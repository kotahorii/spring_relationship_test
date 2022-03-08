package com.example.hello_world.entity

import Recipe
import javax.persistence.*

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    @ManyToMany(mappedBy = "category")
    val recipe: Set<Recipe>
)