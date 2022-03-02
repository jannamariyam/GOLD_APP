package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;
//import android.app.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
//    Button b1;
    EditText t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    Button b1,btdt;
    private int year, month, day;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=(Button)findViewById(R.id.button);
        btdt=(Button)findViewById(R.id.btdate);
        t1=(EditText)findViewById(R.id.editText1);
        t2=(EditText)findViewById(R.id.editText2);
        t3=(EditText)findViewById(R.id.editText3);
        t4=(EditText)findViewById(R.id.editText4);
        t5=(EditText)findViewById(R.id.editText5);
        t6=(EditText)findViewById(R.id.editText6);
        t7=(EditText)findViewById(R.id.editText7);
        t8=(EditText)findViewById(R.id.editText8);
        t9=(EditText)findViewById(R.id.editText9);
        t10=(EditText)findViewById(R.id.editText10);
//        t11=(EditText)findViewById(R.id.editText11);
        t12=(EditText)findViewById(R.id.editText12);
        t13=(EditText)findViewById(R.id.editText13);

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
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String em = t3.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@gmail+\\.+com+";
                if (!em.matches(emailPattern)) {
                    t3.setText("");
                    t3.setError("Not in e-mail format");
                }


                String mo = t2.getText().toString();
                if (mo.length() != 10) {
                    t2.setText("");
                    t2.setError("Invalid number...");
                }
                String mob = t6.getText().toString();
                if (mob.length() != 10) {
                    t6.setText("");
                    t6.setError("Invalid number...");
                }
                String pn = t8.getText().toString();
                if (pn.length() != 6) {
                    t8.setText("");
                    t8.setError("Invalid format...");
                }





                if(!t1.getText().toString().equals("")&&!t2.getText().toString().equals("")&&!t4.getText().toString().equals("")&&!t3.getText().toString().equals("")
                        &&!t5.getText().toString().equals("")&&!t6.getText().toString().equals("")
                        &&!t7.getText().toString().equals("")&&!t8.getText().toString().equals("")&&!t9.getText().toString().equals("")
                        &&!t10.getText().toString().equals("")&&!t12.getText().toString().equals("")
                        &&!t13.getText().toString().equals("")) {

                    AsyncTask asyncTask = new AsyncTask() {

                        @Override
                        protected Object doInBackground(Object[] objects) {

                            JSONObject postdata = new JSONObject();

                            try {
                                postdata.put("name", t1.getText().toString());
                                postdata.put("phone", t2.getText().toString());
                                postdata.put("email", t3.getText().toString());
                                postdata.put("dob", t4.getText().toString());
                                postdata.put("nomi", t5.getText().toString());
                                postdata.put("nph", t6.getText().toString());
                                postdata.put("aad", t7.getText().toString());
                                postdata.put("pin", t8.getText().toString());
                                postdata.put("dist", t9.getText().toString());
                                postdata.put("acc", t10.getText().toString());
//                                postdata.put("jdat", "2022-02-02");
//                                postdata.put("jdat", "2022-02-02");
                                postdata.put("un", t12.getText().toString());
                                postdata.put("pwd", t13.getText().toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            OkHttpClient client = new OkHttpClient();

                            MediaType MEDIA_TYPE = MediaType.parse("application/json");
                            RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                            Request request = new Request.Builder()
                                    .url(MainActivity.url+"customer/register/")
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
                else
                {
                    Toast.makeText(getApplicationContext(), "Please fill the required fields", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        t4.setText(new StringBuilder().append(year).append("/")
                .append(month).append("/").append(day));
    }




}
