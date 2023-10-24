import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class q1 {
    static Vector colmnName;
    static Vector data=new Vector<>();
    static JTable table;
    JLabel namelabel=new JLabel("Name");
    JTextField name=new JTextField();
    JLabel pricelabel=new JLabel("price");
    JTextField price=new JTextField();
    JLabel quantitylabel=new JLabel("quantity");
    JTextField quantity=new JTextField();
    JButton addb=new JButton("ADD");
    JLabel totallabel=new JLabel("Total");
    JLabel total;
    q1(){
        colmnName=new Vector<>();
        colmnName.add("Name");
        colmnName.add("price");
        colmnName.add("Quantity");
        colmnName.add("Action");
        Vector row=new Vector<>();
        row.add("Product A");
        row.add("10");
        row.add("50");
        row.add("x");
        data.add(colmnName);
        data.add(row);
        table=new JTable(data,colmnName);
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(table);
        name.setSize(10,10);
        panel.add(namelabel);
        panel.add(name);
        panel.add(pricelabel);
        panel.add(price);
        panel.add(quantitylabel);
        panel.add(quantity);
        panel.add(addb);
        panel.add(totallabel);
      //  panel.add(total);
        JFrame frame=new JFrame("Q1lab6");
        frame.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        addb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a=name.getText();
                String b=price.getText();
                String c=quantity.getText();
                String[] abc={a,b,c};
                maketable(abc,table);
               // setTotalLabel(table,total);
                panel.revalidate();
                panel.repaint();
            }
        });

    }

    public static void maketable(String[] row,JTable t){
        String name=row[0];
        String price=row[1];
        String quantity=row[2];
        Vector nrow=new Vector<>();
        nrow.add(name);
        nrow.add(price);
        nrow.add(quantity);
        nrow.add("x");
        data.add(nrow);
        t=new JTable(data,colmnName);
    }
    private static void setTotalLabel(JTable t, JLabel l) {
        double totalPrice = 0.0;
        for (int row = 0; row < t.getRowCount(); row++) {
            double price = (double) t.getValueAt(row, 1);
            int quantity = (int) t.getValueAt(row, 2);
            totalPrice += price * quantity;
        }
        l.setText("Total: " + totalPrice);
    }


    public static void main(String[] args){
        q1 q=new q1();
    }
}
