package com.example.aashishkumar.rootcause01;

/**
 * Code forked from/inspired by Parsania Hardik on GitHub.
 */
public class Model {

    private String text1;
    private String text2;
    private String mode;
    private int image_drawable;
    private int fb_logo;
    private String saved;

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }
    public int getFb_logo() {
        return fb_logo;
    }

    public void setFb_logo(int fb_logo) {
        this.fb_logo = fb_logo;
    }

    public String getSaved() {
        return saved;
    }

    public void setSaved(String saved) {
        this.saved = saved;
    }
}
