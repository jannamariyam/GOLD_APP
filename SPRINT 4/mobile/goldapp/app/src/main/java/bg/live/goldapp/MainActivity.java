package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2;
   // static String url="http://192.168.18.3:8000/";

    static String url="http://192.168.43.179:8000/";
    static String UID,uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!e1.getText().toString().equals("")&&!e2.getText().toString().equals("")) {
                    uname=e1.getText().toString();
                    pass=e2.getText().toString();
                    AsyncTask asyncTask = new AsyncTask() {

                        @Override
                        protected Object doInBackground(Object[] objects) {

                            JSONObject postdata = new JSONObject();

                            try {
                                postdata.put("un", e1.getText().toString());
                                postdata.put("pwd", e2.getText().toString());
//                                postdata.put("un", "a");
//                                postdata.put("pwd", "b");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            OkHttpClient client = new OkHttpClient();

                            MediaType MEDIA_TYPE = MediaType.parse("application/json");
                            RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                            Request request = new Request.Builder()
                                    .url(MainActivity.url+"login/login/")
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

                            if(o.toString().contains("Successfull"))
                            {
                                String[] ob=o.toString().split("#");
                                UID=ob[1];

                                Toast.makeText(getApplicationContext(), UID.toString(), Toast.LENGTH_SHORT).show();


                            Intent i = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(i);
                           }
//
                        }


                    }.execute();
//
                }
                else
                    {
                    Toast.makeText(getApplicationContext(),"Please fill the required fields" , Toast.LENGTH_SHORT).show();

                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
