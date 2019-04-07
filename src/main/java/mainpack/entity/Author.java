package mainpack.entity;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;


    @Column(name="style")
    private String style;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Book> bookList;

    public Author() {
    }

    public Author(String name,String style,List<Book> bookList) {
       this.name=name;
        this.style = style;
        this.bookList = bookList;
    }

    public Author(String name,String style) {

        this.name=name;
        this.style = style;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<Book> getBookList() {
        return this.bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book) {

        if(this.bookList == null) {
            this.bookList = new ArrayList<Book>();
        }

        this.bookList.add(book);

        book.setAuthor(this);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
               "name=" + name +
                ", style='" + style + '\'' +
                '}';
    }
}
