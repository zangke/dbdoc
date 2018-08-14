package org.xyz.dbdoc

/**
 * ConnectionDef.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 18:40
 */
class ConnectionDef {
    String url
    String driver
    String user
    String password
    String schema
    String dbType

    ConnectionDef(String url, String driver, String user, String password) {
        this.url = url
        this.driver = driver
        this.user = user
        this.password = password
        if (driver.indexOf("mysql") > -1) {
            dbType = DatabaseType.MySQL
        } else if (driver.indexOf("sqlserver") > -1) {
            dbType = DatabaseType.SqlServer
        } else {
            dbType = DatabaseType.Oracle
        }

        this.schema = user
    }
}
