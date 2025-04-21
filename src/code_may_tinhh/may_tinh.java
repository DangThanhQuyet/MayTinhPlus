package code_may_tinhh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

class JFontChooser extends JPanel {

    private JComboBox<String> fontBox;
    private JComboBox<Integer> sizeBox;
    private Font selectedFont;

    public JFontChooser() {
        setLayout(new GridLayout(2, 2, 10, 10));

        fontBox = new JComboBox<>(GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames());

        Integer[] sizes = {8, 10, 12, 14, 16, 18, 20, 22, 24, 28, 32, 36, 48, 72};
        sizeBox = new JComboBox<>(sizes);

        add(new JLabel("Font:"));
        add(fontBox);
        add(new JLabel("Size:"));
        add(sizeBox);

        selectedFont = new Font((String) fontBox.getSelectedItem(), Font.PLAIN, (Integer) sizeBox.getSelectedItem());

        fontBox.addActionListener(e -> updateFont());
        sizeBox.addActionListener(e -> updateFont());
    }

    private void updateFont() {
        String fontName = (String) fontBox.getSelectedItem();
        int fontSize = (Integer) sizeBox.getSelectedItem();
        selectedFont = new Font(fontName, Font.PLAIN, fontSize);
    }

    public void setSelectedFont(Font font) {
        fontBox.setSelectedItem(font.getFamily());
        sizeBox.setSelectedItem(font.getSize());
        selectedFont = font;
    }

    public Font getSelectedFont() {
        return selectedFont;
    }

    public int showDialog(Component parent) {
        int result = JOptionPane.showConfirmDialog(parent, this, "Chọn font", JOptionPane.OK_CANCEL_OPTION);
        return result;
    }
}

class FontChooserDialog {

    public static Font showDialog(Component parent, Font initialFont) {
        JFontChooser fontChooser = new JFontChooser();
        fontChooser.setSelectedFont(initialFont);

        int result = JOptionPane.showConfirmDialog(parent, fontChooser, "Chọn phông chữ", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return fontChooser.getSelectedFont();
        } else {
            return initialFont;
        }
    }
}

public class may_tinh extends javax.swing.JFrame {

    private String currentInput = "";
    private JTextArea historyArea;
    private StringBuilder history = new StringBuilder();
    private boolean isDarkMode = false;
    private Color selectedBgColor = Color.WHITE;
    private Color selectedFgColor = Color.BLACK;
    private Font selectedFont = new Font("Arial", Font.PLAIN, 12);

