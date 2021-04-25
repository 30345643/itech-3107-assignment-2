package com.example.FedUniMillionaire30345643;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.FedUniMillionaire30345643.Fragments.QuestionFragment;
import com.example.FedUniMillionaire30345643.Models.Option;
import com.example.FedUniMillionaire30345643.Models.Question;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public ArrayList<Question> questions = new ArrayList<Question>();
    public int savings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Question question1 = new Question();
        question1.setQ("Who was the first president of America?");
        ArrayList<Option> question1Options = new ArrayList<Option>();
        question1Options.add(new Option("A", "George Washington"));
        question1Options.add(new Option("B", "Barack Obama"));
        question1Options.add(new Option("C", "Thomas Jefferson"));
        question1Options.add(new Option("D", "Gorge Bush"));
        question1.setOptions(question1Options);
        questions.add(question1);

        Question question2 = new Question();
        question2.setQ("Which is the fastest sport bike in the world?");
        ArrayList<Option> question2Options = new ArrayList<Option>();
        question2Options.add(new Option("A", "Ducati V4R"));
        question2Options.add(new Option("B", "Honda R1000"));
        question2Options.add(new Option("C", "Kawasaki Ninja"));
        question2Options.add(new Option("B", "Kawasaki Ninja H2R"));
        question2.setOptions(question2Options);
        questions.add(question2);

        Question question3 = new Question();
        question3.setQ("Is mango a fruit?");
        ArrayList<Option> question3Options = new ArrayList<Option>();
        question3Options.add(new Option("A", "Yes"));
        question3Options.add(new Option("B", "No"));
        question3Options.add(new Option("C", "All of the Above"));
        question3Options.add(new Option("D", "None of the above"));
        question3.setOptions(question3Options);
        questions.add(question3);

        Question question4 = new Question();
        question4.setQ("Should under age children take alcohol?");
        ArrayList<Option> question4Options = new ArrayList<Option>();
        question4Options.add(new Option("A", "Yes"));
        question4Options.add(new Option("B", "No"));
        question4Options.add(new Option("C", "A little"));
        question4Options.add(new Option("D", "They can take"));
        question4.setOptions(question4Options);
        questions.add(question4);

        Question question5 = new Question();
        question5.setQ("Who was the first man to break two-hour barrier in marathon?");
        ArrayList<Option> question5Options = new ArrayList<Option>();
        question5Options.add(new Option("A", "Usain Bolt"));
        question5Options.add(new Option("B", "Eliud Kipchonge"));
        question5Options.add(new Option("C", "Mo Farah"));
        question5Options.add(new Option("D", "Kipchonge Keino"));
        question5.setOptions(question5Options);
        questions.add(question5);

        Question question6 = new Question();
        question6.setQ("Which is the capital city of China?");
        ArrayList<Option> question6Options = new ArrayList<Option>();
        question6Options.add(new Option("A", "Nairobi"));
        question6Options.add(new Option("C", "Denver"));
        question6Options.add(new Option("B", "Beijing"));
        question6Options.add(new Option("D", "Rio"));
        question6.setOptions(question6Options);
        questions.add(question6);

        Question question7 = new Question();
        question7.setQ("Which is the largest continent?");
        ArrayList<Option> question7Options = new ArrayList<Option>();
        question7Options.add(new Option("A", "North America"));
        question7Options.add(new Option("B", "Europe"));
        question7Options.add(new Option("C", "Asia"));
        question7Options.add(new Option("D", "Australia"));
        question7.setOptions(question7Options);
        questions.add(question7);

        Question question8 = new Question();
        question8.setQ("Which is the tallest mountain in the world?");
        ArrayList<Option> question8Options = new ArrayList<Option>();
        question8Options.add(new Option("A", "Kilimanjaro"));
        question8Options.add(new Option("B", "Everest"));
        question8Options.add(new Option("C", "Ben Nevis"));
        question8Options.add(new Option("D", "Ben Macdui"));
        question8.setOptions(question8Options);
        questions.add(question8);

        Question question9 = new Question();
        question9.setQ("who was the first man to go the moon?");
        ArrayList<Option> question9Options = new ArrayList<Option>();
        question9Options.add(new Option("A", "Neil Armstrong"));
        question9Options.add(new Option("B", "Elon Musk"));
        question9Options.add(new Option("C", "Mr. Simmons"));
        question9Options.add(new Option("D", "Mr. Robertson"));
        question9.setOptions(question9Options);
        questions.add(question9);

        Question question10 = new Question();
        question10.setQ("Who started Amazon eccommerce platform?");
        ArrayList<Option> question10Options = new ArrayList<Option>();
        question10Options.add(new Option("A", "Jeff Bezos"));
        question10Options.add(new Option("B", "Bill Gates"));
        question10Options.add(new Option("C", "Larry Page"));
        question10Options.add(new Option("D", "Carlos Slim"));
        question10.setOptions(question10Options);
        questions.add(question10);

        Question question11 = new Question();
        question11.setQ("Who started Alibaba.com");
        ArrayList<Option> question11Options = new ArrayList<Option>();
        question11Options.add(new Option("A", "Donald Trump"));
        question11Options.add(new Option("B", "Isabel dos Santos"));
        question11Options.add(new Option("C", "Amancio Ortega"));
        question11Options.add(new Option("D", "Jack Ma"));
        question11.setOptions(question11Options);
        questions.add(question11);

        //setting the default fragment to be home
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.question_fragment, new QuestionFragment(questions, savings))
                .commit();


    }
}