package spock

import spock.lang.*

class FirstSpecification extends Specification {

    def "첫 번째 테스트케이스: 스택에 엘리먼트 푸쉬해보기"() {
        setup:
            def stack = new Stack()
            assert stack.isEmpty()
            def element = "push me"

        when:
            stack.push(element)

        then:
            !stack.empty()
            stack.size() == 1
            stack.peek() == element
    }

    def "에러는 thrown()으로 처리"() {
        setup:
            def stack = new Stack()

        when:
            stack.pop()

        then:
            thrown(EmptyStackException)
            stack.isEmpty()
    }

    def "HashMap accepts null key"() {
        setup:
            def map = new HashMap()

        when:
            map.put(null, "elment")

        then:
            notThrown(NullPointerException)
    }

    /* 이건 아직 Publisher가 없어서 동작하지 않아요.. 
    def "모든 섭스크라이버에게 이벤트 퍼블리싱됐는가"() {
        setup:
            def subscriber1 = Mock(Subscriber)
            def subscriber2 = Mock(Subscriber)
            def publisher = new Publisher()

            publisher.add(subscriber1)
            publisher.add(subscriber2)

        when:
            publisher.fire("event")

        then:
            1 * subscriber1.receive("event")
            1 * subscriber2.receive("event")
    }
    */

    def "expect 돌려보기"() {
        when:
        def x = Math.max(1, 2)

        then:
        x == 2

        expect:
        Math.max(1, 2) == 2
    }

    def "where 블락으로 데이터-드리븐 기능 테스트"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }
}
