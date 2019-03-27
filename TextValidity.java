
/**
 * Ckeck the validity of the user input text.
 *
 * @author Li Peiyao
 * @version (2019.03.27)
 */
public class TextValidity
{ 

    /**
     * Constructor for objects of class TextValidity
     */
    public TextValidity()
    {
        
    }

    /**
     * Test the validity of the format of the name text field.
     * @param input the input string from the user
     * @return if the format is correct
     */
    public boolean validName(String input)
    {
        String format = "[A-Za-z\\s]+"; 
        return input.matches(format);
    }
    
    /**
     * Test the validity of the format of the number text field.
     * @param input the input string from the user
     * @return if the format is correct
     */
    public boolean validNumber(String input)
    {
        String format = "[0-9\\s]+"; 
        return input.matches(format);
    }
    
    /**
     * Test the validity of the format of the date text field.
     * @param input the input string from the user
     * @return if the format is correct
     */
    public boolean validDate(String input)
    {
        String format = "(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[1-2])/(20[1-9][0-9])"; 
        return input.matches(format);
    }
}
