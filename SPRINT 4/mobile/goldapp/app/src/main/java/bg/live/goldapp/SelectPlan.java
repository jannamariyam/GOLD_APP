package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SelectPlan extends AppCompatActivity {

    Button b1;
    String plan,type;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    String url1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_plan);
        plan=Packages.type;
        type=Packages.pack;
        Toast.makeText(getApplicationContext(),type,Toast.LENGTH_SHORT).show();
        if (plan.contains("Fixed"))
        {
            url1="package/android1/";
        }
        else
        {
            url1="package/android2/";
        }
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        rb5=(RadioButton)findViewById(R.id.radioButton5);
        rb6=(RadioButton)findViewById(R.id.radioButton6);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb1.setChecked(true);
                Selectplanlast.selpack=rb1.getText().toString();
                if (rb1.isChecked())
                {
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                    rb6.setChecked(false);
                }
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb2.setChecked(true);
                Selectplanlast.selpack=rb2.getText().toString();
                if (rb2.isChecked())
                {
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                    rb6.setChecked(false);
                }
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb3.setChecked(true);
                Selectplanlast.selpack=rb3.getText().toString();
                if (rb3.isChecked())
                {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                    rb6.setChecked(false);
                }
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb4.setChecked(true);
                Selectplanlast.selpack=rb4.getText().toString();
                if (rb4.isChecked())
                {
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                    rb2.setChecked(false);
                    rb5.setChecked(false);
                    rb6.setChecked(false);
                }
            }
        });
        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb5.setChecked(true);
                Selectplanlast.selpack=rb5.getText().toString();
                if (rb5.isChecked())
                {
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb2.setChecked(false);
                    rb6.setChecked(false);
                }
            }
        });
        rb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb6.setChecked(true);
                Selectplanlast.selpack=rb6.getText().toString();
                if (rb6.isChecked())
                {
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                    rb2.setChecked(false);
                }
            }
        });




        AsyncTask asyncTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                JSONObject postdata = new JSONObject();

                try {
                    postdata.put("pack", type);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                OkHttpClient client = new OkHttpClient();

                MediaType MEDIA_TYPE = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                Request request = new Request.Builder()
                        .url(MainActivity.url+url1)
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
                String p1="",p2="",p3="",p4="",p5="",p6="";
                String gram = "";
                try {
//                    JSONObject c1= new JSONObject(o.toString());
                    JSONArray array= new JSONArray(o.toString());
                    for(int i=0;i<array.length();i++) {
                        JSONObject c = array.getJSONObject(i);
                        p1 = c.getString("price1");
                        p2 = c.getString("price2");
                        p3 = c.getString("price3");
                        p4 = c.getString("price4");
                        p5 = c.getString("price5");
                        p6 = c.getString("price6");
//
//                        Toast.makeText(getApplicationContext(), sub_name, Toast.LENGTH_SHORT).show();
                    }
                    rb1.setText(p1);
                    rb2.setText(p2);
                    rb3.setText(p3);
                    rb4.setText(p4);
                    rb5.setText(p5);
                    rb6.setText(p6);

                } catch (JSONException e) {
//                            e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }

//
            }


        }.execute();



//        Toast.makeText(getApplicationContext(),plan,Toast.LENGTH_SHORT).show();
        b1=(Button)findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Selectplanlast.class);
                startActivity(i);
            }
        });
    }
}
