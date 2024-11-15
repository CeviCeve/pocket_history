package by.ph.adapter;

import static by.ph.data.ArrayData.favorites;
import static by.ph.worker.Finder.findFavoriteByName;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.ph.MainActivity;
import by.ph.R;
import by.ph.Search;
import by.ph.data.BuildingData;
import by.ph.interfaces.OnRecyclerViewItemClickListener;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteHandler> {

    FavoriteHandler previous;
    List<BuildingData> data;
    Context context;

    private OnRecyclerViewItemClickListener mClickListener;

    public FavoriteAdapter(@NonNull Context context, List<BuildingData> data, OnRecyclerViewItemClickListener clickListener){
        this.data = data;
        this.context = context;
        mClickListener = clickListener;
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
            if(holder == previous) {
                //Toast.makeText(context, "text", Toast.LENGTH_SHORT).show();

                if (mClickListener != null) {
                    mClickListener.onClick(buildingData);
                }
                //new MainActivity().openFragment(new Search(favorites.get(findFavoriteByName(buildingData.getName()))));
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
