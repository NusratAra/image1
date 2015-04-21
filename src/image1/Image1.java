package image1;

import com.googlecode.javacv.CanvasFrame;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

public class Image1 {

    public static void main(String[] args) {

        //BGR to HSV
        //Image Smoothing / Filtering / Blur
//        IplImage img = cvLoadImage("r.jpg");
////      IplImage gray=IplImage.create(img.width(),img.height(), IPL_DEPTH_8U, 3);
////      cvCvtColor(img, gray, CV_BGR2HSV);
//        IplImage dst = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, img.nChannels());
//        cvSmooth(img, dst, CV_MEDIAN, 5);
//        CanvasFrame cv = new CanvasFrame("My Frame");
//        cv.setDefaultCloseOperation(CanvasFrame.EXIT_ON_CLOSE);
//        cv.showImage(dst);


        //Image Crop
        //prblm**********
        IplImage src = cvLoadImage("r.jpg");
        int upperLeftX = 100;
        int upperLeftY = 100;
        int downRightX = 200;
        int downRightY = 200;
        int width = downRightX - upperLeftX;
        int height = downRightY - upperLeftY;
        CvRect r = new CvRect(width, height, upperLeftX, upperLeftY);
        cvSetImageROI(src, r); //set region of interest
        //cvSetImageROI is before IplImage dst
        IplImage dst = cvCreateImage(cvGetSize(src), src.depth(), src.nChannels());
        cvCopy(src, dst);//Copy original image(only ROI) to dst
        cvResetImageROI(src); //reset ROI
        CanvasFrame canvas = new CanvasFrame("MyImage");
        canvas.setDefaultCloseOperation(CanvasFrame.EXIT_ON_CLOSE);
        canvas.showImage(dst);


    }
}
