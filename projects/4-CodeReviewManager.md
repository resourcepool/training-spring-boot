Code Review Management
===================
The goal of this mini-project is to use your skills on Spring to make a code review management tool.  
You can either : 
 * Make a standalone app using Spring boot + Thymeleaf
 * Make a back with an API (using Spring Boot) and a front to display your data (using Angular)

# Project Conditions
You will develop your project as a **team** of 3.  

In terms of delivery, these are the requirements:
   * Clean & commented code
   * send us a Github or Gitlab link to your repository (don't make it private) 
   * A small ReadMe with instructions to launch your project and a screenshot of your app

Send your repositories at lcouvreux@takima.fr and amoray@takima.fr

# The Project      
Your goal is to create an administration panel to manage a schedule of code reviews.
In particular, the following items will be implemented:
  * Create a new member: name, email, birthdate, class
  * Create a new class: name, members
  * Create a code review schedule: name, description, datetime, class

A **member** can be edited and belongs to a class. It has both a name, an email and a birthdate.  
A **class** is a group of members. The name refers to their arrival date (Class of February 2017 for instance). It needs a name and has between 0 and an infinity of members. Users are members of zero to one class at most.  
A **code review** is a meeting for members of a class. It must have a date & hour, a name, a description, and of course the targeted class.

You don't need to implement security like login or user account at the moment.
We provide you the front pages but you'll need to edit it.

# Bonus
All is done on day 3?
Here are a few features we as a customer would have loved to have available.
 * Add a fullscreen Timer countdown page for the next code review, for each class (to display on a TV Screen)
 * Add a search bar
 * Handle multiple timers
 * Add the ability to assign a reviewer to a code review
 * Connect to Google Agenda API
 * Send notification emails (reminders)
 * Implement backend tests

