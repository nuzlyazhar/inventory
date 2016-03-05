/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author nuzly
 */
public class InventoryUtils {

    public static boolean isEmpty(String value) {
        return (null == value || "".equals(value));
    }

    public static boolean isNotEmpty(String value) {
        return (null != value && !"".equals(value));
    }

}
