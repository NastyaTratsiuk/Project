package service;

import objects.*;

import java.util.ArrayList;
import java.util.List;

public class CinemaService {
    public static User addUser(User user, Cinema cinema) {
        cinema.getUsers().add(user);
        FileService.updateCinemaState(cinema);
        return user;
    }

    public static User currentUser(User user, Cinema cinema) {
        cinema.setCurrentUser(user);
        FileService.updateCinemaState(cinema);
        return user;
    }

    public static Film addFilm(Film film, Cinema cinema) {
        cinema.getFilms().add(film);
        FileService.updateCinemaState(cinema);
        return film;
    }

    public static Ticket addTicket(Ticket ticket, Cinema cinema) {
        cinema.getTickets().add(ticket);
        FileService.updateCinemaState(cinema);
        return ticket;
    }

    public static List<User> getAllUsers(Cinema cinema) {
        updateUsers(cinema);
        FileService.updateCinemaState(cinema);
        return cinema.getUsers();
    }

    public static List<Film> getAllFilms(Cinema cinema) {
        updateFilms(cinema);
        FileService.updateCinemaState(cinema);
        return cinema.getFilms();
    }

    public static List<Ticket> getAllTickets(Cinema cinema) {
        updateTicket(cinema);
        FileService.updateCinemaState(cinema);
        return cinema.getTickets();
    }

    public static void updateUsers(Cinema cinema) {
        List<User> users = new ArrayList<>();
        users.add(new User("Oleg", "Ol1234", UserType.REGULAR));
        users.add(new User("Stepan", "Step", UserType.REGULAR));
        users.add(new User("Kate", "K1234", UserType.MANAGER));
        users.add(new User("Nastya", "Na123", UserType.MANAGER));
        users.add(new User("Denis", "Den", UserType.ADMIN));
        users.add(new User("Lena", "Leana", UserType.ADMIN));
        cinema.setUsers(users);
    }

    public static void updateFilms(Cinema cinema) {
        List<Film> films = new ArrayList<>();
        films.add(new Film(123, "Bravo!", "24 May 2020 20:00:00", cinema.getTickets()));
        films.add(new Film(145, "New York!", "28 May 2020 17:30:00", cinema.getTickets()));
        cinema.setFilms(films);
    }

    public static void updateTicket(Cinema cinema) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, cinema.getFilms().get(0), 200, true));
        tickets.add(new Ticket(2, cinema.getFilms().get(0), 200, true));
        tickets.add(new Ticket(3, cinema.getFilms().get(0), 200, true));
        tickets.add(new Ticket(1, cinema.getFilms().get(1), 200, true));
        tickets.add(new Ticket(2, cinema.getFilms().get(1), 200, true));
        tickets.add(new Ticket(3, cinema.getFilms().get(1), 200, true));
        cinema.setTickets(tickets);
    }
}

