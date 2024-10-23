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

        init();

        binding.searchMenuButton.setOnClickListener(v -> {
                makePreviousUnactive();
                binding.searchMenuButton.setBackgroundResource(R.drawable.search_active);
                previous = binding.searchMenuButton;
                //openSearchMenu();
            Toast.makeText(this,"text",Toast.LENGTH_SHORT).show();
        });

        binding.saveMenuButton.setOnClickListener(v -> {
            makePreviousUnactive();
            binding.saveMenuButton.setBackgroundResource(R.drawable.save_active);
            previous = binding.saveMenuButton;
        });

        binding.arMenuButton.setOnClickListener(v -> {
            makePreviousUnactive();
            binding.arMenuButton.setBackgroundResource(R.drawable.ar_active);
            previous = binding.arMenuButton;
        });

        binding.settingsMenuButton.setOnClickListener(v -> {
            makePreviousUnactive();
            binding.settingsMenuButton.setBackgroundResource(R.drawable.settings_active);
            previous = binding.settingsMenuButton;
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
        if(previous == binding.searchMenuButton) binding.searchMenuButton.setBackgroundResource(R.drawable.search_unactive);
        else if(previous == binding.settingsMenuButton) binding.settingsMenuButton.setBackgroundResource(R.drawable.settings_unactive);
        else if(previous == binding.arMenuButton) binding.arMenuButton.setBackgroundResource(R.drawable.ar_unactive);
        else binding.saveMenuButton.setBackgroundResource(R.drawable.save_unactive);
    }

    private void init() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        previous = binding.searchMenuButton;
    }
}