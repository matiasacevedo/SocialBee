package project.socialbee.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.socialbee.view.model.GeneralData
import project.socialbee.view.network.Callback
import project.socialbee.view.network.FirestoreService

class GeneralDataViewModel : ViewModel() {
    // esto se a encargar de comunicar con lo que hicimos con la UI con Firestore
    //creamos una instancia de Firebase que ya la tenemos creado

    private val firestoreService = FirestoreService()
    var listGeneralData: MutableLiveData<List<GeneralData>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakerFromFirebase()
    }

    private fun  getSpeakerFromFirebase(){
        firestoreService.getGeneralData(object : Callback<List<GeneralData>> {
            override fun onSuccess(result: List<GeneralData>?) {
                listGeneralData.postValue(result)
                isLoading.value = true     //process finish
            }

            override fun onFailed(exception: Exception) {
                isLoading.value = true     //process finish
            }
        })
    }
}