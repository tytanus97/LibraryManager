package mainpack.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
                        ,fetch=FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Author author;

    @Column(name="description")
    private String description;

    @Column(name="amount")
    private int amount;

    @ManyToMany(fetch = FetchType.LAZY,
               cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="users_books",joinColumns = @JoinColumn(name="book_id")
            ,inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> userList;

    public Book() {
    }

    public Book(String title, Author author, String description,int amount) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.amount = amount;
    }

    public Book(String title, Author author, String description,int amount,List<User> userList) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.amount = amount;
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {

        if(this.userList == null) {
            this.userList = new ArrayList<>();
        }

        this.userList.add(user);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", description='" + description + '\'' +
                '}';
    }
}
