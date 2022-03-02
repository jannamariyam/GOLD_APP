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

public class Selectplanlast extends AppCompatActivity {
    static String selpack,type,payment;
    EditText e3,e2,e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectplanlast);
        e3=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText2);
        e1=(EditText)findViewById(R.id.editText1);
        b1=(Button)findViewById(R.id.button7);
        e3.setText(selpack);
        e2.setText(type);
        e1.setText(payment);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask asyncTask = new AsyncTask() {

                    @Override
                    protected Object doInBackground(Object[] objects) {

                        JSONObject postdata = new JSONObject();

                        try {

                            postdata.put("uid", MainActivity.UID);
                            postdata.put("plan", e2.getText().toString());
                            postdata.put("pay", e1.getText().toString());
                            postdata.put("amt", e3.getText().toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        OkHttpClient client = new OkHttpClient();

                        MediaType MEDIA_TYPE = MediaType.parse("application/json");
                        RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                        Request request = new Request.Builder()
                                .url(MainActivity.url+"uplan/android1/")
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
//                                JSONObject c= new JSONObject(o.toString());
////                                JSONArray array= new JSONArray(o.toString());
////                                JSONObject c= array.getJSONObject(0);
//                                String sub_name = c.getString("stat");
//                                Toast.makeText(getApplicationContext(),sub_name,Toast.LENGTH_SHORT).show();
////                              Toast.makeText(getApplicationContext(),Integer.toString(array.length()),Toast.LENGTH_SHORT).show();
//
//
//                        } catch (JSONException e) {
////                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
//                        }
                    }


                }.execute();
            }
        });

    }
}
