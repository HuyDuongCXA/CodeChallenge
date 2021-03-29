# CodeChallenge

## Installation

- Eclipse or Intelli J (recommended)
- Java JDK
- Chrome 89

## Build steps
 Build steps
```python
For Eclipse:
 1 Select pom.xml -> right click -> Run As -> Maven clean (Eclipse)
 2 Select pom.xml -> right click -> Run As -> Maven install (Eclipse)
 
For Intelli J:
 - Select pom.xml -> right click -> Maven -> Reload Project (Intelli J only)
```   

### How to run
- Execution via Eclipse:
```python
1 Go to root folder
2 Select "testNG.xml" file -> right click -> Run As -> Run As TestNG Suite
```
- Execution via Intelli J:
```python
1 Go to root folder
2 Select "testNG.xml" file -> right click -> Run As -> Run'../testNg.xml
```

#### Note

If you encounter "Java error", please change the java complier version in the POM file to version in your machine then re-install Maven.

EX: 

```bash
<maven.compiler.source>1.14</maven.compiler.source>
<maven.compiler.target>1.14</maven.compiler.target>
```    
If you're using JAVA 12 then change 1.14 into 1.12

## Structure
<img width="967" alt="Screen Shot 2021-03-29 at 10 23 55" src="https://user-images.githubusercontent.com/61961708/112783178-e9ec8800-9078-11eb-8b9c-2b90baf8ffc8.png">
