package project.socialbee.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import project.socialbee.R

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}