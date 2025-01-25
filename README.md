**Spring Boot REST API for In-Memory Transactions**

This API allows users to:
- Add and remove transactions.
  
Retrieve transaction statistics, including:
- Count: Total number of transactions.
- Sum: Total value of all transactions.
- Average: Average value of the transactions.
- Max: Highest transaction value.
- Min: Lowest transaction value.

It tracks the time the transaction was made. 

By default, the API calculates statistics based on transactions from the last 60 seconds.

However, users have the flexibility to customize this time window.
