package io.github.kaiouz.douban.repo.jdbc.person;

import io.github.kaiouz.douban.person.Person;
import io.github.kaiouz.douban.person.PersonRepository;
import io.github.kaiouz.douban.repo.jdbc.BaseRepositoryJdbcImpl;

import javax.sql.DataSource;

public class PersonRepoJdbcImpl extends BaseRepositoryJdbcImpl implements PersonRepository  {

    public PersonRepoJdbcImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Person byId(int id) {
        return null;
    }

    @Override
    public String save(Person person) {
        return null;
    }

}
