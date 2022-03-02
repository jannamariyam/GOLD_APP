package bg.live.goldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Packages extends AppCompatActivity {
    Button b1;
    static String pack,type;
    Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages);
        b1=(Button)findViewById(R.id.button2);
        sp1=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pack=sp1.getSelectedItem().toString();
                type=sp2.getSelectedItem().toString();
                Selectplanlast.type=type;
                Selectplanlast.payment=pack;

//               Toast.makeText(getApplicationContext(), pack, Toast.LENGTH_SHORT).show();

                Intent i=new Intent(getApplicationContext(),SelectPlan.class);
                startActivity(i);
            }
        });
    }
}
