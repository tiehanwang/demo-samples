create table Activities
(
    sell_date date not null,
    product  varchar(10) not null
);
select sell_date,count(distinct product) as num_sold,group_concat(distinct product order by product separator ',')as products
from Activities
group by sell_date