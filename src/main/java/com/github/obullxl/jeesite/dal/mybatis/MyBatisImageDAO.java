/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.ImageDAO;

import com.github.obullxl.jeesite.dal.dto.ImageDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.ticket.fmt.TicketEncode;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.ImageDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Fri Jan 31 19:40:58 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisImageDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements ImageDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }

	/** Ticket Encoder */
	private TicketEncode ticketEncode;
	
	public void setTicketEncode(TicketEncode ticketEncode) {
		this.ticketEncode = ticketEncode;
	}

	/**
	 *  Insert one <tt>ImageDTO</tt> object to DB table <tt>atom_image</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_image(id,flag,topic,title,size,width,height,url,summary,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param image
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(ImageDTO image) throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.insert");
	try {
    	if (image == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            image.setId(this.ticketEncode.encode(this.ticketService.nextValue()));
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-IMAGE.insert", image);

        return image.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Update DB table <tt>atom_image</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_image set flag=?, topic=?, title=?, size=?, width=?, height=?, url=?, summary=? where (id = ?)</tt>
	 *
	 *	@param image
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(ImageDTO image) throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.update");
	try {
    	if (image == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("ATOM-IMAGE.update", image);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_image</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_image set flag='FLAG', url='URL' where (id = 'ID')</tt>
	 *
	 *	@param image
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateUrl(ImageDTO image) throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.updateUrl");
	try {
    	if (image == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("ATOM-IMAGE.updateUrl", image);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_image</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_image where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return ImageDTO
	 *	@throws DataAccessException
	 */	 
    public ImageDTO find(String id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.find");
	try {

        return this.getSqlSession().selectOne("ATOM-IMAGE.find", id);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_image</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_image</tt>
	 *
	 *	@return List<ImageDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ImageDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-IMAGE.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_image</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_image where (topic = ?)</tt>
	 *
	 *	@param topic
	 *	@return List<ImageDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ImageDTO> findTopic(String topic) throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.findTopic");
	try {

        return this.getSqlSession().selectList("ATOM-IMAGE.findTopic", topic);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_image</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_image where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.delete");
	try {

        return this.getSqlSession().delete("ATOM-IMAGE.delete", id);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_image</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_image where (topic = ?)</tt>
	 *
	 *	@param topic
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteTopic(String topic) throws DataAccessException{
	Profiler.enter("DAO: ATOM-IMAGE.deleteTopic");
	try {

        return this.getSqlSession().delete("ATOM-IMAGE.deleteTopic", topic);
	} finally {
		Profiler.release();
	}
}
}
