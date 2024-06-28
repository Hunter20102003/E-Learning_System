package Model;

import java.util.ArrayList;

/**
 *
 * @author _aquyndz
 */

public class QuizDBO {
    
    private int quizId;
    private String quizName;
    private int quizMinutes;
    private boolean is_locked;
    private ArrayList<QuestionsDBO> question_list;
    private int locked = 0;

    public QuizDBO() {
    }

    public QuizDBO(int quizId, String quizName, int quizMinutes, boolean is_locked) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizMinutes = quizMinutes;
        this.is_locked = is_locked;
    }
    

    public QuizDBO(int quizId, String quizName, int quizMinutes, boolean is_locked, ArrayList<QuestionsDBO> question_list) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizMinutes = quizMinutes;
        this.is_locked = is_locked;
        this.question_list = question_list;
    }

 
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }


    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getQuizMinutes() {
        return quizMinutes;
    }

    public void setQuizMinutes(int quizMinutes) {
        this.quizMinutes = quizMinutes;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    @Override
    public String toString() {
        return "QuizDBO{" + "quizId=" + quizId + ", quizName=" + quizName + ", quizMinutes=" + quizMinutes + ", is_locked=" + is_locked + ", question_list=" + question_list + '}';
    }
 
    
}
