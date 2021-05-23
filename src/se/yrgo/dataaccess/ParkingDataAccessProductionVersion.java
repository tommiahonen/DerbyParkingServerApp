package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import se.yrgo.domain.ParkingTicketAlreadyExistsException;
import se.yrgo.domain.StorageException;
import se.yrgo.domain.ParkingTicket;

@Stateless
@Default
public class ParkingDataAccessProductionVersion implements ParkingDataAccess {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ParkingTicket> getAllParkingTickets() {
		Query q = em.createQuery("select ticket from Ticket ticket");
		List<ParkingTicket> tickets = q.getResultList();
		return tickets;
	}
	
	@Override
	public List<ParkingTicket> getCarsbyId(int id) {
		Query q = em.createQuery("select car from Car car where car.id = :carId");
		q.setParameter("carId", id);
		return q.getResultList();
	}

	@Override
<<<<<<< HEAD
	public void createTicket(ParkingTicket ticket) throws ParkingTicketAlreadyExistsException, StorageException {
		
		System.out.printf("Now creating new ParkingTicket %s in database.", ticket);
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		try {
			//Sem.persist(ticket);
		} catch (EntityExistsException ex) {
			throw new ParkingTicketAlreadyExistsException(ex);
		} catch (Exception ex) {
			throw new StorageException("Error: Unable to store new ticket in database", ex);
		}
		// TODO: Remove once database query has been implemented
		throw new StorageException("Error: Unable to store new ticket in database");
		//tx.commit();
		//em.close();
=======
	public void createTicket(ParkingTicket ticket) {
		em.persist(ticket);
>>>>>>> 45c0515301153c6a1127391dbcd78139458c576e
		
	}

	@Override
	public void deleteTicket(int ticketId) {
		em.remove(ticketId);
		
	}

	@Override
	public ParkingTicket findTicketById(int ticketId) {
		Query q = em.createQuery("select parkingticket from Parkingticket parkingticket where parkingticket.id = :parkingticketId");
		q.setParameter("parkingticketId", ticketId);
		return (ParkingTicket)q.getResultList();
	}
	
}