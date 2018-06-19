package com.jcmsalves.domain

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO
}
