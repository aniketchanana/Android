package com.aniket.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    static int count = 0;
    Button ac,div,rem,seven,eight,nine,mul,four,five,six,min,one,two,three,plus,decimal,zero,equal;
    double a,b;
    char op ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac = findViewById(R.id.ac);
        div = findViewById(R.id.div);
        rem = findViewById(R.id.rem);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        mul = findViewById(R.id.mul);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        min = findViewById(R.id.min);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        decimal = findViewById(R.id.decimal);
        zero = findViewById(R.id.zero);
        equal = findViewById(R.id.equal);
        text = findViewById(R.id.result);
        plus = findViewById(R.id.plus);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+ "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0){
                    text.setText(text.getText()+".");
                    count++;
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"0");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    a = Double.parseDouble(text.getText().toString());
                    op = '/';
                    text.setText("");
                    count=0;
                }catch (Exception e){

                }
            }
        });

        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    a = Double.parseDouble(text.getText().toString());
                    op = '%';
                    text.setText("");
                    count=0;
                }catch (Exception e){

                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    a = Double.parseDouble(text.getText().toString());
                    op = '*';
                    text.setText("");
                    count=0;
                }catch (Exception e){

                }
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    a = Double.parseDouble(text.getText().toString());
                    op = '-';
                    text.setText("");
                    count=0;
                }catch (Exception e){

                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    a = Double.parseDouble(text.getText().toString());
                    op = '+';
                    text.setText("");
                    count=0;
                }catch (Exception e){

                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a>=0)
                {
                    try {
                        b = Double.parseDouble(text.getText().toString());
                    }catch (Exception e){

                    }
                    switch (op)
                    {
                        case '/':
                            text.setText(String.valueOf(a/b));
                            break;
                        case '*':
                            text.setText(String.valueOf(a*b));
                            break;
                        case '+':
                            text.setText(String.valueOf(a+b));
                            break;
                        case '-':
                            text.setText(String.valueOf(a-b));
                            break;
                        case '%':
                            text.setText(String.valueOf(a%b));
                    }
                    a = -1 ;
                }
            }
        });
    }
}
