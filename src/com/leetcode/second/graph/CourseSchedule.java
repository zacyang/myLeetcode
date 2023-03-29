package com.leetcode.second.graph;

import java.util.*;

public class CourseSchedule {
    Map<Integer, List<Integer>> cache = new HashMap();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> currentCallStack = new HashSet<>();
            boolean anyCycle = anyCycle(i, prerequisites, visited, currentCallStack);
            if (anyCycle) {
                return false;
            }
        }
        return true;
    }

    private boolean anyCycle(int numCourses, int[][] prerequisites, Set<Integer> visited, Set<Integer> currentCallStack) {


        if (currentCallStack.contains(numCourses)) {
            return true;
        }

        if (visited.contains(numCourses)) {
            return false;
        }

        currentCallStack.add(numCourses);
        visited.add(numCourses);

        List<Integer> depdencyCourses = getDependency(prerequisites, numCourses);
        boolean containsCycle = depdencyCourses.stream().anyMatch(p -> anyCycle(p, prerequisites, visited, currentCallStack));

        currentCallStack.remove(numCourses);

        return containsCycle;
    }

    private List<Integer> getDependency(int[][] prerequisites, int targetCourse) {
        List<Integer> storedDependency = cache.get(targetCourse);
        if (storedDependency != null) {
            return storedDependency;
        } else {
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][0] == targetCourse) {
                    result.add(prerequisites[i][1]);
                }
            }
            cache.put(targetCourse, result);
            return result;
        }


    }

    public static void main(String[] args) {
//        System.out.println(new CourseSchedule().canFinish(2, new int[][]{new int[]{1, 0}}));
//        [[1,4],[2,4],[3,1],[3,2]]
        System.out.println(new CourseSchedule().canFinish(5, new int[][]{
                new int[]{1, 4},
                new int[]{2, 4},
                new int[]{3, 1},
                new int[]{3, 2}
        }));
    }
}
