package by.ph;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import static by.ph.data.ArrayData.buildings;
import static by.ph.data.ArrayData.favorites;
import static by.ph.worker.Finder.findBuildingByName;
import static by.ph.worker.Finder.findFavoriteByName;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import by.ph.data.BuildingData;
import by.ph.databinding.ActivityMainBinding;
import by.ph.databinding.FragmentSearchBinding;

public class Search extends Fragment {

    private FragmentSearchBinding binding;
    private String name;
    private String city;
    private Drawable place;
    private Context context;

    public Search() {}

    public Search(BuildingData data) {
        name = data.getName();
        city = data.getCity();
        place = data.getPlace();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(getLayoutInflater());
        context = getContext();

//        if(findFavoriteByName(name) != -1) {
//            binding.save.setBackgroundResource(R.drawable.saved);
//        }

        binding.way.setOnClickListener(v -> {
            Toast.makeText(this.getContext(),"Ведутся технические работы",Toast.LENGTH_SHORT).show();
        });
        binding.save.setOnClickListener(v -> {
            if(findFavoriteByName(name) != -1) {
                favorites.remove(findFavoriteByName(name));
                binding.save.setBackgroundResource(R.drawable.save);
                Toast.makeText(this.getContext(),"Удалено из сохранненных",Toast.LENGTH_SHORT).show();
            }
            else {
                favorites.add(buildings.get(findBuildingByName(name)));
                binding.save.setBackgroundResource(R.drawable.saved);
                Toast.makeText(this.getContext(),"Добавлено в сохранненные",Toast.LENGTH_SHORT).show();
            }
        });
        binding.message.setOnClickListener(v -> {
            Toast.makeText(this.getContext(),"Ведутся технические работы",Toast.LENGTH_SHORT).show();
        });
        binding.games.setOnClickListener(v -> {

        });

        binding.name.setText(name);
        binding.city.setText(city);
        binding.place.setImageDrawable(place);

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
                    iMM.hideSoftInputFromWindow(binding.searchBar.getWindowToken(), 0 );

                    // Здесь можно выполнять нужные действия с текстом
                    //Toast.makeText(getContext(), "Вы ввели: " + text, Toast.LENGTH_SHORT).show();
                    //if(findBuildingByName(text)) {}
                    //else {}

                    return true;
                }
                return false;
            }
        });

        return binding.getRoot();

    }

    private void openAR() {
        Fragment exampleFragment = new AR();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frag, exampleFragment);
        transaction.addToBackStack(null); // Позволяет вернуться к предыдущему фрагменту по нажатию кнопки "назад"
        transaction.commit();
    }


}