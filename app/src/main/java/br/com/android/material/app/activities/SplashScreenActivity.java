package br.com.android.material.app.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import br.com.android.material.R;

/**
 * Tela inicial da aplicação
 *
 * @author andre.moreira
 */
@EActivity(R.layout.activity_splash_screen)
public class SplashScreenActivity extends DaggerActivity {

    /**
     * 
     * Inicializa
     *
     * Seria utilizado para buscar dados que devem estar disponíveis ao iniciar a
     * aplicação.
     */
    @AfterViews
    @Background(delay = 2000)
    protected void initialize() {
        // Atenção: o delay é apenas par exemplifcar, se não tem nada para busca deveria ir direto
        // para a Home
        HomeActivity_.intent(this).start();
    }
}