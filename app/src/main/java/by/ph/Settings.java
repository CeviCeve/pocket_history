package by.ph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import by.ph.databinding.FragmentSearchBinding;
import by.ph.databinding.FragmentSettingsBinding;

public class Settings extends Fragment {

    private FragmentSettingsBinding binding;

    public Settings() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }

    /*

    @Override
    public int getItemCount() {
        return Assortment.assortment.size();
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }

    static class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
     */

}