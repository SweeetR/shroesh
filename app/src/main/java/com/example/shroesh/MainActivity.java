package com.example.shroesh;

        import android.content.Intent;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rnd = new Random();
    EditText e1, e2, e3;
    double a, b, c;
    double x1, x2;
    TextView tv1, tv2;
    String ze,zee,zeee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

    public void random(View view) {
        a = rnd.nextGaussian();
        b = rnd.nextGaussian();
        c = rnd.nextGaussian();
        e1.setText(a + "");
        e2.setText(b + "");
        e3.setText(c + "");

    }

    public void solve(View view) {

        ze = e1.getText().toString();
        zee = e2.getText().toString();
        zeee = e3.getText().toString();

        if (((ze.equals("+")) || (zee.equals("+")) || (zeee.equals("+")) || (ze.equals("-")) || (zee.equals("-")) || (zeee.equals("-"))||(ze.equals(""))||(zee.equals(""))||(zeee.equals(""))||(ze.equals("."))||(zee.equals("."))||(zeee.equals(".")))) {
            Toast.makeText(this, "Please dont enter wrong inputs", Toast.LENGTH_SHORT).show();
        }
        else{
            a = Double.parseDouble(e1.getText().toString());
            b = Double.parseDouble(e2.getText().toString());
            c = Double.parseDouble(e3.getText().toString());
            Intent si = new Intent(this, AnswerActivity.class);
            si.putExtra("a", a);
            si.putExtra("b", b);
            si.putExtra("c", c);
            startActivityForResult(si, 1);
        }
    }


    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        if (source == 1) {
            if (good == RESULT_OK) {
                if (data_back != null) {
                    tv1.setText("The last x1 was: " + data_back.getStringExtra("x1"));
                    tv2.setText("The last x2 was: " + data_back.getStringExtra("x2"));
                }

            }
        }
    }
}