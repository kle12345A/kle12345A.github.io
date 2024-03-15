/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import entity.Account;
import entity.Category;
import entity.Order;
import entity.Product;
import java.util.List;
import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class DAOTest {
    DAO dao= new DAO();
    public DAOTest() {
    }

    @Test
    public void testGetAllProductNotEmpty() {
        DAO productDAO = new DAO();
        Vector<Product> productList = productDAO.getAllProduct();
        assertFalse("thanh cong", productList.isEmpty());
    }

    @Test
    public void testGetAllProductCorrectSize() {
        DAO productDAO = new DAO();
        Vector<Product> productList = productDAO.getAllProduct();
        int expectedSize = 10; 
        assertEquals("thanh cong", expectedSize, productList.size());
    }


    @Test
    public void testGetAllProductWhenDatabaseIsEmpty() {
        DAO productDAO = new DAO();
        Vector<Product> productList = productDAO.getAllProduct();
        assertTrue("thanh cong", productList.isEmpty());
    }

 

   @Test
    public void testLoginSuccess() {
        DAO accountDAO = new DAO();
        String validUsername = "admin";
        String validPassword = "123";
        Account loggedInAccount = accountDAO.login(validUsername, validPassword);
        assertNotNull("Account da ton tai trong database ", loggedInAccount);
    }

    @Test
    public void testLoginFailure() {
        DAO accountDAO = new DAO();
        String invalidUsername = "adm";
        String invalidPassword = "123";
        Account loggedInAccount = accountDAO.login(invalidUsername, invalidPassword);
        assertNull("Account 0 ton tai trong database", loggedInAccount);
    }
    @Test
public void testLoginUsernameNotExist() {
    DAO accountDAO = new DAO();
    String nonExistentUsername = "nonexistent";
    String anyPassword = "123";
    Account loggedInAccount = accountDAO.login(nonExistentUsername, anyPassword);
    assertNull("tai khoan khong ton tai trong database", loggedInAccount);
}
@Test
public void testLoginIncorrectPassword() {
    DAO accountDAO = new DAO();
    String validUsername = "admin";
    String incorrectPassword = "wrongpassword";
    Account loggedInAccount = accountDAO.login(validUsername, incorrectPassword);
    assertNull("tai khoan khong ton tai trong database", loggedInAccount);
}




    @Test
    public void testGetTop3() {
        Vector<Product> top3Products = dao.getTop3();

        assertNotNull("danh sach top3 product", top3Products);
    }


 @Test
public void testSearchByName() {
    String nameToSearch = "hoa";

    Vector<Product> searchResults = dao.searchByName(nameToSearch);
    assertFalse("Khong tim thay san pham  ", searchResults.isEmpty());
}
//tim nx san pham bat dau bang chu h va kiem tra so luong san pham ben trong
@Test
public void testSearchByName1() {
    String nameToSearch = "h";
    int expectedNumberOfResults = 3; 

    Vector<Product> searchResults = dao.searchByName(nameToSearch);
   assertFalse("khong tim thay san pham ", searchResults.isEmpty());

    // Kiểm tra xem số lượng sản phẩm trong danh sách có phải là số lượng mong đợi không
    assertEquals("so luong san pham khong dung ", expectedNumberOfResults, searchResults.size());
}



@Test
public void testGetProductByCID1() {
    // ID của danh mục sản phẩm cần tìm kiếm
    String categoryId = "1"; // Ví dụ: danh mục có ID là 1

    Vector<Product> products = dao.getProductByCID(categoryId);
    assertNotNull("danh sach san pham not null", products);

}
@Test
public void testGetProductByID1() {
   int Id = 100;
    Product products = dao.getProductById(Id);
    assertNull("doi tuong ton tai", products);
}
@Test
public void testGetProductByID2() {
   int Id = 1;
    Product products = dao.getProductById(Id);
    assertNull("doi tuong ton tai", products);
}


    @Test
public void testDeleteProduct() {
    // ID của sản phẩm cần xóa
  String productId = "1"; // Ví dụ: sản phẩm có ID là 1

    // Gọi phương thức deleteProduct() của đối tượng DAO
    dao.deleteProduct(productId);

    // Kiểm tra xem sản phẩm có còn tồn tại trong cơ sở dữ liệu không
    assertNull("khong ton tai san pham ", dao.getProductById(Integer.parseInt(productId)));
}
@Test
public void testDeleteNonExistingProduct() {
    // ID của sản phẩm không tồn tại
    String nonExistingProductId = "9999";
    dao.deleteProduct(nonExistingProductId);

    // Kiểm tra xem phương thức đã xử lý đúng khi cố gắng xóa một sản phẩm không tồn tại
    // Bằng cách kiểm tra xem sản phẩm với ID không tồn tại có là null hay không
    assertNull("0 ton tai san pham", dao.getProductById(Integer.parseInt(nonExistingProductId)));
}



    @Test
    public void testInsertProduct() {
        // Dữ liệu sản phẩm mới
    String name = "Test Product";
    String image = "test_image.jpg";
    String price = "99.99";
    String title = "Test Product Title";
    String description = "This is a test product description.";
    String category = "1"; // ID của danh mục sản phẩm
    int sid = 1; // ID của người bán
     dao.insertProduct(name, image, price, title, description, category, sid);
     Product tets = dao.getProductByName(name);

  
    assertNotNull("them thanh cong ", tets);
    }
    
      @Test
public void testInsertProductWithEmptyName() {
    // Dữ liệu sản phẩm mới
    String name = ""; // Chuỗi rỗng
    String image = "test_image.jpg";
    String price = "99.99";
    String title = "Test Product Title";
    String description = "This is a test product description.";
    String category = "1"; 
    int sid = 1; // ID của người bán
    dao.insertProduct(name, image, price, title, description, category, sid);
    Product testProduct = dao.getProductByName(name);
    assertNull("khong nen de ten san pham bi rong", testProduct);
}
@Test
public void testInsertProductWithInvalidPrice() {
    // Dữ liệu sản phẩm mới
    String name = "Test";
    String image = "test_image.jpg";
    String price = "Invalid Price"; // Giá sản phẩm không hợp lệ
    String title = "Test Product Title";
    String description = "This is a test product description.";
    String category = "1"; 
    int sid = 1;
    dao.insertProduct(name, image, price, title, description, category, sid);
    Product testProduct = dao.getProductByName(name);
    // Kiểm tra xem sản phẩm có tồn tại trong cơ sở dữ liệu hay không
    assertNull("nen de gia sp la so", testProduct);
}
@Test
public void testInsertProductWithNegativePrice() {
    // Dữ liệu sản phẩm mới
    String name = "Test1";
    String image = "test_image.jpg";
    String price = "-9999999"; // Giá sản phẩm không hợp lệ
    String title = "Test Product Title";
    String description = "This is a test product description.";
    String category = "1"; 
    int sid = 1;
    dao.insertProduct(name, image, price, title, description, category, sid);
    Product testProduct = dao.getProductByName(name);
    // Kiểm tra xem sản phẩm có tồn tại trong cơ sở dữ liệu hay không
    assertNull("nen de gia sp la so >0", testProduct);
}
@Test
public void testCheckProductNameExistsWithExistingProduct() {
    String existingProductName = "kien";
    boolean exists = dao.checkProductNameExists(existingProductName);
    assertTrue("san pham ton tai trong csdl", exists);
}

@Test
public void testSignup() {
    // Dữ liệu đăng ký mới
    String username = "newuser";
    String password = "newpassword";
    dao.singup(username, password);
    Account newAccount = dao.checkAccountExist(username);
    assertNotNull("tao tai khoan thanh cong ", newAccount);
}
@Test
public void testSignupWithEmptyUsername() {
    String username = "";
    String password = "newpassword";
    dao.singup(username, password);
    Account newAccount = dao.checkAccountExist(username);
    assertNull("tai khoan khong nen de null", newAccount);
}

@Test
public void testSignupWithEmptyPassword() {
    String username = "avx";
    String password = "";
    dao.singup(username, password);
    Account newAccount = dao.checkAccountExist(username);
    assertNull("pass khong nen de null", newAccount);
}
 @Test
    public void testGetAllAccountByPage() {
        int page = 1;
        int pageSize = 10; // Kích thước trang

      
        Vector<Account> accounts = dao.getAllAccountByPage(page, pageSize);

        assertNotNull("Danh account khong null", accounts);

    }
    @Test
public void testGetAllAccountByNonExistingPage() {
    int nonExistingPage = 1000; 
    int pageSize = 10; 
    Vector<Account> accounts = dao.getAllAccountByPage(nonExistingPage, pageSize);
    assertTrue("danh sach rong vi trang khong ton tai", accounts.isEmpty());
}

@Test
public void testGetAllAccountByPageWithLessData() {
    int page = 1; 
    int pageSize = 100;
    Vector<Account> accounts = dao.getAllAccountByPage(page, pageSize);
    assertFalse("Danh khong rong", accounts.isEmpty());

    
    int expectedSize = Math.min(pageSize, dao.getTotalAccount()); 
    assertEquals("so luong tai khoan trong danh sach khong dung", expectedSize, accounts.size());
}

@Test
public void testUpdateCategory() {
    Category category = new Category();
    category.setCid(1); 
    category.setCname("Hoa th? bình"); 
    dao.updateCategory(category);
    Category updatedCategory = dao.getCategoryById(category.getCid());
    assertEquals("cap nhat thanh cong", category.getCname(), updatedCategory.getCname());
}
@Test
public void testUpdateCategoryWithNonExistingCategory() {
    Category nonExistingCategory = new Category();
    nonExistingCategory.setCid(1000); // Giả sử cid này không tồn tại trong cơ sở dữ liệu
    nonExistingCategory.setCname("abcxyx");
    dao.updateCategory(nonExistingCategory);
    Category updatedCategory = dao.getCategoryById(nonExistingCategory.getCid());
    assertNull("cap nhat ko thanh cong cid khong ton tai", updatedCategory);
}

@Test
public void testUpdateCategoryWithNullCategoryName() {
    Category category = new Category();
    category.setCid(1);
    category.setCname(null);
    dao.updateCategory(category);
    Category updatedCategory = dao.getCategoryById(category.getCid());
    assertNotNull("Danh khong cap nhat cname là null", updatedCategory);
}
@Test
public void testUpdateCategoryWithEmptyCategoryName() {
    Category category = new Category();
    category.setCid(1);
    category.setCname(""); 
    dao.updateCategory(category);
    Category updatedCategory = dao.getCategoryById(category.getCid());
    assertNotNull("khong cap nhat duoc vi cname rong", updatedCategory);
}
@Test
    public void testGetAllOrder() {
        List<Order> orders = dao.getAllOrder();
        assertNotNull("Danh sach don hang ko null", orders);
        assertTrue("Danh sach don hang khong rong", orders.size() > 0);

        
    }
    
    @Test
public void testOrdersAreSortedByCreatedDate() {
    List<Order> orders = dao.getAllOrder();
    assertNotNull("Danh sách đơn hàng không được trả về là null", orders);
    assertTrue("Danh sách đơn hàng không được trả về là rỗng", orders.size() > 0);

    // Kiểm tra xem các đơn hàng được sắp xếp theo thứ tự ngày tạo không
    for (int i = 0; i < orders.size() - 1; i++) {
        String createdDate1 = orders.get(i).getCreatedDate();
        String createdDate2 = orders.get(i + 1).getCreatedDate();
        assertTrue("cac don hang k dc sap xep theo ngay tao", createdDate1.compareTo(createdDate2) >= 0);
    }
}

}
