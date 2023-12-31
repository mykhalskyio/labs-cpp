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

namespace Server
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
            string request = e.MessageString;
            string[] keys = request.Split(',');

            int iterator = 0;

            bool checkbox1 = false;
            bool checkbox2 = false;

            while (iterator < keys.Length)
            {
                string numbers = Regex.Replace(keys[iterator], "[^0-9.+-]", "");

                if (checkbox1 == false)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        button3.Enabled = true;
                    });
                }
                
                if(checkbox2 == false)
                {
                    button3.Invoke((MethodInvoker)delegate ()
                    {
                        label3.Visible = true;
                        panel1.Visible = true;
                    });
                }

                if (Convert.ToInt32(numbers) == 1)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        button3.Enabled = false;
                        checkbox1 = true;
                    });
                }
                else if (Convert.ToInt32(numbers) == 2)
                {
                    button3.Invoke((MethodInvoker)delegate ()
                    {
                        label3.Visible = false;
                        panel1.Visible = false;
                        checkbox2 = true;
                    });
                }
                else if (Convert.ToInt32(numbers) == 3)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.BackColor = SystemColors.Control;
                    });
                }
                else if (Convert.ToInt32(numbers) == 4)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.BackColor = Color.Red;
                    });
                }
                else if (Convert.ToInt32(numbers) == 5)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.BackColor = Color.Yellow;
                    });
                }

                iterator++;
            }
        }


        private void button2_Click(object sender, EventArgs e)
        {
            System.Net.IPAddress ip = System.Net.IPAddress.Parse(textBox1.Text);
            server.Start(ip, Convert.ToInt32(textBox2.Text));
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (server.IsStarted)
            {
                server.Stop();
            }
        }
    }
}
