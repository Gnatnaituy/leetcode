package classify.dp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class GameOfLifeAWT extends JFrame implements ActionListener {

    private static final Color[] color = {Color.orange, Color.BLACK};
    private static final int size = 15;
    private static final Dimension dim = new Dimension(size, size);

    // size in pixel of every label
    private static final int GenDelay = 1000;
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    public static Random random = new Random();
    // the cells labels
    private CellsGrid[][] Cells;

    // timer that fires the next generation

    private Timer timer;

    // generation counter

    private int generation = 0;

    private JLabel CellsIteration = new JLabel("Generation: 0");

    // the 3 buttons

    private JButton clearBtn = new JButton("Clear"),

    PauseBtn = new JButton("Pause"),

    StartBtn = new JButton("Start");

    // the slider for the speed


    // state of the game (running or pause)

    private boolean gameRunning = false;

    // if the mouse is down or not

    private boolean mouseDown = false;


    private GameOfLifeAWT(int nbRow, int nbCol) {

        super(" New GameOfLife");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        // create the labels (2 more on each size) these wont be shown

        // but will be used in calculating the cells alive around

        Cells = new CellsGrid[nbRow + 2][nbCol + 2];

        for (int r = 0; r < nbRow + 2; r++) {

            for (int c = 0; c < nbCol + 2; c++) {

                Cells[r][c] = new CellsGrid();

            }


        }


        // panel in the center with the labels

        JPanel panel = new JPanel(new GridLayout(nbRow, nbCol, 1, 1));

        panel.setBackground(Color.BLACK);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        // add each label (not the one on the border) to the panel and add to each of them its neighbours

        for (int r = 1; r < nbRow + 1; r++) {

            for (int c = 1; c < nbCol + 1; c++) {

                panel.add(Cells[r][c]);

                Cells[r][c].addNeighbour(Cells[r - 1][c]);
                //Cells[r][c].addNeighbour(getCellSafe(r-1, c)); // North

                Cells[r][c].addNeighbour(Cells[r + 1][c]);    // South
                //Cells[r][c].addNeighbour(getCellSafe(r+1, c));

                Cells[r][c].addNeighbour(Cells[r][c - 1]);    // West
                //Cells[r][c].addNeighbour(getCellSafe(r, c-1));

                Cells[r][c].addNeighbour(Cells[r][c + 1]);    // East
                //Cells[r][c].addNeighbour(getCellSafe(r, c+1));

                Cells[r][c].addNeighbour(Cells[r - 1][c - 1]);  // North West
                //Cells[r][c].addNeighbour(getCellSafe(r-1, c-1));

                Cells[r][c].addNeighbour(Cells[r - 1][c + 1]);  // North East
                //Cells[r][c].addNeighbour(getCellSafe(r-1, c+1));

                Cells[r][c].addNeighbour(Cells[r + 1][c - 1]);  // South West
                //Cells[r][c].addNeighbour(getCellSafe(r+1, c-1));

                Cells[r][c].addNeighbour(Cells[r + 1][c + 1]);  // South East
                //Cells[r][c].addNeighbour(getCellSafe(r+1, +c));

            }


        }


        // now the panel can be added

        add(panel, BorderLayout.CENTER);


        // the bottom panel with the buttons the generation label and the slider

        // this panel is formed grid panels

        panel = new JPanel(new GridLayout(1, 3));

        // another panel for the 3 buttons

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        clearBtn.addActionListener(this);

        buttonPanel.add(clearBtn);

        PauseBtn.addActionListener(this);

        PauseBtn.setEnabled(false);           // game is pause the pause button is disabled

        buttonPanel.add(PauseBtn);

        StartBtn.addActionListener(this);

        buttonPanel.add(StartBtn);

        // add the 3 buttons to the panel

        panel.add(buttonPanel);

        // the generation label

        CellsIteration.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(CellsIteration);


        // in the JFrame

        add(panel, BorderLayout.NORTH);

        // put the frame on

        setLocation(20, 20);

        pack(); // adjust to the window size
        setVisible(true);

        // start the thread that run the cycles of life

        timer = new Timer(GenDelay, this);

    }

    public static void main(String[] arg) {

        SwingUtilities.invokeLater(() -> new GameOfLifeAWT(50, 50));

    }

//end of game of life

    // called by the Timer and the JButtons

    public CellsGrid getCellSafe(int r0, int c0) {
        int r = r0 % Cells.length; // Cells.length is effectively nbRow
        if (r < 0) r += Cells.length; // deal with how % works for negatives
        int c = c0 % Cells[0].length; // Cells[0].length is effectively nbCol
        if (c < 0) c += Cells[0].length; // deal with how % works for negatives
        return Cells[r][c];
    }
    //end of action


    // to start the whole thing as a Java application

    public synchronized void actionPerformed(ActionEvent e) {

        // test the JButtons first

        Object o = e.getSource();

        // the clear button

        if (o == clearBtn) {

            timer.stop();                   // stop timer

            gameRunning = false;            // flag gamme not running

            PauseBtn.setEnabled(false);       // disable pause button

            StartBtn.setEnabled(true);           // enable go button

            // clear all cells

            for (int r = 1; r < Cells.length; r++) {

                for (int c = 1; c < Cells[r].length; c++) {

                    Cells[r][c].clear();

                }

            }

            // reset generation number and its label

            generation = 0;

            CellsIteration.setText("Generation: 0");

            return;

        }

        // the pause button

        if (o == PauseBtn) {

            timer.stop();                   // stop timer

            gameRunning = false;            // flag not running

            PauseBtn.setEnabled(false);       // disable myself

            StartBtn.setEnabled(true);           // enable go button

            return;

        }

        // the go button

        if (o == StartBtn) {

            PauseBtn.setEnabled(true);                // enable pause button

            StartBtn.setEnabled(false);                  // disable myself

            gameRunning = true;                     // flag game is running

            timer.setDelay(GenDelay);

            timer.start();

            return;

        }

        // not a JButton so it is the timer

        // set the delay for the next time

        timer.setDelay(GenDelay);

        // if the game is not running wait for next time

        if (!gameRunning)

            return;

        ++generation;

        CellsIteration.setText("Generation: " + generation);

        for (CellsGrid[] cell : Cells) {
            for (CellsGrid cellsGrid : cell) {
                cellsGrid.checkState();
            }
        }

        for (CellsGrid[] cell : Cells) {
            for (CellsGrid cellsGrid : cell) {
                cellsGrid.updateState();
            }
        }

    }


    // A class that extends JLabel but also check for the neigbour

    // when asked to do so

    class CellsGrid extends JLabel implements MouseListener {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private int state, newState;

        private int numNeighbours;

        private CellsGrid[] neighbour = new CellsGrid[8]; // array of total neighbours with possibility of 8


        CellsGrid() {

            state = newState = 0;           // Dead

            setOpaque(true);                // so color will be showed

            setBackground(color[0]);        //set colour of dead cell

            addMouseListener(this);         // to select new LIVE cells

            this.setPreferredSize(dim);     //set size a new cells

        }

        // to add a neighbour

        void addNeighbour(CellsGrid n) {

            neighbour[numNeighbours++] = n;

        }

        // to see if I should live or not

        void checkState() {

            // number alive around

            int NumNeighbours = 0; // number alive neighbours

            // see the state of my neighbour

            for (int i = 0; i < numNeighbours; i++)

                NumNeighbours += neighbour[i].state;

            // newState

            if (state == 1) {                // if alive

                if (NumNeighbours < 2)              // 1.Any live cell with fewer than two live neighbours dies

                    newState = 0;

                if (NumNeighbours > 3)              // 2.Any live cell with more than three live neighbours dies

                    newState = 0;

            } else {

                if (NumNeighbours == 3)            // 4.Any dead cell with exactly three live neighbours becomes a live cell

                    newState = 1;

            }

        }

        // after the run switch the state to new state

        void updateState() {

            if (state != newState) {     // do the test to avoid re-setting same color for nothing

                state = newState;

                setBackground(color[state]);

            }

        }


        // called when the game is reset/clear

        void clear() {

            if (state == 1 || newState == 1) {

                state = newState = 0;

                setBackground(color[state]);

            }

        }

        @Override

        public void mouseClicked(MouseEvent arg0) {

        }

        // if the mouse enter a cell and it is down we make the cell alive

        public void mouseEntered(MouseEvent arg0) {

            if (mouseDown) {

                state = newState = 1;

                setBackground(color[1]);

            }

        }

        @Override

        public void mouseExited(MouseEvent arg0) {

        }

        // if the mouse is pressed on a cell you register the fact that it is down
        // and make that cell alive
        public void mousePressed(MouseEvent arg0) {
            mouseDown = true;
            state = newState = 1;
            setBackground(color[1]);
        }

        // turn off the fact that the cell is down
        public void mouseReleased(MouseEvent arg0) {
            mouseDown = false;
        }
    }
}