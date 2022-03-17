/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.enums;

/**
 *
 * @author Ivan
 */
public enum CinemaTicketPriceEnum {
    FREE_TICKET("Free Ticket",0), 
    TUESDAY_SUPER_DISCOUNT("Best Deal Super Discount",2), 
    WEEKDAY_GENERAL("Weekday Regular Price",7), 
    WEEKEND_DISCOUNT("Weekend Price with 20% Discount", 12), 
    WEEKEND_FULL("Weekend Regular Price", 15), 
    AVANT_PREMIERE("Avant Premiere Price", 30);
    
    private final String ticketPriceEnumDescription;
    private final double ticketPriceUSD;

    private CinemaTicketPriceEnum(String ticketPriceEnumDescription, double ticketPriceUSD) {
        this.ticketPriceEnumDescription = ticketPriceEnumDescription;
        this.ticketPriceUSD = ticketPriceUSD;
    }

    public String getTicketPriceEnumDescription() {
        return ticketPriceEnumDescription;
    }

    public double getTicketPriceUSD() {
        return ticketPriceUSD;
    }
    
    
    
}

/*
From less to most expensive
free ticket
tuesday super discount
week day general 
weekend discounted
weekend full
avant premiere 
*/