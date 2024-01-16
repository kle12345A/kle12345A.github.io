using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab06_3
{
    internal class Student
    {
        public string Id {  get; set; }
        public string FirstName {  get; set; }
        public string LastName { get; set; }
        public bool Gender { get; set; }
        public double Avg {  get; set; }
        public override string ToString()
        {
            return "\nId: " + Id + "\nFullName: " + FirstName + " " + LastName
                + "\nGender: " + (Gender ? "Male" : "Female") + "\nAverage Mark: " + Avg;
        }
    }
}
