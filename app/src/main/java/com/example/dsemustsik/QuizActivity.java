package com.example.dsemustsik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button nextbutton;
    private int questionCounter;
    private int questionCountTotal;
    private TextView number;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        nextbutton = findViewById(R.id.next_button);
        questionCountTotal = 45;
        questionCounter = 1;
        answer = "";
        number = (TextView) findViewById(R.id.question_number);
        number.setText(String.format(" %s", String.valueOf(questionCounter)));
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_next_question();
            }
        });
    }

    private void show_next_question() {
        if (rbGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please choose an option", Toast.LENGTH_SHORT).show();
            return;
        }
        if (rb1.isChecked()) {
            answer += '0';
        }
        if (rb2.isChecked()) {
            answer += '1';
        }
        if (rb3.isChecked()) {
            answer += '2';
        }
        if (rb4.isChecked()) {
            answer += '3';
        }
        rbGroup.clearCheck();

        if (questionCounter < 45) {
            questionCounter++;
        } else {
            finishQuiz();

        }
        number.setText(String.valueOf(questionCounter));
    }

    private void finishQuiz() {
        Intent intent = new Intent(QuizActivity.this, Finish_activity.class);
        intent.putExtra("res", answer);
        startActivity(intent);
    }
}