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
