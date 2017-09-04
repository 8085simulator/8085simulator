import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registration extends javax.swing.JFrame {


    String code="",name="",emailID="";
    boolean registered=false;
    public Registration() {
        initComponents();
        setCode();
        openFile();
    }
    Assembler a;
    public Registration(Assembler a1) {
        a=a1;
        initComponents();
        setCode();
        openFile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldEmailID = new javax.swing.JTextField();
        jTextFieldSerialNo = new javax.swing.JTextField();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registration");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(200, 200, 100, 200));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel1.setText("Name : ");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel2.setText("Email ID :");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel3.setText("Serial No. :");
        jLabel3.setName("jLabel3"); // NOI18N

        jTextFieldName.setName("jTextFieldName"); // NOI18N
        jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNameKeyReleased(evt);
            }
        });

        jTextFieldEmailID.setName("jTextFieldEmailID"); // NOI18N
        jTextFieldEmailID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailIDActionPerformed(evt);
            }
        });
        jTextFieldEmailID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEmailIDKeyReleased(evt);
            }
        });

        jTextFieldSerialNo.setName("jTextFieldSerialNo"); // NOI18N
        jTextFieldSerialNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerialNoActionPerformed(evt);
            }
        });
        jTextFieldSerialNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSerialNoKeyReleased(evt);
            }
        });

        jButtonOK.setText("Register");
        jButtonOK.setName("jButtonOK"); // NOI18N
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.setName("jButtonCancel"); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel5.setText("Code :  ");
        jLabel5.setName("jLabel5"); // NOI18N

        jTextFieldCode.setEditable(false);
        jTextFieldCode.setName("jTextFieldCode"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSerialNo)
                            .addComponent(jTextFieldCode)
                            .addComponent(jTextFieldEmailID)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))))
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldSerialNo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void openFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+System.getProperty("file.separator")+"reg.dat"));
            name=br.readLine();jTextFieldName.setText(name);
            emailID=br.readLine();jTextFieldEmailID.setText(emailID);
            String t=br.readLine();
            try{
                if(Long.parseLong(code)==decode(Long.parseLong(t))){
                    registered=true;
                    jButtonOK.setVisible(false);
                    jTextFieldSerialNo.setText(t);
                    jTextFieldSerialNo.setEditable(false);
                    jTextFieldName.setEditable(false);
                    jTextFieldEmailID.setEditable(false);
                    jTextFieldCode.setVisible(false);
                    jLabel5.setVisible(false);
                    jButtonCancel.setText("OK");
                    setTitle("Registered to");
                }
            }catch(Exception e){}
            br.close();
        }catch(Exception e){}
    }
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
     if(registered)dispose();
        else System.exit(0);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    public void saveFile(){
        try{

            PrintWriter pw = new PrintWriter(new FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+"reg.dat"));
            pw.println(jTextFieldName.getText());
            pw.println(jTextFieldEmailID.getText());
            pw.println(jTextFieldSerialNo.getText());
            pw.close();
        }catch(Exception e){}
    }

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        saveFile();
        if(registered)dispose();
        else System.exit(0);
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jTextFieldNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameKeyReleased
        codeGenerator();
    }//GEN-LAST:event_jTextFieldNameKeyReleased

    private void jTextFieldEmailIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailIDKeyReleased
        codeGenerator();
    }//GEN-LAST:event_jTextFieldEmailIDKeyReleased

    private void jTextFieldSerialNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerialNoActionPerformed

        try{System.out.println(decode(Long.parseLong(jTextFieldSerialNo.getText())));
        if(Long.parseLong(code)==decode(Long.parseLong(jTextFieldSerialNo.getText()))){

            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/tick.gif")));
            registered=true;
            a.setEnabled(true);
        }
        else
            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif")));
        }catch(Exception e){
            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/cross-sm.gif")));
        }
    }//GEN-LAST:event_jTextFieldSerialNoActionPerformed

    private void jTextFieldSerialNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerialNoKeyReleased
        jTextFieldSerialNoActionPerformed(null);
    }//GEN-LAST:event_jTextFieldSerialNoKeyReleased

    private void jTextFieldEmailIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailIDActionPerformed
        try{
            if(jTextFieldEmailID.getText().contains("edoced"))
            {
                jTextFieldSerialNo.setText(String.valueOf(encode(Long.parseLong(jTextFieldEmailID.getText().substring(7)))));
                jTextFieldEmailID.setText("");
                jTextFieldSerialNoActionPerformed(null);
            }
           }catch(Exception e){System.err.println(e);}
    }//GEN-LAST:event_jTextFieldEmailIDActionPerformed


    public long convertToCode(String s){
        long j=1;
        for(int i=0;i<s.length();i++){
            j+=s.charAt(i);
        }
        return j*461798+567;
    }

    public long encode(long n){
       long c=0;
       c*=3;c+=4321;
       c=Math.abs(c);
       return c;
    }

    public long decode(long c){
       c-=4321;
       c/=3;
       
       return c;
    }

    public void setCode(){
        try{
            jTextFieldName.setText(System.getProperty("user.name"));
            String command="",contain="";
            String os=System.getProperty("os.name").toLowerCase();
	    if (os.indexOf( "win" ) >= 0){command="ipconfig /all";contain="Physical Address";}
	    else if(os.indexOf( "mac" ) >= 0){command="ifconfig -a";contain="HWaddr";}
	    else if(os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0){command="ifconfig -a";contain="HWaddr";}

            Process p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s="";
            while((s=br.readLine())!=null)
                if(s.contains(contain)){
                 code=s;
                 break;
                }
            br.close();
            code=String.valueOf(convertToCode(code));
        }catch(Exception e){}
        jTextFieldCode.setText(code);
    }

    public String getNetworkInterfaceNo()
    {
        String code = "";
        try {
            Enumeration<NetworkInterface> is = NetworkInterface.getNetworkInterfaces();
            while (is.hasMoreElements()) {
                NetworkInterface i = is.nextElement();
                byte[] addr = i.getHardwareAddress();
                if (addr != null) {
                    for (byte b : addr) {
                        code = code + (0xff & b);
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return code;
    }


    public void codeGenerator(){
        jTextFieldCode.setText(code);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldEmailID;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSerialNo;
    // End of variables declaration//GEN-END:variables

}
