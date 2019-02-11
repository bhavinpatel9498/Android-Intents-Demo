package m.com.intentsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        /* Getting Bundle*/

        Bundle dataBundle =  getIntent().getExtras();
        String value1 = dataBundle.getString("value1");
        TextView tv1 = (TextView) findViewById(R.id.textView1);
        tv1.setText(value1);

        /* Without bundle */
        String value2 = getIntent().getStringExtra("value2");
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setText(value2);


    }



}
