package ru.netology.domain;


public class TicketInfo implements Comparable <TicketInfo>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int timeInAir;

    @Override
    public String toString() {
        return "TicketInfo{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", timeInAir=" + timeInAir +
                '}';
    }

    public TicketInfo(int id, int price, String from, String to, int timeInAir) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.timeInAir = timeInAir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTimeInAir() {
        return timeInAir;
    }

    public void setTimeInAir(int timeInAir) {
        this.timeInAir = timeInAir;
    }

    @Override
    public int compareTo(TicketInfo o) {
       return price - o.price;
    }
}
