package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ACER
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        return list;
    }

    public void insert(Category c) {
        String sql = "INSERT INTO [dbo].[Categories]"
                + "           ([ID]"
                + "           ,[name]"
                + "           ,[describe])"
                + "     VALUES"
                + "           (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getName());
            st.setString(3, c.getDescribe());

            st.executeUpdate();
            System.out.println("thanh cong");
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public Category getCategoryID(int id) {
        String sql = "select * from Categories where ID=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("describe"));
                return c;
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        return null;
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Categories]"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
//            System.out.print(e);
        }
    }

    public void update(Category c) {
        String sql = "UPDATE [dbo].[Categories]"
                + " SET [name] = ?,[describe] = ?"
                + " WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1, c.getName());
            st.setString(2, c.getDescribe());
            st.setInt(3, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("update thanh cong");
        }
    }

    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<Category> list = c.getAll();
        System.out.println(list.get(0).getName());
    }

}
