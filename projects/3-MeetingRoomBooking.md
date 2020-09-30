Meeting Room Booking
===========
The goal of this mini-project is to use skills on Spring to make your own online CV website.  
You can either : 
  * Make a standalone app using Spring boot + Thymeleaf
  * Make a back with an API (using Spring Boot) and a front part to display your data (using Angular)

# Project Conditions
You will develop your project as a **team** of 3.  

In terms of delivery, these are the requirements:
   * Clean & commented code
   * send us a Github or Gitlab link to your repository (don't make it private) 
   * A small ReadMe with instructions to launch your project and a screenshot of your app

Send your repositories at lcouvreux@takima.fr and amoray@takima.fr

# The Project 
Your goal is to create both a client and an administration panel for a meeting room booking app. 
Any member should be able to book a room for a specific duration at the date and time of his choice or whenever the room is available.
Each meeting room has a dedicated dashboard where anyone can view and book (potentially, this dashboard would be displayed on a tablet in front of each room). 

In particular, the following items will be implemented:  

**Admin panel:**
  * Create & edit a new member: name, email, birthdate, uuid
  * Create & edit a new meeting room: name, picture, capacity (X persons), equipment (Screen, whiteboard), uuid
  * Book a meeting room for a given time at a given date with constraints
  * See which room is free
  * Invite members to the meeting room
  * Send emails to members invited to a meeting (ICS card to link in a calendar)

**Client panel:**
  * View specific meeting room calendar
  * View members of a meeting
  * Book a meeting room

A **member** can be edited. It has both a name, an email and a birthdate. Each user also has a unique identifier (uuid).

A **meeting room** has a name, a picture, a capacity and an unique identifier. It may have more attributes ;)
You will need to implement a set of business rules and constraints to book a room like:
  - I need a room for X people
  - I need it for Y hours and Z minutes
  - I need a TV to display content
  - I need a whiteboard
  - Preferably in the morning
  - As soon as possible / Next week / next month
  - Preferably in room 1 / Preferably in room 1 or 3

Some contraints combination may not be possible, so you will need to inform the user and propose a better solution or alternative...
You don't need to implement security like login or user account at the moment.

# Bonus
All is done on day 3?
Here are a few features we as a customer would have loved to have available.
 * Link with Google calendar
 * Add a recommendation engine in case a room is not available according to the provided rules
 * Send notification emails (reminders)
 * Implement backend tests
