-- Добавление столбца 'created_at' в таблицу 'categories' для отслеживания времени создания
ALTER TABLE categories
    ADD COLUMN created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP;

-- Создание новой таблицы 'user_actions' для логирования действий пользователей
CREATE TABLE user_actions (
                              id SERIAL PRIMARY KEY,
                              user_id INTEGER NOT NULL,
                              action_type VARCHAR(255) NOT NULL,
                              description TEXT,
                              action_timestamp TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Создание индекса для столбца 'username' в таблице 'users' для улучшения производительности запросов
CREATE INDEX idx_users_username ON users (username);
