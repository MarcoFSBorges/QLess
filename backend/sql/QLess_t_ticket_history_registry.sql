-- trigger to automatically keep track of the ticket history
CREATE OR REPLACE TRIGGER ticket_history_registry
	AFTER UPDATE OF treated_by, state_id, category_id
    ON ticket
	FOR EACH ROW
	EXECUTE FUNCTION insert_ticket_history();