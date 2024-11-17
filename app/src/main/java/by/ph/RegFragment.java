package by.ph;

import static androidx.appcompat.content.res.AppCompatResources.getDrawable;
import static by.ph.data.ArrayData.buildings;
import static by.ph.data.ArrayData.userData;
import static by.ph.worker.Finder.findBuildingByName;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import by.ph.data.UserData;
import by.ph.databinding.FragmentRegBinding;


public class RegFragment extends Fragment {

    private FragmentRegBinding binding;
    public RegFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegBinding.inflate(getLayoutInflater());

        binding.reg.setOnClickListener(v->{
            //Toast.makeText(getContext(),"Ошибка валидации", Toast.LENGTH_SHORT).show();
            if(binding.name.getText().toString().isEmpty()
                    || binding.mail.getText().toString().isEmpty()
                    || binding.password.getText().toString().isEmpty()) {
                Toast.makeText(getContext(),"Ошибка валидации", Toast.LENGTH_SHORT).show();
            } else {
                userData.setName(binding.name.getText().toString());
                userData.setMail(binding.mail.getText().toString());
                userData.setPassword(binding.password.getText().toString());
                openSettings();
            }
        });
        return binding.getRoot();
    }

    private void openSettings() {
        Settings secondFragment = new Settings();
        FragmentTransaction transaction = requireFragmentManager().beginTransaction();
        transaction.replace(R.id.frag, secondFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}