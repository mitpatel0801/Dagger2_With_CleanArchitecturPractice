package com.example.cleanarchitecturpractice.presentation.activities

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.cleanarchitecturpractice.R
import com.example.cleanarchitecturpractice.data.api.TMDBService
import com.example.cleanarchitecturpractice.data.db.TMDBDatabase
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieLocalDatasource
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieRemoteDatasource
import com.example.cleanarchitecturpractice.data.repositories.movie.DatasourceImp.MovieLocalDatasourceImp
import com.example.cleanarchitecturpractice.data.repositories.movie.DatasourceImp.MovieRemoteDatasourceImp
import com.example.cleanarchitecturpractice.data.repositories.movie.MovieRepositoryImp
import com.example.cleanarchitecturpractice.databinding.ActivityMainBinding
import com.example.cleanarchitecturpractice.domain.repositories.MovieRepository
import com.example.cleanarchitecturpractice.domain.usecases.GetMoviesUseCase
import com.example.cleanarchitecturpractice.domain.usecases.UpdateMovieUseCase
import com.example.cleanarchitecturpractice.presentation.MyApplication
import com.example.cleanarchitecturpractice.presentation.di.*
import com.example.cleanarchitecturpractice.presentation.viewmodels.movie.MovieViewModel
import com.example.cleanarchitecturpractice.presentation.viewmodels.movie.MovieViewModelFactory
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import kotlin.math.log

private const val TAG = "MainActivity"
private const val LINE =
    "---------------------------------------------------------------------------------------"



class MainActivity : AppCompatActivity() {


    private lateinit var movieViewModel: MovieViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//
//        val tmdbService = retrofit.create(TMDBService::class.java)
//
//        val db = Room.databaseBuilder(
//            applicationContext,
//            TMDBDatabase::class.java, "database-name"
//        ).build()


//        val movieRemoteDataSource = MovieRemoteDatasourceImp(tmdbService, apiKey)
//        val movieLocalDatasource = MovieLocalDatasourceImp(db.movieDao())
//
//        val movieRepo = MovieRepositoryImp(movieRemoteDataSource, movieLocalDatasource)
//        val getMovieUseCase = GetMoviesUseCase(movieRepo)
//        val updateMovieUseCase = UpdateMovieUseCase(movieRepo)
//

           // .inject(this)

        (application as MyApplication).appComponent.movieSubcomponent().create().inject(this)
        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]


        activityMainBinding.getData.setOnClickListener {
            val responce = movieViewModel.getMovies()
            responce.observe(this) {
                Log.d(TAG, LINE)
                Log.d(TAG, "onGet: $it")
                Log.d(TAG, LINE)
            }
        }

        activityMainBinding.updateData.setOnClickListener {
            val responce = movieViewModel.getMovies()
            responce.observe(this) {
                Log.d(TAG, LINE)
                Log.d(TAG, "onUpdate: $it")
                Log.d(TAG, LINE)
            }
        }

    }
}