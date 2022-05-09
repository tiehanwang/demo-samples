create table Employees
(
    employee_id int not null,
    name        int not null,
    salary      int not null
);
select employee_id,if(left(name,1)!='M' && employee_id%2!=0,salary,0) as bonus
from Employees