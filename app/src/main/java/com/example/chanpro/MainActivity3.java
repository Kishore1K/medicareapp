package com.example.chanpro;

import androidx.appcompat.app.AppCompatActivity;

        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    static final int ALARAM_REQ_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText editText=findViewById(R.id.edtTime);

        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int time=Integer.parseInt(((EditText)(findViewById(R.id.edtTime))).getText().toString());
                long triggerTime=System.currentTimeMillis()+(time*1000);

                Intent iBroadCast=new Intent(MainActivity3.this,MyReceiver.class);

                PendingIntent pi=PendingIntent.getBroadcast(MainActivity3.this,ALARAM_REQ_CODE,iBroadCast,PendingIntent.FLAG_UPDATE_CURRENT);


                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);



            }
        });



    }
}