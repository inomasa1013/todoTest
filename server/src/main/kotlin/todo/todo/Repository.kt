package todo.todo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<TodoItem,Int> {
    override fun findAll(): List<TodoItem>
}