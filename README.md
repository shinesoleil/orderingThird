#Ordering tasking

* ###/products

1. return 201 when POST  
estimate :10 min  
real :8 min

2. create product with name and find by productId  
e: 30 min  
r: 20 min

3. return 201 when POST with name  
e: 10 min  
r: 15 min

4. create product with parameters and find by productId  
e: 15 min  
r: 

5. return 201 when POST with parameters

6. return 400 when POST fails ?????

7. return 200 when GET

8. find products 

9. return a list of products when GET

* ###/products/{productId}

1. return 200 when GET by productId

2. return 404 when GET by productId fails

3. return product when GET by productId

* ###/users

1. return 201 when POST

2. create user with name and find by userId

3. return 201 when POST with name

4. create user with parameters and find by userId

5. return 201 when POST with parameters

6. return 400 when POST fails ?????

7. return 200 when GET

8. find users 

9. return a list of users when GET

* ###/users/{userId}

1. return 200 when GET by userId

2. return 404 when GET by userId fails

3. return user when GET by userId

* ###/users/{userId}/orders

1. return 201 when POST

2. create order with name and find by userId and orderId

3. return 201 when POST with name

4. create order with parameters and find by userId and orderId

5. return 201 when POST with parameters

6. return 400 when POST fails ?????

7. return 200 when GET

8. find orders 

9. return a list of orders when GET

* ###/users/{userId}/orders/{orderId}

1. return 200 when GET by userId and orderId

2. return 404 when GET by userId and orderId fails

3. return order when GET by userId and orderId

* ###/users/{userId}/orders/{orderId}/payment

1. return 201 when POST

2. create payment with amount and find by userId and orderId

3. return 201 when POST with amount

4. create payment with parameters and find by userId and orderId

5. return 201 when POST with parameters

6. return 400 when POST fails ?????

7. return 200 when GET by userId and orderId

8. return 404 when GET by userId and orderId fails

9. return payment when GET by userId and orderId
