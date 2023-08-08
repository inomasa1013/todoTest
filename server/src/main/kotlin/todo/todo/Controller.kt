package todo.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class MyController(@Autowired val component: MyComponent){
    init{
        println("controller: mycomponent: $component")
    }
}
