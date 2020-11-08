use employees;
create database sdet4_juby;
use sdet4_juby;

CREATE TABLE salesman (
    salesman_id int primary key,
    name varchar(32),
    city varchar(32),
    commission int);
    
    desc salesman;
    
    SELECT * FROM salesman;


INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);

INSERT INTO salesman VALUES
    (5002, 'Nail Knite', 'Paris', 13),
    (5005, 'Pit Alex', 'London', 11), 
    (5006, 'McLyon', 'Paris', 14), 
    (5007, 'Paul Adam', 'Rome', 13),
    (5003, 'Lauson Hen', 'San Jose', 12);
    
  SELECT salesman_id, city FROM salesman;
  
  SELECT * FROM salesman WHERE city='Paris';
  
  SELECT salesman_id, commission FROM salesman WHERE name='Paul Adam';
  
  ALTER TABLE salesman ADD grade int;
  UPDATE salesman SET grade=100;
  SELECT * FROM salesman;
  UPDATE salesman SET grade=200 WHERE city='Rome';
  SELECT * FROM salesman WHERE city='Rome';
  UPDATE salesman SET grade=300 WHERE name='James Hoog';
  UPDATE salesman SET name='Pierre' WHERE name='McLyon';
  SELECT * FROM salesman WHERE salesman_id='5006';
  
  SELECT * FROM salesman;
  
  create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);
    
    insert into customers values 
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002),
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);
    
    insert into orders values
(70001, 150.5, '2012-10-05', 3005, 5002), (70009, 270.65, '2012-09-10', 3001, 5005),
(70002, 65.26, '2012-10-05', 3002, 5001), (70004, 110.5, '2012-08-17', 3009, 5003),
(70007, 948.5, '2012-09-10', 3005, 5002), (70005, 2400.6, '2012-07-27', 3007, 5001),
(70008, 5760, '2012-08-15', 3002, 5001), (70010, 1983.43, '2012-10-10', 3004, 5006),
(70003, 2480.4, '2012-10-10', 3009, 5003), (70012, 250.45, '2012-06-27', 3008, 5002),
(70011, 75.29, '2012-08-17', 3003, 5007), (70013, 3045.6, '2012-04-25', 3002, 5001);

select distinct salesman_id from orders;
select order_no, order_date from orders order by order_date;
select order_no, purchase_amount from orders order by purchase_amount desc; 
select * from orders where purchase_amount < 500 ;  
select * from orders where purchase_amount between 1000 and 2000 ;         

select sum(purchase_amount) as "Sum" from orders;
select avg(purchase_amount) as "Average" from orders;
select max(purchase_amount) as "Maximum" from orders;
select min(purchase_amount) as "Minimum" from orders;
select count(distinct salesman_id) as "Count" from orders;

-- Activity 8

select customer_id, max(purchase_amount) as "Maximum" from orders group by customer_id;
select salesman_id, order_date, max(purchase_amount) as "Maximum" from orders  
where order_date = '2012-08-17'group by salesman_id, order_date;
select customer_id, order_date, max(purchase_amount) as "Maximum" from orders  
group by customer_id, order_date 
having max(purchase_amount) in (2030, 3450, 5760, 6000);

SELECT * FROM customers;
SELECT * FROM orders;
SELECT * FROM salesman;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a 
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name, a.city, a.grade, b.name AS "Salesman", b.city FROM customers a 
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;

select a.customer_name as "Customer Name", b.name as "Salesman", b.commission from customers a
Inner join salesman b on a.salesman_id=b.salesman_id WHERE commission >12;

---- Activity 9

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, 
c.name AS "Salesman", c.commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;  

---- Activity 10

/* select * from orders 
where salesman_id in (select salesman_id from orders where customer_id = 3007); 

select * from orders 
where salesman_id in (select salesman_id from salesman where city = 'New York'); */

 /*select grade, count(*) from customers group by grade
 having grade >(select avg(grade) from customers where city = 'New York'); */
 
select * from orders 
where salesman_id in (select salesman_id from salesman 
where commission= (select max(commission) from salesman)); 



------ Activity 11

SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;

SELECT a.salesman_id, name, order_no, 'highest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.salesman_id, name, order_no, 'lowest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);




