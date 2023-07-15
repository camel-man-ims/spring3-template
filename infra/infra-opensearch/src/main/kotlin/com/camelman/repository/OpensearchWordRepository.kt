package com.camelman.repository

import com.camelman.domain.OpensearchWord
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface OpensearchWordRepository :
    CrudRepository<OpensearchWord, String>,
    PagingAndSortingRepository<OpensearchWord, String>
