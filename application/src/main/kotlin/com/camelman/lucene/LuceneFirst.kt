package com.camelman.lucene

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.CharArraySet
import org.apache.lucene.analysis.core.StopAnalyzer
import org.apache.lucene.analysis.core.WhitespaceAnalyzer
import org.apache.lucene.analysis.en.EnglishAnalyzer
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.TextField
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.TopDocs
import org.apache.lucene.store.FSDirectory
import org.aspectj.weaver.tools.cache.SimpleCacheFactory.path
import java.nio.file.Paths
import java.util.*
import kotlin.collections.HashMap

class LuceneFirst

fun main() {
    readDocs()
}

fun readDocs() {
    val path = Paths.get("./lucene/luceneidx")
    val directory = FSDirectory.open(path)
    val indexReader = DirectoryReader.open(directory)

    val parser = QueryParser("title", WhitespaceAnalyzer())
    val query = parser.parse("DL")

    val indexSearcher = IndexSearcher(indexReader)
    val hits: TopDocs = indexSearcher.search(query, 10)

    for (i in 0 until hits.scoreDocs.size) {
        val scoreDoc = hits.scoreDocs[i]
        val doc = indexReader.document(scoreDoc.doc)
        println("${doc.get("title")} : ${scoreDoc.score}")
    }
}

fun registerDocs() {
    val path = Paths.get("./lucene/luceneidx")
    val directory = FSDirectory.open(path)
    val map = HashMap<String, Analyzer>()

    val stopWords = CharArraySet(listOf("a", "an", "the"), true)
    map["pages"] = StopAnalyzer(stopWords)
    map["title"] = WhitespaceAnalyzer()

    val analyzer: Analyzer = PerFieldAnalyzerWrapper(EnglishAnalyzer(), map)

    val config = IndexWriterConfig(analyzer)
    val writer = IndexWriter(directory, config)

    val dl4s = Document()
    dl4s.add(TextField("title", "DL FOR search", Field.Store.YES))
    dl4s.add(TextField("page", "Living in the information", Field.Store.YES))

    val rs = Document()
    rs.add(TextField("title", "Relevant search", Field.Store.YES))
    rs.add(TextField("title", "Getting a search engine to behave", Field.Store.YES))

    writer.addDocument(dl4s)
    writer.addDocument(rs)

    writer.commit()
    writer.close()
}
