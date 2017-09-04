
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TimingDiagram extends javax.swing.JFrame {

    public TimingDiagram() {
        initComponents();
        ((TimingPaint)jPanel1).memoryCycleDecoder(new Assembler(),"C000");

    }

    private Assembler o;
    public TimingDiagram(Assembler o,String address) {
        this.o=o;
        initComponents();
        ((TimingPaint)jPanel1).memoryCycleDecoder(o,address);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new TimingPaint(this.o);
        jSlider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Timing Diagram");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(100, 100, 500, 250));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 510));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jSlider1.setToolTipText("");
        jSlider1.setValue(0);
        jSlider1.setName("jSlider1"); // NOI18N
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
        o.timingDiagramX=jSlider1.getValue();
        repaint();
    }//GEN-LAST:event_jSlider1MouseReleased


    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TimingDiagram o = new TimingDiagram(new Assembler(),"C000");
                o.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables

}

class TimingPaint extends JPanel
{
    Graphics g;
    
    public TimingPaint(Assembler o){
        this.o=o;
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg.BLACK);

    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg.WHITE);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, 100000, 520);
    }



    @Override
    public void paintComponent(Graphics g) {
        this.g=g;
        super.paintComponent(g);
        end=500;
        x=70-o.timingDiagramX *20;
        nameRows(x-70);
        int addressDec=this.addressDec;
         for(int i=0;i<code.length();i++,addressDec++)
         {
            cycleDecoder(code.charAt(i),o.engine.Dec2Hex(addressDec), o.engine.Dec2Hex2digit(o.matrix.memory[addressDec]));
         }
    }

   
        int end=500;
    private void opcodeFetchTable(int x)
    {
        g.drawLine(x+0, 10, x+400, 10);
        g.drawString("OPCODE FETCH CYCLE", x+127, 25);
        g.drawLine(x+0, 30, x+400, 30);
        g.drawString("T1", x+45, 45);
        g.drawString("T2", x+145, 45);
        g.drawString("T3", x+245, 45);
        g.drawString("T4", x+345, 45);
        g.drawLine(x+0, 50, x+400, 50);

        g.drawLine(x+0, 10, x+0, end);
        g.drawLine(x+100, 30, x+100, end);
        g.drawLine(x+200, 30, x+200, end);
        g.drawLine(x+300, 30, x+300, end);
        g.drawLine(x+400, 10, x+400, end);
        g.drawLine(x+0, end, x+400, end);

    }

    private void memoryReadTable(int x)
    {
        g.drawLine(x+0, 10, x+300, 10);
        g.drawString("MEMORY READ CYCLE", x+80, 25);
        g.drawLine(x+0, 30, x+300, 30);
        g.drawString("T1", x+45,  45);
        g.drawString("T2", x+145, 45);
        g.drawString("T3", x+245, 45);
        g.drawLine(x+0, 50, x+300, 50);

        g.drawLine(x+0, 10, x+0, end);
        g.drawLine(x+100, 30, x+100, end);
        g.drawLine(x+200, 30, x+200, end);
        g.drawLine(x+300, 10, x+300, end);
        g.drawLine(x+0, end, x+300, end);

    }

     private void memoryWriteTable(int x)
    {
        g.drawLine(x+0, 10, x+300, 10);
        g.drawString("MEMORY WRITE CYCLE", x+80, 25);
        g.drawLine(x+0, 30, x+300, 30);
        g.drawString("T1", x+45,  45);
        g.drawString("T2", x+145, 45);
        g.drawString("T3", x+245, 45);
        g.drawLine(x+0, 50, x+300, 50);

        g.drawLine(x+0, 10, x+0, end);
        g.drawLine(x+100, 30, x+100, end);
        g.drawLine(x+200, 30, x+200, end);
        g.drawLine(x+300, 10, x+300, end);
        g.drawLine(x+0, end, x+300, end);

    }

     private void ioReadTable(int x)
    {
        g.drawLine(x+0, 10, x+300, 10);
        g.drawString("I/O READ CYCLE", x+105, 25);
        g.drawLine(x+0, 30, x+300, 30);
        g.drawString("T1", x+45,  45);
        g.drawString("T2", x+145, 45);
        g.drawString("T3", x+245, 45);
        g.drawLine(x+0, 50, x+300, 50);

        g.drawLine(x+0, 10, x+0, end);
        g.drawLine(x+100, 30, x+100, end);
        g.drawLine(x+200, 30, x+200, end);
        g.drawLine(x+300, 10, x+300, end);
        g.drawLine(x+0, end, x+300, end);

    }
    
     private void ioWriteTable(int x)
    {
        g.drawLine(x+0, 10, x+300, 10);
        g.drawString("I/O WRITE CYCLE", x+100, 25);
        g.drawLine(x+0, 30, x+300, 30);
        g.drawString("T1", x+45,  45);
        g.drawString("T2", x+145, 45);
        g.drawString("T3", x+245, 45);
        g.drawLine(x+0, 50, x+300, 50);

        g.drawLine(x+0, 10, x+0, end);
        g.drawLine(x+100, 30, x+100, end);
        g.drawLine(x+200, 30, x+200, end);
        g.drawLine(x+300, 10, x+300, end);
        g.drawLine(x+0, end, x+300, end);

    }

     private void opcodeFetchTable6state(int x)
    {
        g.drawLine(x+0, 10, x+600, 10);
        g.drawString("OPCODE FETCH CYCLE WITH 6 T-STATES", x+180, 25);
        g.drawLine(x+0, 30, x+600, 30);
        g.drawString("T1", x+45, 45);
        g.drawString("T2", x+145, 45);
        g.drawString("T3", x+245, 45);
        g.drawString("T4", x+345, 45);
        g.drawString("T5", x+445, 45);
        g.drawString("T6", x+545, 45);
        g.drawLine(x+0, 50, x+600, 50);

        g.drawLine(x+0, 10, x+0, end);
        g.drawLine(x+100, 30, x+100, end);
        g.drawLine(x+200, 30, x+200, end);
        g.drawLine(x+300, 30, x+300, end);
        g.drawLine(x+400, 30, x+400, end);
        g.drawLine(x+500, 30, x+500, end);
        g.drawLine(x+600, 10, x+600, end);
        g.drawLine(x+0, end, x+600, end);

    }

     private void busIdleTable(int x)
     {
        g.drawLine(x+0, 10, x+100, 10);
        g.drawString("BUS IDLE CYCLE", x+2, 25);
        g.drawLine(x+0, 30, x+100, 30);
        g.drawString("T1", x+45,  45);
        g.drawLine(x+0, 50, x+100, 50);

        g.drawLine(x+0, 10, x+0, end);
        g.drawLine(x+100, 10, x+100, end);
        g.drawLine(x+0, end, x+100, end);

     }

     private void nameRows(int x)
     {
         int y=0;
         g.drawString("CLK", 25+x, 80);
         g.drawString("A15-A8", 15+x, 140);
         g.drawString("AD7-AD0", 5+x, 180);
         g.drawString("ALE", 35+x, 230);
         g.drawLine(46+x, 288, 54+x, 288);
         g.drawString("IO / M", 25+x, 300);
         g.drawString("S1", 40+x, 335);
         g.drawString("S0", 40+x, 375);
         g.drawLine(41+x, 438, 55+x, 438);
         g.drawString("RD", 40+x, 450);
         g.drawLine(40+x, 478, 58+x, 478);
         g.drawString("WR", 40+x, 490);


     }

    private void clock(int x,int tstate) {
        int y = -35;
        g.setColor(Color.green);
        for(int i=0;i<tstate;i++,x+=100)
        {
        g.drawLine(x + 0,  y + 100, x + 10, y + 120);
        g.drawLine(x + 10, y + 120, x + 50, y + 120);
        g.drawLine(x + 50, y + 120, x + 60, y + 100);
        g.drawLine(x + 60, y + 100, x + 100, y + 100);
        }
        g.setColor(Color.WHITE);
    }

    private void A15A8(int x,int tstate) //times: 3,4,6
    {
         int y=125;
         g.setColor(Color.yellow);
         g.drawLine(x, y, x+5, y);
         g.drawLine(x, y+20, x+5, y+20);
         g.drawLine(x+10, y, x+300, y);
         g.drawLine(x+10, y+20, x+300, y+20);
         g.drawLine(x+5, y, x+10, y+20);
         g.drawLine(x+10, y, x+5, y+20);
        
        if(tstate==4){
            x=x+300;
        g.drawLine(x, y, x+5, y);
        g.drawLine(x, y+20, x+5, y+20);
        g.drawLine(x+10, y, x+100, y);
        g.drawLine(x+10, y+20, x+100, y+20);
        g.drawLine(x+5, y, x+10, y+20);
        g.drawLine(x+10, y, x+5, y+20);
        x=x-300;
        }
        else if(tstate==6){
            x=x+300;
         g.drawLine(x, y, x+5, y);
         g.drawLine(x, y+20, x+5, y+20);
         g.drawLine(x+10, y, x+300, y);
         g.drawLine(x+10, y+20, x+300, y+20);
         g.drawLine(x+5, y, x+10, y+20);
         g.drawLine(x+10, y, x+5, y+20);
            x=x-300;
         g.setColor(Color.white);
        }
    }

    private void AD7AD0(int x,int tstate)
    {
        g.setColor(new Color(255, 255, 170));
        int y=165;
         if(tstate==4){
         g.drawLine(x, y, x+5, y);
         g.drawLine(x, y+20, x+5, y+20);
         g.drawLine(x+10, y, x+5, y+20);
         g.drawLine(x+5, y, x+10, y+20);
         }
         else{
            for(int i=0;i<5;i+=4)
            {
            g.drawLine(x+i, y+10, x+i, y+10);
            }
         g.drawLine(x+10, y, x+5, y+10);
         g.drawLine(x+5, y+10, x+10, y+20);
         }
         g.drawLine(x+10, y, x+100, y);
         g.drawLine(x+10, y+20, x+100, y+20);
         g.drawLine(x+100, y, x+105, y+10);
         g.drawLine(x+105, y+10, x+100, y+20);

         for(int i=0;i<45;i+=6)
         {
             g.drawLine(x+105+i, y+10, x+107+i, y+10);
         }

         g.drawLine(x+150, y+10, x+155, y+20);
         g.drawLine(x+155, y, x+150, y+10);
         g.drawLine(x+155, y, x+255, y);
         g.drawLine(x+155, y+20, x+255, y+20);
         g.drawLine(x+255, y, x+260, y+10);
         g.drawLine(x+260, y+10, x+255, y+20);
         int up=195;
         if(tstate==4)up=295;
         else if(tstate==6)up=495;

         for(int i=155;i<up;i+=6)
         {
             g.drawLine(x+105+i, y+10, x+107+i, y+10);
         }
        g.setColor(Color.white);

    }

    private void ALE(int x,int tstate)
    {
        int y=235;
        g.setColor(Color.blue);
        g.drawLine(x, y, x+5, y-20);
        g.drawLine(x+5, y-20, x+50, y-20);
        g.drawLine(x+50, y-20, x+55, y);
        g.drawLine(x+55, y, x+300, y);
        if(tstate==4)       g.drawLine(x+300, y, x+400, y);
        else if(tstate==6)  g.drawLine(x+300, y, x+600, y);
        g.setColor(Color.white);

    }


    private void controlSignal(int x,int y,int toggle,int tstate)
    {
        g.setColor(Color.red);
        if(toggle==1){
        g.drawLine(x, y, x+100, y);
        g.drawLine(x+100, y, x+120, y);
        g.drawLine(x+120, y, x+125, y+20);
        g.drawLine(x+125, y+20, x+275, y+20);
        g.drawLine(x+275, y+20, x+280, y);
        g.drawLine(x+280, y, x+300, y);
        }
        else{
            g.drawLine(x, y, x+300, y);
        }
        if(tstate==4)       g.drawLine(x+300, y, x+400, y);
        else if(tstate==6)  g.drawLine(x+300, y, x+600, y);
        g.setColor(Color.WHITE);
    }

    /**
     *
     * @param x x co-ordinate
     * @param y y co-ordinate
     * @param toggle 0 & 1 & 2 for neutral
     * @param tstate no of tstate to be in that state
     */
    private void signalActiveHigh(int x,int y,int toggle,int tstate)
    {
        g.setColor(Color.MAGENTA);
        int i=0;
        if(toggle==1){
                    i=1;
                    g.drawLine(x, y, x+5, y);
                    g.drawLine(x+5, y, x+10, y-20);
                    y=y-20;
                    g.drawLine(x+10, y, x+100, y);
        }
        else if(toggle==0){
                    i=1;
                    y=y-20;
                    g.drawLine(x, y, x+5, y);
                    g.drawLine(x+5, y, x+10, y+20);
                    y=y+20;
                    g.drawLine(x+10, y, x+100, y);
        }
        else if(toggle==4)
        {
            for(;i<tstate;i++)
            {
               g.drawLine(x+100*i,y-20,x+100*(i+1),y-20);
            }
        }
        for(;i<tstate;i++)
        {
               g.drawLine(x+100*i,y,x+100*(i+1),y);
        }
        g.setColor(Color.white);
    }

    private void signalActiveLow(int x,int y,int toggle,int tstate)
    {
        g.setColor(Color.MAGENTA);
        int i=0;
        if(toggle==0){
                    i=1;
                    g.drawLine(x, y, x+5, y);
                    g.drawLine(x+5, y, x+10, y-20);
                    y=y-20;
                    g.drawLine(x+10, y, x+100, y);
        }
        else if(toggle==1){
                    i=1;
                    y=y-20;
                    g.drawLine(x, y, x+5, y);
                    g.drawLine(x+5, y, x+10, y+20);
                    y=y+20;
                    g.drawLine(x+10, y, x+100, y);
        }
        for(;i<tstate;i++)
        {
               g.drawLine(x+100*i,y,x+100*(i+1),y);
        }
         g.setColor(Color.WHITE);
 }

    int io=0,s1=0,s0=0;
    /**
     * 
     * @param i 1 for io,2 for s1,3 for s0
     */
    private int signalLogicHigh(int i)
    {
         if(i==1){
             if(io==0)return 1;
             else   return 4;
         }
         else if(i==2){
             if(s1==0)return 1;
             else   return 4;
         }
         else{
             if(s0==0)return 1;
             else   return 4;
         }
    }

    private int signalLogicLow(int i)
    {
         if(i==1){
             if(io==1)return 0;
             else   return 3;
         }
         else if(i==2){
             if(s1==1)return 0;
             else   return 3;
         }
         else{
             if(s0==1)return 0;
             else   return 3;
         }
    }

    private void opcodeFetch(int x,String address,String opcode)
    {
        
        opcodeFetchTable(x);
        clock(x, 4);
        A15A8(x, 4);
        AD7AD0(x, 4);
        ALE(x, 4);
        signalActiveHigh(x, 300, signalLogicLow(1), 4);
        signalActiveHigh(x, 340, signalLogicHigh(2), 4);
        signalActiveHigh(x, 380, signalLogicHigh(3), 4);
        controlSignal(x,435,1,4);
        controlSignal(x,475,0,4);
        io=0;s1=1;s0=1;

        x=x-70;
        String highAddress=address.substring(0, 2);
        String lowAddress =address.substring(2, 4);
        g.drawString(highAddress+"   High-Order Memory Address",x+148, 140);
        g.drawString(lowAddress+" Low-Order", x+85, 180);
        g.drawString("Memory Address", x+76, 200);
        g.drawString("Opcode Read "+opcode, x+225, 180);
        g.drawString("Unspecified", x+390, 140);
        g.drawString("Decodes Opcode", x+373, 170);
        g.drawString("ALE = 1", x+80, 230);
        g.drawString("ALE = 0", x+210, 230);
        g.drawLine(x+232, 283,x+238,283);
        g.drawString("IO / M = 0", x+210, 295);
        g.drawString("S1 = 1", x+210, 335);
        g.drawString("S0 = 1", x+210, 375);
        g.drawLine(x+211, 438, x+225, 438);
        g.drawString("RD = 0", x+210, 450);
        g.drawLine(x+209, 480, x+227, 480);
        g.drawString("WR = 1", x+210, 492);

    }

    private void memRead(int x,String address,String opcode)
    {

        memoryReadTable(x);
        clock(x, 3);
        A15A8(x, 3);
        AD7AD0(x, 3);
        ALE(x, 3);
        signalActiveHigh(x, 300, signalLogicLow(1), 3);
        signalActiveHigh(x, 340, signalLogicHigh(2), 3);
        signalActiveHigh(x, 380, signalLogicLow(3), 3);
        controlSignal(x,435,1,3);
        controlSignal(x,475,0,3);
        io=0;s1=1;s0=0;

        x=x-70;
        String highAddress=address.substring(0, 2);
        String lowAddress =address.substring(2, 4);
        g.drawString(highAddress+"   High-Order Memory Address",x+148, 140);
        g.drawString(lowAddress+" Low-Order", x+85, 180);
        g.drawString("Memory Address", x+76, 200);
        g.drawString("Opcode Read "+opcode, x+225, 180);
        g.drawString("ALE = 1", x+80, 230);
        g.drawString("ALE = 0", x+210, 230);
        g.drawLine(x+232, 283,x+238,283);
        g.drawString("IO / M = 0", x+210, 295);
        g.drawString("S1 = 1", x+210, 335);
        g.drawString("S0 = 0", x+210, 375);
        g.drawLine(x+211, 438, x+225, 438);
        g.drawString("RD = 0", x+210, 450);
        g.drawLine(x+209, 480, x+227, 480);
        g.drawString("WR = 1", x+210, 492);
    }

    private void memWrite(int x,String address,String opcode)
    {
        memoryWriteTable(x);
        clock(x, 3);
        A15A8(x, 3);
        AD7AD0(x, 3);
        ALE(x, 3);
        signalActiveHigh(x, 300, signalLogicLow(1), 3);
        signalActiveHigh(x, 340, signalLogicLow(2), 3);
        signalActiveHigh(x, 380, signalLogicHigh(3), 3);
        controlSignal(x,435,0,3);
        controlSignal(x,475,1,3);
        io=0;s1=0;s0=1;

        x=x-70;
        String highAddress=address.substring(0, 2);
        String lowAddress =address.substring(2, 4);
        g.drawString(highAddress+"   High-Order Memory Address",x+148, 140);
        g.drawString(lowAddress+" Low-Order", x+85, 180);
        g.drawString("Memory Address", x+76, 200);
        g.drawString("Opcode Write "+opcode, x+225, 180);
        g.drawString("ALE = 1", x+80, 230);
        g.drawString("ALE = 0", x+210, 230);
        g.drawLine(x+232, 283,x+238,283);
        g.drawString("IO / M = 0", x+210, 295);
        g.drawString("S1 = 0", x+210, 335);
        g.drawString("S0 = 1", x+210, 375);
        g.drawLine(x+211, 438, x+225, 438);
        g.drawString("RD = 1", x+210, 450);
        g.drawLine(x+209, 480, x+227, 480);
        g.drawString("WR = 0", x+210, 492);
    }

    private void ioRead(int x,String address,String opcode)
    {
        ioReadTable(x);
        clock(x, 3);
        A15A8(x, 3);
        AD7AD0(x, 3);
        ALE(x, 3);
        signalActiveHigh(x, 300, signalLogicHigh(1), 3);
        signalActiveHigh(x, 340, signalLogicHigh(2), 3);
        signalActiveHigh(x, 380, signalLogicLow(3), 3);
        controlSignal(x,435,1,3);
        controlSignal(x,475,0,3);
        io=1;s1=1;s0=0;

        x=x-70;
        String highAddress=address.substring(0, 2);
        g.drawString("         Port Address "+highAddress,x+148, 140);
        g.drawString("Port Address "+highAddress, x+80, 180);
        g.drawString("   Input Data "+opcode, x+225, 180);
        g.drawString("ALE = 1", x+80, 230);
        g.drawString("ALE = 0", x+210, 230);
        g.drawLine(x+232, 283,x+238,283);
        g.drawString("IO / M = 1", x+210, 295);
        g.drawString("S1 = 1", x+210, 335);
        g.drawString("S0 = 0", x+210, 375);
        g.drawLine(x+211, 438, x+225, 438);
        g.drawString("RD = 0", x+210, 450);
        g.drawLine(x+209, 480, x+227, 480);
        g.drawString("WR = 1", x+210, 492);
    }

    private void ioWrite(int x,String address,String opcode)
    {

        ioWriteTable(x);
        clock(x, 3);
        A15A8(x, 3);
        AD7AD0(x, 3);
        ALE(x, 3);
        signalActiveHigh(x, 300, signalLogicHigh(1), 3);
        signalActiveHigh(x, 340, signalLogicLow(2), 3);
        signalActiveHigh(x, 380, signalLogicHigh(3), 3);
        controlSignal(x,435,0,3);
        controlSignal(x,475,1,3);
        io=1;s1=0;s0=1;

        x=x-70;
        String highAddress=address.substring(0, 2);
        g.drawString("        Port Address "+highAddress,x+148, 140);
        g.drawString("Port Address "+highAddress, x+80, 180);
        g.drawString(" Output data "+opcode, x+225, 180);
        g.drawString("ALE = 1", x+80, 230);
        g.drawString("ALE = 0", x+210, 230);
        g.drawLine(x+232, 283,x+238,283);
        g.drawString("IO / M = 1", x+210, 295);
        g.drawString("S1 = 0", x+210, 335);
        g.drawString("S0 = 1", x+210, 375);
        g.drawLine(x+211, 438, x+225, 438);
        g.drawString("RD = 1", x+210, 450);
        g.drawLine(x+209, 480, x+227, 480);
        g.drawString("WR = 0", x+210, 492);
    }

     private void opcodeFetch6State(int x,String address,String opcode)
    {
        opcodeFetchTable6state(x);
        clock(x, 6);
        A15A8(x, 6);
        AD7AD0(x, 6);
        ALE(x, 6);
        signalActiveHigh(x, 300, signalLogicHigh(1),  6);
        signalActiveHigh(x, 340, signalLogicHigh(2), 6);
        signalActiveHigh(x, 380, signalLogicHigh(3), 6);
        controlSignal(x,435,0,6);
        controlSignal(x,475,0,6);
        io=1;s1=1;s0=1;

        x=x-70;
        String highAddress=address.substring(0, 2);
        String lowAddress =address.substring(2, 4);
        g.drawString(highAddress+"   High-Order Memory Address",x+148, 140);
        g.drawString("Decodes Opcode & the next memory address",x+390, 140);
        g.drawString(lowAddress+" Low-Order", x+85, 180);
        g.drawString("Memory Address", x+76, 200);
        g.drawString("Opcode Read "+opcode, x+225, 180);
        g.drawString("ALE = 1", x+80, 230);
        g.drawString("ALE = 0", x+210, 230);
        g.drawLine(x+232, 283,x+238,283);
        g.drawString("IO / M = 1", x+210, 295);
        g.drawString("S1 = 1", x+210, 335);
        g.drawString("S0 = 1", x+210, 375);
        g.drawLine(x+211, 438, x+225, 438);
        g.drawString("RD = 1", x+210, 450);
        g.drawLine(x+209, 480, x+227, 480);
        g.drawString("WR = 1", x+210, 492);
    }

     private void busIdle(int x)
     {
         busIdleTable(x);
         clock(x, 1);
         int y=125;
         g.setColor(Color.yellow);
         g.drawLine(x, y, x+100, y);
         g.drawLine(x, y+20, x+100, y+20);

         g.setColor(new Color(255, 255, 170));
         y=165;
            for(int i=0;i<100;i+=6)
            {
            g.drawLine(x+i, y+10, x+2+i, y+10);
            }

        y=235;
        g.setColor(Color.blue);
        g.drawLine(x, y, x+100, y);

        if(io==1)signalActiveHigh(x, 300, 4,1);
        else signalActiveLow(x, 300, 4, 1);
        if(s1==1)signalActiveHigh(x, 340, 4,1);
             else signalActiveLow(x, 340, 4,1);
        if(s0==1)signalActiveHigh(x, 380, 4,1);
             else signalActiveLow(x, 380, 4,1);
        
        y=435;
        g.setColor(Color.RED);
        g.drawLine(x, y, x+100, y);y+=40;
        g.drawLine(x, y, x+100, y);
        g.setColor(Color.WHITE);

     }


     Assembler o;
     int x;
     int addressDec;
     String code;

     private void cycleDecoder(char choice,String address,String opcode)
     {
         if (choice == 'F') {
             opcodeFetch(x, address, opcode);x+=400;
         } else if (choice == 'S') {
             opcodeFetch6State(x, address, opcode);x+=600;
         } else if (choice == 'R') {
             memRead(x, address, opcode);x+=300;
         } else if (choice == 'W') {
             memWrite(x, address, opcode);x+=300;
         } else if (choice == 'I') {
             ioRead(x, address, opcode);x+=300;
         } else if (choice == 'O') {
             ioWrite(x, address, opcode);x+=300;
         } else if (choice == 'B') {
             busIdle(x);x+=100;
         } else if (choice == 'H') {
             memRead(x, o.engine.Dec2Hex(o.matrix.SP - 1), opcode);x+=300;
         } else if (choice == 'P') {
             memRead(x, o.engine.Dec2Hex(o.matrix.SP - 2), opcode);x+=300;
         }


     }

     public void memoryCycleDecoder(Assembler o,String address)
     {
         this.o=o;
         addressDec=o.engine.Hex2Dec(address);
         this.code=o.matrix.tstates(o.matrix.memory[addressDec]);

     }
     
     

}



