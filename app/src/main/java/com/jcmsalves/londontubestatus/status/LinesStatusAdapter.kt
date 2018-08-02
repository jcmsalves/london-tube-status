package com.jcmsalves.londontubestatus.status

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.*
import com.jcmsalves.londontubestatus.R
import com.jcmsalves.londontubestatus.status.model.LineStatusPresentation
import kotlinx.android.synthetic.main.item_line_status.view.*
import javax.inject.Inject

class LinesStatusAdapter @Inject
constructor() : RecyclerView.Adapter<LineStatusViewHolder>() {

    private val linesStatus = ArrayList<LineStatusPresentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LineStatusViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_line_status, parent, false))

    override fun getItemCount() = linesStatus.size

    override fun onBindViewHolder(holder: LineStatusViewHolder, position: Int) {
        holder.bind(linesStatus[position])
    }

    fun setLinesStatus(linesStatus: List<LineStatusPresentation>) {
        this.linesStatus.clear()
        this.linesStatus.addAll(linesStatus)
        notifyDataSetChanged()
    }
}

class LineStatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(lineStatus: LineStatusPresentation) {
        itemView.text_view_line_name.text = lineStatus.name
        itemView.text_view_line_status.text = lineStatus.severityLevelDescription

        itemView.image_view_line_badge.setImageDrawable(
            ContextCompat.getDrawable(itemView.context, lineStatus.badgeResourceId))
        itemView.view_severity_level.setBackgroundColor(
            ContextCompat.getColor(itemView.context, lineStatus.colourResourceId))
    }
}
