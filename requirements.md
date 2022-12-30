### User
* Sign up -                             POST ```http://localhost:8080/users/register```
* Log in -                              [GET](http://localhost:8080/users/{{email}}/{{password}})
* Update email, name and password -     PUT http://localhost:8080/users/{{userId}}
* ***This end point amended: Delete account-    DELETE http://localhost:8080/users/{{userId}}***


### Address
* create an address -                    POST http://localhost:8080/addresses
* update an address -                    PUT http://localhost:8080/addresses/{{addressId}}
* delete an address -                    DELETE http://localhost:8080/addresses/{{addressId}}
* add an address to customer -           POST http://localhost:8080/addresses/{{addressId}}/user/{{userId}}
* get the addresses of a customer -      GET http://localhost:8080/addresses/{{userId}}/get-user-address-list

### Cart
* get user cart -                        GET http://localhost:8080/carts/get-user-cart/{{userId}}

### CartProduct
* addCartProductToCart -                 POST http://localhost:8080/cart-products
* updateCardProductInCart -              PUT http://localhost:8080/cart-products/{{cartProductId}}

### Category
* create a category -                    POST http://localhost:8080/categories
* get a category -                        Not required ATM
* update a category -                     Not required ATM
* delete a category -                     Not required ATM


### Order
* checkout the cart (confirm an order) - POST http://localhost:8080/orders/checkout-cart/{{cartId}}

### OrderProduct
* No end point required

### Product
* create a product -                      POST http://localhost:8080/products
* Get a product -                         Not required ATM
* Update a product -                      Not required ATM
* Delete a product -                      Not required ATM
* Add a product to a Category -           POST http://localhost:8080/products/{{productId}}/category/{{categoryId}}
* Get the products of a category -        GET http://localhost:8080/products/{{categoryId}}/get-category-product-list



