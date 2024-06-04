package Dal;

import java.sql.Date;



public class SubLessonDBO {

    private int id;
    private String title;
    private String content;
    private String description;
    private Date creation_date;
    private String video_link;
    private boolean is_locked;

    public SubLessonDBO() {
    }

    public SubLessonDBO(int id, String title, String content, String description, Date creation_date, String video_link, boolean is_locked) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
        this.creation_date = creation_date;
        this.video_link = video_link;
        this.is_locked = is_locked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    @Override
    public String toString() {
        return "SubLessonDBO{" + "id=" + id + ", title=" + title + ", content=" + content + ", description=" + description + ", creation_date=" + creation_date + ", video_link=" + video_link + ", is_locked=" + is_locked + '}';
    }

     
    
}
