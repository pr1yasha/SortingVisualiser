import javax.swing.JFrame;
import java.awt.Dimension;

public class Frame extends JFrame {

    SortingArray panel = new SortingArray();

    public Frame() {
        this.setTitle("Sorting Algorithms");
        this.getContentPane().setPreferredSize(new Dimension(1400, 700));
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
    }
}
