package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PensionPlan {
    private long planReferenceNumber;
    private Date enrollmentDate;
    private double monthlyContribution;

    @Override
    public String toString() {
        return "{" +
                "\"planReferenceNumber\": " + planReferenceNumber +
                ", \"enrollmentDate\": " + "\"" +enrollmentDate + "\"" +
                ", \"monthlyContribution\": " + monthlyContribution +
                '}';
    }

    public PensionPlan(){}

    public PensionPlan(long planReferenceNumber, String enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        try {
            this.enrollmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(enrollmentDate);
        } catch (Exception e) {
            this.enrollmentDate = null;
        }
        this.monthlyContribution = monthlyContribution;
    }

    public long getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(long planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}
