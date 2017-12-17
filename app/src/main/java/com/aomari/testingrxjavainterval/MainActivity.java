package com.aomari.testingrxjavainterval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textViewSpeed)
    TextView textViewSpeed;
    @BindView(R.id.seekBar)
    SeekBar seekBar;

    TickHandler tickHandler;
    private int timer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String label = String.valueOf(i) + "/sec";

                tickHandler.setPeriod(i * 1000);
                textViewSpeed.setText(label);
                if (tickHandler.isRunning()) {
                    tickHandler.stop();
                    tickHandler.resume();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tickHandler = new TickHandler();
        tickHandler.setOnTickListener(() -> textView.setText(String.valueOf(++timer)));
    }

    @OnClick(R.id.start)
    void onStartCounting() {
        tickHandler.resume();
    }

    @OnClick(R.id.stop)
    void onStopCounting() {
        tickHandler.stop();
    }

    @OnClick(R.id.reset)
    void omRestCounting() {
        tickHandler.stop();
        timer = 0;
        textView.setText(String.valueOf(timer));
    }
}
