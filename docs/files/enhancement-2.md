# Enhancement-2

[Home](../README.md)

 Just like the last enhancement, I chose this artifact for the same reasons. It gave me a good starting point to keep building on a project I already understood while also showing a clear before and after improvement. The artifact was originally created in CS 320 as a Java project that used simple in memory lists and manual lookups for contacts, tasks, and appointments. For this enhancement, I moved the project to a database a little earlier than required because I knew that would make it easier to build the search and sort features I wanted for this milestone. That change was not really about making everything instantly faster. In the original version, searching a list was generally a linear O(n) operation, and without indexing, PostgreSQL sequential scans are also O(n). The real benefit was replacing the old list based structure with something that made the project more realistic and better prepared for organized retrieval. Moving to PostgreSQL also creates the possibility for future indexing improvements, although that was not the main focus of this milestone.

 The main improvement in this enhancement was adding search and sorting features to the project. Tasks can now be searched and sorted alphabetically, appointments can be searched by description and sorted by date, and contacts can be searched and sorted by name in a more organized way too. Sorting adds more processing, usually around O(n log n), but it also makes the data much easier to use and better organized for the user. I think this enhancement fits Course Outcome 3 well because it focuses on algorithmic thinking, time complexity, efficiency, and the trade offs involved in design choices.

 One thing I learned from this enhancement is that improving algorithms and data structures is not always about making something dramatically faster right away. Sometimes it is more about building a better foundation so the project can grow and handle data in a cleaner way. The biggest challenge was keeping this milestone focused on algorithms and data structures instead of letting it turn into mostly a database or user interface update. Overall, I think I met the goal I planned in Module One because I improved how the project organizes, searches, and sorts data while making it feel more like a real application.


[Home](../README.md)
