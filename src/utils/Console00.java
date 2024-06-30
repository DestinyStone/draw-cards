package utils;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Console00 {

    private static final String DEFAULT_BLANK_WARNING = "不允许为空， 请重新输入";
    private static final String DEFAULT_FORMAT_WARNING = "不支持的格式， 请重新输入";

    private static Scanner scanner = new Scanner(System.in);

    private static String read(String label) {
        print(label);
        return scanner.nextLine();
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }


    public static String keyInputMenu(String label, boolean accessBlank, String... menu) {
        return keyInputMenu(label, accessBlank, Arrays.stream(menu).collect(Collectors.toList()));
    }

    public static String keyInputMenu(String label, boolean accessBlank, Collection<String> menu) {
        String read = read(label);
        if (StrUtil.isNotBlank(read)) {
            long count = menu.stream().filter(item -> {
                return Objects.equals(item, read);
            }).count();
            if (count <= 0) {
                println(DEFAULT_FORMAT_WARNING);
                return keyInputMenu(label, accessBlank, menu);
            }
            return read;
        }
        if (!accessBlank) {
            println(DEFAULT_BLANK_WARNING);
            return keyInputMenu(label, false);
        }
        return null;
    }

    public static String keyInputString(String label) {
        return keyInputString(label, false);
    }

    public static String keyInputString(String label, boolean accessBlank) {
        String read = read(label);
        if (StrUtil.isNotBlank(read)) {
            return read;
        }
        if (!accessBlank) {
            println(DEFAULT_BLANK_WARNING);
            return keyInputString(label, false);
        }
        return null;
    }


}
