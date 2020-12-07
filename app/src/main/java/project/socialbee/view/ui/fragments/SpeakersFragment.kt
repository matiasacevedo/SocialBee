package project.socialbee.view.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import project.socialbee.R
import project.socialbee.view.adapter.GeneralDataAdapter
import project.socialbee.view.model.GeneralData
import project.socialbee.view.viewmodel.GeneralDataViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_speakers.*
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import project.socialbee.view.adapter.GeneralDataListener


class SpeakersFragment : Fragment(), GeneralDataListener {

    private lateinit var generalDataAdapter: GeneralDataAdapter
    private lateinit var viewModel: GeneralDataViewModel

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
        return inflater.inflate(R.layout.fragment_speakers, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(GeneralDataViewModel::class.java)
        viewModel.refresh()
        generalDataAdapter = GeneralDataAdapter(this)
        rvSpeakers.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = generalDataAdapter
        }

        observerViewModel()

    }

    private fun  observerViewModel() {
        viewModel.listGeneralData.observe(viewLifecycleOwner,
            Observer<List<GeneralData>>{ data ->
                data.let {
                    generalDataAdapter.updateData((data))
                }
            })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if(it != null)
                rlBase.visibility = View.INVISIBLE
        })

    }

    override fun onSpeakerClicked(data: GeneralData, position: Int) {
        val bundle = bundleOf("data" to data)
        findNavController().navigate(R.id.SpeakerDetailDialogFragment, bundle)
    }

}