# My Personal Project

## Hospital Record Manager 

This application serves as a straightforward Manager Application for Hospitals, Clinics and other medical services. 
This App will enable them to organize their patients in a neat way. Users can create data files for each patient, 
adding personal info, medical info and other important information regarding the person. The Patients are stored in a 
database where the clerk, nurse, or doctor can search for a specific patient. 

The Current **Main** Features:
- Add multiple *patients* to Records Database
- Add Person Information about patients such as age, sex, phone number etc.
- Add Medical Conditions/information to Current Patients. 

This will include a straightforward and simplistic UI for **Nurses, Clerks**, and **Doctors** to use. The patient 
records will be easy to find and will display the information in an organized manner. My goal with this project is to 
implement everything I learned in CPSC 210. I want to spread as much as I can and get the most out of this course.
By the end, I want to be able to utilise the skills I learned in this project on a harder personal project and 
continue from there. 

## User Stories

- As a User, I want to be able to add a **Patient** to the **Records**
- As a User, I want to be able to view all the patients recorded so far 
- As a User, I want to be able to select a patient and view their information
- As a User, I want to be able to select a patient and add information to them ex) Age, Sex, Etc.
- As a User, I want to be able to delete a specific patient from the records
- As a User, I want to be able to delete all the records 
- As a User, I want to add a picture of a Patient to the Patient's Records
- As a User, I want to be able to add a designated doctor to a Patient

- As a User, I want to be able to save a backup of the **patient records** to a **file**
- As a User, I want the patient records to automatically load into the program
- As a User, I want to load a patient records file into the program


**User Instruction for Grader**

To Generate the required events:
- You can open the records page by clicking on Open Records in the Main Menu
- On the records Page, you can click on any patient to view their information
- You can also click add Patient and add a patient to the records, this will be reflected in the List.
- Also, you can click delete patient when highlighted on desired patient to remove them from the records
- You can also edit the patients information by clicking on the edit button. Remember to press the save button on the
edit menu and cancel out of the menu to properly save changes.

The GUI properly displays the "Y" Object and generates enough events to satisfy the requirements

- You can generate multiple Audio Events by pressing the save button and the clear button in the main menu. This
acts as a nice prompt to let the user know the data has been saved/cleared properly. The save button plays a 
fanfare right now because I couldnt source a good save sound just yet. **Warning**: Turn Program Volume Down!
 
- You can Find the Visual Component in the records screen where you can see the Patients photo, you can also select
another photo to replace the current photo.

- The save button in the Main Menu saves the records to the data file

- The load button lets you pick a record file to load into the current program. If you want to test this, navigate to
the project files, and in the data package you will find a folder containing TestData files to test that the load functionality
works. The File Path for me is: "D:\School\CPSC210\project_c4y2b\data\testdata\testRecords.json"

**Phase 4: Task 2**

For this Task of the phase I decided to implement the first and second constructs into my project.

For the Robust Class:

- In Phase 2, I already designed my persistence classes to be robust and created tests that checked the expection for both cases. 
The Classes Writer and Reader both show that they are robust with their Constructors and Close methods throwing exceptions. 
Each respective test has two tests within itself that test when the exception is expected and when it is not. Usually exceptions
are thrown when A file cannot be found and when a file cannot be read. Another Exception is thrown if an error occurs when the writer
is writing to the file.

- Despite the fact that the above example is robust, the exceptions were not created by me so I decided to make my Patient Class and
Person Class robust aswell with my own exceptions. I did this by making sure that the numbers that the user inputs for
(Phone number and CareCard) is of correct length and format. I throw an exception if the number of digits they enter is too long
or if it contains a letter which it should not. Since these are both important fields, the program notifies the user to make sure
the numbers are in correct format and inputted without error. The Methods that are robust are SetCareCard() in the Patient Class and 
AddPhoneNumber() in the Person Class. The respective tests both test the scenarios when the numbers are inputted incorrectly and pass. 
These tests can be found in the PatientTest Class at the very Bottom.

For the Type Hierarchies

- I have decided to include two type hierarchies within my program. I noticed that there was 
significant duplication in 4 of my classes, I shifted all of the duplicated code to the abstract class and extended that abstract 
class. The first hierarchy I implemented was the PatientPanel class. This class basically contains all of the Java Swing components
that are used both in the EditPanel and DisplayPanel. Since these panels are basically Identical, the instantiations and placing could 
all be done within the abstract class. However, I needed some distinct functionality with the textFields in the EditPanel class, so I overrided
the InstantiateFields() method to make that change. This implementation really helped increase the readability of my Panel Classes which was a nice
bonus. The next type Hierarchy I implemented was the Person Class. This Abstract Class contains all of the common fields that the Professional
and Patient classes share. This reduced a lot of duplication and also helped me solve one of my Cohesion issues I had in the patient Class. The classes
Patient and Professional both extend Person and add their own respective fields on top of the ones that person has. 

**Phase 4: Task 3**

I have identified the following Problems

- My DisplayPanel Class had a lot of coupling with the RecordList Class and Records Class. The DisplayPanel class was modifying the RecordList Object
which could create problems if I were to change some of the implementation of the RecordList Class. I chose to remove the usage of RecordList in DisplayPanel
and to reroute the same functionality to the Records Class which contains the RecordList Object. 

- My Patient Class had some poor cohesion when I decided that I should designate a doctor to each patient. This was due to the fact that the patient class
 would be storing the information for a Patient and for its Doctor. At this point I decided to split Patient and Doctor(Professional) into two different 
 classes. By doing this, the Patient Class can only focus on the Patient's information and the Doctor's information will now be stored in its own class.
On top of that, I noticed that there was significant duplication with both of these classes. I decided to extract the duplication into the Abstract Class Person.

- I found that my Sound method was within my MainMenu class, which lowers the cohesion of the mainMenu class. Since the mainmenu class should only really be made 
up of code that deals with creating and adding things to the main menu panel, I decided to move the soundPlayer to its own class. This should increase the Cohesion overall.

- I decided to increase the cohesion further by removing the implementation for the DoctorPanel out of the DisplayPanel/EditPanel and made it its own class. After extracting
that chunk of code, I decided to abstract the duplication between the DisplayPanel and EditPanel Classes. This fix helped me increase the cohesion by removing the need for one
class to do two things and helped me remove duplication aswell.

- From my UML Diagram, I see that the a few Classes have associations with Manager which shows some mild coupling. After looking into the areas where I use 
the manager object in the Records, RecordList, and MainMenu class, I have come to the conclusion that the methods would not create issues if I changed the implementation
of Manager. All of these classes depend on the Save() and Reload() methods, which if they were to change in implementation, would not affect the Other Classes. If the Save() 
method was altered to save something else aswell, the code will still run and the Records, RecordList, and MainMenu classes will work as expected.

- Overall, I am satisfied with my Project. After looking at my UML Diagram, I am happy with the fact that my program has that Funnel type where everything is going down
and nothing is going back up. Despite the fact that there is still some mild coupling, I am pretty sure none of it is semantic coupling. 
