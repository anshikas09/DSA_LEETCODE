# Write your MySQL query statement below
select e1.name
from Employee e1
join employee e2
on e1.id = e2.managerID
group by e2.managerId 
having count(*) >= 5;