package service;

import objects.Cinema;
import objects.Ticket;
import objects.User;
import view.Main;

import java.util.List;
import java.util.Scanner;

public class UserService {

    public static User loginUser(String login, String password, Cinema cinema) {
        User userNew = new User(login, password);
        if(cinema.getUsers().contains(userNew)){
            CinemaService.currentUser(userNew,cinema);
            System.out.println("Login successful!");
        }else {
            System.out.println("Error try again!");
            Main.loginUser();
        }
        return null;
    }

    public static User loginUserManager(String login, String password, Cinema cinema){
        for (User user : cinema.getUsers()) {
            if (user.getLogin().
                    equals(login)
                    && user.getPassword().
                    equals(password)){
                CinemaService.currentUser(user,cinema);
                System.out.println("Login successful!");
            }
        }
        return null;
    }


    public static User registerUser(String login, String password, Cinema cinema) {
        User user = new User(login, password);
        CinemaService.currentUser(user,cinema);
        return CinemaService.addUser(user, cinema);
    }

    public static void printUser(Cinema cinema) {
        for (int i = 0; i < cinema.getUsers().size(); i++) {
            System.out.println("Number user: " + i + "Name user " + cinema.getUsers().get(i).getLogin());
        }
    }

    public static List<User> deleteUserAdmin ( String login, Cinema cinema){
        for (Ticket ticket: cinema.getTickets()) {
            if (ticket.getUser() != null && ticket.getUser().getLogin().equals(login)){
                ticket.setAvailable(true);
            }
        }
        cinema.getUsers().removeIf(user -> user.getLogin().equals(login));
        System.out.println("User deleted.");
        FileService.updateCinemaState(cinema);
        return cinema.getUsers();
    }

    public static List<User> changeUserAdminPassword (String login, Cinema cinema){
        for (User user : cinema.getUsers()) {
            if (user.getLogin().equals(login)){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new password!");
                String newPassword = scanner.next();
                user.setPassword(newPassword);
                FileService.updateCinemaState(cinema);
                System.out.println("Password changed!");
            }
        }
        return cinema.getUsers();
    }
}
