# 可回收且低脂的产品
CREATE DATABASE IF NOT EXISTS Test;
USE Test;
CREATE TABLE IF NOT EXISTS Products(
    product_id INT PRIMARY KEY,
    low_fats ENUM('Y', 'N'), # 是否低脂
    recyclable ENUM('Y', 'N') # 是否可回收
);
INSERT INTO Products VALUES (0, 'Y', 'N');
INSERT INTO Products VALUES (1, 'Y', 'Y');
INSERT INTO Products VALUES (2, 'N', 'Y');
INSERT INTO Products VALUES (3, 'Y', 'Y');
INSERT INTO Products VALUES (4, 'N', 'N');

SELECT * FROM Products;
SELECT product_id FROM Products WHERE low_fats = 'Y' AND recyclable = 'Y';

SELECT product_id FROM Products WHERE low_fats = 'Y' OR recyclable = 'Y';
# and 优先级高于 or
SELECT product_id FROM Products WHERE low_fats = 'Y' AND recyclable = 'Y' OR recyclable = 'N';