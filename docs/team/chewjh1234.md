---
layout: page
title: Chew Jing Heng's Project Portfolio Page
---

## Project: NUSCourseMates

### Overview
NUSCourseMates is a desktop address book application used for keeping track of the courses your contacts are taking. 
The user interacts with it using a Command Line Interface (CLI), and it has a Graphical User Interface (GUI) created with JavaFX. 
It is written in Java, and has about 10 kLoC.

### Summary of Contributions
Given below are my contributions to the project.
[Full contribution on RepoSense](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=chewjh1234&breakdown=true)
  
#### New Feature - Sort by Name
Added this feature which allows users of the application to sort the student contacts by name. 

Before this feature was implemented, new contacts were added to the bottom of the address book which meant that the address book could get messy very easily. With this feature, contacts are sorted by name, and it will take the user much less time to search for the contact they want by name, thereby improving user experience. 

The user is also able to specify whether the contacts are to be sorted in an **ascending** or a **descending** alphabetical order with the `sort name-ascending` and `sort name-descending` commands respectively. The names are first converted to upper case names before they are being compared using a comparator. 

Credits: None

#### New Feature - Sort by Course
Added this feature which allows users of the application to sort the student contacts by the number of courses taken. 

With this feature, users are able to determine the contacts that have the largest number of overlapping courses as them. This helps users to decide the courses they should take in the semester and to also connect with these contacts, which are the main goals of **NUSCoursemates**.  

The user is also able to specify whether the contacts are to be sorted in an **increasing** or a **decreasing** number of courses taken with the `sort course size-ascending` and `sort course size-descending` commands respectively. The course sizes are compared using a comparator. 

Credits: None

#### New Feature - Sort by Tags
Added this feature which allows users of the application to sort the student contacts by their tags.

Similar to how our Instagram close friends' stories will appear first, the Sort by Tags function allows users to sort their contacts by tags, so that the users' close friends would appear right at the top of **NUSCoursemates**. This allows users to better keep track of the people who matter to them the most.

As students can have multiple tags, only the highest priority tag will be taken into consideration. This is done by iterating the list of tags, to find the one with the highest priority. 

Credits: None

#### Project management
* to be added soon

#### Documentation
* User Guide
  * Added documentation for the various [sort features](https://ay2324s1-cs2103t-t17-4.github.io/tp/UserGuide.html#sorting-by-tags-sort-tags). 
  * Added the [Command Line Interface (CLI) tutorial](https://ay2324s1-cs2103t-t17-4.github.io/tp/UserGuide.html#using-the-command-line-interface-cli) 
  * Added the [Command Format section](https://ay2324s1-cs2103t-t17-4.github.io/tp/UserGuide.html#command-format)
* Developer's Guide
  * Added documentation for the various [sort features](https://ay2324s1-cs2103t-t17-4.github.io/tp/DeveloperGuide.html#45-sort-feature). 
  * Added UML diagrams (Activity diagram, Sequence diagram) for the various sort features.
  * Modify various sections (such as Product Scope). 

#### Review/mentoring contributions
* Bugs


#### Community
* to be added soon

#### Tools
* to be added soon
