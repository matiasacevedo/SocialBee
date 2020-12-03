package project.socialbee.view.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import project.socialbee.view.model.GeneralData

const val GENERAL_DATA_COLLECTION_NAME = "generaldata"

class FirestoreService {
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    private val setting = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = setting
    }

    fun getGeneralData(callback: Callback<List<GeneralData>>) {
        firebaseFirestore.collection(GENERAL_DATA_COLLECTION_NAME)
            .orderBy("title")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    // obtengo una lista el resultado de firestore
                    val list = result.toObjects(GeneralData:: class.java) // tenemos toda la lista de las collection
                    callback.onSuccess(list)
                    break
                }
            }
    }
}