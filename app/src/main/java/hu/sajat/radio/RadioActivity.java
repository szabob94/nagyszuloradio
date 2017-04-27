package hu.sajat.radio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RadioActivity extends AppCompatActivity {

    private static final int MAX_VOLUME = 25;

    private MediaPlayer mediaPlayer;
    private List<RadioEntity> radioEntities;

    private ListView radioListView;
    private RadioListViewAdapter radioListViewAdapter;
    private AudioManager audioManager;
    private int currentVolume = 5;
    private ImageButton volumeMinus;
    private ImageButton volumePlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        mediaPlayer = new MediaPlayer();
        radioListView = (ListView) findViewById(R.id.listview_radio);
        radioEntities = new ArrayList<>();
        initRadios();
        radioListViewAdapter = new RadioListViewAdapter(this, 0, radioEntities);
        radioListView.setAdapter(radioListViewAdapter);
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        volumeMinus = (ImageButton) findViewById(R.id.volume_minus);
        volumeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentVolume--;
                float log1 = (float) (Math.log(MAX_VOLUME - currentVolume) / Math.log(MAX_VOLUME));
                mediaPlayer.setVolume(log1, log1);
            }
        });
        volumePlus = (ImageButton) findViewById(R.id.volume_plus);
        volumePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentVolume++;
                float log1 = (float) (1 - (Math.log(MAX_VOLUME - currentVolume) / Math.log(MAX_VOLUME)));
                mediaPlayer.setVolume(log1, log1);
            }
        });
    }

    private void initRadios() {
        if (radioEntities != null) {
            radioEntities.add(new RadioEntity(
                    0, R.drawable.bartok, "http://icast.connectmedia.hu/4741/mr3.mp3", "Bartók Rádió"
            ));
            radioEntities.add(new RadioEntity(
                    1, R.drawable.danko, "http://icast.connectmedia.hu/4748/mr7.mp3", "Dankó Rádió"
            ));
            radioEntities.add(new RadioEntity(
                    2, R.drawable.kossuth_radio, "http://icast.connectmedia.hu/4736/mr1.mp3", "Kossuth Rádió"
            ));
        }
    }
}
