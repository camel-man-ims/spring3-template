package com.camelman

import EnableOpensearch
import org.opensearch.spring.boot.autoconfigure.OpenSearchRestClientAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.camelman"],
    exclude = [ElasticsearchDataAutoConfiguration::class, OpenSearchRestClientAutoConfiguration::class],
)
@EnableOpensearch
@ConfigurationPropertiesScan
class CamelmanApplication

fun main(args: Array<String>) {
    runApplication<CamelmanApplication>(*args)
}
