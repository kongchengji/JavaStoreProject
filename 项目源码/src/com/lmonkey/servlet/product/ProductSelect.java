package com.lmonkey.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class ProductSelect
 */
@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<LMONKEY_PRODUCT>  plist = LMONKEY_PRODUCTDao.selectAll();
		
		request.setAttribute("plist", plist);
		
		
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
	}



}
