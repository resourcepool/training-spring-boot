# TheWelcomeProject

`Serie 4: CV-webapp`

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
   * Use of the whole JEE stack is required, with at least JSP, Servlet, JSTL, EJB and JPA
   * Use of Hibernate ORM through is allowed
   * Use of Spring is not allowed
   * Use of Maven is not allowed

# The Project    
The project consists of a JEE webapp.  
Your goal is to create both a client and an administration panel for your own professional website.  
Your website is there to expose your experience and all the info you might want to show on your CV.  
It is aimed at facilitating your presence on the web.

We have provided you a nice template to work with so that you don't spend too much time on styling.

In particular, the following features will be implemented:  

**Admin panel:**
  * Create / edit / delete all sections of your profile: experience, education, skills, hobbies, etc...
  * Edit all profile meta-data: name, email, profile picture, banner, etc...
  * Add optional Social links to your external profiles : LinkedIn, Github, Twitter, Instagram
  * Allow to import or export cv-data from / to an external .json file

**Client panel:**
  * Embrace responsive design for all sections of your CV. Mobile first!
  * Allow to generate a dynamic printable version of your CV
  * Allow to contact you through a contact-form

You don't need to implement security like login or user account at the moment.
We have provided you with a sample "export" of our own CV app. Maybe it could help you to design your models...

## Setup environment

### MariaDB Database
First, install a local **MariaDB** server & a SQL administration tool (MySQL Workbench or PhpMyAdmin).

### Your IDE
For this exercise, you will have to use Eclipse.  
Install the latest **Wildfly** application server. Search & read the docs to know how to :).

### Git repository
A new repository will be provided, with owner rights.  
Everyone must be able to push code on the repository. The important fact here is to **create your own team workflow**.

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
  - HTML5 architecture
  - Some CSS bootstrap code + js libs

Some skeletons of pages:
  - index.html
  - contact.html
  - 404.html

We also added a cv-sample.json which contains a possible schema for your models
(You may go another way or change some fields obviously).

# Bonus
All is done on day 3?
Here are a few features we as a customer would have loved to have available.
 * Import data from LinkedIn
 * Implement theme abilities : make someone able to upload a custom theme for his/her CV
 * Implement security (through Oauth: Twitter or Github or LinkedIn)
 * Add a newsletter form and newsletter management in your admin section
 * Make all your sections use Markdown and a nice Markdown editor to format your content

# License
The static content of this project is a derivate from [Kataklimt](https://www.html5xcss3.com/2012/12/html5-template-kataklimt.html), a HTML5/CSS3 website template.
Thanks for the authors for providing it for free.
