package by.ph;

import static java.lang.Math.random;
import static by.ph.data.ArrayData.buildings;
import static by.ph.data.ArrayData.lastBuilding;
import static by.ph.worker.Finder.findBuildingByName;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import by.ph.databinding.FragmentSearchBinding;
import by.ph.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;

    public StartFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(getLayoutInflater());

        //Поиск
        binding.searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {

                    String text = binding.searchBar.getText().toString();
                    binding.searchBar.clearFocus();

                    //скрыть клавиатуру
                    InputMethodManager iMM = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    iMM.hideSoftInputFromWindow(binding.searchBar.getWindowToken(), 0);

                    // Здесь можно выполнять нужные действия с текстом
                    if(findBuildingByName(text) !=-1) { openSearch(findBuildingByName(text)); }
                    else {
                        Toast.makeText(getContext(), "Ничего не найдено", Toast.LENGTH_SHORT).show();}

                    return true;
                }
                return false;
            }
        });
        binding.randomButton.setOnClickListener(v -> {
            openSearch((int) Math.random() * buildings.size());
        });
        return binding.getRoot();
    }

    private void openSearch(int i) {
        lastBuilding = buildings.get(i);
        Search secondFragment = new Search(lastBuilding);
        FragmentTransaction transaction = requireFragmentManager().beginTransaction();
        transaction.replace(R.id.frag, secondFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}