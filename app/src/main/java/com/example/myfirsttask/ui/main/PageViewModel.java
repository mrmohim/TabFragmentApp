package com.example.myfirsttask.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    public int mm;

    public MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    public LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            if(input == 1){
                return "APPLE";
            }
            else if (input == 2){
                return "ORANGE";
            }
            else if(input == 3){
                return "MANGO";
            }
            else{
                return "LEMON";
            }
        }
    });

    public LiveData<Integer> mImage = Transformations.map(mIndex, new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer input) {
            if(input == 1){
                return 1;
            }
            else if (input == 2){
                return 2;
            }
            else if(input == 3){
                return 3;
            }
            else{
                return 4;
            }
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Integer> getImage() {
        return mImage;
    }
}