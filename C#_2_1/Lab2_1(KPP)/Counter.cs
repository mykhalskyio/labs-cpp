using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab2_1_KPP_
{
    class Counter
    {
        public bool stop = false;
        public double epsilon = Math.Pow(10, -5);
        public Label label;
        public CheckBox checkBox;

        public void Stop()
        {
            stop = true;
        }

        public void Run()
        {
            double S = 0;
            double a = 1;
            int n = 0;
            int x = 5;

            do
            {
                if (stop == true)
                {
                    break;
                }

                n++;

                int factorial = 1;
                int number = 2 * n + 1;

                for (int i = number; i > 0; i--)
                {
                    factorial *= i;
                }

                Console.WriteLine(x + " - " + number + " - " + Math.Pow(x, number) + " - " + factorial);

                double R = Math.Pow(x, number) / (factorial);
                a *= R;
                S += a;

                label.Invoke((MethodInvoker)(() => label.Text = S.ToString()));
                Thread.Sleep(1000);

            } while (Math.Abs(a) >= epsilon);

            checkBox.Invoke((MethodInvoker)(() => checkBox.Checked = false));
        }
    }
}
