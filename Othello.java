import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import javax.swing.border.Border;
import java.util.Random;
class Othello extends JFrame
{
AudioClip clip1;
 public static boolean chance = false;
Random ra=new Random();
static Va va = new Va();
static JPanel pan = new JPanel();
JLabel back = new JLabel(new ImageIcon(getClass().getResource("images/background.jpg")));
static JLabel fin=new JLabel();
static JLabel lab1 = new JLabel();
static JLabel lab2 = new JLabel();
static MyButton but1 = new MyButton("Restart");
Border bor =BorderFactory.createLineBorder(new Color(200,80,80),10,true);
ActionListener listener = new ButtonListener();
public Othello()
{
super("GAME OF OTHELLO");
addSound();
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setSize(d.width,d.height);
setResizable(false);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
getContentPane().setBackground(Color.black);
addButtons();
lab1.setText(Va.username +":"+ Va.black_count);
 if(Va.Two)
lab2.setText(Va.username1+":" + Va.white_count);
 else
lab2.setText("Computer"+":" + Va.white_count);
lab1.setForeground(Color.white);
lab2.setForeground(Color.white);
lab1.setBounds((d.width-800)/2,(1/5)*d.height,200,100);
lab2.setBounds(((d.width-800)/2) + 500,(1/5)*d.height,200,100);
pan.setBorder(bor);
but1.setBounds((d.width - 800)/2 +350, d.height-160,150,60);
but1.setBackground(Color.green);
but1.setFont(new Font("cooper black",2,24));
but1.setForeground(Color.black);
but1.addActionListener(listener);
Image sup = va.superb.getImage();
setIconImage(sup);
lab1.setFont(new Font("cooper black", 2,28));
lab2.setFont(new Font("cooper black", 2,28));
pan.setBounds((d.width-800)/2,(d.height-800)/2 -40,800,800);
pan.setLayout(new GridLayout(8,8));
  fin.setLayout(null);
  fin.setBounds((d.width-800)/2 + 200,(1/5)*d.height,300,100);
fin.setVisible(false);
addflips();
back.setLayout(null);
back.setSize(d.width,d.height);
back.add(pan);
back.add(lab1);
back.add(lab2);
back.add(fin);
back.add(but1);
add(back);
back.setVisible(true);
setVisible(true);
blackTurn();
}
 public void addSound()
 {
   try
   {
       clip1=Applet.newAudioClip(getClass().getResource("sounds/flip.wav"));
   }catch(Exception ex){}
 } 
    public static void bFlipDown(int i,int j)
         {
               i++;
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   i++;
                                   
                          } 
         }
       public static void bFlipLeft(int i,int j)
         {
               j--;
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   j--;                            
                          } 
         }
        public static void bFlipLeftDown(int i,int j)
         {
                  i++;
                 j++;              
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   i++;
                                   j++;                             
                          } 
         }
        public static void bFlipLeftUp(int i,int j)
         {
               i--;
               j--;
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   i--;
                                   j--;
                                   
                          } 
         }
        public static void bFlipRight(int i,int j)
         {
               j++;
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   j++;
                                   
                          } 
         }
       public static void bFlipRightDown(int i,int j)
         {
               i++;
               j--;
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   i++;
                                   j--;
                                   
                          } 
         }
       public static void bFlipRightUp(int i,int j)
         {
                    i--;
                    j++;               
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   i--;
                                   j++;
                                   
                          } 
         }
        public static void bFlipUp(int i,int j)
         {
               i--;
                while(Va.bt[i][j].getIcon()!=va.icon)
                           { 
                                Va.bt[i][j].setIcon(va.icon);
                                   i--;
                                   
                          } 
         }
    public static void wFlipDown(int i,int j)
         {
               i++;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   i++;
                                   
                          } 
         }
       public static void wFlipLeft(int i,int j)
         {
               j--;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   j--;
                                   
                          } 
         }
        public static void wFlipLeftDown(int i,int j)
         {
               i++;
              j++;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   i++;
                                   j++;
                                   
                          } 
         }
        public static void wFlipLeftUp(int i,int j)
         {
               i--;
               j--;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   i--;
                                   j--;
                                   
                          } 
         }
        public static void wFlipRight(int i,int j)
         {
               j++;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   j++;
                                   
                          } 
         }
       public static void wFlipRightDown(int i,int j)
         {
               i++;
               j--;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   i++;
                                   j--;
                                   
                          } 
         }
       public static void wFlipRightUp(int i,int j)
         {
               i--;
               j++;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   i--;
                                   j++;
                                   
                          } 
         }
        public static void wFlipUp(int i,int j)
         {
               i--;
                while(Va.bt[i][j].getIcon()!=va.icon1)
                           { 
                                Va.bt[i][j].setIcon(va.icon1);
                                   i--;
                                   
                          } 
         }
