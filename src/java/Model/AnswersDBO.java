package Model;

/**
 *
 * @author _aquyndz
 */

public class AnswersDBO {
    private int answerId;
    private String answerText;
    private boolean isCorrect;

    public AnswersDBO() {
    }

    public AnswersDBO(int answerId, String answerText, boolean isCorrect) {
        this.answerId = answerId;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "AnswersDBO{" + "answerId=" + answerId + ", answerText=" + answerText + ", isCorrect=" + isCorrect + '}';
    }

  
    
    
}
