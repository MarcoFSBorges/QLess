-- Create a trigger to execute the ticket_set_category_id function on INSERT
CREATE TRIGGER ticket_insert_trigger
    BEFORE INSERT ON ticket
    FOR EACH ROW
    EXECUTE FUNCTION ticket_set_category_id();
