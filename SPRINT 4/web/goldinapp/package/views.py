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
from .mserializer import mserializer
from .mserializer1 import mserializer1
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView

class mapiview1(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):
        objs=Fixed.objects.all()
        ser = mserializer(objs, many=True)
        return Response(ser.data)


class mapiview2(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self, request):
        objs = Variable.objects.all()
        ser = mserializer1(objs, many=True)
        return Response(ser.data)