package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class Penaltyview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penaltyview);

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
                        .url(MainActivity.url+"penalty/android1/")
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
                Toast.makeText(getApplicationContext(), o.toString(), Toast.LENGTH_SHORT).show();
                try {
//                    JSONObject c1= new JSONObject(o.toString());
                    JSONArray array= new JSONArray(o.toString());
                    ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
                    for(int i=0;i<array.length();i++) {
                        JSONObject c = array.getJSONObject(i);
                        HashMap<String,String> tab=new HashMap<String, String>();
                        tab.put("slno", c.getString("plid"));
                        tab.put("plan", c.getString("plan"));
                        tab.put("pay", c.getString("date"));
                        tab.put("date", c.getString("amt"));
                        tab.put("amount", c.getString("penalty"));
                        list.add(tab);

                    }
                    ListAdapter la=new SimpleAdapter(getApplicationContext(), list, R.layout.selectedplans, new String[] {"plan","pay","date","amount",},new int[] {R.id.textView10,R.id.textView11,R.id.textView12,R.id.textView14});
                    ListView lv=findViewById(R.id.lview1);

                    lv.setAdapter(la);


                } catch (JSONException e) {
//                            e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }

            }


        }.execute();
    }
}
