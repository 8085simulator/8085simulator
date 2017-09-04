
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


class lcd extends javax.swing.JFrame {
    public int x=-30,y=-30,s=60,gap=60;
    public int a[][]=new int[4][7];

    public int i=0;
    char colour='f';
    public lcd() {
        initComponents();
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<7;j++)
            {
                a[i][j]=1;
            }
        }
        canvas1.setBackground(new java.awt.Color(0,150,0));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new lcdCanvas(this);
        canvas2 = new lcdCanvas(this);
        canvas3 = new lcdCanvas(this);
        canvas4 = new lcdCanvas(this);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("7 Segment Cathode Display");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        canvas1.setName("canvas1"); // NOI18N

        canvas2.setBackground(new java.awt.Color(0, 140, 0));
        canvas2.setName("canvas2"); // NOI18N

        canvas3.setBackground(new java.awt.Color(0, 140, 0));
        canvas3.setName("canvas3"); // NOI18N

        canvas4.setBackground(new java.awt.Color(0, 140, 0));
        canvas4.setName("canvas4"); // NOI18N

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("File");
        jMenu1.setName("jMenu1"); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Settings");
        jMenu2.setName("jMenu2"); // NOI18N

        jMenu3.setText("Set Colour");
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem2.setText("Blue");
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem8.setText("Default");
        jMenuItem8.setName("jMenuItem8"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem6.setText("Disco");
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Gray");
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem3.setText("Green");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Magenta");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem1.setText("Red");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem5.setText("Yellow");
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        lcdCanvas c=(lcdCanvas)canvas1;
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        colour='b';
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        colour='g';
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        colour='m';
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        colour='r';
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        colour='y';
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        colour='u';
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        colour='e';
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        colour='f';
    }//GEN-LAST:event_jMenuItem8ActionPerformed

                                                                                          

   public int[] decoder(char c)
   {
       int b[]=new int[7];
       switch(c)
       {
           case '0':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case '1':b[0]=0;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=0;b[6]=0;break;
           case '2':b[0]=1;b[1]=1;b[2]=0;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case '3':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=0;b[5]=0;b[6]=1;break;
           case '4':b[0]=0;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=1;b[6]=1;break;
           case '5':b[0]=1;b[1]=0;b[2]=1;b[3]=1;b[4]=0;b[5]=1;b[6]=1;break;
           case '6':b[0]=1;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case '7':b[0]=1;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=0;b[6]=0;break;
           case '8':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case '9':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=0;b[5]=1;b[6]=1;break;
           case 'a':b[0]=1;b[1]=1;b[2]=1;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'A':b[0]=1;b[1]=1;b[2]=1;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'b':b[0]=0;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'B':b[0]=0;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'c':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case 'C':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case 'd':b[0]=0;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case 'D':b[0]=0;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case 'e':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'E':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'f':b[0]=1;b[1]=0;b[2]=0;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'F':b[0]=1;b[1]=0;b[2]=0;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;

       }
       return b;
   }

    public static void main(String args[]) {
        
       
       lcd o=new lcd();
       o.a[0]=o.decoder('9');
       o.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public java.awt.Canvas canvas1;
    public java.awt.Canvas canvas2;
    public java.awt.Canvas canvas3;
    public java.awt.Canvas canvas4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables


}
class lcdCanvas extends Canvas
{

    int x=-30,y=-40,s=30;

        int a[][]=new int[1][7];

    lcd o;
    public lcdCanvas() {

            a[0]=decoder('5');

    }
    public lcdCanvas(char c) {

            a[0]=decoder(c);


    }

    public lcdCanvas(lcd o) {

            this.o=o;
            a[0]=decoder('5');

    }
    public void reDraw(char c)
    {


           a[0]=decoder(c);
            repaint();
    }

    java.awt.Color c1=new java.awt.Color(0,220,0);
    java.awt.Color c2=new java.awt.Color(0,100,0);

