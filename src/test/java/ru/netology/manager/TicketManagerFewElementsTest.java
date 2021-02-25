package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparators.TicketByTimeInAir;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerFewElementsTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketByTimeInAir comporator = new TicketByTimeInAir();
    TicketInfo ticketMskSpb1 = new TicketInfo(1, 110, "MSK", "SPB", 110);
    TicketInfo ticketMskSpb2 = new TicketInfo(2, 101, "MSK", "SPB", 120);
    TicketInfo ticketMskkSpb = new TicketInfo(3, 10, "MSKk", "SPB", 120);

    @BeforeEach
    public void setUp() {
        repository.save(ticketMskSpb2);
        repository.save(ticketMskSpb1);
        repository.save(ticketMskkSpb);
    }

    @Test
    void findByAirportsShouldSortDesc() {
        TicketInfo[] actual = manager.findByAirports("MSK", "SPB");
        TicketInfo[] expected = new TicketInfo[2];
        expected[0] = ticketMskSpb2;
        expected[1] = ticketMskSpb1;
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllShouldSortByTimeInAir() {
        TicketInfo[] actual = manager.findAll("MSK", "SPB", comporator);
        TicketInfo[] expected = new TicketInfo[2];
        expected[0] = ticketMskSpb1;
        expected[1] = ticketMskSpb2;
        assertArrayEquals(expected, actual);
    }

}