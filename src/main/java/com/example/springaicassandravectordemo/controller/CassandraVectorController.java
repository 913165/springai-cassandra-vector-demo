package com.example.springaicassandravectordemo.controller;

import com.example.springaicassandravectordemo.service.CassandraVectorService;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CassandraVectorController {

    @Autowired
    CassandraVectorService cassandraVectorService;

    @GetMapping("/search")
    public List<Document> search() {
        List<Document> transform = cassandraVectorService.transform();
        return cassandraVectorService.search();
    }

}
