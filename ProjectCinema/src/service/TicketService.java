
package service;

import objects.Cinema;
import objects.Ticket;
import objects.User;
import service.FileService;
import service.NoSuchItemExeption;

import java.util.List;

public class TicketService {

    public static void printTickets(Cinema cinema) {
        for (int i = 0; i < cinema.getTickets().size() ; i++) {
            System.out.println("Number ticket : " + i + " " + cinema.getTickets().get(i));
        }
    }
    public static List<Ticket> pichaseTicket(int numberTicket, Cinema cinema) throws NoSuchItemExeption {
        if (numberTicket <= cinema.getTickets().size()) {
            cinema.getTickets().get(numberTicket).setAvailable(false);
            cinema.getTickets().get(numberTicket).setUser(cinema.getCurrentUser());
            System.out.println("Ticket ordered successfully" + cinema.getTickets().get(numberTicket));
            FileService.updateCinemaState(cinema);
        } else{
            throw new NoSuchItemExeption("Wrong ticket number entered");
        }
        return cinema.getTickets();
    }

    public static List<Ticket> returnTicket(int newplaceNumber, Cinema cinema){
        for (Ticket ticket : cinema.getTickets()) {
            if (ticket.getUser() != null && ticket.getUser().equals(cinema.getCurrentUser())
                    && ticket.getPlaceNumber() == newplaceNumber) {
                ticket.setUser(null);
                ticket.setAvailable(true);
                System.out.println("Ticket canceled" + ticket);
                FileService.updateCinemaState(cinema);
            }
        }
        return cinema.getTickets();
    }

    public static void viewPurchasedTickets (Cinema cinema){
        for (Ticket ticket:cinema.getTickets()) {
            if (ticket.getUser() != null && ticket.getUser(). equals (cinema.getCurrentUser())){
                System.out.println(ticket);
            }
        }
    }

    public static List<Ticket> puchaseTicketManager(String login,int numberTicket, Cinema cinema) {
        for (User user:cinema.getUsers( )){
            if (numberTicket <= cinema.getTickets().size() &&
                    user.getLogin().equals(login)) {
                cinema.getTickets().get(numberTicket).setAvailable(false);
                cinema.getTickets().get(numberTicket).setUser(user);
                FileService.updateCinemaState(cinema);
                System.out.println("Ticket ordered successfully" + cinema.getTickets().get(numberTicket));
            }
        }
        return cinema.getTickets();
    }

    public static List<Ticket> puchaseTicketManager2(int numberTicket, int numberUser, Cinema cinema) {
        if (numberTicket <= cinema.getTickets().size() &&
                numberUser <= cinema.getUsers().size()) {
            cinema.getTickets().get(numberTicket).setAvailable(false);
            cinema.getTickets().get(numberTicket).setUser(cinema.getUsers().get(numberUser));
            FileService.updateCinemaState(cinema);
        }
        return cinema.getTickets();
    }
    public static List<Ticket> returnTicketManager(int numberTicket, Cinema cinema) {
        int number = 0;
        for (Ticket ticket : cinema.getTickets()) {
            if (number == numberTicket){
                ticket.setAvailable(true);
                ticket.setUser(null);
                FileService.updateCinemaState(cinema);
                System.out.println("Ticket canceled " +ticket );
            }
            number++;
        }
        return cinema.getTickets();
    }


}

