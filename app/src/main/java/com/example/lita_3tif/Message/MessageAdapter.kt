package com.example.lita_3tif.Message


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.lita_3tif.Home.Pertemuan_5.FifthActivity
import com.example.lita_3tif.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val  Messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, Messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val data = Messages[position]

        // Binding data ke View
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.timeMessage.text = data.time

        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        view.setOnClickListener {
            val i= Intent(context, FifthActivity::class.java)
            i.putExtra("nama", data.senderName) //memindahkan data ke activity yujuan
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText} ${data.time}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        return view
    }
}