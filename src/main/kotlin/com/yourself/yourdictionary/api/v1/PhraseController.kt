package com.yourself.yourdictionary.api.v1

import com.yourself.yourdictionary.dto.phrase.CreatePhraseDTO
import com.yourself.yourdictionary.dto.phrase.PhraseDTO
import com.yourself.yourdictionary.service.PhraseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault


@RestController
@RequestMapping("/phrase")
@Tag(name = "Фразы", description = "Управление фразами")
class PhraseController(
    private val phraseService: PhraseService
) {

    @PostMapping
    @Operation(summary = "Создать фразу", description = "Создаёт новую фразу и возвращает её")
    fun create(@RequestBody data: CreatePhraseDTO): ResponseEntity<PhraseDTO> {
        println("Приняли фразу: $data")
        return ResponseEntity.status(HttpStatus.CREATED).body(phraseService.create(data))
    }

    @GetMapping
    @Operation(summary = "Получить список фраз с пагинацией")
    fun getAll(
        @PageableDefault(size = 20) pageable: Pageable
    ): ResponseEntity<Page<PhraseDTO>> {
        val result = phraseService.getAll(pageable)
        return ResponseEntity.ok(result)
    }
}