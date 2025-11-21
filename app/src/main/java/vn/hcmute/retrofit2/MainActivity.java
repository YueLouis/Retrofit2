package vn.hcmute.retrofit2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private ArrayList<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = findViewById(R.id.rcvCategory);

        categoryList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(this, categoryList);

        rcvCategory.setLayoutManager(new LinearLayoutManager(this));
        rcvCategory.setAdapter(categoryAdapter);

        loadCategories();
    }

    private void loadCategories() {
        APIService apiService = ApiClient.getService();
        Call<List<Category>> call = apiService.getCategories();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call,
                                   Response<List<Category>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    categoryList.clear();
                    categoryList.addAll(response.body());   // lấy HẾT 12 category
                    categoryAdapter.notifyDataSetChanged();

                    // debug nhỏ: xem số lượng
                    Toast.makeText(MainActivity.this,
                            "Số category: " + categoryList.size(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Lỗi: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Gọi API thất bại: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
