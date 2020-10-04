# Mood of the Month

The goal of this mini-project is to use skills on Spring to make a mood survey website.  

# The Project    
Your goal is to create both a client and an administration panel for an employee "mood of the month" app.
Every last friday of the month, at around 10 AM for example, the MOTM (Mood Of The Month) app will send an email to each employee with a link.
When following the link, the employee will be able to give their mood (a 1 to 5 scale) for the current month, and eventually put an additional comment anonymously.

In particular, the following items will be implemented:  

**Admin panel:**
  * Create a new employee: name, email, birthdate, uuid
  * Create the MOTM template content: Title, message template, page template.
  * See MOTM stats

**Client panel:**
  * Answer the MOTM
  * Edit a previous answer

An **employee** can be edited. It has both a name, an email and a birthdate. Each user also has a unique identifier (uuid).
A **MOTM** contains a title, a message template, and a page template.

You don't need to implement security like login or user account at the moment.

# Bonus
All is done on day 3?
Here are a few features we as a customer would have loved to have available.
 * Add a fullscreen dashboard with the evolution of the global company mood for the past **n** months
 * Printable report
 * CSV export
 * Add multiple "questions"
 * Send automatic report to all members each month (and add Feedback template in MOTM)
 * Send notification emails (reminders)
 * Implement backend tests
