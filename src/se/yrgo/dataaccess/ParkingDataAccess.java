package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;


import se.yrgo.domain.ParkingTicket;
import se.yrgo.exceptions.ParkingTicketAlreadyExistsException;
import se.yrgo.exceptions.ParkingTicketDoesNotExistException;
import se.yrgo.exceptions.StorageAccessException;

@Local
public interface ParkingDataAccess {
	public List<ParkingTicket> getAllParkingTickets();
	public List<ParkingTicket> getCarsbyId(int id);
	public void createTicket(ParkingTicket ticket) throws ParkingTicketAlreadyExistsException, StorageAccessException;
	public boolean deleteTicket(int ticketId) throws StorageAccessException;
	public ParkingTicket findTicketById(int ticketId) throws StorageAccessException;
	public void updateTicket(ParkingTicket newTicket) throws StorageAccessException, ParkingTicketDoesNotExistException;;
}
