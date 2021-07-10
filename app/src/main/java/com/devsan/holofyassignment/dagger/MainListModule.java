package com.devsan.holofyassignment.dagger;

import androidx.lifecycle.ViewModelProviders;

import com.devsan.holofyassignment.data.ViewModelFactory;
import com.devsan.holofyassignment.models.MainListHomeViewModel;
import com.devsan.holofyassignment.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainListModule {

    private MainActivity mainActivity;

    public MainListModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    public MainListHomeViewModel provideMainListHomeViewModel(ViewModelFactory factory) {

        if (mainActivity != null) {

            return ViewModelProviders.of(mainActivity, factory).get(MainListHomeViewModel.class);
        }
        return null;
    }
}
