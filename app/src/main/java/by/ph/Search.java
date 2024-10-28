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
            Toast.makeText(this.getContext(),"text",Toast.LENGTH_SHORT).show();
        });
        return binding.getRoot();
    }


}