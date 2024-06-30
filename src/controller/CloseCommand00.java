package controller;

import utils.Console00;


public class CloseCommand00 implements Command00 {
    @Override
    public void load() {
        Console00.println("退出成功");
        System.exit(-1);
    }

    @Override
    public String getName() {
        return "退出系统";
    }

    @Override
    public String type() {
        return "3";
    }
}
