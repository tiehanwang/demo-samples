create table Patients
(
    conditions int not null
);
select * from Patients
where conditions like 'DIAB1%' or conditions like '% DIAB1%';

#\b匹配一个单词边界，也就是指单词和空格间的位置。例如， 'er\b' 可以匹配"never" 中的 'er'，但不能匹配 "verb" 中的 'er'。
#*匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
#.匹配除换行符（\n、\r）之外的任何单个字符。要匹配包括 '\n' 在内的任何字符，请使用像"(.|\n)"的模式。
select * from Patients
where conditions regexp '\\bDIAB1.*'
