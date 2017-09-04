import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SteperMotor extends javax.swing.JFrame {

    int x=-80,y=-80;
    int rotateLeft=0,rotateRight=0,stop=1;
    double i=4;
    Graphics g;
    int speed=50;
   CanvasDraw c;

    public SteperMotor() {
        initComponents();
        c=(CanvasDraw) canvas1;
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new CanvasDraw(this);
        jSlider1 = new javax.swing.JSlider();
        jButtonLeft = new javax.swing.JButton();
        jButtonRight = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stepper Motor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        canvas1.setName("canvas1"); // NOI18N

        jSlider1.setName("jSlider1"); // NOI18N
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });
        jSlider1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSlider1KeyReleased(evt);
            }
        });

        jButtonLeft.setText("Left");
        jButtonLeft.setName("jButtonLeft"); // NOI18N
        jButtonLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeftActionPerformed(evt);
            }
        });

        jButtonRight.setText("Right");
        jButtonRight.setName("jButtonRight"); // NOI18N
        jButtonRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRightActionPerformed(evt);
            }
        });

        jButtonStop.setText("Stop");
        jButtonStop.setName("jButtonStop"); // NOI18N
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLeft)
                .addGap(37, 37, 37)
                .addComponent(jButtonStop)
                .addGap(28, 28, 28)
                .addComponent(jButtonRight))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLeft)
                    .addComponent(jButtonRight)
                    .addComponent(jButtonStop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
                speed=(100-jSlider1.getValue());
    }//GEN-LAST:event_jSlider1MouseReleased

    private void jButtonLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeftActionPerformed
        c.rotateLeft();
    }//GEN-LAST:event_jButtonLeftActionPerformed

    private void jButtonRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRightActionPerformed
        c.rotateRight();
    }//GEN-LAST:event_jButtonRightActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        c.stop();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        c.terminate();
    }//GEN-LAST:event_formWindowClosing

    private void jSlider1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSlider1KeyReleased
                speed=(100-jSlider1.getValue());

    }//GEN-LAST:event_jSlider1KeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SteperMotor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public java.awt.Canvas canvas1;
    private javax.swing.JButton jButtonLeft;
    private javax.swing.JButton jButtonRight;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables

}

class CanvasDraw extends Canvas implements Runnable
{
    Graphics g;
    ExecutorService exec = Executors.newCachedThreadPool();
    SteperMotor o;
    boolean run=true;

    public CanvasDraw(SteperMotor o)
    {
        this.o=o;
        exec.execute(this);

    }

    public void rotateRight()
    {
        o.rotateLeft=0;o.rotateRight=1;o.stop=0;

    }
    public void rotateLeft()
    {

        o.rotateLeft=1;o.rotateRight=0;o.stop=0;

    }
    public void stop()
    {
        o.rotateLeft=0;o.rotateRight=0;o.stop=1;


    }

    public void run()
    {
       while(run)  {
            repaint();
            if(o.rotateLeft==1) {
                o.i = o.i - 0.05;
            }
            else if(o.rotateRight==1) {
                o.i = o.i + 0.05;
            }
            
            try {
                Thread.sleep(o.speed);

            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public void paint(Graphics g1)
    {

        Graphics2D g = (Graphics2D) g1;
        g.setStroke(new BasicStroke(3));
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, 300, 300);
        g.setColor(new java.awt.Color(0,220,0));
        g.drawOval(o.x+96,o.y+96,108,108);
        g.setColor(Color.BLACK);
        g.drawOval(o.x+96,o.y+96,110,110);


                for(int j=0;j<12;j++){
                g.setColor(new java.awt.Color(0,220,0));
                g.drawLine(o.x+150,o.y+150, (int) (o.x +150+ 50 * Math.cos(o.i+j)),(int) (o.y +150+ 50 * Math.sin(o.i+j)));
                
                }
        
    }

    BufferedImage bufferedimage;
    Rectangle rect=null;
    public void update(Graphics g){
        if(!getBounds().equals(rect)){
            rect=getBounds();
            bufferedimage=new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
        }
        if(run){

            paint(bufferedimage.getGraphics());
            g.drawImage(bufferedimage, 0, 0, null);
        }
    }

    public void terminate()
    {
        run=false;
        exec.shutdown();
    }

}