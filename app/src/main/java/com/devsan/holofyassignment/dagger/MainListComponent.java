package com.devsan.holofyassignment.dagger;

import com.devsan.holofyassignment.data.MainListRepository;
import com.devsan.holofyassignment.ui.MainActivity;

import dagger.Component;

@Component(modules = { MainListModule.class })
public interface MainListComponent extends BaseComponent<MainActivity> {

    MainListRepository getMainListRepository();
}
