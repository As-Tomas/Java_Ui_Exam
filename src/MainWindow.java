import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.Parser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    int sk1 = 20;
    int sk2 = 10;

    JButton btnRodyti;
    JTable lentele;
    DefaultTableModel lentelesModelis;
    JTextField skaicius1TxF;
    JTextField skaicius2TxF;

    MainWindow(){

        Container cnt = getContentPane();
        cnt.setLayout(new BorderLayout());

        JPanel mainLaiout = new JPanel();
        mainLaiout.setLayout(new GridLayout(2,1));

        String stulpeliuPav[] ={"Skaicius", "Kvadratas"};
        Object duomenys[][] = new Object[0][0];
        lentelesModelis = new DefaultTableModel(duomenys, stulpeliuPav);
        lentele = new JTable(lentelesModelis);

        mainLaiout.add(new JScrollPane(lentele));

        ///dideleApacia
        JPanel dideleApacia = new JPanel();
        dideleApacia.setLayout(new BorderLayout());

        //apaciaKaire
        JPanel apaciaKaire = new JPanel();
        apaciaKaire.setLayout(new BorderLayout());

        //apaciaDesine
        JPanel apaciaDesine = new JPanel();
        apaciaDesine.setLayout(new BorderLayout());

        //objektai
        JLabel skaiciai = new JLabel("Skaiciai");
        JLabel skaicius1Leib = new JLabel("Skaicius 1");
        JLabel skaicius2Leib = new JLabel("Skaicius 2");
        skaicius1TxF = new JTextField(sk1+"");
        skaicius2TxF = new JTextField(sk2+"");
        btnRodyti = new JButton("Rodyti");

        //sukrauname
        JPanel skaiciuObjektai = new JPanel();
        skaiciuObjektai.setLayout(new GridLayout(2,2,10,10));
        skaiciuObjektai.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skaiciuObjektai.setBorder(new TitledBorder("Skaiciai"));
        skaiciuObjektai.add(skaicius1Leib);
        skaiciuObjektai.add(skaicius1TxF);
        skaiciuObjektai.add(skaicius2Leib);
        skaiciuObjektai.add(skaicius2TxF);

        apaciaKaire.add(skaiciai, BorderLayout.WEST);
        apaciaKaire.add(skaiciuObjektai, BorderLayout.SOUTH);

        apaciaDesine.add(btnRodyti,BorderLayout.SOUTH);

        dideleApacia.add(apaciaKaire, BorderLayout.WEST);
        dideleApacia.add(apaciaDesine, BorderLayout.EAST);

        mainLaiout.add(dideleApacia);

        cnt.add(mainLaiout,BorderLayout.CENTER);
        cnt.add(new JPanel(), BorderLayout.EAST);
        cnt.add(new JPanel(), BorderLayout.WEST);
        cnt.add(new JPanel(), BorderLayout.NORTH);
        cnt.add(new JPanel(), BorderLayout.SOUTH);

        BtnPress veiksmas = new BtnPress();
        btnRodyti.addActionListener(veiksmas);
    }

    class BtnPress implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            sk1 = Integer.parseInt(skaicius1TxF.getText());
            sk2 = Integer.parseInt(skaicius2TxF.getText());

            if (sk1 > sk2){
                int temp = sk1;
                sk1 = sk2;
                sk2 = temp;
                skaicius1TxF.setText(sk1 + "");
                skaicius2TxF.setText(sk2 + "");

            } else {
                int temp = sk1;
                for (int i=0; temp <= sk2; i++) {
                    Object eil[]= new Object[2];
                    eil[0]=temp;
                    eil[1]=temp*temp;
                    lentelesModelis.insertRow(i,eil);
                    temp++;
                }
            }
        }
    }
}
