# USE amsystemdb;
#
# DELETE FROM amsystemdb.employees WHERE email = 'admin@admin.com';
#
# INSERT INTO amsystemdb.employees
#     (id, last_name, first_name, email, password, phone_number, employee_role, remaining_days)
# VALUES
#     (null, 'admin', 'admin', 'admin@admin.com', '$2y$11$mpya140ccuKgw/8MGifSHuzkUxDlBFUWNdjJ/AFT7Z3XsQwCm7bDC',
#         000000000, 'ADMIN', 0);