public static void wRightUpThread(int a,int b)
{
int c=0;
int flag=0;
a--;
b++;
while(a<8 &&a>=0 && b<8 && b>=0)
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
     if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     a--;
     b++;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][4]  = 1;
 }
}
public static void wUpThread(int a,int b)
{
int c=0;
int flag=0;
a--;
while(a<8 &&a>=0 && b<8 && b>=0)
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
     if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     a--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][2]  = 1;
 }
}
public static void wRightThread(int a,int b)
{
int c=0;
int flag=0;
b++;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
     if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     b++;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][0]  = 1;
 }
}
public static void wRightDownThread(int a,int b)
{

int c=0;
int flag=0;
a++;
b--;
while(a<8 &&a>=0 && b<8 && b>=0)
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
    if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     a++;
     b--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][5]  = 1;
 }
}
public static void wLeftUpThread(int a,int b)
{

int c=0;
int flag=0;
a--;
b--;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
    if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     a--;
     b--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][6]  = 1;
 }
}
public static void wLeftThread(int a,int b)
{
int c=0;
int flag=0;
b--;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
     if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     b--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][1]  = 1;
 }
}
public static void wLeftDownThread(int a,int b)
{
int c=0;
int flag=0;
a++;
b++;
while(a<8 &&a>=0 && b<8 && b>=0)
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
    if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     a++;
     b++;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][7]  = 1;
 }
}
public static void wDownThread(int a,int b)
{
int c=0;
int flag=0;
a++;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon1)
   {
   flag=1;
   break;
   }
    if(Va.bt[a][b].getIcon()!=va.icon)
     break;
    c++; 
     a++;
     
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][3]  = 1;
 }
}
public static void bUpThread(int a,int b)
{
int c=0;
int flag=0;
a--;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
    if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     a--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][2]  = 1;
 }
}
public static void bRightUpThread(int a,int b)
{
int c=0;
int flag=0;
a--;
b++;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
  if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     a--;
     b++;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][4]  = 1;
 }
}
public static void bRightThread(int a,int b)
{
int c=0;
int flag=0;
b++;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
   if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     b++;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][0]  = 1;
 }
}
public static void bRightDownThread(int a,int b)
{
int c=0;
int flag=0;
a++;
b--;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
  if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     a++;
     b--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][5]  = 1;
 }
}
public static void bLeftUpThread(int a,int b)
{
int c=0;
int flag=0;
a--;
b--;
while(a<8 &&a>=0 && b<8 && b>=0)
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
  if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     a--;
     b--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][6]  = 1;
 }
}
public static void bLeftThread(int a,int b)
{
int c=0;
int flag=0;
b--;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
  if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     b--;
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][1]  = 1;
 }
}
public static void bLeftDownThread(int a,int b)
{
int c=0;
int flag=0;
a++;
b++;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
  if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     a++;
     b++;
 }
