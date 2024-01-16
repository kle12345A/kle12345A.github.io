namespace Lab06_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Student> list = new List<Student>()
           {
               new Student {Id= "S10",FirstName= "Nguyen Thu", LastName= "Phuong",Avg=9.5},
               new Student {Id= "S12",FirstName= "Tran Thi", LastName= "thuy",Avg=9.0},
               new Student {Id= "S13",FirstName= "Le Hoang", LastName= "Nhat",Avg=8.0},
               new Student {Id= "S14",FirstName= "Nguyen Van", LastName= "Phong",Avg=6.5},
               new Student {Id= "S15",FirstName= "Hoang Thi ", LastName= "Hue",Avg=9.7},
               new Student {Id= "S16",FirstName= "Nguyen Tien", LastName= "Tung",Avg=5.0},
               new Student {Id= "S17",FirstName= "Nguyen Thien", LastName= "Nhan",Avg=4.8},



           };
            Console.WriteLine("In danh sach sinh vien");
            foreach(var st in list)
            {
                Console.Write(st);
            }
            //tim sinh vien co diem trung binh cao nhat
            double max = list[0].Avg;
            Student stmax = list[0];
            foreach(var st in list)
            {
                if(st.Avg > max)
                {
                    max = st.Avg;
                    stmax = st;
                }
            }

            Console.WriteLine("Sinh vien co diem cao nhat la: ");
            Console.WriteLine(stmax);
        }
    }
}
