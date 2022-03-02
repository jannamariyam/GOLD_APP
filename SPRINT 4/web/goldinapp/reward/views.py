from django.shortcuts import render
from .models import Reward
from django.http import HttpResponse,HttpResponseRedirect
# Create your views here.
def post_reward(request):

    objs=Reward.objects.filter(rwid=1)
    month=""
    year=""
    if(len(objs)>0):
        oo=objs[0]
        month=oo.month
        year=oo.year

    context={
        'mnth':month,
        'year':year
    }
    if request.method=="POST":
        obj=Reward()
        obj.rwid=1
        obj.month= request.POST.get('month')
        obj.year=request.POST.get('year')
        obj.save()
        # return view_reward(request)
        # return HttpResponseRedirect('/reward/view_re/')
    return render(request,'reward/rewardentry.html',context)
def view_reward(request):
    objs = Reward.objects.all()
    context = {
        'abc': objs,
    }
    return render(request, 'reward/viewreward.html', context)

def del_reward(request,idd):
    obj=Reward.objects.get(rwid=idd)
    obj.delete()
    return view_reward(request)

def update(request,idd):
    objs = Reward.objects.filter(rwid=idd)
    context = {
        'abc': objs,
    }
    if request.method=="POST":
        obj=Reward.objects.get(rwid=idd)
        obj.rduration = request.POST.get('duration')
        obj.type = request.POST.get('type')
        obj.plan = request.POST.get('plan')
        obj.rper = request.POST.get('per')
        obj.save()
    return render(request,'reward/update.html',context)

from .mserializer import mserializer
from userplan.models import Userplan
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
        objs=Reward.objects.all()
        reward="No Reward Details Found"
        if(len(objs)>0):
            obj=objs[0]
            reward="After 6 months"+ str(obj.month) +" After One Year " + str(obj.year)



        # plid =request.data["plan"]
        # obj=Userplan.objects.get(plid=plid,status='Active')
        # doj=obj.jdate
        # # print(type(doj))
        # cdate=datetime.date.today()
        # # from datetime import date
        # # print(type(cdate))
        #
        # delta = cdate - doj
        # days=delta.days
        # mnth=0
        # if days>=730:
        #     mnth=24
        # elif days>=365:
        #     mnth=12
        # obj=Reward.objects.filter(rduration=mnth,plan=obj.amt)
        # reward="not"
        # if len(obj)>0:
        #     reward=obj[0].rper
        return HttpResponse(reward)