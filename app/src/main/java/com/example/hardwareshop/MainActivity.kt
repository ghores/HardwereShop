package com.example.hardwareshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.elecomco.mymvvmshop.utils.setupWithNavController
import com.example.hardwareshop.data.ResponseCount
import com.example.hardwareshop.databinding.ActivityMainBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.color.MaterialColors
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    private var currentNavController: LiveData<NavController>? = null
    //Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        EventBus.getDefault().register(this)
        if (savedInstanceState == null) {
            setupNavigationBar()
        }
    }

    private fun setupNavigationBar() {
        val bottomNavigationView = binding.bottomNav
        val navGraphIds = listOf(
            R.navigation.home,
            R.navigation.category,
            R.navigation.cart,
            R.navigation.profile
        )
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )
        currentNavController = controller
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupNavigationBar()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun countItemCart(countItemCart: ResponseCount) {
        val badge = binding.bottomNav.getOrCreateBadge(R.id.cart)
        badge.backgroundColor = MaterialColors.getColor(binding.bottomNav, org.koin.android.R.attr.colorPrimary)
        badge.badgeGravity = BadgeDrawable.BOTTOM_START
        badge.number = countItemCart.count.toInt()
        badge.isVisible = countItemCart.count > 0
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}