public class CodeWizard extends javax.swing.JFrame {

    public CodeWizard() {
        initComponents();
        hideNseek(0, 0, 0, 0);
    }

    Assembler o;
    public CodeWizard(Assembler o) {
        this.o=o;
        initComponents();
        hideNseek(0, 0, 0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new ZebraJTree();
        jComboBoxRegister1 = new javax.swing.JComboBox();
        jComboBoxRegPair = new javax.swing.JComboBox();
        jTextFieldData = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jComboBoxDataType = new javax.swing.JComboBox();
        jComboBoxRegister2 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCode = new javax.swing.JTextArea();
        jButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButtonUndo = new javax.swing.JButton();
        jButtonRedo = new javax.swing.JButton();
        jButtonCopy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Code Wizard");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTree.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        jTree.setFont(new java.awt.Font("Arial", 1, 11));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Code Classification");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Data Transfer Operation");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Load Data");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Register         ←   Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator  ←   Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator  ←   Data (from memory address directly)");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator  ←   Data (from memory address pointed by Reg Pair H-L)");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator  ←   Data (from memory address pointed by Reg. Pair)");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Register Pair ←   Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Reg. pair H-L  ←   Data (from memory address directly)");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Stack Pointer (SP)  ←  Reg. pair H-L");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Program Counter (PC)  ←   Reg. pair H-L");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Store Data");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator(Data)  → Memory (at address specified directly)");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator(Data)  → Memory (at address pointed by Reg Pair H-L)");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator(Data)  → Memory (at address pointed by Reg. Pair)");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Reg. pair H-L(Data) → Memory (at address specified directly)");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Move Data");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Register ←  Register");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Stack");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Push");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Pop");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Exchange");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("H-L   ←→  D-E");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("H-L   ←→  Stack Top Pointer");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Arithmetic Operation");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Addition");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator + Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator + Carry + Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator + Register");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator + Carry + Register");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Register Pair(H-L) = Register Pair(H-L) + Register Pair");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Subtraction");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator - Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator - Borrow/Carry - Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator - Register");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator - Borrow/Carry - Register");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Increment");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Increment Register");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Increment Register Pair");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Decrement");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Decrement Register");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Decrement Register Pair");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Binary to BCD");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Decimal Adjust Accumulator");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Logical Operation");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("And");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator & Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator & Register");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Or");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator | Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator | Register");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Xor");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator ^ Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator = Accumulator ^ Register");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Rotate");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Rotate Accumulator Left with carry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Rotate Accumulator Left without carry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Rotate Accumulator Right with carry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Rotate Accumulator Right without carry");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Compare");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator -  Data");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator -  Register");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Complement");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Complement Accumulator");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Complement Carry");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Carry");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Set Carry [C=1]");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Complement Carry");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Branching Operation");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Jump to a location");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on Positive");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on Negative");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on Zero");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on not Zero");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on Parity Even");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on Parity Odd");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on Carry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Jump on no Carry");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Call a subroutine");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on Positive");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on Negative");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on Zero");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on not Zero");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on Parity Even");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on Parity Odd");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on Carry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Call on no Carry");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Return from a subroutine");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on Positive");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on Negative");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on Zero");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on not Zero");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on Parity Even");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on Parity Odd");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on Carry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Return on no Carry");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Restart(One line call instruction)");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0000");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0008");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0010");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0018");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0020");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0028");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0030");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Restart from memory loaction 0038");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Change Program Counter");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Program Counter (PC)  ←   Reg. pair H-L");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Change Stack Pointer");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Stack Pointer (SP)  ←  Reg. pair H-L");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("H-L   ←→  Stack Top Pointer");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("I/O Operation");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator  ←  Input data");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Accumulator   → Output data");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Interrupt Operation");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Halt Operation");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Enable Interrupt");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Disable Interrupt");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Read Interrupt Mask");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Set Interrupt Mask");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("No Operation");
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.setName("jTree"); // NOI18N
        jTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeMouseClicked(evt);
            }
        });
        jTree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTreeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        jComboBoxRegister1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accumulator", "Register B", "Register C", "Register D", "Register E", "Register H", "Register L", "Memory(M)" }));
        jComboBoxRegister1.setName("jComboBoxRegister1"); // NOI18N
        jComboBoxRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRegister1ActionPerformed(evt);
            }
        });

        jComboBoxRegPair.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Register Pair B - C", "Register Pair D - E", "Register Pair H - L", "Stack Pointer" }));
        jComboBoxRegPair.setName("jComboBoxRegPair"); // NOI18N
        jComboBoxRegPair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRegPairActionPerformed(evt);
            }
        });

        jTextFieldData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldData.setFocusCycleRoot(true);
        jTextFieldData.setName("jTextFieldData"); // NOI18N
        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });
        jTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDataKeyReleased(evt);
            }
        });

        jLabelData.setText("Data : ");
        jLabelData.setName("jLabelData"); // NOI18N

        jComboBoxDataType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Binary", "Decimal", "Hexadecimal", "ASCII" }));
        jComboBoxDataType.setSelectedIndex(2);
        jComboBoxDataType.setName("jComboBoxDataType"); // NOI18N
        jComboBoxDataType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDataTypeActionPerformed(evt);
            }
        });

        jComboBoxRegister2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accumulator", "Register B", "Register C", "Register D", "Register E", "Register H", "Register L", "Memory(M)" }));
        jComboBoxRegister2.setName("jComboBoxRegister2"); // NOI18N
        jComboBoxRegister2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRegister2ActionPerformed(evt);
            }
        });

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextAreaCode.setBackground(new java.awt.Color(255, 255, 204));
        jTextAreaCode.setColumns(6);
        jTextAreaCode.setFont(new java.awt.Font("Monospaced", 1, 13));
        jTextAreaCode.setRows(5);
        jTextAreaCode.setName("jTextAreaCode"); // NOI18N
        jTextAreaCode.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextAreaCodeCaretUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaCode);

        jButton.setText("OK");
        jButton.setName("jButton"); // NOI18N
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(153, 0, 204));
        jLabel1.setText("         Rough Work");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(153, 102, 0));
        jLabel2.setText("Code Guide ");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("N.B: Copy Rough work to the main workspace.");
        jLabel3.setName("jLabel3"); // NOI18N

        jCheckBox1.setText("Append");
        jCheckBox1.setName("jCheckBox1"); // NOI18N

        jButtonUndo.setText("Undo");
        jButtonUndo.setName("jButtonUndo"); // NOI18N
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });

        jButtonRedo.setText("Redo");
        jButtonRedo.setName("jButtonRedo"); // NOI18N
        jButtonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedoActionPerformed(evt);
            }
        });

        jButtonCopy.setText("Copy");
        jButtonCopy.setName("jButtonCopy"); // NOI18N
        jButtonCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBoxDataType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jComboBoxRegister1, 0, 92, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxRegister2, 0, 114, Short.MAX_VALUE)
                                .addGap(4, 4, 4)
                                .addComponent(jComboBoxRegPair, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonUndo)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRedo)
                            .addComponent(jButtonCopy)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel2)
                .addGap(369, 369, 369))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(456, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDataType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRegister2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRegPair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButtonCopy))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUndo)
                            .addComponent(jButtonRedo)
                            .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String initial="";

    private void jTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeMouseClicked

        try{
            String s=jTree.getAnchorSelectionPath().getLastPathComponent().toString();
            initial=jTextAreaCode.getText();
            decodeFunction(s);
        }
        catch(Exception e){}
    }//GEN-LAST:event_jTreeMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        jButtonCopyActionPerformed(null);

    }//GEN-LAST:event_formWindowClosing

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        jButtonCopyActionPerformed(null);
        dispose();
    }//GEN-LAST:event_jButtonActionPerformed

    private void jComboBoxRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRegister1ActionPerformed

        jTextAreaCode.setText(initial);
        jTreeMouseClicked(null);
    }//GEN-LAST:event_jComboBoxRegister1ActionPerformed

    private void jComboBoxRegister2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRegister2ActionPerformed
   jTextAreaCode.setText(initial);
        jTreeMouseClicked(null);
    }//GEN-LAST:event_jComboBoxRegister2ActionPerformed

    private void jComboBoxRegPairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRegPairActionPerformed
   jTextAreaCode.setText(initial);
        jTreeMouseClicked(null);
    }//GEN-LAST:event_jComboBoxRegPairActionPerformed

    private void jTextFieldDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataKeyReleased

        jTextFieldDataActionPerformed(null);
    }//GEN-LAST:event_jTextFieldDataKeyReleased

    private void jComboBoxDataTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDataTypeActionPerformed
        jTextAreaCode.setText(initial);
        jTreeMouseClicked(null);
    }//GEN-LAST:event_jComboBoxDataTypeActionPerformed

    private void jTreeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTreeKeyReleased

        jTreeMouseClicked(null);
    }//GEN-LAST:event_jTreeKeyReleased

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        jTextAreaCode.setText(initial);
        jTreeMouseClicked(null);
        jTextFieldData.transferFocusDownCycle();
}//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed

        undo--;
        if(undo>0)jTextAreaCode.setText(array[undo]);
    }//GEN-LAST:event_jButtonUndoActionPerformed

    private void jButtonCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopyActionPerformed

        jTextAreaCode.selectAll();
        jTextAreaCode.copy();
    }//GEN-LAST:event_jButtonCopyActionPerformed

    String array[]=new String[100];
    int undo=0;
    private void jTextAreaCodeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextAreaCodeCaretUpdate

    }//GEN-LAST:event_jTextAreaCodeCaretUpdate

    private void jButtonRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedoActionPerformed
    undo++;
        if(undo<array.length)jTextAreaCode.setText(array[undo]);

    }//GEN-LAST:event_jButtonRedoActionPerformed

    /**
     * 
     * @param a Register1
     * @param b Register2
     * @param c Register pair
     * @param d Data
     */
    public void hideNseek(int a,int b, int c, int d)
    {
        jComboBoxRegister1.setVisible(false);
        jComboBoxRegister2.setVisible(false);
        jComboBoxRegPair.setVisible(false);
        jLabelData.setVisible(false);
        jTextFieldData.setVisible(false);
        jComboBoxDataType.setVisible(false);

        if(a==1)        jComboBoxRegister1.setVisible(true);
        if(b==1)        jComboBoxRegister2.setVisible(true);
        if(c==1)        jComboBoxRegPair.setVisible(true);
        if(d==1){
        jLabelData.setVisible(true);
        jTextFieldData.setVisible(true);
        jComboBoxDataType.setVisible(true);

        }
    }

    public String reg1()
    {
        int n=jComboBoxRegister1.getSelectedIndex();
        String s[]={"A","B","C","D","E","H","L","M"};
        return s[n];
    }

    public String reg2()
    {
        int n=jComboBoxRegister2.getSelectedIndex();
        String s[]={"A","B","C","D","E","H","L","M"};
        return s[n];
    }

    public String regPair()
    {
        int n=jComboBoxRegPair.getSelectedIndex();
        String s[]={"B","D","H","SP"};
        return s[n];
    }

    public String data4digit()
    {
        int n=jComboBoxDataType.getSelectedIndex(),no=0;
        String s=jTextFieldData.getText();
        try{no=Integer.parseInt(s);}catch(Exception e){}
        if(n==0){s = o.engine.Bin2Hex(s);jTextFieldData.setText(o.engine.Hex2Bin(s));}
        else if(n==1){s=o.engine.Dec2Hex(no);jTextFieldData.setText(String.valueOf(o.engine.Hex2Dec(s)));}
        else if(n==3){s=o.engine.Ascii2Hex(s);jTextFieldData.setText(o.engine.Hex2Ascii(s));}
        else if(n==2){jTextFieldData.setText(o.engine.HexAutoCorrect4digit(s));}
        return o.engine.HexAutoCorrect4digit(s);
    }

    public String data2digit()
    {
        int n=jComboBoxDataType.getSelectedIndex(),no=0;
        String s=jTextFieldData.getText();
        try{no=Integer.parseInt(s);}catch(Exception e){}
        if(n==0){s = o.engine.Bin2Hex(s);jTextFieldData.setText(o.engine.Hex2Bin(s));}
        else if(n==1){s=o.engine.Dec2Hex(no);jTextFieldData.setText(String.valueOf(o.engine.Hex2Dec(s)));}
        else if(n==3){s=o.engine.HexAutoCorrect2digit(o.engine.Ascii2Hex(s));jTextFieldData.setText(o.engine.Hex2Ascii(s));}
        else if(n==2){jTextFieldData.setText(o.engine.HexAutoCorrect2digit(s));}
        return o.engine.HexAutoCorrect2digit(s);
    }

    public void append(String t)
    {
        if(jCheckBox1.isSelected())jTextAreaCode.append("\n"+t);
        else jTextAreaCode.setText(t);
            if(undo<array.length)array[undo]=jTextAreaCode.getText();
            undo++;
    }

    public String funcDataTransfer(String s)
    {
        String t="";

        if (s.equals("Register         ←   Data")) {t="MVI "+reg1()+","+data2digit();hideNseek(1, 0, 0, 1);
        }
        else if (s.equals("Accumulator  ←   Data")) {
            t="MVI A,"+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator  ←   Data (from memory address directly)")) {
            t="LDA "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator  ←   Data (from memory address pointed by Reg Pair H-L)")) {
            t="MOV A,M";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Accumulator  ←   Data (from memory address pointed by Reg. Pair)")) {
            t="LDAX "+regPair();hideNseek(0, 0, 1, 0);

        }
        else if (s.equals("Register Pair ←   Data")) {
            t="LXI "+regPair()+","+data4digit();hideNseek(0, 0, 1, 1);
        }
        else if (s.equals("Reg. pair H-L  ←   Data (from memory address directly)")) {
            t="LHLD "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if(s.equals("Stack Pointer (SP)  ←  Reg. pair H-L")){
            t="SPHL";hideNseek(0, 0, 0, 0);
        }
        else if(s.equals("Program Counter (PC)  ←   Reg. pair H-L")){
            t="PCHL";hideNseek(0, 0, 0, 0);
        }
        else if(s.equals("Accumulator(Data)  → Memory (at address specified directly)")){
            t="STA "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if(s.equals("Accumulator(Data)  → Memory (at address pointed by Reg Pair H-L)")){
            t="MOV M,A";
        }
        else if(s.equals("Accumulator(Data)  → Memory (at address pointed by Reg. Pair)")){
            t="STAX "+regPair();hideNseek(0, 0, 1, 0);
        }
        else if(s.equals("Reg. pair H-L(Data) → Memory (at address specified directly)")){
            t="SHLD "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Register ←  Register")) {
            t="MOV "+reg1()+","+reg2();hideNseek(1, 1, 0, 0);
        }
        else if (s.equals("Push")) {
            t="PUSH "+regPair();hideNseek(0, 0, 1, 0);
        }
        else if (s.equals("Pop")) {
            t="POP "+regPair();hideNseek(0, 0, 1, 0);
        }
        else if (s.equals("H-L   ←→  D-E")) {
            t="XCHG";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("H-L   ←→  Stack Top Pointer")) {
            t="XTHL";hideNseek(0, 0, 0, 0);
        }

        return t;
    }

    public String funcArithmetic(String s)
    {
        String t="";
        if (s.equals("Accumulator = Accumulator + Data")) {
            t="ADI "+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator = Accumulator + Carry + Data")) {
            t="ACI "+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator = Accumulator + Register")) {
            t="ADD "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Accumulator = Accumulator + Carry + Register")) {
            t="ADC "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Register Pair(H-L) = Register Pair(H-L) + Register Pair")) {
            t="DAD "+regPair();hideNseek(0, 0, 1, 0);
        }
        else if (s.equals("Accumulator = Accumulator - Data")) {
            t="SUI "+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator = Accumulator - Borrow/Carry - Data")) {
            t="SBI "+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator = Accumulator - Register")) {
            t="SUB "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Accumulator = Accumulator - Borrow/Carry - Register")) {
            t="SBB "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Increment Register")) {
            t="INR "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Increment Register Pair")) {
            t="INX "+regPair();hideNseek(0, 0, 1, 0);
        }
        else if (s.equals("Decrement Register")) {
            t="DCR "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Decrement Register Pair")) {
            t="DCX "+regPair();hideNseek(0, 0, 1, 0);
        }
        else if (s.equals("Decimal Adjust Accumulator")) {
            t="DAA";
        }

        return t;
    }

    public String funcLogic(String s)
    {
        String t="";
        if (s.equals("Accumulator = Accumulator & Data")) {
            t="ANI "+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator = Accumulator & Register")) {
            t="ANA "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Accumulator = Accumulator | Data")) {
            t="ORI "+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator = Accumulator | Register")) {
            t="ORA "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Accumulator = Accumulator ^ Data")) {
            t="XRI "+data2digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Accumulator = Accumulator ^ Register")) {
            t="XRA "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Rotate Accumulator Left with carry")) {
            t="RAR";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Rotate Accumulator Left without carry")) {
            t="RRC";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Rotate Accumulator Right with carry")) {
            t="RAL";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Rotate Accumulator Right without carry")) {
            t="RLC";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Rotate Accumulator Right without carry")) {
        }
        else if (s.equals("Accumulator -  Data")) {
            t="CPI "+data2digit();hideNseek(0, 0, 0, 1);                                                        
        }
        else if (s.equals("Accumulator -  Register")) {
            t="CMP "+reg1();hideNseek(1, 0, 0, 0);
        }
        else if (s.equals("Complement Accumulator")) {
            t="CMA";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Complement Carry")) {
            t="CMC";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Set Carry [C=1]")) {
            t="STC";hideNseek(0, 0, 0, 0);
        }


        return t;
    }

    public String funcBranching(String s)
    {
        String t="";
        if (s.equals("Jump")) {
            t="JMP "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on Positive")) {
            t="JP "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on Negative")) {
            t="JM "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on Zero")) {
            t="JZ "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on not Zero")) {
            t="JNZ "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on Parity Even")) {
            t="JPE "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on Parity Odd")) {
            t="JPO "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on Carry")) {
            t="JC "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Jump on no Carry")) {
            t="JNC "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call")) {
            t="CALL "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on Positive")) {
            t="CP "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on Negative")) {
            t="CM "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on Zero")) {
            t="CZ "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on not Zero")) {
            t="CNZ "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on Parity Even")) {
            t="CPE "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on Parity Odd")) {
            t="CPO "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on Carry")) {
            t="CC "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Call on no Carry")) {
            t="CNC "+data4digit();hideNseek(0, 0, 0, 1);
        }
        else if (s.equals("Return")) {
            t="RET";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Return on Positive")) {
            t="RP";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Return on Negative")) {
            t="RM";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Return on Zero")) {
            t="RZ";hideNseek(0, 0, 0, 0);
       }
        else if (s.equals("Return on not Zero")) {
            t="RNZ";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Return on Parity Even")) {
            t="RPE";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Return on Parity Odd")) {
            t="RPO";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Return on Carry")) {
            t="RC";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Return on no Carry")) {
            t="RNC";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0000")) {
            t="RST 0";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0008")) {
            t="RST 1";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0010")) {
            t="RST 2";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0018")) {
            t="RST 3";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0020")) {
            t="RST 4";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0028")) {
            t="RST 5";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0030")) {
            t="RST 6";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Restart from memory loaction 0038")) {
            t="RST 7";hideNseek(0, 0, 0, 0);
        }
        return t;
    }

    public String funcIO(String s){
        String t="";
        if (s.equals("Accumulator  ←  Input data")) {
          t="IN "+data2digit();hideNseek(0, 0, 0, 1);

        }
        else if (s.equals("Accumulator   → Output data")) {
            t="OUT "+data2digit();hideNseek(0, 0, 0, 1);
        }

        return t;
    }

    public String funcInterrupt(String s){
        String t="";
        if (s.equals("Halt Operation")) {
            t="HLT";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Enable Interrupt")) {
            t="EI";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Disable Interrupt")) {
            t="DI";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Read Interrupt Mask")) {
            t="RIM";hideNseek(0, 0, 0, 0);
        }
        else if (s.equals("Set Interrupt Mask")) {
            t="SIM";hideNseek(0, 0, 0, 0);
        }
        return t;
    }

    public String funcNOP(String s){
        String t="";
        if(s.equals("No Operation")){
            t="NOP";hideNseek(0, 0, 0, 0);
        }
        return t;
    }


    public void decodeFunction(String s){
        String t="";
        t=funcDataTransfer(s);
        if(t.equals(""))t=funcArithmetic(s);
        if(t.equals(""))t=funcLogic(s);
        if(t.equals(""))t=funcBranching(s);
        if(t.equals(""))t=funcIO(s);
        if(t.equals(""))t=funcInterrupt(s);
        if(t.equals(""))t=funcNOP(s);
        if(!t.equals(""))append(t);
    }

     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodeWizard(new Assembler()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButtonCopy;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBoxDataType;
    private javax.swing.JComboBox jComboBoxRegPair;
    private javax.swing.JComboBox jComboBoxRegister1;
    private javax.swing.JComboBox jComboBoxRegister2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaCode;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables

}

/**
 * A JTree that draws a zebra-striped background.
 */
class ZebraJTree extends javax.swing.JTree
{
    public java.awt.Color rowColors[] = new java.awt.Color[2];
    private boolean drawStripes = false;

    public ZebraJTree( )
    {
    }
    public ZebraJTree( java.util.Hashtable<?,?> value )
    {
        super( value );
    }
    public ZebraJTree( Object[] value )
    {
        super( value );
    }
    public ZebraJTree( javax.swing.tree.TreeModel newModel )
    {
        super( newModel );
    }
    public ZebraJTree( javax.swing.tree.TreeNode root )
    {
        super( root );
    }
    public ZebraJTree( javax.swing.tree.TreeNode root,
        boolean asksAllowsChildren )
    {
        super( root, asksAllowsChildren );
    }
    public ZebraJTree( java.util.Vector<?> value )
    {
        super( value );
    }

    /** Add zebra stripes to the background. */
    public void paintComponent( java.awt.Graphics g )
    {
        if ( !(drawStripes = isOpaque( )) )
        {
            super.paintComponent( g );
            return;
        }

        // Paint zebra background stripes
        updateZebraColors( );
        final java.awt.Insets insets = getInsets( );
        final int w   = getWidth( )  - insets.left - insets.right;
        final int h   = getHeight( ) - insets.top  - insets.bottom;
        final int x   = insets.left;
        int y         = insets.top;
        int nRows     = 0;
        int startRow  = 0;
        int rowHeight = getRowHeight( );
        if ( rowHeight > 0 )
            nRows = h / rowHeight;
        else
        {
            // Paint non-uniform height rows first
            final int nItems = getRowCount( );
            rowHeight = 17; // A default for empty trees
            for ( int i = 0; i < nItems; i++, y+=rowHeight )
            {
                rowHeight = getRowBounds( i ).height;
                g.setColor( rowColors[i&1] );
                g.fillRect( x, y, w, rowHeight );
            }
            // Use last row height for remainder of tree area
            nRows    = nItems + (insets.top + h - y) / rowHeight;
            startRow = nItems;
        }
        for ( int i = startRow; i < nRows; i++, y+=rowHeight )
        {
            g.setColor( rowColors[i&1] );
            g.fillRect( x, y, w, rowHeight );
        }
        final int remainder = insets.top + h - y;
        if ( remainder > 0 )
        {
            g.setColor( rowColors[nRows&1] );
            g.fillRect( x, y, w, remainder );
        }

        // Paint component
        setOpaque( false );
        super.paintComponent( g );
        setOpaque( true );
    }

    /** Wrap cell renderer and editor to add zebra background stripes. */
    private class RendererEditorWrapper
        implements javax.swing.tree.TreeCellRenderer,
        javax.swing.tree.TreeCellEditor
    {
        public javax.swing.tree.TreeCellRenderer ren = null;
        public javax.swing.tree.TreeCellEditor   ed  = null;

        public java.awt.Component getTreeCellRendererComponent(
            javax.swing.JTree tree, Object value,
            boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus )
        {
            final java.awt.Component c =
                ren.getTreeCellRendererComponent(
                tree, value, selected, expanded,
                leaf, row, hasFocus );
            if ( selected || !drawStripes )
                return c;
            if ( !(c instanceof javax.swing.tree.DefaultTreeCellRenderer) )
                c.setBackground( rowColors[row&1] );
            else
                ((javax.swing.tree.DefaultTreeCellRenderer)c).
                setBackgroundNonSelectionColor( rowColors[row&1] );
            return c;
        }

        public java.awt.Component getTreeCellEditorComponent(
            javax.swing.JTree tree, Object value,
            boolean selected, boolean expanded,
            boolean leaf, int row )
        {
            final java.awt.Component c =
                ed.getTreeCellEditorComponent(
                tree, value, selected, expanded, leaf, row );
            if ( !selected && drawStripes )
                c.setBackground( rowColors[row&1] );
            return c;
        }

        public void addCellEditorListener(
            javax.swing.event.CellEditorListener l )
        {
            ed.addCellEditorListener( l );
        }
        public void cancelCellEditing( )
        {
            ed.cancelCellEditing( );
        }
        public Object getCellEditorValue( )
        {
            return ed.getCellEditorValue( );
        }
        public boolean isCellEditable(
            java.util.EventObject anEvent )
        {
            return ed.isCellEditable( anEvent );
        }
        public void removeCellEditorListener(
            javax.swing.event.CellEditorListener l )
        {
            ed.removeCellEditorListener( l );
        }
        public boolean shouldSelectCell(
            java.util.EventObject anEvent )
        {
            return ed.shouldSelectCell( anEvent );
        }
        public boolean stopCellEditing( )
        {
            return ed.stopCellEditing( );
        }
    }
    private RendererEditorWrapper wrapper = null;

    /** Return the wrapped cell renderer. */
    public javax.swing.tree.TreeCellRenderer getCellRenderer( )
    {
        final javax.swing.tree.TreeCellRenderer ren = super.getCellRenderer( );
        if ( ren == null )
            return null;
        if ( wrapper == null )
            wrapper = new RendererEditorWrapper( );
        wrapper.ren = ren;
        return wrapper;
    }

    /** Return the wrapped cell editor. */
    public javax.swing.tree.TreeCellEditor getCellEditor( )
    {
        final javax.swing.tree.TreeCellEditor ed = super.getCellEditor( );
        if ( ed == null )
            return null;
        if ( wrapper == null )
            wrapper = new RendererEditorWrapper( );
        wrapper.ed = ed;
        return wrapper;
    }

    /** Compute zebra background stripe colors. */
    private void updateZebraColors( )
    {
        if ( (rowColors[0] = getBackground( )) == null )
        {
            rowColors[0] = rowColors[1] = java.awt.Color.white;
            return;
        }
        java.awt.Color sel = javax.swing.UIManager.getColor(
            "Tree.selectionBackground" );
        if ( sel == null )
            sel = java.awt.SystemColor.textHighlight;
        if ( sel == null )
        {
            rowColors[1] = rowColors[0];
            return;
        }
        final float[] bgHSB = java.awt.Color.RGBtoHSB(
            rowColors[0].getRed( ), rowColors[0].getGreen( ),
            rowColors[0].getBlue( ), null );
        final float[] selHSB  = java.awt.Color.RGBtoHSB(
            sel.getRed( ), sel.getGreen( ), sel.getBlue( ), null );
        rowColors[1] = java.awt.Color.getHSBColor(
            (selHSB[1]==0.0||selHSB[2]==0.0) ? bgHSB[0] : selHSB[0],
            0.1f * selHSB[1] + 0.9f * bgHSB[1],
            bgHSB[2] + ((bgHSB[2]<0.5f) ? 0.05f : -0.05f) );
    }
}