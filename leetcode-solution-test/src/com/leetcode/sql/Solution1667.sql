create table Users
(
    user_id int not null,
    name    varchar(10) not null
);
select user_id,concat(upper(left(name,1)),lower(substr(name,2))) as name
from Users
order by user_id;
# SQL CONCAT() 函数
# https://www.w3cschool.cn/sql/sz8w1ozt.html
# SQL 字母大小写转换函数UPPER(s)、UCASE(s)、LOWER(s)和LCASE(s)
# https://www.w3cschool.cn/sql/sql-upperlower.html