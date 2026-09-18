# Write your MySQL query statement below
select
round(sum(if(player_login ='1',1,0))/count(distinct player_id),2) as fraction
from (
select player_id , 
datediff(event_date,min(event_date) over (partition by player_id)) =1 as player_login
from Activity) as new_table;

# a partition by clause is used to partition rows tables into groups  always used inside the over()clause