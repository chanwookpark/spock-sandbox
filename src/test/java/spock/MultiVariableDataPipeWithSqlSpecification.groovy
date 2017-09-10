package spock

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author chanwook
 */
class MultiVariableDataPipeWithSqlSpecification extends Specification {

    @Shared sql = Sql.newInstance("jdbc:h2:~/mem", "org.h2.Driver")

    def setupSpec() {
        sql.execute("CREATE TABLE MAXDATA( A INTEGER, B INTEGER, C INTEGER)")
        sql.execute("INSERT INTO MAXDATA VALUES(1, 3, 3)")
        sql.execute("INSERT INTO MAXDATA VALUES(7, 4, 7)")
        sql.execute("INSERT INTO MAXDATA VALUES(0, 0, 0)")
    }

    def cleanupSpec() {
        sql.execute("DROP TABLE MAXDATA")
    }

    @Unroll
    def "공용 sql 사용해 where 변수 만들기"() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << sql.rows("select a, b, c from MAXDATA")
    }
}
