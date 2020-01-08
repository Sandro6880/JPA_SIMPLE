package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(Person person) {
        final String stmt = "insert into person values (?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(stmt, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, person.getSSN());
                ps.setDate(2, Date.valueOf(person.getDateOfBirth()));
                ps.setString(3, person.getFirstName());
                ps.setString(4, person.getLastName());
                ps.setBoolean(5, person.isAwesome());
                ps.setFloat(6, person.getAwesomeness());
                ps.setBigDecimal(7, person.getWealth());
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public List<Person> getPersons() {
        return jdbcTemplate.query("select * from person", (rs, rowNum) -> new Person(
                rs.getString("SSN"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getBoolean("is_awesome"),
                rs.getFloat("awesomeness"),
                rs.getBigDecimal("wealth")
        ));
    }

}
