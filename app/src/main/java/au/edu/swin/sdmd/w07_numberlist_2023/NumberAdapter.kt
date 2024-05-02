package au.edu.swin.sdmd.w07_numberlist_2023

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(private val data: List<Int>) : RecyclerView.Adapter<NumberAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.layout_row, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val number: TextView = v.findViewById(R.id.number)

        fun bind(item: Int) {
            number.text = item.toString()

            v.setOnClickListener {
                val i = Intent(it.context, DetailActivity::class.java)
                i.putExtra("NUMBER", item)
                it.context.startActivity(i)
            }
        }

    }

}