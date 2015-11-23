package br.com.android.material.app;

import android.app.Application;

import org.androidannotations.annotations.EApplication;

import javax.inject.Singleton;

import br.com.android.material.app.activities.DaggerActivity;
import br.com.android.material.app.modules.AppModule;
import dagger.Component;

/**
 * Aplicação
 *
 * @author andre.moreira
 */
@EApplication
public class DefaultApplication extends Application {

    private ApplicationComponent component;

    @Singleton
    @Component(modules = AppModule.class)
    public interface ApplicationComponent {
        void inject(DefaultApplication application);
        void inject(DaggerActivity daggerActivity);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerDefaultApplication_ApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component().inject(this); // As of now, LocationManager should be injected into this.
    }

    public ApplicationComponent component() {
        return component;
    }
}