# Food Ordering System API Specification

Welcome to the Food Ordering System API documentation. Below is a detailed overview of the available API endpoints, including example requests and responses.

## 📋 Endpoints Overview

### Food Endpoints
- **GET** `/api/foods` - Fetch all available food items.
- **GET** `/api/foods/{foodId}` - Fetch details of a specific food item.
- **POST** `/api/foods` - Add a new food item.
- **PUT** `/api/foods/{foodId}` - Modify details of an existing food item.
- **DELETE** `/api/foods/{foodId}` - Delete a specific food item.

### Add-On Endpoints
- **POST** `/api/foods/{foodId}/add-ons` - Add a new add-on to a specific food item.
- **PUT** `/api/add-ons/{addOnId}` - Modify details of an existing add-on.
- **DELETE** `/api/add-ons/{addOnId}` - Delete a specific add-on.

### Order Endpoints
- **POST** `/api/orders` - Create a new order with food and add-on snapshots.
- **GET** `/api/orders/{orderId}` - Fetch details of a specific order.

### Merchant & Outlet Endpoints
- **GET** `/api/merchants` - Fetch all merchants.
- **GET** `/api/merchants/{merchantId}/outlets` - Fetch all outlets for a specific merchant.
- **GET** `/api/outlets/{outletId}/foods` - Fetch food items available at a specific outlet.


## Food Endpoints

### Fetch All Food Items
**Endpoint:** `GET /api/foods`

**Description:** Retrieves a list of all available food items.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "food-123",
      "name": "Burger",
      "description": "A juicy beef burger with cheese.",
      "price": 5.99,
      "addOns": []
    },
    {
      "id": "food-456",
      "name": "Pizza",
      "description": "Cheese pizza with a crispy crust.",
      "price": 8.99,
      "addOns": [
        {
          "id": "add-on-789",
          "name": "Extra Cheese",
          "description": "Additional cheese topping.",
          "price": 1.00
        }
      ]
    }
  ]
}
```

**Response Body (Success):**
```json
{
  "errors": "No food items found"
}
```


### Fetch Food Details by ID
**Endpoint:** `GET /api/foods/{foodId}`

**Description:** Retrieves details of a specific food item by its ID.

**Response Body (Success):**
```json
{
  "data": {
    "id": "food-123",
    "name": "Burger",
    "description": "A juicy beef burger with cheese.",
    "price": 5.99,
    "addOns": []
  }
}
```

**Response Body (Success):**
```json
{
  "errors": "Food item not found"
}
```


### Add a New Food Item
**Endpoint:** `POST /api/foods`

**Description:** Adds a new food item to the system.

**Request Body:**
```json
{
  "outlet_id": "outlet-1",
  "name": "Margherita Pizza",
  "description": "Classic Margherita pizza with fresh basil.",
  "price": 12.5
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "food-1",
    "outlet_id": "outlet-1",
    "name": "Margherita Pizza",
    "description": "Classic Margherita pizza with fresh basil.",
    "price": 12.5
  }
}
```

**Response Body (Success):**
```json
{
  "errors": "Invalid data provided. Price must be a positive number."
}
```


### Modify Food Item
**Endpoint:** `PUT /api/foods/{foodId}`

**Description:** Modifies details of an existing food item.

**Request Body :**
```json
{
  "name": "Veggie Burger",
  "description": "A delicious veggie burger with a blend of fresh vegetables.",
  "price": 5.50
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "food-123",
    "name": "Veggie Burger",
    "description": "A delicious veggie burger with a blend of fresh vegetables.",
    "price": 5.50
  }
}
```

**Response Body (Success):**
```json
{
  "errors": "Price is invalid"
}
```


### Delete Food
**Endpoint:** `DELETE /api/foods/{foodId}`

**Description:** Deletes a specific food item.

**Response Body (Success):**
```json
{
  "data": "OK"
}
```

**Response Body (Success):**
```json
{
  "errors": "Food is not found"
}
```


## Add-On Endpoints
### Add Add-On to a Food Item
**Endpoint:** `POST /api/foods/{foodId}/add-ons`

**Description:** Adds a new add-on to a specific food item.

**Request Body :**
```json
{
  "name": "Extra Cheese",
  "description": "Additional cheese for a richer taste.",
  "price": 1.00
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "add-on-456",
    "name": "Extra Cheese",
    "description": "Additional cheese for a richer taste.",
    "price": 1.00
  }
}
```

**Response Body (Success):**
```json
{
  "errors": "Price is invalid"
}
```


### Modify Add-On
**Endpoint:** `PUT /api/add-ons/{addOnId}`

**Description:** Modifies details of an existing add-on.

**Request Body :**
```json
{
  "name": "Extra Cheese",
  "description": "Additional layer of melted cheese.",
  "price": 1.00
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "addon-123",
    "name": "Extra Cheese",
    "description": "Additional layer of melted cheese.",
    "price": 1.00
  }
}
```

**Response Body (Success):**
```json
{
  "errors": "Price is invalid"
}
```


### Delete Add-On
**Endpoint:** `DELETE /api/add-ons/{addOnId}`

**Description:** Deletes a specific add-on.

**Response Body (Success):**
```json
{
  "data": "OK"
}
```

**Response Body (Success):**
```json
{
  "errors": "Add-on is not found"
}
```


## Order Endpoints
### Create Order
**Endpoint:** `POST /api/orders`

**Description:** Creates a new order with food and add-on snapshots.

**Request Body :**
```json
{
  "userId": "user-123",
  "outletId": "outlet-456",
  "foodSnapshots": [
    {
      "foodId": "food-789",
      "quantity": 2,
      "addOnSnapshots": [
        {
          "addOnId": "addon-101",
          "quantity": 1
        }
      ]
    }
  ]
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "order-202",
    "userId": "user-123",
    "outletId": "outlet-456",
    "createdTime": "2024-08-21T12:34:56Z",
    "foodSnapshots": [
      {
        "foodId": "food-789",
        "quantity": 2,
        "addOnSnapshots": [
          {
            "addOnId": "addon-101",
            "quantity": 1
          }
        ]
      }
    ]
  }
}
```

**Response Body (Success):**
```json
{
  "errors": "Invalid userId or outletId"
}
```


### Fetch Order Details
**Endpoint:** `GET /api/orders/{orderId}`

**Description:** Fetches details of a specific order.

**Path Parameters:**
- `orderId` (String): Unique identifier for the order.

**Response Body (Success):**
```json
{
  "data": {
    "id": "order-202",
    "userId": "user-123",
    "outletId": "outlet-456",
    "createdTime": "2024-08-21T12:34:56Z",
    "foodSnapshots": [
      {
        "foodId": "food-789",
        "quantity": 2,
        "addOnSnapshots": [
          {
            "addOnId": "addon-101",
            "quantity": 1
          }
        ]
      }
    ]
  }
}
```

**Response Body (Success):**
```json
{
  "errors": "Order not found"
}
```


## Merchant & Outlet  Endpoints
### Fetch All Merchants
**Endpoint:** `GET /api/merchants`

**Description:** Fetches a list of all merchants.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "merchant-1",
      "name": "Merchant One",
      "description": "A great merchant offering diverse options."
    },
    {
      "id": "merchant-2",
      "name": "Merchant Two",
      "description": "Known for quality and service."
    }
  ]
}
```

