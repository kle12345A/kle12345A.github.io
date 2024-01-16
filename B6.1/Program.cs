using System.Text;

namespace B6._1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            List<Book> bookList = new List<Book>
        {
            new Book { Id = 1, Title = "Sách 1", Author = "Tác giả 1", Publisher = "Nhà xuất bản 1", Year = 2022, Price = 29.99 },
            new Book { Id = 2, Title = "Sách 2", Author = "Tác giả 2", Publisher = "Nhà xuất bản 2", Year = 2020, Price = 19.99 },
            new Book { Id = 3, Title = "Sách 3", Author = "Tác giả 3", Publisher = "Nhi Dong", Year = 2021, Price = 24.99 },
            new Book { Id = 4, Title = "Sách 4", Author = "Tác giả 4", Publisher = "Nhà xuất bản 4", Year = 2019, Price = 34.99 },
            new Book { Id = 5, Title = "Sách 5", Author = "Tác giả 5", Publisher = "Nhà xuất bản 5", Year = 2018, Price = 39.99 },
            new Book { Id = 6, Title = "Sách 6", Author = "Tác giả 6", Publisher = "Nhà xuất bản 6", Year = 2023, Price = 44.99 },
            new Book { Id = 7, Title = "Sách 7", Author = "Tác giả 7", Publisher = "Nhà xuất bản 7", Year = 2017, Price = 29.99 },
            new Book { Id = 8, Title = "Sách 8", Author = "Tác giả 8", Publisher = "Nhà xuất bản 8", Year = 2024, Price = 49.99 },
            new Book { Id = 9, Title = "Sách 9", Author = "Tác giả 9", Publisher = "Nhà xuất bản 9", Year = 2016, Price = 54.99 },
            new Book { Id = 10, Title = "Sách 10", Author = "Tác giả 10", Publisher = "Nhà xuất bản 10", Year = 2020, Price = 29.99 }
        };

            bookList.Sort((book1, book2) => book1.Price.CompareTo(book2.Price));
            Console.WriteLine("Danh sách sách sau khi sắp xếp theo giá tăng dần:");
            foreach (Book book in bookList)
            {
                Console.WriteLine($"ID: {book.Id}, Title: {book.Title}, Author: {book.Author}, Publisher: {book.Publisher}, Year: {book.Year}, Price: {book.Price:C}");
            }


            Console.Write("Nhập title cần tìm kiếm: ");
            string inputTitle = Console.ReadLine();

            
            Book searhTitle = null;
            foreach (Book book in bookList)
            {
                if (string.Equals(book.Title, inputTitle, StringComparison.OrdinalIgnoreCase))
                {
                    searhTitle = book;
                    break; 
                }
            }

            
            if (searhTitle != null)
            {
                Console.WriteLine($"Đã tìm thấy sách với title \"{inputTitle}\":");
                Console.WriteLine($"ID: {searhTitle.Id}, Title: {searhTitle.Title}, Author: {searhTitle.Author}, Publisher: {searhTitle.Publisher}, Year: {searhTitle.Year}, Price: {searhTitle.Price:C}");
            }
            else
            {
                Console.WriteLine($"Không tìm thấy sách với title \"{inputTitle}\".");
            }

            List<Book> booksPublishedIn2014 = bookList.Where(book => book.Year == 2014).ToList();

            Console.WriteLine("Nhung quyen sach xuat ban nam 2014");
            foreach(Book book in booksPublishedIn2014)
            {
                Console.WriteLine($"ID: {book.Id}, Title: {book.Title}, Author: {book.Author}, Publisher: {book.Publisher}, Year: {book.Year}, Price: {book.Price:C}");
            }


            Console.WriteLine("Xoa nhung quyen sach cua nha cxuat ban Nhi Dong");
            string PublisherRemove = "Nhi Dong";
            bookList.RemoveAll(book => string.Equals(book.Publisher, PublisherRemove, StringComparison.OrdinalIgnoreCase));
            Console.WriteLine("Danh scah sau khi xoa la: ");
            foreach( Book book in bookList)
            {
                Console.WriteLine($"ID: {book.Id}, Title: {book.Title}, Author: {book.Author}, Publisher: {book.Publisher}, Year: {book.Year}, Price: {book.Price:C}");
            }
        }
    }
}
