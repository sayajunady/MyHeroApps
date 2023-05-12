package com.kopikode.myheroapps.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kopikode.myheroapps.DetailMovieActivity
import com.kopikode.myheroapps.Movie
import com.kopikode.myheroapps.MovieAdapter
import com.kopikode.myheroapps.R


class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MovieAdapter(movieArrayList){
            val intent = Intent(context,DetailMovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.arsenal,
            R.drawable.brentford,
            R.drawable.brighton,
            R.drawable.chelsea,
            R.drawable.crystalpalace,
            R.drawable.everton,
            R.drawable.liverpool,
            R.drawable.manchesterunited,
            R.drawable.manchestercity,
            R.drawable.newcastleunited,
            R.drawable.nottinghamforest,
            R.drawable.stanley,

        )
        title = arrayOf(
            getString(R.string.arsenal),
            getString(R.string.brighton),
            getString(R.string.brentford),
            getString(R.string.chelsea),
            getString(R.string.palace),
            getString(R.string.everton),
            getString(R.string.liverpool),
            getString(R.string.united),
            getString(R.string.city),
            getString(R.string.newcastle),
            getString(R.string.forest),
            getString(R.string.stanley),
        )
        descriptions = arrayOf(
            getString(R.string.arsenal),
            getString(R.string.brighton),
            getString(R.string.brentford),
            getString(R.string.chelsea),
            getString(R.string.palace),
            getString(R.string.everton),
            getString(R.string.liverpool),
            getString(R.string.united),
            getString(R.string.city),
            getString(R.string.newcastle),
            getString(R.string.forest),
            getString(R.string.stanley),
        )
        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }
    }
}


