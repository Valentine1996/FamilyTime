INSERT INTO family (id, name) VALUES
  (1, 'Family1'),
  (2, 'Family2');

INSERT INTO user(id, family_id, first_name, last_name, middle_name, username, password, birthday, gender, locale, isParent, isActive) VALUES
  (1, 1, 'Valentyn','Namisnyk','Yaroslavovuch','valentunnamisnuk@gmail.com','Softjourn1996',DATE '1996-02-26',TRUE,'uk_UA',TRUE,TRUE);
--   (2, 2, 'Oleh','Semankiv','Olehovuch','OlehSemankiv@ukr.net','Softjourn1887',TO_DATE(1987-03-15,'yyyy-MM-dd'),TRUE,'uk_UA',TRUE,TRUE);


INSERT INTO role(id, authority) VALUES
  (1, 'PARENT'),
  (2, 'CHILD');

INSERT INTO user_role(user_id, role_id) VALUES
  (1, 1);

-- INSERT INTO recovery_access(id,user_id,hash,expiredAt) VALUES