#!/usr/bin/python3

from sense_hat import SenseHat 
sense=SenseHat()


for i in range(0,8,1):
    for j in range(0,8,1):
        sense.set_pixel(i,j, (0,0,0))


for i in range(0,8,1):
    sense.set_pixel (i, i , (255,255,255))

sense.set_pixel(7,6, (255,255,255))
sense.set_pixel(7,5 , (255,255,255))
sense.set_pixel(5,7, (255,255,255))
sense.set_pixel(6,7, (255,255,255))
