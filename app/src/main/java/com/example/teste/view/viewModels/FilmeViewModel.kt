import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teste.view.models.FilmeVO
import com.example.teste.view.models.ResultVO
import com.example.teste.view.repositories.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmeViewModel(private val repository: MovieRepository) : ViewModel() {

    val movieList = MutableLiveData<List<FilmeVO>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies(){
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<ResultVO>{
            override fun onResponse(call: Call<ResultVO>, response: Response<ResultVO>) {
                movieList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<ResultVO>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}