package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        TextView textView = findViewById(R.id.text2);
        textView.setText(str);

        Button verify, cancel;
        verify = findViewById(R.id.buttonVerify);
        cancel = findViewById(R.id.buttonCancel);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), PracticalTest01Var05MainActivity.class);
                setResult(1, intent1);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), PracticalTest01Var05MainActivity.class);
                setResult(0, intent1);
                finish();
            }
        });

    }
}