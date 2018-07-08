package Main;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    private Socket client;
    private ObjectInputStream is;
    private ObjectOutputStream os;

    public Client() {
        client = null;
        is = null;
        os = null;
    }

    public void start() {
        try {
            client = new Socket("localhost", 49527);
            os = new ObjectOutputStream(client.getOutputStream());
            os.flush();
            is = new ObjectInputStream(client.getInputStream());   
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public void connect(ArrayList<ArrayList<Object>> message) {
        try {
            os.writeObject(message);

            ArrayList<ArrayList<Object>> answer = (ArrayList<ArrayList<Object>>)is.readObject();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
