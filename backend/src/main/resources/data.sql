-- -- Sample Customers
-- INSERT INTO Customers (NAME, EMAIL, PHONE) VALUES
-- ('Acme Corp', 'acme@example.com', '+15551234567'),
-- ('Globex Inc', 'contact@globex.com', '+15559876543');
--
-- -- Sample Contacts
-- INSERT INTO Contacts (CUSTOMER_ID, NAME, TITLE) VALUES
-- (1, 'John Smith', 'Sales Director'),
-- (1, 'Emily Davis', 'Support Manager');
--
-- -- Sample Notes
-- INSERT INTO Notes (CUSTOMER_ID, CONTENT, AUTHOR) VALUES
--  (1, 'Interested in premium plan', 'Admin'),
--  (2, 'Requested demo next week', 'Sales');

-- Insert dummy data into Customers
INSERT INTO Customers (NAME, EMAIL, PHONE, ADDRESS, COMPANY_NAME, CUSTOMER_TYPE, CREATED_DATE, UPDATED_DATE, IS_ACTIVE)
VALUES
    ('Alice Johnson', 'alice.johnson@example.com', '+90-532-111-2233', '123 Elm Street, Istanbul', 'TechNova Ltd', 'Individual', NOW(), NOW(), TRUE),
    ('Bob Smith', 'bob.smith@example.com', '+90-532-222-3344', '45 Oak Avenue, Ankara', 'Green Solutions Inc', 'Corporate', NOW(), NOW(), TRUE),
    ('Carla Mendes', 'carla.mendes@example.com', '+90-532-333-4455', '78 Maple Road, Izmir', 'Mendes Consulting', 'Individual', NOW(), NOW(), TRUE),
    ('David Brown', 'david.brown@example.com', '+90-532-444-5566', '90 Pine Boulevard, Antalya', 'Brown Enterprises', 'Corporate', NOW(), NOW(), FALSE),
    ('Elif Yilmaz', 'elif.yilmaz@example.com', '+90-532-555-6677', '12 Cedar Lane, Bursa', 'Yilmaz Textiles', 'Corporate', NOW(), NOW(), TRUE);

-- Insert dummy data into Contacts
INSERT INTO Contacts (CUSTOMER_ID, NAME, PHONE, EMAIL, TITLE, POSITION, CONTACT_PREFERENCES, IS_ACTIVE)
VALUES
    (1, 'Mark Taylor', '+90-532-888-9900', 'mark.taylor@example.com', 'Mr.', 'Sales Manager', 'Prefers email, weekdays only', TRUE),
    (1, 'Nina Rossi', '+90-532-777-8899', 'nina.rossi@example.com', 'Ms.', 'Project Lead', 'Prefers phone calls in mornings', TRUE),
    (2, 'Chris Evans', '+90-532-999-0011', 'chris.evans@example.com', 'Mr.', 'CEO', 'Available anytime, prefers WhatsApp', TRUE),
    (3, 'Laura White', '+90-532-112-2234', 'laura.white@example.com', 'Dr.', 'Consultant', 'Prefers in-person meetings', FALSE),
    (4, 'Okan Demir', '+90-532-223-3345', 'okan.demir@example.com', 'Mr.', 'Finance Director', 'Only emails, no calls', TRUE),
    (5, 'Selin Kaya', '+90-532-334-4456', 'selin.kaya@example.com', 'Ms.', 'Marketing Specialist', 'Flexible, prefers calls after 5pm', TRUE);

-- Insert dummy data into Notes
INSERT INTO Notes (CUSTOMER_ID, CONTENT, DATE, AUTHOR, IS_ACTIVE)
VALUES
    (1, 'Customer requested a demo of the product on Monday.', NOW(), 'Alice Johnson', TRUE),
    (1, 'Follow-up call scheduled with Mark Taylor.', NOW(), 'Sales Team', TRUE),
    (2, 'Sent contract draft for review to Chris Evans.', NOW(), 'Bob Smith', TRUE),
    (3, 'Carla asked for pricing details on consulting packages.', NOW(), 'Carla Mendes', TRUE),
    (4, 'David Brown mentioned possible expansion next year.', NOW(), 'David Brown', FALSE),
    (5, 'Elif Yilmaz provided feedback on textile samples.', NOW(), 'Elif Yilmaz', TRUE),
    (5, 'Selin Kaya suggested collaboration on new campaign.', NOW(), 'Marketing Team', TRUE);
