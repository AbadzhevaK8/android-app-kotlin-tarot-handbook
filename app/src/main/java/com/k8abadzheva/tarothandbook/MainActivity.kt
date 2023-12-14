package com.k8abadzheva.tarothandbook

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.k8abadzheva.tarothandbook.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val currentMode = sharedPreferences.getInt("ThemeMode", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        AppCompatDelegate.setDefaultNightMode(currentMode)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()

        navController?.let { bottomNavigationView.setupWithNavController(it) }
        if (navController != null) {
            appBarConfiguration = AppBarConfiguration(navController.graph)
        }
        navController?.let { binding.toolbar.setupWithNavController(it, appBarConfiguration) }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.HandbookFragment -> {
                    navController?.navigate(R.id.HandbookFragment)
                    true
                }
                R.id.TellFortunesFragment -> {
                    navController?.navigate(R.id.TellFortunesFragment)
                    true
                }
                else -> false
            }
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()

        return when (item.itemId) {
            R.id.SettingsFragment -> {
                navController?.navigate(R.id.SettingsFragment)
                true
            }

            R.id.AboutFragment -> {
                navController?.navigate(R.id.AboutFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()

        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("ThemeMode", AppCompatDelegate.getDefaultNightMode())
        editor.apply()
    }
}
