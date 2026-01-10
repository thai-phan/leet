package cHard.grahp;

import java.util.*;

public class ReconstrucItinerary {
  public class Edge {
    String from;
    String to;
    Integer id;

    public Edge(String from, String to, Integer id) {
      this.from = from;
      this.to = to;
      this.id = id;
    }
  }

  public static void main(String[] args) {
    ReconstrucItinerary solution = new ReconstrucItinerary();
    List<List<String>> tickets = new ArrayList<>();
    tickets.add(Arrays.asList("JFK", "ATL"));
    tickets.add(Arrays.asList("JFK", "SFO"));
    tickets.add(Arrays.asList("JFK", "CHI"));
    tickets.add(Arrays.asList("ATL", "JFK"));
    tickets.add(Arrays.asList("ATL", "SFO"));
    tickets.add(Arrays.asList("SFO", "ATL"));
    tickets.add(Arrays.asList("SFO", "JFK"));
    tickets.add(Arrays.asList("CHI", "TEX"));
    List<String> itinerary = solution.findItinerary(tickets);
    System.out.println("Itinerary: " + itinerary);
  }

  Map<String, List<Edge>> map;
  boolean[] visitedEdge;
  int totalTicket;
  List<String> out;

  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    for (List<String> ticket : tickets) {
      targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
    }
    List<String> route = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    stack.push("JFK");

    while (!stack.empty()) {
      System.out.println("Out Stack peek: " + stack.peek());
      while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
        System.out.println("In Stack peek: " + stack.peek());
        String peek = stack.peek();
        String nextDest = targets.get(peek).poll();
        System.out.println("Next Dest: " + nextDest);
        stack.push(nextDest);
        System.out.println("Stack after push: " + stack);
      }
      System.out.println("Route add first: " + stack.peek());

      route.addFirst(stack.pop());
      System.out.println("Stack after pop: " + stack);
    }
    return route;
  }

  public List<String> findItineraryT(List<List<String>> tickets) {
    totalTicket = tickets.size();
    visitedEdge = new boolean[tickets.size()];
    out = new ArrayList<>();

    map = new HashMap<>();
    for (int i = 0; i < tickets.size(); i++) {
      String from = tickets.get(i).get(0);
      String to = tickets.get(i).get(1);
      map.putIfAbsent(from, new ArrayList<>());
      map.get(from).add(new Edge(from, to, i));
    }

    for (String key : map.keySet()) {
      List<Edge> edges = map.get(key);
      edges.sort(Comparator.comparing(edge -> edge.to));
    }


    Stack<Edge> stack = new Stack<>();

    for (Edge edge : map.get("JFK")) {
      stack.push(edge);
    }

    out.add("JFK");

    while (!stack.isEmpty()) {
      Edge edge = stack.pop();
      out.add(edge.to);



      for (Edge nextEdge : map.get(edge.to)) {
        if (!visitedEdge[nextEdge.id]) {


          String edgeTo = edge.to;
          int edgeId = edge.id;
          visitedEdge[edgeId] = true;

//          stack.push(edgeTo);

//          dfs(edgeTo, size + 1, list);
          visitedEdge[edgeId] = false;

        }
      }
      out.removeLast();


    }

//    out.add("JFK");
//    dfs("JFK", 0, new ArrayList<>());

    return out;
  }

  public void dfs(String name, int size, List<String> list) {
    if (size == totalTicket) {
      out.addAll(list);
      return;
    }

    if (!map.containsKey(name)) {
      return;
    }

    for (Edge edge : map.get(name)) {
      if (!visitedEdge[edge.id]) {
        String edgeTo = edge.to;
        int edgeId = edge.id;
        list.add(edge.to);
        visitedEdge[edgeId] = true;
        dfs(edgeTo, size + 1, list);
        visitedEdge[edgeId] = false;
        list.removeLast();
      }
    }
  }
}
