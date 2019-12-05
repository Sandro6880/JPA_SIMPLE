package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonPU");
        EntityManager em = factory.createEntityManager();

        //insertPerson(em);

        /*Query query = em.createQuery("select p from Person p");
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
        }*/
        //insertProduct(em);
        //insertOrder(em);
        //insertOrderItems(em);
        Query queryHw = em.createQuery(
                "select oi.amount, sum(oi.amount*p.price),pe.firstName " +
                "from OrderW o " +
                "join OrderItems oi on (oi.order_id = o.id) " +
                "join Product p on (p.product_id = oi.product_id) " +
                "join Person pe on (pe.id = o.ssn)" +
                " group by oi.amount,pe.firstName");



        List<String> result1 = queryHw.getResultList();
        for (String city : result1){
            System.out.println(city);
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
    private static void insertProduct(EntityManager em ){
        em.getTransaction().begin();

        Product newProduct = new Product(1,"Most Awesome Nerf Gun EVER!", BigDecimal.valueOf(100));
        Product newProduct2 = new Product(2,"Most Useless Nerf Gun EVER!", BigDecimal.valueOf(10000));

        em.persist(newProduct);
        em.persist(newProduct2);
        em.getTransaction().commit();
    }
    private static void insertOrder(EntityManager em ){
        em.getTransaction().begin();
        OrderW newOrder = new OrderW(
                "4321020290"
                ,(short)1
                ,Date.valueOf(LocalDate.of(2020,5,29))
                ,(short)1);

        em.persist(newOrder);
        em.getTransaction().commit();
    }
    private static void insertOrderItems(EntityManager em ){
        em.getTransaction().begin();
        OrderItems newOrderItems = new OrderItems(1,1,100);
        OrderItems newOrderItems2 = new OrderItems(1,2,10000);
        em.persist(newOrderItems);
        em.persist(newOrderItems2);
        em.getTransaction().commit();
    }

}
