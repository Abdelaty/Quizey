package com.example.quizey;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.quizey.Adapter.QuizzesAdapter;
import com.example.quizey.Model.QuizzesModel;

import java.util.ArrayList;
import java.util.List;

import nl.dionsegijn.konfetti.KonfettiView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    QuizzesAdapter quizzesAdapter;
    List<QuizzesModel> quizzesModels;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    KonfettiView konfettiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_congrats);
        viewPager = findViewById(R.id.viewpager);
        konfettiView = findViewById(R.id.celebr_view);
        quizzesModels = new ArrayList<>();
        quizzesModels.add(new QuizzesModel(R.drawable.ic_launcher_background, "quiz1", "test1 test1 test1"));
        quizzesModels.add(new QuizzesModel(R.drawable.ic_launcher_background, "quiz2", "test2 test2 test2"));
        quizzesModels.add(new QuizzesModel(R.drawable.ic_launcher_background, "quiz3", "test3 test3 test3"));
        quizzesModels.add(new QuizzesModel(R.drawable.ic_launcher_background, "quiz4", "test4 test4 test4"));

        quizzesAdapter = new QuizzesAdapter(quizzesModels, this);
        viewPager.setAdapter(quizzesAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {getResources().getColor(R.color.testcolor1),
                getResources().getColor(R.color.testcolor2),
                getResources().getColor(R.color.testcolor3),
                getResources().getColor(R.color.testcolor4)};
        colors = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (quizzesAdapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )

                    );
                } else
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        konfettiView.build()
//                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
//                .setDirection(0.0, 359.0)
//                .setSpeed(1f, 5f)
//                .setFadeOutEnabled(true)
//                .setTimeToLive(2000L)
//                .addShapes(Shape.RECT, Shape.CIRCLE)
//                .addSizes(new Size(12, 5))
//                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
//                .streamFor(300, 5000L);
    }
}
