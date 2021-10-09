package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_W2_MutualEval {
    static Character[] score = {'F', 'F', 'F', 'F', 'F', 'D', 'D', 'C', 'B', 'A', 'A'};
    public String solution(int[][] scores) {
        String answer = "";

        // 각 학생들이 받은 점수의 평균 -> 학점 부여
        // 자기 자신 평가 유일한! 최고점, 최저점 제외하고 평균
        int studentSize = scores.length;
        List<Student> psQ = new ArrayList<>();

        for(int i = 0; i < studentSize; i++) {
            int sum = 0;
            int myself = 0;
            double avg;
            int max = -1;
            int min = Integer.MAX_VALUE;
            int maxCount = 1;
            int minCount = 1;

            for(int j = 0; j < studentSize; j++) {
                if(i == j) {
                    myself = scores[j][i];
                } else {
                    sum += scores[j][i];
                }

                if(max == scores[j][i]) {
                    maxCount++;
                } else if (max < scores[j][i]) {
                    max = scores[j][i];
                    maxCount = 1;
                }

                if(min == scores[j][i]) {
                    minCount++;
                } else if (min > scores[j][i]) {
                    min = scores[j][i];
                    minCount = 1;
                }
            }

            if(myself == max && maxCount == 1) {
                avg = sum / (studentSize - 1);
                psQ.add(new Student(i, avg));
                continue;
            }

            if(myself == min && minCount == 1) {
                avg = sum / (studentSize - 1);
                psQ.add(new Student(i, avg));
                continue;
            }

            sum += myself;
            avg = sum / (studentSize);

            psQ.add(new Student(i, avg));
        }

        char[] studentScores = new char[studentSize];
        for(int i = 0; i < studentSize; i++) {
            Student temp = psQ.get(i);
            int scoreCheck = (int)(temp.average / 10);
            System.out.println(temp.average);
            studentScores[temp.order] = score[scoreCheck];
        }

        answer = String.valueOf(studentScores);
        return answer;
    }

    static class Student {
        int order;
        double average;

        Student(int order, double average) {
            this.order = order;
            this.average = average;
        }
    }
}
