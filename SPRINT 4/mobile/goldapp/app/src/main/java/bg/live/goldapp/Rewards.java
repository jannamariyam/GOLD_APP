package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Rewards extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        t1=(TextView)findViewById(R.id.textView15);
        String pid=Walletmaster.plid;
//        String amt=Walletmaster.amt;
        AsyncTask asyncTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                JSONObject postdata = new JSONObject();

                try {

                    postdata.put("plan", pid);
                    postdata.put("uid", MainActivity.UID);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


                OkHttpClient client = new OkHttpClient();

                MediaType MEDIA_TYPE = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                Request request = new Request.Builder()
                        .url(MainActivity.url+"reward/android1/")
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
                t1.setText(o.toString());
//                        try {
//                            String[] det=o.toString().split("#");
//                            t4.setText(det[0]);
//                            t6.setText(det[1]);
//                            t7.setText(det[2]);
//                            String pt= Integer.toString (tterm- Integer.parseInt(det[2]));
//                            t8.setText(pt);
//
//
//
//                        }
//                        catch (Exception ex)
//                        {
//
//                        }


            }


        }.execute();
    }
}
