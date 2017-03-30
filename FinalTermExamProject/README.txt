You need to implement a small system to organize the package shipment.


For each package you need to have the following data:

- target location

- distance in km to the target

- merchandise value

- delivery date



The system should be able to sort the packages based on the target location and delivery date.

For each bunch of packages which are delivered to the same location on a given date, the system must calculate the merchandise value and the profit. 

The profit is calculate considering a fix value per km.

Each bunch of packages must be delivered by a separate thread.

When the delivery is done the total merchandise value and the profit must be printed.

The delivery is done in an time interval equal in seconds with the distance to destination.

Make sure that you can deliver concurrently multiple packages.



To test it:

- create a main method where you create the packages for multiple destinations and delivery dates

- then set the target date and start the distribution

As a result:

- for all delivered bunch of packages for that specific date, the merchandise total value and the profit is printed
