package br.com.android.material.app.modules;

import android.support.annotation.NonNull;

import br.com.android.material.app.DefaultApplication;
import br.com.android.material.core.modules.CoreModule;
import dagger.Module;

/**
 * Disponibiliza as classes da aplicação
 *
 * @author andre.moreira
 */
@Module(injects = {DefaultApplication.class}, includes = {CoreModule.class})
public class AppModule {

    @NonNull
    private final android.app.Application application;

    /**
     * Construtor
     *
     * @param app Application
     */
    public AppModule(@NonNull android.app.Application app) {
        this.application = app;
    }

    /**
     * @return Contexto da aplicação
     */
    /*@Provides
    @Singleton
    @Application
    @NonNull
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }*/
}