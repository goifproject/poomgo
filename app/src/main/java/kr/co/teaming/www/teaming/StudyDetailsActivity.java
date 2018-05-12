package kr.co.teaming.www.teaming;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class StudyDetailsActivity extends AppCompatActivity {
    ImageView study_details_title_image;
    ImageView study_details_person_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_details);

        // 이미지뷰 모서리 라운딩 처리
        study_details_title_image = findViewById(R.id.study_details_title_image);
        GradientDrawable gradientDrawable = (GradientDrawable) getDrawable(R.drawable.background_rounding);
        study_details_title_image.setBackground(gradientDrawable);
        study_details_title_image.setClipToOutline(true);

        // 써클 이미지뷰
        study_details_person_image = findViewById(R.id.study_details_person_image);
        study_details_person_image.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            study_details_person_image.setClipToOutline(true);
        }

    }
}
