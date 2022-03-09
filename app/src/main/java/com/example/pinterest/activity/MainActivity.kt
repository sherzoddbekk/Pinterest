package com.example.pinterest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pinterest.R
import com.example.pinterest.fragement.Fragment_four
import com.example.pinterest.fragement.Fragment_one
import com.example.pinterest.fragement.Fragment_three
import com.example.pinterest.fragement.Fragment_two
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomnavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun initView(){
        bottomnavigation = findViewById(R.id.bottom_navigation)
        replaceFragment(Fragment_one())
        bottomnavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.search -> replaceFragment(Fragment_two())
                R.id.message -> replaceFragment(Fragment_three())
                R.id.person -> replaceFragment(Fragment_four())
                R.id.home -> replaceFragment(Fragment_one())
            }
            true
        }
    }
    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame,fragment)
            commit()
        }
    }
}