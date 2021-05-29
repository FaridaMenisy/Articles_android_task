package com.example.myapplication.domain.usecase

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.nw.Result
import com.example.myapplication.domain.model.ArticlesModel
import com.example.myapplication.domain.repository.GetArticlesRepo
import com.example.myapplication.util.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
 class GetArticlesUseCase @Inject constructor(var getArticlesRepo: GetArticlesRepo) {

    var getArticlesLiveData =
        MutableLiveData<Result<ArticlesModel>>()
    val compositeDisposable = CompositeDisposable()

    fun getArticles(sections: String, period: String) {
        getArticlesLiveData.postValue(Result.Loading)
        val dispose = getArticlesRepo.getArticles(sections, period)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                handleSuccess(it)
            }, { throwable ->
                handleError(throwable)
            })
        compositeDisposable.addAll(dispose)
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
     fun handleSuccess(articlesModel: ArticlesModel) {
        if (articlesModel.status == Constants.SUCCESS_STATUS)
            getArticlesLiveData.postValue(
                Result.Success(data = articlesModel))

    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
     fun handleError(throwable: Throwable) {
        getArticlesLiveData.postValue(
            Result.Error(throwable = throwable)
        )
    }

}




