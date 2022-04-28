# Write your MySQL query statement below

create table World
(
    name       varchar(20) not null,
    continent  varchar(20) not null,
    population int not null,
    area       int not null,
    gdp        int not null
);
select name ,population,area
from World
where area >=3000000 or population >=25000000;
#union
select name ,population,area
from World
where area >=3000000
union
select name ,population,area
from World
where population >=25000000