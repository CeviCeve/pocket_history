package by.ph;

import static by.ph.data.ArrayData.buildings;
import static by.ph.data.ArrayData.lastBuilding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.ph.databinding.FragmentArBinding;

public class AR extends Fragment {

    private FragmentArBinding binding;

    public AR() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentArBinding.inflate(getLayoutInflater());

        binding.text16.setText(lastBuilding.getName());

        binding.pointer1.setOnClickListener(v -> {
            binding.text18.setText("Вечный огонь");
            binding.text3.setText(R.string.if3);
            binding.imageView15.setBackgroundResource(R.drawable.pl3);

            binding.pointer1.setBackgroundResource(R.drawable.point_green);
            binding.pointer2.setBackgroundResource(R.drawable.point_red);
            binding.pointer3.setBackgroundResource(R.drawable.point_red);
        });
        binding.pointer2.setOnClickListener(v -> {
            binding.text18.setText("Горельефы");
            binding.text3.setText(R.string.if1);
            binding.imageView15.setBackgroundResource(R.drawable.pl1);

            binding.pointer1.setBackgroundResource(R.drawable.point_red);
            binding.pointer2.setBackgroundResource(R.drawable.point_green);
            binding.pointer3.setBackgroundResource(R.drawable.point_red);

        });
        binding.pointer3.setOnClickListener(v -> {
            binding.text18.setText("Меч");
            binding.text3.setText(R.string.if2);
            binding.imageView15.setBackgroundResource(R.drawable.pl2);

            binding.pointer1.setBackgroundResource(R.drawable.point_red);
            binding.pointer2.setBackgroundResource(R.drawable.point_red);
            binding.pointer3.setBackgroundResource(R.drawable.point_green);
        });
        return binding.getRoot();
    }
}