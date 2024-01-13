INSERT INTO Report_Type_Entity (Name, Description, Creation_date) VALUES
('Contabilidad de impuestos federales', 'Descripción de Contabilidad de impuestos federales', now()),
('Presentacion de impuestos estatales', 'Descripción de Presentacion de impuestos estatales', now()),
('Proceso de nomina', 'Descripción de Proceso de nomina', now()),
('Actualizaciones del IMSS', 'Descripción de Actualizaciones del IMSS', now()),
('Actos administrativos SAT', 'Descripción de Actos administrativos SAT', now());

INSERT INTO client_entity (id, name, email, admin_full_name, admin_phone, admin_email, headquarter_state)
VALUES
('1', 'John Doe', 'john.doe@example.com', 'Jane Doe', '555-0101', 'jane.doe@example.com', 'California'),
('2', 'Alice Johnson', 'alice.johnson@example.com', 'Bob Johnson', '555-0202', 'bob.johnson@example.com', 'Texas'),
('3', 'Michael Smith', 'michael.smith@example.com', 'Sarah Smith', '555-0303', 'sarah.smith@example.com', 'New York');

INSERT INTO User_Entity (id, name, last_Name, email) VALUES
(1,'Kathian', 'Hernandez', 'khernandez@mmasesoria.com'),
(2,'Victor', 'Hernandez', 'vhernandez@mmasesoria.com'),
(3,'Eduardo', 'Martinez', 'emartinez@mmasesoria.com');

