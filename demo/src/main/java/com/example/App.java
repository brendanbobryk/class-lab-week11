package com.example;

import com.google.gson.Gson;
import java.util.*;

public class App {

    private static String dataFilePath = "C:/Users/Brendan/Documents/GitHub/class-lab-week11/demo/src/main/java/com/example/riverData.json";

    public static TestOutput process(TestInput input) {
        String river = input.river;
        char[] water = input.water;
        char[] elements = input.elements;

        TestOutput answer = new TestOutput();

        HashMap<Character, Integer> waterElementsCount = new HashMap<>();

        // count occurrences of elements in the water
        for (char element : water) {
            waterElementsCount.put(element, waterElementsCount.getOrDefault(element, 0) + 1);
        }

        // check if all elements are in the water
        for (char element : elements) {
            if (!waterElementsCount.containsKey(element) || waterElementsCount.get(element) == 0) {
                // return answer if the river does not have gold
                answer.hasGold = false;
                return answer;
            }
            waterElementsCount.put(element, waterElementsCount.get(element) - 1);
        }

        // return the answer if the river has gold
        answer.hasGold = true;
        return answer;

    }

    public static void main(String[] args) {
        LabTestData td = new LabTestData();

        // read data
        String jsonStr = td.readJSON(dataFilePath);

        // convert data to obj
        Gson gson = new Gson();
        LabTestData testData = gson.fromJson(jsonStr, LabTestData.class);

        // run each test
        int pass = 0;
        int fail = 0;
        for (int i = 0; i < testData.tests.length; i += 1) {
            TestInput input = testData.tests[i].input;

            TestOutput answer = process(input);

            // get correct answer
            TestOutput correctAnswer = testData.tests[i].output;

            System.out.printf("\n");

            // if answer is correct, report results
            if ((answer.hasGold == correctAnswer.hasGold)) {
                System.out.printf("--------------------------------------\n");
                System.out.printf("PASSED test %d :\n", i);
                System.out.printf("--------------------------------------\n\n");
                pass += 1;
                // if answer is incorrect, report the error
            } else {
                System.out.printf("--------------------------------------\n");
                System.out.printf("FAILED test %d\n", i);
                System.out.printf("--------------------------------------\n\n");
                fail += 1;
            }

            // print input
            System.out.printf("input:\n");
            System.out.println(input);

            // print answer and correct answer
            System.out.printf("your answer:\n");
            System.out.println(answer);
            System.out.printf("correct answer:\n");
            System.out.println(correctAnswer);

            System.out.printf("--------------------------------------\n\n");
        }
        System.out.printf("--------------------------------------\n");
        System.out.printf("PASSED %d TESTS\n", pass);
        System.out.printf("FAILED %d TESTS\n", fail);
        System.out.printf(
                "%d%% pass rate\n",
                (int) (((float) pass / (float) (pass + fail) * 100.0f)));

        System.out.printf("--------------------------------------\n\n");
    }
}
