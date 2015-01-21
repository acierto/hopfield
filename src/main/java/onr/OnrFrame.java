package onr;


import org.generation5.nn.NeuralNetworkException;
import org.generation5.nn.PerceptronNN;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class OnrFrame extends JFrame {

    static final int COL_NUM = 6;

    static final int ROW_NUM = 8;

    static final int BIT_SIZE = COL_NUM * ROW_NUM;

    static final double[] ONE =
            {0, 0, 0, 1, 0, 0,
             0, 0, 0, 0, 0, 0,
             0, 0, 1, 0, 0, 0,
             0, 1, 0, 0, 0, 0,
             0, 1, 0, 0, 0, 0,
             0, 1, 0, 0, 0, 0,
             0, 1, 0, 0, 1, 0,
             0, 0 ,1, 1, 0, 0};

    static final double[] TWO =
            {0, 0, 1, 0, 0, 0,
             0, 0, 0, 0, 0, 0,
             0, 0, 1, 0, 0, 0,
             0, 0, 1, 1, 0, 0,
             0, 1, 1, 0, 0, 0,
             1, 0, 1, 0, 0, 0,
             1, 1, 1, 0, 0, 0,
             0, 1 ,0, 0, 0, 0};

    static final double[] THREE =
            {0, 1, 0, 0, 0, 0,
             0, 1, 0, 0, 0, 0,
             0, 1, 0, 0, 1, 0,
             0, 1, 0, 1, 0, 0,
             0, 1, 1, 0, 0, 0,
             0, 1, 1, 0, 0, 0,
             0, 1, 0, 1, 0, 0,
             0, 1 ,0, 0, 1, 0};

    static final double[] FOUR =
            {0, 0, 1, 1, 0, 0,
             0, 1, 0, 1, 0, 0,
             0, 1, 0, 1, 0, 0,
             0, 1, 1, 0, 0, 0,
             1, 1, 0, 0, 0, 0,
             0, 1, 0, 0, 1, 0,
             0, 1, 0, 1, 0, 0,
             0, 0 ,1, 0, 0, 0};

    static final double[] FIVE =
            {1, 1, 1, 1, 1, 0,
             1, 0, 1, 0, 1, 0,
             1, 0, 1, 0, 1, 0,
             1, 0, 1, 0, 1, 0,
             1, 0, 1, 0, 1, 0,
             1, 0, 1, 0, 1, 0,
             1, 0, 1, 0, 1, 0,
             1, 0 ,1, 0, 1, 1};

    static final double[] SIX =
            {1, 1, 1, 1, 0, 0,
             1, 0, 0, 1, 0, 0,
             1, 0, 0, 1, 0, 0,
             1, 0, 0, 1, 0, 0,
             1, 0, 0, 1, 0, 0,
             1, 0, 0, 1, 0, 0,
             1, 0, 0, 1, 0, 1,
             1, 0 ,0, 0, 1, 0};

    static final double[] SEVEN =
            {0, 1, 1, 1, 0, 0,
             1, 0, 0, 0, 1, 0,
             1, 0, 0, 0, 1, 0,
             1, 0, 0, 0, 1, 0,
             1, 0, 0, 0, 1, 0,
             1, 0, 0, 0, 1, 0,
             1, 0, 0, 1, 0, 0,
             0, 1 ,1, 1, 0, 0};

    static final double[] EIGHT =
            {0, 0, 1, 1, 0, 0,
             0, 1, 0, 0, 1, 0,
             0, 1, 0, 0, 1, 0,
             0, 1, 0, 0, 1, 0,
             0, 1, 1, 1, 0, 0,
             0, 1, 0, 0, 0, 0,
             0, 1, 0, 0, 0, 0,
             1, 0 ,0, 0, 0, 0};

    static final double[] NINE =
             {0, 1, 1, 1, 0, 0,
              0, 1, 0, 1, 0, 0,
              0, 1, 0, 1, 0, 0,
              0, 1, 1, 1, 0, 0,
              0, 1, 0, 0, 0, 0,
              0, 1, 1, 0, 0, 0,
              0, 1, 0, 1, 0, 0,
              0, 1 ,0, 0, 1, 0};

    static final double[] ZERO =
            {0, 1, 1, 1, 0, 0,
             1, 0, 0, 0, 1, 0,
             1, 0, 0, 0, 0, 0,
             0, 1, 1, 0, 0, 0,
             0, 0, 0, 1, 0, 0,
             0, 0, 0, 0, 1, 0,
             1, 0, 0, 0, 1, 0,
             0, 1 ,1, 1, 1, 0};

    static final public double[][] DIGITS = {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
    protected int noisyTemplates = 25;

    protected PerceptronNN[] perceptron = new PerceptronNN[DIGITS.length];
    protected double[][] trainingData = new double[noisyTemplates * DIGITS.length][BIT_SIZE];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addNoiseButton;
    private JButton classifyButton;
    private JButton clearButton;
    private onr.OnrCharacterPanel eightTemplate;
    private onr.OnrCharacterPanel fiveTemplate;
    private onr.OnrCharacterPanel fourTemplate;
    private onr.OnrCharacterPanel inputPanel;
    private JPanel mainPanel;
    private onr.OnrCharacterPanel nineTemplate;
    private onr.OnrCharacterPanel oneTemplate;
    private onr.OnrCharacterPanel outputPanel;
    private onr.OnrCharacterPanel sevenTemplate;
    private onr.OnrCharacterPanel sixTemplate;
    private JPanel templatePanel;
    private onr.OnrCharacterPanel threeTemplate;
    private JPanel toolbarPanel;
    private onr.OnrCharacterPanel twoTemplate;
    private onr.OnrCharacterPanel zeroTemplate;

    /**
     * Creates new form onr.OnrFrame
     */
    public OnrFrame() throws NeuralNetworkException {

        OnrApplet myApplet = new OnrApplet();
        myApplet.start();
        myApplet.init();
        getContentPane().add(myApplet.getContentPane());

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.err.println("Problem loading 'WindowsLookAndFeel', defaulting to metal.");
        }

        initComponents();

        this.setSize(420, 280);
        this.setResizable(false);

        oneTemplate.setCharacter(ONE);
        twoTemplate.setCharacter(TWO);
        threeTemplate.setCharacter(THREE);
        fourTemplate.setCharacter(FOUR);
        fiveTemplate.setCharacter(FIVE);
        sixTemplate.setCharacter(SIX);
        sevenTemplate.setCharacter(SEVEN);
        eightTemplate.setCharacter(EIGHT);
        nineTemplate.setCharacter(NINE);
        zeroTemplate.setCharacter(ZERO);

        System.out.print("Generating data...");
        generateData();     // Generate the normal/noisy data
        System.out.println("done.");

        System.out.print("Training perceptrons...");
        trainPerceptrons();     // Generate the normal/noisy data
        System.out.println("done.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws NeuralNetworkException {
        new OnrFrame().setVisible(true);
    }

    public void generateData() {
        int idx = 0;
        for (double[] DIGIT : DIGITS) {
            System.arraycopy(DIGIT, 0, trainingData[idx], 0, BIT_SIZE);
            idx++;

            // Now generate the necessary noisy data
            for (int j = 1; j < noisyTemplates; j++) {
                for (int d = 0; d < BIT_SIZE; d++) {
                    if (Math.random() < 0.07) {
                        trainingData[idx][d] = Math.random();
                    } else {
                        trainingData[idx][d] = DIGIT[d];
                    }
                }
                idx++;
            }
        }

        writeTestData();
    }

    protected void writeTestData() {
        BufferedImage img = new BufferedImage(640, 480, 1);
        Graphics g = img.getGraphics();

        int px, py;
        int size = 2;
        int xoffset = 0;
        int yoffset = 0;
        float greyval;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());

        for (int i = 0; i < trainingData.length; i++) {
            for (int x = 0; x < BIT_SIZE; x++) {
                greyval = (float) (1 - trainingData[i][x]);
                px = (x % 5) * size + xoffset;
                py = (x / 5) * size + yoffset;

                g.setColor(new Color(greyval, greyval, greyval));
                g.fillRect(px, py, size, size);
            }
            xoffset += 15;
            if (((i + 1) % noisyTemplates) == 0) {
                xoffset = 0;
                yoffset += 20;
            }
        }

        try {
            javax.imageio.ImageIO.write(img, "png", new java.io.File("testData.png"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void trainPerceptrons() throws NeuralNetworkException {
        for (int i = 0; i < perceptron.length; i++) {
            perceptron[i] = new PerceptronNN(BIT_SIZE);

            PerceptronData pd = createDigitData(i);
            for (int a = 0; a < 100; a++) {
                for (int n = 0; n < pd.classA.length; n++) {
                    perceptron[i].train(pd.classA[n], 0);
                }
                for (int n = 0; n < pd.classB.length; n++) {
                    perceptron[i].train(pd.classB[n], 1);
                }
            }
        }
    }

    protected PerceptronData createDigitData(int digit) {
        PerceptronData input = new PerceptronData();

        input.classB = new double[noisyTemplates][BIT_SIZE];
        int start = digit * noisyTemplates;
        int end = start + noisyTemplates;
        for (int i = start; i < end; i++) {
            System.arraycopy(trainingData[i], 0, input.classB[i - start], 0, BIT_SIZE);
        }

        int idx = 0;
        input.classA = new double[trainingData.length - noisyTemplates][BIT_SIZE];
        for (int i = 0; i < DIGITS.length; i++) {
            if (i == digit) continue;
            start = i * noisyTemplates;
            end = start + noisyTemplates;
            for (int j = start; j < end; j++) {
                System.arraycopy(trainingData[j], 0, input.classA[idx], 0, BIT_SIZE);
                idx++;
            }
        }

        return input;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        templatePanel = new JPanel();
        oneTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        twoTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        threeTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        fourTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        fiveTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        sixTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        sevenTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        eightTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        nineTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        zeroTemplate = new OnrCharacterPanel(OnrCharacterPanel.THUMBNAIL_VIEW);
        mainPanel = new JPanel();
        inputPanel = new onr.OnrCharacterPanel();
        toolbarPanel = new JPanel();
        classifyButton = new JButton();
        clearButton = new JButton();
        addNoiseButton = new JButton();
        outputPanel = new onr.OnrCharacterPanel();

        setTitle("Optical Numerical Recognizor (ONR)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm();
            }
        });

        templatePanel.setPreferredSize(new Dimension(200, 60));
        oneTemplate.setLayout(null);

        oneTemplate.setPreferredSize(new Dimension(35, 50));
        oneTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(oneTemplate);

        twoTemplate.setLayout(null);

        twoTemplate.setPreferredSize(new Dimension(35, 50));
        twoTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(twoTemplate);

        threeTemplate.setLayout(null);

        threeTemplate.setPreferredSize(new Dimension(35, 50));
        threeTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(threeTemplate);

        fourTemplate.setLayout(null);

        fourTemplate.setPreferredSize(new Dimension(35, 50));
        fourTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(fourTemplate);

        fiveTemplate.setLayout(null);

        fiveTemplate.setPreferredSize(new Dimension(35, 50));
        fiveTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(fiveTemplate);

        sixTemplate.setLayout(null);

        sixTemplate.setPreferredSize(new Dimension(35, 50)
        );
        sixTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(sixTemplate);

        sevenTemplate.setLayout(null);

        sevenTemplate.setPreferredSize(new Dimension(35, 50));
        sevenTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(sevenTemplate);

        eightTemplate.setLayout(null);

        eightTemplate.setPreferredSize(new Dimension(35, 50));
        eightTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(eightTemplate);

        nineTemplate.setLayout(null);

        nineTemplate.setPreferredSize(new Dimension(35, 50));
        nineTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(nineTemplate);

        zeroTemplate.setLayout(null);

        zeroTemplate.setPreferredSize(new Dimension(35, 50));
        zeroTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                templateMouseClicked(evt);
            }
        });

        templatePanel.add(zeroTemplate);

        getContentPane().add(templatePanel, BorderLayout.SOUTH);

        mainPanel.setLayout(new BorderLayout());

        inputPanel.setLayout(null);

        inputPanel.setPreferredSize(new Dimension((5 + 1) * 25, (7 + 1) * 25));
        mainPanel.add(inputPanel, BorderLayout.WEST);

        toolbarPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        toolbarPanel.setMinimumSize(new Dimension(100, 500));
        toolbarPanel.setPreferredSize(new Dimension(100, 300));
        classifyButton.setFont(new Font("MS Sans Serif", Font.BOLD, 11));
        classifyButton.setText("Classify");
        classifyButton.setMargin(new Insets(2, 10, 2, 10));
        classifyButton.setPreferredSize(new Dimension(75, 23));
        classifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifyButtonActionPerformed();
            }
        });

        toolbarPanel.add(classifyButton);

        clearButton.setText("Clear");
        clearButton.setMaximumSize(new Dimension(75, 23));
        clearButton.setPreferredSize(new Dimension(75, 23));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed();
            }
        });

        toolbarPanel.add(clearButton);

        addNoiseButton.setText("Add Noise");
        addNoiseButton.setMargin(new Insets(2, 10, 2, 10));
        addNoiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNoiseButtonActionPerformed();
            }
        });

        toolbarPanel.add(addNoiseButton);

        mainPanel.add(toolbarPanel, BorderLayout.CENTER);

        outputPanel.setLayout(new BorderLayout());

        outputPanel.setPreferredSize(new Dimension((5 + 1) * 25, (7 + 1) * 25));
        mainPanel.add(outputPanel, BorderLayout.EAST);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        pack();
    }

    private void classifyButtonActionPerformed() {
        int bestIndex = -1;
        double bestValue = Double.MIN_VALUE, currValue;
        double[] data = inputPanel.getCharacter();
        outputPanel.clear();
        for (int i = 0; i < perceptron.length; i++) {
            currValue = perceptron[i].run(data);
            if (currValue > bestValue) {
                bestIndex = i;
                bestValue = currValue;
            }
        }

        if (bestIndex == -1) {
            bestIndex = 0;
        }
        outputPanel.setCharacter(DIGITS[bestIndex]);
        outputPanel.repaint();

    }

    private void clearButtonActionPerformed() {
        inputPanel.clear();
        inputPanel.repaint();
        outputPanel.clear();
        outputPanel.repaint();
    }

    private void addNoiseButtonActionPerformed() {
        inputPanel.addNoise(0.07);
        inputPanel.repaint();
    }

    private void templateMouseClicked(java.awt.event.MouseEvent evt) {
        OnrCharacterPanel src = (OnrCharacterPanel) evt.getSource();

        inputPanel.setCharacter(src.getCharacter());
        inputPanel.repaint();
    }

    /**
     * Exit the Application
     */
    private void exitForm() {
        System.exit(0);
    }
}
