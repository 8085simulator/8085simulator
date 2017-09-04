
import java.awt.*;
import java.awt.print.*;
import java.io.*;
import java.net.URI;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.jar.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

public class Assembler extends javax.swing.JFrame implements Runnable{

    AssemblerEngine engine;
    Matrix matrix;
    FileChooser fileChooser;
    Disassembler disassembler;
    PPI8255 ppi8255;
    Preprocessor preprocessor;
    TextEditor textEditor;
    int tableState=0;
    String path="";
    boolean closeStateCall=false;
    float[] speed=new float[4];
    int timingDiagramX = 0;
    
    String recover="";
    String[] comments=new String[1000];
    String[] macro=new String[1000];
    int oIndex=0;
    boolean stop=false;
    boolean pause=false;
    boolean properShutdown=false;
    int stopAtIndex=207;
    int memShift=0;
    int continueFrom=0;
    String fileSeparator=System.getProperty("file.separator");
    

    public Assembler() {

        matrix = new Matrix(this);
        engine = new AssemblerEngine(matrix);
        ppi8255=new PPI8255(this);
        preprocessor = new Preprocessor();
        disassembler = new Disassembler(this);
        textEditor=new TextEditor(this);
        initComponents();
        jTabbedPaneAssemblerEditor.removeAll();
        jTabbedPaneAssemblerEditor.addTab("Assembler",jScrollPane9);
        jTabbedPaneAssemblerEditor.addTab("Disassembler",jScrollPane5);

        setParameters();
        matrix.PC=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldBeginFrom.getText()));
        matrix.beginAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
        matrix.stopAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemStop.getText()));
        sampleCode();
        jScrollPane16.setVisible(true);
        jMenu12.setVisible(false);
        jTabbedPaneInterface.setVisible(true);
        jTabbedPaneInterface.addTab("I/O Port Editor", jScrollPane4);
        //jTableAssembler.setRowSelectionAllowed(true);
        //jTableAssembler.setRowSelectionInterval(0, 1);
        
    }

    public void sampleCode()
    {
        JarFile jarFile = null;
        try {
            String filepath=Assembler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            for(int i=0;i<filepath.length()-2;i++)
            {
                if(filepath.substring(i, i+3).equalsIgnoreCase("%20"))
                    filepath=filepath.substring(0,i)+" "+filepath.substring(i+3,filepath.length());
            }
            jarFile = new JarFile(filepath);
            Enumeration enum1 = jarFile.entries();
            while (enum1.hasMoreElements()) {
             jMenuCreator(enum1.nextElement());
           }
        } catch (Exception ex) {
            System.err.println(ex);
        }
     }

     JMenuItem jMenuItem[]= new JMenuItem[100];
     int menu=0;
    private void jMenuCreator(Object obj) {
       JarEntry entry = (JarEntry)obj;
       String name = entry.getName();
       if(name.startsWith("8085 Program/")&&name.length()>13)
       {
           jMenuItem[menu] = new javax.swing.JMenuItem();
           jMenuItem[menu].setText(name.substring(13,name.length()-4));
           jMenu5.add(jMenuItem[menu]);
           jMenuItem[menu].addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   jMenuItemArrayActionPerformed(evt);
               }
           });

       }
     }

    private void jMenuItemArrayActionPerformed(java.awt.event.ActionEvent evt) {
        String line, s = "";
        try {
        InputStreamReader jar=new InputStreamReader(Assembler.class.getResourceAsStream("/8085 Program/"+evt.getActionCommand()+".asm"));
        BufferedReader in = new BufferedReader(jar);
        while ((line = in.readLine()) != null) {
        s = s + line + "\n";
              jTabbedPaneAssemblerEditor.setSelectedIndex(0);
              jButtonDisassemble.setVisible(false);
              jButtonAssemble.setVisible(true);
        }
        } catch(Exception e){}
        jTextAreaAssemblyLanguageEditor.setText(s);
        textEditor.colorEditor();
        
    }

    public void setParameters()
    {
        jButtonStop.setVisible(false);
        jButtonBackward.setVisible(false);
        jButtonForward.setVisible(false);
        jLabelError.setVisible(false);
        jLabelComment.setVisible(false);
        jScrollPane16.setVisible(false);
        jButtonDisassemble.setVisible(false);
        jTabbedPaneLabelEditor.setVisible(false);
        jLabelErrorHang.setVisible(false);
        jProgressBar1.setVisible(false);
        jTabbedPaneInterface.setVisible(false);
        jButtonRun.setVisible(true);
        jButtonContinue.setVisible(false);
        jTabbedPaneInterface.removeAll();

       jRadioButtonMenuItemUltimate.setSelected(true);
       jRadioButtonMenuItemStepByStep.setSelected(false);
       jRadioButtonMenuItemNormal.setSelected(false);
       speed[0]=0;speed[1]=0;speed[2]=0;speed[3]=1;
        for (int i = 0; i < 3; i++) jTableNoConverter.setValueAt(0, 0, i);
        loadSettings();
        if(path.length()>0)path=path.substring(0,path.length());
        set();
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem20 = new javax.swing.JMenuItem();
        jTabbedPaneMemory = new javax.swing.JTabbedPane();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTableSIM = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTableRIM = new javax.swing.JTable();
        jLabelErrorHang = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTableFlagregister = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTableInterrupt = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTableNoConverter = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableRegister = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCounter = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jTextFieldMemBegin = new javax.swing.JTextField();
        jRadioButtonStoreMemoryLocation = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMemory = new javax.swing.JTable();
        jRadioButtonUsedMemoryLocation = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMemStop = new javax.swing.JTextField();
        jRadioButtonShowAll = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jTabbedPaneInterface = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePort = new javax.swing.JTable();
        jPanel8255 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable8255 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea8255 = new javax.swing.JTextArea();
        jButtonAnalizeCW = new javax.swing.JButton();
        jTabbedPaneEditor = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButtonAssemble = new javax.swing.JButton();
        jTabbedPaneAssemblerEditor = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaDisassembler = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaAssemblyLanguageEditor = textEditor.jTextPane1;
        jButtonDisassemble = new javax.swing.JButton();
        jTabbedPaneLabelEditor = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaLabel = new javax.swing.JTextArea();
        jButtonAutocorrect = new javax.swing.JButton();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jLabelComment = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTableAssembler = new javax.swing.JTable();
        jLabelError = new javax.swing.JLabel();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jButtonContinue = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextFieldBeginFrom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonStop = new javax.swing.JButton();
        jButtonBackward = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jButtonForward = new javax.swing.JButton();
        jButtonStep = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemLoad_Assembly_Language_code = new javax.swing.JMenuItem();
        jMenuItemLoad_Hexcode = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jMenuItemSave_Assembly_Language_code = new javax.swing.JMenuItem();
        jMenuItemSave_Hexcode = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JSeparator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JSeparator();
        jMenuItemRecover = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JSeparator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JSeparator();
        jMenuItemAutocorrect = new javax.swing.JMenuItem();
        jMenuSettings = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jRadioButtonMenuItemStepByStep = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemNormal = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemUltimate = new javax.swing.JRadioButtonMenuItem();
        jMenuItemClearMemory = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemRunAllAtATime = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemForward = new javax.swing.JMenuItem();
        jMenuItemBackward = new javax.swing.JMenuItem();
        jMenuItemStop = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItemInterruptServiceSubroutine = new javax.swing.JMenuItem();
        jMenuItemDelaySubroutine = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jCheckBoxMenuItemIOPort = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemPeriphralInterface = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem20.setText("Code Guide");
        jMenuItem20.setName("jMenuItem20"); // NOI18N
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("8085 Simulator");
        setBounds(new java.awt.Rectangle(20, 0, 200, 0));
        setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPaneMemory.setName("jTabbedPaneMemory"); // NOI18N

        jInternalFrame3.setTitle("Registers : ");
        jInternalFrame3.setName("jInternalFrame3"); // NOI18N

        jScrollPane15.setName("jScrollPane15"); // NOI18N

        jTableSIM.setBackground(new java.awt.Color(204, 204, 204));
        jTableSIM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableSIM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SOD", "SDE", "*", "R7.5", "MSE", "M7.5", "M6.5", "M5.5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSIM.setName("jTableSIM"); // NOI18N
        jTableSIM.setRowSelectionAllowed(false);
        jTableSIM.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(jTableSIM);
        if (jTableSIM.getColumnModel().getColumnCount() > 0) {
            jTableSIM.getColumnModel().getColumn(0).setResizable(false);
            jTableSIM.getColumnModel().getColumn(1).setResizable(false);
            jTableSIM.getColumnModel().getColumn(2).setResizable(false);
            jTableSIM.getColumnModel().getColumn(3).setResizable(false);
            jTableSIM.getColumnModel().getColumn(4).setResizable(false);
            jTableSIM.getColumnModel().getColumn(5).setResizable(false);
            jTableSIM.getColumnModel().getColumn(6).setResizable(false);
            jTableSIM.getColumnModel().getColumn(7).setResizable(false);
            jTableSIM.getColumnModel().getColumn(7).setHeaderValue("M5.5");
        }

        jScrollPane17.setName("jScrollPane17"); // NOI18N

        jTableRIM.setBackground(new java.awt.Color(204, 204, 204));
        jTableRIM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableRIM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SID", "I7.5", "I6.5", "I5.5", "IE", "M7.5", "M6.5", "M5.5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRIM.setName("jTableRIM"); // NOI18N
        jTableRIM.setRowSelectionAllowed(false);
        jTableRIM.getTableHeader().setReorderingAllowed(false);
        jScrollPane17.setViewportView(jTableRIM);
        if (jTableRIM.getColumnModel().getColumnCount() > 0) {
            jTableRIM.getColumnModel().getColumn(0).setResizable(false);
            jTableRIM.getColumnModel().getColumn(1).setResizable(false);
            jTableRIM.getColumnModel().getColumn(2).setResizable(false);
            jTableRIM.getColumnModel().getColumn(3).setResizable(false);
            jTableRIM.getColumnModel().getColumn(4).setResizable(false);
            jTableRIM.getColumnModel().getColumn(5).setResizable(false);
            jTableRIM.getColumnModel().getColumn(6).setResizable(false);
            jTableRIM.getColumnModel().getColumn(7).setResizable(false);
            jTableRIM.getColumnModel().getColumn(7).setHeaderValue("M5.5");
        }

        jLabelErrorHang.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorHang.setText("jLabel13");
        jLabelErrorHang.setName("jLabelErrorHang"); // NOI18N

        jScrollPane13.setName("jScrollPane13"); // NOI18N

        jTableFlagregister.setBackground(new java.awt.Color(255, 153, 255));
        jTableFlagregister.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableFlagregister.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Flag Resister", null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Resister", "Value", "S", "Z", "*", "AC", "*", "P", "*", "CY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFlagregister.setName("jTableFlagregister"); // NOI18N
        jTableFlagregister.setRowSelectionAllowed(false);
        jTableFlagregister.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(jTableFlagregister);
        if (jTableFlagregister.getColumnModel().getColumnCount() > 0) {
            jTableFlagregister.getColumnModel().getColumn(0).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(0).setPreferredWidth(825);
            jTableFlagregister.getColumnModel().getColumn(1).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(1).setPreferredWidth(425);
            jTableFlagregister.getColumnModel().getColumn(2).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(3).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(4).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(5).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(6).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(7).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(8).setResizable(false);
            jTableFlagregister.getColumnModel().getColumn(9).setResizable(false);
        }

        jSeparator1.setName("jSeparator1"); // NOI18N

        jScrollPane18.setName("jScrollPane18"); // NOI18N

        jTableInterrupt.setBackground(new java.awt.Color(0, 206, 206));
        jTableInterrupt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableInterrupt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "SOD", "SID", "INTR", "TRAP", "R7.5", "R6.5", "R5.5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInterrupt.setName("jTableInterrupt"); // NOI18N
        jTableInterrupt.setRowSelectionAllowed(false);
        jTableInterrupt.getTableHeader().setReorderingAllowed(false);
        jTableInterrupt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInterruptMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(jTableInterrupt);
        if (jTableInterrupt.getColumnModel().getColumnCount() > 0) {
            jTableInterrupt.getColumnModel().getColumn(0).setResizable(false);
            jTableInterrupt.getColumnModel().getColumn(1).setResizable(false);
            jTableInterrupt.getColumnModel().getColumn(2).setResizable(false);
            jTableInterrupt.getColumnModel().getColumn(3).setResizable(false);
            jTableInterrupt.getColumnModel().getColumn(4).setResizable(false);
            jTableInterrupt.getColumnModel().getColumn(5).setResizable(false);
            jTableInterrupt.getColumnModel().getColumn(6).setResizable(false);
        }

        jScrollPane14.setName("jScrollPane14"); // NOI18N

        jTableNoConverter.setBackground(new java.awt.Color(204, 204, 255));
        jTableNoConverter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableNoConverter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null}
            },
            new String [] {
                "Hexadecimal", "Decimal", "Binary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableNoConverter.setToolTipText("simple enter the no. and press enter");
        jTableNoConverter.setName("jTableNoConverter"); // NOI18N
        jTableNoConverter.setRowSelectionAllowed(false);
        jTableNoConverter.getTableHeader().setReorderingAllowed(false);
        jTableNoConverter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableNoConverterMousePressed(evt);
            }
        });
        jTableNoConverter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableNoConverterKeyReleased(evt);
            }
        });
        jScrollPane14.setViewportView(jTableNoConverter);
        if (jTableNoConverter.getColumnModel().getColumnCount() > 0) {
            jTableNoConverter.getColumnModel().getColumn(0).setResizable(false);
            jTableNoConverter.getColumnModel().getColumn(0).setPreferredWidth(800);
            jTableNoConverter.getColumnModel().getColumn(1).setResizable(false);
            jTableNoConverter.getColumnModel().getColumn(1).setPreferredWidth(800);
            jTableNoConverter.getColumnModel().getColumn(2).setResizable(false);
            jTableNoConverter.getColumnModel().getColumn(2).setPreferredWidth(800);
        }

        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("No. Converter Tool : ");
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel10.setText("For SIM instruction");
        jLabel10.setName("jLabel10"); // NOI18N

        jScrollPane12.setName("jScrollPane12"); // NOI18N

        jTableRegister.setBackground(new java.awt.Color(204, 204, 255));
        jTableRegister.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableRegister.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Accumulator", "", null, null, null, null, null, null, null, null},
                {"Register B", "", null, null, null, null, null, null, null, null},
                {"Register C", null, null, null, null, null, null, null, null, null},
                {"Register D", null, null, null, null, null, null, null, null, null},
                {"Register E", null, null, null, null, null, null, null, null, null},
                {"Register H", null, null, null, null, null, null, null, null, null},
                {"Register L", null, null, null, null, null, null, null, null, null},
                {"Memory(M)", null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "  Register", "Value", "7", "6", "5", "4", "3", "2", "1", "0"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRegister.setName("jTableRegister"); // NOI18N
        jTableRegister.setRowSelectionAllowed(false);
        jTableRegister.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(jTableRegister);
        if (jTableRegister.getColumnModel().getColumnCount() > 0) {
            jTableRegister.getColumnModel().getColumn(0).setResizable(false);
            jTableRegister.getColumnModel().getColumn(0).setPreferredWidth(825);
            jTableRegister.getColumnModel().getColumn(1).setResizable(false);
            jTableRegister.getColumnModel().getColumn(1).setPreferredWidth(425);
            jTableRegister.getColumnModel().getColumn(2).setResizable(false);
            jTableRegister.getColumnModel().getColumn(3).setResizable(false);
            jTableRegister.getColumnModel().getColumn(4).setResizable(false);
            jTableRegister.getColumnModel().getColumn(5).setResizable(false);
            jTableRegister.getColumnModel().getColumn(6).setResizable(false);
            jTableRegister.getColumnModel().getColumn(7).setResizable(false);
            jTableRegister.getColumnModel().getColumn(8).setResizable(false);
            jTableRegister.getColumnModel().getColumn(9).setResizable(false);
        }

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTableCounter.setBackground(new java.awt.Color(255, 255, 204));
        jTableCounter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableCounter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Stack Pointer(SP)", null},
                {"Memory Pointer (HL)", null},
                {"Program Status Word(PSW)", null},
                {"Program Counter(PC)", null},
                {"Clock Cycle Counter", null},
                {"Instruction Counter", null}
            },
            new String [] {
                "Type", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCounter.setName("jTableCounter"); // NOI18N
        jTableCounter.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTableCounter);
        if (jTableCounter.getColumnModel().getColumnCount() > 0) {
            jTableCounter.getColumnModel().getColumn(0).setResizable(false);
            jTableCounter.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTableCounter.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel12.setText("For RIM instruction");
        jLabel12.setName("jLabel12"); // NOI18N

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                                .addGap(12, 12, 12))))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabelErrorHang)
                        .addContainerGap(369, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrorHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneMemory.addTab("Registers", jInternalFrame3);

        jInternalFrame2.setTitle("Memory Editor");
        jInternalFrame2.setName("jInternalFrame2"); // NOI18N

        jTextFieldMemBegin.setEditable(false);
        jTextFieldMemBegin.setText("0000");
        jTextFieldMemBegin.setName("jTextFieldMemBegin"); // NOI18N
        jTextFieldMemBegin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMemBeginActionPerformed(evt);
            }
        });

        jRadioButtonStoreMemoryLocation.setText("Store directly to specified memory location ");
        jRadioButtonStoreMemoryLocation.setName("jRadioButtonStoreMemoryLocation"); // NOI18N
        jRadioButtonStoreMemoryLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStoreMemoryLocationActionPerformed(evt);
            }
        });

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTableMemory.setBackground(new java.awt.Color(255, 204, 204));
        jTableMemory.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [256][17],
            new String [] {
                "        ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMemory.setName("jTableMemory"); // NOI18N
        jTableMemory.setRowSelectionAllowed(false);
        jTableMemory.getTableHeader().setReorderingAllowed(false);
        jTableMemory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMemoryMousePressed(evt);
            }
        });
        jTableMemory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableMemoryKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableMemory);
        jTableMemory.getColumnModel().getColumn(0).setPreferredWidth(250);

        jRadioButtonUsedMemoryLocation.setText("Show only loaded memory location");
        jRadioButtonUsedMemoryLocation.setName("jRadioButtonUsedMemoryLocation"); // NOI18N
        jRadioButtonUsedMemoryLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUsedMemoryLocationActionPerformed(evt);
            }
        });

        jLabel5.setText("----");
        jLabel5.setName("jLabel5"); // NOI18N

        jTextFieldMemStop.setEditable(false);
        jTextFieldMemStop.setText("FFFF");
        jTextFieldMemStop.setName("jTextFieldMemStop"); // NOI18N
        jTextFieldMemStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMemStopActionPerformed(evt);
            }
        });

        jRadioButtonShowAll.setSelected(true);
        jRadioButtonShowAll.setText("Show entire memory content");
        jRadioButtonShowAll.setName("jRadioButtonShowAll"); // NOI18N
        jRadioButtonShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonShowAllActionPerformed(evt);
            }
        });

        jLabel4.setText("Memory Range:");
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMemBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addComponent(jTextFieldMemStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jRadioButtonShowAll)
            .addComponent(jRadioButtonUsedMemoryLocation)
            .addComponent(jRadioButtonStoreMemoryLocation)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMemBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMemStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonUsedMemoryLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonStoreMemoryLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        jTabbedPaneMemory.addTab("Memory", jInternalFrame2);

        jInternalFrame4.setTitle("Interfacing device");
        jInternalFrame4.setName("jInternalFrame4"); // NOI18N

        jTabbedPaneInterface.setName("jTabbedPaneInterface"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTablePort.setBackground(new java.awt.Color(204, 255, 204));
        jTablePort.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTablePort.setModel(new javax.swing.table.DefaultTableModel(
            new Object [16][17],
            new String [] {
                "        ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePort.setName("jTablePort"); // NOI18N
        jTablePort.setRowSelectionAllowed(false);
        jTablePort.getTableHeader().setReorderingAllowed(false);
        jTablePort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePortKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTablePort);
        jTablePort.getColumnModel().getColumn(0).setPreferredWidth(310);

        jTabbedPaneInterface.addTab("I/O Port Editor", jScrollPane4);

        jPanel8255.setName("jPanel8255"); // NOI18N

        jScrollPane7.setName("jScrollPane7"); // NOI18N

        jTable8255.setBackground(new java.awt.Color(255, 204, 255));
        jTable8255.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable8255.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Port A", "00", null, null, null, null, null, null, null, null, null},
                {"Port B", "01", null, null, null, null, null, null, null, null, null},
                {"Port C", "02", null, null, null, null, null, null, null, null, null},
                {"Control Register", "03", null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Address", "Value", "7", "6", "5", "4", "3", "2", "1", "0"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8255.setName("jTable8255"); // NOI18N
        jTable8255.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable8255KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTable8255);
        if (jTable8255.getColumnModel().getColumnCount() > 0) {
            jTable8255.getColumnModel().getColumn(3).setResizable(false);
            jTable8255.getColumnModel().getColumn(4).setResizable(false);
            jTable8255.getColumnModel().getColumn(5).setResizable(false);
            jTable8255.getColumnModel().getColumn(6).setResizable(false);
            jTable8255.getColumnModel().getColumn(7).setResizable(false);
            jTable8255.getColumnModel().getColumn(8).setResizable(false);
            jTable8255.getColumnModel().getColumn(9).setResizable(false);
            jTable8255.getColumnModel().getColumn(10).setResizable(false);
        }
        jTable8255.getColumnModel().getColumn(0).setPreferredWidth(2000);
        jTable8255.getColumnModel().getColumn(1).setPreferredWidth(1000);
        jTable8255.getColumnModel().getColumn(2).setPreferredWidth(500);

        jScrollPane8.setName("jScrollPane8"); // NOI18N

        jTextArea8255.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea8255.setColumns(20);
        jTextArea8255.setEditable(false);
        jTextArea8255.setLineWrap(true);
        jTextArea8255.setRows(5);
        jTextArea8255.setName("jTextArea8255"); // NOI18N
        jScrollPane8.setViewportView(jTextArea8255);

        jButtonAnalizeCW.setText("Analyse Control Word");
        jButtonAnalizeCW.setName("jButtonAnalizeCW"); // NOI18N
        jButtonAnalizeCW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalizeCWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8255Layout = new javax.swing.GroupLayout(jPanel8255);
        jPanel8255.setLayout(jPanel8255Layout);
        jPanel8255Layout.setHorizontalGroup(
            jPanel8255Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addGroup(jPanel8255Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8255Layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(jButtonAnalizeCW)
                .addGap(81, 81, 81))
        );
        jPanel8255Layout.setVerticalGroup(
            jPanel8255Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8255Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAnalizeCW)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        jTabbedPaneInterface.addTab("8255", jPanel8255);

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneInterface, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneInterface, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
        );

        jTabbedPaneMemory.addTab("Devices", jInternalFrame4);

        jTabbedPaneEditor.setName("jTabbedPaneEditor"); // NOI18N

        jInternalFrame1.setTitle("8085 Assembly Language Editor");
        jInternalFrame1.setName("jInternalFrame1"); // NOI18N

        jButtonAssemble.setText("Assemble");
        jButtonAssemble.setName("jButtonAssemble"); // NOI18N
        jButtonAssemble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssembleActionPerformed(evt);
            }
        });

        jTabbedPaneAssemblerEditor.setName("jTabbedPaneAssemblerEditor"); // NOI18N
        jTabbedPaneAssemblerEditor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneAssemblerEditorMouseClicked(evt);
            }
        });

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        jTextAreaDisassembler.setColumns(20);
        jTextAreaDisassembler.setRows(5);
        jTextAreaDisassembler.setText(":102400003A0025471101262101254E210028B71A3F\n:102410008E277713230DC20F2405C20724760000F0\n:1025000003050000000000000000000000000000C3\n:1026000000458956240064358654000789713200DC\n:00000001FF\n");
        jTextAreaDisassembler.setName("jTextAreaDisassembler"); // NOI18N
        jScrollPane5.setViewportView(jTextAreaDisassembler);

        jTabbedPaneAssemblerEditor.addTab("Disassembler", jScrollPane5);

        jScrollPane9.setName("jScrollPane9"); // NOI18N

        jTextAreaAssemblyLanguageEditor.setName("jTextAreaAssemblyLanguageEditor"); // NOI18N
        jScrollPane9.setViewportView(jTextAreaAssemblyLanguageEditor);

        jTabbedPaneAssemblerEditor.addTab("Assembler", jScrollPane9);

        jButtonDisassemble.setText("Disassemble");
        jButtonDisassemble.setName("jButtonDisassemble"); // NOI18N
        jButtonDisassemble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisassembleActionPerformed(evt);
            }
        });

        jTabbedPaneLabelEditor.setName("jTabbedPaneLabelEditor"); // NOI18N

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jTextAreaLabel.setColumns(4);
        jTextAreaLabel.setRows(5);
        jTextAreaLabel.setName("jTextAreaLabel"); // NOI18N
        jScrollPane6.setViewportView(jTextAreaLabel);

        jTabbedPaneLabelEditor.addTab("Label", jScrollPane6);

        jButtonAutocorrect.setText("Autocorrect");
        jButtonAutocorrect.setName("jButtonAutocorrect"); // NOI18N
        jButtonAutocorrect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAutocorrectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneLabelEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jButtonAutocorrect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jButtonDisassemble)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAssemble))
                    .addComponent(jTabbedPaneAssemblerEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jTabbedPaneLabelEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(jTabbedPaneAssemblerEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAutocorrect))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAssemble)
                        .addComponent(jButtonDisassemble)))
                .addGap(60, 60, 60))
        );

        jTabbedPaneEditor.addTab("Editor", jInternalFrame1);

        jInternalFrame5.setTitle("Assembler");
        jInternalFrame5.setName("jInternalFrame5"); // NOI18N

        jLabelComment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelComment.setForeground(new java.awt.Color(0, 153, 153));
        jLabelComment.setText("jLabel13");
        jLabelComment.setAutoscrolls(true);
        jLabelComment.setName("jLabelComment"); // NOI18N

        jScrollPane16.setName("jScrollPane16"); // NOI18N

        jTableAssembler.setBackground(new java.awt.Color(176, 194, 158));
        jTableAssembler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableAssembler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [1000][8] ,
            new String [] {
                "*", "Address", "Label", "Mnemonics", "Hexcode", "Bytes", "M-Cycles", "T-States"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false,false,false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        }

    );
    jTableAssembler.setName("jTableAssembler"); // NOI18N
    jTableAssembler.setRowSelectionAllowed(true);
    jTableAssembler.getTableHeader().setReorderingAllowed(false);
    jTableAssembler.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTableAssemblerMouseClicked(evt);
        }
    });
    jTableAssembler.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jTableAssemblerKeyReleased(evt);
        }
    });
    jScrollPane16.setViewportView(jTableAssembler);
    jTableAssembler.getColumnModel().getColumn(0).setPreferredWidth(10);
    jTableAssembler.getColumnModel().getColumn(3).setPreferredWidth(125);

    jLabelError.setForeground(new java.awt.Color(255, 51, 51));
    jLabelError.setText("Error : ");
    jLabelError.setName("jLabelError"); // NOI18N

    jInternalFrame6.setTitle("Simulate");
    jInternalFrame6.setName("jInternalFrame6"); // NOI18N
    jInternalFrame6.setVisible(true);
    jInternalFrame6.getContentPane().setLayout(null);

    jButtonContinue.setMnemonic('t');
    jButtonContinue.setText("Continue");
    jButtonContinue.setFocusable(false);
    jButtonContinue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButtonContinue.setName("jButtonContinue"); // NOI18N
    jButtonContinue.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButtonContinue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonContinueActionPerformed(evt);
        }
    });
    jInternalFrame6.getContentPane().add(jButtonContinue);
    jButtonContinue.setBounds(160, 0, 250, 30);

    jProgressBar1.setForeground(new java.awt.Color(102, 0, 255));
    jProgressBar1.setName("jProgressBar1"); // NOI18N
    jInternalFrame6.getContentPane().add(jProgressBar1);
    jProgressBar1.setBounds(160, 0, 250, 30);

    jTextFieldBeginFrom.setText("C000");
    jTextFieldBeginFrom.setName("jTextFieldBeginFrom"); // NOI18N
    jTextFieldBeginFrom.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldBeginFromActionPerformed(evt);
        }
    });
    jTextFieldBeginFrom.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jTextFieldBeginFromKeyReleased(evt);
        }
    });
    jInternalFrame6.getContentPane().add(jTextFieldBeginFrom);
    jTextFieldBeginFrom.setBounds(100, 0, 48, 30);

    jLabel6.setText("Start From  →");
    jLabel6.setName("jLabel6"); // NOI18N
    jInternalFrame6.getContentPane().add(jLabel6);
    jLabel6.setBounds(0, 0, 100, 20);

    jButtonStop.setMnemonic('s');
    jButtonStop.setText("Stop");
    jButtonStop.setFocusable(false);
    jButtonStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButtonStop.setName("jButtonStop"); // NOI18N
    jButtonStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButtonStop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonStopActionPerformed(evt);
        }
    });
    jInternalFrame6.getContentPane().add(jButtonStop);
    jButtonStop.setBounds(150, 30, 140, 70);

    jButtonBackward.setMnemonic('b');
    jButtonBackward.setText("Backward");
    jButtonBackward.setName("jButtonBackward"); // NOI18N
    jButtonBackward.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonBackwardActionPerformed(evt);
        }
    });
    jInternalFrame6.getContentPane().add(jButtonBackward);
    jButtonBackward.setBounds(0, 30, 150, 70);

    jButtonRun.setMnemonic('r');
    jButtonRun.setText("Run all At a Time");
    jButtonRun.setName("jButtonRun"); // NOI18N
    jButtonRun.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRunActionPerformed(evt);
        }
    });
    jInternalFrame6.getContentPane().add(jButtonRun);
    jButtonRun.setBounds(0, 30, 230, 70);

    jButtonForward.setMnemonic('w');
    jButtonForward.setText("Forward");
    jButtonForward.setName("jButtonForward"); // NOI18N
    jButtonForward.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonForwardActionPerformed(evt);
        }
    });
    jInternalFrame6.getContentPane().add(jButtonForward);
    jButtonForward.setBounds(290, 30, 150, 70);

    jButtonStep.setMnemonic('t');
    jButtonStep.setText("Step By Step");
    jButtonStep.setName("jButtonStep"); // NOI18N
    jButtonStep.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonStepActionPerformed(evt);
        }
    });
    jInternalFrame6.getContentPane().add(jButtonStep);
    jButtonStep.setBounds(230, 30, 210, 70);

    javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
    jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
    jInternalFrame5Layout.setHorizontalGroup(
        jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jInternalFrame5Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame5Layout.createSequentialGroup()
                    .addComponent(jLabelComment, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jInternalFrame5Layout.createSequentialGroup()
                    .addComponent(jLabelError, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addGap(269, 269, 269))))
        .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        .addComponent(jInternalFrame6, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
    );
    jInternalFrame5Layout.setVerticalGroup(
        jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelComment)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabelError)
            .addGap(18, 18, 18)
            .addComponent(jInternalFrame6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(161, 161, 161))
    );

    jTabbedPaneEditor.addTab("Assembler", jInternalFrame5);

    jLabel1.setText("Created by : Jubin Mitra");
    jLabel1.setName("jLabel1"); // NOI18N

    jMenuBar1.setName("jMenuBar1"); // NOI18N

    jMenuFile.setMnemonic('f');
    jMenuFile.setText("File");
    jMenuFile.setName("jMenuFile"); // NOI18N

    jMenuItemLoad_Assembly_Language_code.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItemLoad_Assembly_Language_code.setText("Load Assembly Language code");
    jMenuItemLoad_Assembly_Language_code.setName("jMenuItemLoad_Assembly_Language_code"); // NOI18N
    jMenuItemLoad_Assembly_Language_code.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemLoad_Assembly_Language_codeActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItemLoad_Assembly_Language_code);

    jMenuItemLoad_Hexcode.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
    jMenuItemLoad_Hexcode.setText("Load Hexcode/Disassembler");
    jMenuItemLoad_Hexcode.setName("jMenuItemLoad_Hexcode"); // NOI18N
    jMenuItemLoad_Hexcode.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemLoad_HexcodeActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItemLoad_Hexcode);

    jSeparator7.setName("jSeparator7"); // NOI18N
    jMenuFile.add(jSeparator7);

    jMenuItemSave_Assembly_Language_code.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItemSave_Assembly_Language_code.setText("Save Assembly Language code");
    jMenuItemSave_Assembly_Language_code.setName("jMenuItemSave_Assembly_Language_code"); // NOI18N
    jMenuItemSave_Assembly_Language_code.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemSave_Assembly_Language_codeActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItemSave_Assembly_Language_code);

    jMenuItemSave_Hexcode.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
    jMenuItemSave_Hexcode.setText("Save Hexcode");
    jMenuItemSave_Hexcode.setName("jMenuItemSave_Hexcode"); // NOI18N
    jMenuItemSave_Hexcode.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemSave_HexcodeActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItemSave_Hexcode);

    jSeparator8.setName("jSeparator8"); // NOI18N
    jMenuFile.add(jSeparator8);

    jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem18.setText("Print Editor Content");
    jMenuItem18.setName("jMenuItem18"); // NOI18N
    jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem18ActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItem18);

    jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
    jMenuItem19.setText("Print Workspace Content");
    jMenuItem19.setName("jMenuItem19"); // NOI18N
    jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem19ActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItem19);

    jSeparator11.setName("jSeparator11"); // NOI18N
    jMenuFile.add(jSeparator11);

    jMenuItemRecover.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jMenuItemRecover.setText("Recover last session");
    jMenuItemRecover.setName("jMenuItemRecover"); // NOI18N
    jMenuItemRecover.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemRecoverActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItemRecover);

    jSeparator10.setName("jSeparator10"); // NOI18N
    jMenuFile.add(jSeparator10);

    jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
    jMenuItemExit.setText("Exit");
    jMenuItemExit.setName("jMenuItemExit"); // NOI18N
    jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemExitActionPerformed(evt);
        }
    });
    jMenuFile.add(jMenuItemExit);

    jMenuBar1.add(jMenuFile);

    jMenu10.setText("Edit");
    jMenu10.setName("jMenu10"); // NOI18N

    jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem14.setText("Undo");
    jMenuItem14.setName("jMenuItem14"); // NOI18N
    jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem14ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem14);

    jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem15.setText("Redo");
    jMenuItem15.setName("jMenuItem15"); // NOI18N
    jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem15ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem15);

    jSeparator2.setName("jSeparator2"); // NOI18N
    jMenu10.add(jSeparator2);

    jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem11.setText("Cut");
    jMenuItem11.setName("jMenuItem11"); // NOI18N
    jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem11ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem11);

    jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem12.setText("Copy");
    jMenuItem12.setName("jMenuItem12"); // NOI18N
    jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem12ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem12);

    jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem13.setText("Paste");
    jMenuItem13.setName("jMenuItem13"); // NOI18N
    jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem13ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem13);

    jSeparator4.setName("jSeparator4"); // NOI18N
    jMenu10.add(jSeparator4);

    jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem16.setText("Find");
    jMenuItem16.setName("jMenuItem16"); // NOI18N
    jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem16ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem16);

    jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem17.setText("Replace");
    jMenuItem17.setName("jMenuItem17"); // NOI18N
    jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem17ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem17);

    jMenuBar1.add(jMenu10);

    jMenu1.setText("Tools");
    jMenu1.setName("jMenu1"); // NOI18N

    jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
    jMenuItem4.setText("Assemble");
    jMenuItem4.setName("jMenuItem4"); // NOI18N
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem4ActionPerformed(evt);
        }
    });
    jMenu1.add(jMenuItem4);

    jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
    jMenuItem5.setText("Disassemble");
    jMenuItem5.setName("jMenuItem5"); // NOI18N
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem5ActionPerformed(evt);
        }
    });
    jMenu1.add(jMenuItem5);

    jSeparator9.setName("jSeparator9"); // NOI18N
    jMenu1.add(jSeparator9);

    jMenuItemAutocorrect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
    jMenuItemAutocorrect.setText("Autocorrect");
    jMenuItemAutocorrect.setName("jMenuItemAutocorrect"); // NOI18N
    jMenuItemAutocorrect.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemAutocorrectActionPerformed(evt);
        }
    });
    jMenu1.add(jMenuItemAutocorrect);

    jMenuBar1.add(jMenu1);

    jMenuSettings.setText("Settings");
    jMenuSettings.setName("jMenuSettings"); // NOI18N

    jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem1.setText("Set Memory Range");
    jMenuItem1.setName("jMenuItem1"); // NOI18N
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
        }
    });
    jMenuSettings.add(jMenuItem1);

    jMenu4.setText("Simulation Speed");
    jMenu4.setName("jMenu4"); // NOI18N

    jRadioButtonMenuItemStepByStep.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jRadioButtonMenuItemStepByStep.setSelected(true);
    jRadioButtonMenuItemStepByStep.setText("Step by Step ");
    jRadioButtonMenuItemStepByStep.setName("jRadioButtonMenuItemStepByStep"); // NOI18N
    jRadioButtonMenuItemStepByStep.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonMenuItemStepByStepActionPerformed(evt);
        }
    });
    jMenu4.add(jRadioButtonMenuItemStepByStep);

    jRadioButtonMenuItemNormal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jRadioButtonMenuItemNormal.setSelected(true);
    jRadioButtonMenuItemNormal.setText("Normal");
    jRadioButtonMenuItemNormal.setName("jRadioButtonMenuItemNormal"); // NOI18N
    jRadioButtonMenuItemNormal.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonMenuItemNormalActionPerformed(evt);
        }
    });
    jMenu4.add(jRadioButtonMenuItemNormal);

    jRadioButtonMenuItemUltimate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jRadioButtonMenuItemUltimate.setSelected(true);
    jRadioButtonMenuItemUltimate.setText("Ultimate");
    jRadioButtonMenuItemUltimate.setName("jRadioButtonMenuItemUltimate"); // NOI18N
    jRadioButtonMenuItemUltimate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonMenuItemUltimateActionPerformed(evt);
        }
    });
    jMenu4.add(jRadioButtonMenuItemUltimate);

    jMenuSettings.add(jMenu4);

    jMenuItemClearMemory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jMenuItemClearMemory.setText("Clear Memory ");
    jMenuItemClearMemory.setName("jMenuItemClearMemory"); // NOI18N
    jMenuItemClearMemory.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemClearMemoryActionPerformed(evt);
        }
    });
    jMenuSettings.add(jMenuItemClearMemory);

    jSeparator5.setName("jSeparator5"); // NOI18N
    jMenuSettings.add(jSeparator5);

    jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem9.setText("Show/Hide Interface Editor");
    jMenuItem9.setName("jMenuItem9"); // NOI18N
    jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem9ActionPerformed(evt);
        }
    });
    jMenuSettings.add(jMenuItem9);

    jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem3.setText("Show/Hide  Editor");
    jMenuItem3.setName("jMenuItem3"); // NOI18N
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem3ActionPerformed(evt);
        }
    });
    jMenuSettings.add(jMenuItem3);

    jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem2.setText("Show/Hide Workspace");
    jMenuItem2.setName("jMenuItem2"); // NOI18N
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt);
        }
    });
    jMenuSettings.add(jMenuItem2);

    jSeparator6.setName("jSeparator6"); // NOI18N
    jMenuSettings.add(jSeparator6);

    jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem6.setText("Stop simulation at mnemonic");
    jMenuItem6.setName("jMenuItem6"); // NOI18N
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem6ActionPerformed(evt);
        }
    });
    jMenuSettings.add(jMenuItem6);

    jMenuBar1.add(jMenuSettings);

    jMenu2.setText("Simulation");
    jMenu2.setName("jMenu2"); // NOI18N

    jMenuItemRunAllAtATime.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP, java.awt.event.InputEvent.ALT_MASK));
    jMenuItemRunAllAtATime.setText("Run all at time");
    jMenuItemRunAllAtATime.setName("jMenuItemRunAllAtATime"); // NOI18N
    jMenuItemRunAllAtATime.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemRunAllAtATimeActionPerformed(evt);
        }
    });
    jMenu2.add(jMenuItemRunAllAtATime);

    jMenu3.setText("Run step by step ");
    jMenu3.setName("jMenu3"); // NOI18N

    jMenuItemForward.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.ALT_MASK));
    jMenuItemForward.setText("Forward");
    jMenuItemForward.setName("jMenuItemForward"); // NOI18N
    jMenuItemForward.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemForwardActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItemForward);

    jMenuItemBackward.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.ALT_MASK));
    jMenuItemBackward.setText("Backward");
    jMenuItemBackward.setName("jMenuItemBackward"); // NOI18N
    jMenuItemBackward.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemBackwardActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItemBackward);

    jMenu2.add(jMenu3);

    jMenuItemStop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, java.awt.event.InputEvent.ALT_MASK));
    jMenuItemStop.setText("Stop");
    jMenuItemStop.setName("jMenuItemStop"); // NOI18N
    jMenuItemStop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemStopActionPerformed(evt);
        }
    });
    jMenu2.add(jMenuItemStop);

    jMenuBar1.add(jMenu2);

    jMenu11.setText("Subroutine");
    jMenu11.setName("jMenu11"); // NOI18N

    jMenuItemInterruptServiceSubroutine.setText("Interrupt Service Subroutine");
    jMenuItemInterruptServiceSubroutine.setName("jMenuItemInterruptServiceSubroutine"); // NOI18N
    jMenuItemInterruptServiceSubroutine.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemInterruptServiceSubroutineActionPerformed(evt);
        }
    });
    jMenu11.add(jMenuItemInterruptServiceSubroutine);

    jMenuItemDelaySubroutine.setText("Insert Delay Subroutine");
    jMenuItemDelaySubroutine.setName("jMenuItemDelaySubroutine"); // NOI18N
    jMenuItemDelaySubroutine.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemDelaySubroutineActionPerformed(evt);
        }
    });
    jMenu11.add(jMenuItemDelaySubroutine);

    jMenuBar1.add(jMenu11);

    jMenu6.setText("View");
    jMenu6.setName("jMenu6"); // NOI18N

    jMenuItem26.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
    jMenuItem26.setText("8085 microprocessor trainer kit");
    jMenuItem26.setName("jMenuItem26"); // NOI18N
    jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem26ActionPerformed(evt);
        }
    });
    jMenu6.add(jMenuItem26);

    jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
    jMenuItem21.setText("Code Wizard");
    jMenuItem21.setName("jMenuItem20"); // NOI18N
    jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem20ActionPerformed(evt);
        }
    });
    jMenu6.add(jMenuItem21);

    jMenuBar1.add(jMenu6);

    jMenu12.setText("Connect");
    jMenu12.setName("jMenu12"); // NOI18N

    jMenu7.setText("Connnect Interfacing device");
    jMenu7.setName("jMenu7"); // NOI18N

    jCheckBoxMenuItemIOPort.setText("I/O Port");
    jCheckBoxMenuItemIOPort.setName("jCheckBoxMenuItemIOPort"); // NOI18N
    jCheckBoxMenuItemIOPort.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBoxMenuItemIOPortActionPerformed(evt);
        }
    });
    jMenu7.add(jCheckBoxMenuItemIOPort);

    jCheckBoxMenuItemPeriphralInterface.setText("Programmable Peripheral Interface");
    jCheckBoxMenuItemPeriphralInterface.setName("jCheckBoxMenuItemPeriphralInterface"); // NOI18N
    jCheckBoxMenuItemPeriphralInterface.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBoxMenuItemPeriphralInterfaceActionPerformed(evt);
        }
    });
    jMenu7.add(jCheckBoxMenuItemPeriphralInterface);

    jCheckBoxMenuItem3.setText("DMA Controller");
    jCheckBoxMenuItem3.setName("jCheckBoxMenuItem3"); // NOI18N
    jMenu7.add(jCheckBoxMenuItem3);

    jCheckBoxMenuItem4.setText("Interrupt Controller");
    jCheckBoxMenuItem4.setName("jCheckBoxMenuItem4"); // NOI18N
    jMenu7.add(jCheckBoxMenuItem4);

    jCheckBoxMenuItem5.setText("Communication Interface");
    jCheckBoxMenuItem5.setName("jCheckBoxMenuItem5"); // NOI18N
    jMenu7.add(jCheckBoxMenuItem5);

    jMenu12.add(jMenu7);

    jMenu8.setText("Connect Peripheral Device");
    jMenu8.setName("jMenu8"); // NOI18N

    jMenuItem7.setText("7 Segment Display");
    jMenuItem7.setName("jMenuItem7"); // NOI18N
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem7ActionPerformed(evt);
        }
    });
    jMenu8.add(jMenuItem7);

    jMenuItem8.setText("Stepper Motor");
    jMenuItem8.setName("jMenuItem8"); // NOI18N
    jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem8ActionPerformed(evt);
        }
    });
    jMenu8.add(jMenuItem8);

    jMenu12.add(jMenu8);

    jMenuBar1.add(jMenu12);

    jMenu5.setText("Load Sample Program");
    jMenu5.setName("jMenu5"); // NOI18N
    jMenuBar1.add(jMenu5);

    jMenuHelp.setText("Help");
    jMenuHelp.setName("jMenuHelp"); // NOI18N

    jMenuItemHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItemHelp.setText("Mnemonic Help");
    jMenuItemHelp.setName("jMenuItemHelp"); // NOI18N
    jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemHelpActionPerformed(evt);
        }
    });
    jMenuHelp.add(jMenuItemHelp);

    jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
    jMenuItem10.setText("Documentation");
    jMenuItem10.setName("jMenuItem10"); // NOI18N
    jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem10ActionPerformed(evt);
        }
    });
    jMenuHelp.add(jMenuItem10);

    jMenuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
    jMenuItemAbout.setText("About");
    jMenuItemAbout.setName("jMenuItemAbout"); // NOI18N
    jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemAboutActionPerformed(evt);
        }
    });
    jMenuHelp.add(jMenuItemAbout);

    jMenuBar1.add(jMenuHelp);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTabbedPaneMemory, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jTabbedPaneEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1))
        .addGroup(layout.createSequentialGroup()
            .addComponent(jTabbedPaneMemory, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

   private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed

       jButtonStop.setVisible(true);
       jButtonRun.setVisible(false);
       jButtonStep.setVisible(false);
       jLabelErrorHang.setVisible(false);
       stop=false;
       ExecutorService exec = Executors.newCachedThreadPool();
       exec.execute(this);


   }//GEN-LAST:event_jButtonRunActionPerformed

    @Override
   public void run()
   {
       matrix.PC=(continueFrom==0)?engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldBeginFrom.getText())):continueFrom;
       if(speed[1]!=1){
       jProgressBar1.setVisible(true);       
       while((!stop)&&matrix.PC<matrix.stopAddress&&(!pause))
       {
               try{
                   matrix.functionRun(matrix.memory[matrix.PC]);
                   jProgressBar1.setIndeterminate(true);
                   
               for(int row=0;row<jTableAssembler.getRowCount();row++){
                  if(jTableAssembler.getValueAt(row, 0)!=null)
                   if(engine.convertToNum(jTableAssembler.getValueAt(row, 1).toString())==matrix.PC)
                   if(jTableAssembler.getValueAt(row, 0).toString().equalsIgnoreCase("#")) {
                              set();
                              jButtonStep.setVisible(false);
                              jButtonRun.setVisible(false);
                              jButtonForward.setVisible(true);
                              jButtonBackward.setVisible(true);
                              jButtonStop.setText("Stop");
                              jButtonStop.setVisible(true);
                              jLabelErrorHang.setVisible(false);
                              jButtonContinue.setVisible(true);
                              continueFrom=matrix.PC;
                              pause = true;
                              jTableAssembler.setRowSelectionAllowed(true);
                              jTableAssembler.changeSelection(row,0, false, false);
                              }
               }
                       if(speed[2]==1){
                           setResister();
                            if(matrix.clockCycleCounter%10000==0){set();}

                       }
               }
               catch(StringIndexOutOfBoundsException e)
                {
                   jButtonStop.doClick();
                   jLabelErrorHang.setText("You have exceeded the memory range");
                   jLabelErrorHang.setVisible(true);
               }

       }}
       else{
                    if(continueFrom==0)jButtonStop.setText("Pause");
                  //jButtonContinue.setVisible(true);
                  while((!stop)&&matrix.PC<matrix.stopAddress&&(!pause))
                  {
                      try {
               for(int row=0;row<jTableAssembler.getRowCount();row++){
                  if(jTableAssembler.getValueAt(row, 0)!=null)
                   if(engine.convertToNum(jTableAssembler.getValueAt(row, 1).toString())==matrix.PC)
                   if(jTableAssembler.getValueAt(row, 0).toString().equalsIgnoreCase("#")) {
                              jButtonStep.setVisible(false);
                              jButtonRun.setVisible(false);
                              jButtonForward.setVisible(true);
                              jButtonBackward.setVisible(true);
                              jButtonStop.setVisible(true);
                              jButtonStop.setText("Stop");
                              jLabelErrorHang.setVisible(false);
                              jButtonContinue.setVisible(true);
                              continueFrom=matrix.PC;
                              jTableAssembler.setRowSelectionAllowed(true);
                              jTableAssembler.changeSelection(row,0, false, false);
                              pause = true;
                              }
                            jButtonForwardActionPerformed(null);
                            Thread.sleep((long) (speed[0] * 1000));
                        }
                      } catch (Exception e) {
                      }
                  }

       }
       if(!pause){
           jButtonStop.setText("Stop");
           jButtonStop.doClick();
       }
       jProgressBar1.setIndeterminate(false);
       jProgressBar1.setVisible(false);
       set();
   }

   private void jButtonStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepActionPerformed

       jButtonStep.setVisible(false);
       jButtonRun.setVisible(false);
       jButtonForward.setVisible(true);
       jButtonBackward.setVisible(true);
       jButtonStop.setVisible(true);
       jLabelErrorHang.setVisible(false);
       stop=false;
       matrix.PC=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldBeginFrom.getText()));

   }//GEN-LAST:event_jButtonStepActionPerformed

   private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
     if(stop|| jButtonStop.getText().equalsIgnoreCase("Stop"))
     {
       matrix.select = 0;
       jButtonForward.setVisible(false);
       jButtonBackward.setVisible(false);
       jButtonStop.setVisible(false);
       jButtonRun.setVisible(true);
       jButtonStep.setVisible(true);
       jButtonContinue.setVisible(false);
       jScrollPane12.setVisible(false);
       jScrollPane12.setVisible(true);
       jTabbedPaneAssemblerEditor.setVisible(false);
       jTabbedPaneAssemblerEditor.setVisible(true);
       continueFrom=0;
       stop=true;
       pause=false;
       File f=new File("cache");
       deleteDir(f);
     }
     if(jButtonStop.getText().equalsIgnoreCase("Pause"))
     {
         pause = true;
         jButtonForward.setVisible(true);
         jButtonBackward.setVisible(true);
         jButtonStop.setVisible(true);
         jButtonContinue.setVisible(true);
         jButtonRun.setVisible(false);
         jButtonStep.setVisible(false);
         jScrollPane12.setVisible(false);
         jScrollPane12.setVisible(true);
         jButtonStop.setText("Stop");
     }

   }//GEN-LAST:event_jButtonStopActionPerformed

   private void jButtonBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackwardActionPerformed
      oIndex--;
      matrix.readCopy(matrix);       
       try{
       if( matrix.select<1000)
          if(jTableAssembler.getValueAt(matrix.select, 3)!=null)
          {  jTableAssembler.setRowSelectionAllowed(true);
             jTableAssembler.changeSelection(matrix.select, matrix.select, false, false);
             jLabelError.setText(comments[matrix.select]);
             jLabelComment.setText(matrix.comment(engine.Hex2Dec(jTableAssembler.getValueAt(matrix.select, 4).toString())));
          }
       }catch(Exception e){}
        set();
   }//GEN-LAST:event_jButtonBackwardActionPerformed

   private void jRadioButtonShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonShowAllActionPerformed
        setMemory();
}//GEN-LAST:event_jRadioButtonShowAllActionPerformed

   private void jRadioButtonUsedMemoryLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUsedMemoryLocationActionPerformed

       int lower = engine.Hex2Dec(jTextFieldMemBegin.getText());
       int upper = engine.Hex2Dec(jTextFieldMemStop.getText());
       jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
               new Object[upper - lower+1][2],
               new String[]{
           "Memory Address", "Value"
       }) {

           Class[] types = new Class[]{
               java.lang.String.class, java.lang.String.class
           };
           boolean[] canEdit = new boolean[]{
               true,true
           };

           public Class getColumnClass(int columnIndex) {
               return types[columnIndex];
           }

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit[columnIndex];
           }
       });
       for(int i=0,row=0;i<=(upper-lower);i++)
       {
           if(matrix.memory[i+lower]!=0)
           {
           jTableMemory.setValueAt("                    "+engine.Dec2Hex(i+lower), row, 0);
           jTableMemory.setValueAt("                          "+engine.Dec2Hex2digit(matrix.memory[i+lower]), row, 1);
           row++;
           }
       }
       jRadioButtonShowAll.setSelected(false);
       jRadioButtonStoreMemoryLocation.setSelected(false);
       jRadioButtonUsedMemoryLocation.setSelected(true);
       tableState=1;

}//GEN-LAST:event_jRadioButtonUsedMemoryLocationActionPerformed

   private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed

       new About().setVisible(true);
   }//GEN-LAST:event_jMenuItemAboutActionPerformed

   private void jTextFieldMemBeginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMemBeginActionPerformed
       jTextFieldMemBegin.setEditable(false);
       jTextFieldMemStop.setEditable(false);
       jTextFieldMemBegin.setText(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
       jTextFieldMemStop.setText(engine.HexAutoCorrect4digit(jTextFieldMemStop.getText()));
       jTextFieldBeginFrom.setText(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
       try {
           int lower = engine.Hex2Dec(jTextFieldMemBegin.getText());
           int upper = engine.Hex2Dec(jTextFieldMemStop.getText());
           if(lower>upper)Popup.show("Upper range cannot be lower than the lower range.");
           int n = (upper - lower + 1) / 16;
           if (n % 16 != 0) {
               n = n - (n % 16) + 16;
           }
           jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
                   new Object[n][17],
                   new String[]{
                       "        ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
                   }) {

               Class[] types = new Class[]{
                   java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
               };
               boolean[] canEdit = new boolean[]{
                   false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
               };

               public Class getColumnClass(int columnIndex) {
                   return types[columnIndex];
               }

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                   return canEdit[columnIndex];
               }
           });
           jTableMemory.getColumnModel().getColumn(0).setPreferredWidth(330);
             matrix.beginAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
             matrix.stopAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemStop.getText()));
               setMemory();

       }catch(Exception e){Popup.show("Memory address should be in the format XXX0");jTextFieldMemBegin.setText("C000");setMemory();}


}//GEN-LAST:event_jTextFieldMemBeginActionPerformed

   private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
       closeButtonFileSave();
   }//GEN-LAST:event_jMenuItemExitActionPerformed

   private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

       jTabbedPaneMemory.setSelectedComponent(jTabbedPaneMemory.getComponentAt(1));
       jTextFieldMemBegin.setEditable(true);
       jTextFieldMemStop.setEditable(true);
   }//GEN-LAST:event_jMenuItem1ActionPerformed

   private void jTextFieldMemStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMemStopActionPerformed
            
            jTextFieldMemBegin.setEditable(false);
            jTextFieldMemStop.setEditable(false);
            jTextFieldMemBegin.setText(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
            jTextFieldMemStop.setText(engine.HexAutoCorrect4digit(jTextFieldMemStop.getText()));
            jTextFieldBeginFrom.setText(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
           try{
               int lower = engine.Hex2Dec(jTextFieldMemBegin.getText());
               int upper = engine.Hex2Dec(jTextFieldMemStop.getText());
               if(lower>upper)Popup.show("Upper range cannot be  lower than the lower range.");
               int n = (upper - lower + 1) / 16;
               if (n % 16 != 0) {
                   n = n - (n % 16) + 16;
               }
               jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
                       new Object[n][17],
                       new String[]{
                           "        ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
                       }) {

                   Class[] types = new Class[]{
                       java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                   };
                   boolean[] canEdit = new boolean[]{
                       false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
                   };

                   public Class getColumnClass(int columnIndex) {
                       return types[columnIndex];
                   }

                   public boolean isCellEditable(int rowIndex, int columnIndex) {
                       return canEdit[columnIndex];
                   }
               });
               jTableMemory.getColumnModel().getColumn(0).setPreferredWidth(330);
               matrix.beginAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
               matrix.stopAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemStop.getText()));
               setMemory();
           }catch(Exception e){Popup.show("Memory address should be in the format XXXF");jTextFieldMemStop.setText("CFFF");setMemory();}

   }//GEN-LAST:event_jTextFieldMemStopActionPerformed

   private void jTableNoConverterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableNoConverterKeyReleased
 int select=jTableNoConverter.getSelectedColumn();
 String hex=jTableNoConverter.getValueAt(0, 0).toString().toUpperCase();
 int dec=Integer.parseInt(jTableNoConverter.getValueAt(0, 1).toString().toUpperCase());
 String binary=jTableNoConverter.getValueAt(0, 2).toString().toUpperCase();
 
       if(select==0){
                   jTableNoConverter.setValueAt(engine.Hex2Dec(hex), 0, 1);
                   jTableNoConverter.setValueAt(engine.Hex2Bin(hex), 0, 2);

       }

       else if(select==1){
           
           jTableNoConverter.setValueAt(engine.Dec2Hex(dec), 0, 0);
           jTableNoConverter.setValueAt(engine.Dec2Bin(dec), 0, 2);
           
       }
       else
       {
                  jTableNoConverter.setValueAt(engine.Bin2Dec(binary), 0, 1);
                  jTableNoConverter.setValueAt(engine.Bin2Hex(binary), 0, 0);

       }             
   }//GEN-LAST:event_jTableNoConverterKeyReleased

   private void jTableMemoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMemoryKeyReleased

       int lower=engine.Hex2Dec(jTextFieldMemBegin.getText());
       int upper=engine.Hex2Dec(jTextFieldMemStop.getText());
       if(tableState==0){
       for(int i=lower,row=0,col=1;i<=upper;i++,col++)
       {
            matrix.memory[i]=engine.Hex2Dec(engine.HexAutoCorrect2digit(jTableMemory.getValueAt(row,col).toString()));
            if(col==16){col=0;row++;}

       }
       set();}
       else{
            for(int i=0;jTableMemory.getValueAt(i, 0)!=null&&jTableMemory.getValueAt(i, 1)!=null&&i<(upper-lower);i++)
           {
               if(engine.Hex2Dec(jTableMemory.getValueAt(i,0).toString())<65536)matrix.memory[engine.Hex2Dec(jTableMemory.getValueAt(i,0).toString())]=engine.Hex2Dec(jTableMemory.getValueAt(i,1).toString());
               jTableMemory.setValueAt("                    "+engine.HexAutoCorrect4digit(jTableMemory.getValueAt(i,0).toString()), i,0);
               jTableMemory.setValueAt("                          "+engine.HexAutoCorrect2digit(jTableMemory.getValueAt(i,1).toString()), i,1);

           }
       }


   }//GEN-LAST:event_jTableMemoryKeyReleased

   private void jTablePortKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePortKeyReleased

       for (int i = 0,row=0,col=1; i < 256; i++, col++) {
            matrix.port[i]=engine.Hex2Dec(engine.HexAutoCorrect2digit(jTablePort.getValueAt(row, col).toString()));
            if(col==16){col=0;row++;}
        }
       set();
   }//GEN-LAST:event_jTablePortKeyReleased

   private void jTableAssemblerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableAssemblerKeyReleased

       
      /* if(jTableAssembler.getSelectedColumn()==3)
       {
           Assemble();
       }
       else if(jTableAssembler.getSelectedColumn()==4)
       {
           disAssemble();
       }*/

   }//GEN-LAST:event_jTableAssemblerKeyReleased

   private void jMenuItemClearMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearMemoryActionPerformed

       
       matrix=new Matrix(this);
       engine.m=matrix;
       matrix.PC=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldBeginFrom.getText()));
       matrix.beginAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemBegin.getText()));
       matrix.stopAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemStop.getText()));

       set();
   }//GEN-LAST:event_jMenuItemClearMemoryActionPerformed

   private void jTabbedPaneAssemblerEditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneAssemblerEditorMouseClicked
            if(jTabbedPaneAssemblerEditor.getSelectedIndex()==0) {
                jButtonAssemble.setVisible(true);
                jButtonDisassemble.setVisible(false);

        }
            else if(jTabbedPaneAssemblerEditor.getSelectedIndex()==1) {
            jButtonAssemble.setVisible(false);
            jButtonDisassemble.setVisible(true);
        }


   }//GEN-LAST:event_jTabbedPaneAssemblerEditorMouseClicked


   private void jButtonAssembleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssembleActionPerformed

       jTabbedPaneEditor.setSelectedComponent(jTabbedPaneEditor.getComponentAt(1));
       jScrollPane16.setVisible(true);
       jTabbedPaneLabelEditor.setVisible(false);
       jTabbedPaneLabelEditor.setVisible(true);
       jTabbedPaneLabelEditor.setVisible(false);
       jTableAssembler.setRowSelectionAllowed(false);
       jLabelErrorHang.setVisible(false);
       jLabelComment.setVisible(false);
       jLabelError.setVisible(false);
       jMenuItemClearMemoryActionPerformed(evt);
       jButtonStop.setText("Stop");
       jButtonStop.doClick();
       for(int i=0;i<65536;i++){matrix.memory[i]=0;
       matrix.label[i]="";}
       setMemory();
       for (int i = 0; i < macro.length; i++) {
           macro[i]="";
           
       }
       for(int i=0;i<999;i++){
           for(int j=0;j<8;j++)
           jTableAssembler.setValueAt(null,i,j);
       }

      String s=jTextAreaAssemblyLanguageEditor.getText();
      String line[]=new String[1000];
      String parse[]=new String[4];
      int i,n,row;

      //break into lines
      for(i=0,n=0;i<s.length();i++)
      {
          if(s.charAt(i)=='\n')n++;
          if(line[n]==null)line[n]="";
          line[n]=line[n]+s.charAt(i);
      }
      int selectIndex=0;
      int rowCompile = 0;
      for(i=0,row=0;i<=n;i++)
      {
          parse=engine.parseAssemblerContent(line[i]);
         try{ 
             if(parse[0].length()==0&&parse[1].length()==0&&parse[3].length()==0)continue;
             if(parse[3].length()!=0){
                 macro[rowCompile++]=parse[3].toUpperCase()+":"+row; 
                 continue;
             }
             if(parse[0].length()!=0&&parse[1].length()==0){
                 jTableAssembler.setValueAt(parse[0],row,2);
                 continue;
             }
             if(jTableAssembler.getValueAt(row, 2)==null)jTableAssembler.setValueAt(parse[0],row,2);
             jTableAssembler.setValueAt(parse[1],row,3);
             comments[row]=parse[2];
             row++;
         }catch(Exception e){
         }
      }
      Assemble();
      jTableAssembler.scrollRectToVisible(jTableAssembler.getCellRect(0, 0, false));
      errorCheck();
      jTextAreaAssemblyLanguageEditor.requestFocus();
      jTextAreaAssemblyLanguageEditor.getHighlighter().removeAllHighlights();
      check:
      for(i=0;i<=n;i++)
      {
        
          parse=engine.parseAssemblerContent(line[i]);
          if(line[i]!=null){
          selectIndex=line[i].length()+selectIndex;
              String temp[]=engine.MnemonicToHexcode(parse[1]);
             if(temp[0].equalsIgnoreCase("NOP")) {
                        textEditor.highligher(i);
             jTabbedPaneEditor.setSelectedComponent(jTabbedPaneEditor.getComponentAt(0));
                //jTextAreaAssemblyLanguageEditor.select(selectIndex-line[i].length(),selectIndex);
                break check;
                }
          }
      }
      jRadioButtonUsedMemoryLocationActionPerformed(evt);
       
   }//GEN-LAST:event_jButtonAssembleActionPerformed

   public void Assemble()
   {
      String[] commentTemp=new String[1000];
      String[] macroTemp=new String[1000];
      String[] label=new String[1000];
      String[] mnemonic=new String[1000];
      int begin=engine.Hex2Dec(jTextFieldMemBegin.getText());
      int macroCounterAddress=begin,macroCount=0;
       
      
      for(int i=0;jTableAssembler.getValueAt(i, 3)!=null;i++)
      {
          if(jTableAssembler.getValueAt(i, 2)!=null)label[i]=jTableAssembler.getValueAt(i, 2).toString().toUpperCase().trim();
          else label[i]="";
          mnemonic[i]=jTableAssembler.getValueAt(i, 3).toString();
          int j=mnemonic[i].indexOf(',');
          if(j!=-1){
              mnemonic[i]=engine.deleteSpace(mnemonic[i].substring(0,j))+','+engine.deleteSpace(mnemonic[i].substring(j+1,mnemonic[i].length()));
              j=mnemonic[i].indexOf(',');
              mnemonic[i]=(mnemonic[i].substring(0,3))+" "+mnemonic[i].substring(3,j)+','+mnemonic[i].substring(j+1,mnemonic[i].length());

          }
          
      }
       for (int i = 0; i < 1000; i++) {
          macroTemp[i]=macro[i];                
          commentTemp[i]=comments[i];
       }
      
      setMemory();      
       
        for(int i=0,temp=begin,x=0,row=0;mnemonic[i]!=null;i++)
        {
               
          try{
              while(Integer.parseInt(macroTemp[macroCount].substring(macroTemp[macroCount].lastIndexOf(":")+1, macroTemp[macroCount].length()))==i)
              {
                    preprocessor.process(this, macroTemp[macroCount++], macroCounterAddress);
                    if(memShift != 0)macroCounterAddress=memShift;
              }        
              
            }catch(Exception e){}      
          if(memShift != 0) temp = begin + memShift;
          matrix.label[temp]=label[i];
          x=engine.getBytesFromMnemonics(mnemonic[i]);
          jTableAssembler.setValueAt(memShift,row,1);          
          if(memShift == 0)macroCounterAddress+=x;
          memShift=0;
          jTableAssembler.setValueAt("  "+label[i],row,2);
          jTableAssembler.setValueAt(mnemonic[i],row,3);
          comments[row]=commentTemp[i];
          temp=temp+x;
          row=row+x;
          for(int j=row-x+1;j<row;j++) {
                jTableAssembler.setValueAt("",j, 2);
                comments[j]=""; 
          }

        }
        
        try {
           if(macro[macroCount]!=null){ //to take care of last macros
                  while(!macroTemp[macroCount].equalsIgnoreCase(""))
                    {
                            preprocessor.process(this, macroTemp[macroCount++], macroCounterAddress);                                  
                            if(memShift != 0)macroCounterAddress=memShift;
                    }
              }
       } catch (Exception e) {}
       memShift =0;
        
      loadMnemonics();
      /*for(int i=0,memShiftTemp=0;jTableAssembler.getValueAt(i, 4)!=null;i++)
      {
          try{
              if(Integer.parseInt(jTableAssembler.getValueAt(i,1).toString())>0)
                            memShiftTemp=engine.Hex2Dec(jTableAssembler.getValueAt(i,1).toString());
              }catch(Exception e){}
          matrix.memory[memShiftTemp]=engine.Hex2Dec(jTableAssembler.getValueAt(i, 4).toString());
      }*/
      jTabbedPaneAssemblerEditor.setSelectedIndex(0);
      jButtonAssemble.setVisible(true);
      jButtonDisassemble.setVisible(false);
   }

   public void loadMnemonics()
   {

       String s[]=new String[4];
       int funcNo=0,memShiftTemp=0;
       for(int i=0;jTableAssembler.getValueAt(i, 3)!=null;i++)
          {
                    s=engine.MnemonicToHexcode(jTableAssembler.getValueAt(i, 3).toString());
                    funcNo=Integer.parseInt(s[3].trim());
                    if(s[0].equalsIgnoreCase("NOP")){jTableAssembler.setValueAt("X",i,0);}
                    else jTableAssembler.setValueAt("√",i,0);

                    try{
                        if(Integer.parseInt(jTableAssembler.getValueAt(i,1).toString())>0)
                            memShiftTemp=Integer.parseInt(jTableAssembler.getValueAt(i,1).toString())-i;
                    }catch(Exception e){}
                    
                    jTableAssembler.setValueAt(engine.Dec2Hex((engine.Hex2Dec(jTextFieldMemBegin.getText())+i+memShiftTemp)&0xFFFF),i,1);
                    jTableAssembler.setValueAt("   "+s[0], i, 3);
                    jTableAssembler.setValueAt("       "+engine.Dec2Hex2digit(funcNo), i, 4);
                    jTableAssembler.setValueAt("       "+engine.I[funcNo][0],i,5);
                    jTableAssembler.setValueAt("       "+engine.I[funcNo][1],i,6);
                    jTableAssembler.setValueAt("      "+engine.I[funcNo][2],i,7);
                    matrix.memory[(engine.Hex2Dec(jTextFieldMemBegin.getText())+i+memShiftTemp)&0xFFFF]=funcNo;

                    for(int j=1;j<engine.I[funcNo][0];j++)
                    {
                        i++;
                        jTableAssembler.setValueAt(engine.Dec2Hex((engine.Hex2Dec(jTextFieldMemBegin.getText())+i+memShiftTemp)&0xFFFF),i,1);
                        jTableAssembler.setValueAt("       "+s[j], i, 4);
                        jTableAssembler.setValueAt("", i, 3);
                        matrix.memory[(engine.Hex2Dec(jTextFieldMemBegin.getText())+i+memShiftTemp)&0xFFFF]=engine.Hex2Dec(s[j]);

                    }

          }

   }

   private void errorCheck()
    {
        loop:
        for(int i=0,row=0;jTableAssembler.getValueAt(i, 4)!=null&&i<999;i++)
        {
            if(jTableAssembler.getValueAt(i, 0)!=null){
                row++;
                 if(jTableAssembler.getValueAt(i, 0).toString().equalsIgnoreCase("X"))
                 {
                 jTableAssembler.setRowSelectionAllowed(true);
                 jTableAssembler.setRowSelectionInterval(i, i);
                 jLabelError.setForeground(Color.red);
                 jLabelError.setVisible(true);
                 jLabelError.setText("Error : At Line no "+row);
                 jTableAssembler.scrollRectToVisible(jTableAssembler.getCellRect(i, 0, false));
                 break loop;
                  }
            else {
                 jLabelError.setVisible(false);
            }
            }
        }
    }


   private void jButtonDisassembleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisassembleActionPerformed
       jScrollPane16.setVisible(true);
       jTabbedPaneLabelEditor.setVisible(false);
       jTabbedPaneLabelEditor.setVisible(true);
       jTabbedPaneLabelEditor.setVisible(false);
       jTableAssembler.setRowSelectionAllowed(false);
       jLabelErrorHang.setVisible(false);
       jLabelComment.setVisible(false);
       jLabelError.setVisible(false);
       jMenuItemClearMemoryActionPerformed(evt);
       jButtonStop.setText("Stop");
       jButtonStop.doClick();
       
       disassembler.loadDisassembler();
       setMemory();
       jRadioButtonUsedMemoryLocationActionPerformed(evt);
       textEditor.colorEditor();
       /*
       jTabbedPaneEditor.setSelectedIndex(1);
       jScrollPane16.setVisible(true);
       jTabbedPaneLabelEditor.setVisible(false);
       jTabbedPaneLabelEditor.setVisible(true);
       jTabbedPaneLabelEditor.setVisible(false);
       jTableAssembler.setRowSelectionAllowed(false);
       jLabelErrorHang.setVisible(false);
       jLabelComment.setVisible(false);
       jLabelError.setVisible(false);
       jMenuItemClearMemoryActionPerformed(evt);
       jButtonStop.setText("Stop");
       jButtonStop.doClick();

       for(int i=0;i<65536;i++){matrix.memory[i]=0;matrix.label[i]="";}
       setMemory();
       for(int i=0;i<999;i++){
           for(int j=0;j<8;j++)
           jTableAssembler.setValueAt(null,i,j);
       }
       
       String s=jTextAreaDisassembler.getText();
       String temp="";
       for(int i=0;i<s.length();i++)
       {
           if(engine.isHex(s.charAt(i)))temp=temp+s.charAt(i);
       }s=temp;

       for(int i=0;i<s.length();i+=2)
       {
           if((i+1)<s.length())
           jTableAssembler.setValueAt(""+s.charAt(i)+s.charAt(i+1), i/2, 4);
       }
       disAssemble();
       errorCheck();
*/
   }//GEN-LAST:event_jButtonDisassembleActionPerformed

   private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(jScrollPane16.isVisible()) {
            jScrollPane16.setVisible(false);
        }
        else {
            jScrollPane16.setVisible(true);
            
        }
        if(jTabbedPaneLabelEditor.isVisible()){
                jTabbedPaneLabelEditor.setVisible(false);
                jTabbedPaneLabelEditor.setVisible(true);
            }
            else{
                jTabbedPaneLabelEditor.setVisible(true);
                jTabbedPaneLabelEditor.setVisible(false);
            }

   }//GEN-LAST:event_jMenuItem2ActionPerformed

   public void viewWorkSpace()
   {
       if(!jScrollPane16.isVisible())
       jMenuItem2ActionPerformed(null);
   }

   private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(jTabbedPaneAssemblerEditor.isVisible()){
            jTabbedPaneAssemblerEditor.setVisible(false);
            jTabbedPaneLabelEditor.setVisible(false);
            jButtonAssemble.setVisible(false);
            jButtonDisassemble.setVisible(false);
        }
        else{
            jTabbedPaneAssemblerEditor.setVisible(true);
            if(jTabbedPaneAssemblerEditor.getSelectedIndex()==0){jTabbedPaneLabelEditor.setVisible(false);
            jButtonAssemble.setVisible(true);
            jButtonDisassemble.setVisible(false);}
            else{
                jTabbedPaneLabelEditor.setVisible(false);
                jButtonAssemble.setVisible(false);
                jButtonDisassemble.setVisible(true);

            }
        }
   }//GEN-LAST:event_jMenuItem3ActionPerformed

   private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    jButtonAssembleActionPerformed(evt);
   }//GEN-LAST:event_jMenuItem4ActionPerformed

   private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
   jButtonDisassembleActionPerformed(evt);
   }//GEN-LAST:event_jMenuItem5ActionPerformed

   private void jMenuItemLoad_Assembly_Language_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoad_Assembly_Language_codeActionPerformed
       if(fileChooser.objectNo==0)
       fileChooser=new FileChooser("Load Mnemonics",this);
       fileChooser.setVisible(true);
   }//GEN-LAST:event_jMenuItemLoad_Assembly_Language_codeActionPerformed

   private void jMenuItemLoad_HexcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoad_HexcodeActionPerformed
        if(fileChooser.objectNo==0)
       fileChooser=new FileChooser("Load Hexcode",this);
       fileChooser.setVisible(true);
   }//GEN-LAST:event_jMenuItemLoad_HexcodeActionPerformed

   private void jMenuItemSave_Assembly_Language_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSave_Assembly_Language_codeActionPerformed
            if(jTabbedPaneAssemblerEditor.getSelectedIndex()==1)jButtonDisassembleActionPerformed(evt);
            else jButtonAssembleActionPerformed(evt);
            
            if(fileChooser.objectNo==0)
            fileChooser=new FileChooser("Save Mnemonics", this);
            fileChooser.setVisible(true);
   }//GEN-LAST:event_jMenuItemSave_Assembly_Language_codeActionPerformed

   private void jMenuItemSave_HexcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSave_HexcodeActionPerformed
            if(jTabbedPaneAssemblerEditor.getSelectedIndex()==1)jButtonDisassembleActionPerformed(evt);
            else jButtonAssembleActionPerformed(evt);
            
            if(fileChooser.objectNo==0)
            fileChooser=new FileChooser("Save Hexcode", this);
            fileChooser.setVisible(true);
   }//GEN-LAST:event_jMenuItemSave_HexcodeActionPerformed

   private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        jButtonStop.setText("Stop");
        jButtonStop.doClick();
        setEnabled(false);
        saveSettings();
        closeButtonFileSave();
        properShutdown=true;
        textEditor.jTextPane1FocusLost(null);
   }//GEN-LAST:event_formWindowClosing

   public  boolean deleteDir(File dir) {
       if (dir.isDirectory()) {
           String[] children = dir.list();
           for (int i = 0; i < children.length; i++) {
               boolean success = deleteDir(new File(dir, children[i]));
               if (!success) {
                   return false;
               }
           }
       }
// The directory is now empty so delete it
       return dir.delete();
}
   
   private void jButtonForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForwardActionPerformed

       jButtonBackward.setEnabled(true);
       if(matrix.stopAddress<matrix.PC||matrix.beginAddress>matrix.PC){
                        jButtonStop.doClick();
                        jLabelErrorHang.setText("You have exceeded the memory range");
                        jLabelErrorHang.setVisible(true);
      }
      //int select=matrix.PC-matrix.beginAddress;
      matrix.createCopy(matrix);

     oIndex++;
     try{
         loop:
           for(matrix.select = 0; matrix.select < 1000 ; matrix.select++)
           { 
            if(jTableAssembler.getValueAt(matrix.select, 3)!=null)
              if(matrix.PC==engine.Hex2Dec(jTableAssembler.getValueAt(matrix.select, 1).toString()) && matrix.select<1000)  
              {    jTableAssembler.setRowSelectionAllowed(true);
                   jTableAssembler.changeSelection(matrix.select, matrix.select, false, false);
                   jLabelError.setForeground(Color.BLUE);
                   jLabelError.setVisible(true);
                   jLabelError.setText("<html>"+comments[matrix.select]+"</html>");
                   jLabelComment.setVisible(true);
                   jLabelComment.setText("<html>"+matrix.comment(engine.Hex2Dec(jTableAssembler.getValueAt(matrix.select, 4).toString()))+"</html>");
                   matrix.select=matrix.select+Integer.parseInt(jTableAssembler.getValueAt(matrix.select, 5).toString().trim());
                   break loop;
              }
           }
       }catch(Exception e){
           System.out.println(e);
       }
     if(stop)
     {
         jButtonStop.doClick();
     }
     matrix.functionRun(matrix.memory[matrix.PC]);
     set();      
   }//GEN-LAST:event_jButtonForwardActionPerformed

   private void jTextFieldBeginFromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBeginFromKeyReleased
      matrix.PC=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldBeginFrom.getText()));

   }//GEN-LAST:event_jTextFieldBeginFromKeyReleased

   private void jMenuItemForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemForwardActionPerformed
       if(jButtonStep.isVisible())jButtonStepActionPerformed(evt);
       jButtonForward.doClick();
   }//GEN-LAST:event_jMenuItemForwardActionPerformed

   private void jMenuItemBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackwardActionPerformed
              if(jButtonStep.isVisible())jButtonStepActionPerformed(evt);
              jButtonBackward.doClick();
   }//GEN-LAST:event_jMenuItemBackwardActionPerformed

   private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
            Help help = new Help();
            help.setVisible(true);
   }//GEN-LAST:event_jMenuItemHelpActionPerformed

   private void jMenuItemStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStopActionPerformed
        jButtonStopActionPerformed(evt);
   }//GEN-LAST:event_jMenuItemStopActionPerformed

   private void jMenuItemRunAllAtATimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRunAllAtATimeActionPerformed
    jButtonRunActionPerformed(evt);
   }//GEN-LAST:event_jMenuItemRunAllAtATimeActionPerformed

   private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        setStopMnemonic s=new setStopMnemonic(this);
        s.setVisible(true);
        s.jButton1.setText("Set");
        s.s="Set";
   }//GEN-LAST:event_jMenuItem6ActionPerformed

   private void jRadioButtonMenuItemNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemNormalActionPerformed

       jRadioButtonMenuItemNormal.setSelected(true);
       jRadioButtonMenuItemStepByStep.setSelected(false);
       jRadioButtonMenuItemUltimate.setSelected(false);
       speed[0]=0;speed[1]=0;speed[2]=1;speed[3]=0;
   }//GEN-LAST:event_jRadioButtonMenuItemNormalActionPerformed

   private void jRadioButtonMenuItemUltimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemUltimateActionPerformed
       jRadioButtonMenuItemNormal.setSelected(false);
       jRadioButtonMenuItemStepByStep.setSelected(false);
       jRadioButtonMenuItemUltimate.setSelected(true);
       speed[0]=0;speed[1]=0;speed[2]=0;speed[3]=1;
   }//GEN-LAST:event_jRadioButtonMenuItemUltimateActionPerformed

   private void jRadioButtonMenuItemStepByStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemStepByStepActionPerformed
       jRadioButtonMenuItemNormal.setSelected(false);
       jRadioButtonMenuItemStepByStep.setSelected(true);
       jRadioButtonMenuItemUltimate.setSelected(false);
       speed[1]=1;speed[2]=0;speed[3]=0;
       setStopMnemonic stopMnemonic = new setStopMnemonic(this);
       stopMnemonic.setTitle("Delay by");
       stopMnemonic.jButton1.setText("Seconds");
       stopMnemonic.setVisible(true);       
       stopMnemonic.jTextField1.setText(String.valueOf(speed[0]));
       stopMnemonic.s="Seconds";
   }//GEN-LAST:event_jRadioButtonMenuItemStepByStepActionPerformed
    trainer trainerObj;
   private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed

            jTableAssembler.setVisible(true);
            if(trainerObj==null){
            trainerObj = new trainer(this);}
            trainerObj.setVisible(true);
   }//GEN-LAST:event_jMenuItem26ActionPerformed

   private void jTextFieldBeginFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBeginFromActionPerformed
       // TODO add your handling code here:
   }//GEN-LAST:event_jTextFieldBeginFromActionPerformed

   private void jTableMemoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMemoryMousePressed
       jTableMemoryKeyReleased(null);
}//GEN-LAST:event_jTableMemoryMousePressed

   private void jTableNoConverterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNoConverterMousePressed
 int select=jTableNoConverter.getSelectedColumn();
 String hex=jTableNoConverter.getValueAt(0, 0).toString().toUpperCase();
 int dec=Integer.parseInt(jTableNoConverter.getValueAt(0, 1).toString().toUpperCase());
 String binary=jTableNoConverter.getValueAt(0, 2).toString().toUpperCase();
 
       if(select==0){
                   jTableNoConverter.setValueAt(engine.Hex2Dec(hex), 0, 1);
                   jTableNoConverter.setValueAt(engine.Hex2Bin(hex), 0, 2);

       }

       else if(select==1){
           
           jTableNoConverter.setValueAt(engine.Dec2Hex(dec), 0, 0);
           jTableNoConverter.setValueAt(engine.Dec2Bin(dec), 0, 2);
           
       }
       else
       {
                  jTableNoConverter.setValueAt(engine.Bin2Dec(binary), 0, 1);
                  jTableNoConverter.setValueAt(engine.Bin2Hex(binary), 0, 0);

       }
       
}//GEN-LAST:event_jTableNoConverterMousePressed

   private void jButtonContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinueActionPerformed

       continueFrom=matrix.PC;
       jButtonForward.setVisible(false);
       jButtonBackward.setVisible(false);
       jButtonStop.setText("Pause");
       jButtonStop.setVisible(true);
       jButtonRun.setVisible(false);
       jButtonStep.setVisible(false);
       jScrollPane12.setVisible(false);
       jScrollPane12.setVisible(true);
       jButtonContinue.setVisible(false);
       pause=false;
       ExecutorService exec = Executors.newCachedThreadPool();
       exec.execute(this);


   }//GEN-LAST:event_jButtonContinueActionPerformed

   private void jTableAssemblerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAssemblerMouseClicked
       if (jTableAssembler.isColumnSelected(0) && jTableAssembler.getValueAt(jTableAssembler.getSelectedRow(), 0) != null) {
           if (!jTableAssembler.getValueAt(jTableAssembler.getSelectedRow(), 0).toString().equalsIgnoreCase("X")) {
               if (jTableAssembler.getValueAt(jTableAssembler.getSelectedRow(), 0).toString().equalsIgnoreCase("#")) {
                   jTableAssembler.setValueAt("√", jTableAssembler.getSelectedRow(), 0);
               } else {
                   jTableAssembler.setValueAt("#", jTableAssembler.getSelectedRow(), 0);
               }
           }
       } else if (jTableAssembler.isColumnSelected(7)) {
          if(jTableAssembler.getValueAt(jTableAssembler.getSelectedRow(), jTableAssembler.getSelectedColumn())!=null)
          {
              TimingDiagram t=new TimingDiagram(this,jTableAssembler.getValueAt(jTableAssembler.getSelectedRow(),1).toString());
              t.setVisible(true);
              t.setTitle(jTableAssembler.getValueAt(jTableAssembler.getSelectedRow(),3).toString());
          }
       }
       

   }//GEN-LAST:event_jTableAssemblerMouseClicked

   private void jButtonAutocorrectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAutocorrectActionPerformed
      jButtonAssembleActionPerformed(evt);
      jTabbedPaneEditor.setSelectedIndex(0);
      String s=jTextAreaAssemblyLanguageEditor.getText()+"\n";
      String line[]=new String[1000];
      String parse[][]=new String[1000][4];
      String temp="";
      int i,n,row,commentCounter=0,macroCounter=0,macroRow=0,lineNo=0;
      for(i=0,n=0;i<s.length();i++)
      {
          if(s.charAt(i)=='\n'){
              parse[n]=engine.parseAssemblerContent(line[n]);
              n++;
          }
          if(line[n]==null)line[n]="";
          line[n]=line[n]+s.charAt(i);
      }
            
      s="";       
      
      for(i=0,row=0;i<=n;i++)
      {
          loop:
          for(;commentCounter<1000;commentCounter++)
          {
              if(parse[commentCounter][2]!=null) {
                    if(!parse[commentCounter][1].isEmpty()) {
                        commentCounter++;
                        break loop;
                    }
              if(!parse[commentCounter][2].trim().equalsIgnoreCase(""))s=s+"// "+parse[commentCounter][2]+"\n";
                }
          }
          
          try{
              temp=macro[macroCounter].substring(macro[macroCounter].lastIndexOf(":")+1, macro[macroCounter].length());
              macroRow=Integer.parseInt(temp);
              if(macroRow==lineNo){
                 while(macroRow==lineNo)
                 {  
                    s=s+"# "+macro[macroCounter].substring(0,macro[macroCounter++].lastIndexOf(":"))+"\n";
                    temp=macro[macroCounter].substring(macro[macroCounter].lastIndexOf(":")+1, macro[macroCounter].length());
                     macroRow=Integer.parseInt(temp);
                 }
              }
          }catch(Exception e){
          }

          if(jTableAssembler.getValueAt(row,4)!=null)
          {

              lineNo++;
                if(!jTableAssembler.getValueAt(row, 2).toString().trim().equalsIgnoreCase("")){
                    s=s+"\n"+jTableAssembler.getValueAt(row, 2).toString().trim();
                    s=s+":";
                }
                s=s+"\t";
                if(!jTableAssembler.getValueAt(row, 3).toString().trim().equalsIgnoreCase("NOP"))
                    s=s+jTableAssembler.getValueAt(row, 3).toString();
                if(!comments[row].equalsIgnoreCase(""))s=s+"\t"+"// "+comments[row];
                //if(!macro[row].equalsIgnoreCase(""))s=s+"\n\t"+"# "+macro[row];
                s=s+"\n";
                row=row+Integer.parseInt(jTableAssembler.getValueAt(row, 5).toString().trim());
          }

      }
      jTextAreaAssemblyLanguageEditor.setText(s);
      textEditor.colorEditor();
      jTextAreaAssemblyLanguageEditor.select(0, 0);
      if (jLabelError.isVisible()) {
           if (jTableAssembler.getValueAt(jTableAssembler.getSelectedRow(), 0).toString().equalsIgnoreCase("X")) {
               jButtonAssembleActionPerformed(evt);
           }
       }
      jTabbedPaneEditor.setSelectedComponent(jTabbedPaneEditor.getComponentAt(0));
      //jMenuItem2ActionPerformed(evt);
   }//GEN-LAST:event_jButtonAutocorrectActionPerformed

   
   
   private void jMenuItemAutocorrectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAutocorrectActionPerformed

       jButtonAutocorrectActionPerformed(evt);
   }//GEN-LAST:event_jMenuItemAutocorrectActionPerformed

   private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

       lcd lcd=new lcd();
       lcd.setVisible(true);

   }//GEN-LAST:event_jMenuItem7ActionPerformed

   private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

       SteperMotor motor=new SteperMotor();
       motor.setVisible(true);
   }//GEN-LAST:event_jMenuItem8ActionPerformed

   private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

            if(jTabbedPaneInterface.isVisible())jTabbedPaneInterface.setVisible(false);
            else jTabbedPaneInterface.setVisible(true);

   }//GEN-LAST:event_jMenuItem9ActionPerformed

   private void jCheckBoxMenuItemIOPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemIOPortActionPerformed

       jTabbedPaneInterface.remove(jScrollPane4);
       if(jCheckBoxMenuItemIOPort.isSelected()){
           jTabbedPaneInterface.setVisible(true);
           jTabbedPaneInterface.addTab("I/O Port Editor", jScrollPane4);
       } else {
           if(jTabbedPaneInterface.getTabCount()==0)jTabbedPaneInterface.setVisible(false);
       }
       
}//GEN-LAST:event_jCheckBoxMenuItemIOPortActionPerformed

   private void jCheckBoxMenuItemPeriphralInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemPeriphralInterfaceActionPerformed
       jTabbedPaneInterface.remove(jPanel8255);
       if(jCheckBoxMenuItemPeriphralInterface.isSelected()){
           jTabbedPaneInterface.setVisible(true);
           jTabbedPaneInterface.addTab("8255", jPanel8255);
                   //jScrollPane8.setVisible(false);

       } else {
           if(jTabbedPaneInterface.getTabCount()==0)jTabbedPaneInterface.setVisible(false);
       }
       
   }//GEN-LAST:event_jCheckBoxMenuItemPeriphralInterfaceActionPerformed

   private void jButtonAnalizeCWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalizeCWActionPerformed


       jScrollPane8.setVisible(true);
       String s="";
        s="Control Word Analysis : \n";
        if ((ppi8255.CRin & 128) == 128) {
           s = s + "Bit No. 7:  It is set to 1, therefore Port A, B & C are defined as I/O Port.";

       } else {
           s = s + "Bit No. 7:  It is set to 0, therefore Port C are to be set or reset.";


       }


        jTextArea8255.setText(s);
   }//GEN-LAST:event_jButtonAnalizeCWActionPerformed

   private void jTable8255KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable8255KeyReleased

       ppi8255.get();

   }//GEN-LAST:event_jTable8255KeyReleased

   private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

       jTextAreaAssemblyLanguageEditor.copy();
   }//GEN-LAST:event_jMenuItem12ActionPerformed

   private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

       jTextAreaAssemblyLanguageEditor.cut();
   }//GEN-LAST:event_jMenuItem11ActionPerformed

   private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed

       jTextAreaAssemblyLanguageEditor.paste();

   }//GEN-LAST:event_jMenuItem13ActionPerformed

   String undo[]=new String[100];
   int undoIndex=0;

   private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed

      textEditor.undo();
      textEditor.colorEditor();
   }//GEN-LAST:event_jMenuItem14ActionPerformed

   private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed

      textEditor.redo();
      textEditor.colorEditor();

   }//GEN-LAST:event_jMenuItem15ActionPerformed
