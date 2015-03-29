package dao;

import javax.transaction.Transactional;

import model.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

@Transactional
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveLogin(Login user) {
        hibernateTemplate.save(user);
    }

}
