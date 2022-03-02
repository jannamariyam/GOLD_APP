from django.shortcuts import render

from .serializer import mserializer
from .models import Penaltyentry
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
        uid= request.data["uid"]
        print(uid)
        s = Penaltyentry.objects.filter(uid=uid)
        ser=mserializer(s,many=True)
        return Response(ser.data)