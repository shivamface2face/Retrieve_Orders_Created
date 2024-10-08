Retrieve Orders Created by Logged-in Sales Agent
In our system, we have a Replenishment Handler, which is an API responsible for managing replenishment orders and stock.

Scenario
Instead of having multiple endpoints for different user roles, such as:

Orders created by a Sales Agent
Orders belonging to a Shopkeeper
Orders assigned to a Delivery Agent
The objective is to implement an API that can handle this flexibility through a single endpoint by using the logged-in user's token.

Requirements
Use the token of the logged-in user to identify the role and filter the relevant orders.
The API should support filtering orders based on:
Orders created by the logged-in Sales Agent.
Orders assigned to the logged-in user (for Delivery Agents).
Orders that belong to the logged-in user (for Shopkeepers).
Orders should also be filtered by status, allowing users to fetch orders based on their current state.
Endpoint
URL: /api/replenish-orders/orders
Expected Solution
Implement an API handler at the above endpoint that:
Parses the user's role from the token.
Filters orders using parameters like createdBy, assignedToMe, or belongsToMe.
Orders can be further filtered based on their status.
