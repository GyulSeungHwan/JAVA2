package com.yedam.departments;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class DepDAO extends DAO {
	
	private static DepDAO depDao = null;
	
	private DepDAO() {
		
	}
	
	public static DepDAO getInstance() {
		if(depDao == null) {
			depDao = new DepDAO();
		}
		return depDao;
	}
	
	
	public List<DepDTO> getDepartmentsList(){
		List<DepDTO> list = new ArrayList<>();
		DepDTO dep = null;
		
		try {
			conn();
			String sql = "SELECT * FROM departments";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				dep = new DepDTO();
				
				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));
				
				list.add(dep);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public DepDTO getDepartMent(int departmentId) {
		DepDTO dep = null;
		try {
			conn();
			
			String sql = "SELECT * FROM departments"
					+ " WHERE department_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dep = new DepDTO();
				
				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return dep;
	}
	
	public int depAdd(DepDTO dep) {
		int result = 0;
		try {
			conn();
			String sql = "update departments set "
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconn();
		}
	}
	
}
