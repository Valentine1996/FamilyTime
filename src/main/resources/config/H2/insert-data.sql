INSERT INTO family (id, name) VALUES
  (1, 'Family1'),
  (2, 'Family2');

INSERT INTO user(id, family_id, first_name, last_name, middle_name, username, email, password, age, gender, isParent, isActive) VALUES
  (1, 1, 'Valentyn','Namisnyk','Yaroslavovuch','Valentine1996','valentunnamisnuk@ukr.net','Softjourn1996',20,TRUE,TRUE,TRUE),
  (2, 2, 'Oleh','Semankiv','Olehovuch','LasVegas','OlehSemankiv@ukr.net','Softjourn1887',29,TRUE,TRUE,TRUE);

INSERT INTO role(id, authority) VALUES
  (1, 'ROLE_PARENT'),
  (2, 'ROLE_CHILD');

INSERT INTO user_role(user_id, role_id) VALUES
  (1, 1);