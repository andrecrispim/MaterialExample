package br.com.android.material.app.activities;

import android.app.Activity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;

import br.com.android.material.app.DefaultApplication;

/**
 * Executa a injeção de dependências ao ser criada
 *
 * @author andre.moreira
 */
@EActivity
public abstract class DaggerActivity extends Activity {

    @App
    protected DefaultApplication application;

    /**
     * Inicializa a injeção de dependência
     */
    @AfterInject
    protected void daggerInitialize() {
        application.getObjectGraph().inject(this);
    }
}