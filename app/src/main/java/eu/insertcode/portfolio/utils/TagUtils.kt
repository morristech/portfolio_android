package eu.insertcode.portfolio.utils

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import eu.insertcode.portfolio.R

/**
 * Created by maartendegoede on 23/10/17.
 * Copyright © 2017 insertCode.eu. All rights reserved.
 */
class TagUtils {
    companion object {
        private val tags: ArrayList<String> = ArrayList()
        private val tagColors = listOf(R.color.insertCode_redDark, R.color.insertCode_redLight, R.color.insertCode_goldLight, R.color.insertCode_goldDark)//, R.color.insertCode_black)

        fun addProjectTag(tag: String, i: Int, context: Context, layout: LinearLayout) {
            LayoutInflater.from(context).inflate(R.layout.item_project_tag, layout)
            layout.getChildAt(i).findViewById<TextView>(R.id.project_tag_text).text = tag
            (layout.getChildAt(i) as CardView).setCardBackgroundColor(getTagColor(tag, context))
        }

        private fun getTagColor(tag: String, context: Context): Int {
            if (!tags.contains(tag)) {
                tags.add(tag)
            }
            val pos = tags.indexOf(tag) % tagColors.size
            return ContextCompat.getColor(context, tagColors[pos])
        }
    }
}