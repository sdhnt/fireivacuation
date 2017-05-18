#!/usr/bin/python3

from sense_hat import SenseHat 
sense=SenseHat()


for i in range(0,8,1):
    for j in range(0,8,1):
        sense.set_pixel(i,j, (0,0,0))


for i in range(0,8,1):
    sense.set_pixel (4, i , (255,255,255))

sense.set_pixel(3,6, (255,255,255))
sense.set_pixel(2,5 , (255,255,255))
sense.set_pixel(5,6, (255,255,255))
sense.set_pixel(6,5, (255,255,255))