    public void colour(char c)
    {
        switch(c)
        {
            case 'r':c1=new java.awt.Color(220,0,0);
                     c2=new java.awt.Color(100,0,0);
                     o.canvas1.setBackground(new java.awt.Color(140,0,0));
                     o.canvas2.setBackground(new java.awt.Color(140,0,0));
                     o.canvas3.setBackground(new java.awt.Color(140,0,0));
                     o.canvas4.setBackground(new java.awt.Color(140,0,0));
                break;

            case 'g':c1=new java.awt.Color(0,220,0);
                     c2=new java.awt.Color(0,100,0);
                     o.canvas1.setBackground(new java.awt.Color(0,140,0));
                     o.canvas2.setBackground(new java.awt.Color(0,140,0));
                     o.canvas3.setBackground(new java.awt.Color(0,140,0));
                     o.canvas4.setBackground(new java.awt.Color(0,140,0));
                break;
            case 'b':c1=new java.awt.Color(0,0,220);
                     c2=new java.awt.Color(0,0,100);
                     o.canvas1.setBackground(new java.awt.Color(0,0,140));
                     o.canvas2.setBackground(new java.awt.Color(0,0,140));
                     o.canvas3.setBackground(new java.awt.Color(0,0,140));
                     o.canvas4.setBackground(new java.awt.Color(0,0,140));
                break;

            case 'y':c1=new java.awt.Color(220,220,0);
                     c2=new java.awt.Color(100,100,0);
                     o.canvas1.setBackground(new java.awt.Color(140,140,0));
                     o.canvas2.setBackground(new java.awt.Color(140,140,0));
                     o.canvas3.setBackground(new java.awt.Color(140,140,0));
                     o.canvas4.setBackground(new java.awt.Color(140,140,0));
                break;

            case 'f':c1=new java.awt.Color(0,220,220);
                     c2=new java.awt.Color(0,100,100);
                     o.canvas1.setBackground(new java.awt.Color(0,140,140));
                     o.canvas2.setBackground(new java.awt.Color(0,140,140));
                     o.canvas3.setBackground(new java.awt.Color(0,140,140));
                     o.canvas4.setBackground(new java.awt.Color(0,140,140));
                break;

            case 'm':c1=new java.awt.Color(220,0,220);
                     c2=new java.awt.Color(100,0,100);
                     o.canvas1.setBackground(new java.awt.Color(140,0,140));
                     o.canvas2.setBackground(new java.awt.Color(140,0,140));
                     o.canvas3.setBackground(new java.awt.Color(140,0,140));
                     o.canvas4.setBackground(new java.awt.Color(140,0,140));
                break;

            case 'e':c1=new java.awt.Color(220,220,220);
                     c2=new java.awt.Color(100,100,100);
                     o.canvas1.setBackground(new java.awt.Color(140,140,140));
                     o.canvas2.setBackground(new java.awt.Color(140,140,140));
                     o.canvas3.setBackground(new java.awt.Color(140,140,140));
                     o.canvas4.setBackground(new java.awt.Color(140,140,140));
                break;

            case 'u':c1=new java.awt.Color(20,20,20);
                     c2=new java.awt.Color(100,100,100);
                     o.canvas1.setBackground(new java.awt.Color(140,140,0));
                     o.canvas2.setBackground(new java.awt.Color(140,0,140));
                     o.canvas3.setBackground(new java.awt.Color(0,140,140));
                     o.canvas4.setBackground(new java.awt.Color(140,0,0));
                break;
            

        }

    }

