package com.example.dungeonans.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.dungeonans.PageAdapter.ViewPagerAdapter
import com.example.dungeonans.R
import com.example.dungeonans.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startbinding()
        connectToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_Community -> {
                // ViewPager의 현재 item에 첫 번째 화면을 대입
                binding.pager.currentItem = 0
                return true
            }
            R.id.nav_Ask -> {
                // ViewPager의 현재 item에 두 번째 화면을 대입
                binding.pager.currentItem = 1
                return true
            }
            R.id.nav_Blog -> {
                // ViewPager의 현재 item에 세 번째 화면을 대입
                binding.pager.currentItem = 2
                return true
            }
            R.id.nav_MyProfile -> {
                binding.pager.currentItem = 3
                return true
            }
            // 나머지 => 반환 안됨.
            else -> {
                return false
            }
        }
    }


    fun startbinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 페이저에 어댑터 연결
        binding.pager.adapter = ViewPagerAdapter(this)

        // 슬라이드하여 페이지가 변경되면 바텀네비게이션의 탭도 그 페이지로 활성화
        binding.pager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationView.menu.getItem(position).isChecked = true
                }
            }
        )
        // 리스너 연결
        binding.bottomNavigationView.setOnItemSelectedListener(this)
    }
    fun connectToolbar() {
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        var actionBar = supportActionBar
        actionBar!!.setDisplayShowCustomEnabled(true)
        actionBar!!.setDisplayShowTitleEnabled(false)
        actionBar!!.setDisplayHomeAsUpEnabled(false)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}