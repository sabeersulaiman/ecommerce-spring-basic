# Orders (basePath: v1/orders)

Contains CRUD endpoints for orders in the e-commerce system.

## Items model

```json
{
  "dateAdded": "2019-07-18T19:33:09.376+0000",
  "dateModified": "2019-07-18T19:33:09.376+0000",
  "deleted": false,
  "orderId": 1,
  "quantity": 2,
  "orderDate": "2019-07-18T19:33:09.365+0000",
  "customerName": "Sabeer Sulaiman",
  "customerAddress": "PV House, Vkd",
  "orderItem": {
    "dateAdded": "2019-07-18T19:31:22.000+0000",
    "dateModified": "2019-07-18T19:33:09.379+0000",
    "deleted": false,
    "itemId": 2,
    "title": "Google Pixel 2",
    "description": "Google device.",
    "tags": "Google,Pixel,2",
    "stock": 98,
    "cost": 800
  },
  "status": "NEW",
  "totalCost": 1600
}
```

## A. POST /

Creates a new order against a single item. Quantity of the item should be set to a value greater than 0.

### Body

```json
{
  "quantity": 2,
  "customerName": "Sabeer Sulaiman",
  "customerAddress": "PV House, Vkd",
  "orderItem": {
    "dateAdded": "2019-07-18T19:18:45.000+0000",
    "dateModified": "2019-07-18T19:18:45.000+0000",
    "deleted": false,
    "itemId": 2,
    "title": "Google Pixel 2 XL",
    "description": "Google device.",
    "tags": "Google,Pixel,2,XL",
    "stock": 100
  }
}
```

### Constraints

- `quantity` should be greater than 0.
- `customerName` cannot be null.

### Example response

```json
{
  "dateAdded": "2019-07-18T19:33:09.376+0000",
  "dateModified": "2019-07-18T19:33:09.376+0000",
  "deleted": false,
  "orderId": 1,
  "quantity": 2,
  "orderDate": "2019-07-18T19:33:09.365+0000",
  "customerName": "Sabeer Sulaiman",
  "customerAddress": "PV House, Vkd",
  "orderItem": {
    "dateAdded": "2019-07-18T19:31:22.000+0000",
    "dateModified": "2019-07-18T19:33:09.379+0000",
    "deleted": false,
    "itemId": 2,
    "title": "Google Pixel 2",
    "description": "Google device.",
    "tags": "Google,Pixel,2",
    "stock": 98,
    "cost": 800
  },
  "status": "NEW",
  "totalCost": 1600
}
```

## B. GET /

List all the orders with pagination.

### Parameters

| Name  |           Type            |                              Description |
| ----- | :-----------------------: | ---------------------------------------: |
| page  |     unsigned integer      |  The page to be retrieved, starts with 0 |
| count | integer - bounded [1,100] | number of items to be retrieved per page |

### Example Response

```json
{
  "content": [
    {
      "dateAdded": "2019-07-18T19:33:09.000+0000",
      "dateModified": "2019-07-18T19:33:09.000+0000",
      "deleted": false,
      "orderId": 1,
      "quantity": 2,
      "orderDate": "2019-07-18T19:33:09.000+0000",
      "customerName": "Sabeer Sulaiman",
      "customerAddress": "PV House, Vkd",
      "orderItem": {
        "dateAdded": "2019-07-18T19:31:22.000+0000",
        "dateModified": "2019-07-18T19:33:09.000+0000",
        "deleted": false,
        "itemId": 2,
        "title": "Google Pixel 2",
        "description": "Google device.",
        "tags": "Google,Pixel,2",
        "stock": 98,
        "cost": 800
      },
      "status": "NEW",
      "totalCost": 1600
    }
  ],
  "pageable": {
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "pageSize": 2,
    "pageNumber": 0,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "first": true,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "number": 0,
  "numberOfElements": 1,
  "size": 2,
  "empty": false
}
```

## C. GET /{id}

Get a single order specified `id`.

### Example Response
```json
{
  "dateAdded": "2019-07-18T19:33:09.000+0000",
  "dateModified": "2019-07-18T19:33:09.000+0000",
  "deleted": false,
  "orderId": 1,
  "quantity": 2,
  "orderDate": "2019-07-18T19:33:09.000+0000",
  "customerName": "Sabeer Sulaiman",
  "customerAddress": "PV House, Vkd",
  "orderItem": {
    "dateAdded": "2019-07-18T19:31:22.000+0000",
    "dateModified": "2019-07-18T19:33:09.000+0000",
    "deleted": false,
    "itemId": 2,
    "title": "Google Pixel 2",
    "description": "Google device.",
    "tags": "Google,Pixel,2",
    "stock": 98,
    "cost": 800
  },
  "status": "NEW",
  "totalCost": 1600
}
```
