# test
1.Config/config.properties: this config file contains:
 i) url of the website to be tested
ii) Browser name chrome/firefox

2. Pages/basePage.java: this is used to get
 i) url from the config file 
ii) Browser from config file
iii) Initialise the browser
iv) Open the url in browser

3.Tests/TestOne.java this class contains test cases. All action required are implemented in this class

Requirements to run test:
1. Install Java

2. Set java home, refer: https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html

3. Download maven, and set maven home, refer: https://maven.apache.org/install.html

4. Import project in eclipse

5. open terminal/command prompt

6. Go to the project directory

7. Run:
mvn clean test
