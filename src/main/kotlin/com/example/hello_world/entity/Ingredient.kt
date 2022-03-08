package com.example.hello_world.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val description: String?,
    val amount: BigDecimal?,
    @ManyToOne
    val recipe: Recipe
)