using SimpleTCP;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab3_1_KPP_
{
    public partial class Server : Form
    {
        public Server()
        {
            InitializeComponent();
        }

        SimpleTcpServer server;

        private void Server_Load(object sender, EventArgs e)
        {
            server = new SimpleTcpServer();
            server.Delimiter = 0x13; //Enter
            server.StringEncoder = Encoding.UTF8;
            server.DataReceived += Server_DataRecieved;
        }

        private void Server_DataRecieved(object sender, SimpleTCP.Message e)
        {
            richTextBox1.Invoke((MethodInvoker)delegate() 
            {
                string request = e.MessageString;
                char[] request_data = request.ToCharArray();

                string result = "";

                foreach (char letter in request_data)
                {
                    if(Char.IsLower(letter))
                    {
                        result += letter;
                    }
                }

                richTextBox1.Text += Environment.NewLine + "Result: " + result.ToString();

                e.ReplyLine(string.Format("Request: {0}", e.MessageString));
            });
        }

        private void button1_Click(object sender, EventArgs e)
        {
            richTextBox1.Text += Environment.NewLine + "Start";
            System.Net.IPAddress ip = System.Net.IPAddress.Parse(textBox1.Text);
            server.Start(ip, Convert.ToInt32(textBox2.Text));
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if(server.IsStarted)
            {
                richTextBox1.Text += Environment.NewLine + "Stop";
                server.Stop();
            }
        }
    }
}
