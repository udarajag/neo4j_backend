package org.ntu.ci.controller;

import com.google.gson.Gson;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.ntu.ci.dao.neo4j.N4Connection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Udara on 20/7/17.
 */

@RestController
public class Neo4JController {

    private Gson gson = new Gson();

    @RequestMapping("/loadData")
    public String getNeo4JResults() {
        try{
            StringBuilder sb = new StringBuilder();
            final StatementResult result =
                    N4Connection.getInstance().runResultQuery("MATCH p=()-[r:subClassOf]->() RETURN p LIMIT 25");
            while ( result.hasNext() ) {
                Record record = result.next();
                sb.append(gson.toJson(record.asMap()));
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
