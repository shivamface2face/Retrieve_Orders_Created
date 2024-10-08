Requirements

Role-Based Order Retrieval

The API should utilize the token of the logged-in user to determine their role and filter relevant orders accordingly. The API must support the following functionalities:

Sales Agent: Retrieve orders created by the logged-in Sales Agent.

Delivery Agent: Retrieve orders assigned to the logged-in user.

Shopkeeper: Retrieve orders that belong to the logged-in user


Status Filtering


In addition to role-based filtering, the API should allow users to filter orders based on their current status. This provides flexibility in fetching relevant orders according to their needs.

API Endpoint

URL: /api/replenish-orders/orders

Method: GET

API Handler Implementation

The implementation of the API handler at the specified endpoint will involve the following steps:

1-Token Parsing:

Extract the user's role from the JWT token provided in the request headers.

Order Filtering Logic:

2- Based on the user's role, filter orders using the following parameters:

createdBy: For Sales Agents, retrieve orders they created.

assignedToMe: For Delivery Agents, retrieve orders assigned to them.

belongsToMe: For Shopkeepers, retrieve orders that belong to them.

3-Status Filtering:

Allow the user to specify an order status (e.g., pending, completed, canceled) to refine the search results further.



Benefits

Single Endpoint: Simplifies the API structure and reduces the number of endpoints to manage.

Role Flexibility: Adapts to different user roles dynamically, ensuring a seamless experience.

Efficient Filtering: Allows users to obtain only the relevant orders based on their role and current status.
