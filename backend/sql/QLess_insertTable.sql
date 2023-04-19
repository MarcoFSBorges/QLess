INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('A43565', 'Afonso', 'Santos', 'afonsosantos@isel.pt', 'ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad');
INSERT INTO employee(is_supervisor) VALUES (TRUE);

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('a46109', 'João', 'Cravo', 'joaocravo@isel.pt', '408f31d86c6bf4a8aff4ea682ad002278f8cb39dc5f37b53d343e63a61f3cc4f');
INSERT INTO employee(is_supervisor) VALUES (TRUE);

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('MarcoFSBorges', 'Marco', 'Borges', 'marcoborges@isel.pt', 'bc10e51485f8524a8f36f9ad5f8cbfbaff125d8558b6203f701850ce156ac054');
INSERT INTO employee(is_supervisor) VALUES (TRUE);

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('randomdude', 'Random', 'Dude', 'randomdude@isel.pt', 'a441b15fe9a3cf56661190a0b93b9dec7d04127288cc87250967cf3b52894d11');
INSERT INTO employee(is_supervisor) VALUES (FALSE);

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('guyrandom', 'Random', 'Guy', 'randomguy@isel.pt', '3987b23e41b2d729523b3e9ab854f13fbe9cae2a69121e448efba1d19b7bf2f2');
INSERT INTO employee(is_supervisor) VALUES (FALSE);


INSERT INTO team(name) VALUES ('Documentação');
INSERT INTO team(name) VALUES ('Inscrições');
INSERT INTO team(name) VALUES ('Tesouraria');
INSERT INTO team(name) VALUES ('SGAAE');
INSERT INTO team(name) VALUES ('IPL');

INSERT INTO category(category_id, name, etc, priority) VALUES ('1', 'Carimbar documento', 5, 'Low');
INSERT INTO category(category_id, name, etc, priority) VALUES ('2', 'Mudança de turma', 20, 'Medium');
INSERT INTO category(category_id, name, etc, priority) VALUES ('2', 'Candidaturas', 25, 'Medium');
INSERT INTO category(category_id, name, etc, priority) VALUES ('3', 'Pagamento de propinas', 10, 'High');
INSERT INTO category(category_id, name, etc, priority) VALUES ('3', 'Pedido de Plano de Pagamento', 30, 'Low');

INSERT INTO ticket(ticket_id, state, category, create_date, update_date, solved_date) VALUES ('4', 'Ongoing', 'Candidaturas', '2022-09-23');
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();


INSERT INTO ticket(ticket_id, state, category, create_date, update_date, solved_date) VALUES ('5', 'Created', 'Carimbar documento', '2022-07-02');
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();

INSERT INTO ticket(ticket_id, state, category, create_date, update_date, solved_date) VALUES ('5', 'Ongoing', 'Mudança de turma', '2022-02-08', '2022-02-13');

INSERT INTO ticket(ticket_id, state, category, create_date, update_date, solved_date) VALUES ('5', 'Solved', 'Pagamento de propinas', '2023-01-14', '2023-01-15','2023-01-15');

INSERT INTO ticket(ticket_id, state, category, create_date, update_date, solved_date) VALUES ('4', 'Solved', 'Pedido de Plano de Pagamento', '2023-01-14', '2023-02-01', '2023-02-01');
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();
INSERT INTO MESSAGE(message_id, created_by, solved_by) VALUES ();

