package com.pandasoft.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.pandasoft.R;
import com.pandasoft.fragment.ClienteFragment;
import com.pandasoft.fragment.PrincipalFragment;
import com.pandasoft.fragment.ServicosFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Carrega a tela principal
        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        fragment.replace(R.id.frameContainer, principalFragment);
        fragment.commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {
            PrincipalFragment principalFragment = new PrincipalFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer, principalFragment);
            fragment.commit();

        } else if (id == R.id.nav_servicos) {

            ServicosFragment servicosFragment = new ServicosFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer, servicosFragment);
            fragment.commit();

        } else if (id == R.id.nav_clientes) {

            ClienteFragment clienteFragment = new ClienteFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer, clienteFragment);
            fragment.commit();

        } else if (id == R.id.nav_contato) {
            enviarEmail();

        } else if (id == R.id.nav_sobre) {

            startActivity(new Intent(this, SobreActivity.class));

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void enviarEmail(){
        Intent email = new Intent (Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"marianobloggers@gmail.com","tiagomarianopc@outlook.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        email.putExtra(Intent.EXTRA_TEXT, "Menssagem automatica");

        //configurar apps apenas para email
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email,"escolha o app de e-mail : "));
    }
}
