package convertervalute;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Value extends JFrame implements ActionListener {
    String[]formats={"RSD-Srpski dinar","EUR-Euro","USD-Americki dolar","CHF-Svajcarski franak","GBP-Britanska funta"};
    String[]formats2={"EUR-Euro","USD-Americki dolar","CHF-Svajcarski franak","GBP-Britanska funta","RSD-Srpski dinar"};
    JComboBox<String> box=new JComboBox<>(formats);
    JComboBox<String> box2=new JComboBox<>(formats2);
    JTextField tex;
    JButton but;
    JTextField tex2;
    HashMap<String,Double>list=new HashMap<>();
    static String str;
     static String s="";
     static String s1="";
    

    public Value() throws HeadlessException {
        super("Convert");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,600);
        tex2=new JTextField("",20);
        JLabel lab=new JLabel("Iz valute:");
        JLabel lab2=new JLabel("U valutu:");
        tex=new JTextField("",20);
        but=new JButton("Konvertuj");
        but.setForeground(Color.blue);
        but.addActionListener(this);
        GridLayout grid=new GridLayout(7,1);
        
          
        
        JPanel pane=new JPanel();
        pane.setLayout(grid);
        pane.add(tex2);
        pane.add(lab);
        pane.add(box);
        pane.add(lab2);
        pane.add(box2);
        pane.add(tex);
        pane.add(but);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(pane);
        
       
        setVisible(true);
        
    }
    
    @Override
    public Insets getInsets(){
        return new Insets(100,0,10,10);
    }
    
    private static void setLookAndFeel(){
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            System.err.println(ex);
    }
    }
    
    public static void main(String[]arg){
       Value.setLookAndFeel();
       Value val=new Value();
        System.out.println(s+s1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           
        if(e.getSource()==but){
            try{
            s = (String) box.getSelectedItem();
            s1 = (String) box2.getSelectedItem();
            double broj = getString(s + s1) * Double.parseDouble(tex2.getText());
            tex.setText(String.valueOf(broj));
            }catch(Exception ex){
                System.out.println("Unesite ispravan formatu u tekstualnom polju");
            }
        
        }
        
        
    }
    
    public double getString(String str){
        list.put("RSD-Srpski dinarEUR-Euro",0.0085);
        list.put("RSD-Srpski dinarUSD-Americki dolar",0.0092);
        list.put("RSD-Srpski dinarCHF-Svajcarski franak",0.0084);
        list.put("RSD-Srpski dinarGBP-Britanska funta",0.0072);
        list.put("EUR-EuroRSD-Srpski dinar",117.0);
        list.put("EUR-EuroRSDUSD-Americki dolar",1.047);
        list.put("EUR-EuroRSDCHF-Svajcarski franak",0.9338);
        list.put("EUR-EuroRSDGBP-Britanska funta",0.832);
        list.put("GBP-Britanska funtaEUR-Euro",1.2);
        list.put("GBP-Britanska funtaRSD-Srpski dinar",140.0);
        list.put("GBP-Britanska funtaUSD-Americki dolar",1.25);
        list.put("GBP-Britanska funtaCHF-Svajcarski franak",1.12);
        list.put("CHF-Svajcarski franakGBP-BritanskaFunta",0.89);
        list.put("CHF-Svajcarski franakEUR-Euro",1.07);
        list.put("CHF-Svajcarski franakUSD-Americki dolar",1.12);
        list.put("CHF-Svajcarski franakRSD-Srpski dinar",124.9);
        list.put("USD-Americki dolarCHF-Svajcarski franak",0.89);
        list.put("USD-Americki dolarRSD-Srpski dinar",111.3);
        list.put("USD-Americki dolarEUR-Euro",0.95);
        list.put("USD-Americki dolarGBP-BritanskaFunta",0.79);
        
        return list.get(str);
    }
    
    
}
