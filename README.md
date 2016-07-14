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
r: 12 min

5. return 201 when POST with parameters  
e: 5 min  
r: 4 min

6. return 500 when POST parameters are not valid
e: 5 min  
r: 3 min

7. return 200 when GET  
r: 5 min  
e: 3 min

8. find products 
e: 15 min  
r: 17 min

9. return a list of products when GET  
e: 5 min  
r: 5 min

* ###/products/{productId}

1. return 200 when GET by productId  
e: 5 min  
r: 6 min

2. return 404 when GET by productId fails  
e: 5 min  
r: 5 min

3. return product when GET by productId  
e: 10 min  
r: 8 min

* ###/users

1. return 201 when POST user  
e: 10 min  
r: 7 min

2. create user with name and find by userId  
e: 20 min  
r: 40 min  
reason: changed default User file name, but IDE auto-changed all "user" to "userExample" 
        (should have been avoided)  

3. return 201 when POST user with name  
e: 10 min  
r: 9 min

4. create user with parameters and find by userId  
e: 12 min  
r: 0 min  
reason: user has only one "name "attribute. 

5. return 201 when POST user with parameters  
e: 5 min  
r: 0 min  
reason: the same as above

6. return 500 when POST user parameters are not valid  
e: 3 min  
r: 2 min

7. return 200 when GET users  
e: 5 min  
r: 4 min

8. find users  
e: 15 min  
r: 11 min

9. return a list of users when GET users 
e: 5 min  
r: 8 min

* ###/users/{userId}

1. return 200 when GET by userId  
e: 4 min  
r: 3 min

2. return 404 when GET by userId fails  
e: 3 min  
r:  4 min

3. return user when GET by userId  
e: 8 min  
r:

* ###/users/{userId}/orders

1. return 201 when POST

2. create order with name and find by userId and orderId

3. return 201 when POST with name

4. create order with parameters and find by userId and orderId

5. return 201 when POST with parameters

6. return 500 when POST fails

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

6. return 500 when POST fails 

7. return 200 when GET by userId and orderId

8. return 404 when GET by userId and orderId fails

9. return payment when GET by userId and orderId
