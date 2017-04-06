/*HQL*/

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
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
		user1.setFirstName("Rakesh1");
		user1.setLastName("Kumar1");
		
		User user2 = new User();
		user2.setFirstName("Rakesh2");
		user2.setLastName("Kumar2");
		
		User user3 = new User();
		user3.setFirstName("Rakesh3");
		user3.setLastName("Kumar3");
		
		User user4 = new User();
		user4.setFirstName("Rakesh4");
		user4.setLastName("Kumar4");
		
		User user5 = new User();
		user5.setFirstName("Rakesh5");
		user5.setLastName("Kumar5");
			
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.save(user3);
		session.save(user4);
		session.save(user5);
		transaction.commit();
		session.close();

		session = factory.openSession();
		transaction = session.beginTransaction();
		/*1*/
		Query qry = session.createQuery("from User");
		List list = qry.list();
		System.out.println("list size: " + list.size());
		
		/*2*/
//		Query qry = session.createQuery("from User u where u.firstName = 'Rakesh2'");
//		List list = qry.list();
//		for(Object o : list)
//		{
//			User u = (User)o;
//			System.out.println("FirstName: " + u.getFirstName());
//			System.out.println("LastName: " + u.getLastName());
//		}
				
		/*3*/
//		Query qry = session.createQuery("select u.lastName from User u where u.firstName = 'Rakesh2'");
//		List list = qry.list();
//		for(Object o : list)
//		{
//			String strLastName = o.toString();
//			System.out.println("LastName: " + strLastName);
//		}

		/*3.1*/
//		Query qry = session.createQuery("select new map(u.id, u.lastName) from User u where u.firstName = 'Rakesh2'");
//		List list = qry.list();
//		for(Object o : list)
//		{
//			Map mp = (Map)o;
//			System.out.println(mp.toString());
//		}

		/*3.2*/
//		Query qry = session.createQuery("select max(u.id) from User u");
//		List list = qry.list();
//		System.out.println(list.toString());
		
		/*4 - pagination*/
//		Query qry = session.createQuery("select u.lastName from User u");
//		qry.setFirstResult(2);
//		qry.setMaxResults(2);
//		List list = qry.list();
//		for(Object o : list)
//		{
//			String strLastName = o.toString();
//			System.out.println("LastName: " + strLastName);
//		}
		
		/*5 - parameter binding - position parameter*/
//		Query qry = session.createQuery("select u.lastName from User u where u.firstName = ?");
//		qry.setString(0, "Rakesh2");
//		List list = qry.list();
//		for(Object o : list)
//		{
//			String strLastName = o.toString();
//			System.out.println("LastName: " + strLastName);
//		}
		
		/*6  - parameter binding - position parameter*/
//		Query qry = session.createQuery("select u.lastName from User u where u.lastName = ? and u.firstName = ?");
//		qry.setString(0, "Kumar2");
//		qry.setString(1, "Rakesh2");
//		List list = qry.list();
//		for(Object o : list)
//		{
//			String strLastName = o.toString();
//			System.out.println("LastName: " + strLastName);
//		}

		/*7 - parameter binding - named parameter*/
//		Query qry = session.createQuery("select u.lastName from User u where u.lastName = :lst and u.firstName = :fir");
//		qry.setString("lst", "Kumar2");
//		qry.setString("fir", "Rakesh2");
//		List list = qry.list();
//		for(Object o : list)
//		{
//			String strLastName = o.toString();
//			System.out.println("LastName: " + strLastName);
//		}
		
		
//		
//		/*Using '?' and ':' is as shown in the above examples is better than passing parameters directly like shown below. The below method
//		 * is vulnerable to SQL injections like explained in comment below.
//		 */
//		String param = "'Rakesh2'";
//		/* Instead of the above value assigned to 'param', if you assign a value which contains some other
//		 * always-true condition with an 'or', it will run for all conditions, ignoring the intended condition
//		 * as shown here: String param = "'Rakesh2' or 1=1";
//		 */
//		Query qry = session.createQuery("select u.lastName from User u where u.firstName = " + param);
//		List list = qry.list();
//		for(Object o : list)
//		{
//			String strLastName = o.toString();
//			System.out.println("LastName: " + strLastName);
//		}
//		

		transaction.commit();
		session.close();
	}
}