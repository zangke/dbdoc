package org.xyz.dbdoc.comment

import org.xyz.dbdoc.ConnectionDef

/**
 * MySqlReadTableComment.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 21:12
 */
class MySqlReadTableComment implements ReadTableComment {
    @Override
    Map<TableComment, Set<ColumnComment>> readComments(ConnectionDef conn, Set tables) {
        return null
    }
}
