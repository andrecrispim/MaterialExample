package br.com.android.material.app;

import android.app.Application;

import org.androidannotations.annotations.EApplication;

import br.com.android.material.app.modules.AppModule;
import dagger.ObjectGraph;

/**
 * Aplicação
 *
 * @author andre.moreira
 */
@EApplication
public class DefaultApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(new AppModule(this));
    }

    /**
     * @return ObjectGraph para injeção de dependências
     */
    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}