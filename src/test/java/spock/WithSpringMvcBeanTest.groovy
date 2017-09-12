package spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class WithSpringMvcBeanTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    UserService service

    def "한명 회원조회 테스트"() {
        when:
        def response = mockMvc.perform(get("/user/chanwook"))

        then:
        assert "{\"userName\":\"chanwook\"}".equals(response.andReturn().response.getContentAsString())
        response.andExpect(status().isOk())
    }

}
