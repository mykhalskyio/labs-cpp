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

        private void Server_Load_1(object sender, EventArgs e)
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

            while (iterator < keys.Length)
            {
                string numbers = Regex.Replace(keys[iterator], "[^0-9.+-]", "");

                if (checkbox1 == false)
                {
                    button3.Invoke((MethodInvoker)delegate ()
                    {
                        button3.Visible = false;
                    });
                }

                if (Convert.ToInt32(numbers) == 1)
                {
                    button3.Invoke((MethodInvoker)delegate ()
                    {
                        button3.Visible = true;
                        checkbox1 = true;
                    });
                }
                else if (Convert.ToInt32(numbers) == 2)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.BackColor = SystemColors.ButtonFace;
                    });
                }
                else if (Convert.ToInt32(numbers) == 3)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.BackColor = Color.Red;
                    });
                }
                else if (Convert.ToInt32(numbers) == 4)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.BackColor = Color.Blue;
                    });
                }
                else if (Convert.ToInt32(numbers) == 5)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.BackColor = Color.Yellow;
                    });
                }
                else if (Convert.ToInt32(numbers) == 6)
                {
                    label3.Invoke((MethodInvoker)delegate ()
                    {
                        label3.Text = "Панель";
                    });
                }
                else if (Convert.ToInt32(numbers) == 6)
                {
                    this.Invoke((MethodInvoker)delegate ()
                    {
                        this.Close();
                    });
                }

                iterator++;
            }
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            System.Net.IPAddress ip = System.Net.IPAddress.Parse(textBox1.Text);
            server.Start(ip, Convert.ToInt32(textBox2.Text));
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (server.IsStarted)
            {
                server.Stop();
            }
        }
    }
}
