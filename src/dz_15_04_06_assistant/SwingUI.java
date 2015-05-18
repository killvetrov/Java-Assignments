package dz_15_04_06_assistant;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;
 
public class SwingUI extends JPanel implements ActionListener {
    protected static JTextField textField;
    protected JTextArea textArea;
    protected JButton buttn;
    private final static String newline = "\n";
    private static SwingUI _instance;
    private static Chat myChat;
    private static LocalUser myLU;
 
    public SwingUI() {
        super(new GridBagLayout());
 
        textField = new JTextField(100);
        textField.setFont(new Font("Consolas", Font.PLAIN, 16));
        textField.addActionListener(this);
 
        textArea = new JTextArea(25, 20);
        textArea.setLineWrap(true);
        
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        buttn = new JButton("Отправить");
        buttn.addActionListener(this);
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        
        c.weightx = 1;
        c.weighty = 0;
        
        c.gridwidth = GridBagConstraints.WEST; 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
        
        c.weightx = 0;
        c.gridwidth = GridBagConstraints.HORIZONTAL;
        add(buttn, c);

    }
    
	public void appendStringToTextArea(String s) {
    	textArea.append(s);
    	textArea.setCaretPosition(textArea.getDocument().getLength());
    }
 
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText().trim();
        if (text.length() == 0) return;
        
        
        if ( text.startsWith("/") && (text.length() >= 5) ) {
        	switch (text.substring(0, 5)) {

        	case "/quit":
        		myChat.quit();
        		textField.setEnabled(false);
        		buttn.setEnabled(false);
        		break;

        	case "/name":
        		if ( text.indexOf(" ") == 5 && (text.length() > 6) ) {
        			myChat.printfToLog("------- Пользователь %s теперь известен как %s%n", myLU.getName(), text.substring(6));
        			myLU.setName(text.substring(6));
        		}
        		break;
        		
        	case "/logp":
        		myChat.printLog();
        		break;
        	}
        } else {
        	myChat.sendMessage(myLU, text);
        }
        
//        if (textArea.getDocument().getLength() == 0)
//        	textArea.append(text);
//        else
//        	textArea.append(newline + text);
        textField.setText("");
       
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
 
 
    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Чат с искуственным интеллектом");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.add(_instance = new SwingUI());

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        textField.grabFocus();
    }
    
    public static SwingUI getInstance() {
    	return _instance;
    }
 
    public static void startChatUI(Chat c, LocalUser lu) {
    	myChat = c;
    	myLU = lu;
        try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
			    public void run() {
			        createAndShowGUI();
			    }
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
    }
}