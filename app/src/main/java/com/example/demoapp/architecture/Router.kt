package com.example.demoapp.architecture

interface Destination

interface Router<TypeOfDestination: Destination> {
    fun routeTo(destination: TypeOfDestination)
}