# 寻找用户推荐人
CREATE TABLE IF NOT EXISTS Customers(
    id INT PRIMARY KEY,
    name VARCHAR(20),
    referee_id INT
);
SHOW TABLES;
# DROP TABLE Customers;
INSERT INTO Customers VALUES (1, 'Will', null);
INSERT INTO Customers VALUES (2, 'Jane', null);
INSERT INTO Customers VALUES (3, 'Alex', 2);
INSERT INTO Customers VALUES (4, 'Bill', null);
INSERT INTO Customers VALUES (5, 'Zack', 1);
INSERT INTO Customers VALUES (6, 'Mark', 2);

SELECT name FROM Customers WHERE referee_id != 2 OR referee_id IS NULL;