package actiondefs;

import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class CommonActionFlow extends JFrame {

    JFrame f;

    public String OptionPanel() {

        f = new JFrame();
        String PhoneNumberValue = JOptionPane.showInputDialog(f, "Enter PhoneNumber");
        return PhoneNumberValue;

    }

    public void OptionPanelCompleted() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Completed");

    }

    public void radioButton() {
        f = new JFrame();
        JRadioButton r1 = new JRadioButton("A) Brodcast");
        JRadioButton r2 = new JRadioButton("B) Group");
        r1.setBounds(75, 50, 100, 30);
        r2.setBounds(75, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        f.add(r1);
        f.add(r2);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void startServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
			Thread.sleep(8000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
