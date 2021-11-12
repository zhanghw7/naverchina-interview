package com.zhw.interview.naverchina.problems;

import java.util.*;

/**
 * @Description 问题一 拓扑排序
 * @Author Zhang Hongwei
 * @Date 2021/11/12 9:30
 */
public class Problem1 {

    public void topologicalSort(List<Task> tasks){
        Set<Task> visited = new HashSet<>();
        Deque<Task> finished = new LinkedList<>();
        for (Task task : tasks) {
            dfs(task, visited, finished);
        }
        while (!finished.isEmpty()){
            System.out.println(finished.pop());
        }
    }

    private void dfs(Task task, Set<Task> visited, Deque<Task> finished){
        if (task == null) return;
        if (task.nextTasks != null) {
            for (Task nextTask : task.nextTasks) {
                if (!visited.contains(nextTask)){
                    dfs(nextTask, visited, finished);
                }
            }
        }
        finished.push(task);
        visited.add(task);
    }


    public static class Task{
        char name;
        List<Task> nextTasks;

        public Task(char name) {
            this.name = name;
        }

        public Task(char name, List<Task> nextTasks) {
            this.name = name;
            this.nextTasks = nextTasks;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return name == task.name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Task " + this.name;
        }
    }

}
