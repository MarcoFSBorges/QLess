-- Create the trigger function to capture updates
CREATE OR REPLACE FUNCTION insert_ticket_history()
    RETURNS TRIGGER AS $$
BEGIN
    IF OLD.treated_by <> NEW.treated_by THEN
        INSERT INTO ticket_history (ticket_id, field_name, old_value, new_value)
        VALUES (NEW.ticket_id, 'treated_by', OLD.treated_by, NEW.treated_by);
    END IF;

    IF OLD.state_id <> NEW.state_id THEN
        INSERT INTO ticket_history (ticket_id, field_name, old_value, new_value)
        VALUES (NEW.ticket_id, 'state_id', OLD.state_id, NEW.state_id);
    END IF;

    IF OLD.category_id <> NEW.category_id THEN
        INSERT INTO ticket_history (ticket_id, field_name, old_value, new_value)
        VALUES (NEW.ticket_id, 'category_id', OLD.category_id, NEW.category_id);
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
