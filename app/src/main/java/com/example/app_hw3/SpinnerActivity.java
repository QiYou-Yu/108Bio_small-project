package com.example.app_hw3;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import java.util.HashSet;
import java.util.Set;


public class SpinnerActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;    //拉條
    private Button button;
    private String output;//output=content
    private String content;//儲存使用者對spinnner所選的選項
    private String[] area; //spinner裡面的陣列

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得介面ID
        button = findViewById(R.id.button);


        //SharedPreference.Editor只作資料寫入資料輸入且提交
        //putString("key",defaultltvalue)---->key:方要找你就會叫Giny.叫那個誰應該會沒收到回應一樣。Giny就是那個Key了
        //default--->sharedPreference找這key找不到時，要回傳什麼
        SharedPreferences prefs = getSharedPreferences("file", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("tpe", "馬偕紀念醫院臺北院區-臺北市中山區中山北路二段92號\n\n" +
                                "臺灣大學醫學院附設醫院-臺北市中正區常德街1號\n\n"+
                                "臺北市立聯合醫院-仁愛院區-臺北市大安區仁愛路4段10號\n\n"+
                               "臺北市立聯合醫院-中興院區-臺北市大同區鄭州路145號\n\n"+
                                "三軍總醫院內湖院區-臺北市內湖區成功路二段325號\n\n"+
                                "三軍總醫院內湖院區-臺北市內湖區成功路二段325號\n\n"+
                                 "臺北市立萬芳醫院-臺北市文山區興隆路三段111號\n\n"+
                                "臺北市立聯合醫院-陽明院區-臺北市士林區雨聲街105號\n\n"+
                                "臺北市立聯合醫院-忠孝院區-臺北市南港區同德路87號");

        editor.putString("nte","臺北慈濟醫院-新北市新店區建國路289號\n\n"+
                                 "亞東紀念醫院-新北市板橋區南雅南路二段21號\n\n"+
                                "恩主公醫院-新北市三峽區復興路399號\n\n"+
                                 "臺北醫院-新北市新莊區思源路127號\n\n"+
                                 "輔仁大學附設醫院-新北市泰山區貴子路69號\n\n"+
                                 "國泰綜合醫院-新北市汐止區建成路59巷2號\n\n"+
                              "淡水馬偕紀念醫院-新北市淡水區民生里民生路45\n\n"+
                                 "新北市立聯合醫院-新北市三重區新北大道1段3號\n\n"+
                        "瑞芳礦工醫院-新北市瑞芳區一坑路71之2號\n\n"+
                        "新泰綜合醫院-新北市新莊區新樹路176號\n\n"+
                        "新北市立土城醫院-新北市土城區金城路2段6號\n\n"+
                        "桃園醫院-桃園市桃園區中山路1492號\n\n"+
                                 "仁愛醫院-新北市樹林區文化街9號");

        editor.putString("tao", "桃園醫院-新屋分院-桃園市新屋區新屋村14鄰新福二路6號\n\n"+
                                 "楊梅天成醫院-桃園市楊梅區中山北路一段356號\n\n"+
                                 "林口長庚紀念醫院-桃園市龜山區公西里復興街5號\n\n"+
                                "聯新國際醫院-桃園市平鎮區廣泰路77號\n\n"+
                                 "臺北榮民總醫院屋分院-桃園市桃園區成功路三段100號\n\n"+
                                "敏盛綜合醫院-桃園市桃園區經國路168號");

        editor.putString("yun", "雲林長庚紀念醫院-雲林縣麥寮鄉中興村工業路1500號\n\n"+
                                 "中國醫藥大學北港附設醫院-雲林縣北港鎮新德路123號\n\n"+
                                  "成大附設醫院-斗六分院-雲林縣斗六市莊敬路345號\n\n"+
                                 "天主教若瑟醫院-雲林縣虎尾鎮新生路 74 號\n\n"+
                                "臺大附設醫院-虎尾院區-雲林縣虎尾鎮學府路95號\n\n"+
                                "臺大附設醫院-斗六院區-雲林縣斗六巿雲林路二段579號");
        editor.apply();//提交寫入結果


// 獲取介面佈局檔案中的Spinner元件
        spinner = findViewById(R.id.spinner);//指定要操作的Spinner ID
        String[] area = {"台北市", "新北市", "基隆市","桃園市","新竹市","苗栗縣","台中市","彰化縣","雲林縣","嘉義縣","台南市","高雄市","屏東縣","宜蘭縣","花蓮縣","台東縣"};
//產生ArrayAdapter，設定資料選項string array及預設spinner的layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_item);
// 為Spinner設定Adapter
        spinner.setAdapter(adapter);
// 為Spinner設定選中事件監聽器
        spinner.setOnItemSelectedListener(this);
    }
//對sipinner監聽
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        content = parent.getItemAtPosition(position).toString(); //取得陣列位置裡的字串
        output=content;
        Toast.makeText(SpinnerActivity.this, "你點選的是:"+ content,Toast.LENGTH_SHORT).show();//LENGTH_SHORT意思是 出現的時間

//sharedpreference的寫入
        SharedPreferences sharedPreferences = getSharedPreferences("name" , MODE_PRIVATE);//建立SharedPreferences，初始化
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor1.putString("data",output);
        editor1.apply();
        //sharedPreferences寫入資料，edit是編輯的意思 ，apply:提交

//對button監聽
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

//切換頁面程式
            Intent intent1 = new Intent();//切換頁面程式
            intent1.putExtra("data", output);//
            intent1.setClass(SpinnerActivity.this, Secondary.class);
            startActivity(intent1);//啟動intent2
            }
        });
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}