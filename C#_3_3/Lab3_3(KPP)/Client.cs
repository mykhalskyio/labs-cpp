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

namespace Lab3_3_KPP_
{
    public partial class Client : Form
    {
        public Client()
        {
            InitializeComponent();
        }

        SimpleTcpClient client;

        private void Client_Load_1(object sender, EventArgs e)
        {
            client = new SimpleTcpClient();
            client.StringEncoder = Encoding.UTF8;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            button1.Enabled = false;
            client.Connect(textBox1.Text, Convert.ToInt32(textBox2.Text));
        }

        private void query()
        {
            string query = "0, ";

            if (visibleToolStripMenuItem.Checked == true)
            {
                query += "1, ";
            }

            if (toolStripMenuItem2.Checked == true)
            {
                query += "2, ";
            }
            else if (toolStripMenuItem3.Checked == true)
            {
                query += "3, ";
            }
            else if (toolStripMenuItem4.Checked == true)
            {
                query += "4, ";
            }
            else if (clYellowToolStripMenuItem.Checked == true)
            {
                query += "5, ";
            }

            if (change_key == 1)
            {
                query += "6, ";
            }

            if (exit_key == 1)
            {
                query += "7, ";
            }

            query += "0";
            textBox3.Text = query;
        }

        private int change_key = 0;
        private int exit_key = 0;

        private void visibleToolStripMenuItem_Click(object sender, EventArgs e)
        {
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            toolStripMenuItem2.Checked = true;
            toolStripMenuItem3.Checked = false;
            toolStripMenuItem4.Checked = false;
            clYellowToolStripMenuItem.Checked = false;

            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void toolStripMenuItem3_Click(object sender, EventArgs e)
        {
            toolStripMenuItem2.Checked = false;
            toolStripMenuItem3.Checked = true;
            toolStripMenuItem4.Checked = false;
            clYellowToolStripMenuItem.Checked = false;

            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void toolStripMenuItem4_Click(object sender, EventArgs e)
        {
            toolStripMenuItem2.Checked = false;
            toolStripMenuItem3.Checked = false;
            toolStripMenuItem4.Checked = true;
            clYellowToolStripMenuItem.Checked = false;

            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void jPanelCaptionToolStripMenuItem_Click(object sender, EventArgs e)
        {
            change_key = 1;
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            exit_key = 1;
            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
            this.Close();
        }

        private void clYellowToolStripMenuItem_Click(object sender, EventArgs e)
        {
            toolStripMenuItem2.Checked = false;
            toolStripMenuItem3.Checked = false;
            toolStripMenuItem4.Checked = false;
            clYellowToolStripMenuItem.Checked = true;

            query();
            client.WriteLineAndGetReply(textBox3.Text, TimeSpan.FromSeconds(1));
        }

        private void form1ColorToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
    }
}
