#!/usr/bin/python3

from sense_hat import SenseHat 
sense=SenseHat()


for i in range(0,8,1):
    for j in range(0,8,1):
        sense.set_pixel(i,j, (0,0,0))


for i in range(0,8,1):
    sense.set_pixel (i,7- i , (255,255,255))

sense.set_pixel(1,7, (255,255,255))
sense.set_pixel(2,7 , (255,255,255))
sense.set_pixel(0,6, (255,255,255))
sense.set_pixel(0,5, (255,255,255))
