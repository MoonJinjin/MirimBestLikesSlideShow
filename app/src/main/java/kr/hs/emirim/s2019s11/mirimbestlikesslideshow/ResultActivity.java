package kr.hs.emirim.s2019s11.mirimbestlikesslideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ResultActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
        flipper = findViewById(R.id.img_view);

        flipper.setFlipInterval(1000);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    flipper.startFlipping();
                    break;
                case R.id.btn_stop:
                    flipper.stopFlipping();
                    break;
            }
        }
    };
}