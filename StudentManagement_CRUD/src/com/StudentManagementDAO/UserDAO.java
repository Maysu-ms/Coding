package com.StudentManagementDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.StudentManagementDTO.UserRequestDTO;
import com.StudentManagementDTO.UserResponseDTO;


public class UserDAO {

	public static Connection con = null;

	static {
		con = MyConnection.getConnection();

	}

	public boolean loginAcceess(UserRequestDTO dto) {
		boolean b = false;
		String sql = "select * from user where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			//ps.setString(2, dto.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (dto.getId().equals(rs.getString("id")) && dto.getPassword().equals(rs.getString("password"))) {
					dto.setName(rs.getString("name"));
					b = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
public int insertData(UserRequestDTO dto) {
	int result=0;
	String sql="insert into user(id,name,password) values(?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getPassword());
		result =ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return result;
}

public ArrayList<UserResponseDTO> select(UserRequestDTO dto){
	ArrayList<UserResponseDTO> list=new ArrayList<UserResponseDTO>();
	
	
	String selectID="select * from user where id=?";
	String selectsearch="select * from user where name=?";
	String selectAll="select * from user";
	
	try {
		PreparedStatement ps=con.prepareStatement(selectAll);
		if(!dto.getId().equals("")) {
			ps=con.prepareStatement(selectID);
			ps.setString(1, dto.getId());
			
		}else if(!dto.getName().equals("")) {
			ps=con.prepareStatement(selectsearch);
			ps.setString(1, dto.getName());
		}
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			UserResponseDTO res=new UserResponseDTO();
			res.setId(rs.getString("id"));
			res.setName(rs.getString("name"));
			res.setPassword(rs.getString("password"));
			list.add(res);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;

}

public int update(UserRequestDTO dto) {
	int result=0;
	String sql="update user set name=?,password=? where id=?";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getPassword());
		ps.setString(3,dto.getId());
		result=ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return result;
}
public int  delete(UserRequestDTO dto) {
	int result=0;
	String sql="delete from user where id=?";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,dto.getId());
		result=ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
	
}


	

}
