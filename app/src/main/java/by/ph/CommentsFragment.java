package by.ph;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import by.ph.databinding.FragmentCommentsBinding;


public class CommentsFragment extends Fragment {

    private FragmentCommentsBinding binding;

    public CommentsFragment(){};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCommentsBinding.inflate(getLayoutInflater());

        binding.click.setOnClickListener(v->{
            if(binding.searchBar2.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Введите текст", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Отправлено на модерацию", Toast.LENGTH_SHORT).show();
                 binding.searchBar2.setText("");
                //скрыть клавиатуру
                InputMethodManager iMM = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                iMM.hideSoftInputFromWindow(binding.searchBar2.getWindowToken(), 0);
            }
        });

        return binding.getRoot();
    }
}