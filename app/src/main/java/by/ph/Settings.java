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
            binding.name.setText(userData.getName());
            binding.mail.setText(userData.getMail());

            binding.numPlaces.setText(userData.getVisited_places());
            binding.numQuiz.setText(userData.getQuizzes());
            binding.numSave.setText(userData.getSave_places());
        } else {
            Toast.makeText(getContext(),"dd",Toast.LENGTH_SHORT).show();
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