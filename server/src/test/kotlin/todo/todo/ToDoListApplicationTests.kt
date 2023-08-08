package todo.todo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
class `Greetingに関するTest` {

    @Test
    fun `Hello ,Worldが出力される`() {
        val ToDoTest = ToDoListApplication()
        val actual = ToDoTest.sayHello()

        assertEquals("Hello ,World!", actual)
    }

    @Test
    @DisplayName("引数とHello ,World!が表示される")
    fun argTest() {
        val ToDoTest = ToDoListApplication()
        val actual = ToDoTest.sayHello("Masa!")

        assertEquals("Masa!Hello ,World!", actual)
    }
}

@WebMvcTest(HelloContainer::class)
@AutoConfigureMockMvc
class `APIに関するテスト` {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun returnApi() {
        mockMvc.perform(get("/api/hello"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello ,World!"))
    }

}