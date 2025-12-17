CREATE TABLE ec_user (
                           id BIGSERIAL PRIMARY KEY,
                           username VARCHAR(255) NOT NULL UNIQUE,
                           password VARCHAR(255) NOT NULL,
                           email VARCHAR(255) UNIQUE,
                           state SMALLINT NOT NULL DEFAULT 0, -- 0=待激活, 1=已激活
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT chk_blog_user_state CHECK (state IN (0, 1))
);