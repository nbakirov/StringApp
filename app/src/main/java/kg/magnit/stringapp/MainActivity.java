package kg.magnit.stringapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et;
    EditText et2;
    TextView tv;
    String etString;
    String et2String;

    String COMPARETO = "Строка %s совпадает со строкой %s";
    String CONTAINS = "Строка %s содержит последовательность символов строки %s";

    private static final String mCHAR = "ABCDEFGHIJKIHNOPQRSTUWXYZ1234567890"; //задаётся набор символов
    public static final int STR_LENGTH = 10; // длина генерируемой строки
    Random random = new Random();  //единый класс для генерации случайных чисел

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.textView);

        etString = et.getText().toString();
        et2String = et2.getText().toString();

        //noinspection SimplifiableIfStatement
        if (id == R.id.compareTo) {
            if (etString.compareTo(et2String) == 0){
                String res = String.format(COMPARETO, etString, et2String);
                tv.setText(res);
            } else {
                tv.setText("Строки не совпадают");
            }

        }
        if (id == R.id.compareToIgnoreCase) {
            if (etString.compareToIgnoreCase(et2String) == 0){
                String res = String.format(COMPARETO, etString, et2String);
                tv.setText(res);
            } else {
                tv.setText("Строки не совпадают");
            }

        }
        if (id == R.id.contains) {
            if (etString.contains(et2String) == true){
                String res = String.format(CONTAINS, etString, et2String);
                tv.setText(res);
            } else {
                tv.setText("Строка 1 не содержит символов строки 2");
            }

        }

        if (id == R.id.endsWith) {
            if (etString.endsWith(et2String) == true){
                String res = String.format("Строка - " + etString + " - заканчивается на - " + et2String);
                tv.setText(res);
            } else {
                tv.setText("Строка 1 не заканчивается строкой 2");
            }

        }

        if (id == R.id.startsWith) {
            if (etString.startsWith(et2String) == true){
                String res = String.format("Строка - " + etString + " - начинается на - " + et2String);
                tv.setText(res);
            } else {
                tv.setText("Строка 1 не начинается строкой 2");
            }

        }

        if (id == R.id.equals) {
            if (etString.equals(et2String) == true){
                String res = String.format(COMPARETO, etString, et2String);
                tv.setText(res);
            } else {
                tv.setText("Строка 1 not equals строке 2");
            }

        }

        if (id == R.id.indexOf) {

            int w = etString.indexOf(et2String );

            if (et2String.equals("")){
                Toast t = Toast.makeText( getApplicationContext(),"Введите символ в поле текста 2", Toast.LENGTH_SHORT);
                t.show();
            }else {

                if (w == -1) {
                    String res = String.format("Символ " + et2String + " не содержится в строке " + etString);
                    tv.setText(res);
                } else {
                    String res2 = String.format("Символ " + et2String + " в строке " + etString + " на позиции " + w);
                    tv.setText(res2);
                }
            }
        }

        if (id == R.id.lastIndexOf) {

            int lastsim = etString.lastIndexOf(et2String);

            if (et2String.equals("")) {
                Toast t = Toast.makeText(getApplicationContext(), "Введите символ в поле текста 2", Toast.LENGTH_SHORT);
                t.show();
            } else {

                if (lastsim == -1) {
                    String res = String.format("Символ " + et2String + " не содержится в строке " + etString);
                    tv.setText(res);
                } else {
                    String res2 = String.format("Символ " + et2String + " в строке " + etString + " первый с конца на позиции " + lastsim);
                    tv.setText(res2);
                }
            }
        }

        if (id == R.id.replace) {
            String zero = "--zero--";
            String rp = etString.replace(et2String,zero);

            if (et2String.equals("")) {
                Toast t = Toast.makeText(getApplicationContext(), "Введите символ в поле текста 2", Toast.LENGTH_SHORT);
                t.show();
            } else {
                tv.setText(rp);

                }
            }
        if (id == R.id.substring) {
            String subst = etString.substring(0,Integer.valueOf(et2String));
            tv.setText(subst);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickButton (View v){
        TextView tv2 = (TextView) findViewById(R.id.textView);
        tv2.setText(createRandomString());
    }

    public  String createRandomString(){
        StringBuilder builder = new StringBuilder(); // объект StringBuilder(раб.тогда, когда нужно собрать).

        for (int i = 0; i < STR_LENGTH; i++) {            //цикл в котором генерируется слуайные числа
            int number = random.nextInt(mCHAR.length());  //
            char ch = mCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();   //возвращается "билдер" в строковм значении
    }
}
