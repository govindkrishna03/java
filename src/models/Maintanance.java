package models;

package com.example.campusconnect.models;

public class MaintenanceRequest {
    private String building;
    private String classroom;
    private String problem;

    public MaintenanceRequest(String building, String classroom, String problem) {
        this.building = building;
        this.classroom = classroom;
        this.problem = problem;
    }

    // Getters and setters

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    // Method to submit maintenance request
    public void submitRequest() {
        // Implement submit maintenance request functionality
        System.out.println("Maintenance Request submitted for:");
        System.out.println("Building: " + building);
        System.out.println("Classroom: " + classroom);
        System.out.println("Problem: " + problem);
    }
}
