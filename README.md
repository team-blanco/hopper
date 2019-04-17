# hopper
Find deals from your local bars and restaurants!

# Hopper Design Specs

Your [design product spec](https://hackmd.io/s/H1wGpVUh7) (described in that link) will look like the following in your README:

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview
### Description
Hopper is an app that notifies users of local bars happy hours and special deals and events. 

## App Evalaution
**Category:** Food & Drink 
**Mobile:** Mobile is essential to the app as it will leverage the use of locations and Push notifications Story: Users will be notified on nearby bar happy hours and special promotions. 
**Market:** Anyone over the age of legal drinking age 
**Habit:** Users going out will be able quickly find bars with specials within walking distance 
**Scope:** V1 would notify users of nearby happy hours and special promotions. V2 will introduce games and streaks where users will be directed to a number of partnered bars for a chance to win prizes.

## Product Spec
## 1. User Stories (Required and Optional)

**Required Must-have Stories**

 * User can view feed of nearby bars
 * User can see a detailed view of each bar to see description and happy hour info 
 * User can view maps page with bars marked


**Optional Nice-to-have Stories**

 * User Registration (Optional)
 * User can Login 
 * User Verification
 * App passes navigation to Maps App
 * User can add deals to feed
 * User can view businesses in search radius
 * Rating of business visible in details
 * Uber/Lyft feature 

## 2. Screen Archetypes

 * Login/ Register Screen  
     * The app will open to the registration page where they can create an account. If the user already has an account, they can login. Upon successful registration or login, they will be sent to the Home(Stream) view.
 * Stream
     * App will provide a feed of nearby businesses along with deals/special events
 * Detail Screen
     * From here the user will be presented a more detailed screen of the bar/deal they selected. It will have an image, offer title, along with details about the bars location, business hours, style, dress, etc.
 * Profile/Settings
     * User is able to contact the support team or logout from the app
 * Map View
     * User will be able to see all the bars near their current location

## 3. Navigation

**Tab Navigation** (Tab to Screen)

 * Home feed
 * Maps
 * Profile

**Flow Navigation** (Screen to Screen)
  * Register Screen
     => Home Feed
     => Login Screen
  * Login
     => Register Screen
     => Home Feed
  * Home Feed
     => Location Screen
     => Post Screen
     =>Detail Screen

## Wireframes
<img src="https://i.imgur.com/worzuk2.png" width=800><br>
<img src="https://i.imgur.com/XfBHlgW.png" width=800><br>

### [BONUS] Digital Wireframes & Mockups
<img src="https://i.imgur.com/blQrFbo.png" height=200>


### [BONUS] Interactive Prototype
<img src="https://media.giphy.com/media/8vqEFjYoczsuF6Wh4U/giphy.gif" width=200>

## Schema 
### Models
#### Post

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | distance      | Number   | distance from business |
   | title         | String   | title of business event/deal |
   | details       | String   | description of business event/deal |
   | business      | Pointer to Business  | business name, physical location, and image |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
   
#### User

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | password      | String   | private password used to authenticate users |
   | name          | String   | first/last name of user |
   | email         | String   | email for user |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
   
#### Business

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | businessName  | String   | name of business |
   | location      | String   | physical location of business |
   | image         | File     | fimage of storefront/business |
   | website       | String   | website for business |
   | phoneNum      | String   | phone number of business |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
   
### Networking
#### List of network requests by screen
   - Home Feed Screen
      - (Read/GET) Query all posts where locations are near user
        ```swift
        // GET /business/search
        
      - (Delete) Delete posts that reach expiration
      
   
   - Map Screen
      - (Read/GET) Query nearby locations
      ```swift
        // GET /business/search
      
   - Profile Screen
      - (Read/GET) Query logged in user object
      
   - Register Screen
      - (Create/POST) Create new user account
      
   - Login Screen
      - (Create/POST) Sends user-supplied credentials for authentication
      
   - Detail Screen
      - (Read/GET) Query business details (name, address, pictures, etc.)
      ```swift
        // GET /business/search
      
   #### PROGRESS UPDATE: UNIT 10 April 3rd
   
   Login Screen:
   <img src="https://i.imgur.com/r0xkvuy.png" width=800><br>
   
   Signup Screen:
   <img src="https://i.imgur.com/NiiuMxs.png" width=800><br>
   
   Profile Screen:
   <img src="https://i.imgur.com/YMwhiRp.png" width=800><br>
   
   Post:
   
   <img src="https://i.imgur.com/K0BKf9z.png" width=800><br>
   
   #### PROGRESS UPDATE: APRIL 8th
   
   Prototype:
   
   <img src="https://github.com/team-blanco/hopper/blob/master/walkthrough.gif"><br>
