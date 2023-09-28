import sympy as sp
import threading
import time

def reciever(func,multi,deri,symbol):
    if multi==1: #multithread
        if deri==1:
            for i in func:
                start=time.clock_gettime_ns()
                t=threading.Thread(target=multiderivative,args=(i,symbol))
                t.start()
                end=time.clock_gettime_ns
                print("The processing time for thread"+i+"is"+(end-start))
        else:
            for i in func:
                start=time.clock_gettime_ns()
                t=threading.Thread(target=multintegral,args=(i,symbol))
                t.start()
                end=time.clock_gettime_ns
                print("The processing time for thread"+i+"is"+(end-start))
           
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
        inte.append(sp.integrate(i.symbol))
    return inte

def multiderivative(func,symbol):
    return (sp.diff(func,symbol))

def multintegral(func,symbol):
    return (sp.integrate(func,symbol))