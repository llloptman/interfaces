package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.comparators.TicketByTimeInAir;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerEmptyTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketByTimeInAir comporator = new TicketByTimeInAir();


    @Test
    void findByAirports() {
        TicketInfo[] actual = manager.findByAirports("MSK", "SPB");
        TicketInfo[] expected = new TicketInfo[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        TicketInfo[] actual = manager.findAll("MSK", "SPB", comporator);
        TicketInfo[] expected = new TicketInfo[0];
        assertArrayEquals(expected, actual);
    }
}