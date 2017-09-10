package spock

import spock.lang.Specification

/**
 * @author chanwook
 */
class InteractionTestSpec extends Specification {

    Publisher publisher = new Publisher()
    Subscriber subscriber1 = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher.subscribers << subscriber1
        publisher.subscribers << subscriber2
    }

    def "모든 서브스크라이버에게 메세지 가는지 확인"() {
        when:
        publisher.send("hello")

        then:
        1 * subscriber1.receive("hello")
        1 * subscriber2.receive("hello")
    }
}
