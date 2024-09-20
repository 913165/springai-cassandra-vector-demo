package com.example.springaicassandravectordemo.config;

import com.datastax.oss.driver.api.core.CqlSession;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.ai.autoconfigure.vectorstore.cassandra.CassandraVectorStoreAutoConfiguration;
import org.springframework.ai.autoconfigure.vectorstore.cassandra.CassandraVectorStoreProperties;
import org.springframework.ai.chat.memory.CassandraChatMemory;
import org.springframework.ai.chat.memory.CassandraChatMemoryConfig;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.CassandraVectorStore;
import org.springframework.ai.vectorstore.CassandraVectorStoreConfig;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.observation.VectorStoreObservationConvention;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class AppConfig {

    //@Bean
    public ChatMemory chatMemory() {
        return CassandraChatMemory.create(CassandraChatMemoryConfig.builder().withTimeToLive(Duration.ofDays(1)).build());
    }


}
