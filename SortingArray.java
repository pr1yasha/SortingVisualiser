import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortingArray extends JPanel implements ActionListener {
    private final Random random;
    private int[] array;
    private final CocktailSort cocktailSort;
    private final CountingSort countingSort;
    private final GnomeSort gnomeSort;
    private final QuickSort quickSort;
    private final BubbleSort bubbleSort;
    private final SelectionSort selectionSort;
    private final PancakeSort pancakeSort;
    private final InsertionSort insertionSort;
    boolean bubble_boolean = false;
    boolean quick_boolean = false;
    boolean cocktail_boolean = false;
    boolean selection_boolean = false;
    boolean insertion_boolean = false;
    boolean pancake_boolean = false;
    boolean gnome_boolean = false;
    boolean counting_boolean = false;
    JButton restart = new JButton("restart array");
    JButton gnome = new JButton("gnome sort");
    JButton bubble = new JButton("bubble sort");
    JButton quick = new JButton("quick sort");
    JButton cocktail = new JButton("cocktail sort");
    JButton selection = new JButton("selection sort");
    JButton insertion = new JButton("insertion sort");
    JButton pancake = new JButton("pancake sort");
    JButton counting = new JButton("counting sort");
    JLabel label = new JLabel("0 swaps made  ");

    public SortingArray() {
        random = new Random();
        cocktailSort = new CocktailSort(array);
        bubbleSort = new BubbleSort(array);
        selectionSort = new SelectionSort(array);
        quickSort = new QuickSort(array);
        pancakeSort = new PancakeSort(array);
        gnomeSort = new GnomeSort(array);
        insertionSort = new InsertionSort(array);
        countingSort = new CountingSort(array);
        array = new int[100];
        this.add(label);
        label.setForeground(Color.RED);
        createButton(restart);
        createButton(bubble);
        createButton(counting);
        createButton(quick);
        createButton(selection);
        createButton(insertion);
        createButton(pancake);
        createButton(cocktail);
        createButton(gnome);
        arrayRandomFill();
        repaint();
    }

    //returns true if the array has finished sorting
    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //creates and adds button to the panel
    public void createButton(JButton button){
        button.setFocusable(false);
        button.addActionListener(this);
        this.add(button);
    }

    // creates a random array
    public void arrayRandomFill() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(510) + 40;
        }
    }

    // method that paints the panel with array
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);

        for (int i = 0; i<array.length; i++){
            g.setColor(Color.WHITE);
            if (gnome_boolean){
                if (i==GnomeSort.currIndex){
                    g.setColor(Color.MAGENTA);
                }

            }
            if (quick_boolean){
                if (i==QuickSort.currIndex){
                    g.setColor(Color.MAGENTA);
                }
                if (i==QuickSort.partition){
                    g.setColor(Color.YELLOW);
                }
                if (i==QuickSort.secondPointer){
                    g.setColor(Color.BLUE);
                }
            }

            if (counting_boolean){
                if (i==CountingSort.currIndex){
                    g.setColor(Color.blue);
                }
            }

            if (cocktail_boolean){
                if (i==CocktailSort.currIndex){
                    g.setColor(Color.MAGENTA);
                }
                if (i>=array.length - CocktailSort.portionSorted || i<=CocktailSort.forwardPortionSorted){
                    g.setColor(Color.GREEN);
                }
            }

            if (bubble_boolean) {
                if (i == BubbleSort.currIndex && i != 0) {
                    g.setColor(Color.MAGENTA);
                }
                if (i >= array.length - BubbleSort.portionSorted) {
                    g.setColor(Color.green);
                }
            }

            if (pancake_boolean) {
                if (!pancakeSort.flip){
                    if (i==getMax(array.length - pancakeSort.portionSorted)) {
                        g.setColor(Color.MAGENTA);
                    }
                    if (i==0){
                        g.setColor(Color.YELLOW);
                    }
                }
                else {
                    if (i==0){
                        g.setColor(Color.MAGENTA);
                    }
                    if (i==pancakeSort.currMax+1) {
                        g.setColor(Color.YELLOW);
                    }

                }
                if (i >= array.length - pancakeSort.portionSorted) {
                    g.setColor(Color.green);
                }
            }

            if (selection_boolean){
                if (i== SelectionSort.minNum){
                    g.setColor(Color.MAGENTA);
                }
                if (i== SelectionSort.current_index){
                    g.setColor(Color.BLUE);
                }
                if (i< SelectionSort.portion_sorted){
                    g.setColor(Color.GREEN);
                }
                if (i== SelectionSort.portion_sorted){
                    g.setColor(Color.ORANGE);
                }

            }

            if (insertion_boolean){
                if (i== InsertionSort.portionSorted){
                    g.setColor(Color.ORANGE);
                }
                if (i== InsertionSort.currIndex){
                    g.setColor(Color.MAGENTA);
                }
            }
            if (isSorted()) {
                g.setColor(Color.green);
            }
            g.drawRect(i*(14), 700-array[i], 14, array[i]);
            g.fillRect(i*(14), 700-array[i], 14, array[i]);
        }
    }

    // resets array and all sorting classes
    @Override
    public void actionPerformed(ActionEvent e) {
        // resets and randomises the array
        if (e.getSource() == restart) {
            label.setText("0 swaps made  ");
            bubble_boolean = false;
            bubbleSort.reset();
            cocktail_boolean = false;
            cocktailSort.reset();
            selection_boolean = false;
            selectionSort.reset();
            insertion_boolean = false;
            insertionSort.reset();
            pancake_boolean = false;
            pancakeSort.reset();
            gnome_boolean = false;
            gnomeSort.reset();
            counting_boolean = false;
            countingSort.reset();
            quick_boolean = false;
            quickSort.reset();
            arrayRandomFill();
            repaint();
        }

        if (e.getSource() == bubble) {
            bubble_boolean = true;
            Timer bubbleTimer;
            bubbleTimer = new Timer(1, e18 -> {
                if (isSorted() || !bubble_boolean) {
                    ((Timer) e18.getSource()).stop();
                } else {
                    bubbleSort.BubbleSort(array);
                    label.setText(BubbleSort.swaps + " swaps made  ");
                    repaint();
                }

            });
            bubbleTimer.start();
        }

        if (e.getSource() == selection){
            selection_boolean = true;
            System.out.println(bubble_boolean);
            Timer selectionTimer;
            selectionTimer = new Timer(1, e17 -> {
                if (isSorted() || !selection_boolean) {
                    ((Timer) e17.getSource()).stop();
                } else {
                    selectionSort.SelectionSort(array);
                    label.setText(SelectionSort.swaps + " swaps made  ");
                    repaint();
                }

            });
            selectionTimer.start();
        }

        if (e.getSource() == insertion){
            insertion_boolean = true;
            Timer insertionTimer;
            insertionTimer = new Timer(1, e16 -> {
                if (isSorted() || !insertion_boolean) {
                    ((Timer) e16.getSource()).stop();
                } else {
                    insertionSort.InsertionSort(array);
                    label.setText(" ");
                    repaint();
                }
            });
            insertionTimer.start();
        }

        if (e.getSource() == pancake) {
            pancake_boolean = true;
            Timer pancakeTimer;
            pancakeTimer = new Timer(20, e15 -> {
                if (isSorted() || !pancake_boolean) {
                    ((Timer) e15.getSource()).stop();
                } else {
                    pancakeSort.PancakeSort(array);
                    label.setText(PancakeSort.swaps + " swaps made  ");
                    repaint();
                }

            });
            pancakeTimer.start();
        }

        if (e.getSource() == cocktail) {
            cocktail_boolean = true;
            Timer cocktailTimer;
            cocktailTimer = new Timer(1, e14 -> {
                if (isSorted() || !cocktail_boolean) {
                    ((Timer) e14.getSource()).stop();
                } else {
                    cocktailSort.cocktailSort(array);
                    label.setText(CocktailSort.swaps + " swaps made");
                    repaint();
                }

            });
            cocktailTimer.start();
        }
        if (e.getSource() == quick) {
            quick_boolean = true;
            Timer quickTimer;
            quickTimer = new Timer(0, e13 -> {
                if (isSorted() || !quick_boolean) {
                    ((Timer) e13.getSource()).stop();
                } else {
                    quickSort.QuickSort(array);
                    repaint();
                }

            });
            quickTimer.start();
        }

        if (e.getSource() == gnome) {
            gnome_boolean = true;
            Timer gnomeTimer;
            gnomeTimer = new Timer(0, e1 -> {
                if (isSorted() || !gnome_boolean) {
                    ((Timer) e1.getSource()).stop();
                } else {
                    gnomeSort.GnomeSort(array);
                    label.setText(GnomeSort.swaps + " swaps made  ");
                    repaint();
                }

            });
            gnomeTimer.start();
        }

        if (e.getSource() == counting) {
            counting_boolean = true;
            Timer countingTimer;
            countingTimer = new Timer(15, e12 -> {
                if (isSorted() || !counting_boolean) {
                    ((Timer) e12.getSource()).stop();
                } else {
                    countingSort.CountingSort(array);
                    label.setText(" ");
                    repaint();
                }

            });
            countingTimer.start();
        }
    }

    public int getMax(int n){
        int index = 0;
        int max = this.array[0];
        for (int i=0; i < n; i++){
            if (this.array[i] > max){
                max = this.array[i];
                index = i;
            }
        }
        return index;
    }
}
