#Payslip Calculator

This is a simple program that accepts a CSV file containing employee information and provides an output of each employee's payslip. The program has been coded using [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and as such will require this specific version to be installed in your machine to run. To package and test the project, you will also need to have [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) installed.

To test the project, go into the project folder and execute the following command.
```sh
mvn test
```

To package the project.
```sh
mvn package
```

A sample _employeeList.csv_ has been provided inside the repository for use in testing the program. To run the program, use the following command in the project folder.
```sh
java -jar target/payslip-calculator-1.0-SNAPSHOT.jar employeeList.csv
```

##### Sample Input and Output
###### Input  

>David,Rudd,60050,9,01 March – 31 March  
>Ryan,Chen,120000,10,01 March – 31 March  

###### Output  

>David Rudd,01 March – 31 March,5004,922,4082,450  
>Ryan Chen,01 March – 31 March,10000,2696,7304,1000  

##### Assumptions
1. Pay periods are always monthly. There are no computations behind them, and they will always equal to the payment start date.
2. Maximum income an employee can have is 999,999.
