package org.xyz.dbdoc

/**
 * DbProperties.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 18:38
 */
trait DbProperties {
    Properties getProperties(ConnectionDef connDef) {
        Properties prop = new Properties()
        prop.setProperty("user", connDef.user)
        prop.setProperty("password", connDef.password)
        return prop
    }
}