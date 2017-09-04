

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

public class About extends JFrame
{
  private JButton jButton1;
  private JLabel jLabel1;

  public About()
  {
    initComponents();
  }

  private void initComponents()
  {
    JLabel appTitleLabel = new JLabel();
    JLabel appDescLabel = new JLabel();
    JLabel versionLabel = new JLabel();
    JLabel appVersionLabel = new JLabel();
    JLabel vendorLabel = new JLabel();
    JLabel appVersionLabel1 = new JLabel();
    JLabel vendorLabel1 = new JLabel();
    JLabel appVersionLabel2 = new JLabel();
    JLabel vendorLabel2 = new JLabel();
    JLabel appVersionLabel3 = new JLabel();
    this.jButton1 = new JButton();
    this.jLabel1 = new JLabel();
    setDefaultCloseOperation(1);
    setTitle("About");
    setAlwaysOnTop(true);
    setBounds(new Rectangle(400, 250, 200, 200));
    setForeground(Color.white);
    setResizable(false);

    appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | 0x1, appTitleLabel.getFont().getSize() + 4));
    appTitleLabel.setText("8085 Simulator");

    appDescLabel.setText("Programming made easy.");

    versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | 0x1));
    versionLabel.setText("Product Version :");

    appVersionLabel.setText("2.0");

    vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | 0x1));
    vendorLabel.setText("Created by : ");

    appVersionLabel1.setText("Jubin Mitra");

    vendorLabel1.setFont(vendorLabel1.getFont().deriveFont(vendorLabel1.getFont().getStyle() | 0x1));
    vendorLabel1.setText("Contact : ");

    appVersionLabel2.setText("<html> <a href=\"\">http://8085simulatorj.blogspot.in/</a></html>");
    

    this.jButton1.setMnemonic('c');
    this.jButton1.setText("Close");
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        About.this.jButton1ActionPerformed(evt);
      }

    });
    appVersionLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://8085simulatorj.blogspot.in/"));
                } catch (Exception ex) {
                    //It looks like there's a problem
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
    this.jLabel1.setIcon(new ImageIcon(super.getClass().getResource("/create.dat")));

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(appTitleLabel).addComponent(appDescLabel, -1, 248, 32767).addGroup(layout.createSequentialGroup().addComponent(versionLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(appVersionLabel)).addGroup(layout.createSequentialGroup().addComponent(vendorLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appVersionLabel1)).addGroup(layout.createSequentialGroup().addComponent(vendorLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appVersionLabel2)))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1))).addContainerGap()));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(appTitleLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appDescLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(versionLabel).addComponent(appVersionLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(vendorLabel).addComponent(appVersionLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(vendorLabel1).addComponent(appVersionLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.jButton1).addContainerGap()).addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));

    
    pack();
  }

  
  private void jButton1ActionPerformed(ActionEvent evt) {
    dispose();
  }

  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        new About().setVisible(true);
      }
    });
  }
}