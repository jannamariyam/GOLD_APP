from django.shortcuts import render

# Create your views here.
from .mserializer import mserializer
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView
from .models import Login
from login.models import Login

class mapiview(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):

        uname = request.data["un"]
        pwd=request.data["pwd"]
        objs=Login.objects.filter(uname=uname,pwd=pwd)
        if len(objs)>0:
            return HttpResponse("Successfull")
        else:
            return HttpResponse("User Details Not Found")




        # print(name)


        return HttpResponse("Successfull")