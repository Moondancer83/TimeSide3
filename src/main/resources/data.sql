--
--  Initial data
--
INSERT INTO role (role_id, role, md) VALUES (1, 'ADMIN', 0) ON DUPLICATE KEY UPDATE md=md+1;
INSERT INTO role (role_id, role, md) VALUES (2, 'USER', 0) ON DUPLICATE KEY UPDATE md=md+1;
INSERT INTO user (user_id, active, email, last_name, name, password, md) VALUES  (1, 1, 'admin@kalee.hu', 'Admin', 'Admin', '$2a$10$vK0I5Q3xz1MpRD22PP/otubIZaQZRvgf9cq3d5eEkJm4BPPiLG3DG', 0) ON DUPLICATE KEY UPDATE md = md +1;
INSERT INTO user_role VALUES (1, 1), (1, 2) ON DUPLICATE KEY UPDATE user_id=1;
