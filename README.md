# CharacterViewer

CharacterViewer is an Android app that displays information about different characters. The app uses the following libraries and frameworks:

- Coroutines for asynchronous programming
- Navigation Component for navigating between screens
- Different flavors to showcase character details as well as a list

## Getting Started

To get started with the app, you can clone the repository and open it in Android Studio:

git clone https://github.com/SKGitKit/CharacterViewer.git


The app has two flavors: `simpson` and `wire`. Each is for a specific show but they each have a shared codebase.



You can also build and run the app from within Android Studio by selecting the appropriate build variant from the Build Variants panel.


## ScreenShots

<img src="https://user-images.githubusercontent.com/123601466/234559470-1ee83d95-4e94-43aa-8987-43103c0503ca.png" alt="Example Image">
<img width="451" alt="phone_detail_Vertical" src="https://user-images.githubusercontent.com/123601466/234559752-0b8feb0d-00de-493a-b1b4-5c910a3bcc58.png">
<img width="919" alt="phone_search_horizontal" src="https://user-images.githubusercontent.com/123601466/234559757-a5c35eba-47e9-46f1-bf72-de75738f8500.png">
<img width="453" alt="phone_search_Vertical" src="https://user-images.githubusercontent.com/123601466/234559758-40d7976b-7063-4628-971e-cf0d08eca549.png">
<img width="1005" alt="Tablet_Horizontal" src="https://user-images.githubusercontent.com/123601466/234559760-d6eee889-709f-4f63-af45-1743784730ab.png">
<img width="807" alt="Tablet_Vertical" src="https://user-images.githubusercontent.com/123601466/234559762-96fc0bf8-2580-4dfb-820c-6303f5b2fbe7.png">

## Architecture

The app follows the MVVM architecture pattern, with the following components:

- Model: Repository classes that handle data access and retrieval.
- View: Fragments that display UI elements and respond to user input.
- ViewModel: Classes that manage the UI state and interact with the repository classes.

The app uses Coroutines for asynchronous programming, allowing for smooth and responsive UI updates without blocking the main thread.

The app also uses the Navigation Component to manage navigation between screens, allowing for a consistent and intuitive user experience.

## Credits

The app uses the following open-source libraries and frameworks:

- Coroutines: https://github.com/Kotlin/kotlinx.coroutines
- Navigation Component: https://developer.android.com/guide/navigation

## License

CharacterViewer is licensed under the MIT License. See the LICENSE file for details.
