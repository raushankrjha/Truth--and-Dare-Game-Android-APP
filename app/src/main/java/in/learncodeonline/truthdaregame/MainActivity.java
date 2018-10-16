package in.learncodeonline.truthdaregame;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
ImageButton i1;
Button b1;
Random r;
int angle;
boolean restart=false;
    MediaPlayer m1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"Click On Start for Play",Toast.LENGTH_SHORT).show();
        r=new Random();
        i1=(ImageButton)findViewById(R.id.imageButton);
        b1=(Button)findViewById(R.id.button);


        //create object of media player
        m1 = MediaPlayer.create(MainActivity.this, R.raw.fv);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(restart)
                {
                    //set into center
                    angle=angle % 360;
                    RotateAnimation rotate = new RotateAnimation(angle,360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    i1.startAnimation(rotate);

                    restart=false;
                    b1.setText("START");

                }
                else {
                    angle = r.nextInt(3600) + 360;
                    RotateAnimation rotate = new RotateAnimation(0, angle, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    i1.startAnimation(rotate);
                    restart=true;
                    b1.setText("RESET");
                }
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(restart)
                {
                    angle=angle % 360;
                    RotateAnimation rotate = new RotateAnimation(angle,360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    i1.startAnimation(rotate);
                    restart=false;
                    b1.setText("START");

                }
                else {
                    angle = r.nextInt(4600) + 360;
                    RotateAnimation rotate = new RotateAnimation(0, angle, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(4600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    i1.startAnimation(rotate);
                    restart=true;
                    b1.setText("RESET");
                }
            }
        });
    }
    boolean doubleBackToExitPressedOnce=false;
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

        super.onBackPressed();

    }
}
