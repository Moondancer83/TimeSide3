--
--  Initial data
--
INSERT IGNORE INTO role VALUES (1, 'ADMIN');
INSERT IGNORE INTO role VALUES (2, 'USER');
INSERT IGNORE INTO user (user_id, active, email, last_name, name, password) VALUES  (1, 1, 'admin@kalee.hu', 'Admin', 'Admin', '$2a$10$vK0I5Q3xz1MpRD22PP/otubIZaQZRvgf9cq3d5eEkJm4BPPiLG3DG');
INSERT IGNORE INTO user_role VALUES (1, 1), (1, 2)
-- INSERT INTO time_session (start, end, open) VALUES (0, 4500000, false);
-- INSERT INTO time_session (start, open) VALUES (1514512800000, true);