DELETE
FROM students;

DELETE
FROM teachers;

INSERT INTO teachers (teacherid, name, address, city, state, telephone)
    VALUES (1, 'Dan L', '123 Main Street', 'City', 'ST', '555-555-1234'),
           (2, 'Dan S', '321 Uptown Drive', 'Town', 'ST', '555-555-5555'),
           (3, 'Dustin M', '565 Side Avenue', 'Village', 'ST', '555-123-1555');

INSERT INTO students (studentid, name, grade, teacherid)
    VALUES (4, 'Doc', 99.95, 1),
           (5, 'Chad', 89.50, 1),
           (6, 'Jason', 77.77, 1),
           (7, 'Jose', 85.49, 1),
           (8, 'Luis', 89.50, 1),
           (9, 'Carlos', 99.49, 2),
           (10, 'Justin', 78.75, 2),
           (11, 'Kim', 89.89, 3);

alter sequence hibernate_sequence restart with 15;