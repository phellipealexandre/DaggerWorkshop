package com.phellipesilva.featuretwo.business

import javax.inject.Inject

class BusinessClassB @Inject constructor(private val helperClass: HelperClass) {
    fun doNothing(number: Int): Int = number
    fun returnTrue() = true
}