package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerOneElementTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketInfo ticketMskSpb1 = new TicketInfo(1, 110, "MSK", "SPB", 120);
    TicketInfo ticketMskSpb2 = new TicketInfo(2, 101, "MSK", "SPB", 120);
    TicketInfo ticketMskkSpb = new TicketInfo(3, 10, "MSKK", "SPB", 120);

    @BeforeEach
    public void setUp() {
        repository.save(ticketMskSpb2);
    }


    @Test
    void findByAirportsMatch() {
       TicketInfo[] actual = manager.findByAirports("MSK","spb");
       TicketInfo[] expected = new TicketInfo[1];
       expected[0] = ticketMskSpb2;
       assertArrayEquals(expected,actual);

    }

    @Test
    void findByAirportsNotMatch() {
        TicketInfo[] actual = manager.findByAirports("MSKk","spb");
        TicketInfo[] expected = new TicketInfo[0];
        assertArrayEquals(expected,actual);

    }
}