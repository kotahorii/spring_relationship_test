package com.example.hello_world.controller

import com.example.hello_world.entity.Category
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CategoryRepository : CrudRepository<Category, Long> {
    fun findByName(name: String): Optional<Category>
}