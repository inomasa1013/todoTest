package todo.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ToDoListApplication

fun main(args: Array<String>) {
    runApplication<ToDoListApplication>(*args)
}

@Component
class MyComponent() {
    init {
        println("component")
    }
}

data class Todo(
    val title:String
)

@RestController
@RequestMapping("/todo")
class TodoContainer (private val todoRepository:TodoRepository){
    private var todos:List<String>  = mutableListOf<String>("masa", "masamasa")
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping()
    fun getTodos(): List<String> {
        println(todoRepository.findAll())
        todos = todoRepository.findAll().map {item -> item.title }
        return todos
    }
    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping()
    fun postTodos(@RequestBody body:Todo): List<String>{
        val todoItem = TodoItem(title=body.title)
        todoRepository.save(todoItem)

        todos = todoRepository.findAll().map {item -> item.title }
        return todos
    }
}


