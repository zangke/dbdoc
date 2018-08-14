package org.xyz.dbdoc

import groovy.util.logging.Log4j
import org.xyz.dbdoc.comment.ReadTableComment
import org.xyz.dbdoc.comment.ReadTableCommentFactory

/**
 * DbDocMain.
 * <p>
 *
 * @author: <a href="mailto:zangke168@foxmail.com"> Andy Cheung</a>
 * @created: 2018/8/14 20:54
 */
@Log4j
class DbDocMain {
    static void main(String[] args) {
        log.info "dbdoc"
        try {
            def main = new DbDocMain()
            main.runLoader()
        }
        catch (Exception e) {
            log.error(e.message, e)
        }
    }

    def runLoader() throws Exception {
        def xmlfile = "dbdoc.xml"
        def config = new XmlParser().parse(xmlfile)
        def connectionDef = new ConnectionDef(
                config.datasource.connection_url.text().trim(),
                config.datasource.driver_class.text().trim(),
                config.datasource.user_name.text().trim(),
                config.datasource.password.text().trim()
        )
        Set tables = []
        config.table?.each {
            def tableName = it.attribute('name')
            tableName.split(",").each {
                tables << it.replace("*", "%")
            }
        }
        log.info "tables ${tables}"
        ReadTables readTables = ReadTablesFactory.make(connectionDef.dbType)
        Set dbTables = readTables.readTables(connectionDef, tables)
        log.info "dbTables ${dbTables}"
        ReadTableComment tableComment = ReadTableCommentFactory.make(connectionDef.dbType)
        def commentMap = tableComment.readComments(connectionDef, dbTables)
        log.info "commentMap ${commentMap}"
    }
}
