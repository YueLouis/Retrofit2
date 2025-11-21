package vn.hcmute.retrofit2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CategoryDetailActivity extends AppCompatActivity {

    private ImageView imgCategoryDetail;
    private TextView txtCategoryNameDetail;
    private TextView txtCategoryDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        imgCategoryDetail = findViewById(R.id.imgCategoryDetail);
        txtCategoryNameDetail = findViewById(R.id.txtCategoryNameDetail);
        txtCategoryDescription = findViewById(R.id.txtCategoryDescription);

        Category category = (Category) getIntent().getSerializableExtra("category");

        if (category != null) {
            txtCategoryNameDetail.setText(category.getName());
            txtCategoryDescription.setText(category.getDescription());

            Glide.with(this)
                    .load(category.getImages())
                    .into(imgCategoryDetail);
        }
    }
}
