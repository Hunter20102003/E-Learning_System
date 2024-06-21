package Dal;

import Model.AnswersDBO;
import Model.MenteeScoreDBO;
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.UserCourseProgressDBO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author _aquyndz
 */
public class QuizDAO extends DBContext {

    public ArrayList<QuizDBO> getListQuizByLessonID(int id) {
        ArrayList<QuizDBO> listQuiz = new ArrayList<>();
        String sql = "select * from lesson as l join quizzes as q"
                + " on l.lesson_id=q.lesson_id where l.lesson_id= ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<QuestionsDBO> listQuestions = getListQuestionsByQuizID(r.getInt(5));
                listQuiz.add(new QuizDBO(r.getInt(5), r.getString(7), r.getInt(8), r.getBoolean(9), listQuestions));
            }
        } catch (Exception e) {
        }
        return listQuiz;
    }

    public ArrayList<QuestionsDBO> getListQuestionsByQuizID(int id) {
        ArrayList<QuestionsDBO> listQuestions = new ArrayList<>();
        String sql = "select * from quizzes q join questions qu "
                + "on q.quiz_id = qu.quiz_id where q.quiz_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<AnswersDBO> listAnswers = getListAnswersByQuestionID(r.getInt(6));
                listQuestions.add(new QuestionsDBO(r.getInt(6), r.getString(8), r.getInt(9), listAnswers));
            }

        } catch (Exception e) {
        }

        return listQuestions;
    }

    public ArrayList<AnswersDBO> getListAnswersByQuestionID(int id) {
        ArrayList<AnswersDBO> listAnswers = new ArrayList<>();
        String sql = "select * from questions q join answers a "
                + "on q.question_id = a.question_id where q.question_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                listAnswers.add(new AnswersDBO(r.getInt(5), r.getString(7), r.getBoolean(8)));
            }
        } catch (Exception e) {
        }
        return listAnswers;
    }

    public ArrayList<AnswersDBO> getAnswersByQuestionID(int id) {
        ArrayList<AnswersDBO> listAnswers = new ArrayList<>();
        String sql = "select * from answers where question_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                listAnswers.add(new AnswersDBO(r.getInt(1), r.getString(3), r.getBoolean(4)));
            }
        } catch (Exception e) {

        }
        return listAnswers;
    }

    public QuizDBO getQuizById(int quizId) {
        String sql = "select * from quizzes where quiz_id = ?";
        QuizDBO quiz = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, quizId);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                quiz = new QuizDBO(r.getInt(1), r.getString(3), r.getInt(4), r.getBoolean(5));
            }
        } catch (Exception e) {
        }
        return quiz;
    }

    public void insertScoreMentee(int userId, int quizId, int score) {
        String sql = "INSERT INTO [dbo].[mentee_scores]\n"
                + "           ([user_id]\n"
                + "           ,[quiz_id]\n"
                + "           ,[score])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, userId);
            p.setInt(2, quizId);
            p.setInt(3, score);
            p.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean checkScoreUser(int userId, int quizId) {
        String sql = "select * from mentee_scores where "
                + "user_id = ? and quiz_id = ?";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, userId);
            p.setInt(2, quizId);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void UpdateScoreMentee(int score, int userId, int quizId) {
        String sql = "update mentee_scores \n"
                + "                set score = ? where user_id = ? and quiz_id= ? ";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, score);
            p.setInt(2, userId);
            p.setInt(3, quizId);
            p.executeUpdate();
        } catch (Exception e) {
        }
    }

    public MenteeScoreDBO getScoreByUserIdQuizId(int userId, int quizId) {
        String sql = "select * from mentee_scores where user_id = ? and quiz_id = ?";
        MenteeScoreDBO UserScore = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, userId);
            p.setInt(2, quizId);
            ResultSet r = p.executeQuery();
            if(r.next()){
                UserScore = new MenteeScoreDBO(r.getInt(1),r.getInt(2),r.getInt(3));
            }
        } catch (Exception e) {
        }
        return UserScore;
    }
    
  

    public static void main(String[] args) {
        QuizDAO dao = new QuizDAO();
        //dao.insertScoreMentee(24,1,3);
        System.out.println(dao.getScoreByUserIdQuizId(1, 1));
        //dao.UpdateScoreMentee(10,24,1);
    }
}
