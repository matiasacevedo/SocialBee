package project.socialbee.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import project.socialbee.R
import project.socialbee.view.ui.fragments.MessageSendDetailDialogFragment

class MenuItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)

        val code = intent.getStringExtra("code")
        val latitude = intent.getStringExtra("latitude")
        val longitude = intent.getStringExtra("longitude")
        val user = intent.getStringExtra("user")
/*
        if (cod=="map"){

            val bundle = bundleOf(
                "latitud" to latitud,
                "longitud" to longitud,
                "user" to user
            )
            /*CREAMOS EL FRAGMENTO*/
            val newFragment = MapFragment()
            /*LE PASAMOS EN BUNDLE AL FRAGMENTO*/
            newFragment.arguments = bundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.contenedor, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else if(cod=="share"){
            val newFragment = ShareFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.contenedor, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else*/ if(code == "message"){
            val newFragment = MessageSendDetailDialogFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.content, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}