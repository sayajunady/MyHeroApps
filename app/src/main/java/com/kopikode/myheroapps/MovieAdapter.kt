package com.kopikode.myheroapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class MovieAdapter(private val movieList : ArrayList<Movie>, val listener: (Movie) -> Unit)
 : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
  val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
  return MovieViewHolder(itemView)
 }

 override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
  holder.bindView(movieList[position],listener)

  val currentItem = movieList[position]
  holder.imageView.setImageResource(currentItem.imageMovie)
  holder.titleMovie.text = currentItem.titleMovie
  holder.descMovie.text = currentItem.descMovie
  itemCount

 }

 override fun getItemCount(): Int {
  return movieList.size
}

 class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
  val imageView : ImageView = itemView.findViewById(R.id.iv_img)
  val titleMovie : TextView = itemView.findViewById(R.id.tv_title)
  val descMovie : TextView = itemView.findViewById(R.id.tv_desc)

  fun bindView(Movie: Movie, listener: (Movie) -> Unit) {
   imageView.setImageResource(Movie.imageMovie)
   titleMovie.text = Movie.titleMovie
   descMovie.text = Movie.descMovie
   itemView.setOnClickListener{
    listener(Movie)
   }
  }
 }
 }




