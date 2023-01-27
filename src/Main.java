import java.util.*;

public class Main {
    static final int LIMIT_OF_CLIENTS = 5; //  число посетителей аттракциона
    static final int LIMIT_OF_TICKETS = 5; //   max число билетов "в одни руки"
    static Random random = new Random();

    public static void main(String[] args) {
        //это все посетители парка развлечений (не все их них пойдут на аттракцион):
        new Person("Алексей", "Дюжев");
        new Person("Максим", "Орешкин");
        new Person("Мария", "Шукшина");
        new Person("Ольга", "Волкова");
        new Person("Саид", "Хадиев");
        new Person("Нина", "Ефимова");
        new Person("Светлана", "Цветкова");
        new Person("Михаил", "Ярочкин");
        new Person("Андрей", "Иванов");
        new Person("Пётр", "Стрелков");


        System.out.println(Person.getListOfPersons()); //выводим на экран всех посетителей парка
        List<Person> listOfClients = generateClients(Person.getListOfPersons()); //формируем из них список посетителей аттракциона
        System.out.println(listOfClients);//выводим его на экран

        Queue<Person> queue = new LinkedList<>();
        queue.addAll(listOfClients); //формируем очередь на аттракцион

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            System.out.println(current.getName() + " " + current.getSurname() + " прокатился на аттракционе.");
            current.spendTicket();
            if (current.getTickets() > 0) {
                queue.add(current);
            }
        }

    }

    //этот метод определяет, кто из посетителей парка пойдет на аттракцион и сколько ему достанется билетов:
    public static List<Person> generateClients(List<Person> listOfPersons) {
        List<Person> listOfClients = new ArrayList<>();
        for (int i = 0; i < LIMIT_OF_CLIENTS; i++) {
            int pos = random.nextInt(listOfPersons.size()); //случайным образом определяем индекс из списка listOfPersons
            Person personToAdd = listOfPersons.get(pos);//определяем будущего посетителя аттракциона
            listOfClients.add(personToAdd); //добавляем его в список
            listOfPersons.remove(personToAdd);//удаляем этого посетителя из списка listOfPersons во избежание дублирования
        }

        for (Person client : listOfClients) {
            client.setTickets(random.nextInt(LIMIT_OF_TICKETS) + 1);
        }
        return listOfClients;
    }
}