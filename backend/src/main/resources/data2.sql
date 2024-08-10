-- Добавление записей в таблицу bank_account
INSERT INTO bank_account (bank_name, account_number, balance) VALUES
                                                                  ('Bank of America', '1234567890', 1000.00),
                                                                  ('Chase Bank', '0987654321', 2500.50);

-- Добавление записей в таблицу category
INSERT INTO category (name) VALUES
                                ('Utilities'),
                                ('Groceries'),
                                ('Entertainment'),
                                ('Transportation');

-- Добавление записей в таблицу budget
INSERT INTO budget (amount, start_date, end_date) VALUES
                                                      (500.00, '2024-08-01', '2024-08-31'),
                                                      (200.00, '2024-08-01', '2024-08-31');

-- Добавление записей в таблицу report
INSERT INTO report (date, details) VALUES
                                       ('2024-08-01', 'Monthly financial report for August 2024'),
                                       ('2024-08-15', 'Mid-month financial review');

-- Добавление записей в таблицу income
INSERT INTO income (source, amount, date, bank_account_id) VALUES
                                                               ('Salary', 3000.00, '2024-08-01', 1),
                                                               ('Freelance Work', 500.00, '2024-08-10', 2);

-- Добавление записей в таблицу expense
INSERT INTO expense (description, amount, date, bank_account_id, category) VALUES
                                                                               ('Electric Bill', 100.00, '2024-08-05', 1, 'Utilities'),
                                                                               ('Grocery Store', 50.00, '2024-08-07', 1, 'Groceries'),
                                                                               ('Movie Night', 30.00, '2024-08-12', 2, 'Entertainment'),
                                                                               ('Gas', 60.00, '2024-08-14', 2, 'Transportation');
