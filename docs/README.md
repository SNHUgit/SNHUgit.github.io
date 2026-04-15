## What It Was

This artifact was originally created in CS 320, Software Testing, Automation, and Quality Assurance. In its original form, it was a Java project built around contact, task, and appointment classes with service classes used to add, update, delete, and manage records. It had a solid backend foundation with validation and testing, but it did not have a graphical interface, persistent storage, or even a driver class to run the program, so it still had a lot of room to grow.

## Why I Chose It

I chose this artifact because I wanted to take the core idea of the original project and turn it into one larger and more realistic application across all three enhancement categories. Even though the enhanced version was reworked to fit Spring Boot and was not just the original code copied forward, the original artifact still gave me the starting point for the data model, project purpose, and overall direction.


## Features Added

- **Web GUI:** I built a web based interface so the enhanced application could be used through a browser instead of only existing as backend classes with no real user interaction.

![Gui](docs/images/gui.png)

- **PostgreSQL Database Persistence:** I moved the application from temporary in memory storage to PostgreSQL so contacts, tasks, and appointments would persist and the project would feel more like a real system.

- **Data Validation:** I carried validation into the enhanced application so user input could be checked more carefully before being stored or processed.

![Data Validation](docs/images/dataValidation.png)

- **Sorting:** I added sorting features to make the data easier to organize and use, including alphabetical sorting for tasks and contacts and date based sorting for appointments.

- **Searching:** I added search features for contacts, tasks, and appointments so records could be found more easily and used in a more organized way.

![Gui](docs/images/SortSearch.png)

- **User Authorization:** I added user authorization to make the application more realistic by controlling access instead of allowing every user to reach everything.

![Login](docs/images/login.png)

- **Centralized Error Handling:** I added centralized exception handling so the application could respond to problems in a cleaner and more consistent way.

## Enhancement One: Software Design and Engineering

For the software design and engineering enhancement, I reworked the original backend only project into a Spring Boot web application with controllers, Thymeleaf pages, reusable fragments, JavaScript for tab behavior, and centralized exception handling. I wanted to use this enhancement because it showed that I could take the original project idea and rebuild it into something more complete, more professional, and much easier for a person to actually interact with.

[Enhancement One Journal](docs/files/enhancement-1.docx)

## Enhancement Two: Algorithms and Data Structures

For the algorithms and data structures enhancement, I added search and sorting features for contacts, tasks, and appointments. I wanted to use this enhancement because it gave me a way to show algorithmic thinking, time complexity, and trade offs without pretending the goal was just to make everything magically faster. The bigger improvement was making the project more organized and better prepared for cleaner retrieval as it grew.

[Enhancement Two Journal](docs/files/enhancement-2.docx)

## Enhancement Three: Databases

For the database enhancement, I moved the project from temporary in memory storage to PostgreSQL so the data would persist, and I also added user authorization. I wanted to use this enhancement because it made the application feel much more realistic and gave me a way to show database integration, persistence, CRUD work, and a stronger focus on controlling access to stored data.

[Enhancement Three Journal](docs/files/enhancement-2.docx)

## Course Outcome One

This project supports collaborative environments and decision making by making the application easier to understand, easier to use, and easier to review. The cleaner structure and web interface make it more accessible to users and other stakeholders than the original backend only version.

## Course Outcome Two

This project supports professional quality oral, written, and visual communication in a few different ways. The Spring Boot web interface improved the visual presentation of the project by turning it into something a user could actually navigate and understand, while the narratives, self assessment, and code review explain the technical decisions behind the work in a way that is easier for instructors, employers, and other nonuser audiences to follow. The GitHub Pages portfolio also supports this outcome by presenting the project in a clear and organized way instead of just dumping files in one place.

## Course Outcome Three

This project supports algorithmic problem solving through the search and sorting enhancements and through discussion of time complexity and design trade offs. A big part of this enhancement was not just making the features work, but improving how the data was organized and used.

## Course Outcome Four

This project supports the use of well founded and practical computing tools by using Spring Boot, Thymeleaf, PostgreSQL, layered application structure, validation, and authorization to build a more complete solution. These enhancements made the project more useful, more realistic, and closer to how a modern full stack application is actually built.

## Course Outcome Five

This project supports a security mindset through validation, cleaner error handling, database use, and user authorization. As the application became more realistic, security became more important, especially when dealing with stored data, user input, and controlling access to different parts of the system.


