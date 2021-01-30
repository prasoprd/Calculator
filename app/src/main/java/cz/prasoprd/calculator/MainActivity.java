package cz.prasoprd.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String number = "";
    private double result = 0;
    private int operation = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.result);
        TextView textView2 = (TextView) findViewById(R.id.number);
        Button number0 = (Button) findViewById(R.id.number0);
        Button number1 = (Button) findViewById(R.id.number1);
        Button number2 = (Button) findViewById(R.id.number2);
        Button number3 = (Button) findViewById(R.id.number3);
        Button number4 = (Button) findViewById(R.id.number4);
        Button number5 = (Button) findViewById(R.id.number5);
        Button number6 = (Button) findViewById(R.id.number6);
        Button number7 = (Button) findViewById(R.id.number7);
        Button number8 = (Button) findViewById(R.id.number8);
        Button number9 = (Button) findViewById(R.id.number9);
        Button dot = (Button) findViewById(R.id.dot);
        Button add = (Button) findViewById(R.id.add);
        Button deduct = (Button) findViewById(R.id.deduct);
        Button multiplication = (Button) findViewById(R.id.multiplication);
        Button division = (Button) findViewById(R.id.division);
        Button calculate = (Button) findViewById(R.id.calculate);
        Button remove = (Button) findViewById(R.id.remove);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                    textView.post(() -> textView.setText(String.format("Result is: %s", result)));
                    textView2.post(() -> textView2.setText(number));
                } catch (Exception ignored) {}
            }
        }).start();

        number0.setOnClickListener(v -> number += "0");
        number1.setOnClickListener(v -> number += "1");
        number2.setOnClickListener(v -> number += "2");
        number3.setOnClickListener(v -> number += "3");
        number4.setOnClickListener(v -> number += "4");
        number5.setOnClickListener(v -> number += "5");
        number6.setOnClickListener(v -> number += "6");
        number7.setOnClickListener(v -> number += "7");
        number8.setOnClickListener(v -> number += "8");
        number9.setOnClickListener(v -> number += "9");
        dot.setOnClickListener(v -> number += ".");

        add.setOnClickListener(v -> {
            doIt();
            operation = 0;
        });

        deduct.setOnClickListener(v -> {
            doIt();
            operation = 1;
        });

        multiplication.setOnClickListener(v -> {
            doIt();
            operation = 2;
        });

        division.setOnClickListener(v -> {
            doIt();
            operation = 3;
        });

        calculate.setOnClickListener(v -> doIt());

        remove.setOnClickListener(v -> {
            number = "";
            result = 0;
            operation = -1;
        });
    }

    private void doIt() {
        if (number() == 0) {
            return;
        }
        switch (operation) {
            case 0:
                result += number();
                break;
            case 1:
                result -= number();
                break;
            case 2:
                result *= number();
                break;
            case 3:
                result /= number();
                break;
            default:
                result = number();
        }
        number = "";
        operation = -1;
    }

    private double number() {
        if (number.isEmpty()) {
            return 0;
        } else {
            return Double.parseDouble(number);
        }
    }
}
