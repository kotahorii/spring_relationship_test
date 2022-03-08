package com.example.hello_world.Recipe.Entity

import java.math.BigDecimal
import javax.persistence.*

enum class Difficulty {
    EASY, MODERATE, HARD
}

@Entity
data class Recipe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var description: String?,
    var prepTime: String?,
    var cookTime: String?,
    var servings: String?,
    var url: String?,
    var directions: String?,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "recipe")
    var ingredient: Set<Ingredient>?,
    @OneToOne(cascade = [CascadeType.ALL])
    var notes: Notes?,
    @ManyToMany
    @JoinTable(
        name = "recipe_category",
        joinColumns = [JoinColumn(name = "recipe_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    val category: Set<Category>?,
    @Enumerated(value = EnumType.STRING)
    val difficulty: Difficulty,
)

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

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    @ManyToMany(mappedBy = "category")
    val recipe: Set<Recipe>
)