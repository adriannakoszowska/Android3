package com.example.adriannakoszowska.android3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.acos;
import static java.lang.StrictMath.asin;
import static java.lang.StrictMath.atan;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.log1p;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.sqrt;
import static java.lang.StrictMath.tan;


public class MainActivity extends ActionBarActivity {
    String dzialanie_globalne="";
    float numberone;
    float numbertwo;
    boolean finish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // wczytanie obiektów
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        // ustawienie tekstu na obiektach
        poprzednie.setText("");
        dzialanie.setText("");
    }

    public void buttonNumeric(View view) {
        String value = "0";
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);

        switch (view.getId()) {
            case R.id.button0:
                value = "0";
                break;
            case R.id.button1:
                value = "1";
                break;
            case R.id.button2:
                value = "2";
                break;
            case R.id.button3:
                value = "3";
                break;
            case R.id.button4:
                value = "4";
                break;
            case R.id.button5:
                value = "5";
                break;
            case R.id.button6:
                value = "6";
                break;
            case R.id.button7:
                value = "7";
                break;
            case R.id.button8:
                value = "8";
                break;
            case R.id.button9:
                value = "9";
                break;
            case R.id.przecinek:
                value = ".";
                break;
        }
        dzialanie.setText(dzialanie.getText() + "" + value);
    }
    public void Click(View view) {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        //dodawanie liczby do dzialania
        numberone = Float.valueOf(dzialanie.getText().toString());
        //dodawanie znaku
        String value="";
        switch (view.getId()) {
            case R.id.dodaj:
                value = "+";
                dzialanie_globalne = "dod";
                break;
            case R.id.odejmij:
                value = "-";
                dzialanie_globalne = "ode";
                break;
            case R.id.pomnoz:
                value = "*";
                dzialanie_globalne = "mno";
                break;
            case R.id.podziel:
                value = "/";
                dzialanie_globalne = "dzi";
                break;
            case R.id.sqrt:
                //value = "sqrt";
                dzialanie_globalne = "sqrt";
                wynik();
                break;
            case R.id.sin:
                dzialanie_globalne = "sin";
                wynik();
                break;
            case R.id.cos:
                dzialanie_globalne = "cos";
                wynik();
                break;
            case R.id.tan:
                dzialanie_globalne = "tan";
                wynik();
                break;
            case R.id.ctan:
                dzialanie_globalne = "ctan";
                wynik();
                break;
            case R.id.pi:
                dzialanie_globalne = "pi";
                wynik();
                break;
            case R.id.lognat:
                dzialanie_globalne = "lognat";
                wynik();
                break;
            case R.id.asin:
                dzialanie_globalne = "asin";
                wynik();
                break;
            case R.id.acos:
                dzialanie_globalne = "acos";
                wynik();
                break;
            case R.id.atan:
                dzialanie_globalne = "atan";
                wynik();
                break;
            case R.id.power:
                value = "^exp";
                dzialanie_globalne = "power";
                break;
        }
        if(dzialanie != null) {
            poprzednie.setText(dzialanie.getText() + value);
            dzialanie.setText("");
        } else {
            dzialanie.setText("Wprowadź liczbę");
        }
    }
    public void getnumbertwo(View view) {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        if(dzialanie == null || poprzednie == null) {
            dzialanie.setText("Najpierw stwórz działanie");
        } else {
            numbertwo = Float.valueOf(dzialanie.getText().toString());

            poprzednie.setText(poprzednie.getText() + "" + dzialanie.getText());
            dzialanie.setText("");

            wynik();
            finish = true;
        }
    }
    public void wynik() {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        String value="";
        switch (dzialanie_globalne) {
            case "dod":
                value = String.valueOf(numberone + numbertwo);
                break;
            case "ode":
                value = String.valueOf(numberone - numbertwo);
                break;
            case "mno":
                value = String.valueOf(numberone * numbertwo);
                break;
            case "dzi":
                value = String.valueOf(numberone / numbertwo);
                break;
            case "sqrt":
                value = String.valueOf(sqrt(numberone));
                break;
            case "sin":
                value = String.valueOf(sin(numberone));
                break;
            case "cos":
                value = String.valueOf(cos(numberone));
                break;
            case "tan":
                value = String.valueOf(tan(numberone));
                break;
            case "ctan":
                value = String.valueOf(1 / tan(numberone));
                break;
            case "pi":
                value = String.valueOf(numberone * PI);
                break;
            case "lognat":
                value = String.valueOf(log1p(numberone));
                break;
            case "asin":
                value = String.valueOf(asin(numberone));
                break;
            case "acos":
                value = String.valueOf(acos(numberone));
                break;
            case "atan":
                value = String.valueOf(atan(numberone));
                break;
            case "power":
                value = String.valueOf(pow(numberone,numbertwo));
                break;
        }
        poprzednie.setText("");
        dzialanie.setText(value);
    }
    public void Czyszczenie(View view) {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);

        numberone = 0;
        numbertwo = 0;
        dzialanie_globalne = "";
        dzialanie.setText("");
        poprzednie.setText("");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}