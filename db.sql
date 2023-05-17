create table organization
(
orid int primary key,
organization_name varchar(30),
compid int,
foreign key(compid) references company(cid)
);
create table company
(
cid int primary key,
cname varchar(50),
clocation varchar(50),
candidateid int,
foreign key (candidateid) references candidate(canid)
);
create table candidate
(
canid int primary key,
cname varchar(50),
caddrerss varchar(50),
mobile char
);