/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author namng
 */
public class BarChart extends javax.swing.JPanel {

    protected double frameSize = 20.0;

    private ArrayList<BlockInfo> blocks;

    /**
     * Get the value of blocks
     *
     * @return the value of blocks
     */
    public ArrayList<BlockInfo> getBlocks() {
        return blocks;
    }

    /**
     * Set the value of blocks
     *
     * @param blocks new value of blocks
     */
    public void setBlocks(ArrayList<BlockInfo> blocks) {
        this.blocks = blocks;
        this.repaint();
    }

            

    /**
     * Get the value of frameSize
     *
     * @return the value of frameSize
     */
    public double getFrameSize() {
        return frameSize;
    }

    /**
     * Set the value of frameSize
     *
     * @param frameSize new value of frameSize
     */
    public void setFrameSize(double frameSize) {
        this.frameSize = frameSize;
    }
    
    public void clearView(){
        this.setBlocks(new ArrayList<>());
    }
    
    public void addBlock(BlockInfo block){
        if(this.blocks == null)
            this.blocks = new ArrayList<>();
        this.blocks.add(block);
        this.repaint();
    }

    /**
     * Creates new form BarChart
     */
    public BarChart() {
        this.blocks = new ArrayList<>();
        initComponents();
    }
    
    private boolean isBlockValid(BlockInfo blockInfo){
        return (blockInfo.getBegin() < this.frameSize && 
                blockInfo.getBegin() + blockInfo.getLen() <= this.frameSize);
    }
    
    private Point calBlockPosition(BlockInfo blockInfo){
        int x;
        x=(int)(blockInfo.getBegin()*(getWidth()-getMs()*2)/frameSize+getMs());
        int y = 0;
        return new Point(x, y);
    }
    
    private int calBlockWidth(BlockInfo blockInfo){
        return (int)(blockInfo.getLen()* (getWidth()-getMs()*2) / frameSize);
    }
    
    private double getMs(){
        return this.getWidth() * ws / 100;
    }
    
    private int calBlockHeight(BlockInfo blockInfo){
        return (int)(this.getHeight());
    }
    
    private int calLabelHeight(Graphics g, BlockInfo blockInfo){
        int fontsize = this.getHeight() / 3;
        if (fontsize > 20){
            fontsize = 20;
        }
        int textWidth = g.getFontMetrics(new Font("TimesRoman", Font.PLAIN, 
                fontsize)).stringWidth(blockInfo.getLabel());
        if (textWidth > calBlockWidth(blockInfo)) {
            return -1;
        } else {
            return fontsize;
        }
    }
    
    private int calLabelWidth(Graphics g, int fontsize, BlockInfo blockInfo){
        return g.getFontMetrics(new Font("TimesRoman", Font.PLAIN, 
                fontsize)).stringWidth(blockInfo.getLabel());
    }
    
    private Point calLabelPos(int labelW, int labelH, Rectangle bound){
        if (labelW > bound.width || labelH > bound.height){
            return null;
        }
        int x = bound.x + bound.width/2 - labelW/2;
        int y = bound.y + bound.height/2 + labelH/2;
        return new Point(x,y);
    }
    
    private void paintBlock(Graphics g, BlockInfo blockInfo){
        if(isBlockValid(blockInfo) && this.isVisible()){
            // Save the current color of graph.
            Color bkColor = g.getColor();
            
            // Paint block based on block information.
            Point blockPos = calBlockPosition(blockInfo);
            int w = calBlockWidth(blockInfo);
            int h = calBlockHeight(blockInfo);
            g.setColor(blockInfo.getBlockColor());
            g.fillRect(blockPos.x, blockPos.y, w, h);
            g.setColor(blockInfo.getBoderColor());
            g.drawRect(blockPos.x, blockPos.y, w, h);
            String label = blockInfo.getLabel();
            if (label != null && !label.isEmpty()) {
                int labelH = calLabelHeight(g, blockInfo);
                if (labelH > 0) {
                    System.out.print("fs: "+labelH+" h: "+h);
                    int labelW = calLabelWidth(g, labelH, blockInfo);
                    Point labelPos = calLabelPos(labelW, labelH,
                            new Rectangle(blockPos.x, blockPos.y, w, h));
                    Font f = g.getFont();
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, labelH));
                    g.drawString(blockInfo.getLabel(), labelPos.x, labelPos.y);
                    g.setFont(f);
                }
            }

            // Restore the color of graph.
            g.setColor(bkColor);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(blocks != null){
            blocks.forEach((b) -> {
                paintBlock(g, b);
            });
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
            return new Dimension(200, 50);
    }
    
    public static void main(String[] args)
    {      
        JFrame frame = new JFrame("Bar Chart");	
        BarChart b = new BarChart();
        BlockInfo b1 = new BlockInfo(0, 2, Color.BLUE, Color.BLACK);
        BlockInfo b2 = new BlockInfo(4, 2, Color.RED, Color.BLACK);
        BlockInfo b3 = new BlockInfo(7, 3, Color.YELLOW, Color.BLACK);
        
        b1.setLabel("task1");
        b2.setLabel("task2");
        b3.setLabel("task3");
        
        b.setSize(500, 20);
        b.frameSize = 20;
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(b, BorderLayout.CENTER);
        b.addBlock(b1);
        b.addBlock(b2);
        b.addBlock(b3);
        b.repaint();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private double ws = 2.5;

    /**
     * Get the value of ws
     *
     * @return the value of ws
     */
    public double getWs() {
        return ws;
    }

    /**
     * Set the value of ws
     *
     * @param ws new value of ws
     */
    public void setWs(double ws) {
        this.ws = ws;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
