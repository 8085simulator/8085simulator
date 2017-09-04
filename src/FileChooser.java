import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends javax.swing.JFrame {

    public static int objectNo=0;
    public String path="";
    Assembler o;
    FileFilter fileFilter ;
    public FileChooser() {
        System.out.println(objectNo);
        objectNo++;
        if(objectNo==1)initComponents();
       jFileChooser1.setApproveButtonText("Open");
       
    }

    public FileChooser(String s,Assembler o) {
        objectNo++;
        o.setEnabled(false);
        initComponents();
        File file=new File(o.path);
        jFileChooser1.setSelectedFile(file);
        jFileChooser1.setApproveButtonText(s);
        setTitle(s);
        jFileChooser1.setApproveButtonMnemonic(s.charAt(0));
        if(s.charAt(5)=='M')
            fileFilter = new FileNameExtensionFilter("8085 Assembler Language Simulation module(.asm)", "asm");
        else if(s.charAt(5)=='H')
            fileFilter = new FileNameExtensionFilter("Hexcode(.hex)", "hex");
        jFileChooser1.setFileFilter(fileFilter);
        jFileChooser1.setFileHidingEnabled(false);
        this.o=o;
        objectNo=0;        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jFileChooser1.setName("jFileChooser1"); // NOI18N
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        o.setEnabled(true);
        if(evt.getActionCommand().equalsIgnoreCase("CancelSelection")) {
            dispose();
            if(o.closeStateCall)(new Popup(o)).terminate("Are you sure you want to exit without saving changes ? ");
        }
        if(evt.getActionCommand().equalsIgnoreCase("ApproveSelection"))
        {
            path=jFileChooser1.getSelectedFile().toString();
            o.path=path;
        o.setTitle("8085 Simulator - "+o.path);
            if(jFileChooser1.getApproveButtonText().equalsIgnoreCase("Load Mnemonics"))
            {
                String s = "", line;
                try {
                    BufferedReader in = new BufferedReader(new FileReader(path));
                    while ((line = in.readLine()) != null) {
                        s = s + line + "\n";
                    }
                    o.jTextAreaAssemblyLanguageEditor.setText(s);
                    o.textEditor.colorEditor();
                    in.close();
                } catch (Exception e) {
                                        Popup.show("Failed to load the file.");
                }
            }
            else if(jFileChooser1.getApproveButtonText().equalsIgnoreCase("Save Mnemonics"))
            {
                try {
                path=path.replace(".asm", "");
                    
                } catch (Exception e) {
                }
                  try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path+".asm")));
                      out.print(o.jTextAreaAssemblyLanguageEditor.getText());
                    out.close();
                } catch (Exception e) {
                    Popup.show("Unable to save the file.");
                }
            }
            else if(jFileChooser1.getApproveButtonText().equalsIgnoreCase("Load Hexcode"))
            {
                try {
                if (!path.contains("."))path=path+".hex";
                    
                } catch (Exception e) {
                }
                String s = "", line;
                try {
                    BufferedReader in = new BufferedReader(new FileReader(path));
                    while ((line = in.readLine()) != null) {
                        s = s + line + "\n";
                    }
                    o.jTextAreaDisassembler.setText(s);
                    in.close();
                } catch (Exception e) {
                        Popup.show("Failed to load the file.");
                }

            }
            else if(jFileChooser1.getApproveButtonText().equalsIgnoreCase("Save Hexcode"))
            {
                try {
                path=path.replace(".hex", "");
                    
                } catch (Exception e) {
                }
                 try {
                     PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path+".hex")));
                        out.print(o.disassembler.saveDisassembler());
                    out.close();
                } catch (Exception e) {
                    Popup.show("Unable to save the file.");
                }
            }
                    o.jTextAreaAssemblyLanguageEditor.select(0, 0);

            dispose();
            if(o.closeStateCall)System.exit(0);
        }
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        o.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing
      
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FileChooser f = new FileChooser();
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables

}
