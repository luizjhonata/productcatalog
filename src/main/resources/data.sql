INSERT INTO tb_product (cod, description, price, weight, details) VALUES('C11JGSDN80', 'CURVA 11º BOLSA DN80', 200.02, 6.7, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('C45JGSDN80', 'CURVA 45º BOLSA DN80', 200.02, 6.7, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('C90GSDN80', 'CURVA 90º BOLSA DN80', 200.02, 6.7, 'FOTO DO DETALHAMENTO');

INSERT INTO tb_product (cod, description, price, weight, details) VALUES('C11FFDN100', 'CURVA 11º FLANGE DN100', 321, 9.8, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('C45FFDN100', 'CURVA 45º FLANGE DN100', 350.5, 10.7, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('C90FFDN100', 'CURVA 90º FLANGE DN100', 385.16, 13.5, 'FOTO DO DETALHAMENTO');

INSERT INTO tb_product (cod, description, price, weight, details) VALUES('EBFDN100', 'EXTREMIDADE BOLSA FLANGE DN100', 272.48, 9.35, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('EBFDN150', 'EXTREMIDADE BOLSA FLANGE DN150', 409.59, 14, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('EBFDN200', 'EXTREMIDADE BOLSA FLANGE DN200', 528.84, 18, 'FOTO DO DETALHAMENTO');


INSERT INTO tb_product (cod, description, price, weight, details) VALUES('TEJSGDN200', 'TE BOLSA DN200', 987.41, 33, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('TEFFDN300', 'TE FLANGEADO DN300', 3309.48, 116, 'FOTO DO DETALHAMENTO');
INSERT INTO tb_product (cod, description, price, weight, details) VALUES('TEJGSFDN400X200', 'TE BOLSA FLANGE DN400 X DN200', 2972, 83, 'FOTO DO DETALHAMENTO');

INSERT INTO tb_user (name, username, password) VALUES('CREATOR', 'admin', '$2a$10$HboXOeCKf1aM89rySpfBZeevAkUH2/V4NMjyYOfke6LWCgCyNKBPu');

INSERT INTO tb_user (name, username, password) VALUES('NORMAL USER', 'normaluser', '$2a$10$JAxyU4nssJWVW66NJ9a31uMtEgxZ8uzeQOKr.d1fR12hrxAXYd/I2');

INSERT INTO tb_role (role_name) VALUES('ROLE_ADMIN');

INSERT INTO tb_role (role_name) VALUES('ROLE_USER');

INSERT INTO tb_user_roles (user_id, role_id) VALUES(1, 1);

INSERT INTO tb_user_roles (user_id, role_id) VALUES(2, 2);