**Response Body (Success):**
```json
{
  "errors": "No merchants found"
}
```


### Fetch All Outlets for a Specific Merchant
**Endpoint:** `GET /api/merchants/{merchantId}/outlets`

**Description:** Fetches all outlets associated with a specific merchant.

**Request Parameters:**
- `merchantId` (String): The unique identifier of the merchant.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "outlet-1",
      "name": "Outlet One",
      "description": "Located in the city center.",
      "merchant_id": "merchant-1"
    },
    {
      "id": "outlet-2",
      "name": "Outlet Two",
      "description": "Popular spot with local specialties.",
      "merchant_id": "merchant-1"
    }
  ]
}
```

**Response Body (Success):**
```json
{
  "errors": "No outlets found for the specified merchant"
}
```


### Fetch Food Items Available at a Specific Outlet
**Endpoint:** `GET /api/outlets/{outletId}/foods`

**Description:** Fetches all food items available at a specific outlet.

**Request Parameters:**
- `outletId` (String): The unique identifier of the outlet.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "food-1",
      "name": "Spaghetti Bolognese",
      "description": "Classic Italian pasta with meat sauce.",
      "price": 12.5,
      "outlet_id": "outlet-1"
    },
    {
      "id": "food-2",
      "name": "Margherita Pizza",
      "description": "Simple and delicious pizza with tomato and mozzarella.",
      "price": 10.0,
      "outlet_id": "outlet-1"
    }
  ]
}
```

**Response Body (Success):**
```json
{
  "errors": "No food items found for the specified outlet"
}
```
