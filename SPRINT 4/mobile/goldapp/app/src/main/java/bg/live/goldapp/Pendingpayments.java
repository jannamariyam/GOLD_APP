package bg.live.goldapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Pendingpayments extends AppCompatActivity {
    ListView lv;
    static String plan;
    static String pay="";
    static String dat="";
    static String amt="";
    static String plid="";
    static String inst="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectedplans);
        lv=(ListView)findViewById(R.id.lview1);

        AsyncTask asyncTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                JSONObject postdata = new JSONObject();

                try {
                    postdata.put("plid", Selectedplans.plid);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                OkHttpClient client = new OkHttpClient();

                MediaType MEDIA_TYPE = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                Request request = new Request.Builder()
                        .url(MainActivity.url+"pending/android1/")
                        .post(body)
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    return response.body().string();

                } catch (Exception ex) {
//                                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
                }
                return null;
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            protected void onPostExecute(Object o) {
//                String p1="",p2="",p3="",p4="",p5="",p6="";
//                String gram = "";
//                Toast.makeText(getApplicationContext(),o.toString(),Toast.LENGTH_SHORT).show();
                try {
//                    JSONObject c1= new JSONObject(o.toString());

                    JSONArray array= new JSONArray(o.toString());
                    ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
                    for(int i=0;i<array.length();i++) {
                        JSONObject c = array.getJSONObject(i);
                        HashMap<String,String> tab=new HashMap<String, String>();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        Date d = dateFormat.parse(c.getString("sdate"));
                        Date d1 = Calendar.getInstance().getTime();
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        Date d2=dateFormat.parse(df.format(d1));
                        String p="";
                        int v=d.compareTo(d2);
                        if(v>0)
                        {
                            p="Upcoming";

                        }
                        else
                        {
                            p="Pay";
                        }
//                        if(d.before(d2))
//                        {
//                            p="Pay";
//                        }
//                        else
//                        {
//                            p="Upcoming";
//                        }
//                        String formattedDate = df.format(c);



                        tab.put("slno", c.getString("slno"));
                        tab.put("sdate", c.getString("sdate"));
                        tab.put("edate", c.getString("edate"));
                        tab.put("plan", c.getString("plan"));
                        tab.put("pay", p);

                        list.add(tab);



//
//                        Toast.makeText(getApplicationContext(), sub_name, Toast.LENGTH_SHORT).show();
                    }
                    ListAdapter la=new SimpleAdapter(getApplicationContext(), list, R.layout.pending_lay, new String[] {"sdate","edate","plan","pay","slno"},new int[] {R.id.textView25,R.id.textView27,R.id.textView29,R.id.textView30,R.id.textView31});
                    lv.setAdapter(la);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {



                        @Override
                        public void onItemClick(AdapterView<?> parent, View viewclicked, int pos, long id) {
                            HashMap<String,String> tmp= (HashMap<String, String>) parent.getItemAtPosition(pos);
                            inst=(String)tmp.get("slno");
//                            Toast.makeText(getApplicationContext(),plid,Toast.LENGTH_SHORT).show();
////                            plan=(String)tmp.get("plan");
                            pay=(String)tmp.get("pay");
////                            dat=(String)tmp.get("date");
////                            amt=(String)tmp.get("amount");
                            if (pay.contains("Pay")) {
                                Intent i = new Intent(getApplicationContext(), PaymentSubmit.class);
                                startActivity(i);
                            }
                        }

                    });
//

                } catch (JSONException | ParseException e) {
//                            e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }


            }


        }.execute();


    }
}
