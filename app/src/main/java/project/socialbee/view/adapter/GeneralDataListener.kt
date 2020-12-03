package project.socialbee.view.adapter

import project.socialbee.view.model.GeneralData

interface GeneralDataListener {
    fun onSpeakerClicked(data : GeneralData, position : Int)
}