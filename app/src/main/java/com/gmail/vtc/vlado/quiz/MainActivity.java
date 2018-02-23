package com.gmail.vtc.vlado.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox mCheckBoxApple, mCheckBoxGoogle, mCheckBoxAndroid, mCheckboxNokia;
    EditText mEditTextAnswer;
    RadioButton mRadioButtonLinux, mRadioButtonJava, mRadioButtonJson;
    Button mButtonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckBoxApple = findViewById(R.id.check_apple);
        mCheckBoxGoogle = findViewById(R.id.check_google);
        mCheckBoxAndroid = findViewById(R.id.check_android);
        mCheckboxNokia = findViewById(R.id.check_nokia);

        mEditTextAnswer = findViewById(R.id.edit_answer);

        mRadioButtonLinux = findViewById(R.id.radio_linux);
        mRadioButtonJava = findViewById(R.id.radio_java);
        mRadioButtonJson = findViewById(R.id.radio_json);

        mButtonResult = findViewById(R.id.button_result);

        onButtonResultClicked();

    }

    /**
     * I don't know what to write in comment, please advise
     */

    private void onButtonResultClicked() {

        mButtonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int score = 0;

                if (!mCheckBoxApple.isChecked()
                        && mCheckBoxAndroid.isChecked()
                        && mCheckBoxGoogle.isChecked()
                        && !mCheckboxNokia.isChecked()) {
                    score += 1;
                }

                String inputAnswer = mEditTextAnswer.getText().toString();
                String correctAnswer = "4";

                if (inputAnswer.equals(correctAnswer)) {
                    score += 1;
                }

                if (mRadioButtonLinux.isChecked()) {
                    score += 1;
                }

                if (mRadioButtonJava.isChecked()) {
                    score += 1;
                }

                if (mRadioButtonJson.isChecked()) {
                    score += 1;
                }

                Toast toast = Toast.makeText(MainActivity.this, "Your score is: "
                        + score + " of 5" + " \n Congratulation ", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });
    }
}