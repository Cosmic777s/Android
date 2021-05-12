package com.example.quizappreworked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton question1answer1, question1answer2, question2answer1, question2answer2;

    CheckBox question4_1, question4_2, question4_3, question4_4;
    EditText question3Answer;

    String correctAnswerQ1;
    String wrongAnswerQ1;
    String correctAnswerQ2;
    String wrongAnswerQ2;
    String correctAnswerQ3;
    String wrongAnswerQ3;
    String correctAnswerQ4;
    String wrongAnswerQ4;
    String scoreResults;

    Button question1SubmitButton;
    Button question2SubmitButton;

    Button question3SubmitButton;
    Button question4SubmitButton;
    Button scoreSubmitButton;


    int scoreKeeper;
    int scoreFWA;
    int q4numberOfTimesClickedCheckBox = 0;
    int question2numberofTimesClicked = 0;
    int question3numberofTimesClicked = 0;
    int question1numberofTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question1answer1 = (RadioButton) findViewById(R.id.q1_Answer);
        question1answer2 = (RadioButton) findViewById(R.id.q1_Answer2);
        question2answer1 = (RadioButton) findViewById(R.id.q2_Answer1);
        question2answer2 = (RadioButton) findViewById(R.id.q2_Answer2);

        question3Answer = (EditText) findViewById(R.id.editText);
        question4_1 = (CheckBox) findViewById(R.id.blue);
        question4_2 = (CheckBox) findViewById(R.id.purple);
        question4_3 = (CheckBox) findViewById(R.id.yellow);
        question4_4 = (CheckBox) findViewById(R.id.copper);

        question1SubmitButton = (Button) findViewById(R.id.submit_button);
        question1SubmitButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (question1answer1.isChecked()) {
                    question1numberofTimesClicked++;
                    if (question1numberofTimesClicked == 1) {
                        correctAnswerQ1 = "Question 1 is correct!";
                        Toast.makeText(getApplicationContext(), correctAnswerQ1, Toast.LENGTH_SHORT).show();
                        scoreKeeper = scoreKeeper + question1numberofTimesClicked;
                    } else {
                        correctAnswerQ1 = "Question 1 was already answered please do not submit more than once";
                        Toast.makeText(getApplicationContext(), correctAnswerQ1, Toast.LENGTH_SHORT).show();
                    }
                } else if (question1answer2.isChecked()) {
                    wrongAnswerQ1 = "Question 1 is wrong";
                    Toast.makeText(getApplicationContext(), wrongAnswerQ1, Toast.LENGTH_LONG).show();
                }

            }
        });
        question2SubmitButton = (Button) findViewById(R.id.submit_button2);
        question2SubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (question2answer1.isChecked()) {
                    question2numberofTimesClicked++;
                    if (question2numberofTimesClicked == 1) {
                        correctAnswerQ2 = "Question 2 is Correct!";
                        Toast.makeText(getApplicationContext(), correctAnswerQ2, Toast.LENGTH_LONG).show();
                        scoreKeeper = scoreKeeper + question2numberofTimesClicked;
                    } else {
                        correctAnswerQ1 = "Question 2 was already answered please do not submit more than once";
                        Toast.makeText(getApplicationContext(), correctAnswerQ1, Toast.LENGTH_SHORT).show();
                    }
                } else if (question2answer2.isChecked()) {
                    wrongAnswerQ2 = "Question 2 is wrong";
                    Toast.makeText(getApplicationContext(), wrongAnswerQ2, Toast.LENGTH_LONG).show();
                    scoreFWA++;
                }
            }

        });


        question3SubmitButton = (Button) findViewById(R.id.submit_button3e);
        question3SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (question3Answer.getText().toString().trim().equalsIgnoreCase("pacific ocean")) {
                    question3numberofTimesClicked++;
                    if (question3numberofTimesClicked == 1) {
                        correctAnswerQ3 = "Question 3 is Correct";
                        Toast.makeText(getApplicationContext(), correctAnswerQ3, Toast.LENGTH_LONG).show();
                        scoreKeeper = scoreKeeper + question3numberofTimesClicked;
                    } else {
                        correctAnswerQ3 = "Question 3 was already answered please do not submit more than once";
                        Toast.makeText(getApplicationContext(), correctAnswerQ3, Toast.LENGTH_SHORT).show();
                    }
                }
                if (!(question3Answer.getText().toString().trim().equalsIgnoreCase("pacific ocean"))) {
                    wrongAnswerQ3 = "Question 3 is wrong";
                    Toast.makeText(getApplicationContext(), wrongAnswerQ3, Toast.LENGTH_LONG).show();
                }

            }

        });


        question4SubmitButton = (Button) findViewById(R.id.submit_button4);
        question4SubmitButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (question4_1.isChecked() && question4_2.isChecked() && question4_3.isChecked() && question4_4.isChecked()) {
                    wrongAnswerQ4 = "Question 4 is wrong one of the following selected is incorrect";
                    Toast.makeText(getApplicationContext(), wrongAnswerQ4, Toast.LENGTH_LONG).show();


                } else if (question4_1.isChecked() && question4_2.isChecked() && question4_3.isChecked() && !(question4_4.isChecked())) {
                    q4numberOfTimesClickedCheckBox++;

                    if (q4numberOfTimesClickedCheckBox == 1) {

                        correctAnswerQ4 = "Question 4 is Correct!";
                        Toast.makeText(getApplicationContext(), correctAnswerQ4, Toast.LENGTH_LONG).show();
                        scoreKeeper = scoreKeeper + q4numberOfTimesClickedCheckBox;
                    } else {


                        wrongAnswerQ4 = "You already submited a correct answer. For question 4 please submit answer only once.";
                        Toast.makeText(getApplicationContext(), wrongAnswerQ4, Toast.LENGTH_LONG).show();

                    }
                } else if (question4_1.isChecked() && question4_2.isChecked() && !(question4_3.isChecked()) && !(question4_4.isChecked())) {
                    q4numberOfTimesClickedCheckBox++;

                    if (q4numberOfTimesClickedCheckBox == 1) {


                        correctAnswerQ4 = "Question 4 is Correct!";
                        Toast.makeText(getApplicationContext(), correctAnswerQ4, Toast.LENGTH_LONG).show();


                        scoreKeeper = scoreKeeper + q4numberOfTimesClickedCheckBox;
                    } else {


                        wrongAnswerQ4 = "You already submited a correct answer. For question 4 please submit answer only once.";
                        Toast.makeText(getApplicationContext(), wrongAnswerQ4, Toast.LENGTH_LONG).show();

                    }

                } else if (question4_1.isChecked() && !(question4_2.isChecked()) && !(question4_3.isChecked()) && !(question4_4.isChecked())) {
                    q4numberOfTimesClickedCheckBox++;

                    if (q4numberOfTimesClickedCheckBox == 1) {

                        correctAnswerQ4 = "Question 4 is Correct!";
                        Toast.makeText(getApplicationContext(), correctAnswerQ4, Toast.LENGTH_LONG).show();
                        scoreKeeper = scoreKeeper + q4numberOfTimesClickedCheckBox;

                    } else {

                        q4numberOfTimesClickedCheckBox = 1;
                        wrongAnswerQ4 = "You already submited a correct answer. For question 4 please submit answer only once.";
                        Toast.makeText(getApplicationContext(), wrongAnswerQ4, Toast.LENGTH_LONG).show();
                    }


                } else if (!(question4_1.isChecked()) && question4_2.isChecked() && question4_3.isChecked() && !(question4_4.isChecked())) {
                    q4numberOfTimesClickedCheckBox++;

                    if (q4numberOfTimesClickedCheckBox == 1) {
                        correctAnswerQ4 = "Question 4 is Correct!";
                        Toast.makeText(getApplicationContext(), correctAnswerQ4, Toast.LENGTH_LONG).show();
                        scoreKeeper = scoreKeeper + q4numberOfTimesClickedCheckBox;

                    } else {


                        wrongAnswerQ4 = "You already submited a correct answer. For question 4 please submit answer only once.";
                        Toast.makeText(getApplicationContext(), wrongAnswerQ4, Toast.LENGTH_LONG).show();
                    }


                } else if (!(question4_1.isChecked()) && !(question4_2.isChecked()) && !(question4_3.isChecked()) && !(question4_4.isChecked())) {
                    wrongAnswerQ4 = "Question 4 is wrong";
                    Toast.makeText(getApplicationContext(), wrongAnswerQ4, Toast.LENGTH_LONG).show();
                    scoreFWA++;
                } else if (!(question4_1.isChecked()) && !(question4_2.isChecked()) && !(question4_3.isChecked()) && question4_4.isChecked()) {
                    wrongAnswerQ4 = "Question 4 is wrong";
                    Toast.makeText(getApplicationContext(), wrongAnswerQ4, Toast.LENGTH_LONG).show();
                    scoreFWA++;
                }


            }

        });

        scoreSubmitButton = (Button) findViewById(R.id.submit_buttonScore);
        scoreSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (scoreKeeper == 4) {
                    scoreResults = "Congratulations you got a 100";
                    Toast.makeText(getApplicationContext(), scoreResults, Toast.LENGTH_LONG).show();

                } else if (scoreKeeper == 3) {
                    scoreResults = "You got a 75";
                    Toast.makeText(getApplicationContext(), scoreResults, Toast.LENGTH_LONG).show();

                } else if (scoreKeeper == 2) {
                    scoreResults = "You got a 50";
                    Toast.makeText(getApplicationContext(), scoreResults, Toast.LENGTH_LONG).show();

                } else if (scoreKeeper == 1) {
                    scoreResults = " You got a 25";
                    Toast.makeText(getApplicationContext(), scoreResults, Toast.LENGTH_LONG).show();

                } else if (scoreKeeper == 0) {
                    scoreResults = "You got a 0";
                    Toast.makeText(getApplicationContext(), scoreResults, Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}