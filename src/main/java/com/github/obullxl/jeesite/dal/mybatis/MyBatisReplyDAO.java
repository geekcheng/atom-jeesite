/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.ReplyDAO;

import com.github.obullxl.jeesite.dal.dto.ReplyDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.ReplyDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Fri Jan 31 19:40:58 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisReplyDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements ReplyDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


	/**
	 *  Insert one <tt>ReplyDTO</tt> object to DB table <tt>atom_reply</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_reply(id,state,topic,title,uname,uemail,usite,content,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param reply
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(ReplyDTO reply) throws DataAccessException{
	Profiler.enter("DAO: ATOM-REPLY.insert");
	try {
    	if (reply == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            reply.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-REPLY.insert", reply);

        return reply.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Query DB table <tt>atom_reply</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_reply where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return ReplyDTO
	 *	@throws DataAccessException
	 */	 
    public ReplyDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-REPLY.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("ATOM-REPLY.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_reply</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_reply</tt>
	 *
	 *	@return List<ReplyDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ReplyDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-REPLY.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-REPLY.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_reply</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_reply where (topic = ?)</tt>
	 *
	 *	@param topic
	 *	@return List<ReplyDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ReplyDTO> findTopic(String topic) throws DataAccessException{
	Profiler.enter("DAO: ATOM-REPLY.findTopic");
	try {

        return this.getSqlSession().selectList("ATOM-REPLY.findTopic", topic);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_reply</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_reply where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-REPLY.delete");
	try {
        Long param = new Long(id);

        return this.getSqlSession().delete("ATOM-REPLY.delete", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_reply</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_reply where (topic = ?)</tt>
	 *
	 *	@param topic
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteTopic(String topic) throws DataAccessException{
	Profiler.enter("DAO: ATOM-REPLY.deleteTopic");
	try {

        return this.getSqlSession().delete("ATOM-REPLY.deleteTopic", topic);
	} finally {
		Profiler.release();
	}
}
}
