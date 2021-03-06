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
		vehicle1.setVeh_id(120);
		vehicle1.setModel("i10");
		vehicle1.setRegNumber(5431);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVeh_id(130);
		vehicle2.setModel("maruthi 800");
		vehicle2.setRegNumber(3409);
		
//		user1.getVehicles().add(vehicle1);
//		user1.getVehicles().add(vehicle2);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);
		transaction.commit();
		session.close();
		
		session = factory.openSession();
		transaction = session.beginTransaction();
		Vehicle veh = (Vehicle) session.get(Vehicle.class, 120);
		User us = veh.getUser();
		System.out.println("User: " + us.getFirstName());
		transaction.commit();
		session.close();
	}
}