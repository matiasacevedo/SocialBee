package project.socialbee.view .ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONArray
import org.json.JSONObject
import project.socialbee.R
import project.socialbee.view.model.GeneralData


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //Analytics Events
        val analytics : FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion con Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        // Setup
        setup()
    }

    private fun setup(){
        title = "Autenticación"

        btnRegister.setOnClickListener() {
            if (username.text?.isNotEmpty() != false && password.text?.isNotEmpty() != false){
                FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(username.text.toString(), password.text.toString())
                            .addOnCompleteListener {
                                if (it.isSuccessful){
                                    showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                                }
                                else {
                                    showAlert()
                                }
                            }
            }
        }

        btnLogin.setOnClickListener() {
            if (username.text!!.isNotEmpty() && password.text!!.isNotEmpty() ){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(username.text.toString(), password.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        }
                        else {
                            showAlert()
                        }
                    }
            }
        }
    }

    private fun showAlert (){
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog : android.app.AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome (email: String, provider: ProviderType){
        val homeIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}