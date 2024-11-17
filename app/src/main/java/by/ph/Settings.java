package by.ph;

import static by.ph.data.ArrayData.userData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import by.ph.databinding.FragmentSettingsBinding;

public class Settings extends Fragment {

    private FragmentSettingsBinding binding;

    public Settings() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(getLayoutInflater());
        if(userData != null) {
            //binding.ava.setBackground(userData.getDrawable());
            String i = userData.getName();
            binding.name.setText(i);
            binding.mail.setText(userData.getMail());

            binding.numPlaces.setText("0");
            binding.numQuiz.setText(String.valueOf(userData.getSave_places()));
            binding.numSave.setText(String.valueOf(userData.getQuizzes()));

        } else {
            Toast.makeText(getContext(),"Ошибка: S003-1",Toast.LENGTH_SHORT).show();
        }

        binding.newObject.setOnClickListener(v->{
            NewPlaceFragment secondFragment = new NewPlaceFragment();
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.frag, secondFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return binding.getRoot();
    }


}