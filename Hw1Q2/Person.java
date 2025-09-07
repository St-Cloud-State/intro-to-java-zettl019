public class Person{
    private String firstName;
    private String lastName;
    private String id;

    public Person(String personFirstname, String personLastname, String personId){
        firstName = personFirstname;
        lastName = personLastname;
        id = personId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName; 
    }
    public String getId(){
        return id; 
    }

    @Override
    public String toString(){
        return "First_Name: " + firstName + ", Last_Name: " + lastName + ", ID: " + id; 
    }
}