if(flag==1 && c>=1)
{
  chance=true;
 Va.butt[Va.ind][7]  = 1;
 }
}
public static void bDownThread(int a,int b)
{

int c=0;
int flag=0;
a++;
while(a<8 &&a>=0 && b<8 && b>=0 )
 {
    if(Va.bt[a][b].getIcon()==va.icon)
   {
   flag=1;
   break;
   }
  if(Va.bt[a][b].getIcon()!=va.icon1)
     break;
    c++; 
     a++;
     
 }
if(flag==1 && c>=1)
{
 chance=true;
 Va.butt[Va.ind][3]  = 1;
 }
}
void addflips()
{
Va.bt[3][3].setIcon(va.icon1);
Va.bt[4][4].setIcon(va.icon1);
Va.bt[3][4].setIcon(va.icon);
Va.bt[4][3].setIcon(va.icon);
}
class ButtonListener implements ActionListener
{
public void actionPerformed(ActionEvent evt)
{
  MyButton b =(MyButton) evt.getSource();
   if(b==but1)
        {
             clip1.play();
              for(int j=0;j<Va.ind;j++)
                             {
                                   Va.but[j].setIcon(null);
                                             for(int k=0;k<8;k++)
                                                       Va.butt[j][k]=0;
                             }
                for(int i=0;i<8;i++)
                  {
                      for(int j=0;j<8;j++)
                        {
                                 if(i==3 && j==3)
                                     Va.bt[i][j].setIcon(va.icon);
                                 else if(i==3 && j==4)
                                     Va.bt[i][j].setIcon(va.icon1);
                                 else if(i==4 && j==3)
                                     Va.bt[i][j].setIcon(va.icon1);
                                else if(i==4 && j==4)
                                     Va.bt[i][j].setIcon(va.icon);
                                else
                                     Va.bt[i][j].setIcon(null);

                         }
                  }
Va.black_count=2;
Va.white_count=2;
Va.NO_WHITE_LEFT=0;
Va.NO_BLACK_LEFT=0;
fin.setVisible(false);
lab1.setText(Va.username +":"+ Va.black_count);
 if(Va.Two)
lab2.setText(Va.username1+":" + Va.white_count);
 else
lab2.setText("Computer"+":" + Va.white_count);
Va.wc=0;
Va.bc=0;
Va.ind=0;
blackTurn();
         }
 
else if(b.getIcon()==va.icon2) 
{
     int i,j;
     clip1.play();
             for(i=0;i<Va.ind;i++)
                      {
                                 if(Va.but[i]==evt.getSource())
                                      break;
                       }
    
             
                            if(Va.butt[i][0]==1)
                                          bFlipRight(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][1]==1)
                                          bFlipLeft(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][2]==1)
                                         bFlipUp(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][3]==1)
                                          bFlipDown(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][4]==1)
                                          bFlipRightUp(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][5]==1)
                                          bFlipRightDown(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][6]==1)
                                          bFlipLeftUp(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][7]==1)
                                          bFlipLeftDown(Va.but[i].row,Va.but[i].column);

                    Va.but[i].setIcon(va.icon);
                                               Va.black_count=0;
                                                Va.white_count=0;
                                                                 for(int r= 0;r<=7;r++)
                                               {
                                                     for(int c=0;c<=7;c++)
                                                            { 
                                                               if(Va.bt[r][c].getIcon()==va.icon)
                                                                   Va.black_count++;
                                                                else if(Va.bt[r][c].getIcon()==va.icon1)
                                                                    Va.white_count++;
                                                            }
                                                 }
                            lab1.setText(Va.username+":" + Va.black_count);
                               if(Va.Two)
                            lab2.setText(Va.username1+":" + Va.white_count);
                               else
                            lab2.setText("Computer"+":" + Va.white_count);
                                       for(j=0;j<Va.ind;j++)
                             {
                                         if(Va.but[j]!=Va.but[i])
                                   Va.but[j].setIcon(null);
                                             for(int k=0;k<8;k++)
                                                       Va.butt[j][k]=0;
                             }
               Va.bc=0; 
               Va.ind=0;
