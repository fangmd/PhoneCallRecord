package com.adouble.phonerecorddemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private File file;
    private Button btn5,btn6;
    // 语音操作对象
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        Intent service = new Intent(this, PhoneService.class);
        startService(service); // 启动服务
    }

    private void findViews() {
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn5:
                String path=AppliacationIMmpl.file.getAbsolutePath();
                mPlayer = new MediaPlayer();
                try {
                    mPlayer.setDataSource(path);
                    mPlayer.prepare();
                    mPlayer.start();
                    Toast.makeText(this,path, Toast.LENGTH_LONG)
                            .show();
                } catch (IOException e) {
                    Log.e("11", "播放失败");
                }
                break;
            case R.id.btn6:
                mPlayer.release();
                mPlayer = null;
                break;
        }

    }

}