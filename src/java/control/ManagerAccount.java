/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;


@WebServlet(name="ManagerAccount", urlPatterns={"/manageraccount"})
public class ManagerAccount extends HttpServlet {
   
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("acc") != null) {
            
            DAO acountDBContext = new DAO();
            // page
            final int PAGE_SIZE = 10;
            int page = 1;
            String pageStr = request.getParameter("page");
            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }
            if (page < 1) {
                page = 1;
            }
            // lấy số lượng account
            int totalAccount = acountDBContext.getTotalAccount();
            int totalPage = totalAccount / PAGE_SIZE;
            if (totalAccount % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            if (page > totalPage) {
                page = totalPage;
            }
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            Vector<Account> accounts =  new DAO().getAllAccountByPage(page, PAGE_SIZE);
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
