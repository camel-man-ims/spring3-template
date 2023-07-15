package com.camelman.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.camelman.repository.OpensearchWordRepository

@RestController
class TestController @Autowired constructor(
    private val opensearchWordRepository: OpensearchWordRepository,
) {
    @GetMapping
    fun hello() {
        println(opensearchWordRepository.findAll())
    }
}
