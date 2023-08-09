package todo.todo

import jakarta.persistence.*
import lombok.*

@Entity
@Table(name ="todos")
data class TodoItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @Column
    var title: String = "masa"
)