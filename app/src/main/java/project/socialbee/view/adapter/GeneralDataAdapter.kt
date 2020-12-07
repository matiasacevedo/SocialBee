package project.socialbee.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import project.socialbee.R
import project.socialbee.view.model.GeneralData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import project.socialbee.view.ui.fragments.SpeakersFragment
import kotlinx.android.synthetic.main.item_speaker.*


class GeneralDataAdapter(private val speakerFragment : GeneralDataListener) : RecyclerView.Adapter<GeneralDataAdapter.ViewHolder>(){

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

        //.set
    }

    fun updateData(data: List<GeneralData>){
        listGeneralData.clear()
        listGeneralData.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val context = itemView.getContext()

        val ivItemSpeakerImage: ImageView = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
        val tvItemSpeakerTitle: TextView = itemView.findViewById<TextView>(R.id.tvItemSpeakerTitle)
        val tvItemSpeakerUser: TextView = itemView.findViewById<TextView>(R.id.tvItemSpeakerUser)
        val tvUser: TextView = itemView.findViewById<TextView>(R.id.tvUser)
        val tvLatitude: TextView = itemView.findViewById<TextView>(R.id.tvLatitude)
        val tvLongitude: TextView = itemView.findViewById<TextView>(R.id.tvLongitude)
        val btnLocation: ImageButton = itemView.findViewById<ImageButton>(R.id.ibLocation)
        val btnShare: ImageButton = itemView.findViewById<ImageButton>(R.id.ibShare)
        val btnMessage: ImageButton = itemView.findViewById<ImageButton>(R.id.ibMessage)

        fun setOnClickListener() {
            btnLocation.setOnClickListener(this)
            btnShare.setOnClickListener(this)
            btnMessage.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {

            var id = p0?.getId()

            // Se obtinen los datos de la card para pasar al mapa
            var lat = tvLatitude.text
            var lon = tvLongitude.text
            var user = tvUser.text
            /*
            when(id){
                R.id.ibLocation -> run {
                    val intent = Intent(context, MenuItemActivity::class.java).apply{
                        putExtra("codigo", "map")
                        /*putExtra("latitude", tvLatitude.toString())*/
                        putExtra("latitude", lat.toString())
                        putExtra("longitude", lon.toString())
                        putExtra("user", user.toString())
                    }
                    context.startActivity(intent)
                }
                R.id.ibShare -> run {
                    val intent = Intent(context, MenuItemActivity::class.java).apply{
                        putExtra("codigo", "share")
                    }
                    context.startActivity(intent)
                }
                R.id.ibMessage -> run {
                    val intent = Intent(context, MenuItemActivity::class.java).apply{
                        putExtra("codigo", "message")
                    }
                    context.startActivity(intent)
                }
            }

             */
        }


    }
}