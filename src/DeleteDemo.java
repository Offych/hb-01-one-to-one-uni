import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
             Session session = factory.openSession()) {


            //start transaction
            session.beginTransaction();


            //get Instructor by primary key
         //   int theId=1;
          //  Instructor tempInstructor = session.get(Instructor.class, theId);

           // System.out.println("Found Insructor: " + tempInstructor);

            //delete the insructors

          //  if(tempInstructor !=null) {
          //      System.out.println("Deleting: " + tempInstructor);

                //+delete from instructor_Detail table because CascadeType.All
              //  session.delete(tempInstructor);
        //    }

            session.createQuery("delete from Instructor where id=2").executeUpdate();

            //commit transaction
            session.getTransaction().commit();
        }
    }
}
