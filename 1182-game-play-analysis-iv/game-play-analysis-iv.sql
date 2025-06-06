SELECT 
  ROUND(
    COUNT( player_id) / 
    (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2
  ) AS fraction
FROM (
  SELECT 
    player_id,
    event_date,
    MIN(event_date) OVER (PARTITION BY player_id) AS first_login
  FROM Activity
) AS sub
WHERE DATEDIFF(event_date, first_login) = 1;
