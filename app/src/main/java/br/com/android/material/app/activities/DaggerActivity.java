package br.com.android.material.app.activities;

import android.support.v7.app.AppCompatActivity;

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
public abstract class DaggerActivity extends AppCompatActivity {

    @App
    protected DefaultApplication application;

    /**
     * Inicializa a injeção de dependência
     */
    @AfterInject
    protected void daggerInitialize() {
        ((DefaultApplication) getApplication()).component().inject(this);
    }
}