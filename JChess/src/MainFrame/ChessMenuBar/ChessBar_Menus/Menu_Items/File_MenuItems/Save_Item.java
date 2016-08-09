
package MainFrame.ChessMenuBar.ChessBar_Menus.Menu_Items.File_MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import MainFrame.ChessFrame.MainPanel;
import MainFrame.ChessFrame.players.Player1;
import MainFrame.ChessFrame.players.Player2;


public class Save_Item extends JMenuItem {
    
	private final JFileChooser chooser;
    private FileNameExtensionFilter filter;
    private Path saveFile;
    Charset charset = Charset.forName("US-ASCII");
    
    /** Creates a new instance of Save_Item */
    public Save_Item() {
    	chooser = new JFileChooser();
    	filter = new FileNameExtensionFilter("JChess files", "jchess");
    	chooser.setFileFilter(filter);
    	    	
    	setText("Save Game");
        
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = chooser.showSaveDialog(null);
                
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                	String filePath = chooser.getSelectedFile().getAbsolutePath();
                	
                	if (!filePath.endsWith(".jchess")) {
                		filePath += ".jchess";
                	}
                	saveFile = Paths.get(filePath);
                }
                
        	  	try (BufferedWriter writer = Files.newBufferedWriter(saveFile, charset, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
        	  		writer.write("" + (MainPanel.isLocal() ? 1 : 0));
        	  		writer.write("" + MainPanel.getPlayers_turn());
					writer.write(Player1.getSaveState());
					writer.write(Player2.getSaveState());
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            	
            }
        });
    }
}
