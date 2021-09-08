package com.smality.navigationrailview_materialdesign

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.smality.navigationrailview_materialdesign.databinding.ActivityMainBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.floatingactionbutton.FloatingActionButton
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        //Alarm item'a badge ekleme
        val badgeDrawable = activityMainBinding.navigationRail?.getOrCreateBadge(R.id.alarms)
        badgeDrawable?.run {
            //Badge özellikleri
            number = 999
            badgeTextColor = ContextCompat.getColor(applicationContext, android.R.color.white)
            maxCharacterCount = 2
            badgeGravity = BadgeDrawable.BOTTOM_END
            isVisible = true
        }

        //İlgili Badge'i silme
        // activityMainBinding.navigationRail?.removeBadge(R.id.alarms)

       //Floating Action Button'a tıklanma eventi
        activityMainBinding.navigationRail?.headerView?.findViewById<FloatingActionButton>(R.id.fab_add)
                ?.setOnClickListener {
                    Toast.makeText(this, "Fab Clicked", Toast.LENGTH_SHORT).show()
                }
        //NavigationRailView menu item'lara tıklanma eventi
        activityMainBinding.navigationRail?.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.alarms -> {
                    Toast.makeText(this, "Alarms Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    Toast.makeText(this, "Other item clicked", Toast.LENGTH_SHORT).show()
                    true
                }
            }
        }
    }
}