    public void paint(Graphics g1)
    {

        colour(o.colour);
        Graphics2D g = (Graphics2D) g1;
        g.setColor(c1);
        g.setStroke(new BasicStroke(5));
        if(a[0][4]==1)g.drawLine(x+40,y+80,x+40,y+100);
        if(a[0][2]==1)g.drawLine(x+60,y+80,x+60,y+100);
        if(a[0][5]==1)g.drawLine(x+40,y+50,x+40,y+70);
        if(a[0][1]==1)g.drawLine(x+60,y+50,x+60,y+70);

        if(a[0][3]==1)g.drawLine(x+42,y+105,x+58,y+105);
        if(a[0][6]==1)g.drawLine(x+42,y+75,x+58,y+75);
        if(a[0][0]==1)g.drawLine(x+42,y+45,x+58,y+45);

        g.setColor(c2);

        if(a[0][4]==0)g.drawLine(x+40,y+80,x+40,y+100);
        if(a[0][2]==0)g.drawLine(x+60,y+80,x+60,y+100);
        if(a[0][5]==0)g.drawLine(x+40,y+50,x+40,y+70);
        if(a[0][1]==0)g.drawLine(x+60,y+50,x+60,y+70);

        if(a[0][3]==0)g.drawLine(x+42,y+105,x+58,y+105);
        if(a[0][6]==0)g.drawLine(x+42,y+75,x+58,y+75);
        if(a[0][0]==0)g.drawLine(x+42,y+45,x+58,y+45);

    }

    public int[] decoder(char c)
   {
       int b[]=new int[7];
       switch(c)
       {
           case '0':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case '1':b[0]=0;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=0;b[6]=0;break;
           case '2':b[0]=1;b[1]=1;b[2]=0;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case '3':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=0;b[5]=0;b[6]=1;break;
           case '4':b[0]=0;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=1;b[6]=1;break;
           case '5':b[0]=1;b[1]=0;b[2]=1;b[3]=1;b[4]=0;b[5]=1;b[6]=1;break;
           case '6':b[0]=1;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case '7':b[0]=1;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=0;b[6]=0;break;
           case '8':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case '9':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=0;b[5]=1;b[6]=1;break;
           case 'a':b[0]=1;b[1]=1;b[2]=1;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'A':b[0]=1;b[1]=1;b[2]=1;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'b':b[0]=0;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'B':b[0]=0;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'c':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case 'C':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case 'd':b[0]=0;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case 'D':b[0]=0;b[1]=1;b[2]=1;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case 'e':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'E':b[0]=1;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=1;break;
           case 'f':b[0]=1;b[1]=0;b[2]=0;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'F':b[0]=1;b[1]=0;b[2]=0;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'g':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=0;b[5]=1;b[6]=1;break;
           case 'G':b[0]=1;b[1]=1;b[2]=1;b[3]=1;b[4]=0;b[5]=1;b[6]=1;break;
           case 'H':b[0]=0;b[1]=1;b[2]=1;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'n':b[0]=0;b[1]=0;b[2]=1;b[3]=0;b[4]=1;b[5]=0;b[6]=1;break;
           case 'N':b[0]=0;b[1]=0;b[2]=1;b[3]=0;b[4]=1;b[5]=0;b[6]=1;break;
           case 'i':b[0]=0;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=0;b[6]=0;break;
           case 'I':b[0]=0;b[1]=1;b[2]=1;b[3]=0;b[4]=0;b[5]=0;b[6]=0;break;
           case 'l':b[0]=0;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case 'L':b[0]=0;b[1]=0;b[2]=0;b[3]=1;b[4]=1;b[5]=1;b[6]=0;break;
           case 'r':b[0]=0;b[1]=0;b[2]=0;b[3]=0;b[4]=1;b[5]=0;b[6]=1;break;
           case 'R':b[0]=0;b[1]=0;b[2]=0;b[3]=0;b[4]=1;b[5]=0;b[6]=1;break;
           case 'o':b[0]=0;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case 'O':b[0]=0;b[1]=0;b[2]=1;b[3]=1;b[4]=1;b[5]=0;b[6]=1;break;
           case 'p':b[0]=1;b[1]=1;b[2]=0;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case 'P':b[0]=1;b[1]=1;b[2]=0;b[3]=0;b[4]=1;b[5]=1;b[6]=1;break;
           case '-':b[0]=0;b[1]=0;b[2]=0;b[3]=0;b[4]=0;b[5]=0;b[6]=1;break;

       }
       return b;
   }


}
