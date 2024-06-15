package Model;

import java.util.ArrayList;

/**
 *
 * @author _aquyndz
 */

public class QuestionsDBO {
    private int questionId;
    private String questionText;
    private int typeId;
    private ArrayList<AnswersDBO> answers_list;

    public QuestionsDBO() {
    }

    public QuestionsDBO(int questionId, String questionText, int typeId, ArrayList<AnswersDBO> answers_list) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.typeId = typeId;
        this.answers_list = answers_list;
    }

    public ArrayList<AnswersDBO> getAnswers_list() {
        return answers_list;
    }

    public void setAnswers_list(ArrayList<AnswersDBO> answers_list) {
        this.answers_list = answers_list;
    }

 

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }


    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "QuestionsDBO{" + "questionId=" + questionId + ", questionText=" + questionText + ", typeId=" + typeId + ", answers_list=" + answers_list + '}';
    }

  
    
    
    
}
