package by.ph.data;

import android.graphics.drawable.Drawable;


public class UserData {

    private String name;
    private String mail;
    private String password;

    private Integer visited_places;
    private Integer quizzes = new Integer(0);
    private Integer save_places = new Integer(0);

    private Drawable drawable;

    public UserData(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public UserData(String name, String mail, String password, Integer visited_places, Integer quizzes, Integer save_places) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.visited_places = visited_places;
        this.quizzes = quizzes;
        this.save_places = save_places;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public Integer getVisited_places() {
        return visited_places;
    }

    public Integer getQuizzes() {
        return quizzes;
    }

    public Integer getSave_places() {
        return save_places;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setSave_places(Integer save_places) {
        this.save_places = save_places;
    }

    public void setQuizzes(Integer quizzes) {
        this.quizzes = quizzes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}