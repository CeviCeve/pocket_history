package by.ph.data;

import android.graphics.drawable.Drawable;

public class UserData {

    private String name;
    private String mail;
    private String password;

    private Integer visited_places;
    private Integer quizzes;
    private Integer save_places;

    private Drawable drawable;

    public UserData(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
}
