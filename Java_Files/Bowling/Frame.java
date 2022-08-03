
/**
 * Represents a frame of a scorecard
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Frame
{
    private String box1;
    private String box2;
    private String box3; //only for the tenth frame
    private int total;
    private int frameNumber;
    
    /**
     * Default Frame = not tenth frame, no scores set
     * 
     * Total to calculated with method calculateTotal()
     */
    public Frame()
    {
        box1 = "";
        box2 = "";
        box3 = null;
        total = 0;
        frameNumber = 1;
    }
    
    /**
     * For non-tenth-frame frames
     * 
     * Total to calculated with method calculateTotal()
     */
    public Frame(String box1, String box2, int frameNumber)
    {
        this.box1 = box1;
        this.box2 = box2;
        box3 = null;
        total = 0;
        this.frameNumber = frameNumber;
    }
    
    /**
     * For the tenth frame
     * 
     * Total to calculated with method calculateTotal()
     */
    public Frame (String box1, String box2, String box3)
    {
        this.box1 = box1;
        this.box2 = box2;
        this.box3 = box3;
        total = 0;
        frameNumber = 10;
    }
    
    public String getBox1()
    {
    
    }
    
    public String getBox2()
    {
    
    }
    
    public String getBox3()
    {
    
    }
    
    /**
     * for frames 1-9
     */
    public void setBoxes(String box1, String box2)
    {
    
    }
    
    /**
     * for the tenth frame
     */
    public void setBoxes(String box1, String box2, String box3)
    {
    
    }
    
    /**
     * calculates the total of the frame
     */
    public int calculateTotal()
    {
    
    }
    
    /**
     * for use with spares and strikes
     */
    public void calculateTotal(int nextScore)
    {
    
    }
}
