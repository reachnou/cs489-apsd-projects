package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private Date employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }

    public Employee (){}

    public Employee(long employeeId, String firstName, String lastName, String employmentDate, double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            this.employmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(employmentDate);
        } catch (Exception e) {
            this.employmentDate = null;
        }
        this.yearlySalary = yearlySalary;
    }

    public Employee(long employeeId, String firstName, String lastName, String employmentDate, double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            this.employmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(employmentDate);
        } catch (Exception e) {
            this.employmentDate = null;
        }
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }
}
