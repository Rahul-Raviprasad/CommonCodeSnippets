http://ngcordova.com/docs/plugins/


### How to avoid cors issue on browser for ionic app.
Add a proxy parameter to ionic.config.json file. This is when you are able to access the endpoint from POSTMAN but not from browser.

"proxies": [
  {
    "path": "/api",
    "proxyUrl": "https://third-party-or-otherURL.com/api/"
  }
],


### Text to speech
To convert text to speech we will require to install a plugin
withint the ionic project folder  run

```terminal command
cordova plugin add cordova-plugin-tts
```

And now within your angular app, you can use it like the following code
```js
$scope.speakText = function() {
  TTS.speak({
         text: 'Hello World',
         locale: 'en-GB',
         rate: 1.5
     }, function () {
         // Do Something after success
     }, function (reason) {
         // Handle the error case
     });
};
```

This plugin uses the AVSpeechSynthesizer on iOS and the android.speech.tts.TextToSpeech package on Android, so it’s really a simple mapper of the best native functions for giving out text.

### Voice Recognition
For voice recognition we need to use a plugin again

```
cordova plugin add https://github.com/macdonst/SpeechRecognitionPlugin
```
once the plugin gets install and added to config file, include the following code in your app
```js
  $scope.recognizedText = '';

  $scope.record = function() {
    var recognition = new SpeechRecognition();
    recognition.onresult = function(event) {
        if (event.results.length > 0) {
            $scope.recognizedText = event.results[0][0].transcript;
            $scope.$apply()
        }
    };
    recognition.start();
  };
```

On Android this plugin uses the native android.speech.SpeechRecognizer package, on iOS it’s a bit harder to achieve this task so the author used the iSpeech SDK which you can test for free for now. If you plan to use this SDK in production additional costs may arise.


## Debugging Ionic app tips
1. the first is to run it with live reload.
2. install a chrome plugin called inspect-devices.
3. Use device monitor provided by android. https://developer.android.com/studio/profile/monitor
