package Main;

import SQLITE.Group;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private static ArrayList<ArrayList<Object>> message = new ArrayList<>();

    /**NACH ALLEN NEU HINZUGEFÜGTEN DATEN MUSS DER LOADER RE-INITILISED WERDEN
     * 
     * Sonstige Reihenfolge:
     * 1. User
     * 2. Group
     * 3. Message
     */

    public static boolean log_in(String email, String password) {
        //NUR ZU TEST ZWECKEN -> Noch nicht fertig

        byte[] crypted_password = Security.ByteArrayVerschlüsseln(password.getBytes(), email);

        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("login"));
        list.add(email);
        list.add(crypted_password);

        message.add(list);

        return Main.logged_in = true;
    }

    public static void register(String forname, String name, String email, byte[] password) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("register"));
        list.add(forname);
        list.add(name);
        list.add(email);
        list.add(password);

        message.add(list);
    }

    public static void deactivate(Integer User_ID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("deactivate"));
        list.add(User_ID);

        message.add(list);
    }

    public static void getUserData(Integer User_ID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("getUserData"));
        list.add(User_ID);

        message.add(list);
    }

    public static void updateUserPicture(byte[] picture, String type, String ID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("updateUserPicture"));
        list.add(picture);
        list.add(type);
        list.add(ID);

        message.add(list);
    }

    public static void updateGroupPicture(byte[] picture, String type, String ID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("updateGroupPicture"));
        list.add(picture);
        list.add(type);
        list.add(ID);

        message.add(list);
    }

    public static void updateStatus(String status, Integer ID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("updateStatus"));
        list.add(status);
        list.add(ID);

        message.add(list);
    }

    public static void updateUsername(String forname, String name, Integer ID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("updateUsername"));
        list.add(forname);
        list.add(name);
        list.add(ID);

        message.add(list);
    }

    public static void createGroup(String name, ArrayList<String> user_emails) {
	//ID und Userdata vom server getten und in DB einfügen
	//Falls online: In Loader adden und GUIManager 
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("createGroup"));
        list.add(name);
        list.add(user_emails);

        message.add(list);
    }

    public static void getGroupName(Integer GroupID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("getGroupName"));
        list.add(GroupID);

        message.add(list);
    }

    public static void addUsertoGroup(String user_email, Integer GroupID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("addUsertoGroup"));
        list.add(user_email);
        list.add(GroupID);

        message.add(list);
    }

    public static void removeUserfromGroup(String user_email, Integer GroupID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("removeUserfromGroup"));
        list.add(user_email);
        list.add(GroupID);

        message.add(list);
    }

    public static void addMessage(Integer UserID, Integer GroupID, byte[] messages) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("addMessage"));
        list.add(UserID);
        list.add(GroupID);
        list.add(messages);

        message.add(list);
    }

    public static void checkMessage(Integer UserID) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("checkMessage"));
        list.add(UserID);

        message.add(list);
    }
	
    public static void sendMessage(Group activeGroup, String msg) {
		
    }

    public static void sendMessage() {
		
    }

    public class SendStation extends Thread {

        Client client;
        Timer timer;
        TimerTask task;
        public SendStation() {
            client = new Client();
            client.start();
            
            timer = new Timer();
            task = new TimerTask() {
                public void run() {
                    while(!isInterrupted()) {
                        try {
                            Thread.sleep(2000); //2 sek.
                            client.connect(message);
                            message = new ArrayList<>();
                        }
                        catch(InterruptedException e) {
                            interrupt();
                        }
                    }
                    timer.cancel();
                }
            };
        }

        public void run() {
            timer.scheduleAtFixedRate(task,0,0);
        }
    }
}
