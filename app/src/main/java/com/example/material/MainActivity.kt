package com.example.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding?.topAppBar)

        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.bottomNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
                R.id.shopItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Shop()).commit()
                R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Delivery()).commit()
                R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Account()).commit()
            }

            return@setOnItemSelectedListener true

        }


        binding?.topAppBar?.setOnMenuItemClickListener { menuItem: MenuItem ->

            when (menuItem.itemId) {
                R.id.favoritesTopItemId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Favorites()).commit()
                    true
                }

                R.id.settingsTopItemId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Settings()).commit()
                    true
                }

                R.id.cloudTopItemId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Cloud()).commit()
                    true
                }

                else -> false
            }

        }

        // Тапаем по итемам Драйвера
        binding?.apply {
            nv.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item1 -> Toast.makeText(this@MainActivity, "Item 1", Toast.LENGTH_SHORT)
                        .show()
                    R.id.item2 -> Toast.makeText(this@MainActivity, "Item 2", Toast.LENGTH_SHORT)
                        .show()
                }
                // При нажатии на итем менюшки - дополнительно заезжает обратно Вивигатион вью
                drawer.closeDrawer(GravityCompat.START)
                true
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.top_menu, menu)

        return true

    }
}