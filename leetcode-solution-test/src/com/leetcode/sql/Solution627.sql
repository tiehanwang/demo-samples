#仅使用 单个 update 语句 ，且不产生中间临时表。
#你必须仅使用一条 update 语句，且 不能 使用 select 语句。
create table Salary
(
    sex enum('f','m') not null
);
update Salary set sex = if(sex = 'm','f','m');
update Salary set sex = char(ascii('m') + ascii('f') - ascii(sex));
update Salary set sex = (
    case sex when 'm' then 'f' else 'm'end
    );