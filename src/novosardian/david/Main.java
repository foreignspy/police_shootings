package novosardian.david;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args)
    {
        Scanner policeList = null;
        try
        {
            policeList = new Scanner(new File("WaPo-fatal-police-shootings-data.csv"));
        }
        catch (Exception ex)
        {
            System.err.println("It appears that file doesn't exist");
            System.exit(0);
        }


        ArrayList<String> errors = new ArrayList<>();

        int lineNumber = 0;

        ArrayList<killedPerson> persons = new ArrayList<>();

        HashMap<String, Integer> byState = new HashMap<>();
        HashMap<String, Integer> byRace = new HashMap<>();

        String line = "";

        policeList.nextLine();
        while (policeList.hasNext())
        {
            lineNumber +=1;

            line = policeList.nextLine().trim();

            killedPerson kP = null;
            try
            {
                kP = new killedPerson(line);
                persons.add(kP);
            }
            catch (Exception ex)
            {
                if (ex.getMessage().equals("That's an empty line"))
                {
                    continue;
                }
                else
                {
                    errors.add(String.format("%s on line %d", ex.getMessage(), lineNumber));
                }
            }
        }

        policeList.close();

        int male = 0;
        int female =0;

        for (killedPerson currentPerson : persons)
        {
            if (byState.containsKey(currentPerson.getState()))
            {
                int personCount = byState.get(currentPerson.getState());

                byState.put(currentPerson.getState(), personCount + 1);
            }
            else
            {
                byState.put(currentPerson.getState(), 1);
            }

            if (byRace.containsKey(currentPerson.getRace()))
            {
                int personCount = byRace.get(currentPerson.getRace());

                byRace.put(currentPerson.getRace(), personCount + 1);
            }
            else
            {
                byRace.put(currentPerson.getRace(), 1);
            }

            if(currentPerson.getGender().equals("M"))
            {
                male++;
            }
            else
            {
                female++;
            }
        }

        TreeMap<String, Integer> sortedStates = new TreeMap<>(byState);
        System.out.println("\nState | Fatalities");
        for (String state : sortedStates.keySet())
        {
            int count =  sortedStates.get(state);

            System.out.println(String.format("%s      %d", state, count));
        }

        TreeMap<String, Integer> sortedRaces = new TreeMap<>(byRace);
        System.out.println("\nRace | Fatalities");
        for (String race : sortedRaces.keySet())
        {
            int count =  sortedRaces.get(race);

            if (race.equals("") )
            {
                System.out.println(String.format("%s  %d", "Unknown", count));
            }
            else
            {
                System.out.println(String.format("%s      %d", race, count));
            }
        }

        System.out.println("\nGender | Fatalities\n" + "Male\t" + male + "\n" +
                "Female\t" + female);


        if(errors.size() > 0)
        {
            for(String e : errors)
            {
                System.err.println(e);
            }
        }

    }
}
