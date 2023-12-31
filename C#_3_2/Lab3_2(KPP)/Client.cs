using SimpleTCP;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab3_2_KPP_
{
    public partial class Client : Form
    {
        public Client()
        {
            InitializeComponent();
        }

        SimpleTcpClient client;

        private void Client_Load(object sender, EventArgs e)
        {
            client = new SimpleTcpClient();
            client.StringEncoder = Encoding.UTF8;
        }
        private void button2_Click(object sender, EventArgs e)
        {
            button2.Enabled = false;
            client.Connect(textBox1.Text, Convert.ToInt32(textBox2.Text));
        }

        private void query()
        {
            string query = "0, ";

            if (checkBox1.Checked == true)
            {
                query += "1, ";
            }
            if (checkBox2.Checked == false)
            {
                query += "2, ";
            }

            if (radioButton1.Checked == true)
            {
                query += "3, ";
            }
            else if (radioButton2.Checked == true)
            {
                query += "4, ";
            }
            else if(radioButton3.Checked == true)
            {
                query += "5, ";
            }

            query += "0";
            textBox3.Text = query;
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromMilliseconds(1));
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromMilliseconds(1));
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromMilliseconds(1));
        }
    }
}
