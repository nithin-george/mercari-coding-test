package com.mercari.mercaritest;

import com.mercari.mercaritest.network.Network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public Network provideNetwork(){
        return new Network();
    }
}
