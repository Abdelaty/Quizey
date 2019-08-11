package com.example.quizey;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.quizey.Adapter.QuizzesAdapter;
import com.example.quizey.Model.QuizzesModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    QuizzesAdapter quizzesAdapter;
    List<QuizzesModel> quizzesModels;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quiz_path);

        quizzesModels = new ArrayList<>();
        quizzesModels.add(new QuizzesModel(R.id.background, "quiz1", "test1 test1 test1"));
        quizzesModels.add(new QuizzesModel(R.id.background, "quiz2", "test2 test2 test2"));
        quizzesModels.add(new QuizzesModel(R.id.background, "quiz3", "test3 test3 test3"));
        quizzesModels.add(new QuizzesModel(R.id.background, "quiz4", "test4 test4 test4"));

        quizzesAdapter = new QuizzesAdapter(quizzesModels, this);
        viewPager.findViewById(R.id.viewpager);
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
                    viewPager.setBackgroundResource(
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

    }
}
