package com.task.accenturelistviewtask.repository

import android.app.Application
import org.junit.Before
import org.junit.Test
import android.content.Context
import com.task.accenturelistviewtask.viewmodel.MainActivityViewModel
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MainActivityRepositoryTest {

    @Mock
    private lateinit var mainActivityRepository: MainActivityRepository
    @Mock
    private lateinit var context: Application
    @Mock
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        `when`<Context>(context.applicationContext).thenReturn(context)

        mainActivityViewModel = MainActivityViewModel(context)

    }

    @Test
    fun getCanadaData() {
    }

    @Test
    fun getProgressBar() {
    }

    @Test
    fun fetchCanadaData() {
    }

    @Test
    fun getApplication() {
    }
}