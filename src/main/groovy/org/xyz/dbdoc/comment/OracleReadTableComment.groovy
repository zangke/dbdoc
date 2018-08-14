package org.xyz.dbdoc.comment

import org.xyz.dbdoc.ConnectionDef

/**
 * OracleTableComment.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 19:21
 */
class OracleReadTableComment implements ReadTableComment {
    @Override
    Map<TableComment, Set<ColumnComment>> readComments(ConnectionDef conn, Set tables) {
        return null
    }
}
