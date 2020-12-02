package project.socialbee.view.adapter

import project.socialbee.view.model.GeneralData

interface GeneralDataListener {
    fun onGeneralDataClicked(data : GeneralData, position : Int)
}