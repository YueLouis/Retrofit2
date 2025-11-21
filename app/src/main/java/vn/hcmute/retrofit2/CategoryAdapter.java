package vn.hcmute.retrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> list;

    public CategoryAdapter(Context context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = list.get(position);

        holder.txtName.setText(category.getName());

        // LOAD ẢNH VỚI GLIDE GIỐNG SLIDE
        Glide.with(context)
                .load(category.getImages())   // chú ý dùng getImages()
                .into(holder.imgThumb);

        // XỬ LÝ CLICK GIỐNG DEMO: TOAST TÊN CATEGORY
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context,
                    "Bạn chọn " + category.getName(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgThumb;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtCategoryName);
            imgThumb = itemView.findViewById(R.id.imgCategory);
        }
    }
}

