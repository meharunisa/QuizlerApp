package com.assorttech.quizlerapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    private TextView mQuestionTextView, mScoreTextView;
    private Button btnOption1, btnOption2, btnOption3, btnOption4;
    int mIndex;
    int mQuestion, mOption1, mOption2, mOption3, mOption4;
    int mScore;

    // TODO: question bank
    private MultipleChoice[] mQuestionBank = new MultipleChoice[]{
            new MultipleChoice(R.string.question_1, R.string.q1option1, R.string.q1option2, R.string.q1option3, R.string.q1option4, R.string.q1option3),
            new MultipleChoice(R.string.question_2, R.string.q2option1, R.string.q2option2, R.string.q2option3, R.string.q2option4, R.string.q2option2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreTextView=findViewById(R.id.score);

        if (savedInstanceState != null) {

            mScore = savedInstanceState.getInt("ScoreKey");
            mIndex = savedInstanceState.getInt("IndexKey");

       } else {
            mScore = 0;
            mIndex = 0;
       }

        mQuestionTextView = findViewById(R.id.qusetionView);
        btnOption1 = findViewById(R.id.button1);
        btnOption2 = findViewById(R.id.button2);
        btnOption3 = findViewById(R.id.button3);
        btnOption4 = findViewById(R.id.button4);

        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mOption1 = mQuestionBank[mIndex].getOption1();
        mOption2 = mQuestionBank[mIndex].getOption2();
        mOption3 = mQuestionBank[mIndex].getOption3();
        mOption4 = mQuestionBank[mIndex].getOption4();

        mQuestionTextView.setText(mQuestion);
        btnOption1.setText(mOption1);
        btnOption2.setText(mOption2);
        btnOption3.setText(mOption3);
        btnOption4.setText(mOption4);

        mScoreTextView.setText("Score "+mScore+"/"+mQuestionBank.length);

        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOption1 = mQuestionBank[mIndex].getOption1();
                checkAnswer(mOption1);
                updateQuestion();
            }
        });
        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOption2 = mQuestionBank[mIndex].getOption2();
                checkAnswer(mOption2);
                updateQuestion();
            }
        });
        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOption3 = mQuestionBank[mIndex].getOption3();
                checkAnswer(mOption3);
                updateQuestion();
            }
        });
        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(mOption4);
                updateQuestion();
            }
        });
    }

    private  void updateQuestion(){

        mIndex=(mIndex+1)%mQuestionBank.length;
        if (mIndex==0){
            final AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("your score"+"  "+mScore+" / "+mQuestionBank.length);
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });

            alert.setNegativeButton("Restart Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mScore=0;
                    mScoreTextView.setText("Score "+mScore+"/"+mQuestionBank.length);
                    dialog.cancel();
                }
            });

            alert.show();
        }

        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mOption1 = mQuestionBank[mIndex].getOption1();
        mOption2 = mQuestionBank[mIndex].getOption2();
        mOption3 = mQuestionBank[mIndex].getOption3();
        mOption4 = mQuestionBank[mIndex].getOption4();

        mQuestionTextView.setText(mQuestion);
        btnOption1.setText(mOption1);
        btnOption2.setText(mOption2);
        btnOption3.setText(mOption3);
        btnOption4.setText(mOption4);

        mScoreTextView.setText("Score "+mScore+"/"+mQuestionBank.length);

    }
    public void checkAnswer(int userSelection) {
        int correctAnswer = mQuestionBank[mIndex].getAnswer();
        if (userSelection == correctAnswer) {
            Log.d("Check","got it"+userSelection);

            Toast.makeText(MainActivity.this, "You got it!", Toast.LENGTH_LONG).show();
            mScore=mScore+1;

        } else {

            Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_LONG).show();

        }
    }
}
