package com.example.wikipediasample.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipediasample.R
import com.example.wikipediasample.databinding.ActivityMainBinding
import com.example.wikipediasample.fragments.ExploreFragment
import com.example.wikipediasample.fragments.ProfileFragment
import com.example.wikipediasample.fragments.TrendFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


///====================================================================================================================================


        // To disable material dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        // To getting my toolbar as an action bar
        setSupportActionBar(binding.mainToolBar)


        // Creating navigation drawer
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.mainDrawerLayout,
            binding.mainToolBar,
            R.string.openDrawer,
            R.string.closeDrawer
        )

        // To add triple line menu toggle
        binding.mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle
            .drawerArrowDrawable.color = ContextCompat.getColor(this, R.color.white)
        actionBarDrawerToggle.syncState()


        binding.mainNavigationView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)

                    dialog.titleText = "Attention"

                    dialog.contentText = "Would you like to read about writing in Wikipedia ?"

                    dialog.confirmText = "YES"

                    dialog.cancelText = "NO"

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                    }

                    dialog.setConfirmClickListener {

                        openWebsite("https://en.wikipedia.org/wiki/Writer")
                        dialog.dismiss()
                    }

                    dialog.show()

                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.menu_photograph -> {

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)

                    dialog.titleText = "Attention"

                    dialog.contentText = "Would you like to read about photographing in Wikipedia ?"

                    dialog.confirmText = "YES"

                    dialog.cancelText = "NO"

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                    }

                    dialog.setConfirmClickListener {

                        openWebsite("https://en.wikipedia.org/wiki/Photographer")
                        dialog.dismiss()
                    }

                    dialog.show()

                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.menu_videoProducer -> {

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)

                    dialog.titleText = "Attention"

                    dialog.contentText =
                        "Would you like to read about film producing in Wikipedia ?"

                    dialog.confirmText = "YES"

                    dialog.cancelText = "NO"

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                    }

                    dialog.setConfirmClickListener {

                        openWebsite("https://en.wikipedia.org/wiki/Film_producer")
                        dialog.dismiss()
                    }

                    dialog.show()

                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.menu_translator -> {

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)

                    dialog.titleText = "Attention"

                    dialog.contentText = "Would you like to read about translation in Wikipedia ?"

                    dialog.confirmText = "YES"

                    dialog.cancelText = "NO"

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                    }

                    dialog.setConfirmClickListener {

                        openWebsite("https://en.wikipedia.org/wiki/Translation")
                        dialog.dismiss()
                    }

                    dialog.show()

                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.menu_open_wikipedia -> {

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)

                    dialog.titleText = "Would you like to visit Wikipedia ?"

                    dialog.confirmText = "YES"

                    dialog.cancelText = "NO"

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                    }

                    dialog.setConfirmClickListener {

                        openWebsite("https://www.wikipedia.org/")
                        dialog.dismiss()
                    }

                    dialog.show()

                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.menu_open_wikimedia -> {

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)

                    dialog.titleText = "Would you like to visit Wikimedia ?"

                    dialog.confirmText = "YES"

                    dialog.cancelText = "NO"

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                    }

                    dialog.setConfirmClickListener {

                        openWebsite("https://www.wikimedia.org/")

                    }

                    dialog.show()

                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                }
            }

            true
        }


        // To be checked fragment explore automatically
        firstRun()

        binding.mainBottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_btmnvg_explore -> {

                    replaceFragment(ExploreFragment())
                }

                R.id.menu_btmnvg_trend -> {

                    replaceFragment(TrendFragment())
                }

                R.id.menu_btmnvg_profile -> {

                    replaceFragment(ProfileFragment())
                }

            }

            true
        }


        //To prevent creating fragment with duplicate clicks
        binding.mainBottomNavigation.setOnItemReselectedListener {

        }

    }

    private fun replaceFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .replace(R.id.frameMainContainer, fragment)
            .commit()
    }

    private fun firstRun() {

        replaceFragment(ExploreFragment())
        binding.mainBottomNavigation.selectedItemId = R.id.menu_btmnvg_explore
    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}




