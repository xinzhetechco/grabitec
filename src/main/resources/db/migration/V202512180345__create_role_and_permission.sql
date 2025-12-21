CREATE TABLE ec_role (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) ,
                         description VARCHAR(255) ,
                         role_key VARCHAR(255) NOT NULL UNIQUE ,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE ec_permission (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) ,
                         description VARCHAR(255) ,
                         permission_key VARCHAR(255) NOT NULL UNIQUE ,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ec_user_role (
                              user_id BIGINT NOT NULL,
                              role_id BIGINT NOT NULL,
                              created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                              PRIMARY KEY (user_id, role_id),
                              FOREIGN KEY (user_id) REFERENCES ec_user(id) ON DELETE CASCADE,
                              FOREIGN KEY (role_id) REFERENCES ec_role(id) ON DELETE CASCADE
);

CREATE TABLE ec_role_permission (
                                    role_id BIGINT NOT NULL,
                                    permission_id BIGINT NOT NULL,
                                    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                    PRIMARY KEY (role_id, permission_id),
                                    FOREIGN KEY (role_id) REFERENCES ec_role(id) ON DELETE CASCADE,
                                    FOREIGN KEY (permission_id) REFERENCES ec_permission(id) ON DELETE CASCADE
);