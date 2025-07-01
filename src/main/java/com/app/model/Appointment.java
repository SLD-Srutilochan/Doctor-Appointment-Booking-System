package com.app.model;

public class Appointment {
    private String referenceId;
    private String patientName;
    private int age;
    private String phone;
    private String address;
    private String reason;
    private String doctorName;
    private String department;
    private String time;

    public Appointment() {}

    public Appointment(String referenceId, String patientName, int age, String phone,
                       String address, String reason, String doctorName,
                       String department, String time) {
        this.referenceId = referenceId;
        this.patientName = patientName;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.reason = reason;
        this.doctorName = doctorName;
        this.department = department;
        this.time = time;
    }

    // Getters
    public String getReferenceId() { return referenceId; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getReason() { return reason; }
    public String getDoctorName() { return doctorName; }
    public String getDepartment() { return department; }
    public String getTime() { return time; }

    // Setters
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setAge(int age) { this.age = age; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setReason(String reason) { this.reason = reason; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public void setDepartment(String department) { this.department = department; }
    public void setTime(String time) { this.time = time; }
}
