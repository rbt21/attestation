CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE resources (
                           id SERIAL PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           description TEXT,
                           type VARCHAR(50),
                           url VARCHAR(255),
                           category_id INTEGER,
                           deleted BOOLEAN DEFAULT FALSE,
                           FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE SET NULL
);

CREATE TABLE favorites (
                           id SERIAL PRIMARY KEY,
                           user_id INTEGER NOT NULL,
                           resource_id INTEGER NOT NULL,
                           deleted BOOLEAN DEFAULT FALSE,
                           FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
                           FOREIGN KEY (resource_id) REFERENCES resources (id) ON DELETE CASCADE,
                           UNIQUE (user_id, resource_id)
);
