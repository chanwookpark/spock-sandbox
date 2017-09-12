package spock

import org.spockframework.spring.ScanScopedBeans
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@ScanScopedBeans
@SpringBootTest
class WithSpringBootTest extends Specification {

    @Autowired
    UserController userController

    def "사용자 조회"() {

        when:
        def user = userController.view("chanwook")

        then:
        assert "chanwook".equals(user.userName)
    }
}
