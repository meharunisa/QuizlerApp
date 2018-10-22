package com.assorttech.quizlerapp;

public class MultipleChoice {
    private int mQuestionID ,option1, option2,option3,option4,Answer;

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public int getOption1() {
        return option1;
    }

    public void setOption1(int option1) {
        this.option1 = option1;
    }

    public int getOption2() {
        return option2;
    }

    public void setOption2(int option2) {
        this.option2 = option2;
    }

    public int getOption3() {
        return option3;
    }

    public void setOption3(int option3) {
        this.option3 = option3;
    }

    public int getOption4() {
        return option4;
    }

    public void setOption4(int option4) {
        this.option4 = option4;
    }

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }

    public MultipleChoice(int questionResourceID, int Option1, int Option2, int Option3, int Option4, int answer){

        mQuestionID=questionResourceID;
        option1=Option1;
        option2=Option2;
        option3=Option3;
        option4=Option4;
        Answer=answer;
    }
}
