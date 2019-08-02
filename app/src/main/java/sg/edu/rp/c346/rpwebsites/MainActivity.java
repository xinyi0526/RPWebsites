package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;
    ArrayList<String> alSubCat;
    ArrayAdapter<String>aaSubCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.button);


        alSubCat = new ArrayList<>();

        aaSubCat = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alSubCat);


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        alSubCat.clear();
                        String[] strsubCat = getResources().getStringArray(R.array.rp);

                        //Convert Array to List and add to the ArrayList
                        alSubCat.addAll(Arrays.asList(strsubCat));
                        spn2.setAdapter(aaSubCat);
                        break;
                    case 1:
                        alSubCat.clear();
                        String[] strsubCat2 = getResources().getStringArray(R.array.soi);

                        //Convert Array to List and add to the ArrayList
                        alSubCat.addAll(Arrays.asList(strsubCat2));
                        spn2.setAdapter(aaSubCat);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(spn2.getSelectedItem().equals("Homepage")) {
                    String url = "https://www.google.com/";
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);


                }else if(spn2.getSelectedItem().equals("Student Life")){
                    String url = "https://www.rp.edu.sg/student-life";
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);



                }else if(spn2.getSelectedItem().equals("DMSD")){
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);

                }else if(spn2.getSelectedItem().equals("DIT")){
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);

                }




            }
        });
    }
}
