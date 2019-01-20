package data;
import java.io.*;
import java.util.*;
import business.User;
import com.oracle.javafx.jmx.json.JSONFactory;

import javax.json.*;


public class UserIO {
    public static void addRecord(User user, String filename) throws IOException {
        File file = new File(filename);
        JsonObjectBuilder jsonObject = Json.createObjectBuilder();
        jsonObject.add("Email Address", user.getEmailAddress()).add("First Name", user.getFirstName()).add("Last Name", user.getLastName());
        JsonArray array;
        if(file.exists()) {
            JsonReader in = Json.createReader(new FileInputStream(file));
            array = in.readArray();
            in.close();
        } else {
            array = JsonArray.EMPTY_JSON_ARRAY;
        }
        JsonWriter out = Json.createWriter(new FileWriter(file, false));
        array.add(jsonObject.build());
        out.writeArray(array);
        out.close();
    }

    public static User getUser(String emailAddress, String filename) throws IOException {
        File file = new File(filename);
        User user = new User();
        if(file.exists()) {
            JsonReader in = Json.createReader(new FileInputStream(file));
            for(JsonValue value: in.readArray()) {
                String userEmail = value.asJsonObject().getString("Email Address");
                if(emailAddress.equals(userEmail)) {
                    user.setFirstName(value.asJsonObject().getString("First Name"));
                    user.setLastName(value.asJsonObject().getString("Last Name"));
                    user.setEmailAddress(userEmail);
                }
            }
            in.close();
        }
        return user;
    }

    public static ArrayList<User> readRecords(String filename) throws IOException {
        File file = new File(filename);
        ArrayList<User> userArrayList = new ArrayList<User>();
        if(file.exists()) {
           JsonReader in = Json.createReader(new FileInputStream(file));
           JsonArray array = in.readArray();
           for(JsonValue value: array) {
               JsonObject jsonUser = value.asJsonObject();
               userArrayList.add(new User(jsonUser.getString("First Name"), jsonUser.getString("Last Name"), jsonUser.getString("Email Address")));
           }
        }
        return userArrayList;
    }


}
