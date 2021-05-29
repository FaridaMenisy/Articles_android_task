package com.example.myapplication.data.nw

interface ServiceFactory{
    fun <T> buildApi(type: Class<T>): T
}