# Write your MySQL query statement below
select e.employee_id 
from Employees e
Left join Salaries s
on e.employee_id=s.employee_id
where s.employee_id is null 
union 
select s.employee_id 
from Salaries s
Left join Employees e
on s.employee_id=e.employee_id
where e.employee_id is null

order by employee_id;