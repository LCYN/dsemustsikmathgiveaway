package com.example.dsemustsik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Finish_activity extends AppCompatActivity {
    private TextView Type11, Type22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Bundle answer = getIntent().getExtras();
        String final_ans = answer.getString("res");
        String real_ans = "220103230313110310202132012320130131220031230";
        int ok=0;
        int A=0, B=0, C=0, D=0;
        int a=0, b=0, c=0, d=0;
        for(int i=0;i<45;i++){
            if(final_ans.charAt(i)==real_ans.charAt(i)){
                ok++;
            }
            if(final_ans.charAt(i)=='0'){
                A++;
            }
            else if(final_ans.charAt(i)=='1'){
                B++;
            }
            else if(final_ans.charAt(i)=='2'){
                C++;
            }
            else{
                D++;
            }
            if(real_ans.charAt(i)=='0'){
                a++;
            }
            else if(real_ans.charAt(i)=='1'){
                b++;
            }
            else if(real_ans.charAt(i)=='2'){
                c++;
            }
            else{
                d++;
            }
        }
        int result1=Math.min(A, a)+Math.min(B, b)+Math.min(C, c)+Math.min(D, d);
        int result2=ok;
        Type11 = (TextView) findViewById(R.id.Text1);
        Type22 = (TextView) findViewById(R.id.Text2);
        Type11.setText(String.format("%s is/are in correct position", String.valueOf(result2)));
        Type22.setText(String.format("%s have the correct value but in wrong position", String.valueOf(result1 - result2)));

        Button nextbutton;
        nextbutton = findViewById(R.id.bye);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result2==45){
                    finall();
                }
                else{
                    returnfirst();
                }
            }
        });

    }
    private void finall() {
        Intent intent = new Intent(Finish_activity.this, finale.class);
        startActivity(intent);
    }
    private void returnfirst(){
        Intent intent = new Intent(Finish_activity.this, MainActivity.class);
        startActivity(intent);
    }
}