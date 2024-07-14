package Model;

import java.util.Date;

public class UserWithEnrollment {

    private UserDBO user;
    private Date enrollmentDate;

    public UserWithEnrollment() {
    }

    public UserWithEnrollment(UserDBO user, Date enrollmentDate) {
        this.user = user;
        this.enrollmentDate = enrollmentDate;
    }

    public UserDBO getUser() {
        return user;
    }

    public void setUser(UserDBO user) {
        this.user = user;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "UserWithEnrollment{" +
                "user=" + user +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
