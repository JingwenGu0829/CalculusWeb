import sympy as sp
import threading

def reciever(func,multi,deri,symbol):
    if multi==1: #multithread
        if deri==1:
            for i in func:
                k=threading.Thread(threadd,args=(i,symbol))
                k.start()

        if deri==0:
            for i in func:
                k=threading.Thread(threadi,args=(i,symbol))
                k.start()
    else:
        if deri==1:
            derivative(func,symbol)
        else:
            integration(func,symbol)

def derivative(func,symbol): #calculate the derivative of the given formula
    df=[]
    for i in func:
        df.append(sp.diff(i,symbol))
    return df

def integration(func,symbol): #calculate the integration of the given formula
    inte=[]
    for i in func:
        inte.append(sp.integrate(i,symbol))
    return inte

def threadd(func,symbol):
    return(sp.diff(func,symbol))

def threadi(func,symbol):
    return(sp.integrate(func,symbol))