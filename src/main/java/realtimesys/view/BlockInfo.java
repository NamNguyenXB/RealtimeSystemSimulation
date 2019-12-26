/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.view;

import java.awt.Color;

/**
 *
 * @author namng
 */
public class BlockInfo {
    
    private double begin;
    private double len;
    private String label;
    private Color blockColor = Color.GRAY;
    private Color boderColor = Color.BLACK;

    /**
     * Get the value of boderColor
     *
     * @return the value of boderColor
     */
    public Color getBoderColor() {
        return boderColor;
    }

    /**
     * Set the value of boderColor
     *
     * @param boderColor new value of boderColor
     */
    public void setBoderColor(Color boderColor) {
        this.boderColor = boderColor;
    }


    /**
     * Get the value of label
     *
     * @return the value of label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the value of label
     *
     * @param label new value of label
     */
    public void setLabel(String label) {
        this.label = label;
    }


    public BlockInfo(double begin, double len, Color color, Color bodercolor) {
        this.begin = begin;
        this.len = len;
        this.blockColor = color;
        this.boderColor = bodercolor;
    }
    

    /**
     * Get the value of blockColor
     *
     * @return the value of blockColor
     */
    public Color getBlockColor() {
        return blockColor;
    }

    /**
     * Set the value of blockColor
     *
     * @param color new value of blockColor
     */
    public void setBlockColor(Color color) {
        this.blockColor = color;
    }


    /**
     * Get the value of len
     *
     * @return the value of len
     */
    public double getLen() {
        return len;
    }

    /**
     * Set the value of len
     *
     * @param len new value of len
     */
    public void setLen(double len) {
        this.len = len;
    }


    /**
     * Get the value of begin
     *
     * @return the value of begin
     */
    public double getBegin() {
        return begin;
    }

    /**
     * Set the value of begin
     *
     * @param begin new value of begin
     */
    public void setBegin(double begin) {
        this.begin = begin;
    }

}
