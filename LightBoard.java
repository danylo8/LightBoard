import java.util.ArrayList;

public class LightBoard
{
 /** The lights on the board, where true represents on and false represents off.
  */
 private boolean[][] lights;
 /** Constructs a LightBoard object having numRows rows and numCols columns.
  * Precondition: numRows > 0, numCols > 0
  * Postcondition: each light has a 40% probability of being set to on.
  */
 public LightBoard(int numRows, int numCols)
 {
  /* to be implemented in part (a) */
  lights = new boolean [numRows][numCols];
  for(int row = 0; row < lights.length; row++)
  {
   for (int col = 0; col < lights[0].length; col++)
   {
    double temp = Math.random();
    if(temp < 0.4)
    {
     lights[row][col] = true;
    }
   }
  }
 }
 /** Evaluates a light in row index row and column index col and returns a status
  * as described in part (b).
  * Precondition: row and col are valid indexes in lights.
  */
 public double test()
 {
  double on = 0;
  for(boolean[] row : lights)
  {
   for(boolean b : row)
   {
    if(b) on++;
   }
  }
  return on / (lights.length * lights[0].length);
 }

 public boolean evaluateLight(int row, int col)
 {
  boolean light = lights[row][col];
  if(light)
  {
   int temp1 = 0;
   for (int row1 = 0; row1 < lights.length; row1++)
   {
    if(lights[row1][col])
    {
     temp1++;
    }
   }
   if(light && temp1 % 2 == 0)
   {
    return false;
   }else{
    return light;
   }
  }else{
   int temp2 = 0;
   for (int row1 = 0; row1 < lights.length; row1++)
   {
    if(lights[row1][col])
    {
     temp2++;
    }
   }
   if(!light && temp2 % 3 == 0)
   {
    return (temp2 % 3 == 0);
   }else{
    return light;
   }
  }
  /* to be implemented in part (b) */
 }

 public void setLights(boolean[][] arr)
 {
  lights = arr;
 }
 // There may be additional instance variables, constructors, and methods not shown.
} 