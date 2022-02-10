from django.shortcuts import render

# Create your views here.
from .mserializer import mserializer
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView
from .models import Customer
from login.models import Login

class mapiview(APIView):
    def get(self,request):
        s=Customer.objects.all()
        ser=mserializer(s,many=True)
        return Response(ser.data)
    def post(self,request):
        obj=Customer()
        obj.name = request.data["name"]
        obj.phone = request.data["phone"]
        obj.email = request.data["email"]
        obj.dob = request.data["dob"]
        obj.nominee = request.data["nomi"]
        obj.nph = request.data["nph"]
        obj.aadr = request.data["aad"]
        obj.pin = request.data["pin"]
        obj.dist = request.data["dist"]
        obj.acc = request.data["acc"]
        obj.jdate = request.data["jdat"]

        objl=Login()
        objl.uname = request.data["un"]
        objl.pwd=request.data["pwd"]
        objl.utype="customer"
        objl.save()

        obj.lid=objl.uid
        obj.save()



        # print(name)


        return HttpResponse("Successfull")