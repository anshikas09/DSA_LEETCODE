SELECT
    user_id,
    IFNULL(MAX(time_stamp), '2020-12-31 23:59:59') AS last_stamp
FROM Logins
WHERE YEAR(time_stamp) = 2020
GROUP BY user_id;