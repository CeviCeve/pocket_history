package by.ph;

import static android.view.View.INVISIBLE;
import static by.ph.data.ArrayData.lastBuilding;
import static by.ph.data.ArrayData.quizData;
import static by.ph.data.ArrayData.userData;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import by.ph.data.QuizData;
import by.ph.databinding.FragmentQuizBinding;

public class Quiz extends Fragment {

    private FragmentQuizBinding binding;
    private int num = 0;
    private int whatAnswer = 0;
    private int tryQ = 0;
    public Quiz() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(getLayoutInflater());

        quizData.add(new QuizData(0,new String[]{"Радивилы","Сапеги","Тышкевичи"}));
        quizData.add(new QuizData(1,new String[]{"1484","1583","1551"}));
        quizData.add(new QuizData(2,new String[]{"Монастырь","Королевская резиденция","Военная крепость"}));
        quizData.add(new QuizData(0,new String[]{"Фестиваль оперы","Рыцарский турнир","Бал цветущих магнолий"}));
        quizData.add(new QuizData(0,new String[]{"Борис Годунов","Пан Тодеуш","Федор Романов"}));

        binding.placeName.setText(lastBuilding.getName());
        binding.next.setOnClickListener(v -> {

            if(whatAnswer != 0) {
                if(num <= 3) {
                    num++;

                    if(num == 1){binding.question.setBackgroundResource(R.drawable.q2);}
                    else if(num == 2){binding.question.setBackgroundResource(R.drawable.q3_ref);}
                    else if(num == 3){binding.question.setBackgroundResource(R.drawable.q4_ref);}
                    else if(num == 4){binding.question.setBackgroundResource(R.drawable.q5_ref);}

                    nextQ();
                } else {
                    binding.question.setBackgroundResource(R.drawable.results);

                    binding.text5.setText("Правильные ответы");
                    binding.text6.setText(tryQ + " из 5");
                    binding.text7.setText("Завершить");

                    binding.next.setVisibility(INVISIBLE);
                    userData.setQuizzes(1);
                    Toast.makeText(getContext(), "Завершено", Toast.LENGTH_SHORT).show();

                    binding.q1.setBackgroundTintList(getResources().getColorStateList(R.color.white, null));
                    binding.q2.setBackgroundTintList(getResources().getColorStateList(R.color.white, null));
                    binding.q3.setBackgroundTintList(getResources().getColorStateList(R.color.white, null));
                }
                whatAnswer = 0;
            } else {
                Toast.makeText(getContext(), "Сначала ответьте", Toast.LENGTH_SHORT).show();
            }
        });

        binding.q1.setOnClickListener(v->{
            if(whatAnswer == 0 && num <= 4) {
                tryOrFalse(0);
            }
            whatAnswer = 1;
        });
        binding.q2.setOnClickListener(v->{
            if(whatAnswer == 0 && num <= 4) {
                tryOrFalse(1);
            }
            whatAnswer = 1;
        });
        binding.q3.setOnClickListener(v->{
            if(whatAnswer == 0 && num <= 4) {
                tryOrFalse(2);
            }
            if (num == 81) {
                Search secondFragment = new Search(lastBuilding);
                FragmentTransaction transaction = requireFragmentManager().beginTransaction();
                transaction.replace(R.id.frag, secondFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            whatAnswer = 1;
        });

        return binding.getRoot();
    }

    private void tryOrFalse(int i) {
        if(i != quizData.get(num).getRight()) {
            if(quizData.get(num).getRight() == 0){
                binding.q2.setBackgroundTintList(getResources().getColorStateList(R.color.app_red, null));
                binding.q3.setBackgroundTintList(getResources().getColorStateList(R.color.app_red, null));
            }
            else if (quizData.get(num).getRight() == 1){
                binding.q1.setBackgroundTintList(getResources().getColorStateList(R.color.app_red, null));
                binding.q3.setBackgroundTintList(getResources().getColorStateList(R.color.app_red, null));
            }
            else if (quizData.get(num).getRight() == 2){
                binding.q2.setBackgroundTintList(getResources().getColorStateList(R.color.app_red, null));
                binding.q1.setBackgroundTintList(getResources().getColorStateList(R.color.app_red, null));
            }
        }

        if(i == 0 && i == quizData.get(num).getRight()){
            binding.q1.setBackgroundTintList(getResources().getColorStateList(R.color.app_green, null));
            tryQ++;
        }
        else if (i == 1 && i == quizData.get(num).getRight()){
            binding.q2.setBackgroundTintList(getResources().getColorStateList(R.color.app_green, null));
            tryQ++;
        }
        else if (i == 2 && i == quizData.get(num).getRight()){
            binding.q3.setBackgroundTintList(getResources().getColorStateList(R.color.app_green, null));
            tryQ++;
        }
        if(num == 4) num = 81;
    }
    private void nextQ() {
        binding.text5.setText(quizData.get(num).getOne()[0].toString());
        binding.text6.setText(quizData.get(num).getOne()[1].toString());
        binding.text7.setText(quizData.get(num).getOne()[2].toString());

        binding.question.setImageDrawable(quizData.get(num).getDrawable());

        binding.q1.setBackgroundTintList(getResources().getColorStateList(R.color.white, null));
        binding.q2.setBackgroundTintList(getResources().getColorStateList(R.color.white, null));
        binding.q3.setBackgroundTintList(getResources().getColorStateList(R.color.white, null));
    }
}