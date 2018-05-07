import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
             Session session = factory.openSession()) {

            Instructor tempInstructor1 = new Instructor("Alexander", "Offych", "off1@gmail.by");
            InstructorDetail tempInstructorDetail1 = new InstructorDetail(
                    "http://youtube.com/Poffych", "Alchogol");

//            //create the Objects
//            Instructor tempInstructor = new Instructor("Alex", "Off", "off@tut.by");
//            InstructorDetail tempInstructorDetail = new InstructorDetail(
//                    "http://youtube.com/Offych", "Table Tennis");

            //associate objects
            tempInstructor1.setInstructorDetail(tempInstructorDetail1);
            //start transaction
            session.beginTransaction();


            //Save the Instructor , it will ALSO save the details object
            //because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor1);

            session.save(tempInstructor1);

            //because of CascadeType.ALL
            System.out.println("Saving Instructor : " + tempInstructor1);
            session.save(tempInstructor1);
            session.getTransaction().commit();
        }
    }
}
