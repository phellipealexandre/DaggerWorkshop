package com.phellipesilva.daggerworkshop.business

class BusinessClassB(
    private val helperClass: HelperClass
) {

    fun doNothing(number: Int): Int = number
}