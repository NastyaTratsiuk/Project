package objects;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Film implements Serializable {

    private int id;
    private String name;
    LocalDateTime date;
    private List<Ticket> tickets;
    private String rfcFormat ;

    public Film(int id, String name, String rfcFormat, List<Ticket> tickets){
        this.id = id;
        this.name = name;
        this.rfcFormat = rfcFormat;
        this.tickets = tickets;
    }
    public Film(int id, String name,String rfcFormat ){
        this.id = id;
        this.rfcFormat = rfcFormat;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getDate(){
        return rfcFormat = date.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss"));
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setDate(String rfcFormat) {
        this.rfcFormat = rfcFormat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", date=").append(rfcFormat);
        sb.append('}');
        return sb.toString();
    }
}
