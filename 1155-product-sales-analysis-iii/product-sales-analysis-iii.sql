# Write your MySQL query statement below
select distinct product_id ,year as first_year,quantity,price from Sales where(product_id,year) IN(
    select product_id, min(year) as year from Sales  group by product_id
);