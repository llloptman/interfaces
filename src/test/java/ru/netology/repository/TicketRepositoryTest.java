package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInfo;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    TicketInfo ticketMskSpb1 = new TicketInfo(1,110,"MSK","SPB",120);
    TicketInfo ticketMskSpb2 = new TicketInfo(2,101,"MSK","SPB",120);
    TicketInfo ticketMskkSpb = new TicketInfo(1,10,"MSKK","SPB",120);

    @Test
    void save() {
       repository.save(ticketMskSpb1);
        TicketInfo[] actual = repository.getAll();
        TicketInfo[] expected = new TicketInfo[1];
        expected[0] = ticketMskSpb1;
        assertArrayEquals(expected,actual);
    }

    @Test
    void getAll() {

    }
}