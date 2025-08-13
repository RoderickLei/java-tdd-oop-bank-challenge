```
As a customer,
So I can safely store and use my money,
I want to create a current account.
``` 

| Classes | Member var.    | Methods      | Scenario     | Output  |
| ------- | -------------- | ------------ | ------------ | ------- |
| Account | String accName | getBalance() | balance == 0 | 0       |
|         | float balance  |              | balance >0   | balance |
| CurrAcc | String accName |              |              |         |
|         | float balance  |              |              |         |


```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```

| Classes | Member var.    | Methods      | Scenario     | Output  |
| ------- | -------------- | ------------ | ------------ | ------- |
| Account | String accName | getBalance() | balance == 0 | 0       |
|         | int Balance    |              | balance >0   | balance |
| SavAcc  | String accName |              |              |         |
|         | int Balance    |              |              |         |
```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```
| Classes       | Member var.                      | Methods                | Scenario                      | Output                                        |
| ------------- | -------------------------------- | ---------------------- | ----------------------------- | --------------------------------------------- |
| BankStatement | List<`Transaction`> Transactions | generate()             | transactions is empty         | header of bankstatements                      |
|               |                                  |                        | transactions got transactions | return string of transactions in right format |
| Transaction   | localDate currDate               |                        |                               |                                               |
|               | float credit                     |                        |                               |                                               |
|               | float debit                      |                        |                               |                                               |
|               | float balance                    |                        |                               |                                               |
| Account       | BankStatement bankStatement      | getBankStatementOutput |                               |                                               |

```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

| Classes | Member var.    | Methods              | Scenario                      | Output |
| ------- | -------------- | -------------------- | ----------------------------- | ------ |
| Account | String accName | deposit(int Amount)  | amount =< 0                   | False  |
|         | float balance  |                      | amount > 0                    | True   |
|         |                | withdraw(int Amount) | amount =< 0                   | False  |
|         |                |                      | amount > 0 && amount<balance  | True   |
|         |                |                      | amount > 0 && amount >balance | False  |

