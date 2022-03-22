package com.StudentManagementDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.StudentManagementDTO.ClassRequestDTO;
import com.StudentManagementDTO.ClassResponseDTO;


public class ClassDAO {
	
	public static Connection con = null;

	static {
		con = MyConnection.getConnection();

	}
	public int insertData(ClassRequestDTO dto) {
		int result=0;
		String sql="insert into class(id,name) values(?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2,dto.getName());
			result =ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public List<ClassResponseDTO> select(ClassRequestDTO dto) {
		List<ClassResponseDTO> list = new ArrayList<ClassResponseDTO>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from class");
			if (!dto.getId().equals("") || !dto.getName().equals("")) {
				ps = con.prepareStatement("select * from class where id=? or name=?");
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getName());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ClassResponseDTO res = new ClassResponseDTO();
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));
				list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<ClassResponseDTO> selectAll() {
		List<ClassResponseDTO> list = new ArrayList<ClassResponseDTO>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from class");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ClassResponseDTO res = new ClassResponseDTO();
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));
				list.add(res);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

}
