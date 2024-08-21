# Food Ordering System API Specification

Welcome to the Food Ordering System API documentation. Below is a detailed overview of the available API endpoints, including example requests and responses.

## 📋 Endpoints Overview

## Food Endpoints
<details>
<a id="fetch-all-food-items"></a>
<summary><b>Fetch All Food Items</b></summary>

**Endpoint:** `GET /api/foods`

**Description:** Retrieves a list of all available food items.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "food-123",
      "outlet_id": "outlet-001",
      "name": "Burger",
      "description": "A juicy beef burger with cheese.",
      "price": 5.99
    },
    {
      "id": "food-456",
      "outlet_id": "outlet-002",
      "name": "Pizza",
      "description": "Cheese pizza with a crispy crust.",
      "price": 8.99
    }
  ]
}
```

**Response Body (Failed):**
```json
{
  "errors": "No food items found"
}
```
</details>

<details>
<a id="fetch-food-details-by-id"></a>
<summary><b>Fetch Food Details by ID</b></summary>

**Endpoint:** `GET /api/foods/{foodId}`

**Description:** Retrieves details of a specific food item by its ID.

**Response Body (Success):**
```json
{
  "data": {
    "id": "food-123",
    "outlet_id": "outlet-001",
    "name": "Burger",
    "description": "A juicy beef burger with cheese.",
    "price": 5.99
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Food item not found"
}
```
</details>

<details>
<a id="add-a-new-food-item"></a>
<summary><b>Add a New Food Item</b></summary>

**Endpoint:** `POST /api/foods`

**Description:** Adds a new food item to the system.

**Request Body:**
```json
{
  "outlet_id": "outlet-1",
  "name": "Margherita Pizza",
  "description": "Classic Margherita pizza with fresh basil.",
  "price": 12.5,
  "addOns": [
    {
      "name": "Extra Cheese",
      "description": "Additional cheese topping.",
      "price": 1.00
    },
    {
      "name": "Olives",
      "description": "Black olives.",
      "price": 0.75
    }
  ]
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
    "price": 12.5,
    "addOns": [
      {
        "id": "add-on-1",
        "food_id": "food-1",
        "name": "Extra Cheese",
        "description": "Additional cheese topping.",
        "price": 1.00
      },
      {
        "id": "add-on-2",
        "food_id": "food-1",
        "name": "Olives",
        "description": "Black olives.",
        "price": 0.75
      }
    ]
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Invalid data provided. Price must be a positive number."
}
```
</details>

<details>
<a id="modify-food-item"></a>
<summary><b>Modify Food Item</b></summary>

**Endpoint:** `PUT /api/foods/{foodId}`

**Description:** Modifies details of an existing food item.

**Request Body :**
```json
{
  "outlet_id": "outlet-001",
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
    "outlet_id": "outlet-001",
    "name": "Veggie Burger",
    "description": "A delicious veggie burger with a blend of fresh vegetables.",
    "price": 5.50
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Price is invalid"
}
```
</details>

<details>
<a id="delete-food"></a>
<summary><b>Delete Food</b></summary>

**Endpoint:** `DELETE /api/foods/{foodId}`

**Description:** Deletes a specific food item.

**Response Body (Success):**
```json
{
  "data": "OK"
}
```

**Response Body (Failed):**
```json
{
  "errors": "Food is not found"
}
```
</details>

## Add-On Endpoints
<details>
<a id="add-add-on-to-a-food-item"></a>
<summary><b>Add Add-On to a Food Item</b></summary>

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

**Response Body (Failed):**
```json
{
  "errors": "Price is invalid"
}
```
</details>

<details>
<a id="modify-add-on"></a>
<summary><b>Modify Add-On</b></summary>

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

**Response Body (Failed):**
```json
{
  "errors": "Price is invalid"
}
```
</details>

<details>
<a id="delete-add-on"></a>
<summary><b>Delete Add-On</b></summary>

**Endpoint:** `DELETE /api/add-ons/{addOnId}`

**Description:** Deletes a specific add-on.

**Response Body (Success):**
```json
{
  "data": "OK"
}
```

**Response Body (Failed):**
```json
{
  "errors": "Add-on is not found"
}
```
</details>

## Order Endpoints
<details>
<a id="create-order"></a>
<summary><b>Create Order</b></summary>

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

**Response Body (Failed):**
```json
{
  "errors": "Invalid userId or outletId"
}
```
</details>

<details>
<a id="fetch-order-details"></a>
<summary><b>Fetch Order Details</b></summary>

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

**Response Body (Failed):**
```json
{
  "errors": "Order not found"
}
```
</details>

## Merchant & Outlet  Endpoints
<details>
<a id="fetch-all-merchants"></a>
<summary><b>Fetch All Merchants</b></summary>

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

**Response Body (Failed):**
```json
{
  "errors": "No merchants found"
}
```
</details>

<details>
<a id="fetch-all-outlets-for-a-specific-merchant"></a>
<summary><b>Fetch All Outlets for a Specific Merchant</b></summary>

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

**Response Body (Failed):**
```json
{
  "errors": "No outlets found for the specified merchant"
}
```
</details>

<details>
<a id="fetch-food-items-available-at-a-specific-outlet"></a>
<summary><b>Fetch Food Items Available at a Specific Outlet</b></summary>

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

**Response Body (Failed):**
```json
{
  "errors": "No food items found for the specified outlet"
}
```

</details>