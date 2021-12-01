import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowB extends JFrame {
    JTextField sk=new JTextField();
    JCheckBox chb=new JCheckBox("Saknis");

    JRadioButton rb1=new JRadioButton("Aktyvus");
    JRadioButton rb2=new JRadioButton("Pasyvus");

    JButton btn=new JButton("Skaiciuoti");

    ButtonGroup rbg=new ButtonGroup();

    MainWindowB(){

        Container cnt = getContentPane();
        cnt.setLayout(new BorderLayout());

        JPanel skaiciavimaiPanel=new JPanel();
        skaiciavimaiPanel.setLayout(new BorderLayout());
        skaiciavimaiPanel.setBorder(new TitledBorder("Skaiciavimai"));

        JPanel skaiciavimaiDesine=new JPanel();
        skaiciavimaiDesine.setLayout(new GridLayout(3,2));
        skaiciavimaiDesine.add(new JLabel("Skaicius"));
        skaiciavimaiDesine.add(sk);
        skaiciavimaiDesine.add(new JPanel());
        skaiciavimaiDesine.add(chb);
        skaiciavimaiDesine.add(new JPanel());
        skaiciavimaiDesine.add(btn);

        skaiciavimaiPanel.add(skaiciavimaiDesine,BorderLayout.EAST);
        cnt.add(skaiciavimaiPanel,BorderLayout.NORTH);

        JPanel apacia=new JPanel();
        apacia.setLayout(new BorderLayout());
        apacia.add(new  JLabel("Rezultatas"),BorderLayout.WEST);

        JPanel radioPanel=new JPanel();
        radioPanel.setLayout(new GridLayout(2,1));
        radioPanel.add(rb1);
        radioPanel.add(rb2);

        apacia.add(radioPanel,BorderLayout.EAST);
        cnt.add(apacia,BorderLayout.SOUTH);

        rbg.add(rb1);
        rbg.add(rb2);

        rb1.addActionListener(new RadioVeikimas());
        rb2.addActionListener(new RadioVeikimas());

    }

    class RadioVeikimas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource().equals(rb1)){
                sk.setEnabled(true);
                chb.setEnabled(true);
                btn.setEnabled(true);
            } else{
                sk.setEnabled(false);
                chb.setEnabled(false);
                btn.setEnabled(false);
            }
        }
    }
}

