package spock

import spock.lang.Specification
import spock.lang.Unroll
/**
 * @author chanwook
 */
class MathSpecification extends Specification {

    def "두 수중 큰 수 찾아내기(expect 사용)"() {
        expect:
        Math.max(1, 3) == 3
        Math.max(7, 4) == 7
        Math.max(0, 0) == 0
    }

    def "두 수중 큰 수 찾아내기(data table 사용)"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

    def "두 수중 큰 수 찾아내기(||로 메서드 인자 제거)"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0
    }

    @Unroll
    def "@Unroll로 어떤 이터레이션에서 에러난 건지 알아내기"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 1
    }

    def "data pipe 사용해보기"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [1, 7, 0]
        b << [3, 4, 0]
        c << [3, 7, 0]
    }

    def "데이터 테이블, 데이터 파이프, 변수 할당하기 혼합해서 사용하기"() {
        expect:
        Math.max(a, b) == c

        where:
        // a는 데이터 테이블로
        a | _
        3 | _
        7 | _
        0 | _

        // b는 데이터 파이프로
        b << [5, 0, 0]

        // c는 변수 할당해서
        c = a > b ? a : b
    }

    def "사람 이름이 #firstName 인지 확인해보기"() {

        expect:
        "chanwook".equals(person.getName())

        where:
        person << new Person("chanwook")
        firstName = person.getName()
    }
}
