package pwo.group.app.gui;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Aleksandr Kovalyov
 */
public class GUITest {
    
    public static List<Component> getAllComponents(final Container c) {
    Component[] comps = c.getComponents();
    var compList = new ArrayList<Component>();
    for (Component comp : comps) {
      compList.add(comp);
      if (comp instanceof Container container) {
        compList.addAll(getAllComponents(container));
      }
    }
    return compList;
  }
    
    public GUITest() {
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

    /**
     * Test of main method, of class SelectFilesForm.
     */
    @Test
    public void SelectFilesFormComponentCount() {
        var form = new SelectFilesForm();
        assertEquals(2, getAllComponents(form).stream()
                .filter(control -> control.getClass() == javax.swing.JButton.class)
                .count());
        assertEquals(2, getAllComponents(form).stream()
                .filter(control -> control.getClass() == javax.swing.JLabel.class)
                .count());
    }
    
    @Test
    public void SelectFilesFormButtonWidthHeight() {
        var form = new SelectFilesForm();
        var button = (javax.swing.JButton) getAllComponents(form).stream()
                .filter(control -> control.getClass() == javax.swing.JButton.class)
                .findFirst()
                .get();
        
        assertEquals(27, button.getHeight());
        assertEquals(102, button.getWidth());
        assertEquals("select file 1", button.getText());
    }
    
    @Test
    public void CompareFilesFormComponentCount() {
        var form = new CompareFilesForm();
        assertEquals(1, getAllComponents(form).stream()
                .filter(control -> control.getClass() == javax.swing.JTable.class)
                .count());
    }
}
