package by.ph.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.ph.R;
import by.ph.data.BuildingData;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteHandler> {

    FavoriteHandler previous;
    List<BuildingData> data;
    Context context;


    public FavoriteAdapter(@NonNull Context context, List<BuildingData> data){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorite_item, parent,false);
        return new FavoriteHandler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteHandler holder, int position) {
        BuildingData buildingData = data.get(position);
        holder.text.setText(String.valueOf(position+1 + ". " + buildingData.getName()));
        holder.constraintLayout.setOnClickListener(v -> {
            if(previous != null){
                previous.constraintLayout.setBackgroundTintList(context.getResources().getColorStateList(R.color.background_dark));
                previous.imageView.setVisibility(View.INVISIBLE);
            }
            holder.constraintLayout.setBackgroundTintList(context.getResources().getColorStateList(R.color.white));
            holder.imageView.setVisibility(View.VISIBLE);

            previous = holder;
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class FavoriteHandler extends RecyclerView.ViewHolder {
        TextView text;
        ImageView imageView;
        ConstraintLayout constraintLayout;

        public FavoriteHandler(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.name_and_num);
            imageView = itemView.findViewById(R.id.go_to);
            constraintLayout = itemView.findViewById(R.id.favorite_item_background);
        }
    }
}
