package org.xyz.dbdoc.comment

import org.xyz.dbdoc.ConnectionDef

/**
 * TableComment.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 18:16
 */
interface ReadTableComment {
    Map<TableComment, Set<ColumnComment>> readComments(ConnectionDef conn, Set tables)
}