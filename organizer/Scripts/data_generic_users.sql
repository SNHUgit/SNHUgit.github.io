-- Generic users add

DELETE FROM public.users;

INSERT INTO public.users (username, password, enabled) VALUES
('manager', '{bcrypt}$2a$10$XPiFHcAAl2cqXZtT3wHlC.QB8T6aZ6smO160/p8omMp9IoMRLKIb2', true),
('task_user', '{bcrypt}$2a$10$sFacgE7XjLSAcZqlqbupouPkVFHmlBkua0EUhzLVZo.piKBHb0nPW', true),
('contact_user', '{bcrypt}$2a$10$pSBfvxfux94ou.CZPelNS.2cMg6wygQNnBPtYhe8HaKjavK9QCmYW', true),
('appointment_user', '{bcrypt}$2a$10$3Me09mZIgNvDgbrZ2ZdKJe8I/bpeaDCL6E72S8Ttw30noN.up90xm', true);

DELETE FROM public.authorities;

INSERT INTO public.authorities (username, authority) VALUES
('manager', 'ROLE_MANAGER'),
('manager', 'ROLE_TASK'),
('manager', 'ROLE_CONTACT'),
('manager', 'ROLE_APPOINTMENT'),
('task_user', 'ROLE_TASK'),
('contact_user', 'ROLE_CONTACT'),
('appointment_user', 'ROLE_APPOINTMENT');