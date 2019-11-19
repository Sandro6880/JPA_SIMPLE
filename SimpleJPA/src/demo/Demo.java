package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonPU");
        EntityManager em = factory.createEntityManager();

        insertPerson(em);

        Query query = em.createQuery("select p from Person p");
        List<Person> result = query.getResultList();
        for (Person p : result){
            System.out.println(p.getsSSN() + ": " + p.getFirstName() + " " + p.getLastName());
        }
        insertAddress(em,result.get(1));
        List<Person> result2 = getPersonList(em);
        em.close();
        factory.close();
    }

    private static void insertPerson(EntityManager em ){
        em.getTransaction().begin();
        Person newPerson = new Person();
        newPerson.setsSSN("5555050675");
        newPerson.setFirstName("Java6");
        newPerson.setLastName("Student");
        newPerson.setDateOfBirth(Date.from(LocalDate.of(1970,6,5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        newPerson.setAwesome(false);
        newPerson.setAwesomeness(-8.12);
        em.persist(newPerson);
        em.getTransaction().commit();
    }
    private static void insertAddress(EntityManager em,Person p) {
        em.getTransaction().begin();
        Address newAddress = new Address();
        newAddress.setId(new AddressID(p.getsSSN(),(short)1));
        newAddress.setCountry("Oesterreich");
        newAddress.setCity("Linz");
        newAddress.setStreet("Edmund-Aigner-Straße");
        newAddress.setStreetNo((short)67);
        newAddress.setPerson(p);
        em.persist(newAddress);
        em.getTransaction().commit();
    }

    private static List<Person> getPersonList(EntityManager em) {
        List<Person> p = em.createQuery(
                "SELECT distinct p from Person p " +
                "join Address a on p.SSN = a.id.SSN " +
                "WHERE p.isAwesome = true ORDER BY a.city",Person.class)
                .getResultList();
        return p;
    }

}
