package ru.netology.manager;

import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;


import static java.util.Arrays.*;

public class TicketManager {
    private TicketRepository repository;
    public TicketManager(TicketRepository repository){this.repository = repository;}


    public TicketInfo[] findByAirports (String from, String to) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo tickets : repository.getAll()) {
            if (tickets.getFrom().equalsIgnoreCase(from)  && tickets.getTo().equalsIgnoreCase(to)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = tickets;
                result = tmp;
            }

        }
        sort(result);
        return result;
    }

//        TicketInfo[] allTickets = repository.getAll();
//        int length = 0;
//        // Узнать сколько будет подходящих билетов по аэропортам
//        for (int i = 0; i <allTickets.length ; i++) {
//            if (allTickets[i].getFrom() == from && allTickets[i].getTo() == to){
//               length++;
//
//            }
//        }
//
//        // Вывести массив из подходящих билетов, если подходящие билеты есть (length > 0)
//        if (length > 0) {
//            TicketInfo[] tmp = new TicketInfo[length];
//            int nextPos = 0;
//
//            for (int i = 0; i < allTickets.length; i++) {
//                if (allTickets[i].getFrom() == from && allTickets[i].getTo() == to) {
//                    System.arraycopy(allTickets, i, tmp,nextPos,1);
//                    nextPos++;
//                }
//            }
//        }



}
