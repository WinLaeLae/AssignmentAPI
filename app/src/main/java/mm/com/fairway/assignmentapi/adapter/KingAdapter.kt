package mm.com.fairway.assignmentapi.adapter

import android.accounts.AccountManager.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.info_king_layout.view.*
import mm.com.fairway.assignmentapi.R
import mm.com.fairway.assignmentapi.model.KingItem

class KingAdapter(var kingItemList:ArrayList<KingItem>):RecyclerView.Adapter<KingAdapter.KingViewHolder>() {
    class KingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind (kingItem:KingItem){
            itemView.id_txt.text=kingItem.id
            itemView.name_txt.text=kingItem.name
            itemView.class_txt.text=kingItem.`class`
            itemView.vote_txt.text=kingItem.vote_count.toString()
            Picasso.get().load(kingItem.img_url).into(itemView.king_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
       return KingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.info_king_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return kingItemList.size
    }

    override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
     holder.bind(kingItemList[position])
}
}