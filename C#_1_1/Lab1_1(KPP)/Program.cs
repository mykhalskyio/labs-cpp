using System;
using System.Collections;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Lab1_1_KPP_
{
    class Program
    {
        static void Main(string[] args)
        {

            string filePath = "path://toys.txt";

            List<Toy> ToyBox = new List<Toy>();

            List<string> lines = File.ReadAllLines(filePath).ToList();

            foreach (var line in lines)
            {
                string[] infoChunk = line.Split(';');

                Toy newToy = new Toy();
                newToy.Name = infoChunk[0];
                newToy.Price = Convert.ToDouble(infoChunk[1]);
                newToy.Age_From = Convert.ToInt32(infoChunk[2]);

                ToyBox.Add(newToy); 
            }

            Console.WriteLine("Toybox:");
            Console.WriteLine("");

            foreach (var Toy in ToyBox)
            {
                Console.WriteLine(Toy.ToString());
            }

            Console.WriteLine("");
            Console.Write("x : ");
            double x = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("");
            Console.WriteLine("-------------------------");
            Console.WriteLine("");
            Console.WriteLine("Toybox {Restrictions: Not a ball, Only for 3 year old, Price not bigger than x} :");
            Console.WriteLine("");

            ToyBox.OrderBy(order => order.Price).ToList();

            foreach (var Toy in ToyBox)
            {
                if (Toy.Name != "Ball")
                {
                    if (Toy.Age_From == 3)
                    {
                        if (Toy.Price <= x)
                        {
                            Console.WriteLine(Toy.ToString());
                        }
                    }
                }
            }
            Console.ReadKey();
        }
    }

    class Toy
    {
        public String Name { get; set; }
        public double Price { get; set; }
        public int Age_From { get; set; }

        public String ToString()
        {
            return "Name: " + this.Name + "; Price: " + this.Price + " UAH; Age Restrictions: " + this.Age_From + "+ Years";
        }
    }
}
