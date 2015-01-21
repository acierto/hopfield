package onr;

import java.awt.*;

import static onr.OnrFrame.*;

public class OnrCharacterPanel extends javax.swing.JPanel {

    public static final int NORMAL_VIEW = 0;
    public static final int THUMBNAIL_VIEW = 1;
    protected double[] character = new double[BIT_SIZE];
    private int viewType = 0;

    public OnrCharacterPanel() {

    }

    public OnrCharacterPanel(int viewType) {
        this.viewType = viewType;
        initComponents();
    }

    public double[] getCharacter() {
        return character;
    }

    public void setCharacter(double[] charMap) {
        System.arraycopy(charMap, 0, character, 0, character.length);
    }

    public void addNoise(double rate) {
        for (int i = 0; i < character.length; i++) {
            if (Math.random() < rate) {
                if (character[i] == 0)
                    character[i] += Math.random();
                else
                    character[i] -= (Math.random() * character[i]);
            }
        }
    }

    public void clear() {
        for (int i = 0; i < character.length; i++) {
            character[i] = 0.0;
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());
    }

    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        g.setColor(new Color(225, 225, 225));
        g.fillRect(0, 0, w, h);
        g.setColor(Color.black);

        int pixelSize = (viewType == NORMAL_VIEW) ? 25 : 5;

        int sx = (w / 2) - (COL_NUM * pixelSize) / 2;
        int sy = (h / 2) - (ROW_NUM * pixelSize) / 2;
        int width = sx + COL_NUM * pixelSize;
        int height = sy + ROW_NUM * pixelSize;
        g.setColor(Color.white);
        g.fillRect(sx, sy, (COL_NUM * pixelSize), (ROW_NUM * pixelSize));

        g.setColor(Color.black);
        float grey;
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                grey = (float) (1 - character[i * COL_NUM + j]);
                g.setColor(new Color(grey, grey, grey));
                g.fillRect(sx + j * pixelSize, sy + i * pixelSize, pixelSize, pixelSize);
            }
        }

        if (viewType == NORMAL_VIEW) {
            g.setColor(Color.lightGray);
            for (int i = 1; i < COL_NUM; i++)
                g.drawLine(sx + i * pixelSize, sy, sx + i * pixelSize, height);
            for (int i = 1; i < ROW_NUM; i++)
                g.drawLine(sx, sy + i * pixelSize, width, sy + i * pixelSize);
        }

        g.setColor(Color.black);
        g.drawRect(sx - 1, sy - 1, (COL_NUM * pixelSize) + 1, (ROW_NUM * pixelSize) + 1);
    }

}
