package br.com.android.material.app.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import br.com.android.material.R;
import br.com.android.material.app.fragments.HomeFragment_;
import br.com.android.material.app.fragments.SecondFragment_;
import br.com.android.material.app.fragments.ThirdFragment_;

/**
 * Tela principal da aplicação
 *
 * @author andre.moreira
 */
@EActivity(R.layout.activity_home)
public class HomeActivity extends DaggerActivity implements NavigationView.OnNavigationItemSelectedListener {

    @ViewById(R.id.home_toolbar)
    protected Toolbar toolbar;

    @ViewById(R.id.home_collapsingToolbar)
    protected CollapsingToolbarLayout collapsingToolbar;

    @ViewById(R.id.home_layout)
    protected DrawerLayout drawer;

    @ViewById(R.id.home_navigationView)
    protected NavigationView navigationView;

    private ActionBarDrawerToggle drawerToggle;

    @AfterViews
    protected void initialize() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawer.setDrawerListener(drawerToggle);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (savedInstanceState == null) {
            onNavigationItemSelected(null);
        }

        drawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        MenuItem currentItem = item;

        if (item == null) {
            fragment = HomeFragment_.builder().build();
            currentItem = navigationView.getMenu().getItem(0);
        } else {
            switch (item.getItemId()) {
                case R.id.navigationMenu_home:
                    fragment = HomeFragment_.builder().build();
                    break;
                case R.id.navigationMenu_configuration:
                    fragment = SecondFragment_.builder().build();
                    break;
                case R.id.navigationMenu_help:
                    fragment = ThirdFragment_.builder().build();
                    break;
            }
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.home_content, fragment);
            transaction.commit();

            if (collapsingToolbar != null) {
                collapsingToolbar.setTitle(currentItem.getTitle());
            }

            drawer.closeDrawers();
            currentItem.setChecked(true);

            return true;
        }

        return false;
    }
}