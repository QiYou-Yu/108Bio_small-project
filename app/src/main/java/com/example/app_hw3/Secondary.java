package com.example.app_hw3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;
import java.util.ArrayList;

public class Secondary extends AppCompatActivity {


    private Button button2;
    private TextView area2;
    private TextView result;
    private String output1;
    private String string_taipei;
    private String string_nte;
    private String string_tao;
    private String string_yun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
//讀取在第一頁spinner中所選取的縣市(已儲存)
        SharedPreferences sharedPreferences = getSharedPreferences("name" , MODE_PRIVATE);
        String output1 = sharedPreferences.getString("data", null); // getting String
//sharedPreference 的讀取(getSting)

        button2 = findViewById(R.id.button2);
        area2=findViewById(R.id.area2);
        result=findViewById(R.id.result);
//讀取已儲存的醫院資料read
        SharedPreferences prefs=getSharedPreferences("file",MODE_PRIVATE);
       // SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        string_taipei=prefs.getString("tpe",null);
        string_nte=prefs.getString("nte",null);
        string_tao=prefs.getString("tao",null);
        string_yun=prefs.getString("yun",null);

//使Activity得到Intent物件
        //Intent intent3=getIntent();
      //  output1= intent3.getStringExtra("data") ;   //獲取Intent所附帶的資料
        //顯示結果
        area2.setText("您選擇的縣市: "+output1);

        switch((output1))      //取得儲存的字串
        {
            case "台北市":
            {
                result.setText(string_taipei);
            }
            break;

            case "新北市":
            {
                result.setText(string_nte);
            }
            break;

            case "桃園市":
            {
                result.setText(string_tao);
            }
            break;

            case "雲林縣":
            {
                result.setText(string_yun);
            }
            break;
        }


//button2監聽
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent();//切換頁面程式
                intent1.setClass(Secondary.this,SpinnerActivity.class);
                startActivity(intent1);//啟動intent1
            }
        });
    }
}



/*
        // 準備資料，塞50個項目到ArrayList裡
        for (int i = 1; i < 50; i++) {
            mData.add(i + " 醫院名稱 +地址");
        }
        // 連結元件
        recycler_view = (RecyclerView) findViewById(R.id.recyclerView);
        // 設置RecyclerView為列表型態
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        // 設置格線
        recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // 將資料交給adapter
        adapter = new MyAdapter(mData);
        // 設置adapter給recycler_view
        recycler_view.setAdapter(adapter);
*/

