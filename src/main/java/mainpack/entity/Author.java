package mainpack.entity;


import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="style")
    private String style;



}
