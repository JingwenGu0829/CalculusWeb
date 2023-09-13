import sympy as sp

def reciever(func,multi,deri,symbol):
    if multi==1: #multithread
        pass
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
