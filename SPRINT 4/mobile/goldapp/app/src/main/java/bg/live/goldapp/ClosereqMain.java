package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
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

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ClosereqMain extends AppCompatActivity {
//
ListView lv;
    static String plan;
    static String pay="";
    static String dat="";
    static String amt="";
    static String plid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closereq_main);
        lv=(ListView)findViewById(R.id.lview1);

        AsyncTask asyncTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                JSONObject postdata = new JSONObject();

                try {
                    postdata.put("uid", MainActivity.UID);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                OkHttpClient client = new OkHttpClient();

                MediaType MEDIA_TYPE = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                Request request = new Request.Builder()
                        .url(MainActivity.url+"uplan/viewplan/")
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

            @Override
            protected void onPostExecute(Object o) {
//                String p1="",p2="",p3="",p4="",p5="",p6="";
//                String gram = "";
                try {
//                    JSONObject c1= new JSONObject(o.toString());
                    JSONArray array= new JSONArray(o.toString());
                    ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
                    for(int i=0;i<array.length();i++) {
                        JSONObject c = array.getJSONObject(i);
                        HashMap<String,String> tab=new HashMap<String, String>();
                        tab.put("slno", c.getString("plid"));
                        tab.put("plan", c.getString("plan"));
                        tab.put("pay", c.getString("payment"));
                        tab.put("date", c.getString("jdate"));
                        tab.put("amount", c.getString("amt"));
                        list.add(tab);



//
//                        Toast.makeText(getApplicationContext(), sub_name, Toast.LENGTH_SHORT).show();
                    }
                    ListAdapter la=new SimpleAdapter(getApplicationContext(), list, R.layout.selectedplans, new String[] {"plan","pay","date","amount",},new int[] {R.id.textView10,R.id.textView11,R.id.textView12,R.id.textView14});
                    lv.setAdapter(la);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {



                        @Override
                        public void onItemClick(AdapterView<?> parent, View viewclicked, int pos, long id) {
                            HashMap<String,String> tmp= (HashMap<String, String>) parent.getItemAtPosition(pos);
                            plid=(String)tmp.get("slno");
                            Toast.makeText(getApplicationContext(),plid,Toast.LENGTH_SHORT).show();
                            plan=(String)tmp.get("plan");
                            pay=(String)tmp.get("pay");
                            dat=(String)tmp.get("date");
                            amt=(String)tmp.get("amount");
                            Intent i=new Intent(getApplicationContext(),Closereqentry.class);
                            startActivity(i);

                        }

                    });
//

                } catch (JSONException e) {
//                            e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }

//
            }


        }.execute();


    }
}
