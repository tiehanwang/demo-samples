# Write your MySQL query statement below
create table Products
(
    product_id int not null AUTO_INCREMENT,
    low_fats   enum('Y','N') not null,
    recyclable enum('Y','N') not null
);
select product_id
from Products
where low_fats = 'Y' and recyclable = 'Y'