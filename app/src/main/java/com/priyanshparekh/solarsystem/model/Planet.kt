package com.priyanshparekh.solarsystem.model

data class Planet(
    val bodies: List<Body>
) {
    constructor(): this(listOf())
}