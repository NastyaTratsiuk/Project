package view;

import objects.Cinema;
import service.*;

import java.util.Scanner;

public class Main {
    public static Cinema cinema;

    public static void main(String[] args) {

        cinema = FileService.getCinemaState();

        System.out.println("Hello user!");
        System.out.println("Enter 1 for login, 2 for registration:");

        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1: {
                loginUser();
                break;
            }
            case 2: {
                registerUser();
                break;
            }
            default:
                System.out.println("Typo!");
        }
    }

    public static void loginUser() {
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        System.out.println("Input password");
        String password = scanner.next();
        UserService.loginUser(login, password, cinema);
        mainMenu(login);
    }

    public static void registerUser() {
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        System.out.println("Input password");
        String password = scanner.next();
        UserService.registerUser(login, password, cinema);
        mainMenu(login);
    }

    public static void mainMenu(String userName) {

        System.out.println("Hello " + userName + " !");

        System.out.println("Select an option:");
        System.out.println("1- View the list of events!");
        System.out.println("2- Buy ticket!");
        System.out.println("3- Return ticket!");
        System.out.println("4- View purchased tickets");
        System.out.println("5- Exit!");

        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1: {
                FilmService.printFilm(cinema);
                mainMenu(cinema.getCurrentUser().getLogin());
                break;
            }
            case 2: {
                buyTicket();
                mainMenu(cinema.getCurrentUser().getLogin());
                break;
            }
            case 3: {
                TicketService.viewPurchasedTickets(cinema);
                returnTicketUser();
                mainMenu(cinema.getCurrentUser().getLogin());
                break;
            }
            case 4: {
                TicketService.viewPurchasedTickets(cinema);
                mainMenu(cinema.getCurrentUser().getLogin());
                break;
            }
            case 5 :{
                System.exit(0);
            }
            default:
                System.out.println("Typo!");
        }

    }
    public static void buyTicket(){
        Scanner scanner = new Scanner(System.in);
        TicketService.printTickets(cinema);
        System.out.println("Input number ticket, please! ");
        int numberTicket = scanner.nextInt();
        try {
            TicketService.pichaseTicket(numberTicket, cinema);
        } catch (NoSuchItemExeption e) {
            e.printStackTrace();
        }
    }

    public static void returnTicketUser (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the seat number!");
        int newPlaceNumber = scanner.nextInt();
        TicketService.returnTicket(newPlaceNumber,cinema);
    }
}




