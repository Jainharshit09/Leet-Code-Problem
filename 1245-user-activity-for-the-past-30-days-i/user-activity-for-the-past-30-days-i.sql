# Write your MySQL query statement below
select  activity_date as day,count(distinct (user_id)) as active_users   from Activity where activity_date between date_sub('2019-07-27',interval 29 day) AND '2019-07-27'
GROUP BY 
  activity_date;