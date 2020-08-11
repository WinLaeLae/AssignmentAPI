package mm.com.fairway.assignmentapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.info_king_layout.view.*
import kotlinx.android.synthetic.main.info_king_layout.view.class_txt
import kotlinx.android.synthetic.main.info_king_layout.view.id_txt
import kotlinx.android.synthetic.main.info_king_layout.view.name_txt
import kotlinx.android.synthetic.main.info_king_layout.view.vote_txt
import kotlinx.android.synthetic.main.info_queen_layout.view.*
import mm.com.fairway.assignmentapi.R
import mm.com.fairway.assignmentapi.model.QueenItem

class QueenAdapter (var queenItemList:ArrayList<QueenItem>):RecyclerView.Adapter<QueenAdapter.QueenViewHolder>(){
    class QueenViewHolder(item: View):RecyclerView.ViewHolder(item){
        fun bind(queenItem: QueenItem){
            itemView.id_txt.text=queenItem.id
            itemView.name_txt.text=queenItem.name
            itemView.class_txt.text=queenItem.`class`
            itemView.vote_txt.text=queenItem.vote_count.toString()
            Picasso.get().load(queenItem.img_url).into(itemView.queen_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
       return QueenViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.info_queen_layout,parent,false))
    }

    override fun getItemCount(): Int {
      return queenItemList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        holder.bind(queenItemList[position])
    }
}