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

        //insertPerson(em);

        Query query = em.createQuery("select p from Person p");
        List<Person> result = query.getResultList();
        for (Person p : result){
            System.out.println(p.getsSSN() + ": " + p.getFirstName() + " " + p.getLastName());
        }

        Query query1 = em.createQuery("select distinct a.city from Person p join p.addresses a where p.isAwesome = true order by a.city");
        List<String> result1 = query1.getResultList();
        for (String city : result1){
            System.out.println(city);
        }
        Query query2 = em.createQuery("select NEW demo.AwesomePeopleCount(p.isAwesome, count(p.SSN)) from Person p group by p.isAwesome");
        List<AwesomePeopleCount> result2 = query2.getResultList();
        for (AwesomePeopleCount apc : result2){
            System.out.println(apc.isAwesome() + ": " + apc.getCount());
        }

        em.close();
        factory.close();
    }

    private static void insertPerson(EntityManager em ){
        em.getTransaction().begin();

        Person newPerson = new Person();
        newPerson.setsSSN("5555050670");
        newPerson.setFirstName("Java");
        newPerson.setLastName("Student");
        newPerson.setDateOfBirth(Date.from(LocalDate.of(1970,6,5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        newPerson.setAwesome(false);
        newPerson.setAwesomeness(-8.12);

        AddressId id = new AddressId();
        id.setPerson(newPerson);
        id.setAddressNo((short) 1);
        Address newAddress = new Address();
        newAddress.setId(id);
        newAddress.setCountry("Austria");
        newAddress.setCity("Leonding");
        newAddress.setStreet("Limesstr.");
        newAddress.setStreetNo((short) 12);
        newPerson.getAddresses().add(newAddress);

        em.persist(newPerson);
        em.getTransaction().commit();
    }
}
