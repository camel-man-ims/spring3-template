package com.camelman.config

import org.opensearch.client.RestHighLevelClient
import org.opensearch.data.client.orhlc.AbstractOpenSearchConfiguration
import org.opensearch.data.client.orhlc.ClientConfiguration
import org.opensearch.data.client.orhlc.RestClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import java.time.Duration

@Profile("local")
@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.camelman"])
@EnableElasticsearchAuditing
class OpensearchConfig : AbstractOpenSearchConfiguration() {
    @Value("\${elasticsearch.host}")
    private val host: String? = null

    @Value("\${elasticsearch.port}")
    private val port: Int = 0
    override fun opensearchClient(): RestHighLevelClient {
        val clientConfiguration: ClientConfiguration = ClientConfiguration.builder()
            .connectedTo("$host:$port")
            .withConnectTimeout(Duration.ofSeconds(5))
            .withSocketTimeout(Duration.ofSeconds(3))
            .build()

        return RestClients.create(clientConfiguration).rest()
    }
}