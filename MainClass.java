import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.applet.*;
import java.awt.image.*;
import java.awt.event.*;
class MainClass extends JFrame
{
 Dimension d;
 AudioClip clip1 =Applet.newAudioClip(getClass().getResource("sounds/flip.wav"));
 JLabel str = new JLabel(new ImageIcon(getClass().getResource("images/othello.jpg")));
 JButton strb = new JButton("START", new ImageIcon(getClass().getResource("images/play.jpg")));
JRadioButton []player=new JRadioButton[2];
   public  MainClass()
      {
           super("GAME OF OTHELLO");
          d=Toolkit.getDefaultToolkit().getScreenSize();
           setSize(d.width,d.height);
           setLocationRelativeTo(null);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           Image stri = (new Va()).superb.getImage();
           setIconImage(stri);
           setLayout(null);
           str.setBounds(0,0,d.width,d.height);
           add(str);
           str.setLayout(null);
           strb.setBounds((d.width-250)/2,d.height-300,250,85);
           strb.setMargin(new Insets(0,0,0,0));
            strb.setBackground(Color.cyan);
           strb.setFont(new Font("cooper black",2,28));
           strb.setMnemonic('S');
           str.add(strb);
           choose();
	strb.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
                                      clip1.play();
		startGame();
	  }
	});
	setVisible(true);
           
       }
  void startGame()
  {
	Va.username=JOptionPane.showInputDialog(this,"Enter your name Player1:");
	if(Va.username==null || Va.username.equals(""))
	  Va.username="Unknown";
                        setChoose();
                    if(Va.Two)
                           {
                               	Va.username1=JOptionPane.showInputDialog(this,"Enter your name Player2:");
	                    if(Va.username1==null || Va.username1.equals(""))
	                          Va.username1="Unknown";
                           }
	new Othello();
	setVisible(false);
  } 
    void choose()
     {	
    JLabel ch=new JLabel("--Choose No. Of Players--");
    ch.setForeground(Color.yellow); 
    ch.setFont(new Font("cooper black",2,28));
    ch.setBounds((d.width-400)/2,d.height/9,400,150);	
    str.add(ch);	
    JPanel pa=new JPanel();
    pa.setBounds((d.width-300)/2,d.height/9 +120,300,40);
    str.add(pa);  
    pa.setBackground(Color.yellow);	
    pa.setOpaque(false);	
    String []st={"1 Player","2 Player"};	
    ButtonGroup gr=new ButtonGroup();		
    for(int i=0;i<2;i++)
    {
	player[i]=new JRadioButton(st[i]);
	gr.add(player[i]);
	player[i].setFont(new Font("cooper black",2,28));
                    player[i].setBackground(Color.yellow);	
	pa.add(player[i]);
    }	
    player[1].setSelected(true);	
  }
  void setChoose()
{
	  if(player[0].isSelected())
		Va.One=true;
	 else
                                      Va.Two=true;
  }     
  public static void main(String args[])
  {
                  
	new MainClass();
                  
  } 
}