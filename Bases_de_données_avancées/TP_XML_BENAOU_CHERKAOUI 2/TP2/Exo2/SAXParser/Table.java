/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author Mohammed
 */
public class Table {

    private String name;
    private ArrayList<String> columnNames;
    private ArrayList<ArrayList<String>> cellValues;
    /**
     * Cree une table avec un nom
     *
     * @param name nom de la table
     */
    public Table(String name) {
        this.name = name;
        this.columnNames = new ArrayList<String>();
        this.cellValues = new ArrayList<ArrayList<String>>();
    }

    /**
     * Ajoute un nom de colonne a la table
     *
     * @param name nom de la colonne
     */
    public void addColumnName(String name) {
        this.getColumnNames().add(name);
    }

    /**
     * Ajoute une ligne de valeurs (cellules).
     *
     * @param values valeurs des cellules
     */
    public void addCellValues(ArrayList<String> values) {
        this.getCellValues().add(values);
    }

    /**
     * Permet d'afficher le contenu de la table
     *
     * @return une chaine de carateres contenant la representation textuelle de
     * la table.
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        Formatter formatter = new Formatter(result, Locale.FRANCE);
        formatter.format("%-10s%n", getName());
        for (String s : this.getColumnNames()) {
            formatter.format("%-20s", s);
        }
        formatter.format("%n", "");
        for (ArrayList<String> as : this.getCellValues()) {
            for (String s : as) {
                formatter.format("%-20s", s);
            }
            formatter.format("%n", "");
        }

        return result.toString();
    }

    /**
     * Retourne le nom de la table.
     *
     * @return nom de la table
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retourne les noms de colonnes de la table
     *
     * @return noms des colonnes
     */
    public ArrayList<String> getColumnNames() {
        return this.columnNames;
    }

    /**
     * Retourne le contenu d'une ligne de la table
     *
     * @return valeurs des cellules d'une ligne
     */
    public ArrayList<ArrayList<String>> getCellValues() {
        return this.cellValues;
    }
}
