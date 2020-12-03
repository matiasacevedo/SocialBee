package project.socialbee.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import project.socialbee.R
import project.socialbee.view.model.GeneralData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import project.socialbee.view.ui.fragments.SpeakersFragment


class GeneralDataAdapter(private val speakerFragment : SpeakersFragment) : RecyclerView.Adapter<GeneralDataAdapter.ViewHolder>(){

    private val listGeneralData = ArrayList<GeneralData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GeneralDataAdapter.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent,false))

    override fun getItemCount() = listGeneralData.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val generalData = listGeneralData[position] as GeneralData

        holder.tvItemSpeakerTitle.text = generalData.title
        holder.tvItemSpeakerUser.text = generalData.user

        Glide.with(holder.itemView.context)
            .load(generalData.photo)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivItemSpeakerImage)

        holder.itemView.setOnClickListener {
            speakerFragment.onSpeakerClicked(generalData, position)
        }
    }

    fun updateData(data: List<GeneralData>){
        listGeneralData.clear()
        listGeneralData.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivItemSpeakerImage: ImageView = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
        val tvItemSpeakerTitle: TextView = itemView.findViewById<TextView>(R.id.tvItemSpeakerTitle)
        val tvItemSpeakerUser: TextView = itemView.findViewById<TextView>(R.id.tvItemSpeakerUser)
    }
}