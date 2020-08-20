package com.solar.architecture.hilt

import androidx.lifecycle.ViewModel
import com.solar.architecture.hilt.HiltService
import javax.inject.Inject

class HiltViewModel @Inject constructor(
    private val service: HiltService
) : ViewModel() {

}