package com.example.hello_world.controller

import com.example.hello_world.entity.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository : CrudRepository<Recipe, Long> {
}