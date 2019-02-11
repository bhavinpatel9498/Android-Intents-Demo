package m.com.intentsdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnId = (Button) findViewById(R.id.button);
        Button btnId2 = (Button) findViewById(R.id.button2);
        Button btnId3 = (Button) findViewById(R.id.button3);

        /* Invoke system app or other apps*/
        btnId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_MAIN);

                //Replace the package name and the classname of the app you want to invoke
                intent.setComponent(new ComponentName("m.com.lab3","m.com.lab3.MainActivity"));


                //intent.setData(Uri.parse("SOME DATA"));
                startActivity(intent);

            }
        });

        /*Invoke implicit intent */
        btnId2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  Uri sms_uri = Uri.parse("smsto:3124091731");
                  Intent sms_intent = new Intent(Intent.ACTION_SENDTO,sms_uri);
                  sms_intent.putExtra("sms_body", "Demo about Implicit Intent");
                  startActivity(sms_intent);

              }
          });

        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Explicit Intent */

                EditText inputText = (EditText) findViewById(R.id.editText);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                /* Bundle data into one */
                Bundle dataBundle = new Bundle();
                dataBundle.putString("value1", inputText.getText().toString());
                intent.putExtras(dataBundle);

                /* Send without bundling */

                intent.putExtra("value2", inputText.getText().toString());

                startActivity(intent);

                }
            });





    }
}
