package com.proyectoastah.xmiexport.ui;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class FileSelection {
    private static File lastDirectory = new File(System.getProperty("user.home"));

    private FileSelection() {
    }

    public static File selectXmiOutputFile(Component parent) {
        JFileChooser chooser = new JFileChooser(lastDirectory);
        chooser.setDialogTitle("Exportar XMI");
        chooser.setFileFilter(new FileNameExtensionFilter("XMI (*.xmi)", "xmi"));
        chooser.setSelectedFile(new File("proyect.xmi"));

        if (chooser.showSaveDialog(parent) != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        File selectedFile = ensureXmiExtension(chooser.getSelectedFile());
        if (selectedFile.exists()) {
            int answer = JOptionPane.showConfirmDialog(parent,
                    "El archivo ya existe. Deseas reemplazarlo?\n" + selectedFile.getAbsolutePath(),
                    "XMI Exporter", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (answer != JOptionPane.YES_OPTION) {
                return null;
            }
        }

        lastDirectory = selectedFile.getParentFile();
        return selectedFile;
    }

    private static File ensureXmiExtension(File file) {
        String path = file.getAbsolutePath();
        if (path.toLowerCase().endsWith(".xmi")) {
            return file;
        }
        return new File(path + ".xmi");
    }
}
