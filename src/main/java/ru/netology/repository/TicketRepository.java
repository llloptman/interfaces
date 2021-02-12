package ru.netology.repository;

import ru.netology.domain.TicketInfo;

public class TicketRepository {
    private TicketInfo[]  TicketInfo = new  TicketInfo[0];

    public void save(TicketInfo newTicket){
        int length = TicketInfo.length + 1;
        TicketInfo[] tmp = new TicketInfo[length];
        System.arraycopy(TicketInfo,0,tmp,0,TicketInfo.length);
        tmp[tmp.length - 1] = newTicket;
        TicketInfo = tmp;
    }

    public TicketInfo[] getAll(){
        return TicketInfo;
    }
}
