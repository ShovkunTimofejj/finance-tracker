-- Создание таблицы bank_account
CREATE TABLE bank_account (
                              id BIGSERIAL PRIMARY KEY,
                              bank_name VARCHAR(255) NOT NULL,
                              account_number VARCHAR(255) NOT NULL,
                              balance DECIMAL(19, 2) NOT NULL
);

-- Создание таблицы income
CREATE TABLE income (
                        id BIGSERIAL PRIMARY KEY,
                        source VARCHAR(255) NOT NULL,
                        amount DECIMAL(19, 2) NOT NULL,
                        date DATE NOT NULL,
                        bank_account_id BIGINT,
                        FOREIGN KEY (bank_account_id) REFERENCES bank_account(id)
);

-- Создание таблицы expense
CREATE TABLE expense (
                         id BIGSERIAL PRIMARY KEY,
                         description VARCHAR(255),
                         amount DECIMAL(19, 2) NOT NULL,
                         date DATE NOT NULL,
                         bank_account_id BIGINT,
                         category VARCHAR(255),
                         FOREIGN KEY (bank_account_id) REFERENCES bank_account(id)
);

-- Создание таблицы category
CREATE TABLE category (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

-- Создание таблицы budget
CREATE TABLE budget (
                        id BIGSERIAL PRIMARY KEY,
                        amount DECIMAL(19, 2) NOT NULL,
                        start_date DATE NOT NULL,
                        end_date DATE NOT NULL
);

-- Создание таблицы report
CREATE TABLE report (
                        id BIGSERIAL PRIMARY KEY,
                        date DATE NOT NULL,
                        details TEXT
);

-- Добавление индексов для улучшения производительности запросов
CREATE INDEX idx_income_bank_account ON income(bank_account_id);
CREATE INDEX idx_expense_bank_account ON expense(bank_account_id);
