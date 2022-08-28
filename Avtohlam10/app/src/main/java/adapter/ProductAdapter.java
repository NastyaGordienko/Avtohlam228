package adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avtohlam10.ProductPage;
import com.example.avtohlam10.R;

import java.util.List;

import model.Product;

public class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);

        return new ProductViewHolder(productItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
holder.productBg.setCardBackgroundColor(Color.parseColor(products.get(position).getColor()));
holder.productTitle.setText(products.get(position).getTitle());
holder.productLevel.setText(products.get(position).getLevel());
        holder.productDate.setText(products.get(position).getDate());
        int imageId=context.getResources().getIdentifier("ic_"+products.get(position).getImg(),"drawable",context.getPackageName());
        holder.productImg.setImageResource(imageId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ProductPage.class);

                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation((Activity)
                        context,new Pair<View,String>(holder.productImg,"productImg"));


                intent.putExtra("Bg",Color.parseColor(products.get(position).getColor()));
                intent.putExtra("Title",products.get(position).getTitle());
                intent.putExtra("Date",products.get(position).getDate());
                intent.putExtra("Level",products.get(position).getLevel());
                intent.putExtra("Text",products.get(position).getText());
                intent.putExtra("Img",imageId);
                intent.putExtra("productId",products.get(position).getId());
                context.startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView productBg;
        TextView productLevel,productDate,productTitle;
        ImageView productImg;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productBg = itemView.findViewById(R.id.productBg);
            productDate=itemView.findViewById(R.id.productDate);
            productTitle = itemView.findViewById(R.id.productTitle);
            productLevel=itemView.findViewById(R.id.productLevel);
            productImg=itemView.findViewById(R.id.productImg);
        }
    }
}
