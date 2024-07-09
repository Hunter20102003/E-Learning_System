package Dal;

import Model.AnswersDBO;
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.UserCourseProgressDBO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public int addQuizByLessonId(int lessonId, String title, int duration, int active) {
        int n = 0;
        String sql = "Insert into quizzes values (?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, lessonId);
            p.setString(2, title);
            p.setInt(3, duration);
            p.setInt(4, active);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int addQuizByLessonId(int lessonId, String title, int active) {
        int n = 0;
        String sql = "Insert into quizzes values (?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, lessonId);
            p.setString(2, title);
            p.setInt(3, active);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int addQuestionByQuizId(int quizId, String question_text, int type_id) {
        String sql = "INSERT INTO questions (quiz_id, question_text, type_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setInt(1, quizId);
            p.setString(2, question_text);
            p.setInt(3, type_id);

            int n = p.executeUpdate();
            if (n > 0) {
                ResultSet generatedKeys = p.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the auto-generated key
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return 0; // Return 0 if insertion failed or no keys were generated
    }

    public int addAnswerByQuestionId(int questionId, String answer_text, int isCorrect) {
        int n = 0;
        String sql = "Insert into answers values (?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, questionId);
            p.setString(2, answer_text);
            p.setInt(3, isCorrect);

            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int editQuizById(int quizId, String title, int duration, int active) {
        int n = 0;
        String sql = "UPDATE quizzes SET quiz_name=?, duration_minutes=?, is_locked=? WHERE quiz_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, title);
            p.setInt(2, duration);
            p.setInt(3, active);
            p.setInt(4, quizId);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int editQuestionById(int questionId, String question_text) {
        int n = 0;
        String sql = "UPDATE questions SET question_text=? WHERE question_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, question_text);
            p.setInt(2, questionId);

            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }
     public int editQuestionById(int questionId, String question_text,int typeId) {
        int n = 0;
        String sql = "UPDATE questions SET question_text=? ,type_id=? WHERE question_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            
            p.setString(1, question_text);
            p.setInt(2, typeId);
            p.setInt(3, questionId);

            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int editAnswerById(int answerId, String answer_text, int isCorrect) {
        int n = 0;
        String sql = "UPDATE answers SET answer_text=? , is_correct=? WHERE answer_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, answer_text);
            p.setInt(2, isCorrect);
            p.setInt(3, answerId);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int removeQuizById(int quizId) {
        int n = 0;
        String sql = "delete from quizzes where quiz_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, quizId);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int removeQuestionById(int questionId) {
        int n = 0;
        String sql = "delete from questions where question_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, questionId);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public int removeAnswerById(int answerId) {
        int n = 0;
        String sql = "delete from answers where answer_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, answerId);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }
    public int removeAllAnswerOfQuestionByQuestionId(int questionId) {
        int n = 0;
        String sql = "delete from answers where question_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, questionId);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }

        return n;
    }

    public QuestionsDBO getQuestionById(String questionId) {
        QuestionsDBO question = null;
        String sql = "select * from questions as q "
                + "join question_type as qt on q.type_id=qt.type_id "
                + "where question_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, questionId);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<AnswersDBO> answersList = getAnswersByQuestionID(Integer.parseInt(questionId));
                question = new QuestionsDBO(
                        Integer.parseInt(questionId),
                        r.getString("question_text"),
                        r.getInt("type_id"),
                        answersList
                );

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return question;
    }
          public UserCourseProgressDBO getUserCourseProgress(int userId, int courseId) {
        String sql = "select * from UserCourseProgress where user_id = ? and course_id = ? ";
        UserCourseProgressDBO UserCourseProgress = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, userId);
            p.setInt(2, courseId);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                UserCourseProgress = new UserCourseProgressDBO(r.getInt(1), r.getInt(2), r.getDate(3), r.getInt(4));
            }
        } catch (Exception e) {
        }
        return UserCourseProgress;
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

    public static void main(String[] args) {
        QuizDAO dao = new QuizDAO();
        //dao.insertScoreMentee(24,1,3);
        //System.out.println(dao.getQuizById(1));
        //dao.UpdateScoreMentee(10, 24, 1);
        System.out.println("");
        //  System.out.println(dao.addQuizByLessonId(2,"a",2,1));
        //  System.out.println(dao.editQuizById(4, "va", 0, 0));
        // System.out.println(dao.removeQuizById(3));
        //  System.out.println(dao.addAnswerByQuestionId(22, "3", 0));
        // System.out.println(dao.editAnswerById(84, "4", 0));
//        System.out.println(dao.getListQuizByLessonID(0));
//        System.out.println(dao.getQuizById(1));
        // System.out.println(dao.getQuestionById("1"));
    }

}
