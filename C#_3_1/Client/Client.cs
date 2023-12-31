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

namespace Client
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
            client.DataReceived += Client_DataRecieved;
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            button1.Enabled = false;
            client.Connect(textBox1.Text, Convert.ToInt32(textBox2.Text));
        }

        private void Client_DataRecieved(object sender, SimpleTCP.Message e)
        {
            richTextBox2.Invoke((MethodInvoker)delegate ()
            {
                richTextBox2.Text += Environment.NewLine + e.MessageString;
            });
        }

        private void button2_Click(object sender, EventArgs e)
        {
            client.WriteLineAndGetReply(richTextBox1.Text, TimeSpan.FromSeconds(3));
        }
    }
}
