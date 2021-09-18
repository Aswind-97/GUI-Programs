#Anthony Lopez
#Simple Python GUI to use system camera to capture image 
#and display a GUI around it
#GUI Application Spring 2020


from tkinter import *
import tkinter as tk
import numpy as np
from PIL import ImageTk, Image, ImageDraw
import cv2
import socket
import json



# funtion for track btn
def TRACK():
    print("TRACKING!!!!")

#funtion for fire button
def FIRE():
    print("FIRING!!!!")

# Capture from camera
#parameter is id of the opened video, if a single camera is connected, pass 0
#can also be filename
# function for video streaming
def video_stream():
    ret, frame = cap.read()#return T/F if frame is read correctly
    newFrame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGBA)
    # ^^reads videocapture and recolors to more natural colors
    img = Image.fromarray(newFrame)#converts data to be viewable in PIL
    img = img.resize((800, 500), Image.ANTIALIAS)#resizes image (width, height)px
    imgForTk = ImageTk.PhotoImage(image=img)#then converts for tkinter format from PIL
    video_area.imgForTk = imgForTk#helps dispay image in the video area
    video_area.configure(image=imgForTk)#helps configure to display image
    video_area.after(1, video_stream)#Keeps video playing consistently every 1ms
    




'''
def reticle():
    _, frame = cap.read()
    cv2.line(frame,(0,0),(200,300),(255,255,255),50) #test code
    #reticle.coords(root, (100, 100)) # change coordinates #test code
img2 = cv2.line(frame,(0,0),(200,300),(255,255,255),50) #test code
cv2.imshow(video_area, img2)
'''




#Setting up the frame of the GUI
root = tk.Tk()
root.title("HAWK")


top_frame = tk.Frame(root)
top_frame.pack(side="top")

bottom_frame = tk.Frame(root)
bottom_frame.pack(side = "bottom")

video_area = Label(top_frame)
video_area.pack(side="top")
#Button section
track_btn = tk.Button(bottom_frame, text = "TRACK", width=15, height=2, borderwidth=50, command=TRACK)
track_btn.pack(side="left")

fire_btn = tk.Button(bottom_frame, text="FIRE", width=15, height=2, command=FIRE)
fire_btn.pack(side="left")

stop_btn = tk.Button(bottom_frame, text="STOP!", width=15, height=2, foreground = "red", command=root.destroy)
stop_btn.pack(side="left")

cap = cv2.VideoCapture(0)
video_stream()


root.mainloop()


#**************************************************************
    #End of main GUI program
#**************************************************************
cap.release()
cv2.destroyAllWindows()
