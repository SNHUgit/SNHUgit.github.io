-- Generic Seed data for task, contacts and appointment

DELETE FROM public.task;
DELETE FROM public.contact;
DELETE FROM public.appointment;

INSERT INTO public.task ("name", description) VALUES
('Task Name 1', 'Task Description 1'),
('Task Name 2', 'Task Description 2'),
('Task Name 3', 'Task Description 3'),
('Task Name 4', 'Task Description 4'),
('Task Name 5', 'Task Description 5'),
('Task Name 6', 'Task Description 6'),
('Task Name 7', 'Task Description 7'),
('Task Name 8', 'Task Description 8'),
('Task Name 9', 'Task Description 9'),
('Task Name 10', 'Task Description 10');

INSERT INTO public.contact (first_name, last_name, "number", address) VALUES
('FirstName1', 'LastName1', '555-0001', 'Address 1'),
('FirstName2', 'LastName2', '555-0002', 'Address 2'),
('FirstName3', 'LastName3', '555-0003', 'Address 3'),
('FirstName4', 'LastName4', '555-0004', 'Address 4'),
('FirstName5', 'LastName5', '555-0005', 'Address 5'),
('FirstName6', 'LastName6', '555-0006', 'Address 6'),
('FirstName7', 'LastName7', '555-0007', 'Address 7'),
('FirstName8', 'LastName8', '555-0008', 'Address 8'),
('FirstName9', 'LastName9', '555-0009', 'Address 9'),
('FirstName10', 'LastName10', '555-0010', 'Address 10');

INSERT INTO public.appointment (description, appointment_date) VALUES
('Appointment Description 1', DATE '2026-04-06'),
('Appointment Description 2', DATE '2026-04-07'),
('Appointment Description 3', DATE '2026-04-08'),
('Appointment Description 4', DATE '2026-04-09'),
('Appointment Description 5', DATE '2026-04-10'),
('Appointment Description 6', DATE '2026-04-11'),
('Appointment Description 7', DATE '2026-04-12'),
('Appointment Description 8', DATE '2026-04-13'),
('Appointment Description 9', DATE '2026-04-14'),
('Appointment Description 10', DATE '2026-04-15');