## ITIS/CS 5180 Mobile Application Development (In Class Assignment 3)

**Basic Instructions:**
1. Each team is required to submit the assignment on Canvas.
2. Please download the support files provided with this assignment and use them when
implementing your project. 3. Submission details:
a. Compress the contents of your project folder. The file name is very important and should follow the following format: InClass03.zip
b. Only one group member is required to submit on behalf of the whole group.
c. You should submit the assignment through Canvas: Submit the zip file.
4. The required Android Virtual Device (AVD) should have minimum SDK version set
to 25 and target SDK at 29.
5. Failure to follow the above instructions will result in point deductions.

![](https://drive.google.com/uc?id=1TR4_Ttr0lLTKy9pIWJ1yTPAZVqHlvaNd)

In this assignment, you will get familiar with intents and how to pass data between multiple activities. You are required to develop a very simple “My Profile Builder” application that enables a person to enter and edit their information. This assignment is composed of two activities namely: My Profile (main activity) and Display My Profile.

**Part 1 (My Profile Activity, 80 points):**

This activity contains, two EditTexts, one ImageView, One RadioGroup, and one Save button. Please implement the following functionalities:

1. When the app loads, it should look like Figure 1(a), use a default image for the
ImageView when no radio button is selected.
2. You should be able to put first name and last name in the corresponding EditTexts.
Use hints to display the hints, ‘First Name’ and ‘Last Name’. See Figure 1(b).
3. You should be able to select the gender from two options: Male and Female. Use a RadioGroup of two RadioButtons to implement that, as it is shown in Figure 1(b). Upon clicking on the option you select (Male or Female), the ImageView needs to
load the corresponding image. Use the images provided with the support files.
4. Clicking on the Save Button should start Display My Profile activity. Start this activity
for result.

**Part 2 (Display My Profile Activity, 20 points):**

1. This activity contains an ImageView, two TextViews, and a Button.
2. It should display the avatar, and the name as it is shown in Figure 1(c and f).
3. Name should be created concatenating the first and the last names.
4. Clicking on the Edit button should send the Data to My Profile Activity and finish the this activity. In My Profile activity, onActivityResult(), load the image and the other data in the corresponding EditTexts to allow the user to edit them, as it is shown in Figure 1(d and e).
