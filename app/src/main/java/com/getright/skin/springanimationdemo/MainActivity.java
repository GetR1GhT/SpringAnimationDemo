package com.getright.skin.springanimationdemo;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.animation_text_view)
    AppCompatTextView animationTextView;
    @BindView(R.id.tanslation_x)
    Button tanslationX;
    @BindView(R.id.tanslation_y)
    Button tanslationY;
    @BindView(R.id.tanslation_z)
    Button tanslationZ;
    @BindView(R.id.scale_x)
    Button scaleX;
    @BindView(R.id.scale_y)
    Button scaleY;
    @BindView(R.id.rotation)
    Button rotation;
    @BindView(R.id.rotation_x)
    Button rotationX;
    @BindView(R.id.rotation_y)
    Button rotationY;
    @BindView(R.id.x)
    Button x;
    @BindView(R.id.y)
    Button y;
    @BindView(R.id.z)
    Button z;
    @BindView(R.id.alpha)
    Button alpha;
    @BindView(R.id.scroll_x)
    Button scrollX;
    @BindView(R.id.scroll_y)
    Button scrollY;

    private SpringForce springForce;
    private SpringAnimation springAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tanslation_x, R.id.tanslation_y, R.id.tanslation_z, R.id.scale_x, R.id.scale_y, R.id.rotation, R.id.rotation_x, R.id.rotation_y, R.id.x, R.id.y, R.id.z, R.id.alpha, R.id.scroll_x, R.id.scroll_y})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tanslation_x:

                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_VERY_LOW)
                        .setFinalPosition(0);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.TRANSLATION_X)
                        .setSpring(springForce).setStartValue(-500f);
                springAnimation.start();
                break;
            case R.id.tanslation_y:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_LOW)
                        .setFinalPosition(0);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.TRANSLATION_Y)
                        .setSpring(springForce).setStartValue(-1000f);
                springAnimation.start();
                break;
            case R.id.tanslation_z:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setFinalPosition(0);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.TRANSLATION_Z)
                        .setSpring(springForce).setStartValue(50f);
                springAnimation.start();
                break;
            case R.id.scale_x:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_LOW)
                        .setFinalPosition(1f);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.SCALE_X)
                        .setSpring(springForce).setStartValue(2f);
                springAnimation.start();
                break;
            case R.id.scale_y:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setFinalPosition(1);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.SCALE_Y)
                        .setSpring(springForce).setStartValue(2f);
                springAnimation.start();
                break;
            case R.id.rotation:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setFinalPosition(1);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.ROTATION)
                        .setSpring(springForce).setStartValue(100f).setStartVelocity(100);
                springAnimation.start();
                break;
            case R.id.rotation_x:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_LOW)
                        .setFinalPosition(1);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.ROTATION_X)
                        .setSpring(springForce).setStartValue(200f).setStartVelocity(500);
                springAnimation.start();
                break;
            case R.id.rotation_y:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_LOW)
                        .setFinalPosition(1);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.ROTATION_Y)
                        .setSpring(springForce).setStartValue(200f).setStartVelocity(100);
                springAnimation.start();
                break;
            case R.id.x:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setFinalPosition(0);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.X)
                        .setSpring(springForce).setStartValue(1.5f);
                springAnimation.start();
                break;
            case R.id.y:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setFinalPosition(0);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.Y)
                        .setSpring(springForce).setStartValue(1.5f);
                springAnimation.start();
                break;
            case R.id.z:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setFinalPosition(0);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.Z)
                        .setSpring(springForce).setStartValue(1.5f);
                springAnimation.start();
                break;
            case R.id.alpha:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_LOW)
                        .setFinalPosition(1);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.ALPHA)
                        .setSpring(springForce).setStartValue(0).setStartValue(0.5f);
                springAnimation.start();
                break;
            case R.id.scroll_x:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setFinalPosition(1);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.SCROLL_X)
                        .setSpring(springForce).setStartValue(300f);
                springAnimation.start();

                break;
            case R.id.scroll_y:
                springForce = new SpringForce()
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_LOW)
                        .setFinalPosition(1);
                springAnimation = new SpringAnimation(animationTextView, DynamicAnimation.SCROLL_Y)
                        .setSpring(springForce).setStartValue(-200f);
                springAnimation.start();
                break;
        }
    }
}
