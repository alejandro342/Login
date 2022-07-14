package com.example.loginko.adapater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginko.R
import com.example.loginko.databinding.ItemUsersBinding
import com.example.loginko.login.model.UsersItem

class UsersAdapter(mContext: Context, var listUser: List<UsersItem>) :
    RecyclerView.Adapter<UsersAdapter.ItemAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapterHolder {
        return ItemAdapterHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_users, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemAdapterHolder, position: Int) {
        val usersItem: UsersItem = listUser[position]
        holder.binding.txtNameUser.setText(usersItem.name)
        holder.binding.txtUser.setText(usersItem.username)
        holder.binding.txtEmailUser.setText(usersItem.email)
        holder.binding.txtCalle.setText(usersItem.phone)
        holder.binding.txtWeb.setText(usersItem.website)

    }

    override fun getItemCount(): Int {
       return listUser.size
    }

    class ItemAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemUsersBinding.bind(itemView)

    }
}