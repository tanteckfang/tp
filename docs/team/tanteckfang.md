---
layout: page
title: Teck Fang's Project Portfolio Page
---

### Project: NUSCourseMates

NUSCourseMates is a desktop address book application used for students to keep track of the modules taken by their contacts. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.


* **New Feature**: Added the ability to filter student based on module ID.
    * What it does: allows users to filter and display students enrolled in a specified course. For example, executing "findcourse MA2001" will show all students taking the course "MA2001".
    * Justification: This feature significantly improves the usability of the application for users by enabling them to quickly find peers or friends associated with specific courses.
    * Highlights: The findcourse feature's implementation necessitated a new command class, FindCourseCommand, and a predicate class, CourseContainsKeywordsPredicate, to handle the search logic. The challenge lay in integrating these new classes seamlessly with the existing architecture and ensuring that the search was both efficient and accurate. This enhancement impacts not only the user's interaction with the application but also the underlying model's data management.
    * Credits: the `find` logic in AB3 address book.


* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=tanteckfang&breakdown=false&sort=groupTitle%20dsc&sortWithin=title&since=2023-09-22&timeframe=commit&mergegroup=&groupSelect=groupByRepos)

* **Enhancements to existing features**: Streamlined the add command to require only a name and phone number.
    * What it does: The `add` command has been modified to make email and address optional when adding a new contact. Now, users can quickly input essential information (just the name and phone number) to create a new entry in their address book.
    * Justification: This modification enhances the application’s flexibility and speed of use. Users often have just the basic contact information at hand and may wish to add more details at a later stage. By reducing the number of mandatory fields, the application becomes more accessible and reduces the barrier for entry creation.
    * Highlights: To implement this feature, the underlying data validation logic was adjusted to check only for the presence of a name and phone number. Optional fields were decoupled from the core validation process, allowing for a more streamlined and user-friendly command structure. This update is particularly important for users who are interested in quickly capturing contact information without being hindered by mandatory fields that may not be immediately available. The adjustment also involved updating the user interface to reflect these new optional fields appropriately.
    * Credits: the original AB3 address book.

* **Enhancements to existing features**: Refined tagging system with predefined categories.
    * What it does: The `add` and `edit` command's tagging functionality has been overhauled to accept only three specific tag categories: 'Friend', 'Close Friend', and 'Emergency'. Tags are case-insensitive to ensure user convenience and consistency. For instance, inputting 'friend', 'FRIEND', or 'friEnd' will all categorize the contact as 'Friend'. Additionally, 'cf' is recognized as a shortcut for 'Close Friend'. The 'Emergency' tag is limited to a maximum of two contacts to emphasize its importance and to keep these contacts readily accessible.
    * Justification: This update introduces a standardized tagging system to help users organize their contacts more efficiently and with greater significance. Limiting the tags to predefined categories eliminates arbitrary tag creation, leading to a more uniform and less cluttered address book. The case-insensitivity feature acknowledges the varied ways users may input data, thus reducing errors and improving user experience. The special restriction on the 'Emergency' tag underscores the critical nature of these contacts and ensures that they remain prominent and unobstructed by less urgent entries.
    * Highlights: Implementing this feature required creating a robust tagging validation system that recognizes and corrects case variations and interprets shortcuts like 'cf' for 'Close Friend'. Moreover, enforcing the limitation on 'Emergency' tags involved designing a check mechanism to count and restrict the number of contacts with this tag. This ensures the system remains exclusive for the most crucial contacts. The UI has been updated to guide users in using the new tagging system effectively, including prompts and error messages for incorrect tag usage. This feature’s introduction necessitated careful consideration of user workflow and error handling to maintain a balance between user autonomy and system constraints.

* **Enhancements to existing features**: Refined the find command to findstudent to align with the findcourse command for consistency.


* **Documentation**:
    * User Guide:
        * Added documentation for the features `findcourse` and `findstudent`.
        * Added some specification for the changes in `Tag`.
    * Developer Guide:
        * Added documentation for the features `findcourse`, `findstudent`, added activity diagram and sequence diagram for both of these features.
        * Added documentation for the feature `Tag`, added activity diagram, sequence diagram and class diagram for it.

* **Community** :
    * PRs reviewed: [#124](https://github.com/AY2324S1-CS2103T-T17-4/tp/pull/124),[#149](https://github.com/AY2324S1-CS2103T-T17-4/tp/pull/149), [#232](https://github.com/AY2324S1-CS2103T-T17-4/tp/pull/232)
    * Posted an issue about an error I faced but resolved it myself and share my solution in forum: [395](https://github.com/nus-cs2103-AY2324S1/forum/issues/385)
    * Reported bugs and some suggestions for other team during PE Dry Run:  [1](https://github.com/tanteckfang/ped/issues/1), [3](https://github.com/tanteckfang/ped/issues/3),[7](https://github.com/tanteckfang/ped/issues/7)


