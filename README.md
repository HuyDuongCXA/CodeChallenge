# CodeChallenge

## Installation

Please use IntelliJ IDEA or Eclipse IDE to run the test

Make sure you have JAVA (JDK) downloaded and installed

### How to run
- If you are using IntelliJ IDEA then please choose Eclipse project option and choose Trust Project (if Trust Maven project displayed)
You can execute the test using the "testNG.xml" file. Simply right-click on "testNG.xml" file then choose "Run'../testNg.xml'"

- If you are using Eclipse then you can execute the test using the "testNG.xml" file. Simply right-click on "testNG.xml" file then choose "Run As TestNG Suite'"

- If you encounter "Java error", please change the java complier version in the POM file to version in your machine then re-install Maven.

EX: 

```bash
<maven.compiler.source>1.14</maven.compiler.source>
<maven.compiler.target>1.14</maven.compiler.target>
```    
If you're using JAVA 12 then change 1.14 into 1.12
