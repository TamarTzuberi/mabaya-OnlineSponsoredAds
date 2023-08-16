# mabaya-OnlineSponsoredAds
Welcome to the OnlineSponsoredAds repository!
# Getting Started 
To get started, make sure you have Docker installed on your system.
1. Clone this repository to your local machine using the following command: 
   git clone https://github.com/TamarTzuberi/mabaya-OnlineSponsoredAds.git
2. From the root directory of the cloned project using your terminal, run:
   docker-compose up --build
   - This command will build the necessary Docker images, create and start the containers, and set up your application and the associated PostgreSQL database.
3. Once the Docker containers are up and running, you can start sending REST API requests:
   - Rest APIs:
    1. Campaign Creation API: Use this API to create campaigns:
       Parameters: name , startDate , List of product identifiers to promote , Bid (price for a click on an advertised product)
       Response: JSON representation of the campaign.
    2. Ad Retrieval API: Retrieve promoted ads based on category:
       Parameters: Category (Electronics, Beauty, Home)
       Response: JSON format, highest bid's product from active campaigns.
   - HTTP client tool
        You can utilize Postman, or any other HTTP client tool of your choice, to:
        1. Retrieve Ad (GET): http://localhost:8080/promotedProduct?category=Home
        2. Create Campaign (POST): http://localhost:8080/newCampaign
           Body Example:  {
                            "name": "HomeCampaign",
                            "startDate": "2023-08-13 00:59:59",
                            "productIds": [3,5,7,9],
                            "bid" : 5000.66
                          }

# Features 
- Database Initialization: Upon application startup, the Spring project automatically populates the database with 10 products.
These products are assigned random categories from a predefined list ("Electronics", "Beauty", "Home"), along with random prices and unique serial numbers.
- Optimized Querying: To enhance query performance for product searches by category, an index has been added to the 'category' column in the database. 
This ensures that searching for products by category is efficient, even as the database grows.





  
