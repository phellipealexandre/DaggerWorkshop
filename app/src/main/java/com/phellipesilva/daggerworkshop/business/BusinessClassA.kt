package com.phellipesilva.daggerworkshop.business

import com.phellipesilva.daggerworkshop.database.User

class BusinessClassA(
    private val helperClass: HelperClass
) {

    fun generateRandomFromUser(user: User): Int = user.hashCode()
}