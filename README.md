# Row/Column Mastery: Settings Screen


# 1. What the App Does

This Android application demonstrates a Settings screen built using Jetpack Compose and Material 3 components. The screen features a top app bar labeled Settings and includes multiple setting rows structured using proper Row and Column layout patterns. The app provides interactive toggle controls such as Switches and Checkboxes, as well as adjustable sliders for Volume, Brightness, and Text Size. A Save button is included at the bottom of the screen, which displays a Snackbar confirmation message when clicked. Each setting row, except those that require a slider, uses a Row as the main container with a Column on the left for the title and supporting text and an interactive control aligned on the right.


# 2. Screenshot of the Running App

<img width="400" height="750" alt="Screenshot_20260222_222647" src="https://github.com/user-attachments/assets/7dcc1fd2-440e-4d50-9320-b6ece9d107b9" />

<img width="400" height="750" alt="Screenshot_20260222_222700" src="https://github.com/user-attachments/assets/36e39dd6-c1e3-4f29-8f42-cc7c4f84bae2" />


# 3. Device / Emulator / SDK Version

- **Emulator Device:** Medium Phone API 36.1 (Android 16.0 ("Baklava"))      
- **Minimum SDK:** 26  
- **Target SDK:** 36


# 4. AI Disclosure

While working on this assignment, I utilized ChatGPT in several ways. ChatGPT helped me understand more about the Modifier and its components like weight, align and heightIn. I found myself confused at moments about how to properly move the text to the center or how to bring things closer/move them further apart. When I ran into problems with controls being misaligned or sliders truncating text, ChatGPT helped me identify that I needed to actually handle the rows with sliders differently compared to the rows without. This helped me realized that I wouldn't be able to get the sliders to stay on the right side with the approach I was taking, allowing me to reevaluate my approach and make the necessary changes. I also ran into a lot of issues with pushing my code to my git repository, so I had to work with Chat to figure out where the issue lied and properly push everything. There were several suggestions I did not take from Chat, one of them being its suggestion to just make one large composition function instead of breaking it down when I was struggling with spacing. I found that approach to look messy and inefficient especially when it came to testing. 

