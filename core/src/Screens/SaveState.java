package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.wallegameone.IG;

public class SaveState
{
    IG thisGame;
    int[] abilityArray;
    int transCount = 0;
    String save1 = "key1";
    Preferences prefs;
    public SaveState(IG game,int[] arr)
    {
        thisGame = game;
        //Initialize with array of 0's
        abilityArray = new int[arr.length];
        for(int i = 0; i<arr.length; i++)
        {
            abilityArray[i] = 0;
        }
        //Initialize with array of 0's
        prefs = Gdx.app.getPreferences("myprefs");


    }
    public void transfer(int[] a)
    {
        for(int i = 0; i<a.length; i++)
        {
            abilityArray[i] = a[i];
        }
        transCount++;
    }
    public int[] getAbilityArray()
    {
        /**
        if(transCount <=0) {
            return abilityArray;
        }
         **/
        transfer(toArray(prefs.getString("key1"),StringCount(prefs.getString("key1"))));
        return abilityArray;
    }
    public String getSaveArr()
    {
        return prefs.getString("key1");
    }
    public int setAbilityArray(int[] arr)
    {
        transfer(arr);
        return transCount;
    }
    public void saveArr()
    {
        String saveState = abilityArray.toString();
        System.out.println("" + saveState);
        //if(transCount>0)
        //{
            //Here we will save the array
            prefs.putString("key1", saveState);
            prefs.flush();
       // }
        //Otherwise do nothing, as the array is the same;
    }
    /**
     * int val = prefs.getInteger("key");
     *
     * //Do something with your value and put it back to the preference
     * val+=something;
     * prefs.putInteger("key", val);
     *
     * //This will finally save the changes to storage
     * prefs.flush();
     */
    public int[] toArray(String a,int length)
    {
        String b = "," +  a;
        int[] arr = new int[length];
        for(int i = 0; i<arr.length; i++)
        {
            int comPos = b.indexOf(",");
            if(i!=0) {
                arr[i] = Integer.parseInt(b.charAt(comPos + 1) + "");
            }
            else
            {
                arr[i] = Integer.parseInt(b.charAt(comPos + 2) + "");
            }
            b = b.substring(0,comPos) + b.substring(comPos + 1);
        }
        return arr;
    }
    public int getTransCount()
    {
        return transCount;
    }
    public int StringCount(String a)
    {
        int counter = 0;
        for(int i = 0; i<a.length(); i++)
        {
            if(a.charAt(i) != ',')
            {
                counter++;
            }
        }
        return counter;
    }
}
