package org.ntu.ci.dao.neo4j;

import org.neo4j.driver.v1.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.*;

/**
 * Created by Udara on 20/7/17.
 */
public class N4Connection {

    private Logger logger = LoggerFactory.getLogger(N4Connection.class);

    private static N4Connection instance;

    private Driver driver;

    private N4Connection() {
        driver = GraphDatabase.driver("bolt://localhost");
    }

    public static N4Connection getInstance() {
        if (instance == null) {
            instance = new N4Connection();
        }
        return instance;
    }

    public Session getSession() {
        return driver.session();
    }

    public StatementResult runResultQuery(String query) {
        Session session = null;
        StatementResult result = null;
        try {
            session = driver.session();
            result = session.run(query);

        } catch (Exception e) {
            logger.info("error :" + e);
        } finally {
            session.close();
        }
        return result;

    }

}
