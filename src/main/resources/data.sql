-- Sample Customers
INSERT INTO Customer (NAME, EMAIL, PHONE) VALUES
('Acme Corp', 'acme@example.com', '+15551234567'),
('Globex Inc', 'contact@globex.com', '+15559876543');

-- Sample Contacts
INSERT INTO Contacts (CUSTOMER_ID, NAME, TITLE) VALUES
(1, 'John Smith', 'Sales Director'),
(1, 'Emily Davis', 'Support Manager');

-- Sample Notes
INSERT INTO Notes (CUSTOMER_ID, CONTENT, AUTHOR) VALUES
 (1, 'Interested in premium plan', 'Admin'),
 (2, 'Requested demo next week', 'Sales');