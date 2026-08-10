package com.Siddharth.EnterpriseKnowledgeAssistant.AI.Ingestion.Wiki;

import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;

@Service
public class WikiIngestionService {
    //1>Define a path containing wiki folder
    private static final String WIKI_DIRECTORY="NexaCorpData/wiki";

    //2>Define a method()
    //ingestWikiFiles()---starts the wiki ingestion process
    public void ingestWikiFiles()throws Exception{

        //3>Locate the wiki folders
        //Tells Java where the wiki folders/files r located
        File path=new File(WIKI_DIRECTORY);

        //4>Get all wiki files inside the wiki folder
        File[]wikiFiles=path.listFiles();

        //5>Process each wiki files one at a time/one by one
        for(File wikifilesss:wikiFiles){

            //6>Read the current wiki files
            //Now we use java's Files.readString() to read the file into String
            String data= Files.readString(wikifilesss.toPath());

            //7>Print the data over console
            System.out.println(data);


        }
    }

}
