//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package net.sqlitetutorial;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
    public Fenetre() {
        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static class TableDemo extends JPanel {
        private boolean DEBUG = false;

        public TableDemo() {
            JTable table = new JTable(new TableDemo.MyTableModel());
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
            table.setFillsViewportHeight(true);
            new JScrollPane(table);
        }

        class MyTableModel extends AbstractTableModel {
            private String[] columnNames = new String[]{"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};
            private Object[][] data = new Object[][]{{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)}, {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)}, {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)}, {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)}, {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}};

            MyTableModel() {
            }

            public int getColumnCount() {
                return this.columnNames.length;
            }

            public int getRowCount() {
                return this.data.length;
            }

            public String getColumnName(int col) {
                return this.columnNames[col];
            }

            public Object getValueAt(int row, int col) {
                return this.data[row][col];
            }

            public Class getColumnClass(int c) {
                return this.getValueAt(0, c).getClass();
            }

            public boolean isCellEditable(int row, int col) {
                return col >= 2;
            }

            public void setValueAt(Object value, int row, int col) {
                if (TableDemo.this.DEBUG) {
                    System.out.println("Setting value at " + row + "," + col + " to " + value + " (an instance of " + value.getClass() + ")");
                }

                this.data[row][col] = value;
                this.fireTableCellUpdated(row, col);
                if (TableDemo.this.DEBUG) {
                    System.out.println("New value of data:");
                    this.printDebugData();
                }

            }

            private void printDebugData() {
                int numRows = this.getRowCount();
                int numCols = this.getColumnCount();

                for (int i = 0; i < numRows; ++i) {
                    System.out.print("    row " + i + ":");

                    for (int j = 0; j < numCols; ++j) {
                        System.out.print("  " + this.data[i][j]);
                    }

                    System.out.println();
                }

                System.out.println("--------------------------");
            }
        }


        public static void main(String[] args) {
            new Fenetre();


        }
    }
}

