/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author quyendz03
 */
public class CommentDBO {

    private int commentId;
    private int parentId;
    private int subLessonId;
    private int userId;
    private String content;
    private LocalDateTime createdAt;
    private String name;
    private String avatar;
    private ArrayList<CommentDBO> replies;
    private String timeDifference; 

    public CommentDBO() {
    }


    public CommentDBO(int commentId, int parentId, int subLessonId, int userId, String content, LocalDateTime createdAt, String name, String avatar, ArrayList<CommentDBO> replies) {
        this.commentId = commentId;
        this.parentId = parentId;
        this.subLessonId = subLessonId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.name = name;
        this.avatar = avatar;
        this.replies = replies;
    }

    public CommentDBO(int commentId, int parentId, int subLessonId, int userId, String content, LocalDateTime createdAt, String name, String avatar, String timeDifference,ArrayList<CommentDBO> replies) {
        this.commentId = commentId;
        this.parentId = parentId;
        this.subLessonId = subLessonId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.name = name;
        this.avatar = avatar;
        this.replies = replies;
        this.timeDifference = timeDifference;
    }

    public String getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(String timeDifference) {
        this.timeDifference = timeDifference;
    }
    
    
    

    public ArrayList<CommentDBO> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<CommentDBO> replies) {
        this.replies = replies;
    }
    
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSubLessonId() {
        return subLessonId;
    }

    public void setSubLessonId(int subLessonId) {
        this.subLessonId = subLessonId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "CommentDBO{" + "commentId=" + commentId + ", parentId=" + parentId + ", subLessonId=" + subLessonId + ", userId=" + userId + ", content=" + content + ", createdAt=" + createdAt + ", name=" + name + ", avatar=" + avatar + ", replies=" + replies + ", timeDifference=" + timeDifference + '}';
    }

  



}
