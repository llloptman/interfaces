package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerEmptyTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketInfo ticketMskSpb1 = new TicketInfo(1, 110, "MSK", "SPB", 120);
    TicketInfo ticketMskSpb2 = new TicketInfo(2, 101, "MSK", "SPB", 120);
    TicketInfo ticketMskkSpb = new TicketInfo(3, 10, "MSKK", "SPB", 120);

    @Test
    void findByAirports() {
        TicketInfo[] actual = manager.findByAirports("MSK", "SPB");
        TicketInfo[] expected = new TicketInfo[0];
        assertArrayEquals(expected,actual);
    }
}