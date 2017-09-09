# JOINS
Join is applied on to combine results of both the tables.

### Inner join 
INNER JOIN: Returns records that have matching values in both tables
- It will result the machining records in the both the tables

```
SELECT column_name(s)
FROM table1
INNER JOIN table2 ON table1.column_name = table2.column_name;
```

> OUTER join will always contain result of Inner join and also other records from the table.

## OUTER JOIN 
It is further divided into.

### Left OUTER Join 
LEFT (OUTER) JOIN: Return all records from the left table, and the matched records from the right table
- It will return all the records from left table and match the records from the right table if not found return null.


```
SELECT column_name(s)
FROM table1
LEFT JOIN table2 ON table1.column_name = table2.column_name;
```

### Right OUTER Join 
RIGHT (OUTER) JOIN: Return all records from the right table, and the matched records from the left table
- It will return all the records from right table and match the records from the left table if not found return null.

```
SELECT column_name(s)
FROM table1
RIGHT JOIN table2 ON table1.column_name = table2.column_name;
```
> So, 
> A LEFT JOIN B <-> B RIGHT JOIN A

### Full OUTER Join
FULL (OUTER) JOIN: Return all records when there is a match in either left or right table
- It combines the result of the Left OUTER Join and Right OUTER Join. It will return NULL values as there is no match.


```
SELECT column_name(s)
FROM table1
FULL OUTER JOIN table2 ON table1.column_name = table2.column_name;
```

### Self Join
- Self-joins are used to compare values in a column with other values in the same column in the same table.

```
SELECT column_name(s)
FROM table1 T1, table1 T2
WHERE condition;
```