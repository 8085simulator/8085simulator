
import java.awt.Font;
import javax.swing.text.IconView;

public class InterruptServiceSubroutine extends javax.swing.JFrame {

    public InterruptServiceSubroutine() {
        initComponents();
    }

    String Rst0,Rst1,Rst2,Rst3,Rst4,Rst5,Rst55,Rst6,Rst65,Rst7,Rst75,Trap;
    Assembler o;

    public InterruptServiceSubroutine(Assembler o) {
        this.o=o;
        initComponents();
        initialize();
        setJtextField();
    }

    public void initialize()
    {
        jLabelTrap.setText(o.engine.Dec2Hex(o.matrix.beginAddress+36)+" H");
        jLabelRst75.setText(o.engine.Dec2Hex(o.matrix.beginAddress+60)+" H");
        jLabelRst65.setText(o.engine.Dec2Hex(o.matrix.beginAddress+52)+" H");
        jLabelRst55.setText(o.engine.Dec2Hex(o.matrix.beginAddress+44)+" H");
        jLabelRst0.setText(o.engine.Dec2Hex(o.matrix.beginAddress)+" H");
        jLabelRst1.setText(o.engine.Dec2Hex(o.matrix.beginAddress+8)+" H");
        jLabelRst2.setText(o.engine.Dec2Hex(o.matrix.beginAddress+16)+" H");
        jLabelRst3.setText(o.engine.Dec2Hex(o.matrix.beginAddress+24)+" H");
        jLabelRst4.setText(o.engine.Dec2Hex(o.matrix.beginAddress+32)+" H");
        jLabelRst5.setText(o.engine.Dec2Hex(o.matrix.beginAddress+40)+" H");
        jLabelRst6.setText(o.engine.Dec2Hex(o.matrix.beginAddress+48)+" H");
        jLabelRst7.setText(o.engine.Dec2Hex(o.matrix.beginAddress+56)+" H");

        vanishTickMark();

        jTextFieldRst0.setText(Rst0);
        jTextFieldRst1.setText(Rst1);
        jTextFieldRst2.setText(Rst2);
        jTextFieldRst3.setText(Rst3);
        jTextFieldRst4.setText(Rst4);
        jTextFieldRst5.setText(Rst5);
        jTextFieldRst55.setText(Rst55);
        jTextFieldRst6.setText(Rst6);
        jTextFieldRst65.setText(Rst65);
        jTextFieldRst7.setText(Rst7);
        jTextFieldRst75.setText(Rst75);
        jTextFieldTrap.setText(Trap);

       
    }

    public void vanishTickMark()
    {
         jLabelCrossRst0.setVisible(false);
        jLabelCrossRst1.setVisible(false);
        jLabelCrossRst2.setVisible(false);
        jLabelCrossRst3.setVisible(false);
        jLabelCrossRst4.setVisible(false);
        jLabelCrossRst5.setVisible(false);
        jLabelCrossRst55.setVisible(false);
        jLabelCrossRst6.setVisible(false);
        jLabelCrossRst65.setVisible(false);
        jLabelCrossRst7.setVisible(false);
        jLabelCrossRst75.setVisible(false);
        jLabelCrossTrap.setVisible(false);

        jLabelTickRst0.setVisible(false);
        jLabelTickRst1.setVisible(false);
        jLabelTickRst2.setVisible(false);
        jLabelTickRst3.setVisible(false);
        jLabelTickRst4.setVisible(false);
        jLabelTickRst5.setVisible(false);
        jLabelTickRst55.setVisible(false);
        jLabelTickRst6.setVisible(false);
        jLabelTickRst65.setVisible(false);
        jLabelTickRst7.setVisible(false);
        jLabelTickRst75.setVisible(false);
        jLabelTickTrap.setVisible(false);
    }

