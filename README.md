# SaturdaySpring
토요일 아침 스프링 스터디 


create SystemInfo database table 2020/04/30
```sql
create table PROCESSHISTORY(
pid bigInt,
cpuUsage float,
memoryUsage float,
virtualSizeUsage float,
residentSetSize float,
name varchar(40),
logtime timestamp
);
``` 