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

update user_info u
set u.user_name = ?,
    u.des = ?,
    u.sex = ?,
    u.birthday = ?,
    u.avatar_color = ?,
    u.phone = ?,
    u.role_id = ?
where u.user_id = ?;


update user_permission
set permission_state = 0
where permission_id >0 and permission_id = ?;

select permission_id id,permission_name label
from user_permission
where permission_id>0 and parent_id = ?;