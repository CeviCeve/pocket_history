package by.ph;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import by.ph.databinding.ActivityMainBinding;
import by.ph.databinding.FragmentSearchBinding;

public class Search extends Fragment {

    private FragmentSearchBinding binding;

    public Search() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(getLayoutInflater());


        binding.way.setOnClickListener(v -> {
            Toast.makeText(this.getContext(),"Ведутся технические работы",Toast.LENGTH_SHORT).show();
        });
        binding.save.setOnClickListener(v -> {
            Toast.makeText(this.getContext(),"Добавлено в сохранненное",Toast.LENGTH_SHORT).show();
            Toast.makeText(this.getContext(),"Ведутся технические работы",Toast.LENGTH_SHORT).show();
        });
        binding.message.setOnClickListener(v -> {
            Toast.makeText(this.getContext(),"Ведутся технические работы",Toast.LENGTH_SHORT).show();
        });
        binding.games.setOnClickListener(v -> {

        });

        binding.name.setText("Несвижский замок");
        binding.city.setText("г. Несвиж");
        binding.place.setImageDrawable(getResources().getDrawable(R.drawable.nesvizh));

        return binding.getRoot();
    }

    /*
    @Override
    public int getItemViewType(int position)
    {
        for (Group group : Assortment.assortment) {
            if (position == Assortment.assortment.indexOf(group)) {
                return 0; // Группа
            } else if (position > Assortment.assortment.indexOf(group) && position <= Assortment.assortment.indexOf(group) + group.getChild().length) {
                return 1; // Дочерний элемент
            }
        }
        return -1; // Неверный тип
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.assortment_item, parent,false);

        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<String> keys = new ArrayList<>(Assortment.assortment.keySet());
        String lineName = keys.get(position);
        holder.text.setText(lineName);
    }

    @Override
    public int getItemCount() {
        return Assortment.assortment.size();
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }

    static class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
     */

}