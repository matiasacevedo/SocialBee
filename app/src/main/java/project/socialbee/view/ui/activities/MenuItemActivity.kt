package project.socialbee.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import project.socialbee.R
import project.socialbee.view.ui.fragments.MapFragment
import project.socialbee.view.ui.fragments.MessageSendDetailDialogFragment

class MenuItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)

        val code = intent.getStringExtra("code")
        val latitude = intent.getStringExtra("latitude")
        val longitude = intent.getStringExtra("longitude")
        val user = intent.getStringExtra("user")

        if (code == "map"){

            val bundle = bundleOf(
                "latitude" to latitude,
                "longitude" to longitude,
                "user" to user
            )

            val newFragment = MapFragment()
            newFragment.arguments = bundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.content, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else if(code == "message"){
            val newFragment = MessageSendDetailDialogFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.content, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}