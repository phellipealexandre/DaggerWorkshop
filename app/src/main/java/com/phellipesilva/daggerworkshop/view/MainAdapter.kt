package com.phellipesilva.daggerworkshop.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.phellipesilva.daggerworkshop.R
import com.phellipesilva.daggerworkshop.database.User
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(
    private val context: Context,
    private val users: List<User>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var userCallback: (User) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listItemInflater = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(listItemInflater)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            if (::userCallback.isInitialized) userCallback.invoke(user)
        }
    }

    fun setOnUserClickListener(userCallback: (User) -> (Unit)) {
        this.userCallback = userCallback
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.nameTextView
        private val emailTextView: TextView = view.emailTextView

        fun bind(user: User) {
            nameTextView.text = user.username
            emailTextView.text = user.email
        }
    }
}