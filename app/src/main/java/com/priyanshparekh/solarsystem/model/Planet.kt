package com.priyanshparekh.solarsystem.model

data class Planet(
    var bodies: List<Body>
) {
    constructor(): this(listOf())
}