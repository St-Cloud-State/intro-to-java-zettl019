// PersonList.java
import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> people;

    public PersonList() {
        people = new LinkedList<Person>();
    }

    public void store(BufferedReader in) throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            String[] parts = line.split(" ");
            String firstName = parts[0];
            String lastName  = parts[1];
            String id        = parts[2];
            people.add(new Person(firstName, lastName, id));
        }
    }

    public void display(OutputStream out) throws IOException {
        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            String line = p.toString();
            out.write(line.getBytes());
            out.write("\n".getBytes());
        }
    }

    public int find(String sid) {
        int location = -1;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId().equals(sid)) {
                location = i + 1;   // same as your Part 2
                break;
            }
        }
        return location;
    }
}
