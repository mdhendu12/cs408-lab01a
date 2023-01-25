package com.example.cs408lab1a__rock_paper_scissors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = view.getRootView().findViewById(R.id.rockButton);

                rpc.evaluateMatch((String) b.getText());
                updateTextViews(view);
            }
        });

        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = view.getRootView().findViewById(R.id.paperButton);

                rpc.evaluateMatch((String) b.getText());
                updateTextViews(view);
            }
        });

        binding.scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = view.getRootView().findViewById(R.id.scissorsButton);

                rpc.evaluateMatch((String) b.getText());
                updateTextViews(view);
            }
        });

        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rpc.reset();
                updateTextViews(view);
            }
        });
    }

    private void updateTextViews(View view) {
        TextView scoreTV = view.getRootView().findViewById(R.id.scoreTV);
        TextView pWeaponTV = view.getRootView().findViewById(R.id.pWeaponTV);
        TextView cWeaponTV = view.getRootView().findViewById(R.id.cWeaponTV);
        TextView resultsTV = view.getRootView().findViewById(R.id.resultsTV);

        scoreTV.setText(rpc.getScoresAsString());
        pWeaponTV.setText(rpc.getPWeaponAsString());
        cWeaponTV.setText(rpc.getCWeaponAsString());
        resultsTV.setText(rpc.getResultsAsString());

    }
    
}