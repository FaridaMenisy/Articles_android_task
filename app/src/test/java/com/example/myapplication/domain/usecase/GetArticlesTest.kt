package com.example.myapplication.domain.usecase


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.data.nw.Result
import com.example.myapplication.domain.repository.GetArticlesRepo
import com.example.myapplication.util.ImmediateSchedulersRule
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetArticlesTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val immadiateSchedulersRx2Rule = ImmediateSchedulersRule()

    @Mock
    private lateinit var getArticlesRepo: GetArticlesRepo

    @Mock
    private lateinit var getArticlesUseCase: GetArticlesUseCase

    @Before
    fun setup() {
        getArticlesUseCase = spy(GetArticlesUseCase(getArticlesRepo = getArticlesRepo))
    }


    @Test
    fun `getArticles - Success - ArticlesModelReturned`() {
        //arrange
        doAnswer {
            Single.just(Util.getArticleDetailsModel())
        }.whenever(getArticlesRepo).getArticles(any(), any())

        val getArticlesObserver = getArticlesUseCase.getArticlesLiveData.test()

        //act
        getArticlesUseCase.getArticles(sections = "all-sections", period = "7")

        //assert
        with(getArticlesObserver) {
            assertHistorySize(2)
            assert(this.valueHistory().first() == Result.Loading)
            assertValue {
                it == Result.Success(Util.getArticleDetailsModel())
            }
        }

    }

    @Test
    fun `getArticles - Failure - throwableReturned`() {
        //arrange
        doAnswer {
            Single.error<Throwable>(Throwable())
        }.whenever(getArticlesRepo).getArticles(any(), any())

        val getArticlesObserver = getArticlesUseCase.getArticlesLiveData.test()

        //act
        getArticlesUseCase.getArticles(sections = "all-sections", period = "7")

        //assert
        with(getArticlesObserver) {
            assertHistorySize(2)
            assert(this.valueHistory().first() == Result.Loading)
            assertValue { output ->
                output is Result.Error
            }

        }

    }

    @Test
    fun `handleSucces - postValueToLiveData`() {
        //arrange
        val getArticlesObserver = getArticlesUseCase.getArticlesLiveData
        doAnswer {
           getArticlesObserver.value =
               Result.Success(Util.getArticleDetailsModel())
        }.whenever(getArticlesUseCase).handleSuccess(Util.getArticleDetailsModel())


        //act
        getArticlesUseCase.handleSuccess(Util.getArticleDetailsModel())
        //assert
        with( getArticlesObserver.test()) {
            assertHistorySize(1)
            assertValue {
                it == Result.Success(Util.getArticleDetailsModel())
            }
        }

    }


}
