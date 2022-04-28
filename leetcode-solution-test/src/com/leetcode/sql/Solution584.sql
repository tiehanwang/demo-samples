# Write your MySQL query statement below
#
create table customer
(
    id         int not null auto_increment,
    name       int not null,
    referee_id int not null,
    primary key (`id`)
)
select name from customer where referee_id is null or referee_id !=2;