    public may_tinh() {
        initComponents();
        setLocationRelativeTo(null);
        historyArea = new JTextArea(10, 30);
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.SOUTH);
        updateUITheme();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtDisplay = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnPower = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnSqrt = new javax.swing.JButton();
        btnPercent = new javax.swing.JButton();
        btnBackspace = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnDivide = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnMultiply = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSubtract = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        btnEqual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnFactorial = new javax.swing.JButton();
        btnLn = new javax.swing.JButton();
        btnLog = new javax.swing.JButton();
        btnToggleAngleUnit = new javax.swing.JButton();
        btnSearchHistory = new javax.swing.JButton();
        btnTan = new javax.swing.JButton();
        btnCot = new javax.swing.JButton();
        btnDeleteLine = new javax.swing.JButton();
        btnSin = new javax.swing.JButton();
        btnCos = new javax.swing.JButton();
        btnChooseColor = new javax.swing.JButton();
        btnSaveHistory = new javax.swing.JButton();
        btnChooseFont = new javax.swing.JButton();
        btnToggleTheme = new javax.swing.JButton();
        nutXoaLui = new javax.swing.JButton();
        nutXoaNhap = new javax.swing.JButton();
        nutTienToi = new javax.swing.JButton();
        txtSearchHistory = new javax.swing.JTextField();
        nutPaste = new javax.swing.JButton();
        nutCopy = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 179, 218));

        txtDisplay.setBackground(new java.awt.Color(204, 204, 204));
        txtDisplay.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisplayActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 153, 204));
        btnSave.setFont(new java.awt.Font("Sitka Text", 1, 10)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnHistory.setBackground(new java.awt.Color(255, 153, 204));
        btnHistory.setFont(new java.awt.Font("Sitka Text", 1, 10)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setText("Hist");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        btnPower.setBackground(new java.awt.Color(255, 153, 204));
        btnPower.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnPower.setForeground(new java.awt.Color(255, 255, 255));
        btnPower.setText("x^y");
        btnPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowerActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(255, 204, 255));
        btn7.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(255, 204, 255));
        btn8.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(255, 204, 255));
        btn9.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(255, 204, 255));
        btn4.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(255, 204, 255));
        btn5.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(255, 204, 255));
        btn6.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btnSqrt.setBackground(new java.awt.Color(255, 153, 204));
        btnSqrt.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnSqrt.setForeground(new java.awt.Color(255, 255, 255));
        btnSqrt.setText("√x");
        btnSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });

        btnPercent.setBackground(new java.awt.Color(255, 153, 204));
        btnPercent.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnPercent.setForeground(new java.awt.Color(255, 255, 255));
        btnPercent.setText("%");
        btnPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPercentActionPerformed(evt);
            }
        });

        btnBackspace.setBackground(new java.awt.Color(255, 102, 102));
        btnBackspace.setFont(new java.awt.Font("Sitka Text", 1, 10)); // NOI18N
        btnBackspace.setText("DEL");
        btnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackspaceActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 102, 102));
        btnClear.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnClear.setText("AC");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btn0.setBackground(new java.awt.Color(255, 204, 255));
        btn0.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnDivide.setBackground(new java.awt.Color(255, 204, 255));
        btnDivide.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnDivide.setText("/");
        btnDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivideActionPerformed(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(255, 204, 255));
        btn1.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(255, 204, 255));
        btn2.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(255, 204, 255));
        btn3.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btnMultiply.setBackground(new java.awt.Color(255, 204, 255));
        btnMultiply.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnMultiply.setText("*");
        btnMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplyActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 204, 255));
        btnAdd.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSubtract.setBackground(new java.awt.Color(255, 204, 255));
        btnSubtract.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnSubtract.setText("-");
        btnSubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubtractActionPerformed(evt);
            }
        });

        btnDot.setBackground(new java.awt.Color(255, 204, 255));
        btnDot.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnDot.setText(".");
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });

        btnEqual.setBackground(new java.awt.Color(255, 204, 255));
        btnEqual.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        btnEqual.setText("=");
        btnEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setText("Casio 280");

        jButton1.setBackground(new java.awt.Color(255, 204, 255));
        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 13)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFactorial.setBackground(new java.awt.Color(255, 153, 204));
        btnFactorial.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnFactorial.setForeground(new java.awt.Color(255, 255, 255));
        btnFactorial.setText("x!");
        btnFactorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactorialActionPerformed(evt);
            }
        });

        btnLn.setBackground(new java.awt.Color(255, 153, 204));
        btnLn.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnLn.setForeground(new java.awt.Color(255, 255, 255));
        btnLn.setText("ln");
        btnLn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLnActionPerformed(evt);
            }
        });

        btnLog.setBackground(new java.awt.Color(255, 153, 204));
        btnLog.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnLog.setForeground(new java.awt.Color(255, 255, 255));
        btnLog.setText("log");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });

        btnToggleAngleUnit.setBackground(new java.awt.Color(255, 153, 204));
        btnToggleAngleUnit.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnToggleAngleUnit.setForeground(new java.awt.Color(255, 255, 255));
        btnToggleAngleUnit.setText("R/D");
        btnToggleAngleUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleAngleUnitActionPerformed(evt);
            }
        });

        btnSearchHistory.setBackground(new java.awt.Color(255, 153, 204));
        btnSearchHistory.setFont(new java.awt.Font("Sitka Text", 1, 13)); // NOI18N
        btnSearchHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchHistory.setText("Tìm phép toán");
        btnSearchHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHistoryActionPerformed(evt);
            }
        });

        btnTan.setBackground(new java.awt.Color(255, 153, 204));
        btnTan.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnTan.setForeground(new java.awt.Color(255, 255, 255));
        btnTan.setText("tan");
        btnTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTanActionPerformed(evt);
            }
        });

        btnCot.setBackground(new java.awt.Color(255, 153, 204));
        btnCot.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnCot.setForeground(new java.awt.Color(255, 255, 255));
        btnCot.setText("cot");
        btnCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotActionPerformed(evt);
            }
        });

        btnDeleteLine.setBackground(new java.awt.Color(255, 153, 204));
        btnDeleteLine.setFont(new java.awt.Font("Sitka Text", 1, 13)); // NOI18N
        btnDeleteLine.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteLine.setText("D_L");
        btnDeleteLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLineActionPerformed(evt);
            }
        });

        btnSin.setBackground(new java.awt.Color(255, 153, 204));
        btnSin.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnSin.setForeground(new java.awt.Color(255, 255, 255));
        btnSin.setText("sin");
        btnSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinActionPerformed(evt);
            }
        });

        btnCos.setBackground(new java.awt.Color(255, 153, 204));
        btnCos.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnCos.setForeground(new java.awt.Color(255, 255, 255));
        btnCos.setText("cos");
        btnCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCosActionPerformed(evt);
            }
        });

        btnChooseColor.setBackground(new java.awt.Color(255, 153, 204));
        btnChooseColor.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnChooseColor.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseColor.setText("màu");
        btnChooseColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseColorActionPerformed(evt);
            }
        });

        btnSaveHistory.setBackground(new java.awt.Color(255, 153, 204));
        btnSaveHistory.setFont(new java.awt.Font("Sitka Text", 1, 13)); // NOI18N
        btnSaveHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveHistory.setText("L_H");
        btnSaveHistory.setActionCommand("LưuH");
        btnSaveHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveHistoryActionPerformed(evt);
            }
        });

        btnChooseFont.setBackground(new java.awt.Color(255, 153, 204));
        btnChooseFont.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnChooseFont.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseFont.setText("font");
        btnChooseFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFontActionPerformed(evt);
            }
        });

        btnToggleTheme.setBackground(new java.awt.Color(255, 153, 204));
        btnToggleTheme.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnToggleTheme.setForeground(new java.awt.Color(255, 255, 255));
        btnToggleTheme.setText("D/R");
        btnToggleTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleThemeActionPerformed(evt);
            }
        });

        nutXoaLui.setBackground(new java.awt.Color(255, 153, 204));
        nutXoaLui.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nutXoaLui.setForeground(new java.awt.Color(255, 255, 255));
        nutXoaLui.setText("<-");
        nutXoaLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutXoaLuiActionPerformed(evt);
            }
        });

        nutXoaNhap.setBackground(new java.awt.Color(255, 153, 204));
        nutXoaNhap.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        nutXoaNhap.setForeground(new java.awt.Color(255, 255, 255));
        nutXoaNhap.setText("CE");
        nutXoaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutXoaNhapActionPerformed(evt);
            }
        });

        nutTienToi.setBackground(new java.awt.Color(255, 153, 204));
        nutTienToi.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        nutTienToi.setForeground(new java.awt.Color(255, 255, 255));
        nutTienToi.setText("->");
        nutTienToi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutTienToiActionPerformed(evt);
            }
        });

        txtSearchHistory.setBackground(new java.awt.Color(204, 204, 204));

        nutPaste.setBackground(new java.awt.Color(255, 153, 204));
        nutPaste.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nutPaste.setForeground(new java.awt.Color(255, 255, 255));
        nutPaste.setText("past");
        nutPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutPasteActionPerformed(evt);
            }
        });

        nutCopy.setBackground(new java.awt.Color(255, 153, 204));
        nutCopy.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        nutCopy.setForeground(new java.awt.Color(255, 255, 255));
        nutCopy.setText("copy");
        nutCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutCopyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearchHistory)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDisplay, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnEqual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPower, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFactorial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnToggleAngleUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteLine, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCot, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSaveHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnToggleTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChooseFont, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChooseColor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nutCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nutPaste, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nutXoaLui, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nutXoaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nutTienToi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nutXoaLui, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nutXoaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nutTienToi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPower, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFactorial, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToggleAngleUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteLine, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCot, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToggleTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseFont, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseColor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nutPaste, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nutCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEqual, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


