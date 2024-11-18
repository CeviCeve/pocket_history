package by.ph;

import static by.ph.data.ArrayData.buildings;
import static by.ph.data.ArrayData.favorites;
import static by.ph.data.ArrayData.lastBuilding;
import static by.ph.data.ArrayData.userData;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import by.ph.data.BuildingData;
import by.ph.data.UserData;
import by.ph.databinding.ActivityMainBinding;
import by.ph.interfaces.OnRecyclerViewItemClickListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ImageView previous;
    private ImageView search_button;
    private ImageView settings_button;
    private ImageView save_button;
    private FragmentContainerView fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        createBuildingData();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        init();

        userData = new UserData("non","text","text", 0, 0, 0);

        search_button.setOnClickListener(v -> {
            makePreviousUnactive();
            search_button.setBackgroundResource(R.drawable.search_active);
            previous = search_button;
            if(lastBuilding == null)openFragment(new StartFragment());
            else openFragment(new Search(lastBuilding));
        });

        save_button.setOnClickListener(v -> {
            makePreviousUnactive();
            save_button.setBackgroundResource(R.drawable.save_active);
            previous = save_button;
            openFragment(new FavoriteFragment());
        });

        settings_button.setOnClickListener(v -> {
            makePreviousUnactive();
            settings_button.setBackgroundResource(R.drawable.settings_active);
            previous = settings_button;

            if(userData == null) openFragment(new RegFragment());
            else if(userData.getName().equals("non")) openFragment(new RegFragment());
            else openFragment(new Settings());
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag, fragment);
        //transaction.addToBackStack(null); // Позволяет вернуться к предыдущему фрагменту по нажатию кнопки "назад"
        transaction.commit();
    }

    private void makePreviousUnactive() {
        if(previous == search_button) search_button.setBackgroundResource(R.drawable.search_unactive);
        else if(previous == settings_button) settings_button.setBackgroundResource(R.drawable.settings_unactive);
        else save_button.setBackgroundResource(R.drawable.save_unactive);
    }

    private void init() {
        search_button = findViewById(R.id.search_menu_button);
        save_button = findViewById(R.id.save_menu_button);
        settings_button = findViewById(R.id.settings_menu_button);

        fragment = findViewById(R.id.frag);

        previous = search_button;
    }

    private void createBuildingData() {
        Drawable drawable = getDrawable(R.drawable.nesvizh);
        buildings.add(new BuildingData("Несвижский замок","г.Несвиж",0, getDrawable(R.drawable.nesvizh), "Временно недоступно. Идет доработка", new double[]{53.906894,27.563843,53.22270604710993, 26.692461368346994}));
        buildings.add(new BuildingData("Площадь Победы","г.Минск",0, getDrawable(R.drawable.pl), "Временно недоступно. Идет отладка", new double[]{53.906894,27.563843,53.908760045436935, 27.575098954631187}));
        buildings.add(new BuildingData("Белая вежа","Беловежская пуща",0, getDrawable(R.drawable.vezsha), "Временно недоступно. Идет тестирование", new double[]{53.906894,27.563843,52.40485064444143, 23.819539081786854}));
    }

}