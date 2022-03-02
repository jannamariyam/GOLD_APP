package bg.live.goldapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import static com.example.a_file_upload.FileUtils.getPath;
import bg.live.goldapp.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static bg.live.goldapp.FileUtils.getPath;

public class PaymentSubmit extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 9544;
    Uri selectedImage;
    String part_image;
    TextView t1,t2,t3,t4;
    EditText e1;
    String pid="";
    Button b1,b2;
    ImageView imgv;

    //file
    private static final int FILE_SELECT_CODE = 0;
    String img_str;
    String flname = null;
    public static byte[] bb;
    //file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_submit);
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
        e1=(EditText)findViewById(R.id.editText11);
        t1.setText(Selectedplans.plan);
        t2.setText(Selectedplans.pay);
        t3.setText(Selectedplans.amt);
        pid=Selectedplans.plid;
        Toast.makeText(getApplicationContext(),pid,Toast.LENGTH_SHORT).show();
        b1=(Button)findViewById(R.id.button8);
        b2=(Button)findViewById(R.id.button2);
        imgv=(ImageView)findViewById(R.id.imageView2);
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.length() != 0)
                {
                    try {

                        float gms=Float.parseFloat(s.toString())/Float.parseFloat(Main2Activity.gramAmt);
                        t4.setText(Float.toString(gms));
//                        t4.setText(s);
                    }
                    catch (Exception ex)
                    {
                        t4.setText(ex.getMessage());
                    }
                }
//                    field2.setText("");

            }

            @Override
            public void afterTextChanged(Editable editable) {

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
                        .url(MainActivity.url+"payment/android2/")
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
                t4.setText(o.toString());

            }


        }.execute();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min,max;
                String err="";

                if(Selectedplans.plan.contains("Variable"))
                {

                    String[] amm=Selectedplans.amt.split("-");

                    min=Integer.parseInt(amm[0]);
                    max=Integer.parseInt(amm[1]);

                    try {

                        float eval=Float.parseFloat(e1.getText().toString());

                        if(eval>=min && eval<=max)
                        {
                            err="ok";

                        }
                        else
                        {
                            err="Invalid Amount";
                            Toast.makeText(getApplicationContext(),"Invalid amount",Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception ex)
                    {
                        err="Invalid Amount";
                        Toast.makeText(getApplicationContext(),ex.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
//                    Toast.makeText(getApplicationContext(),Selectedplans.amt,Toast.LENGTH_LONG).show();
                    min=Integer.parseInt(Selectedplans.amt);
                    try {
                        float eval = Float.parseFloat(e1.getText().toString());
                        if (eval == min) {
                            err = "ok";

                        } else {
                            err = "Invalid Amount";
                            Toast.makeText(getApplicationContext(),"Invalid amount3",Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception ex)
                    {
                        err = "Invalid Amount";
                        Toast.makeText(getApplicationContext(),"Invalid amount4",Toast.LENGTH_LONG).show();
                    }
                }

                if(err.contains("ok")) {
                    AsyncTask asyncTask = new AsyncTask() {

                        @Override
                        protected Object doInBackground(Object[] objects) {

                            JSONObject postdata = new JSONObject();

                            try {
                                postdata.put("uid", MainActivity.UID);
                                postdata.put("plan", pid);
                                postdata.put("inst", Pendingpayments.inst);
                                postdata.put("amount", e1.getText().toString());
                                postdata.put("img", img_str);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            OkHttpClient client = new OkHttpClient();

                            MediaType MEDIA_TYPE = MediaType.parse("application/json");
                            RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


                            Request request = new Request.Builder()
                                    .url(MainActivity.url + "payment/android1/")
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

                        }


                    }.execute();
                }
                else
                {
//                    Toast.makeText(getApplicationContext(),"Invalid Amount",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    public void pick(View view) throws FileNotFoundException {
        verifyStoragePermissions(PaymentSubmit.this);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Open Gallery"), PICK_IMAGE_REQUEST);
        //base 64
//

        //#############3
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST) {
            if (resultCode == RESULT_OK) {
                selectedImage = data.getData();                                                         // Get the image file URI
                String[] imageProjection = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, imageProjection, null, null, null);
                if(cursor != null) {
                    cursor.moveToFirst();
                    int indexImage = cursor.getColumnIndex(imageProjection[0]);
                    part_image = cursor.getString(indexImage);

                    //########

                    InputStream inputStream = null; // You can get an inputStream using any I/O API
                    try {
                        inputStream = new FileInputStream(part_image);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    byte[] bytes;
                        byte[] buffer = new byte[8192];
                        int bytesRead;
                        ByteArrayOutputStream output = new ByteArrayOutputStream();

                        try {
                            while ((bytesRead = inputStream.read(buffer)) != -1) {
                                output.write(buffer, 0, bytesRead);
                            }
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }

                        bytes = output.toByteArray();
                        String encodedString = Base64.encodeToString(bytes, Base64.DEFAULT);
                        img_str=encodedString;
                    //########
//                    Toast.makeText(getApplicationContext(),encodedString,Toast.LENGTH_SHORT).show();

//                    imgPath.setText(part_image);                                                        // Get the image file absolute path
                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imgv.setImageBitmap(bitmap);                                                       // Set the ImageView with the bitmap of the image
                }
            }
        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }



}
