package com.example.lita_3tif.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.lita_3tif.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Reuse view jika convertView tidak null (opsional tapi disarankan agar performa hemat memory)
        val binding = if (convertView == null) {
            ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemMessageBinding.bind(convertView)
        }

        val data = messages[position]

        // Binding data ke View
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.timeMessage.text = data.time

        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        return binding.root
    }
}