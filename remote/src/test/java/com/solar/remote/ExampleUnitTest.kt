package com.solar.remote

import com.nhaarman.mockito_kotlin.mock
import com.solar.data.model.FoodEntity
import com.solar.remote.impl.FoodRemoteImpl
import com.solar.remote.mapper.EntityMapper
import com.solar.remote.mapper.FoodEntityMapper
import com.solar.remote.retrofit.ApiClient
import com.solar.remote.service.FoodService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleUnitTest {

    private lateinit var service: FoodService
    private lateinit var foodRemoteImpl: FoodRemoteImpl

    @Before
    fun setup() {
        service = ApiClient.provideAppService(true) //mock()
        foodRemoteImpl = FoodRemoteImpl(service, FoodEntityMapper())
    }

    @Test
    fun getFoodList() {
        val foodEntities = mutableListOf<FoodEntity>()
        val testObserver = foodRemoteImpl.getFoodList().test()
        testObserver.assertComplete()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}