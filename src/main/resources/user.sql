use financial_manage_sys;
insert into user_info
values(
       1,
       "yy",
       "123",
       "yy",
       "",
       "123",
       0,
       "1996-01-01",
       "play",
       "12312312312",
       1,
       "2000-01-01 00:00:00",
       "2000-01-01 00:00:00",
       1
      );

select user_role.*
from user_role
where user_role.role_id = 1;

select u.user_name,u.des,u.sex,u.birthday,u.avatar_color,u.phone,u.last_login
from user_info u
where u.user_id = ?;