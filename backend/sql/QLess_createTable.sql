CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- category priority accepted values
CREATE DOMAIN priority_range AS INTEGER
	CHECK (VALUE >= 0 AND VALUE <= 10);

-- table with all the users, backoffice or clients
CREATE TABLE IF NOT EXISTS qless_user (
	user_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	fname varchar(100) NOT NULL,
	lname varchar(100) NOT NULL,
	email varchar(255) NOT NULL UNIQUE,
	picture bytea,
	password varchar(64) NOT NULL,
	CONSTRAINT valid_email CHECK (email ~* '^[A-Za-z0-9._+%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$')
);

-- table with all the roles
CREATE TABLE IF NOT EXISTS role (
	role_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	name varchar(50) NOT NULL
);

-- table with all the available teams
CREATE TABLE IF NOT EXISTS team (
	team_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	name char(30) UNIQUE NOT NULL
);

-- table with all the available categories
CREATE TABLE IF NOT EXISTS category (
	category_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	name varchar(50) NOT NULL,
	eta int NOT NULL, -- estimate time of completion
	priority priority_range NOT NULL -- priority from 0 to 10, being 0 the highest priority and 10 the lowest
);

-- association table between users and roles
CREATE TABLE IF NOT EXISTS user_role (
	user_id uuid PRIMARY KEY,
	role_id uuid UNIQUE NOT NULL,
	CONSTRAINT fk_userRole_userId FOREIGN KEY(user_id) REFERENCES qless_user(user_id),
	CONSTRAINT fk_userRole_roleId FOREIGN KEY(role_id) REFERENCES role(role_id)
);

-- association table between users and teams
CREATE TABLE IF NOT EXISTS user_team (
	user_id uuid PRIMARY KEY,
	team_id uuid UNIQUE NOT NULL,
	CONSTRAINT fk_userTeam_userId FOREIGN KEY(user_id) REFERENCES qless_user(user_id),
	CONSTRAINT fk_userRole_teamId FOREIGN KEY(team_id) REFERENCES team(team_id)
);

-- association table between categories and teams
CREATE TABLE IF NOT EXISTS category_team (
	category_id uuid PRIMARY KEY,
	team_id uuid UNIQUE NOT NULL,
	CONSTRAINT fk_categoryTeam_categoryId FOREIGN KEY(category_id) REFERENCES category(category_id),
	CONSTRAINT fk_categoryTeam_teamId FOREIGN KEY(team_id) REFERENCES team(team_id)
);

-- table with all the existing states
CREATE TABLE IF NOT EXISTS state (
	state_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name varchar(50) NOT NULL
);

-- table to define state transition rules
CREATE TABLE IF NOT EXISTS state_transition (
	previous_state uuid,
	next_state uuid,
	CONSTRAINT pk_StateTransition PRIMARY KEY (previous_state, next_state),
	CONSTRAINT fk_stateTransition_previousState FOREIGN KEY(previous_state) REFERENCES state(state_id),
	CONSTRAINT fk_stateTransition_nextState FOREIGN KEY(next_state) REFERENCES state(state_id)
);

-- table with all the ticket data
CREATE TABLE IF NOT EXISTS ticket (
	ticket_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	opened_by uuid NOT NULL,
	treated_by uuid,
	category_id uuid NOT NULL,
	state_id uuid,
	create_date timestamp DEFAULT current_timestamp,
	update_date timestamp,
	solved_date timestamp,
	CONSTRAINT fk_ticket_userId FOREIGN KEY(opened_by) REFERENCES qless_user(user_id),
	CONSTRAINT fk_ticket_treatedBy FOREIGN KEY(treated_by) REFERENCES qless_user(user_id),
	CONSTRAINT fk_ticket_categoryId FOREIGN KEY(category_id) REFERENCES category(category_id),
	CONSTRAINT fk_ticket_stateId FOREIGN KEY(state_id) REFERENCES state(state_id)
);

-- table with ticket history
CREATE TABLE IF NOT EXISTS ticket_history (
	ticket_history_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	ticket_id uuid NOT NULL,
	field_name TEXT NOT NULL,
	old_value uuid,
	new_value uuid,
	update_date timestamp DEFAULT current_timestamp,
	CONSTRAINT fk_ticket_history_ticketId FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id)
);

CREATE TABLE IF NOT EXISTS message (
	message_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	ticket_id uuid NOT NULL,
	sent_by_employee boolean NOT NULL,
	content varchar(2000) NOT NULL,
	time_sent timestamp DEFAULT current_timestamp,
	CONSTRAINT fk_message_ticketId FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id)
);

CREATE TABLE IF NOT EXISTS attachment (
	attachment_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	ticket_id uuid NOT NULL,
	name varchar(255),
	create_date timestamp DEFAULT current_timestamp,
	content bytea NOT NULL,
	CONSTRAINT fk_attachment_ticketId FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id)
);

CREATE TABLE IF NOT EXISTS session (
    session_id uuid,
    user_id uuid,
	CONSTRAINT pk_session PRIMARY KEY (session_id, user_id),
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES qless_user(user_id)
);