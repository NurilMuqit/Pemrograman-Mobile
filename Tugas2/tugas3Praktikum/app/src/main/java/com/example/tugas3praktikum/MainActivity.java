//package com.example.tugas3praktikum;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import android.view.View;
//import android.widget.TextView;
//
//
//public class MainActivity extends AppCompatActivity {
//    String oldNumber="";
//    String op="+";
//    boolean isNewOp= true;
//    TextView result;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        result = findViewById(R.id.result);
//    }
//    public void number(View view) {
//        if (isNewOp)
//            result.setText("");
//        isNewOp = false;
//        String angka = result.getText().toString();
//        switch (view.getId()){
//            case R.id.nol:
//                angka += "0";
//                break;
//            case R.id.satu:
//                angka += "1";
//                break;
//            case R.id.dua:
//                angka += "2";
//                break;
//            case R.id.tiga:
//                angka += "3";
//                break;
//            case R.id.empat:
//                angka += "4";
//                break;
//            case R.id.lima:
//                angka += "5";
//                break;
//            case R.id.enam:
//                angka += "6";
//                break;
//            case R.id.tujuh:
//                angka += "7";
//                break;
//            case R.id.delapan:
//                angka += "8";
//                break;
//            case R.id.sembilan:
//                angka += "9";
//                break;
//        }result.setText(angka);
//    }
//
//    public void operation(View view) {
//        isNewOp = true;
//        oldNumber = result.getText().toString();
//        switch (view.getId()){
//            case R.id.tambah:
//                oldNumber +="+";
//                op ="+";
//                break;
//            case R.id.kali:
//                oldNumber +="x";
//                op ="x";
//                break;
//            case R.id.kurang:
//                oldNumber +="-";
//                op ="-";
//                break;
//            case R.id.bagi:
//                oldNumber +="/";
//                op ="/";
//                break;
//        }result.setText(oldNumber);
//    }
//}

