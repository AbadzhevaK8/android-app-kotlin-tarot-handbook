package com.k8abadzheva.tarothandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
//                R.id.OptionFragment -> {
//                    navController?.navigate(R.id.OptionFragment)
//                    true
//                }
                else -> false
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                //Log.d("ASAP", "action_settings IS CLICKED!!!")
                // Добавьте код для обработки выбора Item 1
                return true
            }
            R.id.action_about -> {
                //Log.d("ASAP", "action_about IS CLICKED!!!")
                // Добавьте код для обработки выбора Item 2
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        //Log.d("ASAP", "onSupportNavigateUp IS CLICKED!!!")
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}