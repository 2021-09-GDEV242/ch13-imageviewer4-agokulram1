
/**
 * Write a description of class FlippedWarholFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlippedWarholFilter extends Filter
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class RedFilter.
     * @param name The name of the filter.
     */
    public FlippedWarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int pixel, alpha, red, green, blue, avgRGB;
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                 pixel = image.getRGB(x,y);
                 alpha = (pixel>>24)&0xff;
                 red = (pixel>>16)&0xff;
                 green = (pixel>>8)&0xff;
                 blue = pixel&0xff;
                 avgRGB = (red+green+blue)/3;
                 pixel = (alpha<<24) | (255 << 16) | (avgRGB << 8) |avgRGB;
                 image.setRGB(x, y, pixel);
                
            }
        }
    }
}

