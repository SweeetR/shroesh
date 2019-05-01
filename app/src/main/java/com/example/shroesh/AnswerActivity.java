package com.example.shroesh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    String url;
    WebView wv1;
    double a,b,c;
    double x1,x2;
    boolean xgood = true;
    TextView tv1,tv2;
    Intent gi;
    String sx1,sx2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        wv1 = (WebView) findViewById(R.id.wv1) ;
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        gi = getIntent();
        a = gi.getDoubleExtra("a",1);
        b = gi.getDoubleExtra("b",0);
        c = gi.getDoubleExtra("c",0);
        if(Math.pow(b,2)+(-4*a*c)<0){
             sx1 = "not";
             sx2 = "solvable";
            tv1.setText(sx1);
            tv2.setText(sx2);
            xgood = false;
        }
        else{
            sx1 = "" + (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
            sx2 = "" + (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
            tv1.setText(sx1);
            tv2.setText(sx2);
        }
        wv1.getSettings().setJavaScriptEnabled(true);
        url = "https://www.google.com/search?q="+a+"x%5E2%2B"+b+"x%2B"+c+"&oq=2x%5E2%2B&aqs=chrome.1.69i57j35i39j0l4.7816j0j7&sourceid=chrome&ie=UTF-8";

        wv1.setWebViewClient(new MyWebViewClient());



        wv1.loadUrl(url);




    }

    public void back(View view) {
        if(xgood) {
            gi.putExtra("x1", sx1);
            gi.putExtra("x2", sx2);
        }
        setResult(RESULT_OK, gi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
       }

