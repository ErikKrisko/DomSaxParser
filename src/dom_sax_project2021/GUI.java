/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_sax_project2021;
/**
 *
 * @author jackiestewart
 */
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class GUI extends JFrame implements ActionListener {

    JRadioButton saxButton = new JRadioButton("SAX");
    JRadioButton domButton = new JRadioButton("DOM");
    JLabel  file = new JLabel("File:");
    JLabel  info = new JLabel("Info:");
    JLabel  saveAs = new JLabel("Save As:");
    JButton browse = new JButton("Browse");
    JButton parse = new JButton("Parse");
    JButton save = new JButton("Save");
    JTextField fileField = new JTextField();
    TextArea infoField = new TextArea();
    JTextField  saveField = new JTextField();

    List SlamAL;
    String fileName;

    public GUI() {
        this.setLayout(null);

        saxButton.setBounds(150, 70, 100, 25);
        domButton.setBounds(250, 70, 100, 25);
        file.setBounds(50, 130, 200, 25);
        info.setBounds(50, 210, 40, 25);
        saveAs.setBounds(30, 500, 200, 25);
        fileField.setBounds(100, 130, 220, 25);
        infoField.setBounds(100, 210, 220, 250);
        saveField.setBounds(100, 500, 220, 25);
        browse.setBounds(340, 130, 80, 25);
        parse.setBounds(430, 130, 80, 25);
        save.setBounds(340, 500, 80, 25);

        this.add(saxButton);
        this.add(domButton);
        this.add(file);
        this.add(info);
        this.add(saveAs);
        this.add(fileField);
        this.add(infoField);
        this.add(saveField);
        this.add(browse);
        this.add(parse);
        this.add(save);

        saxButton.addActionListener(this);
        domButton.addActionListener(this);
        browse.addActionListener(this);
        parse.addActionListener(this);
        save.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object target = e.getSource();
        if(target == browse )
        {
            Chooser frame = new Chooser();
            fileField.setText(frame.fileName);
            this.fileName = frame.fileName;
        }
        if(fileField.getText().equals(""))
        {
            infoField.setText("Please Browse for xml file");
        }
        if(saxButton.isSelected()) //if the SAX button is selected
        {
            if(target == parse)  //remember to re-activate the button when ready to run project
            {
                SAX s = new SAX();
                infoField.setText(s.run());
                //this.SlamAL = s.getSlamList();
            }
        }
        else if(domButton.isSelected())  //if the DOM buttons is selected
        {
            if(target == parse)  //remember to re-activate the button when ready to run project
            {
                DOM d = new DOM();
                infoField.setText(d.run());
                //this.SlamAL = d.getSlamList();    I have this incorporated in getSlam();
                
            }
        }
        
}

    public static void main(String args[]) {

        GUI frame = new GUI();
        frame.setSize(600, 600);
        frame.setLocation(200, 100);
        frame.setVisible(true);
    }
}

class Chooser extends JFrame {

    JFileChooser chooser;
    String fileName;

    public Chooser() {
        chooser = new JFileChooser();
        int r = chooser.showOpenDialog(new JFrame());
        if (r == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getPath();
        }
    }
}
