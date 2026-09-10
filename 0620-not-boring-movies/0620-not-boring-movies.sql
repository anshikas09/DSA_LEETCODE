# Write your MySQL query statement below
select id, movie, description, round(rating,2) as rating
from Cinema 
where id in (1,3,5,7,9) and description <> "boring"
order by rating desc;