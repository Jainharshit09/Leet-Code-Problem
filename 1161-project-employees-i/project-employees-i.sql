# Write your MySQL query statement below
select  project_id,
ROUND(AVG(experience_years), 2) AS average_years
from project p join   Employee e ON 
p.employee_id = e.employee_id
GROUP BY project_id