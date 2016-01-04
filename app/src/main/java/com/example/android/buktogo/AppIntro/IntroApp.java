package com.example.android.buktogo.AppIntro;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.buktogo.MainActivity;
import com.example.android.buktogo.R;
import com.github.paolorotolo.appintro.AppIntro2;

/**
 * Created by jan on 12/30/15.
 */
public class IntroApp extends AppIntro2 {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onNextPressed() {
    }

//    @Override
//    public void onSkipPressed() {
//        loadMainActivity();
//    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    @Override
    public void onSlideChanged() {
    }
}
