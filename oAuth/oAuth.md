Lets say you have been asked to authorize users using oAuth 2.0 with an external server.

oAuth 2.0 roles

* User
* Application
* API

let say you are using the spotify app to listen to music, and you use Facebook's login to access it.
In this case, "Spotify" is the Application and FB is your API

* Passwords are never passed from server to server.

There are many authentication methods available, but authenticating users via OAuth is a long time favorite for developers. It’s an open standard for authorization which allows users to sign in to applications using their accounts on other services (such as Facebook, Google etc) without giving the application access to any credentials.

cordovaOAuth is an AngularJS extension which allows mobile developers to add Oauth authorization to their Cordova based apps as simple as possible.
