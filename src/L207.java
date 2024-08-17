import java.util.ArrayList;
import java.util.List;

public class L207 {
    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     *
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     *
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        L207 l207 = new L207();
        System.out.println(l207.canFinish(numCourses, prerequisites));

    }
    /**
     * 判断是否可以完成所有课程
     *
     * @param numCourses 课程总数
     * @param prerequisites 课程的先决条件数组，prerequisites[i] = [ai, bi] 表示在学习课程 ai 之前需要先完成课程 bi
     * @return 如果可以完成所有课程返回true，否则返回false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 计算每个节点的入度
        int[] inDegree = new int[numCourses];
        // 创建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 构建课程的依赖关系图
        for (int[] prerequisite : prerequisites) {
            // 添加依赖关系
            graph.get(prerequisite[1]).add(prerequisite[0]);
            // 计算每个节点的入度
            inDegree[prerequisite[0]]++;
        }
        // 记录已经完成的课程数量
        int count = 0;
        // 循环直到所有课程都被完成
        while (count < numCourses) {
            // 标记是否存在入度为0的课程
            boolean hasZeroInDegree = false;
            // 遍历所有课程
            for (int i = 0; i < numCourses; i++) {
                // 如果找到入度为0的课程
                if (inDegree[i] == 0) {
                    // 标记存在入度为0的课程
                    hasZeroInDegree = true;
                    // 将该课程的入度减1，表示已经完成
                    inDegree[i]--;
                    // 增加完成的课程数量
                    count++;
                    // 遍历该课程的所有后续课程，减少它们的入度
                    for (int j = 0; j < graph.get(i).size(); j++) {
                        inDegree[graph.get(i).get(j)]--;
                    }
                }
            }
            // 如果不存在入度为0的课程，说明存在循环依赖，无法完成所有课程
            if (!hasZeroInDegree) {
                return false;
            }
        }
        // 如果完成的课程数量等于总课程数量，说明可以完成所有课程
        return count == numCourses;
    }

}
