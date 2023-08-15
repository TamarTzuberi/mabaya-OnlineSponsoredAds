# mabaya-OnlineSponsoredAds
Welcome to the OnlineSponsoredAds repository!
# Getting Started 
To get started, make sure you have Docker installed on your system.
########add explanation about docker run###############
# Features 
- Database Initialization: Upon application startup, the Spring project automatically populates the database with 10 products.
These products are assigned random categories from a predefined list ("Electronics", "Beauty", "Home"), along with random prices and unique serial numbers.
- Optimized Querying: To enhance query performance for product searches by category, an index has been added to the 'category' column in the database. 
This ensures that searching for products by category is efficient, even as the database grows.
- Rest APIs:
    1. Campaign Creation API: Use this API to create campaigns:
       Parameters: name , startDate , List of product identifiers to promote , Bid (price for a click on an advertised product)
       Response: JSON representation of the campaign.
    2. Ad Retrieval API: Retrieve promoted ads based on category:
       Parameters: Category
       Response: JSON format, highest bid's product from active campaigns.
# HTTP client tool
After Docker's run, you can utilize Postman, or any other HTTP client tool of your choice, to:
1. Retrieve Ad (GET): http://localhost:8080/promotedProduct?category="Home"
2. Create Campaign (POST): http://localhost:8080/newCampaign
                   Body Example:  {
                                      "name": "HomeCampaign",
                                      "startDate": "2023-08-13 00:59:59",
                                      "productIds": [3,5,7,9],
                                      "bid" : 5000.66
                                  }




  
