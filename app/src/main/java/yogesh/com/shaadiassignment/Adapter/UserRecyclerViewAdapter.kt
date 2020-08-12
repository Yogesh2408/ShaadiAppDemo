package yogesh.com.shaadiassignment.Adapter

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogesh.shaadiassignemt.dataclasses.Result
import yogesh.com.shaadiassignment.R

class UserRecyclerViewAdapter(_context: Context, _itemClickListener: RecyclerItemClickListener) : RecyclerView.Adapter<UserRecyclerViewAdapter.CountryViewHolder>() {

    val context = _context
    val itemClickListener = _itemClickListener
    var userList = ArrayList<Result>()

    fun setUserList(_userList: List<Result>) {
//        if (userList.isEmpty()) {
        userList = _userList as ArrayList<Result>
        notifyDataSetChanged()
//        } else {
//            for (_newresult in _userList) {
//                for ((index, result) in userList.withIndex()) {
//                    if (_newresult.hashCode() == result.hashCode()) {
//                        notifyItemChanged(index)
//                        break
//                    }
//                }
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_user_model_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.name.getFullName()
        holder.userAgeDob.text = user.dob.getAgeAndDob()
        holder.regDate.text = user.registered.getRegDate()
        holder.userAddress.text = user.location.getAddress()
        Glide.with(holder.userProfileImage.context)
                .setDefaultRequestOptions(RequestOptions().circleCrop())
                .load(user.picture.large)
                .into(holder.userProfileImage)

        holder.acceptBtn.setOnClickListener {
            itemClickListener.onItemClickListener(position, user.email, context.getString(R.string.accepted))
        }
        holder.acceptTv.setOnClickListener {
            itemClickListener.onItemClickListener(position, user.email, context.getString(R.string.accepted))
        }
        holder.declineBtn.setOnClickListener {
            itemClickListener.onItemClickListener(position, user.email, context.getString(R.string.declined))
        }
        holder.declineTv.setOnClickListener {
            itemClickListener.onItemClickListener(position, user.email, context.getString(R.string.declined))
        }

        val acceptedString = "${context.getString(R.string.member)} ${context.getString(R.string.accepted)}"
        val declinedString = "${context.getString(R.string.member)} ${context.getString(R.string.declined)}"
        if (!TextUtils.isEmpty(user.extraInfo)) {
            if (user.extraInfo.equals(context.getString(R.string.accepted), true)) {
                holder.confirmationTv.visibility = View.VISIBLE
                holder.confirmationTv.setTextColor(Color.parseColor("#FF5BAA4A"))
                holder.confirmationTv.text = acceptedString
                holder.acceptBtn.visibility = View.INVISIBLE
                holder.acceptTv.visibility = View.INVISIBLE
                holder.declineBtn.visibility = View.INVISIBLE
                holder.declineTv.visibility = View.INVISIBLE
            } else if (user.extraInfo.equals(context.getString(R.string.declined), true)) {
                holder.confirmationTv.visibility = View.VISIBLE
                holder.confirmationTv.setTextColor(Color.parseColor("#FFC64545"))
                holder.confirmationTv.text = declinedString
                holder.acceptBtn.visibility = View.INVISIBLE
                holder.acceptTv.visibility = View.INVISIBLE
                holder.declineBtn.visibility = View.INVISIBLE
                holder.declineTv.visibility = View.INVISIBLE
            } else {
                holder.confirmationTv.visibility = View.GONE
                holder.acceptBtn.visibility = View.VISIBLE
                holder.acceptTv.visibility = View.VISIBLE
                holder.declineBtn.visibility = View.VISIBLE
                holder.declineTv.visibility = View.VISIBLE
            }
        } else {
            holder.confirmationTv.visibility = View.GONE
            holder.acceptBtn.visibility = View.VISIBLE
            holder.acceptTv.visibility = View.VISIBLE
            holder.declineBtn.visibility = View.VISIBLE
            holder.declineTv.visibility = View.VISIBLE
        }
    }


    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.textView_name)
        val userAgeDob: TextView = itemView.findViewById(R.id.textView_detail)
        val userAddress: TextView = itemView.findViewById(R.id.textView_education)
        val regDate: TextView = itemView.findViewById(R.id.reg_date_textView)
        val userProfileImage: ImageView = itemView.findViewById(R.id.user_image_view)

        val acceptBtn: ImageView = itemView.findViewById(R.id.accept_button)
        val acceptTv: TextView = itemView.findViewById(R.id.textView_accept)

        val declineBtn: ImageView = itemView.findViewById(R.id.decline_button)
        val declineTv: TextView = itemView.findViewById(R.id.textView_decline)

        val confirmationTv: TextView = itemView.findViewById(R.id.textView_confirmation)
    }

}