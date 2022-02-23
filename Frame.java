import javax.swing.JFrame;
import java.awt.Dimension;

public class Frame extends JFrame {

    SortingArray panel = new SortingArray();

    public Frame() {
        this.setTitle("Sorting Algorithms");
        this.getContentPane().setPreferredSize(new Dimension(1200, 700));
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
    }

}
