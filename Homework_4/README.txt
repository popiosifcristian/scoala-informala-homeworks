Java OOP II Homework

Compute electricity consumption / hour for household appliances.



All appliances can be turned on and off, and the consumption / hour value can be checked.

Every appliance has specific behaviors and features which when turned on can consume more electricity.



The following code should be similar to the one in your application:



Appliance a = new Appliance(); // This must NOT compile

Appliance fridge = new SamsungSmartFridge("SN-SMSG009"); // This must compile - serial number is passed via constructor

float consumption = fridge.getConsumptionPerHour();// consumption should be 0

fridge.start();

float consumption = fridge.getConsumptionPerHour();// consumption should be 10w

fridge.turnOnPowerFreezer();

float consumption = fridge.getConsumptionPerHour();// consumption should be 20w



IRobotVacuum iRobot = new IRobotVacuum600Series();

Appliance someVacuum = (Appliance) iRobot; // upcast

someVacuum.start(); // starts the irobot

iRobot.doQuickClean(); // the robot might have a ThoroughClean function, or CleanPetHair function, etc.

iRobot.stop();



Task (if not implemented - you receive penalties):

Write at least 1 interface.

Write at least 1 abstract class.

Write at least 4 different appliances that belong to different appliance categories

    - e.g LG Television, Philips Blender, HP Notebook, Samsung Fridge

    - don't write LG Television, Sharp Television, Samsung Television

Each appliance should have at least one behavior controlled by one or more methods that the other 3 appliances don't have.
