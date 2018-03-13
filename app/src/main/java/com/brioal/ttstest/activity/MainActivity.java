package com.brioal.ttstest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import com.brioal.ttstest.R;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnInitListener{
    private Button speechButton;
    private TextView speechText;
    private TextToSpeech tts;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);

        speechText = findViewById(R.id.speechTextView);
        speechButton = findViewById(R.id.speechButton);
        speechButton.setOnClickListener(new OnClickListener()
        {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
              //  tts.speak(speechText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onInit(int status)
    {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS)
        {
            Toast.makeText(MainActivity.this, "成功输出语音", Toast.LENGTH_SHORT).show();
            //指定当前朗读的是英文，如果不是给予提示
        int result = tts.setLanguage(Locale.US);
           // int result = tts.setLanguage(Locale.CHINESE);//制定当前阅读的是中文
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Toast.makeText(MainActivity.this, R.string.notAvailable, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
