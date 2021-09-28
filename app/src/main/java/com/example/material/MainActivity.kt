package com.example.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.bottomNav?.setOnItemSelectedListener { item ->

            when(item.itemId){
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
                R.id.shopItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Shop()).commit()
                R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Delivery()).commit()
                R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Account()).commit()
            }

            return@setOnItemSelectedListener true

        }


    }
}