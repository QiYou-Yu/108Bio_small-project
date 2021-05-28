package com.example.app_hw3;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//把輸入的資料排成陣列
/*
        //I create another Set, then I fetch List from my prefs file
        Set<String> fetch_taipei = prefs.getStringSet("data_taipei", null);
        //I then convert it to an Array List and try to see if I got the values
        List<String> list_taipei = new ArrayList<String>(fetch_taipei);


        Set<String> fetch_ntc = prefs.getStringSet("data_ntc", null);
        List<String> list_ntc = new ArrayList<String>(fetch_ntc);

        Set<String> fetch_tao = prefs.getStringSet("data_tao", null);
        List<String> list_tao = new ArrayList<String>(fetch_tao);

        Set<String> fetch_yun = prefs.getStringSet("data_yun", null);
        List<String> list_yun = new ArrayList<String>(fetch_yun);



        for(int i = 0 ; i < list_taipei.size() ; i++){
            Log.d("fetching values", "fetch value " + list_taipei.get(i));
        }



        for(int i = 0 ; i < list_ntc.size() ; i++){
            Log.d("fetching values", "fetch value " + list_ntc.get(i));
        }


        for(int i = 0 ; i < list_tao.size() ; i++){
            Log.d("fetching values", "fetch value " + list_tao.get(i));
        }


        for(int i = 0 ; i < list_yun.size() ; i++){
            Log.d("fetching values", "fetch value " + list_yun.get(i));
        }
*/
    }
}









