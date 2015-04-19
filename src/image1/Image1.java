package image1;

import com.googlecode.javacv.CanvasFrame;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

public class Image1 {

    public static void main(String[] args) {
        
        //BGR to HSV
        IplImage img = cvLoadImage("r.jpg");
        IplImage gray = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 3);
        cvCvtColor(img, gray, CV_BGR2HSV);
        CanvasFrame cv = new CanvasFrame("My Frame");
        cv.setDefaultCloseOperation(CanvasFrame.EXIT_ON_CLOSE);
        cv.showImage(gray);
    }
}
