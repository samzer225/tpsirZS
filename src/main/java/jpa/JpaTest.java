package jpa;

import system.Commentaire;
import system.Tag;
import system.Ticket;
import system.User;
import system.UserSupportTech;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		JpaTest jpatest = new JpaTest(manager);

		try {
			jpatest.createUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//factory.close();
	}


	/**
	 * @name createUser
	 */
	private void createUser() {
		int numOfUsers = manager.createQuery("Select u From User u", User.class).getResultList().size();
		if (numOfUsers == 0) {
			User user1 = new User("sange@gmail.com","Maurel Serou","sam");
			User user2 = new User("testNom","sam2","sange@gmail.com3");
			manager.persist(user1);
			manager.persist(user2);
			UserSupportTech tech = new UserSupportTech("Zabra Enoch", "Consultant");
			UserSupportTech tech2 = new UserSupportTech("SAM Test", "testeur");
			manager.persist(tech);
			manager.persist(tech2);
			Tag tag = new Tag("testTag","Test Description");
			Ticket ticket = new Ticket("TestSujet", "TestDesc","TestStatut");
			ticket.setUser(user1);
			ticket.getCommentaire();
			ticket.setTag(tag);
			Commentaire commentaire = new Commentaire("Ceci est test");
			commentaire.setUser(user1);
			commentaire.setUser(user2);
			commentaire.setTicket(ticket);
			manager.persist(commentaire);
			manager.persist(tag);
			manager.persist(ticket);

		}
	}

	/**
	 * @name listUser
	 */
	private void listUser() {
		List<User> resultList = manager.createQuery("Select a From User a", User.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (User next : resultList) {
			System.out.println("next employee: " + next);
		}
	}

}