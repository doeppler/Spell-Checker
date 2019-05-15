import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class InputOutput
{
    private File dictionaryFile;
    private Scanner reader;
    private String corpusFile;

    public InputOutput()
    {
        dictionaryFile = new File("dictionary.txt");
        reader = new Scanner(System.in);
        setCorpusFile(null);
        greetUser();
    }

    void setCorpusFile(String corpusFile)
    {
        this.corpusFile = corpusFile;
    }

    public String getCorpusFile()
    {
        return corpusFile;
    }

    void greetUser()
    {
        System.out.println("Welcome.");
    }


    void doesDictionaryExist(boolean state)
    {
        if(!state)
        {
            System.out.println("Dictionary file exists.");
        }
        else
        {
            System.out.println("Dictionary doesn't exist! Creating new dictionary.");
        }

    }

    void isDictionaryEmpty(boolean state)
    {
        if(state)
        {
            System.out.println("Dictionary file is empty.");
        }
        else
        {
            System.out.println("Dictionary file has content.");
        }
    }

    void setCorpus()
    {
        System.out.println("\nPlease enter a corpus file name. Example: \"corpus.txt\"");
        System.out.print("Corpus file name: ");
        String temp = reader.nextLine();

        if(!checkFileInput(temp))
        {
            System.out.println("Wrong input.");
            setCorpus();
        }
        else
        {
            setCorpusFile(temp);
        }
    }

    boolean checkFileInput(String input)
    {
        if(!input.contains(".txt")) return false;

        if(!input.substring(input.length()-4).equals(".txt"))
        {
            return false;
        }

        return true;
    }

    boolean isCorpusEmpty(boolean state)
    {
        if(state)
        {
            System.out.println("Corups file is empty!");
            return true;
        }
        return false;
    }

    boolean askToWipe()
    {
        System.out.print("Would you like to wipe the data on the dictionary file and start over? [y]: ");
        Scanner reader = new Scanner(System.in);

        var answer = reader.nextLine();
        answer.toLowerCase();
        if(answer.equals("y") || answer.equals("yes") || answer.equals("ye"))
        {
            System.out.println("Okay!");
            var dictionary = new Dictionary();
            dictionaryFile.delete();
            System.out.println("Task complete.");
            return true;
        }

        System.out.println("Okay.");
        return false;

    }

    public String getUserFile()
    {
        System.out.println("\nPlease enter a corpus file name. Example: \"check.txt\"");
        System.out.print("File name: ");
        String temp = reader.nextLine();

        if(!checkFileInput(temp))
        {
            System.out.println("Wrong input.");
            getUserFile();
        }
        else
        {
            System.out.println("Thank you.");
        }


        return temp;
    }

}
