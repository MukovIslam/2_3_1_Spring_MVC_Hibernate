package orgexample.dao;

import org.springframework.stereotype.Repository;
import orgexample.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers(){
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser (int id){
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public void updateUser(User user){
        em.merge(user);
    }

    @Override
    public void deleteAllUsers() {
        em.createQuery("DELETE FROM User").executeUpdate();
        em.createNativeQuery("ALTER TABLE test.users_mvc AUTO_INCREMENT = 1").executeUpdate();

    }
}
