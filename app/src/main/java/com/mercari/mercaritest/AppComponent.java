package com.mercari.mercaritest;


import javax.inject.Singleton;

import dagger.Component;

// NOTE: components initialized with all modules specified.
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent {
    void inject(MercariApp app);
    void inject(MainActivity activity);

    final class Initializer {
        static AppComponent init(MercariApp app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .networkModule(new NetworkModule())
                    .build();
        }

        private Initializer() {}
    }
}
