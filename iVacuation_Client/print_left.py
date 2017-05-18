#!/usr/bin/python3

from sense_hat import SenseHat 
sense=SenseHat()


for i in range(0,8,1):
    for j in range(0,8,1):
        sense.set_pixel(i,j, (0,0,0))


for i in range(0,8,1):
    sense.set_pixel (i, 4 , (255,255,255))

sense.set_pixel(1,3, (255,255,255))
sense.set_pixel(2,2 , (255,255,255))
sense.set_pixel(1,5, (255,255,255))
sense.set_pixel(2,6, (255,255,255))
