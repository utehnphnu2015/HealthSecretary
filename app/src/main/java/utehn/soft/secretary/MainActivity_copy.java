package utehn.soft.secretary;

import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity_copy extends AppCompatActivity implements
        DefaultTabFragment.OnFragmentInteractionListener
        , NewsTabFragment.OnFragmentInteractionListener {


    private List<Person> initPerson() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert Albahan", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#FAB483")));
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher, Color.parseColor("#68FA93")));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#7AD3FA")));
        persons.add(new Person("Robert Albahan", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#FAB483")));
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher, Color.parseColor("#68FA93")));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#7AD3FA")));
        persons.add(new Person("Robert Albahan", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#FAB483")));
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher, Color.parseColor("#68FA93")));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#7AD3FA")));
        persons.add(new Person("Robert Albahan", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#FAB483")));
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher, Color.parseColor("#68FA93")));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher, Color.parseColor("#7AD3FA")));

        return persons;

    }

    CoordinatorLayout rootLayout;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    MyRecyclerAdapter adapter;
    CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("โรงพยาบาลวัดโบสถ์");


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity_copy.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);


        List<Person> persons = initPerson();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lm);
        //recyclerView.setHasFixedSize(true);
        adapter = new MyRecyclerAdapter(persons);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        NavigationView navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navItem1:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        navigate(menuItem.getItemId());
                        break;
                    case R.id.navItem2:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        navigate(menuItem.getItemId());
                        break;
                    case R.id.navItem3:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        navigate(menuItem.getItemId());
                        break;
                }
                return false;
            }
        });


    }

    private void navigate(final int itemId) {

        Snackbar.make(rootLayout, "Hello." + String.valueOf(itemId), Snackbar.LENGTH_LONG)
                .setAction("ยกเลิก", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item))
            return true;
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
