/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import Model.CommentDBO;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

;

/**
 *
 * @author ADMIN
 */
public class CommentDAO extends DBContext {

    public void InsertComment(String parentid, int subLessonId, int userId, String content) {
        String sql = "INSERT INTO [dbo].[Comments]\n"
                + "           ([parent_id]\n"
                + "           ,[sub_lesson_id]\n"
                + "           ,[user_id]\n"
                + "           ,[content]\n"
                + "           ,[created_at])\n"
                + "             VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, parentid);
            p.setInt(2, subLessonId);
            p.setInt(3, userId);
            p.setString(4, content);
            p.setTimestamp(5, new Timestamp(new Date().getTime()));
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(int commentId) {
        String sql = "EXEC DeleteCommentAndReplies @comment_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, commentId);
            p.executeUpdate();
        } catch (Exception e) {
        }
    }

    
    public ArrayList<CommentDBO> getCommentsFromDatabase(int subLessonId) {
        ArrayList<CommentDBO> listComment = new ArrayList<>();
        String sql = "WITH comment_hierarchy AS (\n"
                + "    SELECT \n"
                + "        c.comment_id,\n"
                + "        c.parent_id,\n"
                + "        c.sub_lesson_id,\n"
                + "        c.user_id,\n"
                + "        c.content,\n"
                + "        c.created_at,\n"
                + "        u.first_name + ' ' + u.last_name AS [name],\n"
                + "        u.avatar\n"
                + "    FROM Comments c\n"
                + "    INNER JOIN [User] u ON c.user_id = u.user_id\n"
                + "    WHERE c.sub_lesson_id = ? \n"
                + "    UNION ALL\n"
                + "    SELECT \n"
                + "        c.comment_id,\n"
                + "        c.parent_id,\n"
                + "        c.sub_lesson_id,\n"
                + "        c.user_id,\n"
                + "        c.content,\n"
                + "        c.created_at,\n"
                + "        u.first_name + ' ' + u.last_name AS [name],\n"
                + "        u.avatar\n"
                + "    FROM Comments c\n"
                + "    INNER JOIN [User] u ON c.user_id = u.user_id\n"
                + "    INNER JOIN comment_hierarchy p ON c.parent_id = p.comment_id\n"
                + ")\n"
                + "SELECT DISTINCT * FROM comment_hierarchy\n"
<<<<<<< HEAD
<<<<<<< HEAD
                + "ORDER BY parent_id, created_at DESC\n"
=======
>>>>>>> origin/front-end
=======
                + "ORDER BY parent_id, created_at DESC\n"
>>>>>>> origin/profile
                + "OPTION (MAXRECURSION 0);"; // Setting MAXRECURSION to 0 for no limit

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, subLessonId);
            try (ResultSet rs = p.executeQuery()) {
                HashMap<Integer, CommentDBO> commentMap = new HashMap<>();
                while (rs.next()) {
                    int commentId = rs.getInt("comment_id");
                    int parentId = rs.getInt("parent_id");
                    int userId = rs.getInt("user_id");
                    int actualSubLessonId = rs.getInt("sub_lesson_id");
                    String content = rs.getString("content");
                    Timestamp timestamp = rs.getTimestamp("created_at");
                    LocalDateTime createdAt = timestamp.toLocalDateTime();
                    String name = rs.getString("name");
                    String avatar = rs.getString("avatar");

                    // Tính toán sự chênh lệch thời gian
                    LocalDateTime now = LocalDateTime.now();
                    Duration duration = Duration.between(createdAt, now);

                    String timeDifference;
                    if (duration.toDays() >= 1) {
                        timeDifference = String.format("%d days ago", duration.toDays());
                    } else if (duration.toHours() >= 1) {
                        timeDifference = String.format("%d hours ago", duration.toHours());
                    } else if (duration.toMinutes() >= 1) {
                        timeDifference = String.format("%d minutes ago", duration.toMinutes());
                    } else {
                        timeDifference = String.format("%d seconds ago", duration.getSeconds());
                    }

                    // Tạo đối tượng CommentDBO
                    CommentDBO comment = new CommentDBO(commentId, parentId, actualSubLessonId, userId, content, createdAt, name, avatar, timeDifference ,new ArrayList<>());
                    commentMap.put(commentId, comment);

                    if (parentId == 0) {
                        listComment.add(comment);
                    } else {
                        CommentDBO parentComment = commentMap.get(parentId);
                        if (parentComment != null) {
                            parentComment.getReplies().add(comment);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listComment;
    }



    public static void main(String[] args) {
        CommentDAO dao = new CommentDAO();
<<<<<<< HEAD
        ArrayList<CommentDBO> list = dao.getCommentsFromDatabase(2);
        System.out.println(list);
=======
//        ArrayList<CommentDBO> list = dao.getCommentsFromDatabase(2);
//        System.out.println(list);
        System.out.println(dao.getCommentsFromDatabase(2));
>>>>>>> origin/profile
        //dao.InsertComment("33", 1, 30, "Ngọt ngào đến mấy cũng tan thành mây");
    }
    

}