package com.example.tugas3praktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button nol, satu, dua, tiga, empat, lima, enam, tujuh, delapan, sembilan, ac, del, jumlah, kali, bagi, kurang, tambah;
    TextView result;
    String[] inputArray = {"0","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        result.setText(inputArray[0] + inputArray[1] + inputArray[2]);

        nol = findViewById(R.id.nol);
        nol.setOnClickListener(this);

        satu = findViewById(R.id.satu);
        satu.setOnClickListener(this);

        dua = findViewById(R.id.dua);
        dua.setOnClickListener(this);

        tiga = findViewById(R.id.tiga);
        tiga.setOnClickListener(this);

        empat = findViewById(R.id.empat);
        empat.setOnClickListener(this);

        lima = findViewById(R.id.lima);
        lima.setOnClickListener(this);

        enam = findViewById(R.id.enam);
        enam.setOnClickListener(this);

        tujuh = findViewById(R.id.tujuh);
        tujuh.setOnClickListener(this);

        delapan = findViewById(R.id.delapan);
        delapan.setOnClickListener(this);

        sembilan = findViewById(R.id.sembilan);
        sembilan.setOnClickListener(this);

        bagi = findViewById(R.id.bagi);
        bagi.setOnClickListener(this);

        kali = findViewById(R.id.kali);
        kali.setOnClickListener(this);

        kurang = findViewById(R.id.kurang);
        kurang.setOnClickListener(this);

        tambah = findViewById(R.id.tambah);
        tambah.setOnClickListener(this);

        jumlah = findViewById(R.id.jumlah);
        jumlah.setOnClickListener(this);

        ac = findViewById(R.id.ac);
        ac.setOnClickListener(this);

        del = findViewById(R.id.del);
        del.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nol:
                setEqu = true;
                operation("0");
                break;
            case R.id.satu:
                setEqu = true;
                operation("1");
                break;
            case R.id.dua:
                setEqu = true;
                operation("2");
                break;
            case R.id.tiga:
                setEqu = true;
                operation("3");
                break;
            case R.id.empat:
                setEqu = true;
                operation("4");
                break;
            case R.id.lima:
                setEqu = true;
                operation("5");
                break;
            case R.id.enam:
                setEqu = true;
                operation("6");
                break;
            case R.id.tujuh:
                setEqu = true;
                operation("7");
                break;
            case R.id.delapan:
                setEqu = true;
                operation("8");
                break;
            case R.id.sembilan:
                setEqu = true;
                operation("9");
                break;
            case R.id.kali:
                operation("x");
                break;
            case R.id.bagi:
                operation("/");
                break;
            case R.id.kurang:
                operation("-");
                break;
            case R.id.tambah:
                operation("+");
                break;
            case R.id.jumlah:
                operation("=");
                break;
            case R.id.ac:
                reset();
                result = findViewById(R.id.result);
                result.setText(inputArray[0] + inputArray[1] + inputArray[2]);
                break;
            case R.id.del:
                delete();
                result = findViewById(R.id.result);
                result.setText(inputArray[0] + inputArray[1] + inputArray[2]);
                break;
        }
    }

    int i = 0;
    boolean set = true;
    boolean setEqu = true;
    public void operation(String x) {
        result = findViewById(R.id.result);
        boolean flag1 = isOperation(x);

        if(!inputArray[2].equals("")) {
            set = false;
        }
        else {
            set = true;
        }

        if (!isEquals(x) && setEqu) {
            if (flag1 && set && inputArray[0]!="") {
                inputArray[1] = x;
                set = false;
                i = 2;
            }
            else if (!flag1){
                if(inputArray[i] == "0"){
                    inputArray[i] = x;
                }
                else {
                    inputArray[i] += x;
                }
            }
            result.setText(inputArray[0] + inputArray[1] + inputArray[2]);
        }
        else {
            try {
                switch (inputArray[1]) {
                    case "+": {
                        BigInteger num1 = new BigInteger(inputArray[0]);
                        BigInteger num2 = new BigInteger(inputArray[2]);
                        result.setText(String.valueOf(num1.add(num2)));
                        reset();
                        break;
                    }
                    case "-": {
                        BigInteger num1 = new BigInteger(inputArray[0]);
                        BigInteger num2 = new BigInteger(inputArray[2]);
                        result.setText(String.valueOf(num1.subtract(num2)));
                        reset();
                        break;
                    }
                    case "x": {
                        BigInteger num1 = new BigInteger(inputArray[0]);
                        BigInteger num2 = new BigInteger(inputArray[2]);
                        result.setText(String.valueOf(num1.multiply(num2)));
                        reset();
                        break;
                    }
                    case "/": {
                        Double num1 = Double.parseDouble(inputArray[0]);
                        Double num2 = Double.parseDouble(inputArray[2]);
                        if (inputArray[2].equals("0")) {
                            Toast.makeText(getApplicationContext(),"Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else {
                            result.setText(String.valueOf(num1/num2));
                            reset();
                        }
                        break;
                    }
                }
            }
            catch (NumberFormatException ex) {
                Toast.makeText(getApplicationContext(), "Input melebihi batas", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    public boolean isOperation(String x) {
        return x.equals("+") || x.equals("-") || x.equals("x") || x.equals("/");
    }

    public  boolean isEquals(String x) {
        return x.equals("=");
    }

    public void delete() {
        if(!inputArray[2].equals("")) {
            if (inputArray[2].length() == 1) {
                inputArray[2] = "";
            }
            else {
                inputArray[2] = inputArray[2].substring(0,inputArray[2].length()-1);
            }
        }
        else if(!inputArray[1].equals("")) {
            inputArray[1] = "";
            set = true;
            i = 0;
        }
        else if(!inputArray[0].equals("")) {
            if (inputArray[0].length() == 1) {
                inputArray[0] = "0";
                set = true;
            }
            else {
                inputArray[0] = inputArray[0].substring(0,inputArray[0].length()-1);
            }
        }
    }

    public void reset() {
        inputArray[0] = "0";
        inputArray[1] = "";
        inputArray[2] = "";
        set = true;
        setEqu = false;
        i = 0;
    }
}
