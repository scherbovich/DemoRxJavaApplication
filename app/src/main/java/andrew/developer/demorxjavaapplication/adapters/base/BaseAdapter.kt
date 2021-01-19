package andrew.developer.demorxjavaapplication.adapters.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {
    protected var dataList: MutableList<T> = ArrayList()
    private var listener: BaseAdapterListener<T>? = null

    var hasItems = false

    fun attachListener(listener: BaseAdapterListener<T>) {
        this.listener = listener
    }

    fun detachListener() {
        this.listener = null
    }

    fun setList(dataList: List<T>) {
        this.dataList.addAll(dataList)
        hasItems = true
        notifyDataSetChanged()
    }

    fun addItem(newItem: T) {
        dataList.add(newItem)
        notifyItemInserted(dataList.size - 1)
    }

    fun addItemToTop(newItem: T) {
        dataList.add(0, newItem)
        notifyItemInserted(0)
    }

    fun updateItems(itemsList: ArrayList<T>) {
        dataList.clear()
        setList(itemsList)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(dataList[position])

        holder.itemView.setOnClickListener {
            listener?.onItemClick(dataList[position], holder.itemView)
        }
        holder.itemView.setOnLongClickListener {
            if (listener == null) {
                false
            } else {
                listener!!.onLongClick(dataList[position], holder.itemView)
            }

        }
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }
}