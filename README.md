# Java Challenges and Lectures

## Interfaces #1
A company wants to automate the processing of its contracts. Processing a contract consists of generating the installments to be paid for that contract, based on the desired number of months.
The company uses an online payment service to make the installment payments. Online payment services typically charge monthly interest, as well as a payment fee. For now, the company uses the PayPal service, which applies simple interest of 1% per installment, plus a payment fee of 2%.
Write a program to read the contract data (contract number, contract date, and total contract value). Then, the program should read the number of months for the installment plan and generate the installment records to be paid (date and amount), with the first installment due one month after the contract date, the second installment two months after the contract date, and so on. Display the installment details on the screen.
See the example on the next page:

Enter contract data: <br>
Number: 8028 <br>
Date (dd/MM/yyyy): 25/06/2018 <br>
Total value of the contract: 600.00 <br>
Enter the number of installments: 3 <br>
 <br>
Installments: <br>
25/07/2018 - 206.04 <br>
25/08/2018 - 208.08 <br>
25/09/2018 - 210.12 <br>

## Interfaces #2

Challenge: Schedule Delivery System <br>
<br>
A logistics company wants to automate the scheduling of deliveries for customer orders. Each order can have multiple scheduled deliveries over a number of weeks, and the company can contract different delivery services to perform these deliveries.
Each delivery service may have its own strategy for calculating delivery costs, and the company wants this calculation to be flexible and extensible, using interfaces to represent different services.
You must develop a program that: 

Reads the order data:

Order code

Order date

Total order amount

Reads the number of scheduled deliveries (e.g., 4 weekly deliveries).

Calculates the dates and values of each delivery, splitting the total order amount equally among the deliveries.

For each delivery, apply the delivery cost calculation according to the delivery service used.

For now, the only available delivery service is "FastDelivery", which applies:

A fixed fee of $5.00 per delivery

An additional 1.5% of the delivery's base amount

The program must print the date and total amount (including delivery cost) for each scheduled delivery.

Hint: Use an interface DeliveryService with a method double calculateFee(double baseAmount) and implement it with the FastDelivery class.

Order code: 1134 <br>
Order date (dd/MM/yyyy): 10/03/2023 <br>
Total order amount: 400.00 <br>
Number of deliveries: 4 <br>
 <br>
Deliveries: <br>
17/03/2023 - 106.50 <br>  
24/03/2023 - 106.50  <br> 
31/03/2023 - 106.50 <br>  
07/04/2023 - 106.50 <br>
(Each delivery: 100.00 base + 5.00 + 1.5% of 100.00 = 106.50)