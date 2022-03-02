from django.shortcuts import render

from .mserializer import mserializer
from .models import Userplan
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView
import datetime
from datetime import timedelta
from planpay.models import PlanPay

def pendingview(request):
    dat=datetime.date.today()
    objs=PlanPay.objects.filter(edate__lte=dat,status='Pending')
    context={
        'valu':objs,
    }
    return render(request,'userplan/duedetails.html',context)
from penentry.models import Penaltyentry
from django.http import HttpResponseRedirect
from account.models import Penalty
def senddue(request,idd):
    print(idd)
    obj2 = Penaltyentry()
    obj=PlanPay.objects.get(payid=idd)
    obj2.slno=obj.slno
    obj1=Userplan.objects.get(plid=obj.plid)
    obj2.uid=obj1.uid
    obj2.plan=obj1.plan
    obj2.amt=obj1.amt
    if obj2.plan=="Variable":
        vv=obj2.amt.split('-')

        amt=int(vv[0])
    else:
        amt=int(obj2.amt)
    obper=Penalty.objects.all()
    print(amt)
    print('haiii')
    per=1
    if(len(obper)>0):
        ppp=obper[0]
        per=ppp.penalty
    obj2.penalty=amt*(per/100)
    dat=datetime.date.today()
    obj2.date=dat
    obj2.plid=obj.plid
    obj2.save()
    return pendingview(request)

class mapiview1(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):
        obj=Userplan()
        obj.uid= request.data["uid"]
        obj.jdate = datetime.date.today()
        obj.plan=request.data["plan"]
        obj.payment=request.data["pay"]
        obj.amt = request.data["amt"]
        obj.nddate= datetime.date.today()
        obj.pcnt=1
        obj.status="Active"
        obj.save()
        if obj.payment=="Monthly":
            dt = datetime.date.today()
            for i in range(1, 13):
                pobj=PlanPay()
                m = i * 30
                dt1 = dt
                # print(dt1)
                dt = dt + timedelta(days=m)
                # print(dt)
                pobj.plan=obj.plan
                pobj.status='Pending'
                pobj.plid=obj.plid
                pobj.slno=i
                pobj.sdate=dt1
                pobj.edate=dt
                pobj.save()
        else:
            dt = datetime.date.today()
            for i in range(1, 49):
                pobj = PlanPay()
                m = i * 7
                dt1 = dt
                # print(dt1)
                dt = dt + timedelta(days=m)
                # print(dt)
                pobj.plan = obj.plan
                pobj.status = 'Pending'
                pobj.plid = obj.plid
                pobj.slno = i
                pobj.sdate = dt1
                pobj.edate = dt
                pobj.save()

        return HttpResponse("Saved Successfully")
        # objs=Userplan.objects.all()
        # ser = mserializer(objs, many=True)
        # return Response(ser.data)
class mapiview2(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):
        uid= request.data["uid"]
        s = Userplan.objects.filter(uid=uid,status='Active')
        ser=mserializer(s,many=True)
        return Response(ser.data)

