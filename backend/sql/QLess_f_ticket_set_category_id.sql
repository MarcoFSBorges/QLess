-- Create a trigger function to automatically set the category_id on INSERT
CREATE OR REPLACE FUNCTION ticket_set_category_id()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.category_id IS NULL THEN
        NEW.category_id := get_category_id('CREATED');
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
