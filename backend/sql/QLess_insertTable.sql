INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('A43565', 'Afonso', 'Santos', 'afonsosantos@isel.pt', 'ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad');

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('a46109', 'Joao', 'Cravo', 'joaocravo@isel.pt', '408f31d86c6bf4a8aff4ea682ad002278f8cb39dc5f37b53d343e63a61f3cc4f');

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('MarcoFSBorges', 'Marco', 'Borges', 'marcoborges@isel.pt', 'bc10e51485f8524a8f36f9ad5f8cbfbaff125d8558b6203f701850ce156ac054');

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('randomdude', 'Random', 'Dude', 'randomdude@isel.pt', 'a441b15fe9a3cf56661190a0b93b9dec7d04127288cc87250967cf3b52894d11');

INSERT INTO qless_user(username, fname, lname, email, password) VALUES ('guyrandom', 'Random', 'Guy', 'randomguy@isel.pt', '3987b23e41b2d729523b3e9ab854f13fbe9cae2a69121e448efba1d19b7bf2f2');

INSERT INTO team(name) VALUES ('Documentacao');
INSERT INTO team(name) VALUES ('Inscricoes');
INSERT INTO team(name) VALUES ('Tesouraria');
INSERT INTO team(name) VALUES ('SGAAE');
INSERT INTO team(name) VALUES ('IPL');

INSERT INTO state(name) VALUES
    ('CREATED'),
    ('ONGOING'),
    ('ARCHIVED'),
    ('CANCELED'),
    ('CLOSED');

--------------------------------------------------------------------------------------------------------------------



INSERT INTO category(name, eta, priority) VALUES ('Carimbar documento', 5, 10);

UPDATE TEAM
SET categories = array_append(categories, 'Carimbar documento')
where name = 'Documentacao';

INSERT INTO category(name, eta, priority) VALUES ('Mudanca de turma', 20, 2);

UPDATE TEAM
SET categories = array_append(categories, 'Mudanca de turma')
where name = 'Inscricoes';

INSERT INTO category(name, eta, priority) VALUES ('Candidaturas', 25, 1);

UPDATE TEAM
SET categories = array_append(categories, 'Candidaturas')
where name = 'Inscricoes';

INSERT INTO category(name, eta, priority) VALUES ('Pagamento de propinas', 10, 5);

UPDATE TEAM
SET categories = array_append(categories, 'Pagamento de propinas')
where name = 'Tesouraria';

INSERT INTO category(name, eta, priority) VALUES ('Pedido de Plano de Pagamento', 30, 0);

UPDATE TEAM
SET categories = array_append(categories, 'Pedido de Plano de Pagamento')
where name = 'Tesouraria';

--------------------------------------------------------------------------------------------------------------------

INSERT INTO ticket(user_id, employee_id, category_id, state, create_date, update_date, solved_date) VALUES (4, null, 2, 'Created', '2022-09-23', null, null);
INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (4, null, 1, '2022-01-08 04:05:06', 'Hello World');
-- Inicialmente o Ticket state � 'Created' e update_date s� � atualizado depois da 1� mensagem de um employee assim como o estado que passar� para Ongoing
-- Na tabela Ticket e na 1� mensagem criada do mesmo, employee_id � null pois ainda n�o est� atribu�do a ningu�m, ser� atualizado depois da 1� mensagem de um qualquer employee com o seu respetivo id

INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (4, 1, 1, '2022-01-09 10:23:54', 'ISEL Message');
UPDATE TICKET 
SET update_date = '2022-01-09 10:23:54', state = 'Ongoing', employee_id = 1
where ticket_id = 1;


INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (4, 1, 1, '2022-01-11 23:31:54', 'New text');
UPDATE TICKET 
SET update_date = '2022-01-11 23:31:54'
where ticket_id = 1;


INSERT INTO ticket(user_id, employee_id, category_id, state, create_date, update_date, solved_date) VALUES (5, null, 2,  'Created', '2023-02-17 14:15:16', null, null);
INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (5, null, 2, '2023-02-17 14:15:16', 'Ajuda pra mudar de turma');


INSERT INTO ticket(user_id, employee_id, category_id, state, create_date, update_date, solved_date) VALUES (4, null, 4, 'Created', '2022-02-07', null, null);
INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (4, null, 3, '2022-01-09 10:23:54', 'Pagar propinas atrasadas');

INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (4, 5, 3, '2022-01-10 22:01:57', 'Aguardamos rececao das mesmas.');
UPDATE TICKET 
SET update_date = '2022-01-10 22:01:57', state = 'Ongoing', employee_id = 5
where ticket_id = 3;



INSERT INTO ticket(user_id, employee_id, category_id, state, create_date, update_date, solved_date) VALUES (2, null, 3, 'Created', '2023-09-10 09:27:16', null, null);
INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (2, null, 4, '2023-09-10 09:27:16', 'Solicito informacoes acerca de XYZ assuntos');


INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (2, 2, 4, '2023-09-11 09:27:16', 'Qual o seu nr de aluno');
UPDATE TICKET 
SET update_date = '2023-09-11 09:27:16', state = 'Ongoing', employee_id = 2
where ticket_id = 4;


INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (2, 2, 4, '2023-09-11 11:27:16', '123');
UPDATE TICKET 
SET update_date = '2023-09-11 11:27:16';


INSERT INTO MESSAGE(user_id, employee_id, ticket_id, sent_time, body) VALUES (2, 2, 4, '2023-09-11 15:13:29', 'Necessita de se deslocar presencialmente aos servicos academicos, obrigado');
UPDATE TICKET 
SET update_date = '2023-09-11 15:13:29', state = 'Solved', solved_date = '2023-09-11 15:13:29'
where ticket_id = 4;
