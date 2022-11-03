package pwo.group.app.filestats;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pwo.group.app.filestats.RegexMatchCountBased.*;

/**
 *
 * @author Aleksandr Kovalyov
 */
public class JavaTests {
    
    private String code = """
                          import java.awt.*;
                          import java.util.Random;
                          
                          public class Building 
                          {
                             private int width;
                             private int height; 
                             private int windows;
                             private Random generator;
                             
                           
                           
                             //-----------------------------------------------------------------
                             //  constructor
                             //-----------------------------------------------------------------
                             public Building (int buildWidth, int buildHeight)
                             {
                          	  generator = new Random();  
                          	  width = buildWidth;
                          	  height = buildHeight;	  
                             }
                          
                             //-----------------------------------------------------------------
                             //  setWidth()
                             //-----------------------------------------------------------------
                             public void setWidth (int sWidth)
                             {
                                width = sWidth;   
                             }
                             
                             //-----------------------------------------------------------------
                             //  getWidth()
                             //-----------------------------------------------------------------
                             public int getWidth() 
                             {
                                return width;  
                             }
                             
                             //-----------------------------------------------------------------
                             //  setHeight()
                             //-----------------------------------------------------------------
                             public void setHeight (int sHeight)
                             {
                                height = sHeight;   
                             }
                             
                             //-----------------------------------------------------------------
                             //  getHeight()
                             //-----------------------------------------------------------------
                             public int getHeight() 
                             {
                                return height;  
                             }  
                           
                             
                             //-----------------------------------------------------------------
                             //  getWindows()
                             //-----------------------------------------------------------------
                             public int getWindows() 
                             {
                                return windows;  
                             }  
                           
                             //-----------------------------------------------------------------
                             //  paints a building
                             //-----------------------------------------------------------------
                             public void draw (Graphics page, int leftedge)
                             {
                                
                                page.setColor (Color.black);
                                int bottom = 300 - height;
                                page.fillRect(leftedge, bottom, width, height);
                                
                                
                                int no_windows = generator.nextInt(20) + 1;
                                page.setColor (Color.white);
                                
                                for (int windowcount = 0; windowcount < no_windows; windowcount++)
                                { 
                              	 
                              	 int windowwidth = 4;
                              	 int windowheight = 4;
                              	 int x_coordinates;
                              	 int y_coordinates;
                              	 x_coordinates = generator.nextInt(width);
                              	 y_coordinates = generator.nextInt(height);
                              	 int x = leftedge + x_coordinates;
                              	 int y = bottom + y_coordinates;
                              	 page.setColor (Color.green);
                              	 page.fillRect(x, y, windowwidth, windowheight);
                              	  	   
                                }
                                
                             }
                          }
                          """;
    
    public JavaTests() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void ClassCount1() {
        assertEquals(1, new CodeFileClassCount(code).GetValue());
    }
    
    @Test
    public void MethodsCount3() {
        assertEquals(3, new CodeFileMethodsCount(code).GetValue());
    }
    
    @Test
    public void VariablesCount14() {
        assertEquals(14, new CodeFileVariablesCount(code).GetValue());
    }
}
