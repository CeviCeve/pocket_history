package by.ph.data;


import android.graphics.drawable.Drawable;

import by.ph.Quiz;

public class QuizData {
    private Drawable drawable;
    private String[] one = new String[3];
    private int right;

    public QuizData(){}

    public QuizData(int right, String[] one, Drawable drawable) {
        this.right = right;
        this.one = one;
        this.drawable = drawable;
    }

    public QuizData(int right, String[] one) {
        this.right = right;
        this.one = one;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public String[] getOne() {
        return one;
    }

    public int getRight() {
        return right;
    }
}
