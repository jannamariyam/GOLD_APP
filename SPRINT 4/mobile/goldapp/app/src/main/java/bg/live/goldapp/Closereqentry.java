package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Closereqentry extends AppCompatActivity {
//    setContentView(R.layout.activity_closereqentry);
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    EditText e1;
    int tterm=0;
    String pid="";
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closereqentry);

        try
        {
            if (android.os.Build.VERSION.SDK_INT > 9)
            {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
        }
        catch(Exception e)
        {
        }
        t1=(TextView)findViewById(R.id.textView15);
        t2=(TextView)findViewById(R.id.textView17);
        t3=(TextView)findViewById(R.id.textView18);
        t4=(TextView)findViewById(R.id.textView22);
        t5=(TextView)findViewById(R.id.textView26);
        t6=(TextView)findViewById(R.id.textView36);
        t7=(TextView)findViewById(R.id.textView32);
        t8=(TextView)findViewById(R.id.textView38);
//        e1=(EditText)findViewById(R.id.editText11);
        t1.setText(ClosereqMain.plan);
        t2.setText(ClosereqMain.pay);
        t3.setText(ClosereqMain.amt);
        t5.setText(ClosereqMain.dat);
        pid=ClosereqMain.plid;
        b1=(Button)findViewById(R.id.button8);
        if(ClosereqMain.pay.contains("Monthly"))
        {
            tterm=12;
        }
        else
        {
            tterm=48;
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                                .url(MainActivity.url+"close/android1/")
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
                        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                        startActivity(i);
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
        });


        AsyncTask asyncTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                JSONObject postdata = new JSONObject();

                try {

                    postdata.put("plan", pid);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


                OkHttpClient client = new OkHttpClient();

                MediaType MEDIA_TYPE = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                Request request = new Request.Builder()
                        .url(MainActivity.url+"payment/android3/")
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
//                Toast.makeText(getApplicationContext(), o.toString(), Toast.LENGTH_SHORT).show();
                try {
                    String[] det=o.toString().split("#");
                    t4.setText(det[0]);
                    t6.setText(det[1]);
                    t7.setText(det[2]);
                    String pt= Integer.toString (tterm- Integer.parseInt(det[2]));
                    t8.setText(pt);



                }
                catch (Exception ex)
                {

                }


            }


        }.execute();







    }
}
