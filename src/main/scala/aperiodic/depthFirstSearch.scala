package aperiodic

object depthFirstSearch {

  type Vertex=Int
  type Graph=Map[Vertex,List[Vertex]]

  def DFS(start: Vertex, g: Graph): List[Vertex] = {

    def DFS0(v: Vertex, visited: List[Vertex]): List[Vertex] = {
      if (visited.contains(v))
        visited
      else {
        val neighbours:List[Vertex] = g(v) filterNot visited.contains
        neighbours.foldLeft(v :: visited)((b,a) => DFS0(a,b))
      }
    }
    DFS0(start,List()).reverse
  }
}
