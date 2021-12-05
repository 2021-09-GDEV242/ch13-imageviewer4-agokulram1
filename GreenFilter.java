
/**
 * Write a description of class GreenFilter here.
 *
 * @author Gokul Ram
 * @version 12.3.21
 */
public class GreenFilter extends Filter
{
    /**
     * Constructor for objects of class GreenFilter.
     * @param name The name of the filter.
     */
    public GreenFilter(String name)
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
                 if ((green >= 200) && (green <= 255))
                    green = 255;
                 else
                    green = avgRGB;
                 pixel = (alpha<<24) | (avgRGB << 16) | (green << 8) | avgRGB;
                 image.setRGB(x, y, pixel);
                
            }
        }
    }
}
