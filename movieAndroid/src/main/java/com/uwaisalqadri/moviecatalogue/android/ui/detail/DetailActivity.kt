package com.uwaisalqadri.moviecatalogue.android.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.ActivityDetailBinding
import com.uwaisalqadri.moviecatalogue.android.ui.favorite.FavoriteViewModel
import com.uwaisalqadri.moviecatalogue.android.utils.*
import com.uwaisalqadri.moviecatalogue.data.source.remote.response.CastItem
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

	private val binding: ActivityDetailBinding by viewBinding()
	private val viewModel: DetailViewModel by viewModel()

	private val castAdapter = GroupAdapter<GroupieViewHolder>()

	private var isFavorite: Boolean? = false
	private var movieId: Int = 0
	private lateinit var movieData: Movie

	companion object {
		const val EXTRA_MOVIE = "movieId"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)

		val intent = intent?.extras?.getInt(EXTRA_MOVIE)
		movieId = intent ?: 0

		with(viewModel) {
			requestDetailMovie(movieId)
			requestCastMovie(movieId)
			requestVideoMovie(movieId)
			checkFavoriteMovie(movieId)

			detailMovie.observe(this@DetailActivity) { movie ->
				binding.apply {
					val genreNames = mutableListOf<String>()
					movieData = movie
					titleDetailMovie.text = movieData.title
					descriptionDetailMovie.text = movieData.overview
					movieData.posterPath?.let { imgDetailMovie.loadImage(Constants.urlImage + it) }
					playtimeDetailMovie.text = movieData.releaseDate
					movieData.genres.forEach { it.name?.let { name -> genreNames.add(name) } }
					genresDetailMovie.text = genreNames.joinToString(", ")

					binding.btnAddFavorite.setOnClickListener {
						when(isFavorite) {
							true -> viewModel.deleteFavoriteMovie(movieData.id ?: 0)
							false -> viewModel.addFavoriteMovie(movieData)
						}
					}
				}
			}

			castMovie.observe(this@DetailActivity) { casts ->
				casts.map {
					castAdapter.add(CastItem(it))
				}
			}

			videoMovie.observe(this@DetailActivity) { videos ->
				videos.map { video ->
					binding.btnWatchTrailer.setOnClickListener {
						openLink(Constants.youtubeUrl + video.key)
					}
				}
			}

			loading.observe(this@DetailActivity) {
				binding.progressCircular.isVisible = it
			}

			favoriteState.observe(this@DetailActivity) { favoriteState ->
				when(favoriteState) {
					is AddFavorite -> {
						removeFavoriteView()
						isFavorite = true
					}
					is RemoveFavorite -> {
						addFavoriteView()
						isFavorite = false
					}
					is FavMovieDataFound -> {
						favoriteState.movie.map {
							if (it.id == movieId) {
								removeFavoriteView()
								isFavorite = true
							}
						}
					}
				}
			}
		}

		with(binding.rvDetailCast) {
			adapter = castAdapter
			layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
			setHasFixedSize(true)
		}

		binding.btnBack.setOnClickListener {
			finish()
		}
	}

	pri
	private fun addFavoriteView() {
		binding.btnAddFavorite.apply {
			text = getString(R.string.add_favorite)
			setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_add, 0, 0, 0)
		}
	}

	private fun removeFavoriteView() {
		binding.btnAddFavorite.apply {
			text = getString(R.string.remove_favorite)
			setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check, 0, 0, 0)
		}
	}
}