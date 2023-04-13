package dao;

import system.Ticket;

public class TicketDao extends AbstractJpaDao<Long, Ticket>  {
	
	public TicketDao() {
		this.setClazz(Ticket.class);
	}
}
