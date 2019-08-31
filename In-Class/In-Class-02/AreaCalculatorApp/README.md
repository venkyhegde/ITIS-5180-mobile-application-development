**ITIS/CS 5180 Mobile Application Development**
    **In Class Assignment 2**

    > **Basic Instructions:**

    1.  In every file submitted you MUST place the following comments: a. Assignment #.
    b. File Name.
    c. Full name

    2.  Each team is required to submit the assignment on Canvas.

    3.  Please download the support files provided with this assignment and use them when

    implementing your project.

    4.  Submission details:

    a. Compress the contents of your project folder. The file name is very important and

    should follow the following format: InClass02.zip
    b. Only one group member is required to submit on behalf of the whole group. c. You should submit the assignment through Canvas: Submit the zip file.


    5. The required Android Virtual Device (AVD) should have minimum SDK version set to 23 and target SDK at 29.

    ---
    Today we are building our first Android application. The name of the application is “Area Calculator.” This consists of a single activity. The app should be able to calculate the area of a Triangle, a Square, and a Circle. Please follow the instructions to develop the app.

    ![enter image description here](https://lh3.googleusercontent.com/TYZxxOTIbP9mtgNy4lMpWwKl4zZdMo7AZqS-We5sB3EpTQstvKflsmUkGtG75anMMq_qVBWqzd6g)

    **Part 1: Using EditTexts and TextViews(10 points)**

    There should be two EditTexts to take inputs, see Figure 1 (a). You should label these as Length 1, and Length 2. These will be used to take inputs. There will also be two TextViews: (1) TextView for clicked image indicator, and (2) TextView to display result.

    **Part 2: Using Images, and Add actions (60 points):**

    You need to import three images to Android studio from the resources folder and place it on screen as they are in Figure 1 (a). Three images represent a triangle, a square, and a circle.

    1.  For Triangle, you will need two inputs to calculate the area. Length 1 represents the

    height, and Length 2 accounts for the Base.

    2.  Clicking on the image of the triangle should let your app calculate the area of the

    triangle, see Figure 1(b). It should set the text to the first TextView as “Triangle.”

    3.  Both of the InputTexts must be active and visible for taking data.

    4.  For Square, you will need to know only one input. You will be using Length 1 as the

    input here.

    5.  Clicking on the Square image should hide the second EditText, Length 2. See figure

    1(d, and e). It should also change the TextView to “Square.”

    6.  Length 1 should be active and ready to take input. It is used as the length of the

    side.

    7.  For Circle, it is the same as a Square. You need to know only the radius of it. So,

    Clicking on the Circle image should also hide Length 2, and change the TextView to

    “Circle.”

    8.  Clicking on the Triangle image again should activate Length 2 again, and make it

    ready to take input.


    **Part 3: Using Buttons, and TextView (30 points):**

    Now you will learn how to calculate the are using buttons.
    1. For the triangle, you need to read Length 1 and 2. Clicking on Calculate button

    should take two inputs and use the following formula to calculate the area. 1. Area of triangle = 0.5 x Length1 x Length 2.

    2.  You need to display the result in a TextView, see figure 1.

    3.  For Square, the formula is: Area = Length 1 x Length 1

    4.  And for Circle, the formula is: Area = 3.1416 x Length 1 x Length 1

    5.  Clicking on the Clear butto

    n should clear all the EditTexts, and change the first

    TextView as it is displayed in figure 1(a).


    **Notes:**

    1.  Inputs should be floats.

    2.  When the app starts, the first TextView should display the message, “Select a

    shape”, see Figure 1(a).
