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

## 📑 API Endpoints
Detailed information for each API endpoint can be found in the [API Specification Document](docs/api-spec.md).

## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/food-ordering-system.git
