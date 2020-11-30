package kr.hs.emirim.s2019s11.mirimbestlikesslideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"주황런쥔", "청순도영", "패딩영훈", "이재현", "당근준휘", "금발준휘", "멈머지성", "조슈아", "핑크찬희"};
    int[] voteCount = new int[imgNames.length];
    ImageView[] imgVs = new ImageView[imgNames.length];
    int[] imgVIds = {R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6,R.id.img7,R.id.img8,R.id.img9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("취향의 아이돌 투표");

        for(int i=0; i<voteCount.length; i++) {
            voteCount[i] = 0;
        }
        for(int i=0; i<imgVs.length; i++) {
            final int index;
            index = i;
            imgVs[index] = findViewById(imgVIds[index]);
            imgVs[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgNames[index] + ": 총 " + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("voteCount", voteCount);
            intent.putExtra("imgNames", imgNames);
            startActivity(intent);
        }
    };
}