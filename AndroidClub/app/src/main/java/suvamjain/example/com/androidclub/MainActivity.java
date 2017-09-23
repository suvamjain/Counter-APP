package suvamjain.example.com.androidclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    TextView text;
    Button switch1;
    Animation animSlideUp;
    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);
        switch1 = (Button)findViewById(R.id.bt);

        // load the animation
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideup);

        // set animation listener
        animSlideUp.setAnimationListener(this);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                text.setVisibility(View.VISIBLE);
                // start the animation
                text.startAnimation(animSlideUp);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {}

    @Override
    public void onAnimationEnd(Animation animation) {
        // check for slide up animation
        if (animation == animSlideUp) {
            text.setText("" + i);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {}
}
