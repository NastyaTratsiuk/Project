package view;

import objects.Cinema;
import service.FileService;
import service.FilmService;
import service.NoSuchItemExeption;
import service.UserService;

import java.util.Scanner;

public class AdminConsole {
    public static Cinema cinema;

    public static void main(String[] args) {

        cinema = FileService.getCinemaState();

        System.out.println("Hello user!");

        Scanner scanner = new Scanner(System.in);
        loginUser();
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1- View the list of events.");
            System.out.println("2- Delete movie.");
            System.out.println("3- Delete user.");
            System.out.println("4- Change user password.");
            System.out.println("5- Exit");
            switch (scanner.nextInt()) {
                case 1: {
                    editEvents();
                    break;
                }
                case 2: {
                    deleteMovie();
                    break;
                }
                case 3: {
                    UserService.printUser(cinema);
                    deleteUser();
                    break;
                }
                case 4: {
                    changeUser();
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
            }
        }
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
    public static void loginUser () {
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        System.out.println("Input password");
        String password = scanner.next();
        UserService.loginUserManager(login, password, cinema);
    }
    public static void deleteMovie () {
        FilmService.printFilm(cinema);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number film, please!");
        int numberFilm = scanner.nextInt();
        FilmService.deleteMovieAdmin(numberFilm, cinema);
    }
    public static void deleteUser () {
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        UserService.deleteUserAdmin(login, cinema);
    }
    public static void changeUser () {
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        UserService.changeUserAdminPassword(login, cinema);
    }


}

