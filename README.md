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
r: 3 min  
reason: userRepository has been created before, only need to invoke them

* ###/users/{userId}/orders

1. return 201 when POST order  
e: 3 min  
r: 4 min

2. create order with name and find by orderId  
e: 15 min  
r: 24 min  
reason: something wrong with cde. 

3. return 201 when POST order with name  
e: 8 min  
r: 8 min

4. create order with parameters and find by userId and orderId  
e: 25 min  
r: more than 3 hours.   
reason: to be described

5. return 201 when POST order with parameters  
e: 15 min  
r: 20 min 

6. return 500 when POST order fails  
e: 5 min  
r: 3 min

7. return 200 when GET orders  
e: 5 min  
r: 3 min

8. find orders  
e: 15 min  
r: 15 min

9. return a list of order when GET orders  
e: 10 min  
r: 8 min

* ###/users/{userId}/orders/{orderId}

1. return 200 when GET by userId and orderId  
e: 5 min  
r: 5 min

2. return 404 when GET by userId and orderId fails  
e: 5 min  
r: 5 min

3. return order when GET by userId and orderId  
e: 15 min

* ###/users/{userId}/orders/{orderId}/payment

1. return 201 when POST  
e: 10 min  
r:

2. create payment with amount and find by userId and orderId  
e: 20 min  
r:

3. return 201 when POST with amount  
e: 8 min  


4. create payment with parameters and find by userId and orderId  
e: 15 min  
r:  


5. return 201 when POST with parameters  
e: 10 min  
r:

6. return 500 when POST fails  
e: 5 min  
r: 

7. return 200 when GET by userId and orderId  
e: 5 min  
r:  

8. return 404 when GET by userId and orderId fails  
e: 5 min  
r:  

9. return payment when GET by userId and orderId  
e: 10 min  
r:
