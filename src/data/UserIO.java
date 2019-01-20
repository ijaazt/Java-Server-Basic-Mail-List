package data;
import java.io.*;
import java.util.*;
import business.User;
import com.oracle.javafx.jmx.json.JSONFactory;
import com.oracle.javafx.jmx.json.JSONWriter;
import

public class UserIO {
    public static void addRecord(User user, String filename) throws IOException {
        File file = new File(filename);
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.println(user.getEmailAddress() + "|");
        out.println();
    }

    public static User getUser() {

    }

    public static ArrayList<User> readRecords(String file) throws IOException {

    }


}
