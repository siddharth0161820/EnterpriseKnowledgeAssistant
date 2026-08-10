package com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.Wiki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WikiIngestionServiceTest {

    //1>Inject wikiservice
    @Autowired
   private WikiIngestionService wikiIngestionService;

    //2> //Method()
    @Test
    public void  ingestWikiFiles()throws Exception{
        wikiIngestionService.ingestWikiFiles();
    }
}
