import javax.swing.*;
import java.text.NumberFormat;
import java.awt.*;

public class NumberTextField extends JFormattedTextField
{
    private NumberFormat format;
    public NumberTextField(int size)
    {
        super(NumberFormat.getNumberInstance());
        this.setPreferredSize(new Dimension(size, size));
    }
}
