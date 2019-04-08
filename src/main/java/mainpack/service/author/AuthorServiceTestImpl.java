package mainpack.service.author;

import mainpack.dao.author.AuthorDAO;
import mainpack.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceTestImpl implements AuthorServiceTest{


    @Autowired
    private AuthorDAO authorDAO;

    @Transactional
    @Override
    public void add(Author author) {
        authorDAO.add(author);
    }

    @Transactional
    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Transactional
    @Override
    public void deleteById(int id) {

    }


    @Transactional
    @Override
    public Author findByName(String name) {
        return authorDAO.findByName(name);
    }


}
