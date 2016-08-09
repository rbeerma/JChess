package MainFrame.ChessMenuBar.ChessBar_Menus.Menu_Items.File_MenuItems;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import MainFrame.ChessFrame.MainFrame;
import MainFrame.ChessFrame.players.Player1;
import MainFrame.ChessFrame.players.Player2;

public class Load_Item  extends JMenuItem {
    private final JFileChooser chooser;
    private FileNameExtensionFilter filter;
    private Path openFile;
        
    /** Creates a new instance of Load_Item */
    public Load_Item(final MainFrame ff) {
    	MainFrame mynewFrame = ff;
    	chooser = new JFileChooser();
    	filter = new FileNameExtensionFilter("JChess files", "jchess");
    	chooser.setFileFilter(filter);
    	
        setText("Load Game");
        
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int returnVal = chooser.showOpenDialog(null);
            	
            	if (returnVal == JFileChooser.APPROVE_OPTION) {
            		 String filePath = chooser.getSelectedFile().getAbsolutePath();
            		 
            		if (!filePath.endsWith(".jchess")) {
            			System.out.println("Not a JChess file!");
            		}
            		
            		openFile = Paths.get(filePath);
            	}
                
            	try (BufferedReader reader = Files.newBufferedReader(openFile)) {
            		Player1 player1 = new Player1();
            		Player2 player2 = new Player2();
            		int[] state = new int[66];
            		String stateString = reader.readLine();
            		
            		for(int i=0; i<stateString.length(); i++) {
            			state[i] = Integer.parseInt(String.valueOf(stateString.charAt(i)));
            		}
            		
            		player1.WC1.setX(state[2]);
            		player1.WC1.setY(state[3]);
            		player1.WC2.setX(state[4]);
            		player1.WC2.setY(state[5]);
            		player1.WH1.setX(state[6]);
            		player1.WH1.setY(state[7]);
            		player1.WH2.setX(state[8]);
            		player1.WH2.setY(state[9]);
            		player1.WE1.setX(state[10]);
            		player1.WE1.setY(state[11]);
            		player1.WE2.setX(state[12]);
            		player1.WE2.setY(state[13]);
            		player1.WQ.setX(state[14]);
            		player1.WQ.setY(state[15]);
            		player1.WK.setX(state[16]);
            		player1.WK.setY(state[17]);
            		player1.WS[0].setX(state[18]);
            		player1.WS[0].setY(state[19]);
            		player1.WS[1].setX(state[20]);
            		player1.WS[1].setY(state[21]);
            		player1.WS[2].setX(state[22]);
            		player1.WS[2].setY(state[23]);
            		player1.WS[3].setX(state[24]);
            		player1.WS[3].setY(state[25]);
            		player1.WS[4].setX(state[26]);
            		player1.WS[4].setY(state[27]);
            		player1.WS[5].setX(state[28]);
            		player1.WS[5].setY(state[29]);
            		player1.WS[6].setX(state[30]);
            		player1.WS[6].setY(state[31]);
            		player1.WS[7].setX(state[32]);
            		player1.WS[7].setY(state[33]);
            		
            		player2.BC1.setX(state[34]);
            		player2.BC1.setY(state[35]);
            		player2.BC2.setX(state[36]);
            		player2.BC2.setY(state[37]);
            		player2.BH1.setX(state[38]);
            		player2.BH1.setY(state[39]);
            		player2.BH2.setX(state[40]);
            		player2.BH2.setY(state[41]);
            		player2.BE1.setX(state[42]);
            		player2.BE1.setY(state[43]);
            		player2.BE2.setX(state[44]);
            		player2.BE2.setY(state[45]);
            		player2.BQ.setX(state[46]);
            		player2.BQ.setY(state[47]);
            		player2.BK.setX(state[48]);
            		player2.BK.setY(state[49]);
            		player2.BS[0].setX(state[50]);
            		player2.BS[0].setY(state[51]);
            		player2.BS[1].setX(state[52]);
            		player2.BS[1].setY(state[53]);
            		player2.BS[2].setX(state[54]);
            		player2.BS[2].setY(state[55]);
            		player2.BS[3].setX(state[56]);
            		player2.BS[3].setY(state[57]);
            		player2.BS[4].setX(state[58]);
            		player2.BS[4].setY(state[59]);
            		player2.BS[5].setX(state[60]);
            		player2.BS[5].setY(state[61]);
            		player2.BS[6].setX(state[62]);
            		player2.BS[6].setY(state[63]);
            		player2.BS[7].setX(state[64]);
            		player2.BS[7].setY(state[65]);
            		
            		mynewFrame.startLoadedGame(player1, player2, state[0], state[1]);

            	} catch (IOException e1) {
					e1.printStackTrace();
				}
            }

        });
        
    }
    
}
