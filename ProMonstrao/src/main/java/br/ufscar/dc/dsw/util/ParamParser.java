package br.ufscar.dc.dsw.util;

public class ParamParser {
    public static Long parseLong(String param) {
        if (param == null || param.isEmpty()) {
            return null;
        }
        try {
            return Long.parseLong(param);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
