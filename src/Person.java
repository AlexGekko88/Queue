import java.util.ArrayList;
import java.util.List;

public class Person {
    static List<Person> listOfPersons = new ArrayList<>();
    private String name;
    private String surname;
    private int tickets;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.tickets = 0;
        listOfPersons.add(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    static List<Person> getListOfPersons() {
        return listOfPersons;
    }

    public String toString() {
        return name + " " + surname + " " + tickets;
    }

    public void spendTicket() {
        this.tickets--;
    }
}
