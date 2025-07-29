Airport System

"Airport" is a Java project that models an airport system with entities such as employees, tickets, baggage, terminals, payments, and bookings. The project covers OOP principles, functional interfaces, lambda expressions, streams, exception handling, and the reflection API.

Technologies
Language: Java 24
Build Tool: Maven
Paradigms: OOP, Functional Programming

Features:
Working with Predicate, Function, UnaryOperator
Usage of Stream API
Use of @FunctionalInterface
Exception Handling
Reflection API


Project structure:
com.solvdinc.airport
├── model/ (Airport, Airplane, Staff, Ticket, Passenger,
   Baggage, StatusGate, BookingSystem, ...)

├── constant/ (FlightStatus, Role, ReservationStatus, 
PaymentMethod, StatusGate)

├── functions/ (StaffCriteria)

├── fault/ (User exceptions)

├── utils/ (TicketUtils)

├── action/ Interfaces (ICost, IFly, iPay, ISearch, IWork)

├── Main/ (Main)
