package org.example;

public class DatabaseConnection {
    private boolean isConnected;

    public void connect(){
        isConnected = true;
        System.out.println("Database Connected");
    }
    public void disConnect(){
        isConnected = false;
        System.out.println("Database disConnected");
    }

    public boolean isConnected() {
        return isConnected;
    }
}
