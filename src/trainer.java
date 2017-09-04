
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class trainer extends javax.swing.JFrame implements Runnable {

    Assembler o=null;
    char c4='0',c3='0',c2='0',c1='0',d2='0',d1='0';
    boolean reg=false,mem=false,set=false,go=false;
    ExecutorService exec = Executors.newCachedThreadPool();

     public trainer() {
        initComponents();
        ((trainerCanvas)canvas44).reDraw('f');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('i');
        ((trainerCanvas)canvas41).reDraw('e');
        ((trainerCanvas)canvas22).reDraw('n');
        ((trainerCanvas)canvas21).reDraw('d');
    }

     public trainer(Assembler o)
     {
         this.o=o;
         initComponents();
        ((trainerCanvas)canvas44).reDraw('f');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('i');
        ((trainerCanvas)canvas41).reDraw('e');
        ((trainerCanvas)canvas22).reDraw('n');
        ((trainerCanvas)canvas21).reDraw('d');

     }

     public void run()
    {
         while(!o.stop)blinking();
     }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1B = new java.awt.Button();
        button2C = new java.awt.Button();
        button8 = new java.awt.Button();
        button0A = new java.awt.Button();
        button5H = new java.awt.Button();
        button6L = new java.awt.Button();
        button7M = new java.awt.Button();
        button3D = new java.awt.Button();
        buttonC = new java.awt.Button();
        button9 = new java.awt.Button();
        buttonA = new java.awt.Button();
        buttonB = new java.awt.Button();
        buttonD = new java.awt.Button();
        buttonE = new java.awt.Button();
        buttonReg = new java.awt.Button();
        button4E = new java.awt.Button();
        buttonF = new java.awt.Button();
        buttonExec = new java.awt.Button();
        buttonMem = new java.awt.Button();
        buttonHalt = new java.awt.Button();
        buttonGo = new java.awt.Button();
        buttonPrev = new java.awt.Button();
        canvas43 = new trainerCanvas(c2);
        canvas42 = new trainerCanvas(c3);
        canvas44 = new trainerCanvas('6');
        buttonReset = new java.awt.Button();
        canvas41 = new trainerCanvas(c4);
        canvas22 = new trainerCanvas(d1);
        canvas21 = new trainerCanvas(d2);
        buttonNext = new java.awt.Button();
        canvas7 = new java.awt.Canvas();
        canvas1 = new java.awt.Canvas();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("8085 MICROPROCESSOR TRAINER KIT");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        button1B.setBackground(new java.awt.Color(0, 0, 0));
        button1B.setFont(new java.awt.Font("Dialog", 1, 12));
        button1B.setForeground(new java.awt.Color(255, 255, 255));
        button1B.setLabel("1 B");
        button1B.setName("button1B"); // NOI18N
        button1B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1BActionPerformed(evt);
            }
        });
        button1B.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button1BKeyReleased(evt);
            }
        });

        button2C.setBackground(new java.awt.Color(0, 0, 0));
        button2C.setFont(new java.awt.Font("Dialog", 1, 12));
        button2C.setForeground(new java.awt.Color(255, 255, 255));
        button2C.setLabel("2 C");
        button2C.setName("button2C"); // NOI18N
        button2C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2CActionPerformed(evt);
            }
        });
        button2C.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button2CKeyReleased(evt);
            }
        });

        button8.setActionCommand("8 SP");
        button8.setBackground(new java.awt.Color(0, 0, 0));
        button8.setFont(new java.awt.Font("Dialog", 1, 12));
        button8.setForeground(new java.awt.Color(255, 255, 255));
        button8.setLabel("8 SP");
        button8.setName("button8"); // NOI18N
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        button8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button8KeyReleased(evt);
            }
        });

        button0A.setBackground(new java.awt.Color(0, 0, 0));
        button0A.setFont(new java.awt.Font("Dialog", 1, 12));
        button0A.setForeground(new java.awt.Color(255, 255, 255));
        button0A.setLabel("0  A");
        button0A.setName("button0A"); // NOI18N
        button0A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button0AActionPerformed(evt);
            }
        });
        button0A.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button0AKeyReleased(evt);
            }
        });

        button5H.setBackground(new java.awt.Color(0, 0, 0));
        button5H.setFont(new java.awt.Font("Dialog", 1, 12));
        button5H.setForeground(new java.awt.Color(255, 255, 255));
        button5H.setLabel("5 H");
        button5H.setName("button5H"); // NOI18N
        button5H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5HActionPerformed(evt);
            }
        });
        button5H.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button5HKeyReleased(evt);
            }
        });

        button6L.setBackground(new java.awt.Color(0, 0, 0));
        button6L.setFont(new java.awt.Font("Dialog", 1, 12));
        button6L.setForeground(new java.awt.Color(255, 255, 255));
        button6L.setLabel("6 L");
        button6L.setName("button6L"); // NOI18N
        button6L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6LActionPerformed(evt);
            }
        });
        button6L.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button6LKeyReleased(evt);
            }
        });

        button7M.setBackground(new java.awt.Color(0, 0, 0));
        button7M.setFont(new java.awt.Font("Dialog", 1, 12));
        button7M.setForeground(new java.awt.Color(255, 255, 255));
        button7M.setLabel("7 M");
        button7M.setName("button7M"); // NOI18N
        button7M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7MActionPerformed(evt);
            }
        });
        button7M.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button7MKeyReleased(evt);
            }
        });

        button3D.setBackground(new java.awt.Color(0, 0, 0));
        button3D.setFont(new java.awt.Font("Dialog", 1, 12));
        button3D.setForeground(new java.awt.Color(255, 255, 255));
        button3D.setLabel("3 D");
        button3D.setName("button3D"); // NOI18N
        button3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3DActionPerformed(evt);
            }
        });
        button3D.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button3DKeyReleased(evt);
            }
        });

        buttonC.setBackground(new java.awt.Color(0, 0, 0));
        buttonC.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonC.setForeground(new java.awt.Color(255, 255, 255));
        buttonC.setLabel("C");
        buttonC.setName("buttonC"); // NOI18N
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });
        buttonC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonCKeyReleased(evt);
            }
        });

        button9.setBackground(new java.awt.Color(0, 0, 0));
        button9.setFont(new java.awt.Font("Dialog", 1, 12));
        button9.setForeground(new java.awt.Color(255, 255, 255));
        button9.setLabel("9 PC");
        button9.setName("button9"); // NOI18N
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });
        button9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button9KeyReleased(evt);
            }
        });

        buttonA.setBackground(new java.awt.Color(0, 0, 0));
        buttonA.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonA.setForeground(new java.awt.Color(255, 255, 255));
        buttonA.setLabel("A");
        buttonA.setName("buttonA"); // NOI18N
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });
        buttonA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonAKeyReleased(evt);
            }
        });

        buttonB.setBackground(new java.awt.Color(0, 0, 0));
        buttonB.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonB.setForeground(new java.awt.Color(255, 255, 255));
        buttonB.setLabel("B");
        buttonB.setName("buttonB"); // NOI18N
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });
        buttonB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonBKeyReleased(evt);
            }
        });

        buttonD.setBackground(new java.awt.Color(0, 0, 0));
        buttonD.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonD.setForeground(new java.awt.Color(255, 255, 255));
        buttonD.setLabel("D");
        buttonD.setName("buttonD"); // NOI18N
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });
        buttonD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonDKeyReleased(evt);
            }
        });

        buttonE.setBackground(new java.awt.Color(0, 0, 0));
        buttonE.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonE.setForeground(new java.awt.Color(255, 255, 255));
        buttonE.setLabel("E");
        buttonE.setName("buttonE"); // NOI18N
        buttonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEActionPerformed(evt);
            }
        });
        buttonE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonEKeyReleased(evt);
            }
        });

        buttonReg.setBackground(new java.awt.Color(102, 102, 255));
        buttonReg.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonReg.setForeground(new java.awt.Color(255, 255, 255));
        buttonReg.setLabel("REG");
        buttonReg.setName("buttonReg"); // NOI18N
        buttonReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegActionPerformed(evt);
            }
        });
        buttonReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonRegKeyReleased(evt);
            }
        });

        button4E.setBackground(new java.awt.Color(0, 0, 0));
        button4E.setFont(new java.awt.Font("Dialog", 1, 12));
        button4E.setForeground(new java.awt.Color(255, 255, 255));
        button4E.setLabel("4 E");
        button4E.setName("button4E"); // NOI18N
        button4E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4EActionPerformed(evt);
            }
        });
        button4E.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                button4EKeyReleased(evt);
            }
        });

        buttonF.setBackground(new java.awt.Color(0, 0, 0));
        buttonF.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonF.setForeground(new java.awt.Color(255, 255, 255));
        buttonF.setLabel("F");
        buttonF.setName("buttonF"); // NOI18N
        buttonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFActionPerformed(evt);
            }
        });
        buttonF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonFKeyReleased(evt);
            }
        });

        buttonExec.setBackground(new java.awt.Color(102, 102, 255));
        buttonExec.setFont(new java.awt.Font("Arial Narrow", 1, 12));
        buttonExec.setForeground(new java.awt.Color(255, 255, 255));
        buttonExec.setLabel("EXEC");
        buttonExec.setName("buttonExec"); // NOI18N
        buttonExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExecActionPerformed(evt);
            }
        });
        buttonExec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonExecKeyReleased(evt);
            }
        });

        buttonMem.setBackground(new java.awt.Color(102, 102, 255));
        buttonMem.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonMem.setForeground(new java.awt.Color(255, 255, 255));
        buttonMem.setLabel("SET / MEM");
        buttonMem.setName("buttonMem"); // NOI18N
        buttonMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMemActionPerformed(evt);
            }
        });
        buttonMem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonMemKeyReleased(evt);
            }
        });

        buttonHalt.setActionCommand("SET");
        buttonHalt.setBackground(new java.awt.Color(102, 102, 255));
        buttonHalt.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonHalt.setForeground(new java.awt.Color(255, 255, 255));
        buttonHalt.setLabel("Halt ");
        buttonHalt.setName("buttonHalt"); // NOI18N
        buttonHalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHaltActionPerformed(evt);
            }
        });
        buttonHalt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonHaltKeyReleased(evt);
            }
        });

        buttonGo.setBackground(new java.awt.Color(102, 102, 255));
        buttonGo.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonGo.setForeground(new java.awt.Color(255, 255, 255));
        buttonGo.setLabel("GO");
        buttonGo.setName("buttonGo"); // NOI18N
        buttonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGoActionPerformed(evt);
            }
        });
        buttonGo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonGoKeyReleased(evt);
            }
        });

        buttonPrev.setActionCommand("PREV");
        buttonPrev.setBackground(new java.awt.Color(102, 102, 255));
        buttonPrev.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonPrev.setForeground(new java.awt.Color(255, 255, 255));
        buttonPrev.setLabel("DCR");
        buttonPrev.setName("buttonPrev"); // NOI18N
        buttonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrevActionPerformed(evt);
            }
        });
        buttonPrev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonPrevKeyReleased(evt);
            }
        });

        canvas43.setBackground(new java.awt.Color(153, 0, 0));
        canvas43.setName("canvas43"); // NOI18N

        canvas42.setBackground(new java.awt.Color(153, 0, 0));
        canvas42.setName("canvas42"); // NOI18N

        canvas44.setBackground(new java.awt.Color(153, 0, 0));
        canvas44.setName("canvas44"); // NOI18N

        buttonReset.setBackground(new java.awt.Color(102, 102, 255));
        buttonReset.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonReset.setLabel("RESET");
        buttonReset.setName("buttonReset"); // NOI18N
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });
        buttonReset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonResetKeyReleased(evt);
            }
        });

        canvas41.setBackground(new java.awt.Color(153, 0, 0));
        canvas41.setName("canvas41"); // NOI18N

        canvas22.setBackground(new java.awt.Color(153, 0, 0));
        canvas22.setName("canvas22"); // NOI18N

        canvas21.setBackground(new java.awt.Color(153, 0, 0));
        canvas21.setName("canvas21"); // NOI18N

        buttonNext.setActionCommand("NEXT / INR");
        buttonNext.setBackground(new java.awt.Color(102, 102, 255));
        buttonNext.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonNext.setForeground(new java.awt.Color(255, 255, 255));
        buttonNext.setLabel("INR");
        buttonNext.setName("buttonNext"); // NOI18N
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });
        buttonNext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonNextKeyReleased(evt);
            }
        });

        canvas7.setBackground(new java.awt.Color(0, 0, 0));
        canvas7.setForeground(new java.awt.Color(255, 0, 51));
        canvas7.setName("canvas7"); // NOI18N

        canvas1.setBackground(new java.awt.Color(0, 0, 0));
        canvas1.setName("canvas1"); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/trainer.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(canvas43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonHalt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(buttonPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonMem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(buttonReg, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(button7M, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(buttonGo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(button0A, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(button1B, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(button2C, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(button3D, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(buttonExec, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(530, 530, 530)
                .addComponent(canvas41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(button4E, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(550, 550, 550)
                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(canvas44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(600, 600, 600)
                .addComponent(button6L, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(canvas42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(620, 620, 620)
                .addComponent(canvas21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(buttonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(canvas22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(650, 650, 650)
                .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(canvas7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(600, 600, 600)
                .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(550, 550, 550)
                .addComponent(button5H, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(canvas43, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHalt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonReg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7M, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonGo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button0A, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1B, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2C, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3D, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(buttonExec, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(canvas41, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(button4E, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(canvas44, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(button6L, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(canvas42, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(canvas21, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(buttonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(canvas22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(canvas7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(button5H, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button6LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6LActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('6');
        c4=c3;c3=c2;c2=c1;c1='6';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            ((trainerCanvas)canvas41).reDraw('L');
            ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.L).charAt(0));
            ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.L).charAt(1));
        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('6');
             d2=d1;d1='6';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button6LActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('8');
        c4=c3;c3=c2;c2=c1;c1='8';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            String s=o.engine.Dec2Hex(o.matrix.SP);
            ((trainerCanvas)canvas44).reDraw(s.charAt(0));
            ((trainerCanvas)canvas43).reDraw(s.charAt(1));
            ((trainerCanvas)canvas42).reDraw(s.charAt(2));
            ((trainerCanvas)canvas41).reDraw(s.charAt(3));
            ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.memory[o.matrix.SP]).charAt(0));
            ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.memory[o.matrix.SP]).charAt(1));

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('8');
             d2=d1;d1='8';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button8ActionPerformed

    private void buttonExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecActionPerformed

        o.viewWorkSpace();
        o.disAssemble();
        if(o.jButtonRun.isVisible())o.jButtonRun.doClick();
        exec.execute(this);
    }//GEN-LAST:event_buttonExecActionPerformed

    private void button0AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button0AActionPerformed

        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('0');
        c4=c3;c3=c2;c2=c1;c1='0';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            ((trainerCanvas)canvas41).reDraw('a');
                    ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.A).charAt(0));
                    ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.A).charAt(1));
            }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('0');
             d2=d1;d1='0';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }

    }//GEN-LAST:event_button0AActionPerformed

    private void button1BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1BActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('1');
        c4=c3;c3=c2;c2=c1;c1='1';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            ((trainerCanvas)canvas41).reDraw('b');
            ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.B).charAt(0));
            ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.B).charAt(1));

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('1');
             d2=d1;d1='1';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);
        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button1BActionPerformed

    private void button2CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2CActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('2');
        c4=c3;c3=c2;c2=c1;c1='2';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            ((trainerCanvas)canvas41).reDraw('C');
            ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.C).charAt(0));
            ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.C).charAt(1));
        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('2');
             d2=d1;d1='2';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button2CActionPerformed

    private void button3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3DActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('3');
        c4=c3;c3=c2;c2=c1;c1='3';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            ((trainerCanvas)canvas41).reDraw('D');
            ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.D).charAt(0));
                    ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.D).charAt(1));
        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('3');
             d2=d1;d1='3';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button3DActionPerformed

    private void button4EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4EActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('4');
        c4=c3;c3=c2;c2=c1;c1='4';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            ((trainerCanvas)canvas41).reDraw('E');
                ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.E).charAt(0));
                ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.E).charAt(1));

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('4');
             d2=d1;d1='4';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button4EActionPerformed

    private void button5HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5HActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('5');
        c4=c3;c3=c2;c2=c1;c1='5';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            ((trainerCanvas)canvas41).reDraw('H');
                    ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.H).charAt(0));
                    ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.H).charAt(1));
        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('5');
             d2=d1;d1='5';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button5HActionPerformed

    private void button7MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7MActionPerformed
        if(((!set)&&mem)||go){

        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('7');
        c4=c3;c3=c2;c2=c1;c1='7';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            String s=o.engine.Dec2Hex(o.matrix.H*256+o.matrix.L);
            ((trainerCanvas)canvas44).reDraw(s.charAt(0));
            ((trainerCanvas)canvas43).reDraw(s.charAt(1));
            ((trainerCanvas)canvas42).reDraw(s.charAt(2));
            ((trainerCanvas)canvas41).reDraw(s.charAt(3));
                    ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.memory[o.matrix.H*256+o.matrix.L]).charAt(0));
                    ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.memory[o.matrix.H*256+o.matrix.L]).charAt(1));

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('7');
             d2=d1;d1='7';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button7MActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        if(((!set)&&mem)||go){
        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('9');
        c4=c3;c3=c2;c2=c1;c1='9';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){
            String s=o.engine.Dec2Hex(o.matrix.PC);
            ((trainerCanvas)canvas44).reDraw(s.charAt(0));
            ((trainerCanvas)canvas43).reDraw(s.charAt(1));
            ((trainerCanvas)canvas42).reDraw(s.charAt(2));
            ((trainerCanvas)canvas41).reDraw(s.charAt(3));
            ((trainerCanvas)canvas22).reDraw(o.engine.Dec2Hex2digit(o.matrix.memory[o.matrix.PC]).charAt(0));
            ((trainerCanvas)canvas21).reDraw(o.engine.Dec2Hex2digit(o.matrix.memory[o.matrix.PC]).charAt(1));

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('9');
             d2=d1;d1='9';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_button9ActionPerformed

    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        if(((!set)&&mem)||go){
        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('A');
        c4=c3;c3=c2;c2=c1;c1='A';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('A');
             d2=d1;d1='A';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_buttonAActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBActionPerformed
        if(((!set)&&mem)||go){
        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('B');
        c4=c3;c3=c2;c2=c1;c1='B';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('B');
             d2=d1;d1='B';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_buttonBActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCActionPerformed
        if(((!set)&&mem)||go){
        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('C');
        c4=c3;c3=c2;c2=c1;c1='C';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('C');
             d2=d1;d1='C';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }

    }//GEN-LAST:event_buttonCActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDActionPerformed
        if(((!set)&&mem)||go){
        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('D');
        c4=c3;c3=c2;c2=c1;c1='D';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('D');
             d2=d1;d1='D';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_buttonDActionPerformed

    private void buttonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEActionPerformed
        if(((!set)&&mem)||go){
        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('E');
        c4=c3;c3=c2;c2=c1;c1='E';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('E');
             d2=d1;d1='E';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }
    }//GEN-LAST:event_buttonEActionPerformed

    private void buttonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFActionPerformed
        if(((!set)&&mem)||go){
        ((trainerCanvas)canvas44).reDraw(c3);
        ((trainerCanvas)canvas43).reDraw(c2);
        ((trainerCanvas)canvas42).reDraw(c1);
        ((trainerCanvas)canvas41).reDraw('F');
        c4=c3;c3=c2;c2=c1;c1='F';
        if(go){
                o.matrix.PC=o.engine.Hex2Dec(""+c4+c3+c2+c1);
                o.jTextFieldBeginFrom.setText(""+c4+c3+c2+c1);
              }

        }
        else if(reg){

        }
        else if(set&&mem){
            ((trainerCanvas)canvas22).reDraw(d1);
            ((trainerCanvas)canvas21).reDraw('F');
             d2=d1;d1='F';
             int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
             o.matrix.memory[memNo]=o.engine.Hex2Dec(""+d2+d1);
             o.set();
             if((memNo-o.matrix.beginAddress)<999&&(memNo-o.matrix.beginAddress)>=0)o.jTableAssembler.setValueAt(""+d2+d1, memNo-o.matrix.beginAddress, 4);

        }
        else{
        ((trainerCanvas)canvas44).reDraw('E');
        ((trainerCanvas)canvas43).reDraw('r');
        ((trainerCanvas)canvas42).reDraw('r');
        ((trainerCanvas)canvas41).reDraw('o');
        ((trainerCanvas)canvas22).reDraw('r');
        ((trainerCanvas)canvas21).reDraw('*');

        }

    }//GEN-LAST:event_buttonFActionPerformed

    private void button0AKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button0AKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        



    }//GEN-LAST:event_button0AKeyReleased

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
        if(memNo>=o.matrix.stopAddress){memNo=o.matrix.beginAddress-1;
                String s=o.engine.Dec2Hex(memNo+1);
                c4=s.charAt(0);c3=s.charAt(1);c2=s.charAt(2);c1=s.charAt(3);}
        if(set){String s=o.engine.Dec2Hex(memNo+1);
                c4=s.charAt(0);c3=s.charAt(1);c2=s.charAt(2);c1=s.charAt(3);
                }
        reg=false;set=true;
        ((trainerCanvas)canvas41).reDraw(c1);
        ((trainerCanvas)canvas42).reDraw(c2);
        ((trainerCanvas)canvas43).reDraw(c3);
        ((trainerCanvas)canvas44).reDraw(c4);
        int n=o.matrix.memory[o.engine.Hex2Dec(""+c4+c3+c2+c1)];
        d1=o.engine.Dec2Hex2digit(n).charAt(1);
        d2=o.engine.Dec2Hex2digit(n).charAt(0);
        ((trainerCanvas)canvas22).reDraw(d2);
        ((trainerCanvas)canvas21).reDraw(d1);


    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrevActionPerformed
        int memNo=o.engine.Hex2Dec(""+c4+c3+c2+c1);
        if(memNo<=o.matrix.beginAddress){memNo=o.matrix.stopAddress+1;
                String s=o.engine.Dec2Hex(memNo+1);
                c4=s.charAt(0);c3=s.charAt(1);c2=s.charAt(2);c1=s.charAt(3);
        }
        if(set){String s=o.engine.Dec2Hex(memNo-1);
                c4=s.charAt(0);c3=s.charAt(1);c2=s.charAt(2);c1=s.charAt(3);
                }
        reg=false;set=true;
        ((trainerCanvas)canvas41).reDraw(c1);
        ((trainerCanvas)canvas42).reDraw(c2);
        ((trainerCanvas)canvas43).reDraw(c3);
        ((trainerCanvas)canvas44).reDraw(c4);
        int n=o.matrix.memory[o.engine.Hex2Dec(""+c4+c3+c2+c1)];
        d1=o.engine.Dec2Hex2digit(n).charAt(1);
        d2=o.engine.Dec2Hex2digit(n).charAt(0);
        ((trainerCanvas)canvas22).reDraw(d2);
        ((trainerCanvas)canvas21).reDraw(d1);

    }//GEN-LAST:event_buttonPrevActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        mem=false;reg=false;set=false;go=false;
        o.stop=true;
        c1='0';c2='0';c3='0';c4='0';d1='0';d2='0';
        ((trainerCanvas)canvas44).reDraw('-');
        ((trainerCanvas)canvas43).reDraw('-');
        ((trainerCanvas)canvas42).reDraw('-');
        ((trainerCanvas)canvas41).reDraw('-');
        ((trainerCanvas)canvas22).reDraw('-');
        ((trainerCanvas)canvas21).reDraw('-');

    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonHaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHaltActionPerformed

    }//GEN-LAST:event_buttonHaltActionPerformed

    private void buttonMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMemActionPerformed
        mem=true;reg=false;set=false;go=false;
        ((trainerCanvas)canvas44).reDraw('*');
        ((trainerCanvas)canvas43).reDraw('*');
        ((trainerCanvas)canvas42).reDraw('*');
        ((trainerCanvas)canvas41).reDraw('*');
        ((trainerCanvas)canvas22).reDraw('*');
        ((trainerCanvas)canvas21).reDraw('*');

    }//GEN-LAST:event_buttonMemActionPerformed

    private void buttonRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegActionPerformed
        mem=false;reg=true;set=false;go=false;
        ((trainerCanvas)canvas44).reDraw('r');
        ((trainerCanvas)canvas43).reDraw('e');
        ((trainerCanvas)canvas42).reDraw('g');
        ((trainerCanvas)canvas41).reDraw('*');
        ((trainerCanvas)canvas22).reDraw('*');
        ((trainerCanvas)canvas21).reDraw('*');


    }//GEN-LAST:event_buttonRegActionPerformed

    private void buttonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGoActionPerformed
        go=true;
        String s=o.engine.HexAutoCorrect4digit(o.jTextFieldBeginFrom.getText());
        ((trainerCanvas)canvas44).reDraw(s.charAt(0));
        ((trainerCanvas)canvas43).reDraw(s.charAt(1));
        ((trainerCanvas)canvas42).reDraw(s.charAt(2));
        ((trainerCanvas)canvas41).reDraw(s.charAt(3));
        s=o.engine.Dec2Hex2digit(o.matrix.memory[o.engine.Hex2Dec(s)]);
        ((trainerCanvas)canvas22).reDraw(s.charAt(0));
        ((trainerCanvas)canvas21).reDraw(s.charAt(1));

    }//GEN-LAST:event_buttonGoActionPerformed

    private void button1BKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button1BKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_button1BKeyReleased

    private void button2CKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button2CKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_button2CKeyReleased

    private void button3DKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button3DKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_button3DKeyReleased

    private void button7MKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button7MKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        


    }//GEN-LAST:event_button7MKeyReleased

    private void button6LKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button6LKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_button6LKeyReleased

    private void button5HKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button5HKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        


    }//GEN-LAST:event_button5HKeyReleased

    private void button4EKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button4EKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        


    }//GEN-LAST:event_button4EKeyReleased

    private void button8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button8KeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_button8KeyReleased

    private void button9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button9KeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        


    }//GEN-LAST:event_button9KeyReleased

    private void buttonAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonAKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonAKeyReleased

    private void buttonBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonBKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonBKeyReleased

    private void buttonCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonCKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonCKeyReleased

    private void buttonDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonDKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonDKeyReleased

    private void buttonEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonEKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonEKeyReleased

    private void buttonFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonFKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonFKeyReleased

    private void buttonGoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonGoKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonGoKeyReleased

    private void buttonExecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonExecKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonExecKeyReleased

    private void buttonRegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonRegKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonRegKeyReleased

    private void buttonNextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonNextKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonNextKeyReleased

    private void buttonPrevKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonPrevKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonPrevKeyReleased

    private void buttonMemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonMemKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonMemKeyReleased

    private void buttonResetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonResetKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonResetKeyReleased

    private void buttonHaltKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonHaltKeyReleased
        if(evt.getKeyChar()=='0')button0AActionPerformed(null);
        else if(evt.getKeyChar()=='1')button1BActionPerformed(null);
        else if(evt.getKeyChar()=='2')button2CActionPerformed(null);
        else if(evt.getKeyChar()=='3')button3DActionPerformed(null);
        else if(evt.getKeyChar()=='4')button4EActionPerformed(null);
        else if(evt.getKeyChar()=='5')button5HActionPerformed(null);
        else if(evt.getKeyChar()=='6')button6LActionPerformed(null);
        else if(evt.getKeyChar()=='7')button7MActionPerformed(null);
        else if(evt.getKeyChar()=='8')button8ActionPerformed(null);
        else if(evt.getKeyChar()=='9')button9ActionPerformed(null);
        else if(evt.getKeyChar()=='A'||evt.getKeyChar()=='a')buttonAActionPerformed(null);
        else if(evt.getKeyChar()=='B'||evt.getKeyChar()=='b')buttonBActionPerformed(null);
        else if(evt.getKeyChar()=='C'||evt.getKeyChar()=='c')buttonCActionPerformed(null);
        else if(evt.getKeyChar()=='D'||evt.getKeyChar()=='d')buttonDActionPerformed(null);
        else if(evt.getKeyChar()=='E'||evt.getKeyChar()=='e')buttonEActionPerformed(null);
        else if(evt.getKeyChar()=='F'||evt.getKeyChar()=='f')buttonFActionPerformed(null);
        else if(evt.getKeyCode()==38||evt.getKeyCode()==10)buttonNextActionPerformed(null);
        else if(evt.getKeyCode()==40)buttonPrevActionPerformed(null);
        else if(evt.getKeyCode()==27)buttonResetActionPerformed(null);
        
        

    }//GEN-LAST:event_buttonHaltKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    public void blinking()
    {
        canvas7.setBackground(Color.red);
        canvas1.setBackground(Color.yellow);
        try {
            Thread.yield();
        } catch (Exception ex) {
        }
        canvas1.setBackground(Color.black);
        canvas7.setBackground(Color.black);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button0A;
    private java.awt.Button button1B;
    private java.awt.Button button2C;
    private java.awt.Button button3D;
    private java.awt.Button button4E;
    private java.awt.Button button5H;
    private java.awt.Button button6L;
    private java.awt.Button button7M;
    private java.awt.Button button8;
    private java.awt.Button button9;
    private java.awt.Button buttonA;
    private java.awt.Button buttonB;
    private java.awt.Button buttonC;
    private java.awt.Button buttonD;
    private java.awt.Button buttonE;
    private java.awt.Button buttonExec;
    private java.awt.Button buttonF;
    private java.awt.Button buttonGo;
    private java.awt.Button buttonHalt;
    private java.awt.Button buttonMem;
    private java.awt.Button buttonNext;
    private java.awt.Button buttonPrev;
    private java.awt.Button buttonReg;
    private java.awt.Button buttonReset;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas21;
    private java.awt.Canvas canvas22;
    private java.awt.Canvas canvas41;
    private java.awt.Canvas canvas42;
    private java.awt.Canvas canvas43;
    private java.awt.Canvas canvas44;
    private java.awt.Canvas canvas7;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
class trainerCanvas extends Canvas
{

    int x=-30,y=-40,s=30;

        int a[][]=new int[1][7];

    public trainerCanvas() {
            
            a[0]=decoder('5');

    }
    public trainerCanvas(char c) {

            a[0]=decoder(c);


    }

    public void reDraw(char c)
    {


           a[0]=decoder(c);
            repaint();                    
    }


    public void paint(Graphics g1)
    {

        Graphics2D g = (Graphics2D) g1;
        g.setColor(new java.awt.Color(255,0,0));
        g.setStroke(new BasicStroke(5));
        if(a[0][4]==1)g.drawLine(x+40,y+80,x+40,y+100);
        if(a[0][2]==1)g.drawLine(x+60,y+80,x+60,y+100);
        if(a[0][5]==1)g.drawLine(x+40,y+50,x+40,y+70);
        if(a[0][1]==1)g.drawLine(x+60,y+50,x+60,y+70);

        if(a[0][3]==1)g.drawLine(x+42,y+105,x+58,y+105);
        if(a[0][6]==1)g.drawLine(x+42,y+75,x+58,y+75);
        if(a[0][0]==1)g.drawLine(x+42,y+45,x+58,y+45);


        g.setColor(new java.awt.Color(130,0,0));

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
