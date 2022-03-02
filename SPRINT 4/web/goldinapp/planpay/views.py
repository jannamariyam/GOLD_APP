from django.shortcuts import render

from .mserializer import mserializer
from .models import PlanPay
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView

# Create your views here.

class mapiview1(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):

        uid= request.data["plid"]
        print(uid)
        s = PlanPay.objects.filter(plid=uid,status='Pending')
        ser=mserializer(s,many=True)
        return Response(ser.data)