package com.leetcode.second.dailyc;

import java.util.HashSet;
import java.util.Set;

public class BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {

//        Set<Integer> idexOfConflicts = findConflic(scores, ages, 0);

        int solutionOfPickingCurrent = pickTeamOtherThan(scores, ages, 1, new HashSet<>());

        int solutionOfPickingOther = pickTeamOtherThan(scores, ages, 0, new HashSet<>());

        return Math.max(solutionOfPickingCurrent, solutionOfPickingOther);
    }

    private int pickTeamOtherThan(int[] scores, int[] ages, int i, Set<Integer> idexOfConflicts) {
        if (i + 1 > ages.length) {
            return 0;
        }
        Set<Integer> currentConflicts = findConflic(scores, ages, i);
        idexOfConflicts.addAll(currentConflicts);

        if (idexOfConflicts.contains(i)) {

            return pickTeamOtherThan(scores, ages, i + 1, idexOfConflicts);
        }

        return scores[i] + pickTeamOtherThan(scores, ages, i + 1, idexOfConflicts);
    }

    private Set<Integer> findConflic(int[] scores, int[] ages, int examingIdx) {
        Set<Integer> result = new HashSet<>();
        for (int i1 = 0; i1 < ages.length; i1++) {
            if (isConflict(scores, ages, examingIdx, i1)) {
                result.add(i1);
            }
        }
        return result;
    }

    private boolean isConflict(int[] scores, int[] ages, int examingIdx, int i1) {
        return (scores[examingIdx] > scores[i1] && ages[examingIdx] < ages[i1]) || ( scores[i1] > scores[examingIdx]  && ages[i1]> ages[examingIdx] );
    }

    public static void main(String[] args) {
//        int i = new BestTeamWithNoConflicts().bestTeamScore(new int[]{
//                        1, 3, 5, 10, 15
//                },
//                new int[]{
//                        1, 2, 3, 4, 5
//                });

        int i = new BestTeamWithNoConflicts().bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1});
        System.out.println(i);
    }
}
