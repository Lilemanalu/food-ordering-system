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
