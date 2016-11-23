package model;

import java.io.*;

/**
 * Created by roberto on 22/11/16.
 */
public class UserDatabase {

    public UserDatabase(){

    }

    public boolean logInUser(String username, String password){
        BufferedReader br = null;
        try {
            String currentLine;
            String databaseUsername;
            String databaseUserPassword;
            br = new BufferedReader(new FileReader("/home/roberto/IdeaProjects/Library/src/persistence/users.txt"));
            while ((currentLine = br.readLine()) != null) {
                databaseUsername = currentLine.split(",")[0];
                databaseUserPassword = currentLine.split(",")[1];
                if(databaseUsername.equals(username) && databaseUserPassword.equals(password)) return true;
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("El fichero no existe" + e);
        }
        return false;
    }

    public boolean registerUser(String username, String password){
        if(username.length()<1 || password.length()<1) return false;
        try(FileWriter fw = new FileWriter("/home/roberto/IdeaProjects/Library/src/persistence/users.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(username+","+password);
            System.out.println("User registered");
            return true;
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        return false;
    }
}
