# MakeChangeProject

## How To Run
This is a Java project, so you could compile and run from the command line with `javac CashRegister.java` and `java CashRegister`. Or you could open it inside your preferred IDE and run it. Once you run the project, it will prompt you for a price and how much cash you are providing to purchase the item. Enter those 2 values.

## Project Description
This is a semi-robust transactional cash register program. It takes in 2 values, a price and cash tendered. With those 2 values, it calculates how much change to give the customer using a simple greedy algorithm. It will give back change in the largest possible denominations up to $20 bills.

## Technologies Used
I decided to use BigDecimal in this program because it does not lose precision like double and float do when doing arithmetic. Other than that, the program consists of a couple of methods, one that returns a BigDecimal and the other that is void, simple logic, such as `if`, `else if`, and `else`, various variable declarations, print statements, and a scanner.