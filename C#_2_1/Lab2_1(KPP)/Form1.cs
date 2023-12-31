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
    public partial class Form1 : Form
    {

        private Counter counter;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            counter = new Counter();
            counter.label = label1;
            counter.checkBox = checkBox1;
            Thread thread = new Thread(counter.Run);
            thread.Start();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if(checkBox1.Checked)
            {
                counter = new Counter();
                counter.label = label1;
                counter.checkBox = checkBox1;
                Thread thread = new Thread(counter.Run);
                thread.Start();
            }
            else if(!checkBox1.Checked)
            {
                if (counter != null)
                {
                    counter.Stop();
                }
            }
        }
    }
}
