package kr.hs.emirim.s2019s11.mirimbestlikesslideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ResultActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    ViewFlipper flipper;
    int[] imgRes = {R.drawable.vote1, R.drawable.vote2, R.drawable.vote3, R.drawable.vote4, R.drawable.vote5, R.drawable.vote6, R.drawable.vote7, R.drawable.vote8, R.drawable.vote9};
    String[] imgNames = {"주황런쥔", "청순도영", "패딩영훈", "이재현", "당근준휘", "금발준휘", "멈머지성", "조슈아", "핑크찬희"};
    ImageView[] imgvs = new ImageView[imgNames.length];
    int[] imgvIds = {R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6,R.id.img7,R.id.img8,R.id.img9};

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

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0;i < imgRes.length-1; i++) {
            for(int j = i+1; j < imgRes.length; j++) {
                if(voteCount[i] < voteCount[j]) {
                    temp1 = voteCount[i];
                    voteCount[i] = voteCount[j];
                    voteCount[j] = temp1;

                    temp2 = imgRes[i];
                    imgRes[i] = imgRes[j];
                    imgRes[j] = temp2;
                }
            }
        }

        for(int i=0; i<imgvIds.length; i++) {
            imgvs[i] = findViewById(imgvIds[i]);
            imgvs[i].setImageResource(imgRes[i]);
        }
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