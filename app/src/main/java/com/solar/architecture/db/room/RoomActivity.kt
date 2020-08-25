package com.solar.architecture.db.room

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.solar.architecture.R
import com.solar.architecture.db.room.entity.FeedEntity
import com.solar.architecture.extension.base
import com.solar.architecture.extension.plusAssign
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.item_room.view.*

class RoomActivity : AppCompatActivity() {
    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        btn_insert.setOnClickListener {
            val str = insert_edit_text.text.toString()
            if (str.isNotEmpty())
                insertFeed(str)
        }


        val list = listOf<String>("")

        loadDatabaseFeedList()



    }

    private fun loadDatabaseFeedList() {
        disposable += AppDatabase.getInstance(this).feedDao().getAll()
            .base()
            .subscribe(
                {
                    room_list.adapter = object: RecyclerView.Adapter<RoomViewHolder>() {
                        override fun onCreateViewHolder(
                            parent: ViewGroup,
                            viewType: Int
                        ): RoomViewHolder {
                            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
                            return RoomViewHolder(view)
                        }

                        override fun getItemCount(): Int = it.size
                        override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
                            holder.itemView.room_title.text = it[position].title
                        }
                    }
                },
                {

                }
            )
    }

    private fun insertFeed(str: String) {
        disposable +=  AppDatabase.getInstance(this).feedDao().insert(FeedEntity(0, str, str))
            .base()
            .subscribe(
                {
                    insert_edit_text.setText("")
                    loadDatabaseFeedList()
                    Log.d("Insert", "Insert Complete")
                },
                {

                    Log.d("Insert", "Insert Error " + it.message)
                }
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }

    private inner class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view)
}