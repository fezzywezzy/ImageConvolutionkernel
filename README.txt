READEME.txt file for Image Convolution project, George Stavrou G00398295

This project will be opened via the Runner class.
It will then initiate a menu as follows:

1) Enter Image Name
2) Select a Filter
3) Or create a filter
4) Apply your selected filter
5) Invert or Flip Image
6) Quit

By entering the relevant number, each option will initiate the written command.

1) When entering an image name, the user will have to enter the file directory with the image name, for example:

C:\Users\John\Pictures\pictureIwantConvoluted.png

The program will request it to be a .png file.

2) This will display the premade filters, 
0 IDENTITY
1 EDGE_DETECTION_1
2 EDGE_DETECTION_2
3 LAPLACIAN
4 SHARPEN
5 VERTICAL_LINES
6 HORIZONTAL_LINES
7 DIAGONAL_45_LINES
8 BOX_BLUR
9 SOBEL_HORIZONTAL
10 SOBEL_VERTICAL

When a user selects it by a number, it will display the filter as a 3d matrix as well.

3) This option lets the user create a filter. It will first ask the dimension, and if it is appropriate, 
subsequently the user can enter each individual digit of matrix they want. It will print the user made kernel.

4) This will apply whatever filter was selected, or created, depending on what was more recent. 
The output will be labelled 'output.png' in the project folder.

5) This is a small addition, simply giving the user to flip the input image vertically or horizontally.
The new image will be named 'horizontalInvertedOutput.png' or 'verticalInvertedOutput.png'.
