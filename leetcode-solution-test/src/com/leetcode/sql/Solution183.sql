# Write your MySQL query statement below
# 左连接
select Name as Customers
from Customers as c left join Orders as o on c.Id = o.CustomerId
where o.Id is null;
# not in
select Name as Customers
from Customers
where Customers.Id not in(
    select distinct CustomerId from Orders
)
#not exists
select Name as Customers
from Customers as c
where not exists (
        select 1 from Orders as o where o.CustomerId = c.Id
    )
