package by.ph;

import static java.util.List.of;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import by.ph.adapter.FavoriteAdapter;
import by.ph.data.BuildingData;
import by.ph.databinding.FragmentFavoriteBinding;


public class FavoriteFragment extends Fragment {

    FragmentFavoriteBinding binding;

    public FavoriteFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());


        ArrayList<BuildingData> data = new ArrayList<>();
        data.add(new BuildingData("Name", "", 1));
        data.add(new BuildingData("SECOND", "", 2));
        data.add(new BuildingData("IDK", "", 3));

        binding.favoriteListView.setAdapter(new FavoriteAdapter(getContext(), data));
        binding.favoriteListView.setLayoutManager(new LinearLayoutManager(getContext()));

        FavoriteAdapter adapter = new FavoriteAdapter(getContext(), data);
        binding.favoriteListView.setAdapter(adapter);
        return binding.getRoot();
    }
}