package com.advanced.practice6.decorator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Decorators {
    public static Logger logger = Logger.getLogger(Decorators.class.getSimpleName());

    static {
        try {
            Handler fh = new FileHandler("resources/advanced/practice6/prog.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
        List<String> list = new ArrayList<>();
        logger.log(Level.INFO, "Source list: " + sourceList.toString());

        for (int i = 0; i < sourceList.size(); i++) {
            if (i % 2 == 0)
                list.add(sourceList.get(i));
        }

        logger.log(Level.INFO, "Even index element sublist: " + list.toString());

        return list;
    }


}
