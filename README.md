# ✨ UI & Mobile Automation 
 
### Overview
Java project for UI and Mobile test automation. This project skeleton allows to other QA Automation Engineers to automate different scenarios for mobile as well as web applications using a single framework. This framework solution is a robust, extensible and easy to maintain.

The framework was developed using 3 tier test architecture. The strategy is to abstract the project in separate tiers. The first tier `Test Scripts` implements the tests using Features, Scenarios and implementing Steps using Gherkin language and Cucumber. The next tier `Test Steps` implements the steps defined in the previous layer using JAVA programming language. Finally, the last layer `App Access Components` use the WebDriver protocol to send commands to a specific web driver and perform actions over the browser. In this last layer, all page object class are implemented.

On the other hand, in order to test the native Android app. The APK file was added to the `app` folder in the automation framework. However, this can be updated easily adding the URL where is the latest build of the application under test.

To develop the framework Java programming language was used. Programs that are written in Java shows to be faster than other programming languages like Python. Moreover, Java is widely used in commercial applications rather than others.

The web page automated was: https://www.babbel.com/ 
- One `Scenario Outline` was developed for Android web-browser.
Path: `resources/features/web/WebTest.feature`
- One `Scenario` was automated for the native Android app. Path: `src/test/resources/features/mobile/MobileTest.feature`

**Note:**
This framework was developed and tested on **Windows 10** OS.

