package by.ph;

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

import by.ph.databinding.ActivityMainBinding;

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

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        init();

        search_button.setOnClickListener(v -> {
            makePreviousUnactive();
            search_button.setBackgroundResource(R.drawable.search_active);
            previous = search_button;
            openSearchMenu();
            //Toast.makeText(this,"text",Toast.LENGTH_SHORT).show();
        });

        save_button.setOnClickListener(v -> {
            makePreviousUnactive();
            save_button.setBackgroundResource(R.drawable.save_active);
            previous = save_button;
        });

        settings_button.setOnClickListener(v -> {
            makePreviousUnactive();
            settings_button.setBackgroundResource(R.drawable.settings_active);
            previous = settings_button;
            openSettingsMenu();
        });

        //openSearchMenu();
    }

    private void openSearchMenu() {
        Fragment exampleFragment = new Search();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag, exampleFragment);
        transaction.addToBackStack(null); // Позволяет вернуться к предыдущему фрагменту по нажатию кнопки "назад"
        transaction.commit();
    }

    private void openSettingsMenu() {
            Fragment exampleFragment = new Settings();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frag, exampleFragment);
            transaction.addToBackStack(null); // Позволяет вернуться к предыдущему фрагменту по нажатию кнопки "назад"
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
}