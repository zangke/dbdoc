package org.xyz.dbdoc

import groovy.sql.Sql
import groovy.util.logging.Log4j

/**
 * MySqlReadTables.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 18:06
 */
@Log4j
class MySqlReadTables implements ReadTables {

    private static String SQL_R_USER_TABLES = """SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES
        WHERE TABLE_SCHEMA = :schema AND TABLE_NAME LIKE :tableName """

    @Override
    Set readTables(ConnectionDef conn, Set tables) {
        def sql
        Set result = []
        try {
            sql = Sql.newInstance(conn.url, getProperties(conn), conn.driver)
            tables.each {
                def data = sql.firstRow(SQL_R_USER_TABLES, [schema: conn.schema, tableName: it])
                if (data) {
                    result << data.table_name
                }
            }

        } catch (e) {
            log.error e, e.message
        }
        result
    }
}
