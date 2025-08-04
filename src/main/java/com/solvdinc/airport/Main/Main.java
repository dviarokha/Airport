package com.solvdinc.airport.Main;

import com.solvdinc.airport.constant.PaymentMethod;
import com.solvdinc.airport.constant.ReservationStatus;
import com.solvdinc.airport.constant.StatusGate;
import com.solvdinc.airport.fault.*;
import com.solvdinc.airport.constant.Role;
import com.solvdinc.airport.model.*;
import com.solvdinc.airport.model.Staff;

import java.io.*;


import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    public static void main(String[] args) {

        final Logger logger = LogManager.getLogger(Main.class);

        Staff staff1 = new Staff(1, "Eustachy", "Uriasz", Role.CHECK_IN_AGENT);
        Staff staff2 = new Staff(2, "Renia ", "Miłosz", Role.CHECK_IN_AGENT);
        Staff staff3 = new Staff(3, "Richard", "McCoy", Role.CO_PILOT);
        Staff staff4 = new Staff(4, "Allen", "Stein", Role.CO_PILOT);
        Staff staff5 = new Staff(5, "Maximo", "David", Role.PILOT);
        List<Staff> staff = Arrays.asList(staff1, staff2, staff3, staff4, staff5);


        Predicate<Staff> isPilot = s -> s.getRole() == Role.PILOT;
        if (isPilot.test(staff5)) {
            logger.info("This staff has been pilot");
        }

        Predicate<Staff> isCheckInAgent = s -> s.getRole() == Role.CHECK_IN_AGENT;

        Function<Staff, Integer> nameLength = s -> s.getName().length();
        int length = nameLength.apply(staff3);
        logger.info("Length name: " + length);

        UnaryOperator<Staff> toUpperCaseStaff = s -> new Staff(s.getId(), s.getName().toUpperCase(), s.getSurname().toUpperCase(), s.getRole());
        Staff upperStaff = toUpperCaseStaff.apply(staff4);
        logger.info(upperStaff.getName() + " " + upperStaff.getSurname());


        staff.stream()
                .filter(isPilot)
                .forEach(s -> logger.info(s.getName()));


        long count = staff.stream().filter(isCheckInAgent).count();
        logger.info(count);

        List<Staff> sortedStaff = staff.stream()
                .sorted(Comparator.comparing(Staff::getName))
                .collect(Collectors.toList());
        sortedStaff.forEach(System.out::println);



        Terminal terminal = new Terminal("Terminal A", "International", staff);


        for (Staff s : staff) {
            try {
                s.validateID();
            } catch (InvalidStaffIdException e) {
                logger.error(e.getMessage());
            }

            try {
                s.getRole().handRole();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }


        try (BufferedReader reader = new BufferedReader(new FileReader("ticket.txt"))) {
            String id = reader.readLine();
            String seatNumber = reader.readLine();
            double price = Double.parseDouble(reader.readLine());
            boolean isChecking = Boolean.parseBoolean(reader.readLine());

            Ticket ticket = new Ticket(id, seatNumber, price, isChecking);
            ticket.validateTicket();

            logger.info("Ticket is read" + ticket);
        } catch (IOException | InvalidTicketException e) {
            logger.error("There was an error reading ticket:" + e.getMessage());
        }


        Gate gate1 = new Gate("1A", LocalTime.of(9, 00), LocalTime.of(11, 45),
                StatusGate.BOARDING, staff1);
        Gate gate2 = new Gate("1AA", LocalTime.of(12, 00), LocalTime.of(13, 00),
                StatusGate.BOARDING, staff2);
        Gate[] gates = {gate1, gate2};

        for (Gate gate : gates) {
            try {
                gate.validateNumber("1A");
            } catch (GateUnavailableException e) {
                logger.error(e.getMessage());
            }

            StatusGate status = StatusGate.CLOSED;
            try {
                gate.getStatusGate().validateBoarding();
            } catch (GateUnavailableException e) {
                logger.error("Status validation" + e.getMessage());
            }


            Ticket ticket1 = new Ticket("392UI", "11A", 1.200, (true));
            Ticket ticket2 = new Ticket("123QA12", "12A", 1000, (true));
            Ticket ticket3 = new Ticket("QW29102", "20A", 700, (true));
            Ticket ticket4 = new Ticket("IW30232", "A9", 1200, (false));
            List<Ticket> tickets = Arrays.asList(ticket1, ticket2, ticket3, ticket4);

            List<Ticket> validTickets = Ticket.filterTicket(tickets, ticket -> ticket.getPrice() > 0);
            logger.info("List tickets: " + validTickets);

            int countValidTickets = Ticket.countValidTickets(validTickets, ticket -> ticket.getPrice() > 0);
            logger.info("Quatity tickets: " + countValidTickets);

            double calculateTotalPrice = Ticket.calculateTotalPrice(tickets, ticket -> ticket.getPrice());
            logger.info("Total price: " + calculateTotalPrice);


            double TotalPrice = tickets.stream()
                    .mapToDouble(Ticket::getPrice)
                    .sum();
            logger.info("Total price: " + TotalPrice);

            boolean CheckIn = tickets.stream()
                    .allMatch(Ticket::isCheckIn);
            logger.info("Check In: " + CheckIn);


            TicketSearchService ticketSearchService = new TicketSearchService(tickets);

            try {
                ticketSearchService.searchTicketBySeatNumber("19A");
            } catch (UnavailableSeatNumberException e) {
                logger.error(e.getMessage());
            }


            Baggage baggage1 = new Baggage("392JD323", "12 kl", (true));
            Baggage baggage2 = new Baggage("9302D333", "25 kl", (true));
            Baggage baggage3 = new Baggage("IOIO932930", "22 kl", (false));
            List<Baggage> baggages = new ArrayList<>();
            baggages.forEach(b -> {
                try {
                    b.checkIfCheckIn(baggage3);
                    logger.info("Baggage" + b.getId() + "is checked in.");
                } catch (UncheckedBaggageException e) {
                    logger.error(e.getMessage());
                }
            });


            Passenger passenger = new Passenger(30032, "Ferdi", "Annelies", tickets, baggages);
            logger.info(passenger);


            Reservation reservation1 = new Reservation("39203JIW", ReservationStatus.CONFIRMED, tickets);
            Reservation reservation2 = new Reservation("123932IIIQA12", ReservationStatus.CANCELLED, tickets);
            Reservation reservation3 = new Reservation("MKW21021", ReservationStatus.EXPIRED, tickets);
            List<Reservation> reservations = Arrays.asList(reservation1, reservation2, reservation3);
            reservations.forEach(reservation -> {
                try {
                    reservation.getStatus().validateStatusForCheckIn();
                    logger.info("Reservation " + reservation.getId() + " is valid and allowed for check in.");
                } catch (InvalidReservationStatusException e) {
                    logger.error("Reservation " + reservation.getId() + " is INVALID and not ready for check in.");
                }
            });


            Payment payment1 = new Payment("ERSFTYGWH39203920391", PaymentMethod.VISA, new BigDecimal(1300.00), (true));
            Payment payment2 = new Payment("IWJXW929032", PaymentMethod.APPLE_PAY, new BigDecimal(1950.50), (true));
            Payment payment3 = new Payment("NJJSW90293", PaymentMethod.PAYPAL, new BigDecimal(2450.70), (true));
            Payment payment4 = new Payment("IWOISOW38293", PaymentMethod.APPLE_PAY, new BigDecimal(2005.99), (false));
            List<Payment> payments = Arrays.asList(payment1, payment2, payment3, payment4);
            payments.forEach(payment -> {
                try {
                    payment.getMethod().validatePaymentMethod();
                } catch (UnknownPaymentMethodException e) {
                    logger.error(e.getMessage());
                }
            });


            List<Payment> filterPayment = payments.stream()
                    .filter(payment -> payment.getMethod() == PaymentMethod.APPLE_PAY)
                    .filter(Payment::isPaid)
                    .collect(Collectors.toList());
            filterPayment.forEach(payment -> logger.info(payment));


            Optional<BigDecimal> minPayment = payments.stream()
                    .map(Payment::getAmount)
                    .reduce(BigDecimal::min);
            logger.info(minPayment);




            BookingSystem bookingSystem = new BookingSystem("Booking System Wroclaw Airport", payments, reservations);
            logger.info(bookingSystem.getName());
            logger.info(bookingSystem.getPayments());
            logger.info(bookingSystem.getReservations());



            Helicopter  helicopter = new Helicopter("HEL32-T", "WQ32", "VIP",  320.0, (true));
            Class clss =  helicopter.getClass();
            logger.info("Class Name: " + clss.getName());

            Method[] methods = clss.getDeclaredMethods();
            logger.info("Methods: ");
            for (Method method : methods)
                logger.info(method.getName());

            Method flyMethod = null;
            try {
                flyMethod = clss.getDeclaredMethod("fly");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            try {
                flyMethod.invoke(helicopter);
                flyMethod.setAccessible(true);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            Method landMethod = null;
            try {
                landMethod = clss.getDeclaredMethod("land");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            try {
                landMethod.invoke(helicopter);
                landMethod.setAccessible(true);
            } catch (IllegalAccessException | InvocationTargetException e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }

            Method takeoffMethod = null;
            try {
                takeoffMethod = clss.getDeclaredMethod("takeoff");
            } catch (NoSuchMethodException e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }
            try {
                takeoffMethod.invoke(helicopter);
                takeoffMethod.setAccessible(true);
            } catch (IllegalAccessException | InvocationTargetException e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }

            Constructor[] constructors = clss.getDeclaredConstructors();
            logger.info("\nConstructors and parameters: ");
            for (Constructor constructor : constructors) {
                Parameter[] parameters = constructor.getParameters();
                for (Parameter parameter : parameters) {
                    logger.info(parameter.getName() + ": " + parameter.getType());
                }
            }

            logger.info("Fields: ");
            Field[] fields = clss.getDeclaredFields();
            for (Field field : fields) {
                logger.info(field.getName() + ": " + field.getType());
            }

        }
    }
}

