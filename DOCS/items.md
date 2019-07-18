# Items (basePath: v1/items)

Contains CRUD endpoints for items(products) in the e-commerce system.

## Items model

```json
{
  "itemId": 4,
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 10,
  "deleted": false,
  "dateAdded": "2019-07-18T15:47:20.280+0000",
  "dateModified": "2019-07-18T15:47:20.280+0000"
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
  "stock": 10
}
```

### Constraints

- `title` is compulsory.
- `stock` cannot be less than 0.

### Example response

```json
{
  "itemId": 4,
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 10,
  "deleted": false,
  "dateAdded": "2019-07-18T15:47:20.280+0000",
  "dateModified": "2019-07-18T15:47:20.280+0000"
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
    "itemId": 1,
    "title": "iPhone X",
    "description": "great iPhone.",
    "tags": "iPhone,X,Apple",
    "stock": 5,
    "deleted": false,
    "dateAdded": "2019-07-18T15:28:24.000+0000",
    "dateModified": "2019-07-18T15:33:30.000+0000"
  },
  {
    "itemId": 3,
    "title": "iPhone XR",
    "description": "Crazy iPhone.",
    "tags": "iPhone,XR,Apple",
    "stock": 10,
    "deleted": false,
    "dateAdded": "2019-07-18T15:32:52.000+0000",
    "dateModified": "2019-07-18T15:32:52.000+0000"
  }
]
```

## C. GET /{id}

Get a single item denoted by `id`. Fails with `404` status when the specified item is not found in the list.

### Example response

```json
{
  "itemId": 4,
  "title": "Google Pixel 2",
  "description": "Google device.",
  "tags": "Google,Pixel,2",
  "stock": 10,
  "deleted": false,
  "dateAdded": "2019-07-18T15:47:20.280+0000",
  "dateModified": "2019-07-18T15:47:20.280+0000"
}
```

## D. PUT /

Update the item provided in the body of the request. Requires the `itemId` property in the object too. Returns the updated Item. Returns `404` if the item requested for update is not found in the system.

### Body

```json
{
  "itemId": 1,
  "title": "iPhone X",
  "description": "great iPhone.",
  "tags": "iPhone,X,Apple",
  "stock": 5
}
```

### Constraints

- `title` is compulsory.
- `stock` cannot be less than 0.

### Example Response

```json
{
  "itemId": 1,
  "title": "iPhone X",
  "description": "great iPhone.",
  "tags": "iPhone,X,Apple",
  "stock": 5,
  "deleted": false,
  "dateAdded": "2019-07-18T15:28:24.000+0000",
  "dateModified": "2019-07-18T15:33:30.280+0000"
}
```

## E. DELETE /{id}

Deletes the item denoted by the `id` value. Throws `404` if the item is not found in the database.

### Example Response

```json
{
  "itemId": 2,
  "title": "iPhone XR",
  "description": "Weird flex but not ok.",
  "tags": "iPhone,XR,Apple",
  "stock": 5,
  "deleted": true,
  "dateAdded": "2019-07-18T15:28:52.000+0000",
  "dateModified": "2019-07-18T15:30:28.281+0000"
}
```
