# Checkout System
Welcome to the **Checkout System**!

This is an experimental implementation of a checkout system, as part of a online store. This system was created using Spring Boot, Spring Data (JPA) with underlying support of Hibernate as ORM framework for persistence in a embedded H2 database.

The current supported features are: create a new cart, add items to the cart, remove items from the cart and close the cart placing a new order. All these operations are supported through the RESTful web service.

## How to use
The table below shows the REST API specification, followed by few examples on how to use some of the features.


Path | Method | Action | Return | Parameters
-----|--------|--------|--------|-----------
`/`| `GET` | N/A | Index page (this page) | N/A
`/api/products` | `GET` | N/A | List of products | N/A
`/api/products/{id}` | `GET` | N/A | A product | `id`\*
`/api/carts` | `GET` | N/A | List of carts | N/A
`/api/carts` | `POST` | Create a new cart | A cart | N/A
`/api/carts/{id}` | `GET` | N/A | A cart | `id`\*
`/api/carts/{id}` | `POST` | Close cart and place order | A cart | `id`\*
`/api/cartitems` | `GET` | N/A | List of cart items | N/A
`/api/cartitems` | `POST` | Create new cart item and add it to the informed cart; if `cartId` omitted, create new cart and add the new cart item to it | A cart item | `cartId`, `quantity`, `productId`\*
`/api/cartitems` | `GET` | N/A | A cart item | `cartId`\* , `productId`\*
`/api/cartitems` | `DELETE` | Remove cart item | N/A | `cartId`\* , `productId`\*
`/api/orders` | `GET` | N/A | List of orders | N/A
`/api/orders/{id}` | `GET` | N/A | A order | `id`\*
`/api/orderitems` | `GET` | N/A | List of order items | N/A
`/api/orderitems` | `GET` | N/A | A order item | `orderId`\* , `productId`\*
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
$ curl -X DELETE "http://localhost:8080/api/cartitems?cartId=2&productId=1"
```
6. List all carts<p>
```
$ curl -X GET http://localhost:8080/api/carts
```
7. Close cart `1` and place an order for it<p>
```
$ curl -X POST http://localhost:8080/api/carts/1
```
8. List all orders<p>
```
$ curl -X GET http://localhost:8080/api/orders
```

## How to build and run

### Running from Spring Boot Maven Plugin
1. Run the following Maven command from the project folder<p>
```
$ mvn spring-boot:run
```

### Running from executable jar file
1. Make sure that the property `packing.type` is with the value `jar` in the `pom.xml` file<p>
```
...
<packing.type>jar</packing.type>
...
```
2. Run the following Maven command from the project folder<p>
```
mvn clean install
```
3. Run the following Java command from the project folder<p>
```
java -jar target/checkout-2.0.0-SNAPSHOT.jar
```

### Running from executable war file
1. Make sure that the property `packing.type` is with the value `war` in the `pom.xml` file<p>
```
...
<packing.type>war</packing.type>
...
```
2. Run the following Maven command from the project folder<p>
```
mvn clean install
```
3. Run the following Java command from the project folder<p>
```
java -jar target/checkout-2.0.0-SNAPSHOT.war
```
