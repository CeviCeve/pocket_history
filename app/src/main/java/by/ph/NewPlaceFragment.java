package by.ph;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import by.ph.databinding.FragmentNewPlaceBinding;


public class NewPlaceFragment extends Fragment {

    private FragmentNewPlaceBinding binding;

    public NewPlaceFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewPlaceBinding.inflate(getLayoutInflater());

        binding.click2.setOnClickListener(v->{
            Toast.makeText(getContext(), "Ошибка: 322-J3", Toast.LENGTH_SHORT).show();
        });
        binding.click3.setOnClickListener(v->{
            if(binding.name.getText().toString().isEmpty()
            || binding.place.getText().toString().isEmpty()
            || binding.chord.getText().toString().isEmpty()
            || binding.facts.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Ошибка валидации", Toast.LENGTH_SHORT).show();
            } else {
                binding.name.setText("");
                binding.place.setText("");
                binding.chord.setText("");
                binding.facts.setText("");
                Toast.makeText(getContext(), "Отправлено на модерацию", Toast.LENGTH_SHORT).show();
            }
        });
        return inflater.inflate(R.layout.fragment_new_place, container, false);
    }
}