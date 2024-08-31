# Project Framework --> HYBRID AUTOMATION FRAMEWORK

# Use Tool & Technologies --> Java, Selenium, TestNG, Maven & page Object Model.

# STEP 1 : Create new maven project. 

# STEP 2 : Required Maven Dependencies --> Add all required dependencies in pom.xml 

		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.23.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.testng/testng -->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.10.2</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.3.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.3.0</version>
		</dependency>

		<!--
		https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.23.1</version>
		</dependency>

		<!--
		https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>2.23.1</version>
		</dependency>

		<!--
		https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>2.23.1</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.1.2</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.16.1</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.13.0</version>
		</dependency>

# STEP 3 : Basic Project Structure Create

-->projectName
	  ->src/test/java
	  		->com.base
	  		->com.pom
	  		->com.testcases
	  		->com.utilies
	  ->src/test/resources
	  		->log4j.xml
	  ->JRE System Library
	  ->Maven Dependencies
	  ->logs
	  ->reports
	  ->screenshots
	  ->src
	  ->target
	  ->testdata
	  ->test-output
	  	|pom.xml
	  	|ProjectProcess.md
	  	

# STEP 4 : Development of Hybrid Driven Framework

--> step 1 : Crate Test Case : User Account Registration
			-> 1.1 	create BasePage class under "com.base" package which includes only construction. This will be invoked by      			        every,Page Object Class constructor(For Re-usability)
			-> 1.2  create page object class for HomePage,RegisterPage under "com.pom" package(these classes 				extends from BasePage).
			-> 1.3 create class "TC001_AccountRegistrationTest" under "com.testcases"
			-> 1.4 create class "BaseTest" under "com.base" package and copy re-usable methods.
			-> 1.5 create re-usable methods to generative random string and numbers in class "BaseTest".
			
--> step 2 : Adding logs to test case (log4j)
			-> 2.1 create log4j2.xml file under src/test/resources and Properties,Appenders,Loggers.
			-> 2.2 update "BaseTest" class creating "Logger" object.
			-> 2.3 add log statements to "TC001_AccountRegistrationTest".
			
--> step 3 : Run Test on Parallel/Cross Browser/Desired Browser
			-> 3.1 create "master.xml" file to run test cases and parameterize OS and Browser name to 				"BaseTest" class "startUp()" method
			-> 3.2 update "startUp()" method with annotated like "@Parameters({ "os", "browser" })" and set 				value name as same as xml file, launch browser based on conditions.
			-> 3.3 Maintain separate xml to run tests multiple browser parallelly.
			
--> step 4 : Read common values from .properties file
			-> 4.1 create properties file any name like config.properties under src/test/resources package and write  	    			 					required configuration.
			-> 4.2 update "BaseTest - startUp()" method, write code for load config.properties file.
			-> Replace hard coded values in test cases like URL, Username, Password etc.

--> step 12 : Run the test cases using pom.xml, command prompt & run.bat file.
			-> 5.1 go to the pom.xml and add below plugins in build tag. and run as Maven test.
			
				<build>
			     	<!-- To define the plugin version in your parent POM -->
			    	<pluginManagement>
						  <plugins>
						        <plugin>
						          <groupId>org.apache.maven.plugins</groupId>
						          <artifactId>maven-compiler-plugin</artifactId>  <!-- use for compile the project -->
						          <version>3.13.0</version>
						        </plugin>
					        
					        	<plugin>
						          <groupId>org.apache.maven.plugins</groupId>
						          <artifactId>maven-surefire-plugin</artifactId>  <!-- use for run the project -->
						          <version>3.4.0</version>
						          <configuration>
									<suiteXmlFiles>
									<suiteXmlFile>grouping.xml</suiteXmlFile>	<!-- here write execute xml file name -->
									</suiteXmlFiles>
								  </configuration> 
						        </plugin>
					      </plugins>
			    	</pluginManagement>	
			     </build>
			     
			     NOTE : dependencies : download the required dependency jar for project
			     		pugins : to compile and run the project
			     		*** In that project we only perform pom.xml only
			
	  				

		