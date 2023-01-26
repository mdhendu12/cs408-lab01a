package com.example.cs408lab1a__rock_paper_scissors;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs408lab1a__rock_paper_scissors.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    RockPaperScissors rpc;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rpc = new RockPaperScissors();
    }

    private void updateTextViews(View view) {
        binding.scoreTV.setText(rpc.getScores());
        binding.pWeaponTV.setText(rpc.getPWeapon());
        binding.cWeaponTV.setText(rpc.getCWeapon());
        binding.resultsTV.setText(rpc.getResults());
    }

    public void onClick(View view) {
        String tag = view.getTag().toString();

        if (tag.equals("resetButton")) {
            rpc.reset();
            updateTextViews(view);
        }
        else {
            rpc.evaluateMatch(tag);
            updateTextViews(view);
        }
    }
    
}