package org.xyz.dbdoc

/**
 * ReadTables.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 18:04
 */
interface ReadTables {
    Set readTables(ConnectionDef conn, Set tables)
}