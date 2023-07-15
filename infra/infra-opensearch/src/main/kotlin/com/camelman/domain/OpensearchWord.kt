package com.camelman.domain

import com.camelman.domain.OpensearchWord.Companion.SEARCH_WORD_INDEX_NAME
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = SEARCH_WORD_INDEX_NAME)
class OpensearchWord(
    @Field(type = FieldType.Text)
    var word: String,

    @Field(type = FieldType.Keyword)
    var wordUnits: List<String>,

    @Field(type = FieldType.Keyword)
    var type: String,

    @Field(type = FieldType.Keyword)
    var wordInitialUnits: List<String>,
) {

    @Id
    @Field(type = FieldType.Text)
    var id: String? = null

    companion object {
        const val SEARCH_WORD_INDEX_NAME = "search_word"
    }
}