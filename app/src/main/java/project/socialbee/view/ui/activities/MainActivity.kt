package project.socialbee.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray
import org.json.JSONObject
import project.socialbee.R
import project.socialbee.view.model.GeneralData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val json = JSONArray("[\n" +
                "            {\n" +
                "                'title': 'TED Talks Daily',\n" +
                "                \"photo\": '',\n" +
                "                \"latitude\": '',\n" +
                "                \"longitude\": \"\",\n" +
                "                \"description\": \"\",\n" +
                "                \"user\": \"Elber Galarza\"\n" +
                "            },\n" +
                "\n" +
                "            {\n" +
                "                \"title\": \"BBC Earth Podcast\",\n" +
                "                \"photo\": \"\",\n" +
                "                \"latitude\": \"\",\n" +
                "                \"longitude\": \"\",\n" +
                "                \"description\": \"\",\n" +
                "                \"user\": \"Monica Galindo\"\n" +
                "            }\n" +
                "        ]")

        val db = FirebaseFirestore.getInstance()

        for (i in 0 until json.length()){
            val aux = json.get(i) as JSONObject
            val data = GeneralData()

            data.title = aux.getString("title")
            data.photo = aux.getString("photo")
            data.latitude = aux.getString("latitude")
            data.longitude = aux.getString("longitude")
            data.description = aux.getString("description")
            data.user = aux.getString("user")

            db.collection("GeneralData").document().set(data)

        }*/

    }
}