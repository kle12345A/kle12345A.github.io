using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab6_01
{
    internal class Product
    {
        public String Name { get; set; }
        public double Cost { get; set; }
        public int onhand { get; set; }

        public Product()
        {
        }

        public Product(string name, double cost, int onhand)
        {
            Name = name;
            Cost = cost;
            this.onhand = onhand;
        }

        public override String ToString()
        {
            return String.Format("{0,-10}Cost: {1,6:C} On hand: {2}", Name, Cost,onhand);
        }
    }
}
