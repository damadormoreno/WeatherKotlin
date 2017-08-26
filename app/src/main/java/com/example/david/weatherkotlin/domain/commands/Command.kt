package com.example.david.weatherkotlin.domain.commands

/**
 * Created by david on 21/08/17.
 */
public interface Command<out T>{
    fun execute():T
}