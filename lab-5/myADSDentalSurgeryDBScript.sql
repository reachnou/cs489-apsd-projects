create table if not exists dentist
(
    id             int auto_increment
        primary key,
    first_name     varchar(255) null,
    last_name      varchar(255) null,
    contact_phone  varchar(255) null,
    email          varchar(255) null,
    specialization varchar(255) null
);

create table if not exists patient
(
    id           int auto_increment
        primary key,
    first_name   varchar(255) null,
    last_name    varchar(255) null,
    contact      varchar(255) null,
    email        varchar(255) null,
    mail_address varchar(255) null,
    dob          varchar(255) null
);

create table if not exists surgery
(
    id       int auto_increment
        primary key,
    name     varchar(255) null,
    location varchar(255) null
);

create table if not exists appointment
(
    id         int auto_increment
        primary key,
    date       varchar(255) null,
    time       varchar(255) null,
    dentist_id int          not null,
    patient_id int          not null,
    surgery_id int          not null,
    constraint appointment_dentist_id_fk
        foreign key (dentist_id) references dentist (id),
    constraint appointment_patient_id_fk
        foreign key (patient_id) references patient (id),
    constraint appointment_surgery_id_fk
        foreign key (surgery_id) references surgery (id)
);

INSERT INTO dentist (first_name, last_name, contact_phone, email, specialization) VALUES
('Tony', 'Smith', '123-456-7890', 'tony.smith@example.com', 'General Dentistry'),
('Helen', 'Pearson', '234-567-8901', 'helen.pearson@example.com', 'Orthodontics'),
('Robin', 'Plevin', '345-678-9012', 'robin.plevin@example.com', 'Oral Surgery');

INSERT INTO patient (first_name, last_name, contact, email, mail_address, dob) VALUES
('Gillian', 'White', '456-789-0123', 'gillian.white@example.com', '123 Main St', '1990-05-15'),
('Jill', 'Bell', '567-890-1234', 'jill.bell@example.com', '456 Elm St', '1985-08-20'),
('Ian', 'MacKay', '678-901-2345', 'ian.mackay@example.com', '789 Oak St', '1978-03-10'),
('John', 'Walker', '789-012-3456', 'john.walker@example.com', '987 Pine St', '1965-11-25');

INSERT INTO surgery (name, location) VALUES
('Surgery Name 1', '123 Surgery St'),
('Surgery Name 2', '456 Operation Ave'),
('Surgery Name 3', '789 Medical Blvd');

INSERT INTO appointment (date, time, dentist_id, patient_id, surgery_id) VALUES
    ('2013-09-14', '16:30',1, 1, 1),
    ('2013-09-12', '10:00',2, 2, 2),
    ('2013-09-15', '18:00',3, 3, 3);

# SELECT * FROM dentist ORDER BY last_name;
#
# SELECT
#     a.id, a.date, a.time,
#     p.id as p_id, p.first_name as p_fName, p.last_name as p_lName, p.contact, p.email, p.mail_address, p.dob
# FROM appointment a
#     JOIN patient p
#         ON a.patient_id = p.id
# WHERE dentist_id = 1;
#
# SELECT a.id, a.date, a.time, s.name, s.location FROM appointment a JOIN surgery s ON s.id = a.surgery_id WHERE location = '123 Surgery St';
#
#
# SELECT a.id, a.date,
#        p.id as p_id, p.first_name as p_fName, p.last_name as p_lName, p.contact, p.email, p.mail_address, p.dob
#        FROM appointment a JOIN patient p ON p.id = a.patient_id WHERE p.id = 1 AND a.date = '2013-09-14';

