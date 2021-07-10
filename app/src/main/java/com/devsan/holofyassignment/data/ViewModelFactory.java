package com.devsan.holofyassignment.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.devsan.holofyassignment.models.MainListHomeViewModel;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {

    MainListRepository listRepository;

    @Inject
    public ViewModelFactory(MainListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == MainListHomeViewModel.class) {
            return (T) new MainListHomeViewModel(listRepository);
        } else {
            return null;
        }
    }
}

