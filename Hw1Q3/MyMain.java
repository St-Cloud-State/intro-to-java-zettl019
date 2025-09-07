// MyMain.java
import java.io.*;

public class MyMain {
    public static void main(String[] args) throws IOException {
        PersonList plist = new PersonList();

        BufferedReader in = new BufferedReader(
            new FileReader("/workspaces/intro-to-java-zettl019/Hw1Q3/person.txt")
        );
        plist.store(in);
        in.close();

        OutputStream out = System.out;
        plist.display(out);

        System.out.println("Testing real IDS...");
        System.out.println(plist.find("2"));
        System.out.println(plist.find("10"));
        System.out.println(plist.find("7"));

        System.out.println("Testing non existing IDs...");
        System.out.println(plist.find("ABCD"));
        System.out.println(plist.find("11"));
        System.out.println(plist.find("0"));
    }
}
