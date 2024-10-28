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

import by.ph.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ImageView previous;
    private ImageView search_button;
    private ImageView settings_button;
    private ImageView save_button;


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
        });

        //openSearchMenu();
    }

    private void openSearchMenu() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.search_fragment, new Search()) // or replace с теми же параметрами
                .addToBackStack(null) // если необходимо, чтоб по нажатию "назад" вы могли вернуться на предыдущий фрагмент. Вместо null можно задать свой ключ.
                .commit();
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

        previous = search_button;
    }
}