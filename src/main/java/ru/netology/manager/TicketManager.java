package ru.netology.manager;

import ru.netology.comparators.TicketByTimeInAir;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;


import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.*;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public TicketInfo[] findByAirports(String from, String to) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo tickets : repository.getAll()) {
            if (tickets.getFrom().equalsIgnoreCase(from) && tickets.getTo().equalsIgnoreCase(to)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = tickets;
                result = tmp;
            }

        }
        sort(result);
        return result;
    }

    public TicketInfo[] findAll(String from, String to, Comparator<TicketInfo> comparator){
        TicketInfo[] result = findByAirports(from,to);
        sort(result,comparator);
        return result;
    }
}
