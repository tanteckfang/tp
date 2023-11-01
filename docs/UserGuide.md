---
layout: page
title: User Guide
---
![NUSCoursemates](images/Logo.jpg)
NUSCourseMates is a **desktop app for managing your SoC friends contacts and their courses, optimized for use via a** [Command Line Interface (CLI)](https://www.w3schools.com/whatis/whatis_cli.asp) while still having the benefits of a [Graphical User Interface (GUI)](https://en.wikipedia.org/wiki/Graphical_user_interface). If you can type fast, NUSCourseMates can get your contact management tasks done faster than traditional GUI apps.

### Table of Contents
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------
## Using this Guide

Welcome to the NUSCoursemates User Guide, your essential companion for navigating and maximizing the full potential of our platform. Whether you're a novice just stepping into the world of NUS SoC student connections or a seasoned expert seeking new ways to enhance your experience, this guide is tailored to meet your needs.

NUSCoursemates is designed with simplicity in mind, and you don't need any prior knowledge or experience to get started. We'll walk you through every step, from the basics of setting up your profile to advanced features that empower you to make the most of your SoC connections.

**Novice Users:** For those taking their first steps with NUSCoursemates, our [Quick Start Guide](#quick-start) will be your trusted ally, providing a seamless entry into the world of SoC networking.

**Amateur Users:** You will find the answers you seek and step-by-step instructions for customizing NUSCoursemates to your preferences by exploring our comprehensive [table of contents](#table-of-contents).

**Seasoned Users:** We've streamlined your access to crucial information with our [command summary](#command-summary) and prefix summary, allowing you to find what you need with ease.

Let's embark on this journey together, connecting NUS SoC students like never before.

Here are some symbols that will give you a more enjoyable time using our guide: 

| Symbol               | Meaning                                                                                        |
|----------------------|------------------------------------------------------------------------------------------------|
| :information_source: | Note. Provides additional information.                                                         |
| :bulb:               | Helpful tip that will improve your experience.                                                 |
| :exclamation:        | Warning. Attempting to perform an action with a warning will lead to undesirable consequences. |

<div markdown="block" class="alert alert-info">
**:information_source: Notes about the command format:**<br>
* These symbols will be encapsulated in a box as such.
</div>

--------------------------------------------------------------------------------------------------------------------
## User Interface
In NUSCoursemates, we've designed our user interface with your convenience and ease of use in mind. Let's take a closer look at the key components of our user interface:
![Labelled GUI](images/LabelledUI.png)

| No  | Component          | Description                                                                                                                                           |
|-----|--------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | Menu Bar           | Provides access to various commands, including options to switch between dark and light mode, and other miscellaneous features.                       |
| 2   | Command Box        | The Command Box is where you can input commands to interact with NUSCoursemates. You can execute a wide range of operations through this input field. |
| 3   | Command Result     | Displays the results and feedback for the executed commands. It provides information and feedback on the outcomes of your actions.                    |
| 4   | Student List Panel | Presents a list of students, and it is where you can view your fellow student records.                                                                |
| 5   | Course List Panel  | Displays a summary of all the courses in your address book, along with the total number of students in each course.                                   |
| 6   | Tag List Panel     | Displays a summary of your tags, including options like 'Friend,' 'Close Friend,' and 'Emergency.'                                                    |

### 1. Menu Bar
<img src="images/MenuBar.png" alt="MenuBar" height="30"/>

The Menu Bar is your command center, offering access to a variety of functions, including the ability to switch between dark and light modes, and other useful features.

| Menu Item | Description                                                             |
|-----------|-------------------------------------------------------------------------|
| File      | Exit the application to close it.                                       |
| Theme     | Choose between Light or Dark mode for your preferred look.              |
| Feedback  | Share your thoughts and suggestions with us through the feedback link.  |
| Help      | Access the User Guide to get assistance and answers to your questions.  |

### 2. Command Box
The Command Box is where the magic happens. It's your gateway to NUSCoursemates, allowing you to input commands and perform a wide range of operations with ease.

You can locate the list of commands you can perform in our [Command Summary](#command-summary).
### 3. Command Result
<img src="images/CommandResult.png" alt="CommandResult"/>

The Command Result section is your information hub. Here, you'll find the outcomes and feedback from your executed commands, helping you stay informed about the impact of your actions.

### 4. Student List Panel
<img src="images/StudentListPanel.png" alt="StudentListPanel"/>

The Student List Panel simplifies your connections. It provides a list of fellow students, offering a convenient way to explore and manage student records, fostering collaboration and community.

You will be able to view each student's details such as:
* Phone number
* Address
* Telehandle
* Email
* Courses
* Tags

### 5. Course List Panel
<img src="images/CourseListPanel.png" alt="CourseListPanel"/>

The Course List Panel is your academic overview. It presents a summary of all the courses in your address book, along with the total number of students in each course. It's your academic compass.

e.g. `MA2001: 2` means that there are 2 students in NUSCoursemates that takes MA2001.

### 6. Tag List Panel
<img src="images/TagListPanel.png" alt="TagListPanel"/>

The Tag List Panel allows you to personalize your connections. Here, you'll find a summary of your tags, including options like 'Friend,' 'Close Friend,' and 'Emergency.' It helps you categorize and manage your contacts with ease.

e.g. `Friend: 3` means that there are 3 students in NUSCoursemates that have "Friend" tag.

--------------------------------------------------------------------------------------------------------------------
## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `NUSCourseMates.jar` from [here](https://github.com/AY2324S1-CS2103T-T17-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your NUSCourseMates.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar NUSCourseMates.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 c/cs2101 c/cs2103t` : Adds a contact named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/close friend`, `t/friend t/emergency` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

## Basic Administration
This subsection covers the basic processes that you will encounter when adding students to NUSCoursemates.

### Adding a student: `add`  
> "Every new friend is a new adventure…the start of more memories."
> — Patrick Lindsay

Embrace the opportunity to expand your circle and make lasting connections by adding new friends to your address book. Our user-friendly "Add" feature makes it simple and convenient to do just that.

**How to do it:** With the `add` command, you can include a variety of details to create a comprehensive profile for your new friend. Here's what each element represents:

Format: `add n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [th/TELEHANDLE] [t/TAG]… [c/COURSE]…​`

* `n/NAME`: Your friend's name, because every name carries a unique story.
* `p/PHONE_NUMBER`: Their contact number, ensuring you're always just a call or message away.
* `e/EMAIL` (optional): Include their email address, making digital connections seamless.
* `a/ADDRESS` (optional): Specify their physical address, ideal for planning meetups.
* `th/TELEHANDLE` (optional): Provide their telehandle, ensuring quick and easy communication.
* `t/TAG` (optional): Categorize your friend with relevant tags, simplifying your contact management.
* `c/COURSE` (optional): Associate your friend with the courses they are enrolled in, for easy reference in your academic journey.


<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>
* You can include any number of tags or courses (including none).
* Only three tag types are allowed: 'Friend,' 'Close Friend,' and 'Emergency.'
* To add a 'Close Friend' tag, use t/cf (case-insensitive).
* Tags and Courses are case-insensitive when entered.
</div>

<div markdown="span" class="alert alert-warning">

**:exclamation: Caution:** <br>
* A student **MUST** have a name and phone number.
* Duplicate students are identified by their names; ensure the name is unique.
* Make sure the courses you add exist and are valid.
* You can tag up to two contacts with the 'Emergency' tag.
</div>

Examples:
* `add n/John Doe p/81234567 e/John@gmail.com a/123 NUS Rd th/@johnny t/close friend c/CS1231S c/CS2103T`
* `add n/Bob Lee p/91234567 e/BL@gmail.com a/123 Clementi Rd th/@boblee c/CS2030S c/CS2040S c/GEA1000 c/NUR1113a`
* `add n/Tom Lee p/81289900`

### Listing all students : `list`

Discover the power of the "List" feature – your ultimate tool for staying organized and in the know about your student contacts. It's like having your address book at your fingertips, ready to provide you with a clear, comprehensive view of your network.

**How to do it:** With the straightforward `list` command, you can effortlessly generate a list of all the students in your address book. It's as simple as typing "list."

Format: `list`

Examples:
![list](images/ListFeature.png)


### Editing a student : `edit`

Edits an existing student in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [th/TELEHANDLE] [t/TAG]…​ [c/add-COURSE_TO_ADD]…​ 
[c/del-COURSE_TO_DELETE]…​ [c/ORIGINAL_COURSE-NEW_COURSE]…​`

* Edits the student at the specified `INDEX`. The index refers to the index number shown in the displayed student list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags or courses by typing `t/` or `c/` respectively without
    specifying any tags after it.
* Here are the 3 types of course modifications:
  1. To add a course, use c/add-[COURSE_TO_ADD]. 
  2. To delete a course, use c/del-[COURSE_TO_DELETE].
  3. To edit a course directly, use c/[ORIGINAL_COURSE-NEW_COURSE].
* The three types of course modifications can be chained together in any amount in a single command.
  * However, the collective chain of modifications will not be executed if any one modification in the chain is invalid.
  * Invalidity arises from either:
  
     (1) Invalid course provided (i.e. CS210333) 
  
     (2) The course you are trying to delete (Type ii) or the course you are trying to modify directly (Type iii) does not exist. There are two possible reasons:
      1. The student does not have the specified course originally. if a student does not have CS2103T originally, performing "c/del-CS2103T" alone will cause an error.
      2. The student has the specified course originally, but because you can chain a list of modifications together, and the modifications are performed in order, it is possible that the course might not exist after a certain change. Performing "c/del-CS2103T c/del-CS2103T" will cause an error, because the first change is performed before the second, and CS2103T does not exist after the first change.

  
Examples:
*  `edit 1 p/91234567 e/johndoe@example.com c/add-MA1521 c/del-CS2103T c/MA2001-ST2334` Assuming the first person in the address book list has courses CS2103T and MA2001 originally, this command edits his phone number and email address to be `91234567` and `johndoe@example.com` respectively, and performs the following course modifications in order: add MA1521, delete CS2103T (valid because CS2103T exists originally), change MA2001 to ST2334 (valid because MA2001 exists originally). The first person now has courses MA1521 and ST2334. 
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
   
Before:
![edit student](images/editFeatureBefore.png)

After:
![edit student](images/editFeatureAfter.png)

### Locating students by name: `findstudent`

Finds students whose names contain any of the given keywords.

Format: `findstudent KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `findstudent John` returns `john` and `John Doe`
* `findstudent alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'findstudent alex david'](images/findAlexDavidResult.png)

### Discover Coursemates with `findcourse`

Ever wondered who in your address book has taken the same courses as you? With `findcourse`, you can effortlessly locate fellow NUS SoC students you've saved who have enrolled in specific courses.


Here’s how to make the most of this handy tool:

Format: `findcourse KEYWORD [MORE_KEYWORDS]`
* Case-Insensitive: Type in any case, like 'cs2030s' or 'CS2030S', and we'll find a match.
* Search By Course Names: This tool zeroes in on the course names associated with your contacts, giving you precise results.
* Partial Words Are Okay: Entering 'CS2030' will identify students who have taken both 'CS2030' and 'CS2030S'.
* Multiple Course Searches: Use multiple keywords, and we'll show you students who have enrolled in any of the courses. For instance, 'cs210' will reveal students who took 'CS2103' or 'CS2106'.


Examples:
* `findcourse cs2030s` returns `CS2030` and `CS2030S`
* `findcourse cs2103t ma1521` returns `CS2103T` and `MA1521`

  ![result for 'findcourse CS2103T MA1521'](images/FindCourseCS2103TMA1521.png)


### Deleting a student : `delete`

> "It's really amazing when two strangers become the best of friends, but it's really sad when the best of friends become two strangers."
> — Unknown

Deletes the specified student from the address book.

Format: `delete INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​
* The deleted student will no longer appear when the `findcourse`, `findstudent` or `list` commands are entered.

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

![delete student](images/deleteFeature.png)


### Sorting by Courses: `sort course`

Picture this: Your NUS address book is teeming with contacts, each with their unique set of courses. Curious about who's taken on the most courses or who's just starting out?

At its core, the `sort course` command rearranges your address book, bringing those with the most courses to the forefront in **descending order**.

For a twist in perspective, and to cheer on those just embarking on their academic journey, use `size-ascending`. This flips the narrative, showcasing contacts with fewer courses in **ascending** order.

#### Format: `sort course`
* Revel in the contacts who've ventured into many courses, displayed in **descending order**.

Example:
Before Sorting:
![initial](images/BeforeSorting.png)

After `sort course`:
![sourse_course](images/SortCourse.png)

#### Format: `sort course size-ascending`:
* Highlight the newcomers, those with the fewest courses, arranged in ascending order.

Example:
Before Sorting:
![initial](images/BeforeSorting.png)


After `sort course size-ascending`:
![sort_course_size_ascending](images/SortCourseAscending.png)

### Clearing all entries : `clear`
>"Every sunset is an opportunity to reset. Every sunrise begins with new eyes."
> — Richie Norton

Clearing all entries is your path to a new chapter in your NUSCoursemates. In NUSCoursemates, we've made it easy for you to clear all student entries when needed.

This feature helps you start fresh or declutter your address book with a single command. Follow the simple steps below to clear all entries from your address book:

Format: `clear`

Examples:
![result for 'clear'](images/Clear.png)


<div markdown="span" class="alert alert-warning">

**:exclamation: Caution:** <br>
* Once you run this command, you lose all data immediately.
</div>

## Additional Features
Congratulations, you've reached the end of our user guide, and that's a job well done! We know it's a lot of information to digest, but don't worry. We've got your back.

But before you go, let's talk about a few extra features that can make your NUSCoursemates experience even better. We've designed these features with you in mind, making sure your journey with us is as seamless as it gets.

### Seeking help : `help`
> "Ignorance has always been the weapon of tyrants; enlightenment the salvation of the free."
> — Bill Richardson

Still feeling a little lost? Just type "help" to access our User Guide and find the issue you are facing. Alternatively, you can simply click on the help button located on the Menu bar. It is as simple as that.

Once you use the help command, you'll receive a message containing a hyperlink to our comprehensive User Guide.

Format: `help`

![help message](images/helpMessage.png)

<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>
* If your command isn't recognized and you see "Unknown command," simply check your spelling and try again. Avoid variants like "helps" or "HELP."
</div>

### Providing Valuable Feedback : `feedback`
> "Your voice is the most powerful tool you have. Be the change you want to see."
> — Anonymous

When you use the feedback command, you'll receive a message containing a link to our dedicated Google feedback form. Alternatively, you can simply click on the feedback button located on the Menu bar. Your journey towards change starts there.

Format: `feedback`

![feedback message](images/feedbackMessage.png)
<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>
* If your command isn't recognized and you see "Unknown command," simply check your spelling and try again. Avoid variants like `feedbacks` or `FEEDBACK`."
</div>


### Exiting the program : `exit`
> "The pain of parting is nothing to the joy of meeting again."
> — Charles Dickens

When you're ready to take a break or end your session, simply use the `exit` command.
Alternatively, you can also click the close button on the window to exit. It's like closing the door on your way out, knowing that your friends will be right here when you return.

Format: `exit`

<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>
* Your data would be saved automatically, feel free to exit anytime!
* If your command isn't recognized and you see "Unknown command," simply check your spelling and try again. Avoid variants like `exits` or `EXIT`."
</div>


### Saving the data

NUSCourseMates data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

NUSCourseMates data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, NUSCourseMates will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ
**Q**: How do I check the Java version I am using?<br>
**A**: Open the Terminal application (if you are using MacOS) or Command Prompt (if you are using Windows). Type `java -version` and hit Enter. The first number that appears in the response refers to the Java version you are currently using.    

**Q**: How do I install Java 11, the Java version required by NUSCourseMates?<br>
**A**: You may download Java 11 from this [link](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html).  

**Q**: I accidentally closed the application. Is my data lost?<br>
**A**: Fret not! NUSCourseMates saves your data after every change you make, so you won't lose any data.

**Q**: Do I need an active internet connection to use NUSCourseMates?<br>
**A**: You can use NUSCourseMates offline, but you'll need an internet connection to download it to your device.  

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous NUSCourseMates home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action           | Format, Examples                                                                                                                                                                                                                                                               |
|------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**          | `add n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [th/TELEHANDLE] [t/TAG]… [c/COURSE]…​` <br> e.g., `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 c/cs2101 c/cs2103t`                                                                         |
| **Clear**        | `clear`                                                                                                                                                                                                                                                                        |
| **Delete**       | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                                                                            |
| **Edit**         | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [th/TELEHANDLE] [t/TAG] [c/add-COURSE_TO_ADD] [c/add-COURSE_TO_DELETE] [c/ORIGINAL_COURSE-NEW_COURSE]…​`<br> e.g.,`edit 1 p/91234567 e/johndoe@example.com c/add-MA1521 c/del-MA1521 c/add-MA2001 c/MA2001-ST2334` |
| **Find Student** | `findstudent KEYWORD [MORE_KEYWORDS]`<br> e.g., `findstudent James Jake`                                                                                                                                                                                                       |
| **Find Course**  | `findcourse KEYWORD [MORE_KEYWORDS]`<br> e.g., `findcourse CS2103T CS2040S `                                                                                                                                                                                                   |
| **Sort**         | `sort SORT_CRITERION`<br> e.g., `sort name`                                                                                                                                                                                                                                    |
| **List**         | `list`                                                                                                                                                                                                                                                                         |
| **Help**         | `help`                                                                                                                                                                                                                                                                         |
| **Feedback**     | `feedback`                                                                                                                                                                                                                                                                     |
