package objects;

import java.io.Serializable;
import java.util.UUID;

public class Ticket implements Serializable {

    private UUID id;
    private int placeNumber;
    User user;
    Film film;
    private int price;
    private boolean isAvailable;

    public Ticket(int placeNumber, User user, Film film, int price, boolean isAvailable){
        this.id = UUID.randomUUID();
        this.placeNumber = placeNumber;
        this.user =user;
        this.film = film;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    public Ticket(int placeNumber, Film film, int price, boolean isAvailable){
        this.id = UUID.randomUUID();
        this.placeNumber = placeNumber;
        this.film = film;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public User getUser() {
        return user;
    }

    public Film getFilm() {
        return film;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("id=").append(id);
        sb.append(",placeNumber=").append(placeNumber);
        sb.append(", user=").append(user);
        sb.append(", film=").append(film);
        sb.append(", price=").append(price);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append('}');
        return sb.toString();
    }

}
