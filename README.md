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
- **[Fetch All Food Items](docs/api-spec.md#fetch-all-food-items)**
- **[Fetch Food Details by ID](docs/api-spec.md#fetch-food-details-by-id)**
- **[Add a New Food Item](docs/api-spec.md#add-a-new-food-item)**
- **[Modify Food Item](docs/api-spec.md#modify-food-item)**
- **[Delete Food](docs/api-spec.md#delete-food)**

### Add-On Endpoints
- **[Add Add-On to a Food Item](docs/api-spec.md#add-add-on-to-a-food-item)**
- **[Modify Add-On](docs/api-spec.md#modify-add-on)**
- **[Delete Add-On](docs/api-spec.md#delete-add-on)**

### Order Endpoints
- **[Create Order](docs/api-spec.md#create-order)**
- **[Fetch Order Details](docs/api-spec.md#fetch-order-details)**

### Merchant & Outlet Endpoints
- **[Fetch All Merchants](docs/api-spec.md#fetch-all-merchants)**
- **[Fetch All Outlets for a Specific Merchant](docs/api-spec.md#fetch-all-outlets-for-a-specific-merchant)**
- **[Fetch Food Items Available at a Specific Outlet](docs/api-spec.md#fetch-food-items-available-at-a-specific-outlet)**


## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/food-ordering-system.git
