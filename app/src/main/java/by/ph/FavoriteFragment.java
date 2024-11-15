package by.ph;

import static by.ph.data.ArrayData.buildings;
import static by.ph.data.ArrayData.favorites;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import by.ph.adapter.FavoriteAdapter;
import by.ph.data.BuildingData;
import by.ph.databinding.FragmentFavoriteBinding;
import by.ph.interfaces.OnRecyclerViewItemClickListener;


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

        binding.favoriteListView.setAdapter(new FavoriteAdapter(getContext(), favorites, new OnRecyclerViewItemClickListener() {
            @Override
            public void onClick() {
                Search secondFragment = new Search();
                FragmentTransaction transaction = requireFragmentManager().beginTransaction();
                transaction.replace(R.id.frag, secondFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }));
        binding.favoriteListView.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }
}