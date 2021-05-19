package com.example.labexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button opt1, opt2, opt3, opt4;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;      //TO access the data from ArrayList
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.QuestionAttempted);
        opt1 = findViewById(R.id.idBtnOption1);
        opt2 = findViewById(R.id.idBtnOption2);
        opt3 = findViewById(R.id.idBtnOption3);
        opt4 = findViewById(R.id.idBtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(opt1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(opt2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(opt3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(opt4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });




    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuiz = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n" + currentScore + "/4");
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();


    }
    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted : " + questionAttempted + "/4");

        if(questionAttempted == 4){
            showBottomSheet();      //end of test
        }
        else{
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            opt1.setText(quizModelArrayList.get(currentPos).getOption1());
            opt2.setText(quizModelArrayList.get(currentPos).getOption2());
            opt3.setText(quizModelArrayList.get(currentPos).getOption3());
            opt4.setText(quizModelArrayList.get(currentPos).getOption4());
        }

    }
    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {

        quizModelArrayList.add(new QuizModel("How GFG is used ?","To Solve DSA problems","To learn new Language","to learn Android","All of the Above","All of the Above"));
        quizModelArrayList.add(new QuizModel("What is GCM in Android ?","Google Cloud Messaging","Google Closure Messaging","Geeks cloud Messaging","None of the Above","Google Cloud Messaging"));
        quizModelArrayList.add(new QuizModel("How to run Android Studio project ?","Through emulator","Through usb cable","Through AVD Manager","All of the Above","All of the Above"));
        quizModelArrayList.add(new QuizModel("What is the new version in Android ?","ColorOS","Pie","Oreo","Android Q","Q"));

    }
}