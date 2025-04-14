package iuh.fit.util;

import iuh.fit.model.Baggage;
import iuh.fit.model.Flight;
import iuh.fit.model.FlightLocation;
import iuh.fit.model.Passenger;
import jakarta.json.Json;
import jakarta.json.stream.JsonParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  Admin 4/14/2025
 *  
**/
public class JsonUtils {

    public static List<Flight> fromJson(String fileName) {
        List<Flight> res = new ArrayList<>();

        try (JsonParser parser = Json.createParser(new FileReader(fileName))) {
            Flight flight = null;
            FlightLocation departure = null;
            FlightLocation arrival = null;
            List<Passenger> passengers = null;

            Passenger passenger = null;
            Baggage baggage = null;

            String key = "";
            String currentObj = "";


            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();

                switch (event) {
                    case START_ARRAY -> {
                        if (key.equals("passengers")) passengers = new ArrayList<>();
                    }
                    case START_OBJECT -> { // {
                        if (flight == null) {
                            flight = new Flight();
                        } else if (departure == null && key.equals("departure")) {
                            departure = new FlightLocation();
                            currentObj = "departure";
                        } else if (arrival == null && key.equals("arrival")) {
                            arrival = new FlightLocation();
                            currentObj = "arrival";
                        } else if (passenger == null) {
                            passenger = new Passenger();
                        } else if (baggage == null && key.equals("baggage")) {
                            baggage = new Baggage();
                        }

                    }
                    case END_OBJECT -> { // }
                        if (departure != null) {
                            flight.setDeparture(departure);
                            departure = null;
                            currentObj = "";
                        } else if (arrival != null) {
                            flight.setArrival(arrival);
                            arrival = null;
                            currentObj = "";
                        } else if (baggage != null) {
                            passenger.setBaggage(baggage);
                            baggage = null;
                        } else if (passenger != null) {
                            passengers.add(passenger);
                            passenger = null;
                        } else if (flight != null) {
                            flight.setPassengers(passengers);
                            res.add(flight);

                            flight = null;
                            passengers = null;
                        }

                    }
                    case KEY_NAME -> key = parser.getString();

                    case VALUE_STRING -> {
                        String value = parser.getString();

                        switch (key) {
                            case "flightNumber" -> flight.setFlightNumber(value);
                            case "airline" -> flight.setAirline(value);
                            case "city" -> {
                                if (currentObj.equals("departure")) departure.setCity(value);
                                else arrival.setCity(value);
                            }
                            case "airport" -> {
                                if (currentObj.equals("departure")) departure.setAirport(value);
                                else arrival.setAirport(value);
                            }
                            case "time" -> {
                                LocalDateTime formattedValue = LocalDateTime.parse(value);

                                if (currentObj.equals("departure")) departure.setTime(formattedValue);
                                else arrival.setTime(formattedValue);
                            }
                            case "name" -> passenger.setName(value);
                            case "passport" -> passenger.setPassport(value);
                            case "seat" -> passenger.setSeat(value);

                        }

                    }
                    case VALUE_NUMBER -> {
                        switch (key) {
                            case "age" -> passenger.setAge(parser.getInt());
                            case "weightKg" -> baggage.setWeightKg(parser.getBigDecimal().doubleValue());
                        }
                    }
                    case VALUE_TRUE -> baggage.setCheckedIn(true);
                    case VALUE_FALSE -> baggage.setCheckedIn(false);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return res;
    }

}

