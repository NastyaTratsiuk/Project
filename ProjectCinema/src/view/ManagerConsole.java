package view;

import objects.Cinema;
import service.*;

import java.util.Scanner;

public class ManagerConsole {

    public static Cinema cinema;

    public static void main(String[] args){

        cinema = FileService.getCinemaState();
        TicketService.viewPurchasedTickets(cinema);

        System.out.println("Hello user!");

        Scanner scanner = new Scanner(System.in);
        loginUser();
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1- View the list of events");
            System.out.println("2- Buy ticket");
            System.out.println("3- Return ticket");
            System.out.println("4- Exit");
            switch (scanner.nextInt()) {
                case 1: {
                    editEvents();
                    break;
                }
                case 2: {
                    byuTicketUser();
                    break;
                }
                case 3: {
                    returnTicketUser();
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Typo!");

            }
        }
    }
    public static void loginUser() {
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        System.out.println("Input password");
        String password = scanner.next();
        UserService.loginUserManager(login, password, cinema);

    }

    public static void editEvents(){
        FilmService.printFilm(cinema);
        System.out.println("Input number: ");
        Scanner scanner = new Scanner(System.in);
        int numberFilm = scanner.nextInt();
        System.out.println("1. Change the name of the movie!");
        System.out.println("2. Change the date!");
        switch (scanner.nextInt()) {
            case 1: {
                try {
                    FilmService.changeNameFilm(numberFilm, cinema);
                } catch (NoSuchItemExeption noSuchItemExeption) {
                    noSuchItemExeption.printStackTrace();
                }
                break;
            }
            case 2: {
                FilmService.changeDateFilm(numberFilm, cinema);
                break;
            }
            default:
                System.out.println("Typo!");
        }
    }

    public static void byuTicketUser() {
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        FilmService.printFilm(cinema);
        System.out.println("Input number film, please!");
        int numberFilm = scanner.nextInt();
        TicketService.printTickets( cinema);
        System.out.println("Input number ticket, please! ");
        int numberTicket = scanner.nextInt();
        TicketService.puchaseTicketManager(login, numberTicket, cinema);
    }

    public static void byuTicketUser2(){
        Scanner scanner = new Scanner(System.in);
        FilmService.printFilm(cinema);
        System.out.println("Input number film, please!");
        int numberFilm = scanner.nextInt();
        TicketService.printTickets(cinema);
        System.out.println("Input number ticket, please! ");
        int numberTicket = scanner.nextInt();
        UserService.printUser(cinema);
        int numberUser = scanner.nextInt();
            TicketService.puchaseTicketManager2(numberTicket, numberUser, cinema);
    }

    public static void returnTicketUser(){
        TicketService.printTickets(cinema);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number ticket, please! ");
        int numberTicket = scanner.nextInt();
        TicketService.returnTicketManager(numberTicket, cinema);
    }
}
