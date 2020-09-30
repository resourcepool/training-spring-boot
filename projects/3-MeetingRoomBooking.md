The welcome project 3
=====================

The goal of this mini-project is to refresh your **Java / JEE** skills in a 4 day rush team-effort.  
This project requires both **Backend** (Java/JEE), **SQL**, **Ops** & **Frontend** skills (JSP, HTML, CSS, JavaScript).  
The 4-day project has to be released in **production** on a dedicated server, and **demonstrated** by the team in a full-house presentation.

# Pool Conditions
You will develop your project as a **team**, with minimum Agile management (we recommend the Kanban method).  
**One** git repository will be given to the team and shall be used properly. The workflow details are left to the team's appreciation.

Every day, the team will be able to attend a retrospective at the time of their choice, in presence of a coach, to discuss the following matters:
 * The challenges encountered the day before
 * The current tasks, the remaining tasks
 * The global workflow efficiency

In terms of team work, you are free to try anything you want.  
Do not hesitate to try out eXtreme Programming concepts such as Pair Programming, Code Reviews, Test-Driven Development, and take the time to plan important parts of your project in common.

In terms of delivery, these are the requirements:
   * Clean & commented code
   * Use of the whole JEE stack is allowed (JSP, Servlet, JSTL, JSF?, JPA, JTA, EJB, ...)
   * Use of Hibernate ORM is allowed
   * Use of Spring is not allowed
   * Use of Maven is not allowed

# The Project    
The project consists of a JEE webapp.  
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
We provided you with the front pages, **even though you might still have to edit them in some way**, it's only a starter.
We also use a library called fullcalendar.io tu display all data in a calendar. You need to read the doc and adapt it to your project.

## Setup environment

### MySQL Database
First, install a local **MySQL** server & a SQL administration tool (MySQL Workbench or PhpMyAdmin).

### Your IDE
For this exercise, you will have to use Eclipse.  
Install the latest **Wildfly** application server. Search & read the docs to know how to do :)

### Git repository
A new repository will be provided, with owner rights.  
Everyone must be able to push code on the repository. The important fact here is to **create your orwn team workflow**.

## Project Architecture
Take your time and brainstorm in group to create a clean architecture for the project.
We advise to use the default ORM which goes with Wildfly for data persistence in your project, through JPA.
Create the main architecture for your web app.

## Integration
Download the provided web architecture in the **resources** directory.
Integrate it in your project.

## Release & Demo
 * For your release, we will provide you with a public server instance. You will need to release your code in production before the demonstration, along with the source code.
 * Your demo must be following a client perspective. You are making the demonstration for the project they have asked you to deliver. Two parts can be prepared. The first part refers mostly to showing what you have done, and how you made things. The second part explains your technical choices, and your roadmap for further improvements.

### Provided content
We provided you with some content to help you bootstrap your work.
  - HTML architecture
  - Bootstrap 3
  - Jquery 3
  - Font Awesome 4

Pages:
  - index.html
  - dashboard.html
  - add_event.html
  - add_member.html

# Bonus
All is done on day 3?
Here are a few features we as a customer would have loved to have available.
 * Link with Google calendar
 * Add a recommendation engine in case a room is not available according to the provided rules
 * Send notification emails (reminders)
 * Implement front validation with jQuery
 * Implement backend tests
