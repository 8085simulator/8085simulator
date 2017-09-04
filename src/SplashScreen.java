import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {

    private int duration;

    public SplashScreen(int d) {
        setAlwaysOnTop(true);
        duration = d;
        showSplashAndExit();
    }

    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor
    public void showSplash() {

        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        //new Popup().show(SplashScreen.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        // Set the window's bounds, centering the window
        int width = 300;
        int height =50;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);

        // Build the splash screen
        JLabel label = new JLabel("Jubin's 8085 Simulator",JLabel.CENTER);
        label.setForeground(new Color(255, 215, 0,  255));
        getContentPane().setBackground(Color.BLACK);
        label.setFont(new java.awt.Font("Tahoma", 1, 21));
        JLabel copyrt = new JLabel("Loading....................................", JLabel.CENTER);
        //copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        //content.add(copyrt, BorderLayout.SOUTH);
        content.add(label, BorderLayout.NORTH);
        Color oraRed = new Color(156, 20, 220,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
        JProgressBar p=new JProgressBar();
        p.setForeground(new Color(156, 210, 220,  255));
        p.setIndeterminate(true);
        p.setVisible(true);
        content.add(p,BorderLayout.LINE_END);
        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try { Thread.sleep(duration); } catch (Exception e) {}

        setVisible(false);

    }

    public void showSplashAndExit() {

        showSplash();
        dispose();

    }

    public static void main(String[] args) {

        // Throw a nice little title page up on the screen first
        SplashScreen splash = new SplashScreen(1000);
        Assembler.main(args);
        // Normally, we'd call splash.showSplash() and get on
        // with the program. But, since this is only a test...

    }
}