### **Installation**
#### 📑 Set up environment
- Have installed JAVA 1.8+ JDK
- Verify JAVA installation
```bash
$ java -version
java version "1.8.0_261"
Java(TM) SE Runtime Environment (build 1.8.0_261-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.261-b12, mixed mode)
```
- Install Gradle (Manually) or use Gradle Wrapper (Recommend)
  * [Download](https://gradle.org/releases/) the latest Gradle distribution.
  * Create a directory i.e. `C:\Gradle`
  * Unzip the distribution zip and copy the folder to the new folder created.
  * Navigate to `Control Panel\System and Security\System`, Click on `Advanced system settings`
  * Click on `Environment Variables`
  * Under System Variables
       * Select Path, then click Edit. Add an entry for `C:\Gradle\gradle-6.6.1\bin.` Click OK to save.
       * Click on new, Add Variable Name & value: `GRADLE_HOME = C:\Gradle\gradle-6.6.1\bin.`
  * Verify installation
  ```bash
  $ gradle -v
  ------------------------------------------------------------
  Gradle 6.6.1
  ------------------------------------------------------------ 
  Kotlin:       1.3.72
  Groovy:       2.5.12
  Ant:          Apache Ant(TM) version 1.10.8 compiled on May 10 2020
  JVM:          1.8.0_261 (Oracle Corporation 25.261-b12)
  OS:           Windows 10 10.0 amd64
  ```
- Download & Install [Appium Desktop](http://appium.io/downloads.html)  
- Download & Install [Android Studio](https://developer.android.com/studio)
    - Select Android SDK 10 (API level 30) or desire.
    - Select SDK Tools
    - Create a virtual device. For this demo a **Pixel 2** device was installed (API level 28).
- Download & Install [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=windows)
    - Set up Intellij Plugins

        | Plugin | README |
        | ------ | ------ |
        | Gherkin| [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin) |
        | Cucumber for Java| [Cucumber](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) |


- Chrome Driver version used ```84.0.4147.30```. Drivers persisted in `Drivers` directory.

- Clone repository.
- Environment info is set up on `src/main/resources/envInfo.yaml` (Use **Default** configuration)
#### 🚀 Run Test Cases
Run the following commands at the root of your project using the *Gradle Wrapper*:

- Clean & Build environment

```sh
$ gradle.bat clean build
```

- 🖥️ To run UI test cases
```sh
$  gradle.bat cucumber -Pbrowser="chrome" -Pdriver="web" -Ptags="@ui"
```

- 📱 To run mobile test cases
  * Verify Android virtual device is running.
  * Verify appium server is running in `Port = 4723` and `Host = 0.0.0.0`
```sh
$ gradle.bat cucumber -Pdriver="android" -Ptags="@mobile" -PuserName="percival@gmail.com" -Ppassword="123456"

```

#### 📝 Reporting
A `cucumber.json` file is created after each execution and is persisted into `/report_output`. 
This file is parsed by Cucumber report plugin to generate a HTML report. To review HTML report double click on `/report/cucumber-html-reports/overview-features.html` 

### Framework

#### 🛠️ Tools/Frameworks
- **Gradle:** from my point of view is more flexible and configurable build tool than maven. However, it requires spending some time to learn the domain-specific language for declaring the project configuration. Nevertheless, it allows to set up more complex codebase. Finally, it worths to be used because is easy to maintain and use.

- **Cucumber:** is used to write scenarios/test cases in a readable way. The use of Gherkin language allows writing automated test cases in plain text. This allows for reducing the communication gap between testers and other teams. From my point of view, this a great advantage when execution reports are reviewed for non-technical colleagues. Another advantage of Cucumber is the reusability of the steps definition so, the step developed could be used in other features. On the other hand, structuring the pre-conditions, features, scenarios and post-conditions requires spent time planning. Also, low-level documentation should be created that describes tags, steps, features in order to promote the reusability of these by other members of the team. Consequently, these points will increase the time to automate new scenarios.

- **Appium:** framework allows to developed mobile automation test cases for native and hybrid apps for different mobile OS such as Android and IOS. Therefore, this allows to testers to automate a variety of scenarios for different mobile devices using a single tool. On the other side, Appium does not support the older versions of Android 4.2. so if we are planning to automate scenarios for older Android versions,  this might not be the correct tool to tackle the problem. Moreover, it takes time to set up a local environment for both mobile OS. To sum up, Appium helps us to create end-to-end scenarios, supports cross-platform(mobile) and different programming language. Conversely, it could be a challenge to set up an environment and there are some drawbacks with stability and performance.

- **Selenium:** framework allows to automate test cases for cross-browsers like Chrome, Firefox, Opera, and IE. For each browser, a web driver is instantiated to interact with the web components. Also, it supports different Operation Systems and finally, it is an open-source framework with avast amount of documentation and community support. On the other hand, one of the biggest drawbacks of selenium is that needs high maintenance if we are facing a UI application that constantly changes. Even small changes can break test cases. Moreover, we can face a slow execution when we are dealing with hundreds of test cases exists works around to deal with this problem, however, a team with years of experience is required.


#### 🧬 Patterns used
- **Factory Pattern:** provide an interface to choose easily which driver should be instantiated. `Driver` class is an interface and `Chrome` and `Android` classes implements the abstract methods defined in it. This pattern is used to hide the logic to create a driver instance in `DriverManager` class. Also, if new requirements are added, such as new browser support (i.e. `Firefox`), this should not be a problem. A new browser class is created which implements the `Driver` interface.

- **Singleton Pattern:** is used to create a `WebDriverManager` or `MobileDriverManager` single instance that can be reused over all the execution by different base page objects. This class is responsible to initialize the `WebDriver` and `WebDriverWait`. Finally, the use of this pattern allows keeping track of the same driver instance through the framework execution preventing get out of sync during the run.

- **Page Object Model:** is used in this project to represent web pages as classes and web elements as variables. This implementation will allow automating any action like "ClickOnButton();" and  "FillOutText();"  as methods in classes. This allows creating readable code, reusable and easy to maintain.

- **Base Page Object:** the `WebBasePage` and `MobileBasePage` retrieve the `WebDriver` and `WebDriverWait` objects from `DriverManager`. Furthermore, it is responsible to initialize the Web elements using the PageFactory. From onwards every page-object created should extend this class. 

