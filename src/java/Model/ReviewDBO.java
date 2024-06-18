

package Model;

import java.util.Date;


public class ReviewDBO {
    private int user_id;
    private int course_id;
    private double rating;
    private String review_text;
    private Date review_date;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }

    @Override
    public String toString() {
        return "ReviewDBO{" + "user_id=" + user_id + ", course_id=" + course_id + ", rating=" + rating + ", review_text=" + review_text + ", review_date=" + review_date + '}';
    }



  
}
