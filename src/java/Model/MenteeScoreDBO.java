/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

/**
 *
 * @author quyendz03
 */

public class MenteeScoreDBO {
    private int userId;
    private int coureId;
    private int score;

    public MenteeScoreDBO() {
    }

    public MenteeScoreDBO(int userId, int coureId, int score) {
        this.userId = userId;
        this.coureId = coureId;
        this.score = score;
    }

    public MenteeScoreDBO(int score) {
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCoureId() {
        return coureId;
    }

    public void setCoureId(int coureId) {
        this.coureId = coureId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MenteeScoreDBO{" + "userId=" + userId + ", coureId=" + coureId + ", score=" + score + '}';
    }
    

}
