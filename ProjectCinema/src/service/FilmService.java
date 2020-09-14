package service;

import objects.Cinema;
import objects.Film;
import objects.Ticket;

import java.util.List;
import java.util.Scanner;

public class FilmService {

    public static void printFilm(Cinema cinema) {
        for (int i = 0; i < cinema.getFilms().size(); i++) {
            System.out.println("Number film: " + i + " " + cinema.getFilms().get(i));
        }
    }

    public static List<Film> changeNameFilm(int numberFilm, Cinema cinema) throws NoSuchItemExeption {
        if (numberFilm <= cinema.getFilms().size()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a new film name!");
            String newName = scanner.next();
            cinema.getFilms().get(numberFilm).setName(newName);
            FileService.updateCinemaState(cinema);
        }else{
            throw new NoSuchItemExeption("Movie number entered incorrectly");
        }
        return cinema.getFilms();
    }

    public static List<Film> changeDateFilm(int numberFilm, Cinema cinema){
        if (numberFilm <= cinema.getFilms().size()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a new film date!");
            System.out.println("Format date: dd MMM yyyy hh:mm:ss");
            String newDate = scanner.nextLine();
            cinema.getFilms().get(numberFilm).setDate(newDate);
            FileService.updateCinemaState(cinema);
            System.out.println(cinema.getFilms().get(numberFilm));
        }
        return cinema.getFilms();
    }

    public static List<Film> deleteMovieAdmin (int numberFilm, Cinema cinema){
        int number = 0;
        for (Ticket ticket: cinema.getTickets()) {
            if (ticket.getFilm() == cinema.getFilms().get(numberFilm)) {
                cinema.getTickets().remove(number);
            }
            number ++;
        }
        cinema.getFilms().remove(numberFilm);
        FileService.updateCinemaState(cinema);
        return cinema.getFilms();
    }

}

