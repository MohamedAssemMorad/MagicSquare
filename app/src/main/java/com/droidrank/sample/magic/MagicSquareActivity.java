package com.droidrank.sample.magic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.droidrank.sample.R;
import com.droidrank.sample.magic.presenter.MagicSquarePresenter;
import com.droidrank.sample.magic.presenter.MagicSquarePresenterImpl;
import com.droidrank.sample.magic.view.MagicSquareView;

public class MagicSquareActivity extends AppCompatActivity implements MagicSquareView {

    private static final String MAGIC_KEY = "magic_key";
    private MagicSquarePresenter magicSquarePresenter;
    private TextView magicTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_square);

        magicTextView = (TextView) findViewById(R.id.textView_magic_matrix);


        magicSquarePresenter = new MagicSquarePresenterImpl(this);
        handleIntent();
    }

    private void handleIntent() {

        Intent intent = getIntent();
        if(intent.hasExtra(MAGIC_KEY)){
            int magicNumber = intent.getIntExtra(MAGIC_KEY, -1);
            magicSquarePresenter.loadMagicSquare(magicNumber);
        }else{
            // Do something else
        }
    }

    @Override
    public void loadMagicSquare(int[][] magicSquareMatrix) {

        int n = magicSquareMatrix.length;
        StringBuilder str = new StringBuilder();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                str.append(magicSquareMatrix[i][j]+"     ");
            str.append("\n");
        }

        magicTextView.setText(str);

    }
}
