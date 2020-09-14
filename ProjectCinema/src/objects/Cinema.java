package objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<User> users;
    private List<Ticket> tickets;
    private List<Film> films;
    private User currentUser;

    public Cinema(List<User> users, List<Ticket> tickets) {
        this.users = users;
        this.tickets = tickets;
    }

    public Cinema() {
        this.users = new ArrayList<User>();
        this.tickets = new ArrayList<Ticket>();
        this.films = new ArrayList<Film>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cinema{");
        sb.append("users=").append(users);
        sb.append(", tickets=").append(tickets);
        sb.append(", films=").append(films);
        sb.append('}');
        return sb.toString();
    }
}

