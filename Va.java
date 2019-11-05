import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
class Va
{
public static int ind=0;
public static int wc=0;
public static int bc=0;
public static boolean end=false;
public static boolean One = false;
public static boolean Two = false;
public static int black_count=2;
public static int white_count=2;
public static String username="";
public static String username1="";
public static int NO_WHITE_LEFT=0;
public static int NO_BLACK_LEFT=0;
static MyButton but[] = new MyButton[20];
public static int butt[][] = new int[20][8];
URL obj = getClass().getResource("images/download1.png");
ImageIcon icon = new ImageIcon(obj);
URL obj1 = getClass().getResource("images/download2.png");
ImageIcon icon1 = new ImageIcon(obj1);
URL obj2 = getClass().getResource("images/download3.png");
 ImageIcon icon2 = new ImageIcon(obj2);
URL obj3 = getClass().getResource("images/download4.png");
ImageIcon icon3 = new ImageIcon(obj3);
URL obj4 = getClass().getResource("images/superb.jpg");
ImageIcon superb = new ImageIcon(obj4);
static MyButton bt[][] = new MyButton[8][8];
}