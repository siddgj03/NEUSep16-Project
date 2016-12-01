package org.neu.project.ui.special;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by qiqi on 2016/11/16.
 */
public class InputValidNumberListener extends KeyAdapter {
    public void keyTyped(KeyEvent e) {
        if (Character.isDigit(e.getKeyChar()) || e.getKeyChar() == '.') {
            return;
        }
        e.consume();
    }
}
