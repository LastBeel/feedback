# Feedback
This is a project that is on its way to become a feedback program for clients to use that is not done. 
There is more info under the subfolders.


## Goal:
A café would like to implement a web site where customers can give feedback on their experience in the cafe.

**DB: Tables in DB for client_info and feedback**

**Backend: Web service with REST interface to read and write from DB.**

**Frontend: Implement a front end page for users give feedback as below:**
* User login to the site (using data from client_info table in DB through the web service)
*	User sees his old feedbacks, but user cannot change them.
*	User should be able to add a new feedback.
*	Admin users should be able to see all other users feedbacks.
*	Admin users should have extra view for statistics (just overall view).
  
## Languages
*	Back end dev : Java(Spring Framework)
* Front end dev: 
  * For beautiful stats: JavaScript(d3js)
  * Everything else: Typescript(Angular)
*	DevOps: Git + Maven
*	Databases: Mysql
