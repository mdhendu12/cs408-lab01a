package com.example.cs408lab1a__rock_paper_scissors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        binding.scoreTV.setText(rpc.getScoresAsString());
        binding.pWeaponTV.setText(rpc.getPWeaponAsString());
        binding.cWeaponTV.setText(rpc.getCWeaponAsString());
        binding.resultsTV.setText(rpc.getResultsAsString());
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