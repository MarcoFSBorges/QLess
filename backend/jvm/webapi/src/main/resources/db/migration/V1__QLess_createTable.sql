CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS qless_user (
	user_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	username varchar(30) NOT NULL,
	fname varchar(100) NOT NULL,
	lname varchar(100) NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(64) NOT NULL,
	CONSTRAINT valid_email CHECK (email ~* '^[A-Za-z0-9._+%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$')
);

CREATE TABLE IF NOT EXISTS role (
	role_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	name varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS team (
	team_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	name char(30) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
	category_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	name varchar(50) NOT NULL,
	eta int NOT NULL,
	priority varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role (
	user_id uuid PRIMARY KEY,
	role_id uuid UNIQUE NOT NULL,
	CONSTRAINT fk_userRole_userId FOREIGN KEY(user_id) REFERENCES qless_user(user_id),
	CONSTRAINT fk_userRole_roleId FOREIGN KEY(role_id) REFERENCES role(role_id)
);

CREATE TABLE IF NOT EXISTS user_team (
	user_id uuid PRIMARY KEY,
	team_id uuid UNIQUE NOT NULL,
	CONSTRAINT fk_userTeam_userId FOREIGN KEY(user_id) REFERENCES qless_user(user_id),
	CONSTRAINT fk_userRole_teamId FOREIGN KEY(team_id) REFERENCES team(team_id)
);

CREATE TABLE IF NOT EXISTS category_team (
	category_id uuid PRIMARY KEY,
	team_id uuid UNIQUE NOT NULL,
	CONSTRAINT fk_categoryTeam_categoryId FOREIGN KEY(category_id) REFERENCES category(category_id),
	CONSTRAINT fk_categoryTeam_teamId FOREIGN KEY(team_id) REFERENCES team(team_id)
);

CREATE TABLE IF NOT EXISTS state (
	state_id uuid PRIMARY KEY DEFAULT uuid_generate_v4()
    name varchar(50) NOT NULL,
);

CREATE TABLE IF NOT EXISTS state_transition (
    ticket_id uuid PRIMARY KEY,
	previous_state int PRIMARY KEY,
	next_state int UNIQUE NOT NULL
    CONSTRAINT fk_ticket_id FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id),
);

CREATE TABLE IF NOT EXISTS ticket (
	ticket_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	opened_by uuid NOT NULL,
	treated_by uuid,
	category_id uuid NOT NULL,
	state_id uuid,
	create_date timestamp NOT NULL,
	update_date timestamp,
	solved_date timestamp,
	CONSTRAINT fk_ticket_userId FOREIGN KEY(opened_by) REFERENCES qless_user(user_id),
	CONSTRAINT fk_ticket_treatedBy FOREIGN KEY(treated_by) REFERENCES qless_user(user_id),
	CONSTRAINT fk_ticket_categoryId FOREIGN KEY(category_id) REFERENCES category(category_id),
	CONSTRAINT fk_ticket_stateId FOREIGN KEY(state_id) REFERENCES state(state_id)
);

CREATE TABLE IF NOT EXISTS message (
	message_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	ticket_id uuid NOT NULL,
	sent_by_employee boolean NOT NULL,
	content varchar(2000) NOT NULL,
	time_sent timestamp NOT NULL,
	CONSTRAINT fk_message_ticketId FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id)
);

CREATE TABLE IF NOT EXISTS attachment (
	attachment_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	ticket_id uuid NOT NULL,
	name varchar(255),
	create_date timestamp NOT NULL,
	content bytea NOT NULL,
	CONSTRAINT fk_attachment_ticketId FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id)
);

CREATE TABLE IF NOT EXISTS session (
    session_id uuid PRIMARY KEY,
    user_id uuid PRIMARY KEY,
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES ticket(user_id)
);
