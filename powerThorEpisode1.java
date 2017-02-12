import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
 
 class Position {
    
    int m_X;
    int m_Y;
    
    Position(int p_X, int p_Y){
        this.m_X = p_X;
        this.m_Y = p_Y;
    }
    
    public void setPosition(int p_X, int p_Y){
        this.m_X = p_X;
        this.m_Y = p_Y;
    }
    
    public int getX(){
        return this.m_X;
    }
    
    public int getY(){
        return this.m_Y;
    }
    
    private  Boolean sameX(Position p_Start, Position p_Target){
        return p_Start.getX() == p_Target.getX();
    }
    
    private  Boolean sameY(Position p_Start, Position p_Target){
        return p_Start.getY() == p_Target.getY();
    }
    
    private  Boolean targetXsmallerThan(Position p_Start, Position p_Target){
        return p_Start.getX() > p_Target.getX();
    }
    
    private  Boolean targetYsmallerThan(Position p_Start, Position p_Target){
        return p_Start.getY() > p_Target.getY();
    }
    
    public String GoToward(Position p_Target){
        
        Boolean lTargetXsmallerThan = targetXsmallerThan(this, p_Target);
        Boolean lTargetYSmallerThan = targetYsmallerThan(this, p_Target);
        Boolean sameX = sameX(this, p_Target);
        Boolean sameY = sameY(this, p_Target);
        
        
        if ( sameX ){
            if ( lTargetYSmallerThan){
                this.m_Y -= 1;
                return "N";
            }else{
                this.m_Y += 1;
                return "S";
            }
        }
        
        
        if ( sameY ){
            if ( lTargetXsmallerThan ){
                this.m_X -= 1;
                return "W";
            }else{
                this.m_X += 1;
                return "E";
            }
        }
        
        if ( lTargetXsmallerThan && lTargetYSmallerThan ){
            this.m_X -= 1;
            this.m_Y -= 1;
            return "NW";
        } else if ( !lTargetXsmallerThan && !lTargetYSmallerThan ){
            this.m_X += 1;
            this.m_Y += 1;
            return "SE";
        } else if ( !lTargetXsmallerThan ){
            this.m_X += 1;
            this.m_Y -= 1;
            return "NE";
        }else{
            this.m_X -= 1;
            this.m_Y += 1;
            return "SW";
        }
            
     }
    
}


class Player {

     static void print(String p_Choice){
         // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(p_Choice);    
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        
        Position thor = new Position(initialTX, initialTY);
        Position light = new Position(lightX, lightY);
        

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            print(thor.GoToward(light));

           
        }
    }
}

