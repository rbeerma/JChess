
package MainFrame.ChessFrame.ThreadTimer;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import MainFrame.ChessFrame.MainPanel;

public class ThreadTimer extends Thread {
    private short mytime=500;
    private JLabel myScreen;
    
    /** Creates a new instance of ThreadTimer */

    public ThreadTimer(JLabel mynewScreen) {
        myScreen=mynewScreen;
        myScreen.setText(Short.toString(mytime)+" Seconds");
    }
    
    public void run() {
        
        while(true) {
            mytime-=0.1;
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            myScreen.setText(Float.toString(mytime)+" Seconds");
            if(mytime == 0) {
                MainPanel.setGameOver(true);
                JOptionPane.showConfirmDialog(null," Game Over!\n Timeout","Timeout",JOptionPane.DEFAULT_OPTION);
                stop();
                System.out.println("TimeOut");

                break;
            }
        }
    }
  
}
