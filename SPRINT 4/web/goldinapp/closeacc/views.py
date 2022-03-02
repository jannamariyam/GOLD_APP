from django.shortcuts import render

from .mserializer import mserializer
from .models import Closereq
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView
import datetime

class mapiview1(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):
        obj=Closereq()
        obj.cus_id= request.data["uid"]
        obj.date = datetime.date.today()
        obj.pl_id =request.data["plan"]
        obj.status ="Requested"
        obj.save()
        return HttpResponse("Saved Successfully")
def closereq(request):
    # return HttpResponse("hello")
    objs=Closereq.objects.filter(status='Requested')
    #
    context={
        'val':objs,
    }

    return render(request,'closeacc/closeview.html',context)

from userplan.models import Userplan
def approve(request,idd):
    obj=Closereq.objects.get(clid=idd)
    obj.status="Accept"
    obj.save()
    obj1=Userplan.objects.get(plid=idd)
    obj1.plid=idd
    obj1.status="Closed"
    obj1.save()
    return closereq(request)