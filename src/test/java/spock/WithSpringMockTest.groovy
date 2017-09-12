package spock

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class WithSpringMockTest extends Specification {

    MockMvc mockMvc
    UserService mockService

    def setup() {
        UserController controller = new UserController()
        mockService = Mock(UserService)
        controller.userService = mockService

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    def "한명 회원조회 테스트"() {
        given:
        def userName = "chanwook"
        def user = new User(userName)

        when:
        def response = mockMvc.perform(get("/user/chanwook"))

        then:
        1 * mockService.getUser(userName) >> user
        response.andExpect(status().isOk())
    }

}
