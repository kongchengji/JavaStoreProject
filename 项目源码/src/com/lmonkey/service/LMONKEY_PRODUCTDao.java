package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;


public class LMONKEY_PRODUCTDao {
	
	public static int insert(LMONKEY_PRODUCT p) {
		String sql = "insert into LMONKEY_PRODUCT values(null, ?, ?,?,?,?,?,?)";
		
		
		Object[] params = {
					p.getPRODUCT_NAME(),
					p.getPRODUCT_DESCRIPTION(),
					p.getPRODUCT_PRICE(),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_FID(),
					p.getPRODUCT_CID(),
					p.getPRODUCT_FILENAME()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static ArrayList<LMONKEY_PRODUCT> selectAll() {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from LMONKEY_PRODUCT";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	
	public static LMONKEY_PRODUCT selectById(int id) {
		LMONKEY_PRODUCT p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return p;
	}
	
	public static ArrayList<LMONKEY_PRODUCT> selectAllByFid(int fid) {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_FID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<LMONKEY_PRODUCT> selectAllByCid(int cid) {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_CID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<LMONKEY_PRODUCT> selectAllById(ArrayList<Integer> ids) {
		ArrayList<LMONKEY_PRODUCT> lastlylist = new ArrayList<LMONKEY_PRODUCT>();
		
		 LMONKEY_PRODUCT p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
		    for(int i=0; i<ids.size(); i++) {
			
				String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ids.get(i));
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 p = new LMONKEY_PRODUCT(
							 	rs.getInt("PRODUCT_ID"),
							 	rs.getString("PRODUCT_NAME"),
							 	rs.getString("PRODUCT_DESCRIPTION"),
							 	rs.getInt("PRODUCT_PRICE"),
							 	rs.getInt("PRODUCT_STOCK"),
							 	rs.getInt("PRODUCT_FID"),
							 	rs.getInt("PRODUCT_CID"),
							 	rs.getString("PRODUCT_FILENAME")
							 );
					 
					 
					 lastlylist.add(p);
					 
				 }
		    }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return lastlylist;
	}
}
