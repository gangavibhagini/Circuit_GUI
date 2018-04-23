package ganga.gui_swing;


import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;


public class DrawCircuit extends JFrame {

    boolean circuitOpener= false;

    private JButton onButton;
    private JButton offButton;
    private Color color=null;

    public void paint(Graphics g) {
        g = (Graphics2D)g;
        g.setColor(Color.red);
        g.fillOval(325,170,10,10);
        g.fillOval(350,170,10,10);
        g.drawOval(570,250,75,75);
        g.drawRect(40,250, 70, 70);
        g.drawString("Power", 57, 275);
        g.drawString("Supply", 54, 290);
        g.drawString("Switch", 322, 200);

        if(color!=null){
            g.setColor(color);
            g.fillOval(570,250,73,73);
        }
        else{
            g.drawOval(570,250,75,75);
        }
        g.setColor(Color.RED);
        g.drawLine(610, 400, 70, 400);
        g.drawLine(610, 400, 610, 325);
        g.drawLine(70, 400, 70, 320);
        g.drawLine(75, 250, 75, 175);
        g.drawLine(610, 250, 610, 173);
        g.drawLine(610, 175, 360, 175);
        g.drawLine(325, 175, 75, 175);


        if (circuitOpener){
            System.out.println("circuit Open");
            g.drawLine(360, 160, 330, 170);
            g.setColor(Color.WHITE);
            g.drawLine(335,175,350,175);
        }
        else{
            System.out.println("Circuit Close");
            g.setColor(Color.WHITE);
            g.drawLine(360,160,330,170);
            g.setColor(Color.RED);
            g.drawLine(335,175,350,175);
        }
    }
    public static void main(String args[])
    {

        DrawCircuit frame = new DrawCircuit();

    }

    private void setupEventHandlers(){
        onButton.addActionListener(new ButtonActionListener());
        offButton.addActionListener(new ButtonActionListener());
    }

    public DrawCircuit(){
        JPanel p = new JPanel();
        //setLayout(new BorderLayout());
        offButton = new JButton("Off");
        onButton = new JButton("On");

        p.add(onButton);
        p.add(offButton);
        Container c = this.getContentPane();
        c.add(p);
        setDefaultCloseOperation(3);
        setTitle("Programming Assignment 2");
        setSize(700,500);
        setBackground(Color.white);
        setVisible(true);


        setupEventHandlers();
    }

    public class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand();
            if(cmd.equals("On")){
                circuitOpener=true;

                System.out.println("On button clicked");
                color = Color.WHITE;
                repaint();

            }
            if(cmd.equals("Off")){
                circuitOpener=false;
                System.out.println("Off button clicked");
                color = Color.YELLOW;
                repaint();
            }
        }
    }
}

