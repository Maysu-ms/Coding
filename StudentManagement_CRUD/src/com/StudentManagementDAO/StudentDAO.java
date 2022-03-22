package com.StudentManagementDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.StudentManagementDTO.StudentRequestDTO;
import com.StudentManagementDTO.StudentResponseDTO;




public class StudentDAO {
	static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public int insert(StudentRequestDTO dto) {
		int result = 0;
		String sql = "insert into student (student_id,student_name,class_name,register_date,status) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getStudentId());
			ps.setString(2, dto.getStudentName());
			ps.setString(3, dto.getClassName());
			ps.setString(4, dto.getRegisterDate());
			ps.setString(5, dto.getStatus());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(StudentRequestDTO dto) {
		int result = 0;
		String sql = "update student set student_name=?,class_name=?,register_date=?,status=? where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(5, dto.getStudentId());
			ps.setString(1, dto.getStudentName());
			ps.setString(2, dto.getClassName());
			ps.setString(3, dto.getRegisterDate());
			ps.setString(4, dto.getStatus());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int delete(StudentRequestDTO dto) {
		int result = 0;
		String sql = "delete from student where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getStudentId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<StudentResponseDTO> select(StudentRequestDTO dto) {
		List<StudentResponseDTO> list = new ArrayList<StudentResponseDTO>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from student");
			if (!dto.getStudentId().equals("")) {
				ps = con.prepareStatement("select * from student where student_id=?");
				ps.setString(1, dto.getStudentId());
			} else if (!dto.getStudentName().equals("") || !dto.getClassName().equals("")) {
				ps = con.prepareStatement("select * from student where student_name=? or class_name=?");
				ps.setString(1, dto.getStudentName());
				ps.setString(2, dto.getClassName());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentResponseDTO res = new StudentResponseDTO();
				res.setStudentId(rs.getString("student_id"));
				res.setStudentName(rs.getString("student_name"));
				res.setClassName(rs.getString("class_name"));
				res.setRegisterDate(rs.getString("register_date"));
				res.setStatus(rs.getString("status"));
				list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
