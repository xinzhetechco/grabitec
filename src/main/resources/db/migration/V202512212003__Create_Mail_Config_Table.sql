-- 创建邮件配置表
CREATE TABLE sys_mail_config (
                                 id SERIAL PRIMARY KEY,
                                 config_name VARCHAR(50) NOT NULL, -- 配置别名，如 "Google企业邮"
                                 smtp_host VARCHAR(100) NOT NULL,  -- smtp.gmail.com
                                 smtp_port INTEGER NOT NULL,       -- 465 或 587
                                 sender_email VARCHAR(100) NOT NULL, -- 发件人邮箱
                                 sender_password VARCHAR(255) NOT NULL, -- 应用专用密码
                                 is_ssl BOOLEAN DEFAULT TRUE,      -- 是否开启SSL
                                 is_active BOOLEAN DEFAULT FALSE,  -- 是否是当前启用的配置
                                 created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 创建发送记录表，用于审计
CREATE TABLE sys_mail_log (
                              id SERIAL PRIMARY KEY,
                              receiver VARCHAR(100) NOT NULL,
                              subject VARCHAR(200),
                              content TEXT,
                              status VARCHAR(20), -- SUCCESS, FAILED
                              error_message TEXT,
                              send_time TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);