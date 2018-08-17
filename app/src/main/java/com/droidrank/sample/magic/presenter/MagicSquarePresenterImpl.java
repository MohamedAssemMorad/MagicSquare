package com.droidrank.sample.magic.presenter;


import com.droidrank.sample.magic.model.MagicSquareModel;
import com.droidrank.sample.magic.view.MagicSquareView;

public class MagicSquarePresenterImpl implements MagicSquarePresenter {

    private MagicSquareView magicSquareView;

    public MagicSquarePresenterImpl(MagicSquareView magicSquareView) {
        this.magicSquareView = magicSquareView;
    }

    @Override
    public void loadMagicSquare(int squareSize) {
        MagicSquareModel magicSquareModel = new MagicSquareModel();
        magicSquareView.loadMagicSquare(magicSquareModel.generateSquare(squareSize));
    }
}
