-- Create the database
CREATE DATABASE lab5DB;

-- Create Dentists table
CREATE TABLE Dentists (
    dentist_Id INT PRIMARY KEY,
    first_Name VARCHAR(50),
    last_Name VARCHAR(50),
    contact_Phone VARCHAR(15),
    email VARCHAR(100),
    specialization VARCHAR(100)
);

-- Create Patients table
CREATE TABLE Patients (
    patient_Id INT PRIMARY KEY,
    first_Name VARCHAR(50),
    last_Name VARCHAR(50),
    contact_Phone VARCHAR(15),
    email VARCHAR(100),
    mailing_Address VARCHAR(200),
    date_Of_Birth DATE
);

-- Create SurgeryLocations table
CREATE TABLE SurgeryLocations (
    location_Id INT PRIMARY KEY,
    name VARCHAR(100),
    location_Address VARCHAR(200),
    telephone_Number VARCHAR(15)
);

-- Create Appointments table
CREATE TABLE Appointments (
    appointment_Id INT PRIMARY KEY,
    appointment_Date DATE,
    appointment_Time TIME,
    dentist_Id INT,
    patient_Id INT,
    location_Id INT,
    FOREIGN KEY (dentist_Id) REFERENCES Dentists(dentist_Id),
    FOREIGN KEY (patient_Id) REFERENCES Patients(patient_Id),
    FOREIGN KEY (location_Id) REFERENCES SurgeryLocations(location_Id)
);

-- Insert Dentists data
INSERT INTO Dentists (dentist_Id, first_Name, last_Name, contact_Phone, email, specialization)
VALUES (1, 'John', 'Smith', '123-456-7890', 'john.smith@example.com', 'General Dentistry'),
       (2, 'Jane', 'Doe', '987-654-3210', 'jane.doe@example.com', 'Orthodontics');

-- Insert Patients data
INSERT INTO Patients (patient_Id, first_Name, last_Name, contact_Phone, email, mailing_Address, date_Of_Birth)
VALUES (1, 'Alice', 'Johnson', '555-123-4567', 'alice@example.com', '123 Main St, City', '1985-03-15'),
       (2, 'Bob', 'Smith', '555-987-6543', 'bob@example.com', '456 Elm St, Town', '1990-07-22');

-- Insert SurgeryLocations data
INSERT INTO SurgeryLocations (location_Id, name, location_Address, telephone_Number)
VALUES (1, 'Downtown Clinic', '789 Oak Ave, Downtown', '555-789-1234'),
       (2, 'Suburb Clinic', '123 Maple St, Suburb', '555-321-5678');

-- Insert Appointments data
INSERT INTO Appointments (appointment_Id, appointment_Date, appointment_Time, dentist_Id, patient_Id, location_Id)
VALUES (1, '2023-10-15', '09:30:00', 1, 1, 1),
       (2, '2023-10-16', '14:00:00', 2, 2, 2);
       
-- Query 1: Display all registered dentists in the system, sorted by last name in ascending order
SELECT * FROM Dentists ORDER BY last_Name ASC;

-- Query 2: Display all appointments for a specified dentist (by dentist_Id), including patient information
SELECT Appointments.appointment_Id, Appointments.appointment_Date, Patients.first_Name AS patient_First_Name, Patients.last_Name AS patient_Last_Name
FROM Appointments
JOIN Patients ON Appointments.patient_Id = Patients.patient_Id
WHERE Appointments.dentist_Id = 1;  -- Specify a specific dentist Id

-- Query 3: Display all appointments scheduled at a specific surgery location
SELECT * FROM Appointments
WHERE location_Id = 1;  -- Specify a specific location Id

-- Query 4: Display all appointments booked for a specified patient (by patient_Id) on a specific date
SELECT Appointments.appointment_Id, Appointments.appointment_Date, Dentists.first_Name AS dentist_First_Name, Dentists.last_Name AS dentist_Last_Name
FROM Appointments
JOIN Dentists ON Appointments.dentist_Id = Dentists.dentist_Id
WHERE Appointments.patient_Id = 1  -- Specify a specific patient Id
  AND Appointments.appointment_Date = '2023-10-15';  -- Specify a specific date
