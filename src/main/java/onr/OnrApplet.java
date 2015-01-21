package onr;

import org.generation5.nn.NeuralNetworkException;

import javax.swing.*;

public class OnrApplet extends JApplet {

    JFrame fFrame;

    public void init () {
        try {
            fFrame = new OnrFrame (this);
            fFrame.setVisible (true);
        } catch (NeuralNetworkException e) {
            e.printStackTrace();
        }
    }

    void close () {
        fFrame.dispose ();
        fFrame = null;
    }

}
