## Java Download
https://www.oracle.com/java/technologies/downloads/

## Eclipse Downloads
https://www.eclipse.org/downloads/

## Download android Studio
https://developer.android.com/studio

**_NOTE:_** 
We can also set up android SDK without android studio https://proandroiddev.com/how-to-setup-android-sdk-without-android-studio-6d60d0f2812a

## NodeJs
https://nodejs.org/en/download/

To check if node is installed properly - type in command prompt - npm

Node js can be installed in mac using home brew - https://support.smartbear.com/testcomplete/docs/app-testing/mobile/device-cloud/configure-appium/android-on-mac.html

## Install appium desktop
https://github.com/appium/appium-desktop/releases/tag/v1.21.0

## Setting up environment variables:

Setup JAVA_HOME and PATH environment variable
- Windows - https://mkyong.com/java/how-to-set-java_home-on-windows-10/
- Linux - https://medium.com/@rohancbandara/install-openjdk-and-set-java-home-path-in-ubuntu-2ce2bc3a8fb2
- Mac - https://mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/
- Setup ANDROID_HOME environment variable with SDK location.

SDK location in windows - C:\Users\username\AppData\Local\Android\Sdk

Add following to Path variable
%ANDROID_HOME%\tools
%ANDROID_HOME%\platform-tools

Mac:
- Create the bash_profile file if not exists- https://redfinsolutions.com/blog/creating-bashprofile-your-mac
- Open the file ~/.bash_profile using any editor example nano ~/.bash_profile and add the environment variables.

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk_folder/Contents/Home
export ANDROID_HOME=/Users/<username>/Library/Android/sdk
export PATH=$/Library/Java/JavaVirtualMachines/jdk_folder/Contents/Home/
bin:$PATH
export PATH="/Users/ <username> /Library/Android/sdk/platform-tools":$PATH

Run the command - ~/.bash_profile to save the settings added.

## Enable virtualization
Needed only for android emulator (windows):
- https://mashtips.com/enable-virtualization-windows-10/

## Install appium via node:
npm install -g appium

## Install appium doctor from command line
npm install appium-doctor -g

## Run appium doctor to confirm all appium dependencies are installed:
appium-doctor --android

## Android device side setting:
Enable developer options and USB debugging (https://developer.android.com/studio/debug/dev-options )

## Appium Inspector App (only for appium 1.22 onwards - not to be used for this workshop)
https://github.com/appium/appium-inspector/releases

## Extract package name and activity name from the android app:
Command - adb shell “dumpsys activity activities | grep mResumedActivity”
Sample output:
mResumedActivity: ActivityRecord{f01a302 u0 com.ravendmaster.linearmqttdashboard/.activity.MainActivity t44804}

Package Name - com.ravendmaster.linearmqttdashboard
Activity name - .activity.MainActivity

## Install application (outside app store):
adb install app_path

## Mirror Android Phone to host pc/laptop:
https://github.com/Genymobile/scrcpy (Direct link - https://github.com/Genymobile/scrcpy/releases/download/v1.19/scrcpy-win64-v1.19.zip)
https://www.vysor.io/

## Enable WebView debugging
- call the static method setWebContentsDebuggingEnabled on the WebView class. Details available in
https://developer.chrome.com/docs/devtools/remote-debugging/webviews/

## Sample App Used for the workshop: 
- https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.apk
