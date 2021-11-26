package io.github.kaiouz.douban.person;

public interface PersonRepository {

    Person byId(int id);

    String save(Person person);

}
