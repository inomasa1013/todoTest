package todo.todo

import jakarta.persistence.*

@Entity
@Table(name ="todos")
class TodoItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id: Int = 0

    @Column
    var title: String = ""
}