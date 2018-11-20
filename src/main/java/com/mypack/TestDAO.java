package com.mypack;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessException.*; 
import org.springframework.jdbc.core.ResultSetExtractor;  

public class TestDAO// implements DaoInter
{
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int saveData(Employee e)
	{
		System.out.println("in save data..");
		String query="insert into Data values('"+e.getFname()+"','"+e.getLname()+"')";
		return jdbcTemplate.update(query);
	}
	
	public List<Employee> getAllEmployees(){  
		 return jdbcTemplate.query("select * from Data",new ResultSetExtractor<List<Employee>>(){  
		    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {    
		        List<Employee> list=new ArrayList<Employee>();  
		        while(rs.next()){  
		        Employee e=new Employee();  
		        e.setFname(rs.getString(1));  
		        e.setLname(rs.getString(2));  
		        list.add(e);  
		        }  
		        return list;  
		        }  
		 });  
	 }  
	
	public int update(Employee p){  
	    String sql="update Data set lname='"+p.getLname()+"' where fname="+p.getFname()+"";  
	    return jdbcTemplate.update(sql);  
	}  
	
	public int delete(String fname){  
	    String sql="delete from Data where fname="+fname+"";  
	    return jdbcTemplate.update(sql);  
	}  
	
	public Employee getEmpByFname(String fname){  
	    String sql="select * from Emp99 where fname=?";  
	    return jdbcTemplate.queryForObject(sql, new Object[]{fname},new BeanPropertyRowMapper<Employee>(Employee.class));  
	}  
	
	/*public Boolean getEmployee(final Employee e){  
	    String query="select * from Data where fname=?";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {  
	        ps.setString(2,e.getFname());   
	        
	        return ps.execute();  
	    }
	    });  
	}  */
}  