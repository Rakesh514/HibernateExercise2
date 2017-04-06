import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateMain {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {

			factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
		}

		User user1 = new User();
		user1.setFirstName("Rakesh");
		user1.setLastName("Kumar");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setModel("i10");
		vehicle1.setRegNumber(5431);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setModel("maruthi 800");
		vehicle2.setRegNumber(3409);
		
//		Uncommenting the below lines does not make any difference
//		vehicle1.setUser(user1);
//		vehicle2.setUser(user1);
		
		user1.getVehicles().add(vehicle1);
		user1.getVehicles().add(vehicle2);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);
		transaction.commit();
		session.close();
	}
}