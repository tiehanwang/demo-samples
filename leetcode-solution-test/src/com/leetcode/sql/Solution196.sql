create table Person
(
    id int not null,
    email varchar(10),
    primary key (id)
);
#如果表名用了别名，要将别名放在delete和from之间
delete p1 from Person p1,Person p2 where p1.email = p2.email and p1.id > p2.id;
delete from Person where id not in(
    select *
    from(
        select min(id)
        from Person
        group by email
    ) as t
)