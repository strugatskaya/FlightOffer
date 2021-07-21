package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FlightManagerTest {
    private FlightRepository repository = new FlightRepository();
    private FlightManager manager = new FlightManager(repository);
    private Flight YYC1 = new Flight(1, 5000, "LED", "YYC", 240);
    private Flight YYC2 = new Flight(2, 1000, "LED", "YYC", 240);
    private Flight YYC3 = new Flight(3, 2300, "LED", "YYC", 300);
    private Flight YYC4 = new Flight(4, 1000, "LED", "YYC", 240);
    private Flight LIS5 = new Flight(5, 1200, "VKO", "LIS", 350);
    private Flight NUE6 = new Flight(6, 2000, "VKO", "NUE", 240);
    private Flight HEL1 = new Flight(7, 3500, "LED", "HEL", 400);
    private Flight NOJ7 = new Flight(8, 2500, "LED", "NOJ", 200);

    @BeforeEach
    public void setUp() {
        repository.addFlight(YYC1);
        repository.addFlight(YYC2);
        repository.addFlight(YYC3);
        repository.addFlight(YYC4);
        repository.addFlight(LIS5);
        repository.addFlight(NUE6);
        repository.addFlight(HEL1);
        repository.addFlight(NOJ7);
    }

    @Test
    void shouldSearchMultipleFlights() {
        String from = "LED";
        String to = "YYC";

        Flight[] actual = manager.searchFlight(from, to);
        Flight[] expected = new Flight[]{YYC2, YYC4, YYC3, YYC1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneFlight() {
        String from = "VKO";
        String to = "NUE";

        Flight[] actual = manager.searchFlight(from, to);
        Flight[] expected = new Flight[]{NUE6};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchFlight() {
        String from = "HEL";
        String to = "NOJ";

        Flight[] actual = manager.searchFlight(from, to);
        Flight[] expected = new Flight[]{};

        assertArrayEquals(expected, actual);
    }
}