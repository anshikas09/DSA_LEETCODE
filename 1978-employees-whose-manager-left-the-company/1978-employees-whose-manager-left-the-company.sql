# Write your MySQL query statement below
select e1.employee_id 
from Employees e1
left join Employees e2
on e2.employee_id = e1.manager_id 
WHERE e1.salary < 30000 and e2.employee_id IS NULL
  AND e1.manager_id IS NOT NULL
ORDER BY e1.employee_id;