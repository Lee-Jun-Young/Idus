package com.example.idus.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Location
import com.example.idus.databinding.ItemRvBinding
import com.example.idus.databinding.RvHeaderBinding

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1
    private val items = ArrayList<Location>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> MainHeaderViewHolder(
                RvHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> return MainViewHolder(
                ItemRvBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.onBind(items[position - 1])
        }
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else {
            TYPE_ITEM
        }
    }

    fun setList(location: List<Location>) {
        val diffResult = DiffUtil.calculateDiff(ContentDiffUtil(items, location), false)
        diffResult.dispatchUpdatesTo(this)
        items.clear()
        items.addAll(location)
    }

    class MainViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(location: Location) {
            binding.mainData = location
        }
    }

    class MainHeaderViewHolder(private val binding: RvHeaderBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ContentDiffUtil(
        private val oldList: List<Location>,
        private val currentList: List<Location>
    ) : DiffUtil.Callback() {
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == currentList[newItemPosition]
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].title == currentList[newItemPosition].title
        }

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = currentList.size
    }
}