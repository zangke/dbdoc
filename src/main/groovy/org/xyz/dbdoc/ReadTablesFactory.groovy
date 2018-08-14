package org.xyz.dbdoc

/**
 * ReadTablesFactory.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 17:16
 */
class ReadTablesFactory {
    static ReadTables make(String dbType) {
        def result
        switch (dbType) {
            case DatabaseType.Oracle:
                result = new OracleReadTables()
                break
            case DatabaseType.MySQL:
                result = new MySqlReadTables()
                break
            default:
                throw new Exception("ReadTables未实现！")
                break
        }
        result
    }
}
