package mainpack.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="role")
    private String role;


    private List<Book> bookList;



}
