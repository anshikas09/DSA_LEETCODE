# Write your MySQL query statement below
select d.name as Department , e.name as Employee , e.salary As Salary
from Employee e
join Department d
on e.departmentId = d.id 
where ( Select count(distinct salary) from employee as e2
where e2.departmentId = d.id and e2.salary >= e.salary) <=3;