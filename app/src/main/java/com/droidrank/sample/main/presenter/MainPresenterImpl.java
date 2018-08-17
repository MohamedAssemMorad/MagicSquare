package com.droidrank.sample.main.presenter;

import com.droidrank.sample.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void validateInput(int i) {
        if(i < 3){
            mainView.showError();
        }else {
            mainView.showMagicSquare();
        }
    }
}
