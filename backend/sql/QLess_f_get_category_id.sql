-- Create a function to retrieve the category_id based on the category name
CREATE OR REPLACE FUNCTION get_category_id(category_name TEXT)
    RETURNS UUID AS $$
DECLARE
    category_id UUID;
BEGIN
    SELECT category_id INTO category_id
    FROM category
    WHERE name = category_name;
    
    RETURN category_id;
END;
$$ LANGUAGE plpgsql;
