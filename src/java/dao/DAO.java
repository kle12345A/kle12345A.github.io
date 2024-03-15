/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.Shipping;

import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trinh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //------------------------------------about product----------------------------------
    public Vector<Product> getAllProduct() {
        Vector<Product> list = new Vector<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Product> getTop3() {
        Vector<Product> list = new Vector<>();
        String query = "select top 3 * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Product> getProductByCID(String cid) {
        Vector<Product> list = new Vector<>();
        String query = "select * from product\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //day thong tin ban hang 
    public Vector<Product> getProductBySellID(int id) {
        Vector<Product> list = new Vector<>();
        String query = "select * from product\n"
                + "where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Product> searchByName(String txtSearch) {
        Vector<Product> list = new Vector<>();
        String query = "select * from product\n"
                + "where [name] like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
public Product getProductByName(String productName) {
    Product pt = null; // Khai báo đối tượng Product ở bên ngoài khối try
    String query = "SELECT * FROM product WHERE [name] = ?";
    try {
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        ps.setString(1, productName);
        rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String image = rs.getString("image");
            double price = rs.getDouble("price");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String category = rs.getString("cateID");
            int sellerId = rs.getInt("sell_ID");
            pt = new Product(id, name, image, price, title, description);
        }
    } catch (Exception e) {
        e.printStackTrace();
    
    }
    return pt; // Trả về đối tượng Product
}

   public Product getProductById(int productId) {
        try {
            String sql = "select *  from Product where id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImage(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTitle(rs.getString(5));
                product.setDescription(rs.getString(6));
               
               
                return product;
            }
        } catch (Exception ex) {
           
        }
        return null;
    }

    public Product getLast() {
        String query = "select top 1 * from product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteProduct(String pid) {
        String query = "delete from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //them 
    public void insertProduct(String name, String image, String price,
            String title, String description, String category, int sid) {
        String query = "INSERT [dbo].[product] \n"
                + "([name], [image], [price], [title], [description], [cateID], [sell_ID])\n"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price,
            String title, String description, String category, String pid) {
        String query = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //Dem so luong account trrong database
    public int getTotalProduct() {
        String sql = "select count(*) from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public Vector<Product> pagingProduct(int index) {
        Vector<Product> vector = new Vector<>();
        String sql = "select *from product\n"
                + "order by id\n"
                + "offset ? rows fetch next 5 rows ONLY;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                vector.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));

            }
        } catch (Exception e) {
        }
        return vector;

    }

    public Vector<Product> getProductsWithPagging(int page, int PAGE_SIZE) {
        Vector<Product> list = new Vector<>();
        try {
            String sql = "select *  from Product order by id\n"
                    + "offset (?-1)*? row fetch next ? rows only";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImage(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTitle(rs.getString(5));
                product.setDescription(rs.getString(6));

                list.add(product);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    //---------------------------------------------------------ABOUT CATEGORY
    public Vector<Category> getAllCategory() {
        Vector<Category> list = new Vector<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertCategory(String name) {
        String sql = "INSERT INTO [Category]\n"
                + "           ([cname])\n"
                + "     VALUES\n"
                + "           (?)";
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public Vector<Category> getAllCategoriesByPage(int page, int PAGE_SIZE) {
        Vector<Category> list = new Vector<>();
        String sql = "select * from Category "
                + "order by cid\n"
                + "offset (?-1)*? row fetch next ? rows only";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCid(rs.getInt(1));
                category.setCname(rs.getString(2));
                list.add(category);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public void updateCategory(Category category) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [cname] = ?\n"
                + " WHERE cid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getCname());
            ps.setInt(2, category.getCid());
            ps.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public void deleteCategory(int id) {
        String sql = "DELETE FROM [Category] \n"
                + "  WHERE [cid] = ?";
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public Category getCategoryById(int id) {
        try {
            String sql = "select *  from Category where cid = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category a = new Category();
                a.setCid(rs.getInt(1));
                a.setCname(rs.getString(2));
                return a;
            }
        } catch (Exception ex) {

        }
        return null;
    }

    //-------------------------------------------------------------ABOUT ACCOUNT
    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
public boolean checkProductNameExists(String productName) {
    String query = "SELECT COUNT(*) FROM product WHERE [name] = ?";
    try {
        conn = new DBContext().getConnection(); // Mở kết nối với cơ sở dữ liệu
        ps = conn.prepareStatement(query);
        ps.setString(1, productName);
        rs = ps.executeQuery();
        
        // Lấy kết quả từ truy vấn
        if (rs.next()) {
            int count = rs.getInt(1);
            // Nếu số lượng sản phẩm có tên trùng khớp là lớn hơn 0, tức là sản phẩm đã tồn tại
            return count > 0;
        }
    } catch (Exception e) {
        e.printStackTrace(); // Xử lý ngoại lệ nếu có
    }
    return false; // Trả về false nếu có lỗi xảy ra hoặc không tìm thấy sản phẩm
}

    public Account checkAccountExist(String user) {
        String query = "select * from account\n"
                + "where [user] = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String user, String pass) {
        String query = "insert into account\n"
                + "values(?,?,0,0)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteAccount(String uID) {
        String sql = "delete from account where uID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, uID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Vector<Account> getAllAccount() {
        Vector<Account> vector = new Vector<>();
        String sql = "select *from account ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                vector.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }

        } catch (Exception e) {

        }
        return vector;
    }

    public Vector<Account> getAllAccountByPage(int page, int PAGE_SIZE) {
        Vector<Account> list = new Vector<>();
        try {
            String sql = "SELECT * FROM Account where isAdmin != 1"
                    + " order by uID\n"
                    + "offset (?-1)*? row fetch next ? rows only";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setUser(rs.getString(2));
                account.setPass(rs.getString(3));
                account.setIsSell(rs.getInt(4));
                account.setIsAdmin(rs.getInt(5));

                list.add(account);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public int getTotalAccount() {
        Vector<Account> list = new Vector<>();
        try {
            String sql = "SELECT * FROM Account where isAdmin != 1";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setUser(rs.getString(2));
                account.setPass(rs.getString(3));
                account.setIsSell(rs.getInt(4));
                account.setIsAdmin(rs.getInt(5));

                list.add(account);
            }
        } catch (Exception ex) {

        }
        return list.size();
    }

    //-----------------------------------------------------------------------SHIPPING
    public int createReturnId(Shipping shipping) {
        try {
            String sql = "INSERT INTO [dbo].[Shipping]\n"
                    + "           ([name]\n"
                    + "           ,[phone]\n"
                    + "           ,[address])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, shipping.getName());
            ps.setString(2, shipping.getPhone());
            ps.setString(3, shipping.getAddress());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {

        }
        return 0;
    }
    //---------------------------Order

    public int createReturnId(Order order) {
        try {
            String sql = "INSERT INTO [dbo].[Orders]\n"
                    + "           ([account_id]\n"
                    + "           ,[totalPrice]\n"
                    + "           ,[note]\n"
                    + "           ,[shipping_id])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, order.getAccountId());
            ps.setDouble(2, order.getTotalPrice());
            ps.setString(3, order.getNote());
            ps.setInt(4, order.getShippingId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception ex) {

        }
        return 0;
    }

    public List<Order> getAllOrder() {
        List<Order> Orders = new ArrayList<>();
        try {
            String sql = "select * from [Orders]";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));
                order.setAccountId(rs.getInt(2));
                order.setTotalPrice(rs.getDouble(3));
                order.setNote(rs.getString(4));
                order.setCreatedDate(rs.getString(5));
                order.setShippingId(rs.getInt(6));

                Orders.add(order);
            }
        } catch (Exception ex) {
         
        }
        return Orders;
    }
    
    //----------------------------------------------------------------------------Orderdetail
    public void saveCart(int orderId, Map<Integer, Cart> carts) {
        try {

            String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                    + "           ([order_id]\n"
                    + "           ,[productName]\n"
                    + "           ,[productImage]\n"
                    + "           ,[productPrice]\n"
                    + "           ,[quantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";
           conn = new DBContext().getConnection();
           ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer productId = entry.getKey();
                Cart cart = entry.getValue();
                ps.setString(2, cart.getProduct().getName());
                ps.setString(3, cart.getProduct().getImage());
                ps.setDouble(4, cart.getProduct().getPrice());
                ps.setDouble(5, cart.getQuantity());
                ps.executeUpdate();
            }

        } catch (Exception ex) {
           
        }
    }

    public Vector<OrderDetail> getAllOrderDetailById(int id) {
       Vector<OrderDetail> OrderDetails = new Vector<>();
        try {
            String sql = "SELECT * FROM OrderDetail Where order_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail order = new OrderDetail();
                order.setId(rs.getInt(1));
                order.setOrderId(rs.getInt(2));
                order.setProductName(rs.getString(3));
                order.setProductImage(rs.getString(4));
                order.setProductPrice(rs.getDouble(5));
                order.setQuantity(rs.getInt(6));

                OrderDetails.add(order);
            }
        } catch (Exception ex) {
           
        }
        return OrderDetails;
    }

    public void delete(int id) {

        try {

            String sql = "DELETE FROM [OrderDetail]\n"
                    + "      WHERE id = ?";
           conn = new DBContext().getConnection();
           ps =  conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Vector<Account> accounts = dao.getAllAccount();
        dao.deleteAccount("16");
        for (Account account : accounts) {
            System.out.println(account);

        }

    }

}