//    private double evaluateBasicExpression(String expression) throws Exception {
//        double k = 0;
//        if (expression.contains("^")) {
//            String[] parts = expression.split("\\^");
//            double base = Double.parseDouble(parts[0]);
//            double exponent = Double.parseDouble(parts[1]);
//            k = Math.pow(base, exponent);
//        } else if (expression.contains("√")) {
//            String numberStr = expression.replace("√", "");
//            double number = Double.parseDouble(numberStr);
//            k = Math.sqrt(number);
//        } else if (expression.contains("%")) {
//            String numberStr = expression.replace("%", "");
//            double number = Double.parseDouble(numberStr);
//            k = number * 0.01;
//        } else if (expression.contains("+")) {
//            String[] parts = expression.split("\\+");
//            k = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
//        } else if (expression.contains("-")) {
//            String[] parts = expression.split("-");
//            k = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
//        } else if (expression.contains("*")) {
//            String[] parts = expression.split("\\*");
//            k = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
//        } else if (expression.contains("/")) {
//            String[] parts = expression.split("/");
//            if (Double.parseDouble(parts[1]) == 0) {
//                throw new ArithmeticException("Không thể chia cho 0");
//            }
//            k = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
//        } else if (expression.contains("ln(")) {
//            expression = expression.replace("ln(", "").replace(")", "");
//            double number = Double.parseDouble(expression);
//            k = Math.log(number);
//        } else if (expression.contains("log(")) {
//            expression = expression.replace("log(", "").replace(")", "");
//            double number = Double.parseDouble(expression);
//            k = Math.log10(number);
//        } else if (expression.contains("sin(")) {
//            expression = expression.replace("sin(", "").replace(")", "");
//            double number = Double.parseDouble(expression);
//            k = Math.sin(isDegree ? Math.toRadians(number) : number);
//        } else if (expression.contains("cos(")) {
//            expression = expression.replace("cos(", "").replace(")", "");
//            double number = Double.parseDouble(expression);
//            k = Math.cos(isDegree ? Math.toRadians(number) : number);
//        } else if (expression.contains("tan(")) {
//            expression = expression.replace("tan(", "").replace(")", "");
//            double number = Double.parseDouble(expression);
//            k = Math.tan(isDegree ? Math.toRadians(number) : number);
//        } else if (expression.contains("cot(")) {
//            expression = expression.replace("cot(", "").replace(")", "");
//            double number = Double.parseDouble(expression);
//            k = 1.0 / Math.tan(isDegree ? Math.toRadians(number) : number);
//        } else if (expression.contains("!")) {
//            expression = expression.replace("!", "");
//            int number = Integer.parseInt(expression);
//            int result = 1;
//            for (int i = 1; i <= number; i++) {
//                result *= i;
//            }
//            k = result;
//        } else {
//            throw new ArithmeticException("Biểu thức không hợp lệ");
//        }
//
//        return k;
//    }
private double evaluateBasicExpression(String expression) throws Exception {
    // Chuyển √ → sqrt, cot → 1/tan
    expression = expression.replace("√", "sqrt");
    expression = expression.replaceAll("cot\\(([^)]+)\\)", "1/tan($1)");

    // Nếu đang bật chế độ Degree (chuyển sang radian)
    if (isDegree) {
        expression = expression.replaceAll("sin\\(([^)]+)\\)", "sin(toRad($1))")
                               .replaceAll("cos\\(([^)]+)\\)", "cos(toRad($1))")
                               .replaceAll("tan\\(([^)]+)\\)", "tan(toRad($1))");

        Expression exp = new ExpressionBuilder(expression)
            .functions(new net.objecthunter.exp4j.function.Function("toRad", 1) {
                @Override
                public double apply(double... args) {
                    return Math.toRadians(args[0]);
                }
            })
            .build();

        return exp.evaluate();
    } else {
        Expression exp = new ExpressionBuilder(expression).build();
        return exp.evaluate();
    }
}
    
     private boolean isDegree = true; 

    private void saveHistory() {
        try {
            String historyText = history.toString();
            JOptionPane.showMessageDialog(this, "Đã lưu:\n" + historyText);
            historyArea.setText(historyText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error.");
        }
    }
   
    private void saveHistoryToFile() {
        try {
            File file = new File("history.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(history.toString());
            writer.close();
            Desktop.getDesktop().open(file);

            JOptionPane.showMessageDialog(this, "✅ Đã lưu lịch sử vào file TanHao.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "❌ Lỗi khi lưu lịch sử: " + e.getMessage());
        }
    }

    private void updateUITheme() {
        Color bg = isDarkMode ? Color.DARK_GRAY : selectedBgColor;
        Color fg = isDarkMode ? Color.WHITE : selectedFgColor;

        getContentPane().setBackground(bg);

        for (Component c : getContentPane().getComponents()) {
            c.setForeground(fg);
            c.setBackground(bg);
            c.setFont(selectedFont);
            if (c instanceof JPanel) {
                for (Component sub : ((JPanel) c).getComponents()) {
                    sub.setForeground(fg);
                    sub.setBackground(bg);
                    sub.setFont(selectedFont);
                }
            }
        }
        repaint();
    }

    private void txtDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisplayActionPerformed

    }//GEN-LAST:event_txtDisplayActionPerformed

    private void btnBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackspaceActionPerformed
        String currentText = txtDisplay.getText();
        if (currentText.length() > 0) {
            txtDisplay.setText(currentText.substring(0, currentText.length() - 1));
        }
    }//GEN-LAST:event_btnBackspaceActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveHistory();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        JOptionPane.showMessageDialog(this, "Lịch sử:\n" + history.toString());
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowerActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "^");
    }//GEN-LAST:event_btnPowerActionPerformed

    private void btnSqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSqrtActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "√");
    }//GEN-LAST:event_btnSqrtActionPerformed

    private void btnMultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplyActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "*");
    }//GEN-LAST:event_btnMultiplyActionPerformed

    private void btnSubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubtractActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "-");
    }//GEN-LAST:event_btnSubtractActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotActionPerformed
        txtDisplay.setText(txtDisplay.getText() + ".");
    }//GEN-LAST:event_btnDotActionPerformed

    private void btnDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivideActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "/");
    }//GEN-LAST:event_btnDivideActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "+");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualActionPerformed
        try {
        String expression = txtDisplay.getText();
        double k = evaluateBasicExpression(expression);
        txtDisplay.setText(String.valueOf(k));

        // Lưu lịch sử
        history.append(expression + " = " + k + "\n");
        historyArea.setText(history.toString());

    } catch (Exception ex) {
        txtDisplay.setText("Error");
    }

    }//GEN-LAST:event_btnEqualActionPerformed

    private void btnPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPercentActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "%");
    }//GEN-LAST:event_btnPercentActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtDisplay.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFactorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactorialActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "!");
    }//GEN-LAST:event_btnFactorialActionPerformed

    private void btnLnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLnActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "ln(");
    }//GEN-LAST:event_btnLnActionPerformed

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "log(");
    }//GEN-LAST:event_btnLogActionPerformed

    private void btnToggleAngleUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleAngleUnitActionPerformed
        isDegree = !isDegree;
        String mode = isDegree ? "Độ" : "Radian";
        JOptionPane.showMessageDialog(this, "Đã chuyển sang đơn vị: " + mode);
    }//GEN-LAST:event_btnToggleAngleUnitActionPerformed

    private void btnSearchHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHistoryActionPerformed
        String keyword = txtSearchHistory.getText().toLowerCase();
        String[] lines = history.toString().split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            if (line.toLowerCase().contains(keyword)) {
                result.append(line).append("\n");
            }
        }

        if (result.length() > 0) {
            JOptionPane.showMessageDialog(this, "Kết quả tìm kiếm:\n" + result.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy phép tính phù hợp.");
        }
    }//GEN-LAST:event_btnSearchHistoryActionPerformed

    private void btnTanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTanActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "tan(");
    }//GEN-LAST:event_btnTanActionPerformed

    private void btnCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "cot(");
    }//GEN-LAST:event_btnCotActionPerformed

    private void btnDeleteLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLineActionPerformed
        String selectedLine = JOptionPane.showInputDialog("Nhập dòng bạn muốn xóa:");

        if (selectedLine != null && !selectedLine.isEmpty()) {
            String[] lines = history.toString().split("\n");
            StringBuilder newHistory = new StringBuilder();

            for (String line : lines) {
                if (!line.trim().equals(selectedLine.trim())) {
                    newHistory.append(line).append("\n");
                }
            }
            history.setLength(0);
            history.append(newHistory);
            historyArea.setText(history.toString());

            JOptionPane.showMessageDialog(this, "Đã xóa dòng: " + selectedLine);
        }
    }//GEN-LAST:event_btnDeleteLineActionPerformed

    private void btnSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "sin(");
    }//GEN-LAST:event_btnSinActionPerformed

    private void btnCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCosActionPerformed
        txtDisplay.setText(txtDisplay.getText() + "cos(");
    }//GEN-LAST:event_btnCosActionPerformed

    private void btnChooseColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseColorActionPerformed
        selectedBgColor = JColorChooser.showDialog(this, "Chọn màu nền", selectedBgColor);
        selectedFgColor = JColorChooser.showDialog(this, "Chọn màu chữ", selectedFgColor);
        updateUITheme();
    }//GEN-LAST:event_btnChooseColorActionPerformed

    private void btnSaveHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveHistoryActionPerformed
        saveHistoryToFile();
    }//GEN-LAST:event_btnSaveHistoryActionPerformed

    private void btnChooseFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFontActionPerformed
        Font newFont = FontChooserDialog.showDialog(this, selectedFont);
        if (newFont != null) {
            selectedFont = newFont;
            updateUITheme();
        }
    }//GEN-LAST:event_btnChooseFontActionPerformed

    private void btnToggleThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleThemeActionPerformed
        isDarkMode = !isDarkMode;
        updateUITheme();
    }//GEN-LAST:event_btnToggleThemeActionPerformed

    private void nutXoaLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutXoaLuiActionPerformed
        txtDisplay.requestFocus();
        int viTri = txtDisplay.getCaretPosition();
        if (viTri > 0) {
            txtDisplay.setCaretPosition(viTri - 1);
        }
    }//GEN-LAST:event_nutXoaLuiActionPerformed

    private void nutXoaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutXoaNhapActionPerformed
        String hienTai = txtDisplay.getText();
        int viTri = Math.max(
                Math.max(hienTai.lastIndexOf("+"), hienTai.lastIndexOf("-")),
                Math.max(hienTai.lastIndexOf("*"), hienTai.lastIndexOf("/"))
        );

        if (viTri != -1) {
            String moi = hienTai.substring(0, viTri + 1);
            txtDisplay.setText(moi);
        } else {
            txtDisplay.setText("");
        }
    }//GEN-LAST:event_nutXoaNhapActionPerformed

    private void nutTienToiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutTienToiActionPerformed
        txtDisplay.requestFocus();  // đảm bảo có focus mới thấy con trỏ
        int viTri = txtDisplay.getCaretPosition();
        if (viTri < txtDisplay.getText().length()) {
            txtDisplay.setCaretPosition(viTri + 1);
        }
    }//GEN-LAST:event_nutTienToiActionPerformed

    private void nutPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutPasteActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String noiDung = (String) clipboard.getData(DataFlavor.stringFlavor);
            txtDisplay.setText(txtDisplay.getText() + noiDung);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nutPasteActionPerformed

    private void nutCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutCopyActionPerformed
        String vanBan = txtDisplay.getText();
        StringSelection luaChon = new StringSelection(vanBan);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(luaChon, null);
    }//GEN-LAST:event_nutCopyActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new may_tinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackspace;
    private javax.swing.JButton btnChooseColor;
    private javax.swing.JButton btnChooseFont;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCos;
    private javax.swing.JButton btnCot;
    private javax.swing.JButton btnDeleteLine;
    private javax.swing.JButton btnDivide;
    private javax.swing.JButton btnDot;
    private javax.swing.JButton btnEqual;
    private javax.swing.JButton btnFactorial;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnLn;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnMultiply;
    private javax.swing.JButton btnPercent;
    private javax.swing.JButton btnPower;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveHistory;
    private javax.swing.JButton btnSearchHistory;
    private javax.swing.JButton btnSin;
    private javax.swing.JButton btnSqrt;
    private javax.swing.JButton btnSubtract;
    private javax.swing.JButton btnTan;
    private javax.swing.JButton btnToggleAngleUnit;
    private javax.swing.JButton btnToggleTheme;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nutCopy;
    private javax.swing.JButton nutPaste;
    private javax.swing.JButton nutTienToi;
    private javax.swing.JButton nutXoaLui;
    private javax.swing.JButton nutXoaNhap;
    private javax.swing.JTextField txtDisplay;
    private javax.swing.JTextField txtSearchHistory;
    // End of variables declaration//GEN-END:variables

    private double evaluateExpression(String expression) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
