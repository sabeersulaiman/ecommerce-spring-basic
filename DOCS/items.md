# Items (basePath: v1/items)

Contains CRUD endpoints for items(products) in the e-commerce system.

## Items model

```json
{
  "dateAdded": "2019-07-18T19:30:24.585+0000",
  "dateModified": "2019-07-18T19:30:24.585+0000",
  "deleted": false,
  "itemId": 1,
  "title": "Google Pixel 2 XL",
  "description": "Google device.",
  "tags": "Google,Pixel,2,XL",
  "stock": 100,
  "cost": 1000
}
```

## A. POST /

Add a new item to the system. Responds with the newly added item.

### Body

```json
{
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 10,
  "cost": 800
}
```

### Constraints

- `title` is compulsory.
- `stock` cannot be less than 0.

### Example response

```json
{
  "dateAdded": "2019-07-18T19:31:21.931+0000",
  "dateModified": "2019-07-18T19:31:21.931+0000",
  "deleted": false,
  "itemId": 2,
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 100,
  "cost": 800
}
```

## B. GET /

Gets the list of all the items in the system. Deleted ones are not retrieved.

### Parameters

| Name  |           Type            |                              Description |
| ----- | :-----------------------: | ---------------------------------------: |
| page  |     unsigned integer      |  The page to be retrieved, starts with 0 |
| count | integer - bounded [1,100] | number of items to be retrieved per page |

### Example response

```json
[
  {
    "dateAdded": "2019-07-18T19:30:25.000+0000",
    "dateModified": "2019-07-18T19:30:25.000+0000",
    "deleted": false,
    "itemId": 1,
    "title": "Google Pixel 2 XL",
    "description": "Google device.",
    "tags": "Google,Pixel,2,XL",
    "stock": 100,
    "cost": 1000
  },
  {
    "dateAdded": "2019-07-18T19:31:22.000+0000",
    "dateModified": "2019-07-18T19:31:22.000+0000",
    "deleted": false,
    "itemId": 2,
    "title": "Google Pixel 2",
    "description": "Google device.",
    "tags": "Google,Pixel,2",
    "stock": 100,
    "cost": 800
  }
]
```

## C. GET /{id}

Get a single item denoted by `id`. Fails with `404` status when the specified item is not found in the list.

### Example response

```json
{
  "dateAdded": "2019-07-18T19:31:22.000+0000",
  "dateModified": "2019-07-18T19:31:22.000+0000",
  "deleted": false,
  "itemId": 2,
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 100,
  "cost": 800
}
```

## D. PUT /

Update the item provided in the body of the request. Requires the `itemId` property in the object too. Returns the updated Item. Returns `404` if the item requested for update is not found in the system.

### Body

```json
{
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 100,
  "cost": 800
}
```

### Constraints

- `title` is compulsory.
- `stock` cannot be less than 0.

### Example Response

```json
{
  "dateAdded": "2019-07-18T19:31:22.000+0000",
  "dateModified": "2019-07-18T19:31:22.000+0000",
  "deleted": false,
  "itemId": 2,
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 100,
  "cost": 800
}
```

## E. DELETE /{id}

Deletes the item denoted by the `id` value. Throws `404` if the item is not found in the database.

### Example Response

```json
{
  "dateAdded": "2019-07-18T19:31:22.000+0000",
  "dateModified": "2019-07-18T19:31:22.000+0000",
  "deleted": true,
  "itemId": 2,
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 100,
  "cost": 800
}
```
