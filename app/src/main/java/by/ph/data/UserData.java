package by.ph.data;

public class UserData {

    private String name;
    private String mail;
    private String password;

    private Integer visited_places;
    private Integer quizzes;
    private Integer save_places;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVisited_places() {
        return visited_places;
    }

    public void setVisited_places(Integer visited_places) {
        this.visited_places = visited_places;
    }

    public Integer getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Integer quizzes) {
        this.quizzes = quizzes;
    }

    public Integer getSave_places() {
        return save_places;
    }

    public void setSave_places(Integer save_places) {
        this.save_places = save_places;
    }

    public UserData(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
}
