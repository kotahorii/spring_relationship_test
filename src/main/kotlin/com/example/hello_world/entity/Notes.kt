package com.example.hello_world.entity

import javax.persistence.*

@Entity
data class Notes(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @OneToOne
    var recipe: Recipe?,
    @Lob
    var notes: String?
)