    public void setJtextField()
    {
        int n=0;

        n=36+o.engine.m.beginAddress;
        jTextFieldTrap.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=60+o.engine.m.beginAddress;
        jTextFieldRst75.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=52+o.engine.m.beginAddress;
        jTextFieldRst65.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=44+o.engine.m.beginAddress;
        jTextFieldRst55.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=0+o.engine.m.beginAddress;
        jTextFieldRst0.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=8+o.engine.m.beginAddress;
        jTextFieldRst1.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=16+o.engine.m.beginAddress;
        jTextFieldRst2.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=24+o.engine.m.beginAddress;
        jTextFieldRst3.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=32+o.engine.m.beginAddress;
        jTextFieldRst4.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=40+o.engine.m.beginAddress;
        jTextFieldRst5.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=48+o.engine.m.beginAddress;
        jTextFieldRst6.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
        n=56+o.engine.m.beginAddress;
        jTextFieldRst7.setText(o.engine.HexToMnemonic(o.matrix.memory[n], o.matrix.memory[n+1], o.matrix.memory[n+2]));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelTrap = new javax.swing.JLabel();
        jLabelRst75 = new javax.swing.JLabel();
        jLabelRst65 = new javax.swing.JLabel();
        jLabelRst55 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelRst0 = new javax.swing.JLabel();
        jLabelRst1 = new javax.swing.JLabel();
        jLabelRst2 = new javax.swing.JLabel();
        jLabelRst3 = new javax.swing.JLabel();
        jLabelRst5 = new javax.swing.JLabel();
        jLabelRst4 = new javax.swing.JLabel();
        jLabelRst6 = new javax.swing.JLabel();
        jLabelRst7 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldRst75 = new javax.swing.JTextField();
        jTextFieldTrap = new javax.swing.JTextField();
        jTextFieldRst55 = new javax.swing.JTextField();
        jTextFieldRst65 = new javax.swing.JTextField();
        jTextFieldRst0 = new javax.swing.JTextField();
        jTextFieldRst1 = new javax.swing.JTextField();
        jTextFieldRst2 = new javax.swing.JTextField();
        jTextFieldRst3 = new javax.swing.JTextField();
        jTextFieldRst4 = new javax.swing.JTextField();
        jTextFieldRst5 = new javax.swing.JTextField();
        jTextFieldRst6 = new javax.swing.JTextField();
        jTextFieldRst7 = new javax.swing.JTextField();
        jLabelTickTrap = new javax.swing.JLabel();
        jLabelCrossTrap = new javax.swing.JLabel();
        jLabelTickRst75 = new javax.swing.JLabel();
        jLabelCrossRst75 = new javax.swing.JLabel();
        jLabelTickRst65 = new javax.swing.JLabel();
        jLabelCrossRst65 = new javax.swing.JLabel();
        jLabelTickRst55 = new javax.swing.JLabel();
        jLabelCrossRst55 = new javax.swing.JLabel();
        jLabelTickRst0 = new javax.swing.JLabel();
        jLabelCrossRst0 = new javax.swing.JLabel();
        jLabelTickRst1 = new javax.swing.JLabel();
        jLabelCrossRst1 = new javax.swing.JLabel();
        jLabelTickRst2 = new javax.swing.JLabel();
        jLabelCrossRst2 = new javax.swing.JLabel();
        jLabelTickRst3 = new javax.swing.JLabel();
        jLabelCrossRst3 = new javax.swing.JLabel();
        jLabelTickRst4 = new javax.swing.JLabel();
        jLabelCrossRst4 = new javax.swing.JLabel();
        jLabelTickRst5 = new javax.swing.JLabel();
        jLabelCrossRst5 = new javax.swing.JLabel();
        jLabelTickRst6 = new javax.swing.JLabel();
        jLabelCrossRst6 = new javax.swing.JLabel();
        jLabelTickRst7 = new javax.swing.JLabel();
        jLabelCrossRst7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interrupt Service Subroutine");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(250, 150, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("TRAP");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("RST 7.5");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("RST 6.5");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("RST 5.5");
        jLabel4.setName("jLabel4"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("  INTERRUPTS");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("CALL LOCATIONS");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabelTrap.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelTrap.setText("0024 H");
        jLabelTrap.setName("jLabelTrap"); // NOI18N

        jLabelRst75.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst75.setText("003C H");
        jLabelRst75.setName("jLabelRst75"); // NOI18N

        jLabelRst65.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst65.setText("0034 H");
        jLabelRst65.setName("jLabelRst65"); // NOI18N

        jLabelRst55.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst55.setText("002C H");
        jLabelRst55.setName("jLabelRst55"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setText("RST 0");
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel12.setText("RST 1");
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel13.setText("RST 2");
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel14.setText("RST 3");
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel15.setText("RST 4");
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel16.setText("RST 5");
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel17.setText("RST 6");
        jLabel17.setName("jLabel17"); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel18.setText("RST 7");
        jLabel18.setName("jLabel18"); // NOI18N

        jLabelRst0.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst0.setText("0000 H");
        jLabelRst0.setName("jLabelRst0"); // NOI18N

        jLabelRst1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst1.setText("0008 H");
        jLabelRst1.setName("jLabelRst1"); // NOI18N

        jLabelRst2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst2.setText("0010 H");
        jLabelRst2.setName("jLabelRst2"); // NOI18N

        jLabelRst3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst3.setText("0018 H");
        jLabelRst3.setName("jLabelRst3"); // NOI18N

        jLabelRst5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst5.setText("0028 H");
        jLabelRst5.setName("jLabelRst5"); // NOI18N

        jLabelRst4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst4.setText("0020 H");
        jLabelRst4.setName("jLabelRst4"); // NOI18N

        jLabelRst6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst6.setText("0030 H");
        jLabelRst6.setName("jLabelRst6"); // NOI18N

        jLabelRst7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelRst7.setText("0038 H");
        jLabelRst7.setName("jLabelRst7"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel27.setForeground(new java.awt.Color(0, 102, 0));
        jLabel27.setText("     Interrupt Service Subroutine");
        jLabel27.setName("jLabel27"); // NOI18N

        jTextFieldRst75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst75.setName("jTextFieldRst75"); // NOI18N
        jTextFieldRst75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst75ActionPerformed(evt);
            }
        });
        jTextFieldRst75.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst75KeyReleased(evt);
            }
        });

        jTextFieldTrap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldTrap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTrap.setName("jTextFieldTrap"); // NOI18N
        jTextFieldTrap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTrapActionPerformed(evt);
            }
        });
        jTextFieldTrap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTrapKeyReleased(evt);
            }
        });

        jTextFieldRst55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst55.setName("jTextFieldRst55"); // NOI18N
        jTextFieldRst55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst55ActionPerformed(evt);
            }
        });
        jTextFieldRst55.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst55KeyReleased(evt);
            }
        });

        jTextFieldRst65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst65.setName("jTextFieldRst65"); // NOI18N
        jTextFieldRst65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst65ActionPerformed(evt);
            }
        });
        jTextFieldRst65.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst65KeyReleased(evt);
            }
        });

        jTextFieldRst0.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst0.setName("jTextFieldRst0"); // NOI18N
        jTextFieldRst0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst0ActionPerformed(evt);
            }
        });
        jTextFieldRst0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst0KeyReleased(evt);
            }
        });

        jTextFieldRst1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst1.setName("jTextFieldRst1"); // NOI18N
        jTextFieldRst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst1ActionPerformed(evt);
            }
        });
        jTextFieldRst1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst1KeyReleased(evt);
            }
        });

        jTextFieldRst2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst2.setName("jTextFieldRst2"); // NOI18N
        jTextFieldRst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst2ActionPerformed(evt);
            }
        });
        jTextFieldRst2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst2KeyReleased(evt);
            }
        });

        jTextFieldRst3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst3.setName("jTextFieldRst3"); // NOI18N
        jTextFieldRst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst3ActionPerformed(evt);
            }
        });
        jTextFieldRst3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst3KeyReleased(evt);
            }
        });

        jTextFieldRst4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst4.setName("jTextFieldRst4"); // NOI18N
        jTextFieldRst4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst4ActionPerformed(evt);
            }
        });
        jTextFieldRst4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst4KeyReleased(evt);
            }
        });

        jTextFieldRst5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst5.setName("jTextFieldRst5"); // NOI18N
        jTextFieldRst5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst5ActionPerformed(evt);
            }
        });
        jTextFieldRst5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst5KeyReleased(evt);
            }
        });

        jTextFieldRst6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst6.setName("jTextFieldRst6"); // NOI18N
        jTextFieldRst6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst6ActionPerformed(evt);
            }
        });
        jTextFieldRst6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst6KeyReleased(evt);
            }
        });

        jTextFieldRst7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRst7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRst7.setName("jTextFieldRst7"); // NOI18N
        jTextFieldRst7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRst7ActionPerformed(evt);
            }
        });
        jTextFieldRst7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRst7KeyReleased(evt);
            }
        });

        jLabelTickTrap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickTrap.setName("jLabelTickTrap"); // NOI18N

        jLabelCrossTrap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossTrap.setName("jLabelCrossTrap"); // NOI18N

        jLabelTickRst75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst75.setName("jLabelTickRst75"); // NOI18N

        jLabelCrossRst75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst75.setName("jLabelCrossRst75"); // NOI18N

        jLabelTickRst65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst65.setName("jLabelTickRst65"); // NOI18N

        jLabelCrossRst65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst65.setName("jLabelCrossRst65"); // NOI18N

        jLabelTickRst55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst55.setName("jLabelTickRst55"); // NOI18N

        jLabelCrossRst55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst55.setName("jLabelCrossRst55"); // NOI18N

        jLabelTickRst0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst0.setName("jLabelTickRst0"); // NOI18N

        jLabelCrossRst0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst0.setName("jLabelCrossRst0"); // NOI18N

        jLabelTickRst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst1.setName("jLabelTickRst1"); // NOI18N

        jLabelCrossRst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst1.setName("jLabelCrossRst1"); // NOI18N

        jLabelTickRst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst2.setName("jLabelTickRst2"); // NOI18N

        jLabelCrossRst2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst2.setName("jLabelCrossRst2"); // NOI18N

        jLabelTickRst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst3.setName("jLabelTickRst3"); // NOI18N

        jLabelCrossRst3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst3.setName("jLabelCrossRst3"); // NOI18N

        jLabelTickRst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst4.setName("jLabelTickRst4"); // NOI18N

        jLabelCrossRst4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst4.setName("jLabelCrossRst4"); // NOI18N

        jLabelTickRst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst5.setName("jLabelTickRst5"); // NOI18N

        jLabelCrossRst5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst5.setName("jLabelCrossRst5"); // NOI18N

        jLabelTickRst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst6.setName("jLabelTickRst6"); // NOI18N

        jLabelCrossRst6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst6.setName("jLabelCrossRst6"); // NOI18N

        jLabelTickRst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif"))); // NOI18N
        jLabelTickRst7.setName("jLabelTickRst7"); // NOI18N

        jLabelCrossRst7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif"))); // NOI18N
        jLabelCrossRst7.setName("jLabelCrossRst7"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelRst0)
                                    .addComponent(jLabelRst1)
                                    .addComponent(jLabelRst2)
                                    .addComponent(jLabelRst3)
                                    .addComponent(jLabelRst4)
                                    .addComponent(jLabelRst5)
                                    .addComponent(jLabelRst6)
                                    .addComponent(jLabelRst7)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addGap(60, 60, 60)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelRst55)
                                        .addComponent(jLabelTrap)
                                        .addComponent(jLabelRst65)
                                        .addComponent(jLabelRst75)))))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTickRst0, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldRst7, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst6, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst75, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldTrap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst65, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldRst1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTickRst2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelTickRst1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTickTrap)
                                    .addComponent(jLabelTickRst75)
                                    .addComponent(jLabelTickRst65))
                                .addComponent(jLabelTickRst55, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelTickRst3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelTickRst4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelTickRst5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelTickRst6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelTickRst7, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelCrossRst7)
                        .addComponent(jLabelCrossRst75)
                        .addComponent(jLabelCrossTrap)
                        .addComponent(jLabelCrossRst65)
                        .addComponent(jLabelCrossRst55)
                        .addComponent(jLabelCrossRst0)
                        .addComponent(jLabelCrossRst1)
                        .addComponent(jLabelCrossRst3)
                        .addComponent(jLabelCrossRst4)
                        .addComponent(jLabelCrossRst5)
                        .addComponent(jLabelCrossRst6))
                    .addComponent(jLabelCrossRst2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTrap)
                            .addComponent(jTextFieldTrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelTickTrap)
                    .addComponent(jLabelCrossTrap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelRst75)))
                            .addComponent(jTextFieldRst75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTickRst75))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldRst65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabelRst65))
                            .addComponent(jLabelTickRst65)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCrossRst75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCrossRst65)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldRst55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabelRst55))
                            .addComponent(jLabelTickRst55))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabelRst0)
                                .addComponent(jTextFieldRst0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTickRst0, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCrossRst55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCrossRst0)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabelRst1)
                        .addComponent(jTextFieldRst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTickRst1)
                    .addComponent(jLabelCrossRst1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCrossRst2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabelRst2)
                            .addComponent(jTextFieldRst2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addComponent(jLabelTickRst2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabelRst3)
                        .addComponent(jTextFieldRst3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTickRst3)
                    .addComponent(jLabelCrossRst3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTickRst4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabelRst4)
                        .addComponent(jTextFieldRst4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelCrossRst4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabelRst5)
                                .addComponent(jTextFieldRst5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTickRst5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(jLabelRst6)
                                .addComponent(jTextFieldRst6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTickRst6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCrossRst5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCrossRst6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabelRst7)
                        .addComponent(jTextFieldRst7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTickRst7)
                    .addComponent(jLabelCrossRst7))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
 *
 * @param s Rst7 or Rst65
 * @param set true to set tick & false to set cross
 */
    public void tickCross(String s,boolean set)
    {

        vanishTickMark();
        if(s.equalsIgnoreCase("Rst0")){
            if(set)jLabelTickRst0.setVisible(true);
            else jLabelCrossRst0.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst1")){
            if(set)jLabelTickRst1.setVisible(true);
            else jLabelCrossRst1.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst2")){
            if(set)jLabelTickRst2.setVisible(true);
            else jLabelCrossRst2.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst3")){
            if(set)jLabelTickRst3.setVisible(true);
            else jLabelCrossRst3.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst4")){
            if(set)jLabelTickRst4.setVisible(true);
            else jLabelCrossRst4.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst5")){
            if(set)jLabelTickRst5.setVisible(true);
            else jLabelCrossRst5.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst6")){
            if(set)jLabelTickRst6.setVisible(true);
            else jLabelCrossRst6.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst7")){
            if(set)jLabelTickRst7.setVisible(true);
            else jLabelCrossRst7.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst55")){
            if(set)jLabelTickRst55.setVisible(true);
            else jLabelCrossRst55.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst65")){
            if(set)jLabelTickRst65.setVisible(true);
            else jLabelCrossRst65.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Rst75")){
            if(set)jLabelTickRst75.setVisible(true);
            else jLabelCrossRst75.setVisible(true);
        }
        else if(s.equalsIgnoreCase("Trap")){
            if(set)jLabelTickTrap.setVisible(true);
            else jLabelCrossTrap.setVisible(true);
        }
    }

    private void jTextFieldRst75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst75ActionPerformed

         boolean tick=o.engine.isFunction(jTextFieldRst75.getText());
         tickCross("Rst75",tick);
         if(tick){jTextFieldRst75.setText(o.engine.funcLabeltofuncCode(jTextFieldRst75.getText()));}
       
    }//GEN-LAST:event_jTextFieldRst75ActionPerformed

    private void jTextFieldRst75KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst75KeyReleased


        boolean tick=o.engine.isFunction(jTextFieldRst75.getText());
        tickCross("Rst75",tick);

    }//GEN-LAST:event_jTextFieldRst75KeyReleased

    private void jTextFieldTrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTrapActionPerformed
         boolean tick=o.engine.isFunction(jTextFieldTrap.getText());
         tickCross("Trap",tick);
         if(tick){jTextFieldTrap.setText(o.engine.funcLabeltofuncCode(jTextFieldTrap.getText()));}
    }//GEN-LAST:event_jTextFieldTrapActionPerformed

    private void jTextFieldRst65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst65ActionPerformed
         boolean tick=o.engine.isFunction(jTextFieldRst65.getText());
         tickCross("Rst65",tick);
         if(tick){jTextFieldRst65.setText(o.engine.funcLabeltofuncCode(jTextFieldRst65.getText()));}
    }//GEN-LAST:event_jTextFieldRst65ActionPerformed

    private void jTextFieldRst65KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst65KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst65.getText());
        tickCross("Rst65",tick);

    }//GEN-LAST:event_jTextFieldRst65KeyReleased

    private void jTextFieldTrapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTrapKeyReleased
        boolean tick=o.engine.isFunction(jTextFieldTrap.getText());
        tickCross("Trap",tick);
}//GEN-LAST:event_jTextFieldTrapKeyReleased

    private void jTextFieldRst55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst55ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst55.getText());
        tickCross("Rst55",tick);
        if(tick){jTextFieldRst55.setText(o.engine.funcLabeltofuncCode(jTextFieldRst55.getText()));}
    }//GEN-LAST:event_jTextFieldRst55ActionPerformed

    private void jTextFieldRst55KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst55KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst55.getText());
        tickCross("Rst55",tick);
    }//GEN-LAST:event_jTextFieldRst55KeyReleased

    private void jTextFieldRst0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst0ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst0.getText());
        tickCross("Rst0",tick);
        if(tick){jTextFieldRst0.setText(o.engine.funcLabeltofuncCode(jTextFieldRst0.getText()));}
    }//GEN-LAST:event_jTextFieldRst0ActionPerformed

    private void jTextFieldRst0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst0KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst0.getText());
        tickCross("Rst0",tick);
}//GEN-LAST:event_jTextFieldRst0KeyReleased

    private void jTextFieldRst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst1ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst1.getText());
        tickCross("Rst1",tick);
        if(tick){jTextFieldRst1.setText(o.engine.funcLabeltofuncCode(jTextFieldRst1.getText()));}
    }//GEN-LAST:event_jTextFieldRst1ActionPerformed

    private void jTextFieldRst1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst1KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst1.getText());
        tickCross("Rst1",tick);
    }//GEN-LAST:event_jTextFieldRst1KeyReleased

    private void jTextFieldRst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst2ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst2.getText());
        tickCross("Rst2",tick);
        if(tick){jTextFieldRst2.setText(o.engine.funcLabeltofuncCode(jTextFieldRst2.getText()));}
    }//GEN-LAST:event_jTextFieldRst2ActionPerformed

    private void jTextFieldRst2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst2KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst2.getText());
        tickCross("Rst2",tick);
    }//GEN-LAST:event_jTextFieldRst2KeyReleased

    private void jTextFieldRst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst3ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst3.getText());
        tickCross("Rst3",tick);
        if(tick){jTextFieldRst3.setText(o.engine.funcLabeltofuncCode(jTextFieldRst3.getText()));}
}//GEN-LAST:event_jTextFieldRst3ActionPerformed

    private void jTextFieldRst3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst3KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst3.getText());
        tickCross("Rst3",tick);
}//GEN-LAST:event_jTextFieldRst3KeyReleased

    private void jTextFieldRst4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst4ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst4.getText());
        tickCross("Rst4",tick);
        if(tick){jTextFieldRst4.setText(o.engine.funcLabeltofuncCode(jTextFieldRst4.getText()));}
    }//GEN-LAST:event_jTextFieldRst4ActionPerformed

    private void jTextFieldRst4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst4KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst4.getText());
        tickCross("Rst4",tick);
    }//GEN-LAST:event_jTextFieldRst4KeyReleased

    private void jTextFieldRst5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst5ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst5.getText());
        tickCross("Rst5",tick);
        if(tick){jTextFieldRst5.setText(o.engine.funcLabeltofuncCode(jTextFieldRst5.getText()));}
    }//GEN-LAST:event_jTextFieldRst5ActionPerformed

    private void jTextFieldRst5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst5KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst5.getText());
        tickCross("Rst5",tick);
    }//GEN-LAST:event_jTextFieldRst5KeyReleased

    private void jTextFieldRst6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst6ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst6.getText());
        tickCross("Rst6",tick);
        if(tick){jTextFieldRst6.setText(o.engine.funcLabeltofuncCode(jTextFieldRst6.getText()));}
    }//GEN-LAST:event_jTextFieldRst6ActionPerformed

    private void jTextFieldRst6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst6KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst6.getText());
        tickCross("Rst6",tick);
    }//GEN-LAST:event_jTextFieldRst6KeyReleased

    private void jTextFieldRst7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRst7ActionPerformed
        boolean tick=o.engine.isFunction(jTextFieldRst7.getText());
        tickCross("Rst7",tick);
        if(tick){jTextFieldRst7.setText(o.engine.funcLabeltofuncCode(jTextFieldRst7.getText()));}
    }//GEN-LAST:event_jTextFieldRst7ActionPerformed

    private void jTextFieldRst7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRst7KeyReleased
        boolean tick=o.engine.isFunction(jTextFieldRst7.getText());
        tickCross("Rst7",tick);
    }//GEN-LAST:event_jTextFieldRst7KeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        String s[]=new String[4];
        int n=0;

        s=o.engine.MnemonicToHexcode(jTextFieldTrap.getText());
        n=o.matrix.beginAddress+36;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst75.getText());
        n=o.matrix.beginAddress+60;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst65.getText());
        n=o.matrix.beginAddress+52;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst55.getText());
        n=o.matrix.beginAddress+44;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst0.getText());
        n=o.matrix.beginAddress+0;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst1.getText());
        n=o.matrix.beginAddress+8;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst2.getText());
        n=o.matrix.beginAddress+16;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst3.getText());
        n=o.matrix.beginAddress+24;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst4.getText());
        n=o.matrix.beginAddress+32;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst5.getText());
        n=o.matrix.beginAddress+40;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst6.getText());
        n=o.matrix.beginAddress+48;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);

        s=o.engine.MnemonicToHexcode(jTextFieldRst7.getText());
        n=o.matrix.beginAddress+56;
        o.matrix.memory[n]=Integer.parseInt(s[3]);o.matrix.memory[n+1]=o.engine.Hex2Dec(s[1]);o.matrix.memory[n+2]=o.engine.Hex2Dec(s[2]);


        o.setMemory();
    }//GEN-LAST:event_formWindowClosing
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterruptServiceSubroutine(new Assembler()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCrossRst0;
    private javax.swing.JLabel jLabelCrossRst1;
    private javax.swing.JLabel jLabelCrossRst2;
    private javax.swing.JLabel jLabelCrossRst3;
    private javax.swing.JLabel jLabelCrossRst4;
    private javax.swing.JLabel jLabelCrossRst5;
    private javax.swing.JLabel jLabelCrossRst55;
    private javax.swing.JLabel jLabelCrossRst6;
    private javax.swing.JLabel jLabelCrossRst65;
    private javax.swing.JLabel jLabelCrossRst7;
    private javax.swing.JLabel jLabelCrossRst75;
    private javax.swing.JLabel jLabelCrossTrap;
    private javax.swing.JLabel jLabelRst0;
    private javax.swing.JLabel jLabelRst1;
    private javax.swing.JLabel jLabelRst2;
    private javax.swing.JLabel jLabelRst3;
    private javax.swing.JLabel jLabelRst4;
    private javax.swing.JLabel jLabelRst5;
    private javax.swing.JLabel jLabelRst55;
    private javax.swing.JLabel jLabelRst6;
    private javax.swing.JLabel jLabelRst65;
    private javax.swing.JLabel jLabelRst7;
    private javax.swing.JLabel jLabelRst75;
    private javax.swing.JLabel jLabelTickRst0;
    private javax.swing.JLabel jLabelTickRst1;
    private javax.swing.JLabel jLabelTickRst2;
    private javax.swing.JLabel jLabelTickRst3;
    private javax.swing.JLabel jLabelTickRst4;
    private javax.swing.JLabel jLabelTickRst5;
    private javax.swing.JLabel jLabelTickRst55;
    private javax.swing.JLabel jLabelTickRst6;
    private javax.swing.JLabel jLabelTickRst65;
    private javax.swing.JLabel jLabelTickRst7;
    private javax.swing.JLabel jLabelTickRst75;
    private javax.swing.JLabel jLabelTickTrap;
    private javax.swing.JLabel jLabelTrap;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldRst0;
    private javax.swing.JTextField jTextFieldRst1;
    private javax.swing.JTextField jTextFieldRst2;
    private javax.swing.JTextField jTextFieldRst3;
    private javax.swing.JTextField jTextFieldRst4;
    private javax.swing.JTextField jTextFieldRst5;
    private javax.swing.JTextField jTextFieldRst55;
    private javax.swing.JTextField jTextFieldRst6;
    private javax.swing.JTextField jTextFieldRst65;
    private javax.swing.JTextField jTextFieldRst7;
    private javax.swing.JTextField jTextFieldRst75;
    private javax.swing.JTextField jTextFieldTrap;
    // End of variables declaration//GEN-END:variables

}
