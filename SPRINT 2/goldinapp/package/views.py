from django.shortcuts import render
from package.models import Package
from scheme.models import Scheme
from django.http import HttpResponseRedirect
# Create your views here.
from package.models import Fixed,Variable

def packview(request):
    return render(request,"package/packages.html")

def fixamount(request):
    obs=Fixed.objects.all()
    if len(obs)>0:
        ob=obs[0]
        context={
            "one":ob.price1,
            "two": ob.price2,
            "three": ob.price3,
            "four": ob.price4,
            "five": ob.price5,
            "six": ob.price6,
        }
    else:
        context = {
            "one": "",
            "two": "",
            "three": "",
            "four": "",
            "five": "",
            "six": "",
        }
    if request.method=="POST":
        if len(obs) > 0:
            ob = obs[0]
        else:
            ob=Fixed()
        ob.price1=request.POST.get("one")
        ob.price2 = request.POST.get("two")
        ob.price3 = request.POST.get("three")
        ob.price4 = request.POST.get("four")
        ob.price5 = request.POST.get("five")
        ob.price6 = request.POST.get("six")
        ob.save()
        obs = Fixed.objects.all()
        if len(obs) > 0:
            ob = obs[0]
            context = {
                "one": ob.price1,
                "two": ob.price2,
                "three": ob.price3,
                "four": ob.price4,
                "five": ob.price5,
                "six": ob.price6,
            }



    return render(request,"package/fixed.html",context)

def varamount(request):
    obs=Variable.objects.all()
    if len(obs)>0:
        ob=obs[0]
        context={
            "one":ob.price1,
            "two": ob.price2,
            "three": ob.price3,
            "four": ob.price4,
            "five": ob.price5,
            "six": ob.price6,
        }
    else:
        context = {
            "one": "",
            "two": "",
            "three": "",
            "four": "",
            "five": "",
            "six": "",
        }
    if request.method=="POST":
        if len(obs) > 0:
            ob = obs[0]
        else:
            ob=Variable()
        ob.price1=request.POST.get("one")
        ob.price2 = request.POST.get("two")
        ob.price3 = request.POST.get("three")
        ob.price4 = request.POST.get("four")
        ob.price5 = request.POST.get("five")
        ob.price6 = request.POST.get("six")
        ob.save()
        obs = Variable.objects.all()
        if len(obs) > 0:
            ob = obs[0]
            context = {
                "one": ob.price1,
                "two": ob.price2,
                "three": ob.price3,
                "four": ob.price4,
                "five": ob.price5,
                "six": ob.price6,
            }



    return render(request,"package/variable.html",context)