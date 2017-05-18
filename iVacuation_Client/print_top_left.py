#!/usr/bin/python3

from sense_hat import SenseHat 
sense=SenseHat()


for i in range(0,8,1):
    for j in range(0,8,1):
        sense.set_pixel(i,j, (0,0,0))


for i in range(0,8,1):
    sense.set_pixel (i, i , (255,255,255))

sense.set_pixel(0,1, (255,255,255))
sense.set_pixel(0,2 , (255,255,255))
sense.set_pixel(1,0, (255,255,255))
sense.set_pixel(2,0, (255,255,255))
