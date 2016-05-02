# VEHICLE IDENTIFIER APPLICATION#
This is a small project intended for reading records of some vehicles from a valid XML file and showing a report for the same.

### What is this repository for? ###

* This is a small project intended for reading records of some vehicles from a valid XML file and showing a report for the same.
* Version : 0.0.1

### How do I get set up? ###

* This has a single module in which I have use Spring-boot, Thymeleaf, Bootstrap, Spring Web, REST API
* Configuration
* Dependencies  : Spring-boot, Thymeleaf, Bootstrap, Spring Web, REST API
* Database configuration
* How to run tests : J-units are configured in pom.xml. They will execute when the application is built.
* Deployment instructions : The jar is executable. You can go to the command line and use java -jar vehicle-identifier-0.0.1.jar. It will start a spring boot server and you can use the application on localhost:8081

### Who do I talk to? ###
* Author : Ashish Dhiman ( ashish.dhiman.nith@gmail.com )

##Technology Description##

###Implementation Details###
This is a Spring Boot project and Thymeleaf along with Bootstrap is used for the front end.
Further it uses REST API to render the views and to interact with the core of the project.
For sending the files to the core it uses a MultipartFile which gives us the file as a Stream. Then this stream is converted to Java Objects/Pojos using JAXB API. This Java Pojos are standard as per the XML schema structure. 
There are two main manager interfaces which process our file, ReportManager and VehicleIdentifier. The ReportManager has a read() method which takes input stream as an argument and returns us the desired java objects by marshalling the stream.
As the read() method returns the desired java objects the application calls VehicleIdentifier.generatReport() method which has the business logic for finding the type of the Vehicle. It returns a map which has VehicleType as key and List of Vehicle objects as value. So, here user can see grouping of fields in our map and we send this data directly to GUI for displaying on the screen.
##Exception Handling##
Exception handling has been thoroughly implemented in the project.
The application has its own exception BusinessException which is always thrown along with the appropriate error code from ErrorCodes enum where each error has a particular error message associated with it.
##Validations##
There is only one input to the project i.e. file type which we are validating before any processing.
The validations are two step validations :
-	Using JQuery Validator ( Check if the File has been selected ( required)) and the selected file is only in XML format otherwise an error message is shown.
-	Java Validation where we are checking the input for nullability and the format and an error is displayed on GUI if input is invalid.
##J-Units##
J Units test cases are provided for both the manager classes and an Unmarshallar engine which covers all the positive and negative scenarios with appropriate assertions.
##Rest Controller##
There is only one Rest Controller i.e. File Controller handling all request and rendering the views.
##Core Business Logic##
I am going to explain a little bit about the main business logic which is implemented in the core to determine the type of vehicle.
First of all I have created a HashMap constant which is a map conating all the available standard vehicle objects keys and the value is the type of that vehicle. This map has 5 keys looking at our total type of Fields.
So, when I have the list of all the Value objects, I just use this map to determine its type.
All the vehicles have overridden .equals method in which I am specifying the criteria for equality and in which I am comparing only the fields which are standard ones and when I find that in the map, I get the value of object.
##Scope of Improvement##
This implementation is robust, reusable, configurable and extendable. But if given some more time, it can also be improved. 