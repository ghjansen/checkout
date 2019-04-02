# Checkout System
Welcome to the **Checkout System**!

This is an experimental implementation of a checkout system, as part of a online store. This system was developed using Spring Boot and a synchronized strategy for the emulation of persistence in memory.

Current supported main features are: create a new cart, add items to the cart, remove items from the cart and close the cart placing a new order. All these operations are supported through the RESTful web service.

## How to use
The table below shows the REST API specification, followed by few examples on how to use some of the features.


Path | Method | Action | Return | Parameters
-----|--------|--------|--------|-----------
`/`| `GET` | N/A | Index page (this page) | N/A
`/api/products` | `GET` | N/A | List of products | N/A
`/api/products/{id}` | `GET` | N/A | A product | `id`*
`/api/carts` | `GET` | N/A | List of carts | N/A
`/api/carts` | `POST` | Create a new cart | A cart | N/A
`/api/carts/{id}` | `GET` | N/A | A cart | `id`*
`/api/carts/{id}` | `POST` | Close cart and place order | A cart | `id`*
`/api/cartitems` | `GET` | N/A | List of cart items | N/A
`/api/cartitems` | `POST` | Create new cart item and add it to the informed cart; if `cartId` omitted, create new cart and add the new cart item to it | A cart item | `cartId`, `quantity`, `productId`*
`/api/cartitems/{id}` | `GET` | N/A | A cart item | `id`*
`/api/cartitems/{id}` | `DELETE` | Remove cart item | N/A | `id`*
`/api/orders` | `GET` | N/A | List of orders | N/A
`/api/orders/{id}` | `GET` | N/A | A order | `id`*
`/api/orderitems` | `GET` | N/A | List of order items | N/A
`/api/orderitems/{id}` | `GET` | N/A | A order item | `id`*
`/api/promotions` | `GET` | N/A | List of promotions | N/A
`/api/promotions/{id}` | `GET` | N/A | A promotion | `id`*
\* = required

### Examples
The following examples use `curl` command to perform some of the operations described above.

1. Create a new cart<p>
```
$ curl -X POST http://localhost:8080/api/carts
```
2. Add a item to cart `1` with `3` units of product `2`<p>
```
$ curl -X POST http://localhost:8080/api/cartitems -d "cartId=1" -d "quantity=3" -d "productId=2"
```
3. Create a new cart adding a item to this cart with `2` units of product `1`<p>
```
$ curl -X POST http://localhost:8080/api/cartitems -d "quantity=2" -d "productId=1"
```
4. List all cart items<p>
```
$ curl -X GET http://localhost:8080/api/cartitems
```
5. Remove cart item `2`<p>
```
$ curl -X DELETE http://localhost:8080/api/cartitems/2
```
6. List all carts<p>
```
$ curl -X GET http://localhost:8080/api/carts
```
7. lose cart `1` and place an order for it<p>
```
$ curl -X POST http://localhost:8080/api/carts/1
```
8. List all orders<p>
```
$ curl -X GET http://localhost:8080/api/orders
```
