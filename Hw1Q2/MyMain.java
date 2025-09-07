import java.io.*;
import java.util.LinkedList;


public class MyMain{
    public static void main(String[] args) throws IOException{
        LinkedList<Person> people = new LinkedList<Person>(); //List of people
        //Opens person.txt and loads each line into list of person objects
        BufferedReader in = new BufferedReader(new FileReader("/workspaces/intro-to-java-zettl019/Hw1Q2/person.txt"));
        store(in, people);
        in.close();
        //Print to console all the person objects from the list
        OutputStream out = System.out;
        display(out, people);
        //Testing real ids, ids are labled 1-10 for each person and there are 10 people in total
        System.out.println("Testing real IDS...");
        int findIndex = find("2", people); //Tests for id 2
        System.out.println(findIndex);
        findIndex = find("10", people); //Tests for id 10
        System.out.println(findIndex); 
        findIndex = find("7", people); //Tests for id 7
        System.out.println(findIndex); 

        //Testing fake ids
        System.out.println("Testing non existing IDs");
        findIndex = find("ABCD", people); 
        System.out.println(findIndex);
        findIndex = find("11", people); 
        System.out.println(findIndex); 
        findIndex = find("0", people); 
        System.out.println(findIndex); 

    }


private static void store(BufferedReader in, LinkedList<Person> people)throws IOException{
    String line;
    //Read file line by line until null
    while((line = in.readLine())!= null){
        //Split line into 3 parts: first name, last name, id
        String[] parts = line.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];
        String id = parts[2];
        //Create new person using parts read in
        people.add(new Person(firstName, lastName, id));
    }
}

private static void display(OutputStream out, LinkedList<Person> people)throws IOException{
    //Iterate through list + print each person
    for(int i = 0; i< people.size(); i++){
        Person p = people.get(i);
        String line = p.toString();
        //Convert string to bytes since OutputStream works with bytes
        out.write(line.getBytes());
        out.write("\n".getBytes()); //adds newline after every person so easier to read

    }

}

private static int find(String sid, LinkedList<Person> people){
    int location = -1; 
    //Loop through list + compare ids
    for(int i = 0; i < people.size(); i++){
        if (people.get(i).getId().equals(sid)) {
            //if match found save position and stop searching
            location = i + 1; 
            break; 
        } 
    }
    //returns index found otherwise -1
    return location;
    }
}

