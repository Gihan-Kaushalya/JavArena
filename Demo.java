import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo extends JPanel { 
    
    private double xt(double t) {
        return 16 * Math.pow(Math.sin(t), 3);
    }
    
    private double yt(double t) {
        return 13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
       
        this.setBackground(Color.BLACK);
        g.setColor(Color.RED);
        
        
        for (int i = 0; i < 2550; i++) {
            double t = i * 0.1;
            int x = (int) (xt(t) * 20) + getWidth() / 2;
            int y = (int) (-yt(t) * 20) + getHeight() / 2;
            
            g.fillRect(x, y, 2, 2);
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new Demo()); 
        frame.setVisible(true);
    }
}
