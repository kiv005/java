class SemesterAssignement1 {
 public static int simulate() {
  // Resetting steps and position at the start of each iteration.
  int steps = 0;
  int x = 5;
  int y = 5;

  while ((x > 0) && (x <= 10) && (y > 0) && (y <= 10)) { // Perform a move action while he is on the island and stop when he falls off.
   int direction = (int)(Math.random() * 4); // Create a random integer in order to simulate directions.
   steps++;

   switch (direction) {
    case (0): --x; break;
    case (1): ++x; break;
    case (2): --y; break;
    case (3): ++y; break;
   }
  }
  return steps;
 }

 
 public static void main(String[] args) {
  double totalSteps = 0, average = 0;

  final int ITERATIONS = 100000;
  for (int i = 0; i < ITERATIONS; i++) {
   totalSteps += simulate(); // Keep track of total steps walked.
  }
  
  average = (totalSteps / ITERATIONS);
  System.out.println("Jack dies after " + average + " steps on average.");
 }
}