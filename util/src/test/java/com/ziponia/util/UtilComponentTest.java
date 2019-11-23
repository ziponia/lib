package com.ziponia.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UtilComponentTest {

    @Test
    public void percentage() {

        int isTrue = 0;
        int isFalse = 0;
        for (int i = 0; i < 100; i++) {
            boolean a = UtilComponent.percentage(5.5);

            if (a)
                isTrue++;
            else
                isFalse++;
        }

        System.out.println("True: " + isTrue);
        System.out.println("False: " + isFalse);
    }

    @Test
    public void drawObject() {
        PercentageList<String> persons = new PercentageList<String>();

        String a1 = "이지훈";
        String a2 = "이정엽";
        String a3 = "김우곤";
        String a4 = "오성범";

        persons.add(a1, 20);
        persons.add(a2, 10);
        persons.add(a3, 5);
        persons.add(a4, 50);

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (int i = 0; i < 10000; i++) {
            String person = persons.get();
            if (person.equals("이지훈")) {
                a++;
            } else if (person.equals("이정엽")) {
                b++;
            } else if (person.equals("김우곤")) {
                c++;
            } else if (person.equals("오성범")) {
                d++;
            }
        }

        System.out.println("이지훈: " + a);
        System.out.println("이정엽: " + b);
        System.out.println("김우곤: " + c);
        System.out.println("오성범: " + d);

        /*
          ===================================
          Difference .get() and .draw()
          ===================================
         */

        while (!persons.isEmpty()) {
            String person = persons.draw();
            if (person.equals("이지훈")) {
                a++;
            } else if (person.equals("이정엽")) {
                b++;
            } else if (person.equals("김우곤")) {
                c++;
            } else if (person.equals("오성범")) {
                d++;
            }
        }

        System.out.println("이지훈: " + a);
        System.out.println("이정엽: " + b);
        System.out.println("김우곤: " + c);
        System.out.println("오성범: " + d);
    }
}