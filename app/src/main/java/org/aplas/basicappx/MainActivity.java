package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;
    private AlertDialog startDialog;

    public MainActivity() {
        this.dist = new Distance();
        this.weight = new Weight();
        this.temp = new Temperature();
    }

    public MainActivity(Distance dist, Weight weight, Temperature temp) {
        this.dist = dist;
        this.weight = weight;
        this.temp = temp;
    }

    protected double convertUnit(String type, String oriUnit, String convUnit, double value) {
        if(type.equals("Temperature")) {
            return temp.convert(oriUnit, convUnit, value);
        }
        else if(type.equals("Distance")) {
            return dist.convert(oriUnit, convUnit, value);
        }
        else {
            return weight.convert(oriUnit, convUnit, value);
        }
    }

    protected String strResult(double val, boolean rounded) {
        if(rounded) {
            DecimalFormat f = new DecimalFormat("#.##");
            return f.format(val);
        }
        else {
            DecimalFormat f = new DecimalFormat("#.#####");
            return f.format(val);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}