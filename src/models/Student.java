package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int id;
    private String department;
    private List<String> enrolledCourses;

    // Additional properties for authentication
    private String username;
    private String password;

    public Student(String name, int id, String department, String username, String password) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.enrolledCourses = new ArrayList<>();
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Method for authentication
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // Method to view notifications
    public void viewNotifications() {
        // Implement view notifications functionality
    }

    // Method to view events
    public void viewEvents() {
        // Implement view events functionality
    }

    // Method to download notes
    public void downloadNotes(String courseName) {
        // Implement download notes functionality
    }

}