public int find=0;
   private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

       find=0;
       Find find=new Find(this);
       find.find();
       find.setVisible(true);

   }//GEN-LAST:event_jMenuItem16ActionPerformed

   private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed

       find=0;
       Find find=new Find(this);
       find.replace();
       find.setVisible(true);

      
   }//GEN-LAST:event_jMenuItem17ActionPerformed

   private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed

       PrinterJob printJob = PrinterJob.getPrinterJob();
       MessageFormat header=new MessageFormat("");
       MessageFormat footer=new MessageFormat("By Jubin`s 8085 simulator");
       printJob.setPrintable(jTextAreaAssemblyLanguageEditor.getPrintable(header, footer));
       if (printJob.printDialog()) {
           try {
               printJob.print();
           } catch (PrinterException pe) {
               System.out.println("Error printing: " + pe);
           }
       }

   }//GEN-LAST:event_jMenuItem18ActionPerformed

   private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed

       PrinterJob printJob = PrinterJob.getPrinterJob();
       MessageFormat header = new MessageFormat("");
       MessageFormat footer = new MessageFormat("By Jubin's 8085 simulator");
       String temp=jTextAreaAssemblyLanguageEditor.getText();
       String s="";
       s=s+jTableAssembler.getColumnName(1)+"\t  "+jTableAssembler.getColumnName(2)+"\t"+jTableAssembler.getColumnName(3)+"\t"+jTableAssembler.getColumnName(4)+"\t"+jTableAssembler.getColumnName(5)+"\t"+jTableAssembler.getColumnName(6)+"\t"+jTableAssembler.getColumnName(7)+"\n\n";

      
       for(int i=0;jTableAssembler.getValueAt(i, 1)!=null&&i<1000;i++)
       {
           s=s+(jTableAssembler.getValueAt(i, 1)==null?" ":jTableAssembler.getValueAt(i, 1))+"\t";
           s=s+(jTableAssembler.getValueAt(i, 2)==null?" ":jTableAssembler.getValueAt(i, 2))+"\t";
           s=s+(jTableAssembler.getValueAt(i, 3)==null?" ":jTableAssembler.getValueAt(i, 3))+"\t";
           s=s+(jTableAssembler.getValueAt(i, 4)==null?" ":jTableAssembler.getValueAt(i, 4))+"\t";
           s=s+(jTableAssembler.getValueAt(i, 5)==null?" ":jTableAssembler.getValueAt(i, 5))+"\t";
           s=s+(jTableAssembler.getValueAt(i, 6)==null?" ":jTableAssembler.getValueAt(i, 6))+"\t";
           s=s+(jTableAssembler.getValueAt(i, 7)==null?" ":jTableAssembler.getValueAt(i, 7))+"\n";
       }
       jTextAreaAssemblyLanguageEditor.setText(s);
       printJob.setPrintable(jTextAreaAssemblyLanguageEditor.getPrintable(header, footer));
       if (printJob.printDialog()) {
           try {
               printJob.print();
           } catch (PrinterException pe) {
               System.out.println("Error printing: " + pe);
           }
       }
       jTextAreaAssemblyLanguageEditor.setText(temp);

   }//GEN-LAST:event_jMenuItem19ActionPerformed

   private void jRadioButtonStoreMemoryLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStoreMemoryLocationActionPerformed

       jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
               new Object[100][2],
               new String[]{
           "Memory Address", "Value"
       }) {

           Class[] types = new Class[]{
               java.lang.String.class, java.lang.String.class
           };
           boolean[] canEdit = new boolean[]{
               true, true
           };

           public Class getColumnClass(int columnIndex) {
               return types[columnIndex];
           }

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit[columnIndex];
           }
       });
       jRadioButtonShowAll.setSelected(false);
       jRadioButtonUsedMemoryLocation.setSelected(false);
       jRadioButtonStoreMemoryLocation.setSelected(true);
       tableState=1;
}//GEN-LAST:event_jRadioButtonStoreMemoryLocationActionPerformed

   private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

       try {
                    
                    String filepath=System.getProperty("user.dir")+fileSeparator+"backup.dat";
                    String line="",s="";
                    BufferedReader in = new BufferedReader(new FileReader(filepath));
                    properShutdown=Boolean.valueOf(in.readLine());
                    while ((line = in.readLine()) != null) {
                           s = s + line + "\n";
                    }
                    in.close();
                    recover=s;
                    if(!properShutdown)new Recovery(this,s).setVisible(true);
                } catch (Exception e) {
                }
                properShutdown=false;
   }//GEN-LAST:event_formWindowOpened


   private void jMenuItemRecoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecoverActionPerformed
       properShutdown=false;
       try {

                    undoIndex++;
                    if(undoIndex<undo.length)undo[undoIndex]=jTextAreaAssemblyLanguageEditor.getText();
                    jTextAreaAssemblyLanguageEditor.setText(recover);
                    textEditor.colorEditor();
            } catch (Exception e) {}
   }//GEN-LAST:event_jMenuItemRecoverActionPerformed

   private void jMenuItemInterruptServiceSubroutineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInterruptServiceSubroutineActionPerformed

       new InterruptServiceSubroutine(this).setVisible(true);
   }//GEN-LAST:event_jMenuItemInterruptServiceSubroutineActionPerformed

   private void jMenuItemDelaySubroutineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDelaySubroutineActionPerformed

       new DelaySubroutine(this).setVisible(true);

   }//GEN-LAST:event_jMenuItemDelaySubroutineActionPerformed

   private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed

       new CodeWizard(this).setVisible(true);
}//GEN-LAST:event_jMenuItem20ActionPerformed

   private void jTableInterruptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInterruptMouseClicked
       int sel=jTableInterrupt.getSelectedColumn();
       switch(sel){
           case 1: matrix.SID = (matrix.SID&0x01)^1; break;
           case 2: matrix.INTR = (matrix.INTR&0x01)^1; break;
           case 3: matrix.TRAP = (matrix.TRAP&0x01)^1;  break;
           case 4: matrix.R75 = (matrix.R75&0x01)^1; break;
           case 5: matrix.R65 = (matrix.R65&0x01)^1;break;
           case 6: matrix.R55 = (matrix.R55&0x01)^1;break;
          default: break;
       }
       setResister();
   }//GEN-LAST:event_jTableInterruptMouseClicked

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        try {
                    Desktop.getDesktop().browse(new URI("http://8085simulator.codeplex.com/downloads/get/88757"));
                } catch (Exception ex) {
                    //It looks like there's a problem
                }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed
   

   public void loadLabel()
   {
            int begin=engine.Hex2Dec(jTextFieldMemBegin.getText());
            int x=0;
             for(int i=0,n=begin;jTableAssembler.getValueAt(i, 3)!=null;i++)
             {
                 if(jTableAssembler.getValueAt(i, 2)!=null)
                 {
                        matrix.label[n]=jTableAssembler.getValueAt(i, 2).toString().toUpperCase().trim();
                        jTableAssembler.setValueAt("  "+matrix.label[n],n-begin,2);
                 }
                 else  jTableAssembler.setValueAt("",n-begin,2);
                 x=engine.getBytesFromMnemonics(jTableAssembler.getValueAt(i, 3).toString());
                 n=n+x;
                 for(int j=1;j<x;j++) {i++;
                jTableAssembler.setValueAt("",i, 2);
                }
             }
   }

   

   public void disAssemble()
   {
      int begin=engine.Hex2Dec(jTextFieldMemBegin.getText());
      int index=0,n=begin;
      String temp="",value="";
      jump:
      for(int i=0,x=0;jTableAssembler.getValueAt(i, 4)!=null;begin++,i++)
      {
            jTableAssembler.setValueAt("  "+engine.Dec2Hex(begin),i,1);
            index=engine.Hex2Dec(jTableAssembler.getValueAt(i, 4).toString());
            if(index<255)temp=engine.S[index];
            else break jump;
            x=engine.getBytesFromMnemonics(temp);
            value="";
            if(engine.S[index].equalsIgnoreCase("NOP")){jTableAssembler.setValueAt("X",i,0);}
            else jTableAssembler.setValueAt("√",i,0);

            jTableAssembler.setValueAt("       "+engine.I[index][0],i,5);
            jTableAssembler.setValueAt("        "+engine.I[index][1],i,6);
            jTableAssembler.setValueAt("        "+engine.I[index][2],i,7);
            jTableAssembler.setValueAt("      "+engine.HexAutoCorrect2digit(jTableAssembler.getValueAt(i, 4).toString().toUpperCase().trim()),i,4);

            for(int j=1;j<x;j++)
            {
                            begin++;
                            i++;
                            jTableAssembler.setValueAt("  "+engine.Dec2Hex(begin),i,1);
                            try{
                            value=jTableAssembler.getValueAt(i, 4).toString().toUpperCase().trim()+value;
                            }catch(Exception e)
                            {
                                value="00"+value;
                                jTableAssembler.setValueAt("00",i,4);

                            }
                            temp=temp.substring(0, temp.length()-2*j)+value;
                            jTableAssembler.setValueAt("      "+engine.HexAutoCorrect2digit(jTableAssembler.getValueAt(i, 4).toString().toUpperCase().trim()),i,4);
            }
            jTableAssembler.setValueAt("  "+temp,i-x+1,3);
      }
      for(int i=0;jTableAssembler.getValueAt(i, 4)!=null;i++)
      {
          matrix.memory[i+n]=engine.Hex2Dec(jTableAssembler.getValueAt(i, 4).toString());
      }
      setMemory();
      jTabbedPaneAssemblerEditor.setSelectedIndex(1);
      jButtonAssemble.setVisible(false);
      jButtonDisassemble.setVisible(true);

   }

   public void setMemory()
   {
       if(jRadioButtonStoreMemoryLocation.isSelected()||jRadioButtonUsedMemoryLocation.isSelected())
       {try {
           int lower = engine.Hex2Dec(jTextFieldMemBegin.getText());
           int upper = engine.Hex2Dec(jTextFieldMemStop.getText());
           int n = (upper - lower + 1) / 16;
           if (n % 16 != 0) {
               n = n - (n % 16) + 16;
           }
           jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
                   new Object[n][17],
                   new String[]{
                       "        ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
                   }) {

               Class[] types = new Class[]{
                   java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
               };
               boolean[] canEdit = new boolean[]{
                   false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
               };

               public Class getColumnClass(int columnIndex) {
                   return types[columnIndex];
               }

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                   return canEdit[columnIndex];
               }
           });
           jTableMemory.getColumnModel().getColumn(0).setPreferredWidth(330);
       }catch(Exception e){}
       }
       int lower=engine.Hex2Dec(jTextFieldMemBegin.getText());
       int upper=engine.Hex2Dec(jTextFieldMemStop.getText());
       int n = (upper - lower+1)/16;
       String s = "";
       int l=lower;
       for (int i = 0; i < n; i++, l+=16) {
           s = engine.Dec2Hex(l);
           jTableMemory.setValueAt(s, i, 0);
           
       }
      
       for(int i=lower,row=0,col=1;i<=upper;i++,col++)
       {

           jTableMemory.setValueAt(engine.Dec2Hex2digit(matrix.memory[i]),row,col);
           if(col==16){col=0;row++;}
           
       }

       
       jRadioButtonStoreMemoryLocation.setSelected(false);
       jRadioButtonUsedMemoryLocation.setSelected(false);
       jRadioButtonShowAll.setSelected(true);
       tableState = 0;
   }

    public void setIOPort() {
        for (int i = 0,row=0,col=1; i < 256; i++, col++) {
            jTablePort.setValueAt( engine.Dec2Hex2digit(matrix.port[i]), row, col);
            if(col==16){col=0;row++;}
        }
        for (int i = 0; i < 16; i++) {
            jTablePort.setValueAt("   "+engine.Dec2Hex2digit(i*16),i,0);
        }
    }


    private void setResister() {
        String s;
        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.A), 0, 1);
        s = engine.Dec2Bin(matrix.A);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 0, i + 2);
        }

        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.B), 1, 1);
        s = engine.Dec2Bin(matrix.B);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 1, i + 2);
        }

        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.C), 2, 1);
        s = engine.Dec2Bin(matrix.C);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 2, i + 2);
        }

        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.D), 3, 1);
        s = engine.Dec2Bin(matrix.D);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 3, i + 2);
        }

        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.E), 4, 1);
        s = engine.Dec2Bin(matrix.E);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 4, i + 2);
        }

        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.H), 5, 1);
        s = engine.Dec2Bin(matrix.H);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 5, i + 2);
        }

        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.L), 6, 1);
        s = engine.Dec2Bin(matrix.L);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 6, i + 2);
        }
        if((256*matrix.H+matrix.L)<65536  ){
        jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(matrix.memory[256*matrix.H+matrix.L]), 7, 1);
        s = engine.Dec2Bin(matrix.memory[256*matrix.H+matrix.L]);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 7, i + 2);
        }}
        else{
            jTableRegister.setValueAt("       " + engine.Dec2Hex2digit(0), 7, 1);
        s = engine.Dec2Bin(0);
        for (int i = 0; i < 8; i++) {
            jTableRegister.setValueAt(s.charAt(i) + "  ", 7, i + 2);
        }

        }

        jTableFlagregister.setValueAt("       " + engine.Dec2Hex2digit(matrix.F), 0, 1);
        s = engine.Dec2Bin(matrix.F);
        for (int i = 0; i < 8; i++) {
            jTableFlagregister.setValueAt(s.charAt(i) + "  ", 0, i + 2);
        }

        jTableCounter.setValueAt("                  " + engine.Dec2Hex(matrix.SP), 0, 1);
        jTableCounter.setValueAt("                  " + engine.Dec2Hex2digit(matrix.H) + engine.Dec2Hex2digit(matrix.L), 1, 1);
        jTableCounter.setValueAt("                  " + engine.Dec2Hex2digit(matrix.A) + engine.Dec2Hex2digit(matrix.F), 2, 1);
        jTableCounter.setValueAt("                  " + engine.Dec2Hex(matrix.PC), 3, 1);
        jTableCounter.setValueAt("                  " + matrix.clockCycleCounter, 4, 1);
        jTableCounter.setValueAt("                  " + matrix.instructionCounter, 5, 1);

        int SOD;
        SOD=(matrix.SOD&matrix.SDE);
        jTableInterrupt.setValueAt("       "+SOD,0,0);
        jTableInterrupt.setValueAt("       "+matrix.SID,0,1);
        jTableInterrupt.setValueAt("       "+matrix.INTR,0,2);
        jTableInterrupt.setValueAt("       "+matrix.TRAP,0,3);
        jTableInterrupt.setValueAt("       "+matrix.R75,0,4);
        jTableInterrupt.setValueAt("       "+matrix.R65,0,5);
        jTableInterrupt.setValueAt("       "+matrix.R55,0,6);

        jTableSIM.setValueAt("    "+matrix.SOD, 0, 0);
        jTableSIM.setValueAt("    "+matrix.SDE, 0, 1);
        jTableSIM.setValueAt("    "+matrix.D1, 0, 2);
        jTableSIM.setValueAt("    "+matrix.RR75, 0, 3);
        jTableSIM.setValueAt("    "+matrix.MSE, 0, 4);
        jTableSIM.setValueAt("    "+matrix.M75, 0, 5);
        jTableSIM.setValueAt("    "+matrix.M65, 0, 6);
        jTableSIM.setValueAt("    "+matrix.M55, 0, 7);

        jTableRIM.setValueAt("    "+matrix.SID, 0, 0);
        jTableRIM.setValueAt("    "+matrix.R75, 0, 1);
        jTableRIM.setValueAt("    "+matrix.R65, 0, 2);
        jTableRIM.setValueAt("    "+matrix.R55, 0, 3);
        jTableRIM.setValueAt("    "+matrix.IE, 0, 4);
        jTableRIM.setValueAt("    "+matrix.M75, 0, 5);
        jTableRIM.setValueAt("    "+matrix.M65, 0, 6);
        jTableRIM.setValueAt("    "+matrix.M55, 0, 7);




    }

    public void set()
    {
        setIOPort();
        setMemory();
        setResister();
        ppi8255.set();
        jRadioButtonUsedMemoryLocationActionPerformed(null);

    }

    

    public void closeButtonFileSave()
    {
        closeStateCall=true;
        String s = "", line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            if (jTabbedPaneAssemblerEditor.getSelectedIndex() == 0) {
                while ((line = in.readLine()) != null) {
                    s = s + line + "\n";
                }
                if (!jTextAreaAssemblyLanguageEditor.getText().equalsIgnoreCase(s)) {

                    jMenuItemSave_Assembly_Language_codeActionPerformed(null);
                }
               else System.exit(0);

            }
                else if (jTabbedPaneAssemblerEditor.getSelectedIndex() == 1) {

                    while ((line = in.readLine()) != null) {
                        s = s + line + "\n";
                    }
                    if (!jTextAreaDisassembler.getText().equalsIgnoreCase(s)) {

                        jMenuItemSave_HexcodeActionPerformed(null);
                    }
                     else System.exit(0);

                }
            
            in.close();
        } catch (Exception e) {
            if(jTabbedPaneAssemblerEditor.getSelectedIndex() == 0)jMenuItemSave_Assembly_Language_codeActionPerformed(null);
            else jMenuItemSave_HexcodeActionPerformed(null);
            
        }
        
    }
    public void saveSettings()
    {
        String filepath=System.getProperty("user.dir")+fileSeparator+"settings.dat";
        try {
                 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filepath)));
                 out.println(jTextFieldMemBegin.getText());
                 out.println(jTextFieldMemStop.getText());
                 out.println(jTextFieldBeginFrom.getText());
                 out.println(path);
                 out.println(stopAtIndex);
                 out.close();

        } catch (Exception e) {
        }

    }

    public void loadSettings()
    {
        String filepath=System.getProperty("user.dir")+fileSeparator+"settings.dat";
        String line="";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filepath));
            if((line=in.readLine())!=null)jTextFieldMemBegin.setText(line);
            if((line=in.readLine())!=null)jTextFieldMemStop.setText(line);
            if((line=in.readLine())!=null)jTextFieldBeginFrom.setText(line);
            if((line=in.readLine())!=null)path=line;
            if((line=in.readLine())!=null)stopAtIndex=Integer.parseInt(line);
            in.close();
        }
        catch(Exception e){}
            jTextFieldMemBeginActionPerformed(null);

    }

    public static void main(String args[]) {
                                                                                                                                                            try {
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception evt) {}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Assembler a=new Assembler();
                a.setVisible(true);
                //Registration r = new Registration(a);
                //r.setVisible(!r.registered);
                //a.setEnabled(r.registered);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnalizeCW;
    private javax.swing.JButton jButtonAssemble;
    private javax.swing.JButton jButtonAutocorrect;
    public javax.swing.JButton jButtonBackward;
    public javax.swing.JButton jButtonContinue;
    private javax.swing.JButton jButtonDisassemble;
    private javax.swing.JButton jButtonForward;
    public javax.swing.JButton jButtonRun;
    private javax.swing.JButton jButtonStep;
    public javax.swing.JButton jButtonStop;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemIOPort;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemPeriphralInterface;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelComment;
    private javax.swing.JLabel jLabelError;
    public javax.swing.JLabel jLabelErrorHang;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    public javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemAutocorrect;
    private javax.swing.JMenuItem jMenuItemBackward;
    private javax.swing.JMenuItem jMenuItemClearMemory;
    private javax.swing.JMenuItem jMenuItemDelaySubroutine;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemForward;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemInterruptServiceSubroutine;
    private javax.swing.JMenuItem jMenuItemLoad_Assembly_Language_code;
    private javax.swing.JMenuItem jMenuItemLoad_Hexcode;
    private javax.swing.JMenuItem jMenuItemRecover;
    private javax.swing.JMenuItem jMenuItemRunAllAtATime;
    private javax.swing.JMenuItem jMenuItemSave_Assembly_Language_code;
    private javax.swing.JMenuItem jMenuItemSave_Hexcode;
    private javax.swing.JMenuItem jMenuItemStop;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JPanel jPanel8255;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemNormal;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemStepByStep;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemUltimate;
    private javax.swing.JRadioButton jRadioButtonShowAll;
    private javax.swing.JRadioButton jRadioButtonStoreMemoryLocation;
    private javax.swing.JRadioButton jRadioButtonUsedMemoryLocation;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPaneAssemblerEditor;
    private javax.swing.JTabbedPane jTabbedPaneEditor;
    private javax.swing.JTabbedPane jTabbedPaneInterface;
    private javax.swing.JTabbedPane jTabbedPaneLabelEditor;
    private javax.swing.JTabbedPane jTabbedPaneMemory;
    public javax.swing.JTable jTable8255;
    public javax.swing.JTable jTableAssembler;
    private javax.swing.JTable jTableCounter;
    private javax.swing.JTable jTableFlagregister;
    private javax.swing.JTable jTableInterrupt;
    private javax.swing.JTable jTableMemory;
    private javax.swing.JTable jTableNoConverter;
    public javax.swing.JTable jTablePort;
    private javax.swing.JTable jTableRIM;
    private javax.swing.JTable jTableRegister;
    private javax.swing.JTable jTableSIM;
    public javax.swing.JTextArea jTextArea8255;
    public javax.swing.JTextPane jTextAreaAssemblyLanguageEditor;
    public javax.swing.JTextArea jTextAreaDisassembler;
    private javax.swing.JTextArea jTextAreaLabel;
    public javax.swing.JTextField jTextFieldBeginFrom;
    private javax.swing.JTextField jTextFieldMemBegin;
    private javax.swing.JTextField jTextFieldMemStop;
    // End of variables declaration//GEN-END:variables

}
