# Desafios em Java proprosta por Nélio Alves

## Interfaces #1
A company wants to automate the processing of its contracts. Processing a contract consists of generating the installments to be paid for that contract, based on the desired number of months.
The company uses an online payment service to make the installment payments. Online payment services typically charge monthly interest, as well as a payment fee. For now, the company uses the PayPal service, which applies simple interest of 1% per installment, plus a payment fee of 2%.
Write a program to read the contract data (contract number, contract date, and total contract value). Then, the program should read the number of months for the installment plan and generate the installment records to be paid (date and amount), with the first installment due one month after the contract date, the second installment two months after the contract date, and so on. Display the installment details on the screen.
See the example on the next page:

Enter contract data:
Number: 8028
Date (dd/MM/yyyy): 25/06/2018
Total value of the contract: 600.00
Enter the number of installments: 3

Installments:
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12
