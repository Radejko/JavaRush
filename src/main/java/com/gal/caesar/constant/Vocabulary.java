package com.gal.caesar.constant;

import java.util.HashMap;
import java.util.Map;

public final class Vocabulary {
    public static final String ALPHABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,«»\"\':!? „”АБВГҐДЕЄЖЗІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯабвгґдеєжзіїйклмнопрстуфхцчшщьюяЫЪЁЭЎыъёэўĀĂĄÃÄÅÆÀÁÂŴĖĒĔĘĚÉÈÊŖŔŘŦŢÞŤĲŶÝŸŲŮŰŪÜŨŬÚÙÛĮĬĪĨÎÍÌŒŐŎŌØÖÕÔÓÒŞŠŚŜĐĎÐĢĞĜĠĤĴĶŁĿĽĻĹŻŹŽČĈĊĆÇŊŇŃÑŅāăąãäåæàáâŵėēĕęěéèêŗŕřŧţþťĳŷýÿųůűūüũŭúùûįĭīĩîíìœőŏōøöõôóòşšśŝđďðģğĝġĥĵķłŀľļĺżźžčĉċćçŋňŉńñņΔΘΛΞΣΨΩαβγδεζηθιλμνξπρσςτυφχωάέϋύΰΐϊίόήώ¿‽¡$€¢£¥₴₹";  // "," -> 54  " " -> 62

    public static final Map<Integer, Character> indexMap = new HashMap<>();
    public static final Map<Character, Integer> valueMap = new HashMap<>();

    static {
        var alphabet = ALPHABET.toCharArray();
        for (int i = 0; i < alphabet.length; i++) {
            indexMap.put(i, alphabet[i]);
            valueMap.put(alphabet[i], i);
        }
    }

    private Vocabulary() {
    }
}
