package com.example.springaicassandravectordemo.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CassandraVectorService {
    @Autowired
    VectorStore vectorStore;

    public List<Document> transform() {
           List<Document> documents = List.of(
                new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("country", "UK", "year", 2020)),
                new Document("The World is Big and Salvation Lurks Around the Corner", Map.of()),
                new Document("You walk forward facing the past and you turn back toward the future.", Map.of("country", "NL", "year", 2023))
        );

        TextSplitter textSplitter = new TokenTextSplitter();

        for (Document document : documents) {
            List<Document> splitteddocs = textSplitter.split(document);

            try {
                Thread.sleep(20000); // Sleep for 1 second
                vectorStore.add(splitteddocs);
                System.out.println("Added document: " + document.getContent());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        System.out.println("Transformed documents: " + documents);
        return documents;
    }

    public List<Document> search() {
        List<Document> results = vectorStore.similaritySearch(SearchRequest.query("Spring").withTopK(2));
        return results;
    }
}