whiteTurn();
if(Va.One && Va.end!=true)
    {
           	Random ra=new Random();
	int num=ra.nextInt(Va.ind); 
                   clip1.play();
                   if(Va.butt[num][0]==1)
                                          wFlipRight(Va.but[num].row,Va.but[num].column);

                      if(Va.butt[num][1]==1)
                                       wFlipLeft(Va.but[num].row,Va.but[num].column);

                      if(Va.butt[num][2]==1)
                                          wFlipUp(Va.but[num].row,Va.but[num].column);

                            if(Va.butt[num][3]==1)
                                       wFlipDown(Va.but[num].row,Va.but[num].column);
                                      
                            if(Va.butt[num][4]==1)
                                          wFlipRightUp(Va.but[num].row,Va.but[num].column);


                            if(Va.butt[num][5]==1)
                                        wFlipRightDown(Va.but[num].row,Va.but[num].column);

                            if(Va.butt[num][6]==1)
                                       wFlipLeftUp(Va.but[num].row,Va.but[num].column);

                            if(Va.butt[num][7]==1)
                                        wFlipLeftDown(Va.but[num].row,Va.but[num].column);

  Va.but[num].setIcon(va.icon1);
                              Va.black_count=0;
                              Va.white_count=0;
                                            for(int r = 0;r<=7;r++)
                                               {
                                                     for(int c=0;c<=7;c++)
                                                            { 
                                                               if(Va.bt[r][c].getIcon()==va.icon)
                                                                   Va.black_count++;
                                                                else if(Va.bt[r][c].getIcon()==va.icon1)
                                                                    Va.white_count++;
                                                            }
                                                 }
                                  lab1.setText(Va.username+":" + Va.black_count);
                                  lab2.setText("Computer"+":" + Va.white_count);
              for( j=0;j<Va.ind;j++)
                             {
                                   if(Va.but[j]!=Va.but[num])
                                   Va.but[j].setIcon(null);
                                             for(int k=0;k<8;k++)
                                                       Va.butt[j][k]=0;
                             }
Va.wc=0;
Va.ind=0;
blackTurn();   
     }
}
 else if(b.getIcon()==va.icon3) 
{
   int i,j;
   clip1.play();
             for(i=0;i<Va.ind;i++)
                      {
                                 if(Va.but[i]==b)
                                       break;
                       }
    
                      if(Va.butt[i][0]==1)
                                          wFlipRight(Va.but[i].row,Va.but[i].column);

                      if(Va.butt[i][1]==1)
                                       wFlipLeft(Va.but[i].row,Va.but[i].column);

                      if(Va.butt[i][2]==1)
                                          wFlipUp(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][3]==1)
                                       wFlipDown(Va.but[i].row,Va.but[i].column);
                                      
                            if(Va.butt[i][4]==1)
                                          wFlipRightUp(Va.but[i].row,Va.but[i].column);


                            if(Va.butt[i][5]==1)
                                        wFlipRightDown(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][6]==1)
                                       wFlipLeftUp(Va.but[i].row,Va.but[i].column);

                            if(Va.butt[i][7]==1)
                                        wFlipLeftDown(Va.but[i].row,Va.but[i].column);

  Va.but[i].setIcon(va.icon1);
                              Va.black_count=0;
                              Va.white_count=0;
                                            for(int r = 0;r<=7;r++)
                                               {
                                                     for(int c=0;c<=7;c++)
                                                            { 
                                                               if(Va.bt[r][c].getIcon()==va.icon)
                                                                   Va.black_count++;
                                                                else if(Va.bt[r][c].getIcon()==va.icon1)
                                                                    Va.white_count++;
                                                            }
                                                 }
                                  lab1.setText(Va.username+":" + Va.black_count);
                                  lab2.setText(Va.username1+":" + Va.white_count);
              for(j=0;j<Va.ind;j++)
                             {
                                   if(Va.but[j]!=Va.but[i])
                                   Va.but[j].setIcon(null);
                                             for(int k=0;k<8;k++)
                                                       Va.butt[j][k]=0;
                             }
Va.wc=0;
Va.ind=0;
blackTurn();
}  

}
}

void addButtons()
{
for(int i=0;i<8;i++)
{
for(int j=0;j<8;j++)
{
Va.bt[i][j]=new MyButton();
 Va.bt[i][j].row=i;
 Va.bt[i][j].column=j;
Va.bt[i][j].setBackground(new Color(80,255,80));
Va.bt[i][j].addActionListener(listener);
pan.add(Va.bt[i][j]);
}
}

}
public void finalDisplay()
{
  Va.end =true;
 if(Va.black_count>Va.white_count)
{
  fin.setText(Va.username + " WON!!");
  fin.setFont(new Font("cooper black",2,30));
  fin.setForeground(Color.yellow);
  fin.setVisible(true);
}
else if(Va.white_count>Va.black_count)
{
  if(Va.Two)
  fin.setText(Va.username1 + " WON!!");
 else
   fin.setText( "Computer WON!!");
 fin.setFont(new Font("cooper black",2,30));
 fin.setForeground(Color.yellow);
 fin.setVisible(true);
}
else
{
  fin.setText("TIE!!");
  fin.setFont(new Font("cooper black",2,30));
 fin.setForeground(Color.yellow);
 fin.setVisible(true);
}
}

