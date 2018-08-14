package org.xyz.dbdoc.comment

import org.xyz.dbdoc.DatabaseType

/**
 * ReadTableCommentFactory.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 21:11
 */
class ReadTableCommentFactory {
    static ReadTableComment make(String dbType) {
        def result
        switch (dbType) {
            case DatabaseType.Oracle:
                result = new OracleReadTableComment()
                break
            case DatabaseType.MySQL:
                result = new MySqlReadTableComment()
                break
            default:
                throw new Exception("ReadTableComment has't implement!")
                break
        }
        result
    }
}
