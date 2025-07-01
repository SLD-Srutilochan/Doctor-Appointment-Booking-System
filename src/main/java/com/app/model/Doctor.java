package com.app.model;

public class Doctor {
    private int id;
    private String name;
    private String department;
    private String fromTime;
    private String toTime;

    public Doctor(int id, String name, String department, String fromTime, String toTime) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getFromTime() { return fromTime; }
    public String getToTime() { return toTime; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setFromTime(String fromTime) { this.fromTime = fromTime; }
    public void setToTime(String toTime) { this.toTime = toTime; }
}
