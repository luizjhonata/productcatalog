INSERT INTO tb_product (cod, description, price, weight) VALUES('C11JGSDN80', 'CURVA 11º BOLSA DN80', 200.02, 6.7);
INSERT INTO tb_product (cod, description, price, weight) VALUES('C45JGSDN80', 'CURVA 45º BOLSA DN80', 200.02, 6.7);
INSERT INTO tb_product (cod, description, price, weight) VALUES('C90GSDN80', 'CURVA 90º BOLSA DN80', 200.02, 6.7);

INSERT INTO tb_product (cod, description, price, weight) VALUES('C11FFDN100', 'CURVA 11º FLANGE DN100', 321, 9.8);
INSERT INTO tb_product (cod, description, price, weight) VALUES('C45FFDN100', 'CURVA 45º FLANGE DN100', 350.5, 10.7);
INSERT INTO tb_product (cod, description, price, weight) VALUES('C90FFDN100', 'CURVA 90º FLANGE DN100', 385.16, 13.5);

INSERT INTO tb_product (cod, description, price, weight) VALUES('EBFDN100', 'EXTREMIDADE BOLSA FLANGE DN100', 272.48, 9.35);
INSERT INTO tb_product (cod, description, price, weight) VALUES('EBFDN150', 'EXTREMIDADE BOLSA FLANGE DN150', 409.59, 14);
INSERT INTO tb_product (cod, description, price, weight) VALUES('EBFDN200', 'EXTREMIDADE BOLSA FLANGE DN200', 528.84, 18);


INSERT INTO tb_product (cod, description, price, weight) VALUES('TEJSGDN200', 'TE BOLSA DN200', 987.41, 33);
INSERT INTO tb_product (cod, description, price, weight) VALUES('TEFFDN300', 'TE FLANGEADO DN300', 3309.48, 116);
INSERT INTO tb_product (cod, description, price, weight) VALUES('TEJGSFDN400X200', 'TE BOLSA FLANGE DN400 X DN200', 2972, 83);

INSERT INTO tb_user (name, username, password) VALUES('CREATOR', 'admin', '$2a$10$e.rSdqIgDDcvsGo4tR.sJ.RxqHvnPw0rVIjsOutuVLNWDjLtGImm6');

INSERT INTO tb_user (name, username, password) VALUES('NORMAL USER', 'normaluser', '$2a$10$C38ITkzDINosJPYljGXJpOtsRx6kzSTbZ0A/o/q1uAND5DOQC2YVq');

INSERT INTO tb_role (role_name) VALUES('ROLE_ADMIN');

INSERT INTO tb_role (role_name) VALUES('ROLE_USER');

INSERT INTO tb_user_roles (user_id, role_id) VALUES(1, 1);

INSERT INTO tb_user_roles (user_id, role_id) VALUES(2, 2);