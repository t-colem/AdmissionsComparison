import java.util.Scanner;
public class AdmissionsComparison {
    public static void main(String[] args){
        // Call the print introduction method
        printIntroduction();
        Scanner in = new Scanner(System.in);
        // Define the necessary variables needed for the program
        int count = 0;
        double totalScoreSAT,totalScoreACT,doGPA,computeSAT,computeACT,satCount,actCount;
        totalScoreSAT = 0;
        totalScoreACT = 0;
        satCount = 0;
        actCount = 0;
        // Define a new int, firstScoreType to figure out which score is entered first by the user, either SAT or ACT
        int firstScoreType = 0;
        // Since there is only need for two inputs from the user, we can use a while loop that's set to end after 2 counts to take the user input
        while(count < 2) {
            // Call the applicant method that prompts the user to input either 1 or 2 for an SAT or ACT score respectively
            double satOrAct = applicant("Do you have 1) SAT scores or 2) ACT scores?", in);
            // If the user enters 1 set satOrAct to 1 to indicate SAT
            if (satOrAct == 1) {
                // Set firstScoreType to 1 to indicate SAT if firstScoreType is still 0
                if (firstScoreType == 0) {
                    firstScoreType = 1;
                }
                // Call the methods to do the computation and set the doGPA and totalScoreSAT variables
                computeSAT = computeSAT(in);
                doGPA = computeGPA(in);
                totalScoreSAT = doGPA + computeSAT;
                // Increment count and satCount
                count++;
                satCount++;
            // If satOrAct = 2 which indicates an ACT score
            } else if (satOrAct == 2) {
                // Set firstScoreType to 2 to indicate ACT if firstScoreType is still 0
                if (firstScoreType == 0) {
                    firstScoreType = 2;
                }
                // Call the methods to do the computation and set the doGPA and totalScoreACT variables
                computeACT = computeACT(in);
                doGPA = computeGPA(in);
                totalScoreACT = doGPA + computeACT;
                // Increment count and actCount
                count++;
                actCount++;
            }
            // When count is equal to 1 after one go through of the loop, print a prompt for the user again
            if (count == 1){
                System.out.println("Information for the second applicant:");
            }

        }
        // Reporting the ACT results first if actCount is 1 and firstScoreType is 2
        if (actCount == 1 && firstScoreType == 2) {
            reportResults(totalScoreACT, totalScoreSAT);
        // Reporting both ACT results if actCount is 2
        } else if (actCount == 2) {
            reportResults(totalScoreACT, totalScoreACT);
        // Reporting the SAT results first if satCount is 1 and firstScoreType is 1
        } else if (satCount == 1 && firstScoreType == 1) {
            reportResults(totalScoreSAT, totalScoreACT);
        // Reporting both SAT results if satCount is 2
        } else if (satCount == 2) {
            reportResults(totalScoreSAT, totalScoreSAT);
        }
    }
    // Define a new void method that prints the introduction to the user
    public static void printIntroduction() {
        System.out.println("This program compares two applicants to determine which one seems like the stronger\n" +
                "applicant. For each candidate I will need either SAT or ACT scores plus a weighted GPA.");
        System.out.println("Information for the first applicant:");
    }
    // Define a new double method applicant that takes a string and a scanner input as arguments
    public static double applicant(String prompt, Scanner in){
        // Start by printing out the prompt then print out a blank line to follow it to add space
        System.out.print(prompt);
        System.out.println();
        // Set applicantType to the user input
        int applicantType = in.nextInt();
        // If the user enters 1 to indicate SAT return 1
        if(applicantType == 1){
            return 1;
        // If the user enters 2 to indicate ACT return 2
        }else if(applicantType == 2) {
            return 2;
        // If the user enters anything else return 0 and present an error prompt
        }else{
            System.out.println("Error, please enter a 1 or a 2 to indicate SAT or ACT respectively");
            return 0;
        }
    }
    // Define a new double method that computes the SAT score and takes a scanner input as an argument
    public static double computeSAT(Scanner in){
        // Prompt the user to enter SAT scores and set those to their respective variables
        System.out.println("Enter SAT Math score");
        int mathScore = in.nextInt();
        System.out.println("Enter SAT Verbal score");
        int verbalScore = in.nextInt();
        // Return a double value that does the necessary computation
        return ((verbalScore * 2.0) + mathScore) / 24;
    }
    // Define a new double method that computes the ACT score and takes a scanner input as an argument
    public static double computeACT(Scanner in){
        // Prompt the user to enter ACT scores and set those to their respective variables
        System.out.println("Enter ACT English score");
        int englishScore = in.nextInt();
        System.out.println("Enter ACT Math score");
        int mathScore = in.nextInt();
        System.out.println("Enter ACT Reading score");
        int readingScore = in.nextInt();
        System.out.println("Enter ACT Science score");
        int scienceScore = in.nextInt();
        // Return a double value that does the necessary computation
        return ((2.0 * readingScore) + englishScore + mathScore + scienceScore) / 1.8;
    }
    // Define a new double method that computes the GPA score and takes a scanner input as an argument
    public static double computeGPA(Scanner in){
        // Prompt the user to enter 2 GPA values and set those to their respective variables
        System.out.println("Enter your GPA");
        double currentGPA = in.nextDouble();
        System.out.println("Enter your maximum GPA");
        double maxGPA = in.nextDouble();
        // Return a double value that does the necessary computation
        return (currentGPA / maxGPA) * 100;
    }
    // Define a final void method that reports the results to the user and takes the applicantOne and applicantTwo scores as arguments
    public static void reportResults(double applicantOne, double applicantTwo){
        // Use a printf to format the scores for both applicants to 2 decimal places
        System.out.printf("\nFirst Applicant Overall Score = %.2f", applicantOne);
        System.out.printf("\nSecond Applicant Overall Score = %.2f\n", applicantTwo);
        // If applicantOne score is greater than applicantTwo score print the first applicant looks better
        if (applicantOne > applicantTwo) {
            System.out.println("The first applicant seems to be better");
        // If applicantTwo score is greater than applicantOne score print the first applicant looks better
        } else if (applicantOne < applicantTwo) {
            System.out.println("The second applicant seems to be better");
        // Otherwise, print that the scores seem to be equal to one another
        } else {
            System.out.println("The two applicants seem to be equal");
        }
    }
}