using System.Collections;

namespace Lab6_01
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ArrayList inv = new ArrayList();
            inv.Add(new Product("A",5.9,3));
            inv.Add(new Product("B", 8.2, 2));


            inv.Add(new Product("C", 3.5, 8));

            inv.Add(new Product("D",1.8, 4));


            Console.WriteLine("Product List: ");
            foreach (Product p in inv) {

                Console.WriteLine("  " + p);
                    }
        }
    }
}
