package project.socialbee.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import project.socialbee.R
import project.socialbee.view.adapter.GeneralDataListener
import project.socialbee.view.model.GeneralData
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment(), GeneralDataListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onSpeakerClicked(data: GeneralData, position: Int) {
        val bundle = bundleOf("data" to data)
        findNavController().navigate(R.id.SpeakerDetailDialogFragment, bundle)
    }
}