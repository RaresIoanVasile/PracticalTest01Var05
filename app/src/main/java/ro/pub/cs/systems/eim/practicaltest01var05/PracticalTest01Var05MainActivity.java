package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    int nrClicks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        Button tLeft, tRight, bLeft, bRight, center, nextActivity;
        TextView textView;

        tLeft = findViewById(R.id.buttonTopLeft);
        tRight = findViewById(R.id.buttonTopRight);
        center = findViewById(R.id.buttonCenter);
        bLeft = findViewById(R.id.buttonBottomLeft);
        bRight = findViewById(R.id.buttonBottomRight);

        nextActivity = findViewById(R.id.buttonSecondaryActivity);

        textView = findViewById(R.id.text);

        if (savedInstanceState != null) {
            nrClicks = savedInstanceState.getInt("clicks");
            Toast.makeText(this, String.valueOf(nrClicks), Toast.LENGTH_SHORT).show();
        }


        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                intent.putExtra("str", String.valueOf(textView.getText()));
                textView.setText("");
                startActivityForResult(intent, 123);
            }
        });

        tLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(textView.getText()).equals("")) {
                    textView.setText("Top Left");
                } else {
                    String str = String.valueOf(textView.getText());
                    str += ", Top Left";
                    textView.setText(str);
                }
                nrClicks += 1;
            }
        });

        tRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(textView.getText()).equals("")) {
                    textView.setText("Top Right");
                } else {
                    String str = String.valueOf(textView.getText());
                    str += ", Top Right";
                    textView.setText(str);
                }
                nrClicks += 1;
            }
        });

        bLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(textView.getText()).equals("")) {
                    textView.setText("Bottom Left");
                } else {
                    String str = String.valueOf(textView.getText());
                    str += ", Bottom Left";
                    textView.setText(str);
                }
                nrClicks += 1;
            }
        });

        bRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(textView.getText()).equals("")) {
                    textView.setText("Bottom Right");
                } else {
                    String str = String.valueOf(textView.getText());
                    str += ", Bottom Right";
                    textView.setText(str);
                }
                nrClicks += 1;
            }
        });

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(textView.getText()).equals("")) {
                    textView.setText("Center");
                } else {
                    String str = String.valueOf(textView.getText());
                    str += ", Center";
                    textView.setText(str);
                }
                nrClicks += 1;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("clicks", nrClicks);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        nrClicks = savedInstanceState.getInt("clicks");
        Toast.makeText(this, String.valueOf(nrClicks), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        nrClicks = 0;
        if (resultCode == 1) {
            Toast.makeText(this, "Verify", Toast.LENGTH_LONG).show();
        }
        if (resultCode == 0) {
            Toast.makeText(this, "Cancel", Toast.LENGTH_LONG).show();
        }

    }
}