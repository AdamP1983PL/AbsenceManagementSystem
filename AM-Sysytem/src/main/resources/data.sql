USE amsystemdb;

DELETE FROM amsystemdb.employees WHERE email = 'admin@admin.pl';

INSERT INTO amsystemdb.employees VALUES (null, 0, 'admin@admin.pl', 'ADMIN', 'admin', 'admin',
                                         '$2y$11$mpya140ccuKgw/8MGifSHuzkUxDlBFUWNdjJ/AFT7Z3XsQwCm7bDC','123123123');

# admin password: admin, bcrypt: $2y$11$mpya140ccuKgw/8MGifSHuzkUxDlBFUWNdjJ/AFT7Z3XsQwCm7bDC

SELECT * FROM amsystemdb.employees;
