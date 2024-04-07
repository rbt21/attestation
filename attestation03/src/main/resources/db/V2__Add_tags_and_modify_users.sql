-- Добавление новой таблицы tags
CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      description TEXT,
                      UNIQUE(name)
);

-- Добавление столбца last_login в таблицу users
ALTER TABLE users
    ADD COLUMN last_login TIMESTAMP;

-- Создание таблицы связей между тегами и ресурсами
CREATE TABLE resource_tags (
                               resource_id INTEGER NOT NULL,
                               tag_id INTEGER NOT NULL,
                               FOREIGN KEY (resource_id) REFERENCES resources (id) ON DELETE CASCADE,
                               FOREIGN KEY (tag_id) REFERENCES tags (id) ON DELETE CASCADE,
                               PRIMARY KEY (resource_id, tag_id)
);
