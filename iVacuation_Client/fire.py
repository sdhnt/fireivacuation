#!/usr/bin/python3
import requests

from sense_hat import SenseHat 
count = 10
sense=SenseHat()

api_key = "ERFYPSGPGER05WM3"
temperature = sense.get_temperature()
data={"api_key": api_key, "field4": temperature }
req = requests.post("https://api.thingspeak.com/update", data=data)
print(str(round(temperature,2)));
