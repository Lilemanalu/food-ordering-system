# 🍽️ Food Ordering System

## Overview

Welcome to the **Food Ordering System**, a robust Spring Boot application that simplifies food ordering from multiple outlets. Users can browse menus, customize food items with add-ons, and place orders effortlessly. The system ensures data consistency by capturing snapshots of food and add-ons at the time of ordering.

## ✨ Features

- **Food Management:**
    - 🔍 Fetch all available food items.
    - 📄 View specific food details by ID.
    - ➕ Add new food items with or without add-ons.
    - ✏️ Modify food details including name, description, and price.
    - 🗑️ Delete food items.

- **Add-On Management:**
    - ➕ Add new add-ons to existing food items.
    - ✏️ Modify add-on details including name, description, and price.
    - 🗑️ Delete add-ons from food items.

- **Order Management:**
    - 🛒 Create orders with food and add-on snapshots.
    - 📄 Query orders along with detailed snapshots of ordered food and add-ons.

- **Merchant & Outlet Management:**
    - 🏢 Query all merchants.
    - 🏬 Query outlets by merchant ID.
    - 🍲 Query food items available at a specific outlet.

- **Logging:**
    - 📝 Generate logs for all API requests and responses.
    - 📊 Log database queries and insertions.
    - ❗ Error logging with detailed messages for troubleshooting.
    - 📈 Log order details such as total price, outlet, and merchant information after an order is created.

## 🗄️ Database Schema

### Tables

1. **Food**
    - `id` (String): Unique identifier for the food item.
    - `outlet_id` (String): Identifier for the outlet offering the food.
    - `name` (String): Name of the food item.
    - `description` (String): Description of the food item.
    - `price` (Double): Price of the food item.

2. **AddOn**
    - `id` (String): Unique identifier for the add-on.
    - `food_id` (String): Identifier of the associated food item.
    - `name` (String): Name of the add-on.
    - `description` (String): Description of the add-on.
    - `price` (Double): Price of the add-on.

3. **FoodSnapshot**
    - `id` (String): Unique identifier for the food snapshot.
    - `order_id` (String): Identifier of the associated order.
    - `food_id` (String): Identifier of the food item.
    - `outlet_id` (String): Identifier of the outlet.
    - `name` (String): Name of the food item.
    - `description` (String): Description of the food item.
    - `price` (Double): Price of the food item.
    - `created_time` (Date): Timestamp when the snapshot was created.

4. **AddOnSnapshot**
    - `id` (String): Unique identifier for the add-on snapshot.
    - `add_on_id` (String): Identifier of the add-on.
    - `food_snapshot_id` (String): Identifier of the associated food snapshot.
    - `name` (String): Name of the add-on.
    - `description` (String): Description of the add-on.
    - `price` (Double): Price of the add-on.
    - `created_time` (Date): Timestamp when the snapshot was created.

5. **Order**
    - `id` (String): Unique identifier for the order.
    - `user_id` (String): Identifier of the user who placed the order.
    - `outlet_id` (String): Identifier of the outlet.
    - `created_time` (Date): Timestamp when the order was created.

6. **User**
    - `id` (String): Unique identifier for the user.
    - `name` (String): Name of the user.

7. **Merchant**
    - `id` (String): Unique identifier for the merchant.
    - `name` (String): Name of the merchant.
    - `description` (String): Description of the merchant.

8. **Outlet**
    - `id` (String): Unique identifier for the outlet.
    - `merchant_id` (String): Identifier of the associated merchant.
    - `name` (String): Name of the outlet.
    - `description` (String): Description of the outlet.

## 📑 API Endpoints
Detailed information for each API endpoint can be found in the [API Specification Document](docs/api-spec.md).

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

## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/food-ordering-system.git
