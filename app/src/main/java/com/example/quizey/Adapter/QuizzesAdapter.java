package com.example.quizey.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.quizey.Model.QuizzesModel;
import com.example.quizey.R;

import java.util.List;

public class QuizzesAdapter extends PagerAdapter {
    private List<QuizzesModel> quizzesModels;
    private LayoutInflater layoutInflater;
    private Context context;

    public QuizzesAdapter(List<QuizzesModel> quizzesModels, Context context) {
        this.quizzesModels = quizzesModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return quizzesModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.quiz_list_vp, container, false);

        ImageView quiz_img;

        TextView quiz_title, quiz_description;

        quiz_img = view.findViewById(R.id.quiz_path_img);
        quiz_title = view.findViewById(R.id.quiz_path_title_tv);
        quiz_description = view.findViewById(R.id.quiz_path_des_tv);

        quiz_img.setImageResource(quizzesModels.get(position).getImage());
        quiz_title.setText(quizzesModels.get(position).getTitle());
        quiz_description.setText(quizzesModels.get(position).getDesc());

        container.addView(view, 0);
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
