# Habit Tracker App

## Project Description

The Habit Tracker app is an application that can help users to track and manage their habits. The app can create and delete habits. The streak for each habit can also be viewed. Firebase Firestore and Authentication were used for storing user and habit data.

### Key Features:
- Create and delete habits
- Display streak for habits
- Firebase integration
- User-friendly UI

## Getting Started

### Prerequisites
Before running the project, you need to have following setup:

* Android Studio
* Firebase account
* An android device or emulator

### Setup Firebase
In order to use Firebase with this application you need to setup the Firebase inside the project by configuring the google-services.json file.

### Running the Project
To run the project, follow these steps:

1. Clone the repository from github.

2. Open the project in Android Studio.

3. Link project to Firebase.

4. Run the application on either an emulator or a physical device.

## Testing the App
After running the app, you can:

- Register
- Login
- Create a new habit.
- Delete a habit.

All data will be stored in Firebase Firestore and will not be lost even if the app is closed.

## Project Structure
- com.example.habittracker.ui: UI-related fragments.
- com.example.habittracker.adapter: HabitAdapter for habits listing.
- com.example.habittracker.data.model: Data model classes for Habit and User.
- com.example.habittracker.repository: HabitRepository that interacts with Firebase.
- com.example.habittracker.viewmodel: Includes the ViewModel, which manages data with UI.

## Contributions

### Team Members and Contributions

*Nazlı Çiçek Özbek:*

- Designed and implemented the UI for the app.
- Integrated Firebase Firestore and Firebase Authentication for data storage and user management.
- Implemented the habit management functionality (Create, Read, Delete).

*Emirhan Tarlabaşı:*

- Assisted with setting up the Firebase Firestore and Firebase Authentication.
- Worked on the UI design for habit detail and create habit screens.
- Conducted testing and debugging of the app.

*Yiğithan Kaptan:*

- Contributed to writing the ViewModel and Repository for managing habit data.
- Ensured seamless navigation between fragments.
- Implemented animations and designed the UI for the app.