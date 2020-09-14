package service;

import objects.Cinema;
import objects.Film;
import objects.User;

import java.io.*;
import java.util.List;

public class FileService extends IService{


        private static final File file = new File("cinemaSave.txt");

        public static List<User> getAllUsers(Cinema cinema) {

            return null;
        }

        public static List<Film> getAllFilms(Cinema cinema) {
            return null;
        }

        public static void updateCinemaState (Cinema cinema){

            try{
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(cinema);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public static Cinema getCinemaState(){
            Cinema cinema = new Cinema();
            try{
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                cinema = (Cinema) objectInputStream.readObject();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
            return cinema;
        }
    }

