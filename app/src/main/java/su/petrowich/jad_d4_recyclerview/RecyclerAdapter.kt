package su.petrowich.jad_d4_recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class RecyclerAdapter : RecyclerView.Adapter<RecyclerViewHolder>(){

    private var items : MutableList<WeatherItem> = mutableListOf()

    fun setItems(newItems : List<WeatherItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_weather, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val textToShow = items[position]
        holder.bind(textToShow)

        holder.itemView.setOnClickListener{
            onRecyclerClicked?.onClick(textToShow)
        }
    }

    interface OnRecyclerClicked{
        fun onClick(text: WeatherItem)
    }

    private var onRecyclerClicked: OnRecyclerClicked? = null

    fun setOnRecyclerClicked(onRecyclerClicked: OnRecyclerClicked?){
        this.onRecyclerClicked = onRecyclerClicked
    }
}