public void whiteTurn()
{
   Va.wc=0;
   Va.ind=0;
                for(int i = 0;i<=7;i++)
   {
         for(int j=0;j<=7;j++)
          { 
              if(Va.bt[i][j].getIcon()==null)
                  {
                        wRightDownThread(i,j);
                        wRightUpThread(i,j);
                        wLeftUpThread(i,j);
                        wLeftDownThread(i,j);
                        wLeftThread(i,j);
                        wUpThread(i,j);
                        wRightThread(i,j);    
                       wDownThread(i,j);
                               if(chance==true)
                                     {
                                      Va.but[Va.ind] = Va.bt[i][j];
                                       Va.ind++;
                                        if(Va.Two)
                                        Va.bt[i][j].setIcon(va.icon3);
                                        Va.wc++;
                                       }
                     chance = false;
                  }
           }
   }
                if(Va.wc>=1)
                 Va.NO_WHITE_LEFT=0;
         if(Va.wc==0)
             {
               Va.NO_WHITE_LEFT=1;
                       if(Va.NO_BLACK_LEFT==1)
                                finalDisplay();
             else
              blackTurn();
              }

}
public void blackTurn()
{
   Va.bc=0;
   Va.ind=0;
                for(int i = 0;i<=7;i++)
   {
         for(int j=0;j<=7;j++)
          { 
              if(Va.bt[i][j].getIcon()==null)
                  {
                        bRightDownThread(i,j);
                        bRightUpThread(i,j);
                        bLeftUpThread(i,j);
                        bLeftDownThread(i,j);
                        bLeftThread(i,j);
                        bUpThread(i,j);
                        bRightThread(i,j);
                       bDownThread(i,j);
                                                            if(chance==true)
                                     {
                                      Va.but[Va.ind] = Va.bt[i][j];
                                       Va.ind++;
                                        Va.bt[i][j].setIcon(va.icon2);
                                        Va.bc++;
                                       }
                         chance = false;
                  }
           }
   }

               if(Va.bc>=1)
                 Va.NO_BLACK_LEFT=0;
         if(Va.bc==0)
             {
               Va.NO_BLACK_LEFT=1;
                       if(Va.NO_WHITE_LEFT==1)
                                finalDisplay();
             else
                  {
                      whiteTurn();
                           if(Va.One && Va.end!=true)
    {
           	Random ra=new Random();
	int num=ra.nextInt(Va.ind); 

                    clip1.play();
                   if(Va.butt[num][0]==1)
                                          wFlipRight(Va.but[num].row,Va.but[num].column);

                      if(Va.butt[num][1]==1)
                                       wFlipLeft(Va.but[num].row,Va.but[num].column);

                      if(Va.butt[num][2]==1)
                                          wFlipUp(Va.but[num].row,Va.but[num].column);

                            if(Va.butt[num][3]==1)
                                       wFlipDown(Va.but[num].row,Va.but[num].column);
                                      
                            if(Va.butt[num][4]==1)
                                          wFlipRightUp(Va.but[num].row,Va.but[num].column);


                            if(Va.butt[num][5]==1)
                                        wFlipRightDown(Va.but[num].row,Va.but[num].column);

                            if(Va.butt[num][6]==1)
                                       wFlipLeftUp(Va.but[num].row,Va.but[num].column);

                            if(Va.butt[num][7]==1)
                                        wFlipLeftDown(Va.but[num].row,Va.but[num].column);

  Va.but[num].setIcon(va.icon1);
                              Va.black_count=0;
                              Va.white_count=0;
                                            for(int r = 0;r<=7;r++)
                                               {
                                                     for(int c=0;c<=7;c++)
                                                            { 
                                                               if(Va.bt[r][c].getIcon()==va.icon)
                                                                   Va.black_count++;
                                                                else if(Va.bt[r][c].getIcon()==va.icon1)
                                                                    Va.white_count++;
                                                            }
                                                 }
                                  lab1.setText(Va.username+":" + Va.black_count);
                                  lab2.setText("Computer"+":" + Va.white_count);
              for(int j=0;j<Va.ind;j++)
                             {
                                   if(Va.but[j]!=Va.but[num])
                                   Va.but[j].setIcon(null);
                                             for(int k=0;k<8;k++)
                                                       Va.butt[j][k]=0;
                             }
Va.wc=0;
Va.ind=0;
blackTurn();   
     }
                     }
              

              }
}

}

