
/**
 * Write a description of class BlueFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueFilter extends Filter
{
   
    /**
     * Constructor for objects of class BlueFilter.
     * @param name The name of the filter.
     */
    public BlueFilter(String name)
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
                 if ((blue >= 200) && (blue <= 255))
                    blue = 255;
                 else
                    blue = avgRGB;
                 pixel = (alpha<<24) | (avgRGB << 16) | (avgRGB << 8) |(blue << 0);
                 image.setRGB(x, y, pixel);
                
            }
        }
    }
}
