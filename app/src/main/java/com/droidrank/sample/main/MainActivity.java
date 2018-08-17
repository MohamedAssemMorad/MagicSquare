package com.droidrank.sample.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.droidrank.sample.R;
import com.droidrank.sample.magic.MagicSquareActivity;
import com.droidrank.sample.main.presenter.MainPresenter;
import com.droidrank.sample.main.presenter.MainPresenterImpl;
import com.droidrank.sample.main.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText inputEditText;
    private Button displayButton;
    private MainPresenter mainPresenter;
    private static final String MAGIC_KEY = "magic_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        mainPresenter = new MainPresenterImpl(this);
    }

    private void bindViews() {
        inputEditText = (EditText) findViewById(R.id.editText_input);
        displayButton = (Button) findViewById(R.id.button_display);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainPresenter.validateInput(Integer.parseInt(inputEditText.getText().toString()));

            }
        });
    }

    @Override
    public void showError() {
        Toast.makeText(MainActivity.this, "Enter number greater than or equal 3", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMagicSquare() {
        Intent intent = new Intent(MainActivity.this , MagicSquareActivity.class);
        intent.putExtra(MAGIC_KEY, Integer.parseInt(inputEditText.getText().toString()));
        startActivity(intent);
    }
}
